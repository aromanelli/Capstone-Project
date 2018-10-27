
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewPostDataPreview {

    @SerializedName("images")
    @Expose
    private List<NewPostDataPreviewImage> newPostDataPreviewImages = new ArrayList<>();
    @SerializedName("enabled")
    @Expose
    private boolean enabled;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewPostDataPreview() {
    }

    /**
     * 
     * @param enabled
     * @param newPostDataPreviewImages
     */
    public NewPostDataPreview(List<NewPostDataPreviewImage> newPostDataPreviewImages, boolean enabled) {
        super();
        this.newPostDataPreviewImages = newPostDataPreviewImages;
        this.enabled = enabled;
    }

    public List<NewPostDataPreviewImage> getNewPostDataPreviewImages() {
        return newPostDataPreviewImages;
    }

    public void setNewPostDataPreviewImages(List<NewPostDataPreviewImage> newPostDataPreviewImages) {
        this.newPostDataPreviewImages = newPostDataPreviewImages;
    }

    public NewPostDataPreview withNewPostDataPreviewImages(List<NewPostDataPreviewImage> newPostDataPreviewImages) {
        this.newPostDataPreviewImages = newPostDataPreviewImages;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public NewPostDataPreview withEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

}
