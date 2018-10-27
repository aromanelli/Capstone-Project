
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewPostData {

    @SerializedName("approved_at_utc")
    @Expose
    private Object approvedAtUtc;
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("selftext")
    @Expose
    private String selftext;
    @SerializedName("author_fullname")
    @Expose
    private String authorFullname;
    @SerializedName("saved")
    @Expose
    private boolean saved;
    @SerializedName("mod_reason_title")
    @Expose
    private Object modReasonTitle;
    @SerializedName("gilded")
    @Expose
    private int gilded;
    @SerializedName("clicked")
    @Expose
    private boolean clicked;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link_flair_richtext")
    @Expose
    private List<Object> linkFlairRichtext = new ArrayList<>();
    @SerializedName("subreddit_name_prefixed")
    @Expose
    private String subredditNamePrefixed;
    @SerializedName("hidden")
    @Expose
    private boolean hidden;
    @SerializedName("pwls")
    @Expose
    private int pwls;
    @SerializedName("link_flair_css_class")
    @Expose
    private Object linkFlairCssClass;
    @SerializedName("downs")
    @Expose
    private int downs;
    @SerializedName("thumbnail_height")
    @Expose
    private Object thumbnailHeight;
    @SerializedName("hide_score")
    @Expose
    private boolean hideScore;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("quarantine")
    @Expose
    private boolean quarantine;
    @SerializedName("link_flair_text_color")
    @Expose
    private String linkFlairTextColor;
    @SerializedName("author_flair_background_color")
    @Expose
    private Object authorFlairBackgroundColor;
    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;
    @SerializedName("ups")
    @Expose
    private int ups;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("media_embed")
    @Expose
    private NewPostDataMediaEmbed newPostDataMediaEmbed;
    @SerializedName("thumbnail_width")
    @Expose
    private Object thumbnailWidth;
    @SerializedName("author_flair_template_id")
    @Expose
    private Object authorFlairTemplateId;
    @SerializedName("is_original_content")
    @Expose
    private boolean isOriginalContent;
    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = new ArrayList<>();
    @SerializedName("secure_media")
    @Expose
    private Object secureMedia;
    @SerializedName("is_reddit_media_domain")
    @Expose
    private boolean isRedditMediaDomain;
    @SerializedName("is_meta")
    @Expose
    private boolean isMeta;
    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("secure_media_embed")
    @Expose
    private NewPostDataSecureMediaEmbed newPostDataSecureMediaEmbed;
    @SerializedName("link_flair_text")
    @Expose
    private Object linkFlairText;
    @SerializedName("can_mod_post")
    @Expose
    private boolean canModPost;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    /////////////////////////
    @SerializedName("edited")
    @Expose
    private Object edited; // Can be either boolean or double !
    /////////////////////////
    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @SerializedName("author_flair_richtext")
    @Expose
    private List<Object> authorFlairRichtext = new ArrayList<>();
    @SerializedName("gildings")
    @Expose
    private NewPostDataGildings newPostDataGildings;
    @SerializedName("post_hint")
    @Expose
    private String postHint;
    @SerializedName("content_categories")
    @Expose
    private Object contentCategories;
    @SerializedName("is_self")
    @Expose
    private boolean isSelf;
    @SerializedName("mod_note")
    @Expose
    private Object modNote;
    @SerializedName("created")
    @Expose
    private double created;
    @SerializedName("link_flair_type")
    @Expose
    private String linkFlairType;
    @SerializedName("wls")
    @Expose
    private int wls;
    @SerializedName("banned_by")
    @Expose
    private Object bannedBy;
    @SerializedName("author_flair_type")
    @Expose
    private String authorFlairType;
    @SerializedName("contest_mode")
    @Expose
    private boolean contestMode;
    @SerializedName("selftext_html")
    @Expose
    private String selftextHtml;
    @SerializedName("likes")
    @Expose
    private Object likes;
    @SerializedName("suggested_sort")
    @Expose
    private Object suggestedSort;
    @SerializedName("banned_at_utc")
    @Expose
    private Object bannedAtUtc;
    @SerializedName("view_count")
    @Expose
    private Object viewCount;
    @SerializedName("archived")
    @Expose
    private boolean archived;
    @SerializedName("no_follow")
    @Expose
    private boolean noFollow;
    @SerializedName("is_crosspostable")
    @Expose
    private boolean isCrosspostable;
    @SerializedName("pinned")
    @Expose
    private boolean pinned;
    @SerializedName("over_18")
    @Expose
    private boolean over18;
    @SerializedName("preview")
    @Expose
    private NewPostDataPreview newPostDataPreview;
    @SerializedName("media_only")
    @Expose
    private boolean mediaOnly;
    @SerializedName("link_flair_template_id")
    @Expose
    private Object linkFlairTemplateId;
    @SerializedName("can_gild")
    @Expose
    private boolean canGild;
    @SerializedName("spoiler")
    @Expose
    private boolean spoiler;
    @SerializedName("locked")
    @Expose
    private boolean locked;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @SerializedName("visited")
    @Expose
    private boolean visited;
    @SerializedName("num_reports")
    @Expose
    private Object numReports;
    @SerializedName("distinguished")
    @Expose
    private Object distinguished;
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @SerializedName("mod_reason_by")
    @Expose
    private Object modReasonBy;
    @SerializedName("removal_reason")
    @Expose
    private Object removalReason;
    @SerializedName("link_flair_background_color")
    @Expose
    private String linkFlairBackgroundColor;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_robot_indexable")
    @Expose
    private boolean isRobotIndexable;
    @SerializedName("report_reasons")
    @Expose
    private Object reportReasons;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("num_crossposts")
    @Expose
    private int numCrossposts;
    @SerializedName("num_comments")
    @Expose
    private int numComments;
    @SerializedName("send_replies")
    @Expose
    private boolean sendReplies;
    @SerializedName("whitelist_status")
    @Expose
    private String whitelistStatus;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = new ArrayList<>();
    @SerializedName("author_patreon_flair")
    @Expose
    private boolean authorPatreonFlair;
    @SerializedName("author_flair_text_color")
    @Expose
    private Object authorFlairTextColor;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("parent_whitelist_status")
    @Expose
    private String parentWhitelistStatus;
    @SerializedName("stickied")
    @Expose
    private boolean stickied;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("subreddit_subscribers")
    @Expose
    private int subredditSubscribers;
    @SerializedName("created_utc")
    @Expose
    private double createdUtc;
    @SerializedName("media")
    @Expose
    private Object media;
    @SerializedName("is_video")
    @Expose
    private boolean isVideo;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewPostData() {
    }

    /**
     * 
     * @param selftextHtml
     * @param pwls
     * @param mediaOnly
     * @param isOriginalContent
     * @param score
     * @param subredditId
     * @param authorFlairType
     * @param authorFlairCssClass
     * @param newPostDataSecureMediaEmbed
     * @param modReports
     * @param clicked
     * @param numComments
     * @param authorPatreonFlair
     * @param canGild
     * @param authorFullname
     * @param linkFlairText
     * @param created
     * @param linkFlairTemplateId
     * @param contestMode
     * @param over18
     * @param bannedBy
     * @param subredditSubscribers
     * @param modReasonTitle
     * @param postHint
     * @param createdUtc
     * @param stickied
     * @param linkFlairType
     * @param linkFlairCssClass
     * @param noFollow
     * @param saved
     * @param distinguished
     * @param newPostDataMediaEmbed
     * @param linkFlairTextColor
     * @param url
     * @param authorFlairText
     * @param subreddit
     * @param reportReasons
     * @param authorFlairTemplateId
     * @param category
     * @param parentWhitelistStatus
     * @param thumbnail
     * @param permalink
     * @param newPostDataPreview
     * @param likes
     * @param newPostDataGildings
     * @param isRedditMediaDomain
     * @param locked
     * @param thumbnailWidth
     * @param media
     * @param viewCount
     * @param whitelistStatus
     * @param quarantine
     * @param isCrosspostable
     * @param approvedBy
     * @param suggestedSort
     * @param isVideo
     * @param id
     * @param modReasonBy
     * @param visited
     * @param subredditNamePrefixed
     * @param userReports
     * @param author
     * @param approvedAtUtc
     * @param title
     * @param modNote
     * @param isRobotIndexable
     * @param archived
     * @param pinned
     * @param name
     * @param domain
     * @param sendReplies
     * @param isSelf
     * @param authorFlairBackgroundColor
     * @param numReports
     * @param secureMedia
     * @param edited
     * @param removalReason
     * @param linkFlairBackgroundColor
     * @param subredditType
     * @param spoiler
     * @param authorFlairRichtext
     * @param thumbnailHeight
     * @param authorFlairTextColor
     * @param contentCategories
     * @param gilded
     * @param linkFlairRichtext
     * @param hideScore
     * @param isMeta
     * @param hidden
     * @param numCrossposts
     * @param wls
     * @param canModPost
     * @param downs
     * @param ups
     * @param selftext
     * @param bannedAtUtc
     */
    public NewPostData(Object approvedAtUtc, String subreddit, String selftext, String authorFullname, boolean saved, Object modReasonTitle, int gilded, boolean clicked, String title, List<Object> linkFlairRichtext, String subredditNamePrefixed, boolean hidden, int pwls, Object linkFlairCssClass, int downs, Object thumbnailHeight, boolean hideScore, String name, boolean quarantine, String linkFlairTextColor, Object authorFlairBackgroundColor, String subredditType, int ups, String domain, NewPostDataMediaEmbed newPostDataMediaEmbed, Object thumbnailWidth, Object authorFlairTemplateId, boolean isOriginalContent, List<Object> userReports, Object secureMedia, boolean isRedditMediaDomain, boolean isMeta, Object category, NewPostDataSecureMediaEmbed newPostDataSecureMediaEmbed, Object linkFlairText, boolean canModPost, int score, Object approvedBy, String thumbnail, Object edited, Object authorFlairCssClass, List<Object> authorFlairRichtext, NewPostDataGildings newPostDataGildings, String postHint, Object contentCategories, boolean isSelf, Object modNote, double created, String linkFlairType, int wls, Object bannedBy, String authorFlairType, boolean contestMode, String selftextHtml, Object likes, Object suggestedSort, Object bannedAtUtc, Object viewCount, boolean archived, boolean noFollow, boolean isCrosspostable, boolean pinned, boolean over18, NewPostDataPreview newPostDataPreview, boolean mediaOnly, Object linkFlairTemplateId, boolean canGild, boolean spoiler, boolean locked, Object authorFlairText, boolean visited, Object numReports, Object distinguished, String subredditId, Object modReasonBy, Object removalReason, String linkFlairBackgroundColor, String id, boolean isRobotIndexable, Object reportReasons, String author, int numCrossposts, int numComments, boolean sendReplies, String whitelistStatus, List<Object> modReports, boolean authorPatreonFlair, Object authorFlairTextColor, String permalink, String parentWhitelistStatus, boolean stickied, String url, int subredditSubscribers, double createdUtc, Object media, boolean isVideo) {
        super();
        this.approvedAtUtc = approvedAtUtc;
        this.subreddit = subreddit;
        this.selftext = selftext;
        this.authorFullname = authorFullname;
        this.saved = saved;
        this.modReasonTitle = modReasonTitle;
        this.gilded = gilded;
        this.clicked = clicked;
        this.title = title;
        this.linkFlairRichtext = linkFlairRichtext;
        this.subredditNamePrefixed = subredditNamePrefixed;
        this.hidden = hidden;
        this.pwls = pwls;
        this.linkFlairCssClass = linkFlairCssClass;
        this.downs = downs;
        this.thumbnailHeight = thumbnailHeight;
        this.hideScore = hideScore;
        this.name = name;
        this.quarantine = quarantine;
        this.linkFlairTextColor = linkFlairTextColor;
        this.authorFlairBackgroundColor = authorFlairBackgroundColor;
        this.subredditType = subredditType;
        this.ups = ups;
        this.domain = domain;
        this.newPostDataMediaEmbed = newPostDataMediaEmbed;
        this.thumbnailWidth = thumbnailWidth;
        this.authorFlairTemplateId = authorFlairTemplateId;
        this.isOriginalContent = isOriginalContent;
        this.userReports = userReports;
        this.secureMedia = secureMedia;
        this.isRedditMediaDomain = isRedditMediaDomain;
        this.isMeta = isMeta;
        this.category = category;
        this.newPostDataSecureMediaEmbed = newPostDataSecureMediaEmbed;
        this.linkFlairText = linkFlairText;
        this.canModPost = canModPost;
        this.score = score;
        this.approvedBy = approvedBy;
        this.thumbnail = thumbnail;
        this.edited = edited;
        this.authorFlairCssClass = authorFlairCssClass;
        this.authorFlairRichtext = authorFlairRichtext;
        this.newPostDataGildings = newPostDataGildings;
        this.postHint = postHint;
        this.contentCategories = contentCategories;
        this.isSelf = isSelf;
        this.modNote = modNote;
        this.created = created;
        this.linkFlairType = linkFlairType;
        this.wls = wls;
        this.bannedBy = bannedBy;
        this.authorFlairType = authorFlairType;
        this.contestMode = contestMode;
        this.selftextHtml = selftextHtml;
        this.likes = likes;
        this.suggestedSort = suggestedSort;
        this.bannedAtUtc = bannedAtUtc;
        this.viewCount = viewCount;
        this.archived = archived;
        this.noFollow = noFollow;
        this.isCrosspostable = isCrosspostable;
        this.pinned = pinned;
        this.over18 = over18;
        this.newPostDataPreview = newPostDataPreview;
        this.mediaOnly = mediaOnly;
        this.linkFlairTemplateId = linkFlairTemplateId;
        this.canGild = canGild;
        this.spoiler = spoiler;
        this.locked = locked;
        this.authorFlairText = authorFlairText;
        this.visited = visited;
        this.numReports = numReports;
        this.distinguished = distinguished;
        this.subredditId = subredditId;
        this.modReasonBy = modReasonBy;
        this.removalReason = removalReason;
        this.linkFlairBackgroundColor = linkFlairBackgroundColor;
        this.id = id;
        this.isRobotIndexable = isRobotIndexable;
        this.reportReasons = reportReasons;
        this.author = author;
        this.numCrossposts = numCrossposts;
        this.numComments = numComments;
        this.sendReplies = sendReplies;
        this.whitelistStatus = whitelistStatus;
        this.modReports = modReports;
        this.authorPatreonFlair = authorPatreonFlair;
        this.authorFlairTextColor = authorFlairTextColor;
        this.permalink = permalink;
        this.parentWhitelistStatus = parentWhitelistStatus;
        this.stickied = stickied;
        this.url = url;
        this.subredditSubscribers = subredditSubscribers;
        this.createdUtc = createdUtc;
        this.media = media;
        this.isVideo = isVideo;
    }

    public Object getApprovedAtUtc() {
        return approvedAtUtc;
    }

    public void setApprovedAtUtc(Object approvedAtUtc) {
        this.approvedAtUtc = approvedAtUtc;
    }

    public NewPostData withApprovedAtUtc(Object approvedAtUtc) {
        this.approvedAtUtc = approvedAtUtc;
        return this;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public NewPostData withSubreddit(String subreddit) {
        this.subreddit = subreddit;
        return this;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public NewPostData withSelftext(String selftext) {
        this.selftext = selftext;
        return this;
    }

    public String getAuthorFullname() {
        return authorFullname;
    }

    public void setAuthorFullname(String authorFullname) {
        this.authorFullname = authorFullname;
    }

    public NewPostData withAuthorFullname(String authorFullname) {
        this.authorFullname = authorFullname;
        return this;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public NewPostData withSaved(boolean saved) {
        this.saved = saved;
        return this;
    }

    public Object getModReasonTitle() {
        return modReasonTitle;
    }

    public void setModReasonTitle(Object modReasonTitle) {
        this.modReasonTitle = modReasonTitle;
    }

    public NewPostData withModReasonTitle(Object modReasonTitle) {
        this.modReasonTitle = modReasonTitle;
        return this;
    }

    public int getGilded() {
        return gilded;
    }

    public void setGilded(int gilded) {
        this.gilded = gilded;
    }

    public NewPostData withNewPostDataGilded(int gilded) {
        this.gilded = gilded;
        return this;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public NewPostData withClicked(boolean clicked) {
        this.clicked = clicked;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NewPostData withTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Object> getLinkFlairRichtext() {
        return linkFlairRichtext;
    }

    public void setLinkFlairRichtext(List<Object> linkFlairRichtext) {
        this.linkFlairRichtext = linkFlairRichtext;
    }

    public NewPostData withLinkFlairRichtext(List<Object> linkFlairRichtext) {
        this.linkFlairRichtext = linkFlairRichtext;
        return this;
    }

    public String getSubredditNamePrefixed() {
        return subredditNamePrefixed;
    }

    public void setSubredditNamePrefixed(String subredditNamePrefixed) {
        this.subredditNamePrefixed = subredditNamePrefixed;
    }

    public NewPostData withSubredditNamePrefixed(String subredditNamePrefixed) {
        this.subredditNamePrefixed = subredditNamePrefixed;
        return this;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public NewPostData withHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public int getPwls() {
        return pwls;
    }

    public void setPwls(int pwls) {
        this.pwls = pwls;
    }

    public NewPostData withPwls(int pwls) {
        this.pwls = pwls;
        return this;
    }

    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public NewPostData withLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
        return this;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public NewPostData withDowns(int downs) {
        this.downs = downs;
        return this;
    }

    public Object getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(Object thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public NewPostData withThumbnailHeight(Object thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    public boolean isHideScore() {
        return hideScore;
    }

    public void setHideScore(boolean hideScore) {
        this.hideScore = hideScore;
    }

    public NewPostData withHideScore(boolean hideScore) {
        this.hideScore = hideScore;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewPostData withName(String name) {
        this.name = name;
        return this;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

    public NewPostData withQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
        return this;
    }

    public String getLinkFlairTextColor() {
        return linkFlairTextColor;
    }

    public void setLinkFlairTextColor(String linkFlairTextColor) {
        this.linkFlairTextColor = linkFlairTextColor;
    }

    public NewPostData withLinkFlairTextColor(String linkFlairTextColor) {
        this.linkFlairTextColor = linkFlairTextColor;
        return this;
    }

    public Object getAuthorFlairBackgroundColor() {
        return authorFlairBackgroundColor;
    }

    public void setAuthorFlairBackgroundColor(Object authorFlairBackgroundColor) {
        this.authorFlairBackgroundColor = authorFlairBackgroundColor;
    }

    public NewPostData withAuthorFlairBackgroundColor(Object authorFlairBackgroundColor) {
        this.authorFlairBackgroundColor = authorFlairBackgroundColor;
        return this;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public NewPostData withSubredditType(String subredditType) {
        this.subredditType = subredditType;
        return this;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public NewPostData withUps(int ups) {
        this.ups = ups;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public NewPostData withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public NewPostDataMediaEmbed getNewPostDataMediaEmbed() {
        return newPostDataMediaEmbed;
    }

    public void setNewPostDataMediaEmbed(NewPostDataMediaEmbed newPostDataMediaEmbed) {
        this.newPostDataMediaEmbed = newPostDataMediaEmbed;
    }

    public NewPostData withNewPostDataMediaEmbed(NewPostDataMediaEmbed newPostDataMediaEmbed) {
        this.newPostDataMediaEmbed = newPostDataMediaEmbed;
        return this;
    }

    public Object getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(Object thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public NewPostData withThumbnailWidth(Object thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    public Object getAuthorFlairTemplateId() {
        return authorFlairTemplateId;
    }

    public void setAuthorFlairTemplateId(Object authorFlairTemplateId) {
        this.authorFlairTemplateId = authorFlairTemplateId;
    }

    public NewPostData withAuthorFlairTemplateId(Object authorFlairTemplateId) {
        this.authorFlairTemplateId = authorFlairTemplateId;
        return this;
    }

    public boolean isIsOriginalContent() {
        return isOriginalContent;
    }

    public void setIsOriginalContent(boolean isOriginalContent) {
        this.isOriginalContent = isOriginalContent;
    }

    public NewPostData withIsOriginalContent(boolean isOriginalContent) {
        this.isOriginalContent = isOriginalContent;
        return this;
    }

    public List<Object> getUserReports() {
        return userReports;
    }

    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    public NewPostData withUserReports(List<Object> userReports) {
        this.userReports = userReports;
        return this;
    }

    public Object getNewPostDataSecureMedia() {
        return secureMedia;
    }

    public void setNewPostDataSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    public NewPostData withNewPostDataSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
        return this;
    }

    public boolean isIsRedditMediaDomain() {
        return isRedditMediaDomain;
    }

    public void setIsRedditMediaDomain(boolean isRedditMediaDomain) {
        this.isRedditMediaDomain = isRedditMediaDomain;
    }

    public NewPostData withIsRedditMediaDomain(boolean isRedditMediaDomain) {
        this.isRedditMediaDomain = isRedditMediaDomain;
        return this;
    }

    public boolean isIsMeta() {
        return isMeta;
    }

    public void setIsMeta(boolean isMeta) {
        this.isMeta = isMeta;
    }

    public NewPostData withIsMeta(boolean isMeta) {
        this.isMeta = isMeta;
        return this;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public NewPostData withCategory(Object category) {
        this.category = category;
        return this;
    }

    public NewPostDataSecureMediaEmbed getNewPostDataSecureMediaEmbed() {
        return newPostDataSecureMediaEmbed;
    }

    public void setNewPostDataSecureMediaEmbed(NewPostDataSecureMediaEmbed newPostDataSecureMediaEmbed) {
        this.newPostDataSecureMediaEmbed = newPostDataSecureMediaEmbed;
    }

    public NewPostData withNewPostDataSecureMediaEmbed(NewPostDataSecureMediaEmbed newPostDataSecureMediaEmbed) {
        this.newPostDataSecureMediaEmbed = newPostDataSecureMediaEmbed;
        return this;
    }

    public Object getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public NewPostData withLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
        return this;
    }

    public boolean isCanModPost() {
        return canModPost;
    }

    public void setCanModPost(boolean canModPost) {
        this.canModPost = canModPost;
    }

    public NewPostData withCanModPost(boolean canModPost) {
        this.canModPost = canModPost;
        return this;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public NewPostData withScore(int score) {
        this.score = score;
        return this;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public NewPostData withApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public NewPostData withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public Object getEdited() {
        return edited;
    }

    public void setEdited(Object edited) {
        this.edited = edited;
    }

    public NewPostData withEdited(Object edited) {
        this.edited = edited;
        return this;
    }

    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public NewPostData withAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
        return this;
    }

    public List<Object> getAuthorFlairRichtext() {
        return authorFlairRichtext;
    }

    public void setAuthorFlairRichtext(List<Object> authorFlairRichtext) {
        this.authorFlairRichtext = authorFlairRichtext;
    }

    public NewPostData withAuthorFlairRichtext(List<Object> authorFlairRichtext) {
        this.authorFlairRichtext = authorFlairRichtext;
        return this;
    }

    public NewPostDataGildings getNewPostDataGildings() {
        return newPostDataGildings;
    }

    public void setNewPostDataGildings(NewPostDataGildings newPostDataGildings) {
        this.newPostDataGildings = newPostDataGildings;
    }

    public NewPostData withNewPostDataGildings(NewPostDataGildings newPostDataGildings) {
        this.newPostDataGildings = newPostDataGildings;
        return this;
    }

    public String getPostHint() {
        return postHint;
    }

    public void setPostHint(String postHint) {
        this.postHint = postHint;
    }

    public NewPostData withPostHint(String postHint) {
        this.postHint = postHint;
        return this;
    }

    public Object getContentCategories() {
        return contentCategories;
    }

    public void setContentCategories(Object contentCategories) {
        this.contentCategories = contentCategories;
    }

    public NewPostData withContentCategories(Object contentCategories) {
        this.contentCategories = contentCategories;
        return this;
    }

    public boolean isIsSelf() {
        return isSelf;
    }

    public void setIsSelf(boolean isSelf) {
        this.isSelf = isSelf;
    }

    public NewPostData withIsSelf(boolean isSelf) {
        this.isSelf = isSelf;
        return this;
    }

    public Object getModNote() {
        return modNote;
    }

    public void setModNote(Object modNote) {
        this.modNote = modNote;
    }

    public NewPostData withModNote(Object modNote) {
        this.modNote = modNote;
        return this;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public NewPostData withCreated(double created) {
        this.created = created;
        return this;
    }

    public String getLinkFlairType() {
        return linkFlairType;
    }

    public void setLinkFlairType(String linkFlairType) {
        this.linkFlairType = linkFlairType;
    }

    public NewPostData withLinkFlairType(String linkFlairType) {
        this.linkFlairType = linkFlairType;
        return this;
    }

    public int getWls() {
        return wls;
    }

    public void setWls(int wls) {
        this.wls = wls;
    }

    public NewPostData withWls(int wls) {
        this.wls = wls;
        return this;
    }

    public Object getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }

    public NewPostData withBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
        return this;
    }

    public String getAuthorFlairType() {
        return authorFlairType;
    }

    public void setAuthorFlairType(String authorFlairType) {
        this.authorFlairType = authorFlairType;
    }

    public NewPostData withAuthorFlairType(String authorFlairType) {
        this.authorFlairType = authorFlairType;
        return this;
    }

    public boolean isContestMode() {
        return contestMode;
    }

    public void setContestMode(boolean contestMode) {
        this.contestMode = contestMode;
    }

    public NewPostData withContestMode(boolean contestMode) {
        this.contestMode = contestMode;
        return this;
    }

    public String getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public NewPostData withSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
        return this;
    }

    public Object getLikes() {
        return likes;
    }

    public void setLikes(Object likes) {
        this.likes = likes;
    }

    public NewPostData withLikes(Object likes) {
        this.likes = likes;
        return this;
    }

    public Object getSuggestedSort() {
        return suggestedSort;
    }

    public void setSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    public NewPostData withSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
        return this;
    }

    public Object getBannedAtUtc() {
        return bannedAtUtc;
    }

    public void setBannedAtUtc(Object bannedAtUtc) {
        this.bannedAtUtc = bannedAtUtc;
    }

    public NewPostData withBannedAtUtc(Object bannedAtUtc) {
        this.bannedAtUtc = bannedAtUtc;
        return this;
    }

    public Object getViewCount() {
        return viewCount;
    }

    public void setViewCount(Object viewCount) {
        this.viewCount = viewCount;
    }

    public NewPostData withViewCount(Object viewCount) {
        this.viewCount = viewCount;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public NewPostData withArchived(boolean archived) {
        this.archived = archived;
        return this;
    }

    public boolean isNoFollow() {
        return noFollow;
    }

    public void setNoFollow(boolean noFollow) {
        this.noFollow = noFollow;
    }

    public NewPostData withNoFollow(boolean noFollow) {
        this.noFollow = noFollow;
        return this;
    }

    public boolean isIsCrosspostable() {
        return isCrosspostable;
    }

    public void setIsCrosspostable(boolean isCrosspostable) {
        this.isCrosspostable = isCrosspostable;
    }

    public NewPostData withIsCrosspostable(boolean isCrosspostable) {
        this.isCrosspostable = isCrosspostable;
        return this;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public NewPostData withPinned(boolean pinned) {
        this.pinned = pinned;
        return this;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public NewPostData withOver18(boolean over18) {
        this.over18 = over18;
        return this;
    }

    public NewPostDataPreview getNewPostDataPreview() {
        return newPostDataPreview;
    }

    public void setNewPostDataPreview(NewPostDataPreview newPostDataPreview) {
        this.newPostDataPreview = newPostDataPreview;
    }

    public NewPostData withNewPostDataPreview(NewPostDataPreview newPostDataPreview) {
        this.newPostDataPreview = newPostDataPreview;
        return this;
    }

    public boolean isMediaOnly() {
        return mediaOnly;
    }

    public void setMediaOnly(boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
    }

    public NewPostData withMediaOnly(boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
        return this;
    }

    public Object getLinkFlairTemplateId() {
        return linkFlairTemplateId;
    }

    public void setLinkFlairTemplateId(Object linkFlairTemplateId) {
        this.linkFlairTemplateId = linkFlairTemplateId;
    }

    public NewPostData withLinkFlairTemplateId(Object linkFlairTemplateId) {
        this.linkFlairTemplateId = linkFlairTemplateId;
        return this;
    }

    public boolean isCanGild() {
        return canGild;
    }

    public void setCanGild(boolean canGild) {
        this.canGild = canGild;
    }

    public NewPostData withCanGild(boolean canGild) {
        this.canGild = canGild;
        return this;
    }

    public boolean isSpoiler() {
        return spoiler;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public NewPostData withSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
        return this;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public NewPostData withLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public NewPostData withAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
        return this;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public NewPostData withVisited(boolean visited) {
        this.visited = visited;
        return this;
    }

    public Object getNumReports() {
        return numReports;
    }

    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    public NewPostData withNumReports(Object numReports) {
        this.numReports = numReports;
        return this;
    }

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public NewPostData withDistinguished(Object distinguished) {
        this.distinguished = distinguished;
        return this;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public NewPostData withSubredditId(String subredditId) {
        this.subredditId = subredditId;
        return this;
    }

    public Object getModReasonBy() {
        return modReasonBy;
    }

    public void setModReasonBy(Object modReasonBy) {
        this.modReasonBy = modReasonBy;
    }

    public NewPostData withModReasonBy(Object modReasonBy) {
        this.modReasonBy = modReasonBy;
        return this;
    }

    public Object getRemovalReason() {
        return removalReason;
    }

    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    public NewPostData withRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
        return this;
    }

    public String getLinkFlairBackgroundColor() {
        return linkFlairBackgroundColor;
    }

    public void setLinkFlairBackgroundColor(String linkFlairBackgroundColor) {
        this.linkFlairBackgroundColor = linkFlairBackgroundColor;
    }

    public NewPostData withLinkFlairBackgroundColor(String linkFlairBackgroundColor) {
        this.linkFlairBackgroundColor = linkFlairBackgroundColor;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NewPostData withId(String id) {
        this.id = id;
        return this;
    }

    public boolean isIsRobotIndexable() {
        return isRobotIndexable;
    }

    public void setIsRobotIndexable(boolean isRobotIndexable) {
        this.isRobotIndexable = isRobotIndexable;
    }

    public NewPostData withIsRobotIndexable(boolean isRobotIndexable) {
        this.isRobotIndexable = isRobotIndexable;
        return this;
    }

    public Object getReportReasons() {
        return reportReasons;
    }

    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    public NewPostData withReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public NewPostData withAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getNumCrossposts() {
        return numCrossposts;
    }

    public void setNumCrossposts(int numCrossposts) {
        this.numCrossposts = numCrossposts;
    }

    public NewPostData withNumCrossposts(int numCrossposts) {
        this.numCrossposts = numCrossposts;
        return this;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public NewPostData withNumComments(int numComments) {
        this.numComments = numComments;
        return this;
    }

    public boolean isSendReplies() {
        return sendReplies;
    }

    public void setSendReplies(boolean sendReplies) {
        this.sendReplies = sendReplies;
    }

    public NewPostData withSendReplies(boolean sendReplies) {
        this.sendReplies = sendReplies;
        return this;
    }

    public String getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(String whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    public NewPostData withWhitelistStatus(String whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
        return this;
    }

    public List<Object> getModReports() {
        return modReports;
    }

    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    public NewPostData withModReports(List<Object> modReports) {
        this.modReports = modReports;
        return this;
    }

    public boolean isAuthorPatreonFlair() {
        return authorPatreonFlair;
    }

    public void setAuthorPatreonFlair(boolean authorPatreonFlair) {
        this.authorPatreonFlair = authorPatreonFlair;
    }

    public NewPostData withAuthorPatreonFlair(boolean authorPatreonFlair) {
        this.authorPatreonFlair = authorPatreonFlair;
        return this;
    }

    public Object getAuthorFlairTextColor() {
        return authorFlairTextColor;
    }

    public void setAuthorFlairTextColor(Object authorFlairTextColor) {
        this.authorFlairTextColor = authorFlairTextColor;
    }

    public NewPostData withAuthorFlairTextColor(Object authorFlairTextColor) {
        this.authorFlairTextColor = authorFlairTextColor;
        return this;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public NewPostData withPermalink(String permalink) {
        this.permalink = permalink;
        return this;
    }

    public String getParentWhitelistStatus() {
        return parentWhitelistStatus;
    }

    public void setParentWhitelistStatus(String parentWhitelistStatus) {
        this.parentWhitelistStatus = parentWhitelistStatus;
    }

    public NewPostData withParentWhitelistStatus(String parentWhitelistStatus) {
        this.parentWhitelistStatus = parentWhitelistStatus;
        return this;
    }

    public boolean isStickied() {
        return stickied;
    }

    public void setStickied(boolean stickied) {
        this.stickied = stickied;
    }

    public NewPostData withStickied(boolean stickied) {
        this.stickied = stickied;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NewPostData withUrl(String url) {
        this.url = url;
        return this;
    }

    public int getSubredditSubscribers() {
        return subredditSubscribers;
    }

    public void setSubredditSubscribers(int subredditSubscribers) {
        this.subredditSubscribers = subredditSubscribers;
    }

    public NewPostData withSubredditSubscribers(int subredditSubscribers) {
        this.subredditSubscribers = subredditSubscribers;
        return this;
    }

    public double getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
    }

    public NewPostData withCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
        return this;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public NewPostData withMedia(Object media) {
        this.media = media;
        return this;
    }

    public boolean isIsVideo() {
        return isVideo;
    }

    public void setIsVideo(boolean isVideo) {
        this.isVideo = isVideo;
    }

    public NewPostData withIsVideo(boolean isVideo) {
        this.isVideo = isVideo;
        return this;
    }

}
