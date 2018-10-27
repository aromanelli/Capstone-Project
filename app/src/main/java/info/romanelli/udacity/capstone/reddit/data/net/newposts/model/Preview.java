
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Preview {

    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("enabled")
    @Expose
    private boolean enabled;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Preview() {
    }

    /**
     * 
     * @param enabled
     * @param images
     */
    public Preview(List<Image> images, boolean enabled) {
        super();
        this.images = images;
        this.enabled = enabled;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Preview withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Preview withEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

}
