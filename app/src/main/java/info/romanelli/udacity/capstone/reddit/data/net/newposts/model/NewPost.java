
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPost {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private NewPostData newPostData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewPost() {
    }

    /**
     * 
     * @param newPostData
     * @param kind
     */
    public NewPost(String kind, NewPostData newPostData) {
        super();
        this.kind = kind;
        this.newPostData = newPostData;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public NewPost withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public NewPostData getNewPostData() {
        return newPostData;
    }

    public void setNewPostData(NewPostData newPostData) {
        this.newPostData = newPostData;
    }

    public NewPost withNewPostData(NewPostData newPostData) {
        this.newPostData = newPostData;
        return this;
    }

}
