package info.romanelli.udacity.capstone.reddit.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

@Entity(tableName = "new_posts")
public class NewPostEntity {

    @PrimaryKey
    @NonNull
    private String id = new Date().toString();

    // From New Posts 'subreddit_name_prefixed'
    @ColumnInfo(name = "subreddit_name_prefixed")
    @NonNull
    private String subreddit_pre = "TBD";

    // From New Posts
    @ColumnInfo(name = "subreddit_name")
    @NonNull
    private String subreddit = "TBD";

    // From Subreddits 'icon_img'
    @ColumnInfo(name = "subreddit_icon")
    private String subreddit_icon;

    // From New Posts
    @ColumnInfo(name = "created")
    private long created;

    // From New Posts
    @ColumnInfo(name = "author")
    @NonNull
    private String author = "TBD";

    // From New Posts
    @ColumnInfo(name = "title")
    @NonNull
    private String title = "TBD";

    // From New Posts
    @ColumnInfo(name = "text")
    private String text; // selftext_html;

    // From New Posts
    @ColumnInfo(name = "url")
    private String url;

    ////////////////////////////////////////////////////////////////


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getSubreddit_pre() {
        return subreddit_pre;
    }

    public void setSubreddit_pre(@NonNull String subreddit_pre) {
        this.subreddit_pre = subreddit_pre;
    }

    @NonNull
    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(@NonNull String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSubreddit_icon() {
        return subreddit_icon;
    }

    public void setSubreddit_icon(String subreddit_icon) {
        this.subreddit_icon = subreddit_icon;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@NonNull String author) {
        this.author = author;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewPostEntity newPostEntity = (NewPostEntity) o;
        return Objects.equals(getId(), newPostEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "NewPostEntity{" +
                "id='" + id + '\'' +
                ", subreddit_pre='" + subreddit_pre + '\'' +
                ", subreddit='" + subreddit + '\'' +
                ", subreddit_icon='" + subreddit_icon + '\'' +
                ", created=" + created +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
