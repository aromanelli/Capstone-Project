package info.romanelli.udacity.capstone.net.reddit;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

abstract public class AbstractRedditFetcher {

    final static public String URL_BASE = "https://www.reddit.com";

    final static public Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(
                    GsonConverterFactory.create(
                            new GsonBuilder()
                                    .setLenient()
//                                    .registerTypeAdapter(
//                                            Subreddits.class,
//                                            (JsonDeserializer<Subreddits>) (json, typeOfT, context) -> {
//                                                return new Subreddits();
//                                            }
//                                    )
                                    .create()
                    )
            )
            .client(
                new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
            )
            .build();

}
