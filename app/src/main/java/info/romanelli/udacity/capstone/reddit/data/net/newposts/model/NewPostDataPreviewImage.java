
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewPostDataPreviewImage {

    @SerializedName("source")
    @Expose
    private NewPostDataPreviewImageSource newPostDataPreviewImageSource;
    @SerializedName("resolutions")
    @Expose
    private List<NewPostDataPreviewImageResolution> newPostDataPreviewImageResolutions = new ArrayList<>();
    @SerializedName("variants")
    @Expose
    private NewPostDataPreviewImageVariants newPostDataPreviewImageVariants;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewPostDataPreviewImage() {
    }

    /**
     * 
     * @param id
     * @param newPostDataPreviewImageSource
     * @param newPostDataPreviewImageVariants
     * @param newPostDataPreviewImageResolutions
     */
    public NewPostDataPreviewImage(NewPostDataPreviewImageSource newPostDataPreviewImageSource, List<NewPostDataPreviewImageResolution> newPostDataPreviewImageResolutions, NewPostDataPreviewImageVariants newPostDataPreviewImageVariants, String id) {
        super();
        this.newPostDataPreviewImageSource = newPostDataPreviewImageSource;
        this.newPostDataPreviewImageResolutions = newPostDataPreviewImageResolutions;
        this.newPostDataPreviewImageVariants = newPostDataPreviewImageVariants;
        this.id = id;
    }

    public NewPostDataPreviewImageSource getNewPostDataPreviewImageSource() {
        return newPostDataPreviewImageSource;
    }

    public void setNewPostDataPreviewImageSource(NewPostDataPreviewImageSource newPostDataPreviewImageSource) {
        this.newPostDataPreviewImageSource = newPostDataPreviewImageSource;
    }

    public NewPostDataPreviewImage withNewPostDataPreviewImageSource(NewPostDataPreviewImageSource newPostDataPreviewImageSource) {
        this.newPostDataPreviewImageSource = newPostDataPreviewImageSource;
        return this;
    }

    public List<NewPostDataPreviewImageResolution> getNewPostDataPreviewImageResolutions() {
        return newPostDataPreviewImageResolutions;
    }

    public void setNewPostDataPreviewImageResolutions(List<NewPostDataPreviewImageResolution> newPostDataPreviewImageResolutions) {
        this.newPostDataPreviewImageResolutions = newPostDataPreviewImageResolutions;
    }

    public NewPostDataPreviewImage withNewPostDataPreviewImageResolutions(List<NewPostDataPreviewImageResolution> newPostDataPreviewImageResolutions) {
        this.newPostDataPreviewImageResolutions = newPostDataPreviewImageResolutions;
        return this;
    }

    public NewPostDataPreviewImageVariants getNewPostDataPreviewImageVariants() {
        return newPostDataPreviewImageVariants;
    }

    public void setNewPostDataPreviewImageVariants(NewPostDataPreviewImageVariants newPostDataPreviewImageVariants) {
        this.newPostDataPreviewImageVariants = newPostDataPreviewImageVariants;
    }

    public NewPostDataPreviewImage withNewPostDataPreviewImageVariants(NewPostDataPreviewImageVariants newPostDataPreviewImageVariants) {
        this.newPostDataPreviewImageVariants = newPostDataPreviewImageVariants;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NewPostDataPreviewImage withId(String id) {
        this.id = id;
        return this;
    }

}
