package info.romanelli.udacity.capstone.net.reddit.subreddits;

import android.support.annotation.NonNull;

import info.romanelli.udacity.capstone.net.NetUtil;
import info.romanelli.udacity.capstone.net.reddit.AbstractRedditFetcher;
import info.romanelli.udacity.capstone.net.reddit.subreddits.model.Subreddits;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class SubredditsFetcher extends AbstractRedditFetcher {

    static public void fetchSubscribed(final SubredditsFetcher.Listener listener) {

        if (NetUtil.isConnected()) {

            Call<Subreddits> call =
                    RETROFIT.create(SubredditsFetcher.Service.class)
                        .fetch(100);

            call.enqueue(new Callback<Subreddits>() {
                @Override
                public void onResponse(
                        @NonNull Call<Subreddits> call,
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
                public void onFailure(
                        @NonNull Call<Subreddits> call,
                        @NonNull Throwable t) {
                    listener.failed(t);
                }
            });

        }

    }

    interface Service {
        @GET("subreddits/mine/subscriber.json")
        Call<Subreddits> fetch(
                @Query("limit")
                int limit
        );
    }

    public interface Listener {
        void fetched(final Subreddits subbreddits);
        void failed(final Throwable t);
    }

}
