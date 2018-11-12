package info.romanelli.udacity.capstone.reddit.data.net;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

abstract public class AbstractRedditFetcher {

    public static final String URL_BASE = "https://oauth.reddit.com"; // 'oauth' NOT 'www' !

    public static final Retrofit RETROFIT = new Retrofit.Builder()
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
//            .client( FOR LOGGING OF OKHTTP
//                new OkHttpClient.Builder().addInterceptor(
//                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//                ).build()
//            )
            .build();


    public static String getHeaderAuthorization(final String authToken) {
        // To embed token statically in header via Interceptor: https://stackoverflow.com/a/51793569/435519
        return "bearer " + authToken;
    }
}
