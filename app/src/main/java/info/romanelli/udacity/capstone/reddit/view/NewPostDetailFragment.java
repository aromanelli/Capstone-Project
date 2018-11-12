package info.romanelli.udacity.capstone.reddit.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Activity activity = this.getActivity();
        Assert.that(activity != null);

        final View rootView;
        CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            rootView = inflater.inflate(R.layout.newpost_detail, container, false);
        } else {
            rootView = inflater.inflate(R.layout.newpost_detail_twopane, container, false);
        }

        // Show the dummy content as text in a TextView.
        if (mItem != null) {

            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getTitle());
            }

            final ImageView ivSubreddit = rootView.findViewById(R.id.ivSubreddit);
            if (ivSubreddit != null) {
                NewPostsListActivity.NewPostsListRecyclerViewAdapter.setImageViewViaGlide(
                        activity, mItem.getSubreddit_icon(), ivSubreddit);
            }

            final TextView tvSubreddit = rootView.findViewById(R.id.tvSubreddit);
            if (tvSubreddit != null) {
                tvSubreddit.setText(mItem.getSubreddit_pre());
            }

            final TextView tvPoster = rootView.findViewById(R.id.tvPoster);
            if (tvPoster != null) {
                tvPoster.setText(mItem.getAuthor());
            }

            final TextView tvPostTitle = rootView.findViewById(R.id.tvPostTitle);
            if (tvPostTitle != null) {
                tvPostTitle.setText(mItem.getTitle());
            }

            FloatingActionButton fab_details = rootView.findViewById(R.id.fab_details);
            if (fab_details != null) {
                fab_details.setOnClickListener(view -> {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(mItem.getUrl()));
                    startActivity(i);
                });
            }

            // And now the new post text body (exists in both xml file versions) ...
            ((TextView) rootView.findViewById(R.id.newpost_detail_text)).setText(mItem.getText());
        }

        return rootView;
    }
}
