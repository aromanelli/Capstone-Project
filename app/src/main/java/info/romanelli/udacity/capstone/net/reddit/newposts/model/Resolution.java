
package info.romanelli.udacity.capstone.net.reddit.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resolution {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Resolution() {
    }

    /**
     * 
     * @param height
     * @param width
     * @param url
     */
    public Resolution(String url, int width, int height) {
        super();
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Resolution withUrl(String url) {
        this.url = url;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Resolution withWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Resolution withHeight(int height) {
        this.height = height;
        return this;
    }

}
