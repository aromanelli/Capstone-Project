package info.romanelli.udacity.capstone.reddit.data.net.newposts;

import android.content.Context;

import androidx.annotation.NonNull;

import info.romanelli.udacity.capstone.reddit.data.net.AbstractRedditFetcher;
import info.romanelli.udacity.capstone.reddit.data.net.newposts.model.NewPosts;
import info.romanelli.udacity.capstone.reddit.data.net.oauth.RedditAuthManager;
import info.romanelli.udacity.capstone.util.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class NewPostsFetcher extends AbstractRedditFetcher {

    public static void fetchNewPosts(final String subreddit,
                                     final Context context,
                                     final NewPostsFetcher.Listener listener) {

        if (NetUtil.isConnected()) {

            RedditAuthManager.performActionWithFreshTokens(
                    context.getApplicationContext(), (accessToken, idToken, ae) -> {

                if (ae == null) {

                    Call<NewPosts> call =
                            RETROFIT.create(NewPostsFetcher.Service.class)
                                    .fetch(
                                            getHeaderAuthorization(accessToken),
                                            subreddit,
                                            "all",
                                            10
                                    );

                    call.enqueue(new Callback<NewPosts>() {
                        @Override
                        public void onResponse(@NonNull Call<NewPosts> call,
                                               @NonNull retrofit2.Response<NewPosts> response) {
                            if (response.body() != null) {
                                //noinspection ConstantConditions
                                final NewPosts newposts = response.body();
                                listener.fetched(newposts);
                            } else {
                                listener.fetched(null);
                            }
                        }
                        @Override
                        public void onFailure(@NonNull Call<NewPosts> call,
                                              @NonNull Throwable t) {
                            listener.failed(t);
                        }
                    });

                } else {
                    // Could not refresh token ...
                    listener.failed(ae);
                }
            });

        }

    }

    interface Service {
        @GET("r/{subreddit}/new.json")
        Call<NewPosts> fetch(
                @Header("Authorization") String auth,
                @Path("subreddit") String subreddit,
                @Query("show") String show,
                @Query("limit") int limit
        );
    }

    public interface Listener {
        void fetched(final NewPosts newposts);
        void failed(final Throwable t);
    }

}
