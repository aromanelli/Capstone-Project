package info.romanelli.udacity.capstone.net.reddit.subreddits;

import android.content.Context;
import android.support.annotation.NonNull;

import info.romanelli.udacity.capstone.net.reddit.AbstractRedditFetcher;
import info.romanelli.udacity.capstone.net.reddit.oauth.RedditAuthManager;
import info.romanelli.udacity.capstone.net.reddit.subreddits.model.Subreddits;
import info.romanelli.udacity.capstone.net.reddit.util.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public class SubredditsFetcher extends AbstractRedditFetcher {

    static public void fetchSubscribed(final Context context,
                                       final SubredditsFetcher.Listener listener) {

        if (NetUtil.isConnected()) {

            RedditAuthManager.performActionWithFreshTokens(
                    context.getApplicationContext(), (accessToken, idToken, ae) -> {

                if (ae == null) {

                    Call<Subreddits> call =
                            RETROFIT.create(SubredditsFetcher.Service.class)
                                    .fetch(getHeaderAuthorization(accessToken), 100);

                    call.enqueue(new Callback<Subreddits>() {
                        @Override
                        public void onResponse(@NonNull Call<Subreddits> call,
                                               @NonNull retrofit2.Response<Subreddits> response) {
                            if (response.body() != null) {
                                //noinspection ConstantConditions
                                final Subreddits subreddits = response.body();
                                listener.fetched(subreddits);
                            } else {
                                listener.fetched(null);
                            }
                        }
                        @Override
                        public void onFailure(@NonNull Call<Subreddits> call,
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
        @GET("subreddits/mine/subscriber.json")
        Call<Subreddits> fetch(
                @Header("Authorization") String auth,
                @Query("limit") int limit
        );
    }

    public interface Listener {
        void fetched(final Subreddits subbreddits);
        void failed(final Throwable t);
    }

}
