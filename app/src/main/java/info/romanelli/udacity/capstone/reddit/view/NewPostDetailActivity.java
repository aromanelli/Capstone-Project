package info.romanelli.udacity.capstone.reddit.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import info.romanelli.udacity.capstone.R;
import info.romanelli.udacity.capstone.reddit.data.DataRepository;
import info.romanelli.udacity.capstone.reddit.data.db.NewPostEntity;
import info.romanelli.udacity.capstone.util.Assert;

import static info.romanelli.udacity.capstone.reddit.view.NewPostDetailFragment.ARG_ITEM_ID;

/**
 * An activity representing a single NewPost detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link NewPostsListActivity}.
 */
public class NewPostDetailActivity extends AppCompatActivity {

    public static final String TAG = NewPostDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost_detail);
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        String idNewPostEntity = getIntent().getStringExtra(ARG_ITEM_ID);
        Assert.that(idNewPostEntity != null);
        Assert.that(idNewPostEntity.trim().length() >= 1);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Log.d(TAG, "onCreate: idNewPostEntity: " + idNewPostEntity);
            NewPostEntity npe = DataRepository.$(this).getNewPostEntity(idNewPostEntity);
            final Uri uriNewPost = Uri.parse(npe.getUrl());
            Log.d(TAG, "onCreate: uriNewPost: " + uriNewPost);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(uriNewPost);
            startActivity(i);
        } );

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ARG_ITEM_ID, idNewPostEntity);
            NewPostDetailFragment fragment = new NewPostDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.newpost_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            // navigateUpTo(new Intent(this, NewPostsListActivity.class));
            // NavUtils.navigateUpFromSameTask(this);
            super.onBackPressed(); // We don't want to call parent Activities create method
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
