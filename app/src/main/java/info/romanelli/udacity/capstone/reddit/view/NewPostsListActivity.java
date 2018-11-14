package info.romanelli.udacity.capstone.reddit.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import info.romanelli.udacity.capstone.R;
import info.romanelli.udacity.capstone.reddit.data.DataRepository;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.reddit.data.net.RedditDataService;
import info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager;
import info.romanelli.udacity.capstone.util.AppExecutors;
import info.romanelli.udacity.capstone.util.AppUtil;
import info.romanelli.udacity.capstone.util.Assert;
import info.romanelli.udacity.capstone.util.FirebaseAnalyticsManager;

import static info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager.RC_AUTH;

/**
 * An activity representing a list of NewPosts. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link NewPostDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class NewPostsListActivity extends AppCompatActivity {

    private static final String TAG = NewPostsListActivity.class.getSimpleName();

    /**
     * Whether or not the activity is in two-pane mode,
     * i.e. running on a tablet device.
     */
    private boolean mTwoPane;

    private NewPostsViewModel mNewPostsViewModel;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;

    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newposts_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        mFloatingActionButton = findViewById(R.id.fab_refresh);
        mFloatingActionButton.setOnClickListener(view -> refresh(true));

        // This is added for Firebase Crashlytics testing purposes only ...
        FirebaseAnalyticsManager.$(this).addCrashButton(this);

        if (findViewById(R.id.newpost_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).  If this view
            // is present, then the activity should be in two-pane mode.
            mTwoPane = true;
        }

        mNewPostsViewModel = ViewModelProviders.of(this).get(NewPostsViewModel.class);

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(() -> refresh(true));

        mRecyclerView = findViewById(R.id.newpost_list);
        Assert.that(mRecyclerView != null);
        setupRecyclerView(mRecyclerView);

        DataRepository.$(this).getNewPosts().observe(this, newPostEntities -> {
            NewPostsListRecyclerViewAdapter adapter = (NewPostsListRecyclerViewAdapter) mRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.setNewPosts(newPostEntities);
            } else {
                throw new IllegalStateException("Expected a non-null adapter reference!");
            }
        });

        // Check if Reddit authorized.  If not, notify user and launch web browser ...
        if (!RedditAuthManager.isAuthorized(this)) {
            // Notify the user that they will need to authorize this app ...
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle(getString(R.string.auth_perform_req_title));
            adb.setMessage(getString(R.string.auth_perform_req_text));
            adb.setPositiveButton(
                    getString(R.string.authorize),
                    (dialog, idBtn) -> {
                        RedditAuthManager.performAuthRequest(this, RC_AUTH);
                        dialog.dismiss();
                    }
            );
            adb.setNegativeButton(
                    getString(R.string.exit),
                    (dialog, idBtn) -> {
                        dialog.dismiss();
                        finish();
                        System.exit(-1);
                    }
            );
            adb.show();
        } else {
            // App is authorized, so populate the database with data from Reddit ...
            Log.d(TAG, "onCreate: Authorized");
            // Only populate db on start and auth'd, not on rotation ...
            if (savedInstanceState == null) {
                refresh(false);
            }
        }

        // If we wanted to do something with the subreddit selected on the large widget view ...
        // String infoSubreddit = getIntent().getStringExtra(RedditInfoWidgetProvider.EXTRA_INFO_SUBREDDIT);
        // Log.d(TAG, "onCreate: infoSubreddit: " + infoSubreddit);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(
                receiverRedditDataService,
                new IntentFilter(RedditDataService.KEY_NOTIFICATION)
        );

        int indexVisiblePos = mNewPostsViewModel.getIndexVisiblePos();
        if (indexVisiblePos >= 0) {
            mRecyclerView.getLayoutManager().scrollToPosition(indexVisiblePos);
        }

        showUI(!mNewPostsViewModel.isRefreshing());
    }
    @Override
    protected void onPause() {
        unregisterReceiver(receiverRedditDataService);

        int indexVisiblePos =
                ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        mNewPostsViewModel.setIndexVisiblePos(indexVisiblePos);

        super.onPause();
    }

    @Override
    protected void onStop() {
        // Fix for user backing out of main activity while a refresh is in progress.
        // This will force a new refresh when the app/activity is restarted by the user.
        mNewPostsViewModel.setIsRefreshing(false);

        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == RC_AUTH) {
            AuthorizationResponse resp = AuthorizationResponse.fromIntent(intent);
            AuthorizationException excp = AuthorizationException.fromIntent(intent);
            // Uri uriRedirect = getIntent().getData();
            RedditAuthManager.performTokenRequest(
                    this,
                    resp,
                    excp,
                    (accessToken, idToken, ex) -> {
                        if (ex != null) {
                            Log.e(TAG, "onActivityResult.performTokenRequest: ex", ex);

                            FirebaseAnalyticsManager.$(NewPostsListActivity.this)
                                    .logEventRedditAuthEnded(false);

                            // Notify the user that they will need to authorize this app ...
                            AlertDialog.Builder adb = new AlertDialog.Builder(this);
                            adb.setTitle(getString(R.string.auth_fail_req_title));
                            String errExtra = ex.errorDescription;
                            if (ex.errorDescription == null) {
                                errExtra = ex.error;
                                if (errExtra == null) {
                                    errExtra = "";
                                }
                            }
                            errExtra += " ["+ ex.code +"]";
                            adb.setMessage(
                                    getString(R.string.auth_fail_req_text) + errExtra
                            );
                            adb.setPositiveButton(
                                    getString(R.string.exit),
                                    (dialog, idBtn) -> {
                                        dialog.dismiss();
                                        finish();
                                        System.exit(-1);
                                    }
                            );
                            adb.show();
                        } else {
                            FirebaseAnalyticsManager.$(NewPostsListActivity.this)
                                    .logEventRedditAuthEnded(true);
                            refresh(true);
                        }
                    }
            );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_newpost_list, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // menu.getItem(0).setEnabled(!mNewPostsViewModel.isRefreshing());
        menu.findItem(R.id.action_refresh).setEnabled(!mNewPostsViewModel.isRefreshing());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                refresh(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void refresh(boolean force) {
        Log.d(TAG, "refresh() called with: force = [" + force + "] (["+ mNewPostsViewModel.isRefreshing() +"])");
        if (!mNewPostsViewModel.isRefreshing()) {
            showUI( false );
            Snackbar.make(mRecyclerView, getString(R.string.fetching_data), Snackbar.LENGTH_SHORT).show();
            DataRepository.$(this).populateDatabase(this, force);
        }
    }

    private BroadcastReceiver receiverRedditDataService = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive() called with: context = [" + context + "], intent = [" + intent + "], thread = [" + Thread.currentThread() + "]");

            if (RedditDataService.KEY_NOTIFICATION.equals(intent.getAction())) {

                Bundle bundle = intent.getExtras();
                if (bundle != null) {

                    int canceled = bundle.getInt(RedditDataService.KEY_RESULT_CANCELLED, Integer.MIN_VALUE);
                    int fetched = bundle.getInt(RedditDataService.KEY_RESULT_FETCHED, Integer.MIN_VALUE);
                    Serializable throwable = bundle.getSerializable(RedditDataService.KEY_RESULT_FAILED);

                    if (throwable instanceof Throwable) {
                        Log.e(TAG, "onReceive: ", (Throwable) throwable);
                        AlertDialog.Builder adb = new AlertDialog.Builder(NewPostsListActivity.this); // NOT appContext !
                        adb.setTitle(getString(R.string.fetch_error_title));
                        adb.setMessage(getString(R.string.fetch_error_text));
                        adb.setPositiveButton(
                                getString(R.string.close),
                                (dialog, idBtn) -> {
                                    dialog.dismiss();
                                    showUI(true);
                                }
                        );
                        adb.show();
                    } else if (fetched == Activity.RESULT_OK) {
                        Snackbar.make(
                                mRecyclerView,
                                getString(R.string.fetching_data_completed),
                                Snackbar.LENGTH_LONG
                        ).show();
                        showUI(true);
                    } else if (canceled == Activity.RESULT_CANCELED) {
                        Snackbar.make(
                                mRecyclerView,
                                getString(R.string.fetching_data_cancelled),
                                Snackbar.LENGTH_LONG
                        ).show();
                        showUI(true);
                    }

                }

            }
        }
    };

    private void showUI(final boolean visible) {
        Log.d(TAG, "showUI() called with: visible = [" + visible + "] (["+ mNewPostsViewModel.isRefreshing() +"])");
        mNewPostsViewModel.setIsRefreshing(!visible);
        AppExecutors.$().mainUI().execute(() -> {

            mSwipeRefreshLayout.setRefreshing(mNewPostsViewModel.isRefreshing());
            // (The 'Refresh' menu view is handled in the onPrepareOptionsMenu(Menu) method!)
            if (visible) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mFloatingActionButton.show();
            } else {
                mRecyclerView.setVisibility(View.INVISIBLE);
                mFloatingActionButton.hide();
            }

            final View detail_container = findViewById(R.id.newpost_detail_container);
            // Handle show/hiding the new post text when in tablet mode ...
            if (detail_container != null) {
                if (visible) {
                    detail_container.setVisibility(View.VISIBLE);
                } else {
                    detail_container.setVisibility(View.INVISIBLE);
                }
            }

        });
    }

    private void setupRecyclerView(@NonNull RecyclerView mRecyclerView) {
        // .setLayoutManager done in xml
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(
                new NewPostsListRecyclerViewAdapter(
                        this,
                        DataRepository.$(this).getNewPosts().getValue(),
                        mTwoPane
                )
        );
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(
                        this,
                        DividerItemDecoration.VERTICAL
                )
        );
    }

    public static class NewPostsListRecyclerViewAdapter
            extends RecyclerView.Adapter<NewPostsListRecyclerViewAdapter.ViewHolder> {

        private final NewPostsListActivity mParentActivity;
        private final List<NewPostEntity> mValues = new ArrayList<>(0);
        private final boolean mTwoPane;

        NewPostsListRecyclerViewAdapter(NewPostsListActivity parent,
                                      List<NewPostEntity> newPosts,
                                      boolean twoPane) {
            mParentActivity = parent;
            setNewPosts(newPosts);
            mTwoPane = twoPane;
        }

        void setNewPosts(List<NewPostEntity> newPosts) {
            mValues.clear();
            if (newPosts != null) {
                mValues.addAll(newPosts);
            }
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.newpost_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

            String url = mValues.get(position).getSubreddit_icon();
            AppUtil.setImageViewViaGlide(mParentActivity, url, holder.ivSubreddit, url);

            holder.tvSubreddit.setText(mValues.get(position).getSubreddit_pre());
            holder.tvPoster.setText(mValues.get(position).getAuthor());
            holder.tvPostTitle.setText(mValues.get(position).getTitle());

            holder.itemView.setTag(mValues.get(position));
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            final ImageView ivSubreddit;
            final TextView tvSubreddit;
            final TextView tvPoster;
            final TextView tvPostTitle;

            ViewHolder(View view) {
                super(view);

                ivSubreddit = view.findViewById(R.id.ivSubreddit);
                tvSubreddit = view.findViewById(R.id.tvSubreddit);
                tvPoster = view.findViewById(R.id.tvPoster);
                tvPostTitle = view.findViewById(R.id.tvPostTitle);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                NewPostEntity item = (NewPostEntity) view.getTag();

                FirebaseAnalyticsManager.$(mParentActivity).logEventViewNewPost(item);

                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(NewPostDetailFragment.ARG_ITEM_ID, item.getId());
                    NewPostDetailFragment fragment = new NewPostDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.newpost_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, NewPostDetailActivity.class);
                    intent.putExtra(NewPostDetailFragment.ARG_ITEM_ID, item.getId());

                    // Start detail activity with a transition ...
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(
                            mParentActivity,
                            ivSubreddit,
                            // Set in NewPostDetailActivity ...
                            ViewCompat.getTransitionName(ivSubreddit)
                    ).toBundle();
                    context.startActivity(intent, bundle);
                }
            }

        }

    }

}
