
package info.romanelli.udacity.capstone.net.reddit.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPosts {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewPosts() {
    }

    /**
     * 
     * @param data
     * @param kind
     */
    public NewPosts(String kind, Data data) {
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

    public NewPosts withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public NewPosts withData(Data data) {
        this.data = data;
        return this;
    }

}
