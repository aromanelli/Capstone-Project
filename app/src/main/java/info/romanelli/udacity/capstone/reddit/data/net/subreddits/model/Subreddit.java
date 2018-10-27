package info.romanelli.udacity.capstone.reddit.data.net.subreddits.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subreddit {

    /*
    Subreddits
        SubredditsData
            Subreddit
                SubredditData
     */

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("data")
    @Expose
    private SubredditData data;

    /**
     * No args constructor for use in serialization
     *
     */
    public Subreddit() {
    }

    /**
     *
     * @param data
     * @param kind
     */
    public Subreddit(String kind, SubredditData data) {
        super();
        this.kind = kind;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Subreddit withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public SubredditData getData() {
        return data;
    }

    public void setData(SubredditData data) {
        this.data = data;
    }

    public Subreddit withData(SubredditData data) {
        this.data = data;
        return this;
    }

}