
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPostDataGildings {

    @SerializedName("gid_1")
    @Expose
    private int gid1;
    @SerializedName("gid_2")
    @Expose
    private int gid2;
    @SerializedName("gid_3")
    @Expose
    private int gid3;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewPostDataGildings() {
    }

    /**
     * 
     * @param gid1
     * @param gid3
     * @param gid2
     */
    public NewPostDataGildings(int gid1, int gid2, int gid3) {
        super();
        this.gid1 = gid1;
        this.gid2 = gid2;
        this.gid3 = gid3;
    }

    public int getGid1() {
        return gid1;
    }

    public void setGid1(int gid1) {
        this.gid1 = gid1;
    }

    public NewPostDataGildings withGid1(int gid1) {
        this.gid1 = gid1;
        return this;
    }

    public int getGid2() {
        return gid2;
    }

    public void setGid2(int gid2) {
        this.gid2 = gid2;
    }

    public NewPostDataGildings withGid2(int gid2) {
        this.gid2 = gid2;
        return this;
    }

    public int getGid3() {
        return gid3;
    }

    public void setGid3(int gid3) {
        this.gid3 = gid3;
    }

    public NewPostDataGildings withGid3(int gid3) {
        this.gid3 = gid3;
        return this;
    }

}
