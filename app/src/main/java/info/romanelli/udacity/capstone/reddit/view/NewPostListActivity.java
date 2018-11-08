package info.romanelli.udacity.capstone.reddit.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;

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
import info.romanelli.udacity.capstone.util.Assert;

import static info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager.RC_AUTH;

/**
 * An activity representing a list of NewPosts. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link NewPostDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class NewPostListActivity extends AppCompatActivity {

    final static private String TAG = NewPostListActivity.class.getSimpleName();

    /**
     * Whether or not the activity is in two-pane mode,
     * i.e. running on a tablet device.
     */
    private boolean mTwoPane;

    private NewPostsViewModel mNewPostsViewModel;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> refresh(fab));

        if (findViewById(R.id.newpost_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).  If this view
            // is present, then the activity should be in two-pane mode.
            mTwoPane = true;
        }

        mNewPostsViewModel = ViewModelProviders.of(this).get(NewPostsViewModel.class);

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(() -> refresh(fab));

        recyclerView = findViewById(R.id.newpost_list);
        Assert.that(recyclerView != null);
        setupRecyclerView(recyclerView);

        mNewPostsViewModel.getNewPosts().observe(this, newPostEntities -> {
            NewPostsListRecyclerViewAdapter adapter = (NewPostsListRecyclerViewAdapter) recyclerView.getAdapter();
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
            // Only populate db on start and auth'd, not on rotation ...
            if (savedInstanceState == null) {
                // App is authorized, so populate the database with data from Reddit ...
                Log.d(TAG, "onCreate: Authorized");
                populateDatabase(false);
            }
        }

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
                            populateDatabase(true);
                        }
                    }
            );
        }
    }

    private void refresh(final View view) {
        Snackbar.make(view, getString(R.string.fetching_data), Snackbar.LENGTH_LONG).show();
        populateDatabase(true);
    }

    private void populateDatabase(boolean force) {
        showInfo(false);
        DataRepository.$(this).populateDatabase(this, force);
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
                        AlertDialog.Builder adb = new AlertDialog.Builder(NewPostListActivity.this); // NOT appContext !
                        adb.setTitle(getString(R.string.fetch_error_title));
                        adb.setMessage(getString(R.string.fetch_error_text));
                        adb.setPositiveButton(
                                getString(R.string.close),
                                (dialog, idBtn) -> {
                                    dialog.dismiss();
                                    showInfo(true);
                                }
                        );
                        adb.show();
                    } else if (fetched == Activity.RESULT_OK) {
                        Snackbar.make(
                                recyclerView,
                                getString(R.string.fetching_data_completed),
                                Snackbar.LENGTH_LONG
                        ).show();
                        showInfo(true);
                    } else if (canceled == Activity.RESULT_CANCELED) {
                        showInfo(true);
                    }

                }

            }
        }
    };

    private void showInfo(final boolean visible) {
        AppExecutors.$().mainUI().execute(() -> {
            mSwipeRefreshLayout.setRefreshing(!visible);
            int show = (!visible) ? View.INVISIBLE : View.VISIBLE;
            recyclerView.setVisibility(show);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiverRedditDataService, new IntentFilter(RedditDataService.KEY_NOTIFICATION));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiverRedditDataService);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        // .setLayoutManager done in xml
        recyclerView.setAdapter(
                new NewPostsListRecyclerViewAdapter(
                        this,
                        mNewPostsViewModel.getNewPosts().getValue(),
                        mTwoPane
                )
        );
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        this,
                        DividerItemDecoration.VERTICAL
                )
        );
    }

    public static class NewPostsListRecyclerViewAdapter
            extends RecyclerView.Adapter<NewPostsListRecyclerViewAdapter.ViewHolder> {

        private final NewPostListActivity mParentActivity;
        private final List<NewPostEntity> mValues = new ArrayList<>(0);
        private final boolean mTwoPane;

        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewPostEntity item = (NewPostEntity) view.getTag();
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

                    context.startActivity(intent);
                }
            }
        };

        NewPostsListRecyclerViewAdapter(NewPostListActivity parent,
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

            Object loadTarget;
            String url = mValues.get(position).getSubreddit_icon();
            if (url == null || url.trim().length() <= 0) {
                loadTarget = R.drawable.ic_reddit_default;
            } else {
                loadTarget = Uri.parse( mValues.get(position).getSubreddit_icon() );
            }
            // https://bumptech.github.io/glide/doc/getting-started.html#listview-and-recyclerview
            Glide.with(mParentActivity)
                    .load(loadTarget)
                    .apply(new RequestOptions()
                            .centerInside()
                            .priority(Priority.HIGH)
                            .placeholder(R.drawable.ic_reddit_default)
                            .error(R.drawable.ic_reddit_default)
                    )
                    .into(holder.ivSubreddit);

            holder.tvSubreddit.setText(mValues.get(position).getSubreddit_pre());
            holder.tvPoster.setText(mValues.get(position).getAuthor());
            holder.tvPostTitle.setText(mValues.get(position).getTitle());

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
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
            }
        }

    }

}
