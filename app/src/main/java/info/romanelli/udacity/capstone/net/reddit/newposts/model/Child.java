
package info.romanelli.udacity.capstone.net.reddit.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private Data_ data;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Child() {
    }

    /**
     * 
     * @param data
     * @param kind
     */
    public Child(String kind, Data_ data) {
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

    public Child withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public Data_ getData() {
        return data;
    }

    public void setData(Data_ data) {
        this.data = data;
    }

    public Child withData(Data_ data) {
        this.data = data;
        return this;
    }

}
