package info.romanelli.udacity.capstone.reddit.data.net.subreddits.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubredditsData {

    /*
    Subreddits
        SubredditsData
            Subreddit
                SubredditData
     */

    @SerializedName("modhash")
    @Expose
    private String modhash;

    @SerializedName("dist")
    @Expose
    private int dist;

    @SerializedName("children")
    @Expose
    private List<Subreddit> subreddits = null;

    @SerializedName("after")
    @Expose
    private String after;

    @SerializedName("before")
    @Expose
    private Object before;

    /**
     * No args constructor for use in serialization
     *
     */
    public SubredditsData() {
    }

    /**
     *
     * @param after
     * @param before
     * @param subreddits
     * @param modhash
     * @param dist
     */
    public SubredditsData(String modhash, int dist, List<Subreddit> subreddits, String after, Object before) {
        super();
        this.modhash = modhash;
        this.dist = dist;
        this.subreddits = subreddits;
        this.after = after;
        this.before = before;
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public SubredditsData withModhash(String modhash) {
        this.modhash = modhash;
        return this;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public SubredditsData withDist(int dist) {
        this.dist = dist;
        return this;
    }

    public List<Subreddit> getSubreddits() {
        return subreddits;
    }

    public void setSubreddits(List<Subreddit> subreddits) {
        this.subreddits = subreddits;
    }

    public SubredditsData withChildren(List<Subreddit> subreddits) {
        this.subreddits = subreddits;
        return this;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public SubredditsData withAfter(String after) {
        this.after = after;
        return this;
    }

    public Object getBefore() {
        return before;
    }

    public void setBefore(Object before) {
        this.before = before;
    }

    public SubredditsData withBefore(Object before) {
        this.before = before;
        return this;
    }

}