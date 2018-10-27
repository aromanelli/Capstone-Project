
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Image {

    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("resolutions")
    @Expose
    private List<Resolution> resolutions = new ArrayList<Resolution>();
    @SerializedName("variants")
    @Expose
    private Variants variants;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param id
     * @param source
     * @param variants
     * @param resolutions
     */
    public Image(Source source, List<Resolution> resolutions, Variants variants, String id) {
        super();
        this.source = source;
        this.resolutions = resolutions;
        this.variants = variants;
        this.id = id;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Image withSource(Source source) {
        this.source = source;
        return this;
    }

    public List<Resolution> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    public Image withResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
        return this;
    }

    public Variants getVariants() {
        return variants;
    }

    public void setVariants(Variants variants) {
        this.variants = variants;
    }

    public Image withVariants(Variants variants) {
        this.variants = variants;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image withId(String id) {
        this.id = id;
        return this;
    }

}
