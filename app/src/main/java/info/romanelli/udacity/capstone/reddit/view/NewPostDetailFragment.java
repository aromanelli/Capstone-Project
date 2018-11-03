package info.romanelli.udacity.capstone.reddit.view;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Optional;

import info.romanelli.udacity.capstone.R;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.util.Assert;

/**
 * A fragment representing a single NewPost detail screen.
 * This fragment is either contained in a {@link NewPostListActivity}
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

    private NewPostsViewModel mNewPostsViewModel;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NewPostDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNewPostsViewModel = ViewModelProviders.of(this).get(NewPostsViewModel.class);

        Assert.that(getArguments() != null);
        if (getArguments().containsKey(ARG_ITEM_ID)) {

            mItem = null;
            final String idToFind = getArguments().getString(ARG_ITEM_ID);
            List<NewPostEntity> list = mNewPostsViewModel.getNewPosts().getValue();
            Assert.that(list != null);
            Optional<NewPostEntity> result =
                    list.stream().filter(newPostEntity ->
                            idToFind.equals(newPostEntity.getId())).findFirst();
            result.ifPresent(newPostEntity -> mItem = newPostEntity);
            Assert.that(mItem != null);

            Activity activity = this.getActivity();
            Assert.that(activity != null);

            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            Assert.that(appBarLayout != null);
            appBarLayout.setTitle(mItem.getTitle());

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.newpost_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.newpost_detail)).setText(mItem.getText());
        }

        return rootView;
    }
}
