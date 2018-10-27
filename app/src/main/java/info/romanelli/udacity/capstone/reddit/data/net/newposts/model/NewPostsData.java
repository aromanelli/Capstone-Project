
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewPostsData {

    @SerializedName("modhash")
    @Expose
    private String modhash;
    @SerializedName("dist")
    @Expose
    private int dist;
    @SerializedName("children")
    @Expose
    private List<NewPost> children = new ArrayList<>();
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
    public NewPostsData() {
    }

    /**
     * 
     * @param after
     * @param before
     * @param children
     * @param modhash
     * @param dist
     */
    public NewPostsData(String modhash, int dist, List<NewPost> children, String after, Object before) {
        super();
        this.modhash = modhash;
        this.dist = dist;
        this.children = children;
        this.after = after;
        this.before = before;
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public NewPostsData withModhash(String modhash) {
        this.modhash = modhash;
        return this;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public NewPostsData withDist(int dist) {
        this.dist = dist;
        return this;
    }

    public List<NewPost> getNewPosts() {
        return children;
    }

    public void setNewPosts(List<NewPost> children) {
        this.children = children;
    }

    public NewPostsData withNewPosts(List<NewPost> children) {
        this.children = children;
        return this;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public NewPostsData withAfter(String after) {
        this.after = after;
        return this;
    }

    public Object getBefore() {
        return before;
    }

    public void setBefore(Object before) {
        this.before = before;
    }

    public NewPostsData withBefore(Object before) {
        this.before = before;
        return this;
    }

}
