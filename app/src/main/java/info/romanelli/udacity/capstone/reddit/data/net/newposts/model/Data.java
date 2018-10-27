
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("modhash")
    @Expose
    private String modhash;
    @SerializedName("dist")
    @Expose
    private int dist;
    @SerializedName("children")
    @Expose
    private List<Child> children = new ArrayList<Child>();
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
    public Data() {
    }

    /**
     * 
     * @param after
     * @param before
     * @param children
     * @param modhash
     * @param dist
     */
    public Data(String modhash, int dist, List<Child> children, String after, Object before) {
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

    public Data withModhash(String modhash) {
        this.modhash = modhash;
        return this;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Data withDist(int dist) {
        this.dist = dist;
        return this;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Data withChildren(List<Child> children) {
        this.children = children;
        return this;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public Data withAfter(String after) {
        this.after = after;
        return this;
    }

    public Object getBefore() {
        return before;
    }

    public void setBefore(Object before) {
        this.before = before;
    }

    public Data withBefore(Object before) {
        this.before = before;
        return this;
    }

}
