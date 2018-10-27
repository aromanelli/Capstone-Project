
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPosts {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private NewPostsData newPostsData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewPosts() {
    }

    /**
     * 
     * @param newPostsData
     * @param kind
     */
    public NewPosts(String kind, NewPostsData newPostsData) {
        super();
        this.kind = kind;
        this.newPostsData = newPostsData;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public NewPosts withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public NewPostsData getNewPostsData() {
        return newPostsData;
    }

    public void setNewPostsData(NewPostsData newPostsData) {
        this.newPostsData = newPostsData;
    }

    public NewPosts withData(NewPostsData newPostsData) {
        this.newPostsData = newPostsData;
        return this;
    }

}
