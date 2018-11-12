package info.romanelli.udacity.capstone.reddit.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;

import info.romanelli.udacity.capstone.R;
import info.romanelli.udacity.capstone.reddit.data.DataRepository;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.util.Assert;

/**
 * A fragment representing a single NewPost detail screen.
 * This fragment is either contained in a {@link NewPostsListActivity}
 * in two-pane mode (on tablets) or a {@link NewPostDetailActivity}
 * on handsets.
 */
public class NewPostDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private NewPostEntity mItem;

    public static final String ARG_FLAG_TWOPANE = "flag_twopane";
    private boolean mTwoPane;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NewPostDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Assert.that(getArguments() != null);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = DataRepository.$(getActivity()).getNewPostEntity(getArguments().getString(ARG_ITEM_ID));
        }

        mTwoPane = getArguments().containsKey(ARG_FLAG_TWOPANE);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.newpost_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {

            Activity activity = this.getActivity();
            Assert.that(activity != null);

            // Handle the header items first ....

            final ImageView ivSubreddit = rootView.findViewById(R.id.ivSubreddit);
            final TextView tvSubreddit = rootView.findViewById(R.id.tvSubreddit);
            final TextView tvPoster = rootView.findViewById(R.id.tvPoster);
            final TextView tvPostTitle = rootView.findViewById(R.id.tvPostTitle);

            if (mTwoPane) {
                NewPostsListActivity.NewPostsListRecyclerViewAdapter.setImageViewViaGlide(
                        activity, mItem.getSubreddit_icon(), ivSubreddit);
                tvSubreddit.setText(mItem.getSubreddit_pre());
                tvPoster.setText(mItem.getAuthor());
                tvPostTitle.setText(mItem.getTitle());
            } else {

                CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
                appBarLayout.setTitle(mItem.getTitle());

                ivSubreddit.setVisibility(View.GONE);
                tvSubreddit.setVisibility(View.GONE);
                tvPoster.setVisibility(View.GONE);
                tvPostTitle.setVisibility(View.GONE);
            }

            // And now the new post text body ...
            ((TextView) rootView.findViewById(R.id.newpost_detail_text)).setText(mItem.getText());
        }

        return rootView;
    }
}
