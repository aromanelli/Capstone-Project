package info.romanelli.udacity.capstone.util;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import info.romanelli.udacity.capstone.R;

public class AppUtil {

    public static void setImageViewViaGlide(final FragmentActivity activity,
                                            final String url,
                                            final ImageView iv,
                                            final String transitionName) {
        Object loadTarget;
        if (url == null || url.trim().length() <= 0) {
            loadTarget = R.drawable.ic_reddit_default;
        } else {
            loadTarget = Uri.parse( url );
        }

        if (transitionName != null) {
            // Set the URL for the movie poster to the ImageView showing the poster ...
            iv.setTransitionName(transitionName);
        }

        // https://bumptech.github.io/glide/doc/getting-started.html#listview-and-recyclerview
        Glide.with(activity)
                .load(loadTarget)
                .apply(new RequestOptions()
                        .centerInside()
                        .priority(Priority.HIGH)
                        .placeholder(R.drawable.ic_reddit_default)
                        .error(R.drawable.ic_reddit_default)
                )
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e,
                                                Object model,
                                                Target<Drawable> target,
                                                boolean isFirstResource) {
                        // Start up previously postpone transition to detail activity
                        activity.supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource,
                                                   Object model,
                                                   Target<Drawable> target,
                                                   DataSource dataSource,
                                                   boolean isFirstResource) {
                        // Start up previously postpone transition to detail activity
                        activity.supportStartPostponedEnterTransition();
                        return false;
                    }
                })
                .into(iv);

    }

}
