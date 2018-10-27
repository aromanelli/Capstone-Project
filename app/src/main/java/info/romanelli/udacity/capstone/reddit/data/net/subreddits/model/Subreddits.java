package info.romanelli.udacity.capstone.reddit.data.net.subreddits.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subreddits {

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
    private SubredditsData data;

    /**
     * No args constructor for use in serialization
     *
     */
    public Subreddits() {
    }

    /**
     *
     * @param data
     * @param kind
     */
    public Subreddits(String kind, SubredditsData data) {
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

    public Subreddits withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public SubredditsData getData() {
        return data;
    }

    public void setData(SubredditsData data) {
        this.data = data;
    }

    public Subreddits withData(SubredditsData data) {
        this.data = data;
        return this;
    }

}