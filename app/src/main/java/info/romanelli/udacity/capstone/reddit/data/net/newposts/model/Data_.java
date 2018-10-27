
package info.romanelli.udacity.capstone.reddit.data.net.newposts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data_ {

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
    private List<Object> linkFlairRichtext = new ArrayList<Object>();
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
    private MediaEmbed mediaEmbed;
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
    private List<Object> userReports = new ArrayList<Object>();
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
    private SecureMediaEmbed secureMediaEmbed;
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
    private List<Object> authorFlairRichtext = new ArrayList<Object>();
    @SerializedName("gildings")
    @Expose
    private Gildings gildings;
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
    private Preview preview;
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
    private List<Object> modReports = new ArrayList<Object>();
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
    public Data_() {
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
     * @param secureMediaEmbed
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
     * @param mediaEmbed
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
     * @param preview
     * @param likes
     * @param gildings
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
    public Data_(Object approvedAtUtc, String subreddit, String selftext, String authorFullname, boolean saved, Object modReasonTitle, int gilded, boolean clicked, String title, List<Object> linkFlairRichtext, String subredditNamePrefixed, boolean hidden, int pwls, Object linkFlairCssClass, int downs, Object thumbnailHeight, boolean hideScore, String name, boolean quarantine, String linkFlairTextColor, Object authorFlairBackgroundColor, String subredditType, int ups, String domain, MediaEmbed mediaEmbed, Object thumbnailWidth, Object authorFlairTemplateId, boolean isOriginalContent, List<Object> userReports, Object secureMedia, boolean isRedditMediaDomain, boolean isMeta, Object category, SecureMediaEmbed secureMediaEmbed, Object linkFlairText, boolean canModPost, int score, Object approvedBy, String thumbnail, Object edited, Object authorFlairCssClass, List<Object> authorFlairRichtext, Gildings gildings, String postHint, Object contentCategories, boolean isSelf, Object modNote, double created, String linkFlairType, int wls, Object bannedBy, String authorFlairType, boolean contestMode, String selftextHtml, Object likes, Object suggestedSort, Object bannedAtUtc, Object viewCount, boolean archived, boolean noFollow, boolean isCrosspostable, boolean pinned, boolean over18, Preview preview, boolean mediaOnly, Object linkFlairTemplateId, boolean canGild, boolean spoiler, boolean locked, Object authorFlairText, boolean visited, Object numReports, Object distinguished, String subredditId, Object modReasonBy, Object removalReason, String linkFlairBackgroundColor, String id, boolean isRobotIndexable, Object reportReasons, String author, int numCrossposts, int numComments, boolean sendReplies, String whitelistStatus, List<Object> modReports, boolean authorPatreonFlair, Object authorFlairTextColor, String permalink, String parentWhitelistStatus, boolean stickied, String url, int subredditSubscribers, double createdUtc, Object media, boolean isVideo) {
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
        this.mediaEmbed = mediaEmbed;
        this.thumbnailWidth = thumbnailWidth;
        this.authorFlairTemplateId = authorFlairTemplateId;
        this.isOriginalContent = isOriginalContent;
        this.userReports = userReports;
        this.secureMedia = secureMedia;
        this.isRedditMediaDomain = isRedditMediaDomain;
        this.isMeta = isMeta;
        this.category = category;
        this.secureMediaEmbed = secureMediaEmbed;
        this.linkFlairText = linkFlairText;
        this.canModPost = canModPost;
        this.score = score;
        this.approvedBy = approvedBy;
        this.thumbnail = thumbnail;
        this.edited = edited;
        this.authorFlairCssClass = authorFlairCssClass;
        this.authorFlairRichtext = authorFlairRichtext;
        this.gildings = gildings;
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
        this.preview = preview;
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

    public Data_ withApprovedAtUtc(Object approvedAtUtc) {
        this.approvedAtUtc = approvedAtUtc;
        return this;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Data_ withSubreddit(String subreddit) {
        this.subreddit = subreddit;
        return this;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public Data_ withSelftext(String selftext) {
        this.selftext = selftext;
        return this;
    }

    public String getAuthorFullname() {
        return authorFullname;
    }

    public void setAuthorFullname(String authorFullname) {
        this.authorFullname = authorFullname;
    }

    public Data_ withAuthorFullname(String authorFullname) {
        this.authorFullname = authorFullname;
        return this;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public Data_ withSaved(boolean saved) {
        this.saved = saved;
        return this;
    }

    public Object getModReasonTitle() {
        return modReasonTitle;
    }

    public void setModReasonTitle(Object modReasonTitle) {
        this.modReasonTitle = modReasonTitle;
    }

    public Data_ withModReasonTitle(Object modReasonTitle) {
        this.modReasonTitle = modReasonTitle;
        return this;
    }

    public int getGilded() {
        return gilded;
    }

    public void setGilded(int gilded) {
        this.gilded = gilded;
    }

    public Data_ withGilded(int gilded) {
        this.gilded = gilded;
        return this;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public Data_ withClicked(boolean clicked) {
        this.clicked = clicked;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data_ withTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Object> getLinkFlairRichtext() {
        return linkFlairRichtext;
    }

    public void setLinkFlairRichtext(List<Object> linkFlairRichtext) {
        this.linkFlairRichtext = linkFlairRichtext;
    }

    public Data_ withLinkFlairRichtext(List<Object> linkFlairRichtext) {
        this.linkFlairRichtext = linkFlairRichtext;
        return this;
    }

    public String getSubredditNamePrefixed() {
        return subredditNamePrefixed;
    }

    public void setSubredditNamePrefixed(String subredditNamePrefixed) {
        this.subredditNamePrefixed = subredditNamePrefixed;
    }

    public Data_ withSubredditNamePrefixed(String subredditNamePrefixed) {
        this.subredditNamePrefixed = subredditNamePrefixed;
        return this;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Data_ withHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public int getPwls() {
        return pwls;
    }

    public void setPwls(int pwls) {
        this.pwls = pwls;
    }

    public Data_ withPwls(int pwls) {
        this.pwls = pwls;
        return this;
    }

    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public Data_ withLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
        return this;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public Data_ withDowns(int downs) {
        this.downs = downs;
        return this;
    }

    public Object getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(Object thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public Data_ withThumbnailHeight(Object thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    public boolean isHideScore() {
        return hideScore;
    }

    public void setHideScore(boolean hideScore) {
        this.hideScore = hideScore;
    }

    public Data_ withHideScore(boolean hideScore) {
        this.hideScore = hideScore;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data_ withName(String name) {
        this.name = name;
        return this;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

    public Data_ withQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
        return this;
    }

    public String getLinkFlairTextColor() {
        return linkFlairTextColor;
    }

    public void setLinkFlairTextColor(String linkFlairTextColor) {
        this.linkFlairTextColor = linkFlairTextColor;
    }

    public Data_ withLinkFlairTextColor(String linkFlairTextColor) {
        this.linkFlairTextColor = linkFlairTextColor;
        return this;
    }

    public Object getAuthorFlairBackgroundColor() {
        return authorFlairBackgroundColor;
    }

    public void setAuthorFlairBackgroundColor(Object authorFlairBackgroundColor) {
        this.authorFlairBackgroundColor = authorFlairBackgroundColor;
    }

    public Data_ withAuthorFlairBackgroundColor(Object authorFlairBackgroundColor) {
        this.authorFlairBackgroundColor = authorFlairBackgroundColor;
        return this;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public Data_ withSubredditType(String subredditType) {
        this.subredditType = subredditType;
        return this;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public Data_ withUps(int ups) {
        this.ups = ups;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Data_ withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public Data_ withMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
        return this;
    }

    public Object getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(Object thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public Data_ withThumbnailWidth(Object thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    public Object getAuthorFlairTemplateId() {
        return authorFlairTemplateId;
    }

    public void setAuthorFlairTemplateId(Object authorFlairTemplateId) {
        this.authorFlairTemplateId = authorFlairTemplateId;
    }

    public Data_ withAuthorFlairTemplateId(Object authorFlairTemplateId) {
        this.authorFlairTemplateId = authorFlairTemplateId;
        return this;
    }

    public boolean isIsOriginalContent() {
        return isOriginalContent;
    }

    public void setIsOriginalContent(boolean isOriginalContent) {
        this.isOriginalContent = isOriginalContent;
    }

    public Data_ withIsOriginalContent(boolean isOriginalContent) {
        this.isOriginalContent = isOriginalContent;
        return this;
    }

    public List<Object> getUserReports() {
        return userReports;
    }

    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    public Data_ withUserReports(List<Object> userReports) {
        this.userReports = userReports;
        return this;
    }

    public Object getSecureMedia() {
        return secureMedia;
    }

    public void setSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    public Data_ withSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
        return this;
    }

    public boolean isIsRedditMediaDomain() {
        return isRedditMediaDomain;
    }

    public void setIsRedditMediaDomain(boolean isRedditMediaDomain) {
        this.isRedditMediaDomain = isRedditMediaDomain;
    }

    public Data_ withIsRedditMediaDomain(boolean isRedditMediaDomain) {
        this.isRedditMediaDomain = isRedditMediaDomain;
        return this;
    }

    public boolean isIsMeta() {
        return isMeta;
    }

    public void setIsMeta(boolean isMeta) {
        this.isMeta = isMeta;
    }

    public Data_ withIsMeta(boolean isMeta) {
        this.isMeta = isMeta;
        return this;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public Data_ withCategory(Object category) {
        this.category = category;
        return this;
    }

    public SecureMediaEmbed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }

    public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }

    public Data_ withSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
        return this;
    }

    public Object getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public Data_ withLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
        return this;
    }

    public boolean isCanModPost() {
        return canModPost;
    }

    public void setCanModPost(boolean canModPost) {
        this.canModPost = canModPost;
    }

    public Data_ withCanModPost(boolean canModPost) {
        this.canModPost = canModPost;
        return this;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Data_ withScore(int score) {
        this.score = score;
        return this;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Data_ withApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Data_ withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public Object getEdited() {
        return edited;
    }

    public void setEdited(Object edited) {
        this.edited = edited;
    }

    public Data_ withEdited(Object edited) {
        this.edited = edited;
        return this;
    }

    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public Data_ withAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
        return this;
    }

    public List<Object> getAuthorFlairRichtext() {
        return authorFlairRichtext;
    }

    public void setAuthorFlairRichtext(List<Object> authorFlairRichtext) {
        this.authorFlairRichtext = authorFlairRichtext;
    }

    public Data_ withAuthorFlairRichtext(List<Object> authorFlairRichtext) {
        this.authorFlairRichtext = authorFlairRichtext;
        return this;
    }

    public Gildings getGildings() {
        return gildings;
    }

    public void setGildings(Gildings gildings) {
        this.gildings = gildings;
    }

    public Data_ withGildings(Gildings gildings) {
        this.gildings = gildings;
        return this;
    }

    public String getPostHint() {
        return postHint;
    }

    public void setPostHint(String postHint) {
        this.postHint = postHint;
    }

    public Data_ withPostHint(String postHint) {
        this.postHint = postHint;
        return this;
    }

    public Object getContentCategories() {
        return contentCategories;
    }

    public void setContentCategories(Object contentCategories) {
        this.contentCategories = contentCategories;
    }

    public Data_ withContentCategories(Object contentCategories) {
        this.contentCategories = contentCategories;
        return this;
    }

    public boolean isIsSelf() {
        return isSelf;
    }

    public void setIsSelf(boolean isSelf) {
        this.isSelf = isSelf;
    }

    public Data_ withIsSelf(boolean isSelf) {
        this.isSelf = isSelf;
        return this;
    }

    public Object getModNote() {
        return modNote;
    }

    public void setModNote(Object modNote) {
        this.modNote = modNote;
    }

    public Data_ withModNote(Object modNote) {
        this.modNote = modNote;
        return this;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public Data_ withCreated(double created) {
        this.created = created;
        return this;
    }

    public String getLinkFlairType() {
        return linkFlairType;
    }

    public void setLinkFlairType(String linkFlairType) {
        this.linkFlairType = linkFlairType;
    }

    public Data_ withLinkFlairType(String linkFlairType) {
        this.linkFlairType = linkFlairType;
        return this;
    }

    public int getWls() {
        return wls;
    }

    public void setWls(int wls) {
        this.wls = wls;
    }

    public Data_ withWls(int wls) {
        this.wls = wls;
        return this;
    }

    public Object getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }

    public Data_ withBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
        return this;
    }

    public String getAuthorFlairType() {
        return authorFlairType;
    }

    public void setAuthorFlairType(String authorFlairType) {
        this.authorFlairType = authorFlairType;
    }

    public Data_ withAuthorFlairType(String authorFlairType) {
        this.authorFlairType = authorFlairType;
        return this;
    }

    public boolean isContestMode() {
        return contestMode;
    }

    public void setContestMode(boolean contestMode) {
        this.contestMode = contestMode;
    }

    public Data_ withContestMode(boolean contestMode) {
        this.contestMode = contestMode;
        return this;
    }

    public String getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public Data_ withSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
        return this;
    }

    public Object getLikes() {
        return likes;
    }

    public void setLikes(Object likes) {
        this.likes = likes;
    }

    public Data_ withLikes(Object likes) {
        this.likes = likes;
        return this;
    }

    public Object getSuggestedSort() {
        return suggestedSort;
    }

    public void setSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    public Data_ withSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
        return this;
    }

    public Object getBannedAtUtc() {
        return bannedAtUtc;
    }

    public void setBannedAtUtc(Object bannedAtUtc) {
        this.bannedAtUtc = bannedAtUtc;
    }

    public Data_ withBannedAtUtc(Object bannedAtUtc) {
        this.bannedAtUtc = bannedAtUtc;
        return this;
    }

    public Object getViewCount() {
        return viewCount;
    }

    public void setViewCount(Object viewCount) {
        this.viewCount = viewCount;
    }

    public Data_ withViewCount(Object viewCount) {
        this.viewCount = viewCount;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Data_ withArchived(boolean archived) {
        this.archived = archived;
        return this;
    }

    public boolean isNoFollow() {
        return noFollow;
    }

    public void setNoFollow(boolean noFollow) {
        this.noFollow = noFollow;
    }

    public Data_ withNoFollow(boolean noFollow) {
        this.noFollow = noFollow;
        return this;
    }

    public boolean isIsCrosspostable() {
        return isCrosspostable;
    }

    public void setIsCrosspostable(boolean isCrosspostable) {
        this.isCrosspostable = isCrosspostable;
    }

    public Data_ withIsCrosspostable(boolean isCrosspostable) {
        this.isCrosspostable = isCrosspostable;
        return this;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public Data_ withPinned(boolean pinned) {
        this.pinned = pinned;
        return this;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public Data_ withOver18(boolean over18) {
        this.over18 = over18;
        return this;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public Data_ withPreview(Preview preview) {
        this.preview = preview;
        return this;
    }

    public boolean isMediaOnly() {
        return mediaOnly;
    }

    public void setMediaOnly(boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
    }

    public Data_ withMediaOnly(boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
        return this;
    }

    public Object getLinkFlairTemplateId() {
        return linkFlairTemplateId;
    }

    public void setLinkFlairTemplateId(Object linkFlairTemplateId) {
        this.linkFlairTemplateId = linkFlairTemplateId;
    }

    public Data_ withLinkFlairTemplateId(Object linkFlairTemplateId) {
        this.linkFlairTemplateId = linkFlairTemplateId;
        return this;
    }

    public boolean isCanGild() {
        return canGild;
    }

    public void setCanGild(boolean canGild) {
        this.canGild = canGild;
    }

    public Data_ withCanGild(boolean canGild) {
        this.canGild = canGild;
        return this;
    }

    public boolean isSpoiler() {
        return spoiler;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public Data_ withSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
        return this;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Data_ withLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public Data_ withAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
        return this;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Data_ withVisited(boolean visited) {
        this.visited = visited;
        return this;
    }

    public Object getNumReports() {
        return numReports;
    }

    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    public Data_ withNumReports(Object numReports) {
        this.numReports = numReports;
        return this;
    }

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public Data_ withDistinguished(Object distinguished) {
        this.distinguished = distinguished;
        return this;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Data_ withSubredditId(String subredditId) {
        this.subredditId = subredditId;
        return this;
    }

    public Object getModReasonBy() {
        return modReasonBy;
    }

    public void setModReasonBy(Object modReasonBy) {
        this.modReasonBy = modReasonBy;
    }

    public Data_ withModReasonBy(Object modReasonBy) {
        this.modReasonBy = modReasonBy;
        return this;
    }

    public Object getRemovalReason() {
        return removalReason;
    }

    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    public Data_ withRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
        return this;
    }

    public String getLinkFlairBackgroundColor() {
        return linkFlairBackgroundColor;
    }

    public void setLinkFlairBackgroundColor(String linkFlairBackgroundColor) {
        this.linkFlairBackgroundColor = linkFlairBackgroundColor;
    }

    public Data_ withLinkFlairBackgroundColor(String linkFlairBackgroundColor) {
        this.linkFlairBackgroundColor = linkFlairBackgroundColor;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Data_ withId(String id) {
        this.id = id;
        return this;
    }

    public boolean isIsRobotIndexable() {
        return isRobotIndexable;
    }

    public void setIsRobotIndexable(boolean isRobotIndexable) {
        this.isRobotIndexable = isRobotIndexable;
    }

    public Data_ withIsRobotIndexable(boolean isRobotIndexable) {
        this.isRobotIndexable = isRobotIndexable;
        return this;
    }

    public Object getReportReasons() {
        return reportReasons;
    }

    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    public Data_ withReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Data_ withAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getNumCrossposts() {
        return numCrossposts;
    }

    public void setNumCrossposts(int numCrossposts) {
        this.numCrossposts = numCrossposts;
    }

    public Data_ withNumCrossposts(int numCrossposts) {
        this.numCrossposts = numCrossposts;
        return this;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public Data_ withNumComments(int numComments) {
        this.numComments = numComments;
        return this;
    }

    public boolean isSendReplies() {
        return sendReplies;
    }

    public void setSendReplies(boolean sendReplies) {
        this.sendReplies = sendReplies;
    }

    public Data_ withSendReplies(boolean sendReplies) {
        this.sendReplies = sendReplies;
        return this;
    }

    public String getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(String whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    public Data_ withWhitelistStatus(String whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
        return this;
    }

    public List<Object> getModReports() {
        return modReports;
    }

    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    public Data_ withModReports(List<Object> modReports) {
        this.modReports = modReports;
        return this;
    }

    public boolean isAuthorPatreonFlair() {
        return authorPatreonFlair;
    }

    public void setAuthorPatreonFlair(boolean authorPatreonFlair) {
        this.authorPatreonFlair = authorPatreonFlair;
    }

    public Data_ withAuthorPatreonFlair(boolean authorPatreonFlair) {
        this.authorPatreonFlair = authorPatreonFlair;
        return this;
    }

    public Object getAuthorFlairTextColor() {
        return authorFlairTextColor;
    }

    public void setAuthorFlairTextColor(Object authorFlairTextColor) {
        this.authorFlairTextColor = authorFlairTextColor;
    }

    public Data_ withAuthorFlairTextColor(Object authorFlairTextColor) {
        this.authorFlairTextColor = authorFlairTextColor;
        return this;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Data_ withPermalink(String permalink) {
        this.permalink = permalink;
        return this;
    }

    public String getParentWhitelistStatus() {
        return parentWhitelistStatus;
    }

    public void setParentWhitelistStatus(String parentWhitelistStatus) {
        this.parentWhitelistStatus = parentWhitelistStatus;
    }

    public Data_ withParentWhitelistStatus(String parentWhitelistStatus) {
        this.parentWhitelistStatus = parentWhitelistStatus;
        return this;
    }

    public boolean isStickied() {
        return stickied;
    }

    public void setStickied(boolean stickied) {
        this.stickied = stickied;
    }

    public Data_ withStickied(boolean stickied) {
        this.stickied = stickied;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Data_ withUrl(String url) {
        this.url = url;
        return this;
    }

    public int getSubredditSubscribers() {
        return subredditSubscribers;
    }

    public void setSubredditSubscribers(int subredditSubscribers) {
        this.subredditSubscribers = subredditSubscribers;
    }

    public Data_ withSubredditSubscribers(int subredditSubscribers) {
        this.subredditSubscribers = subredditSubscribers;
        return this;
    }

    public double getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Data_ withCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
        return this;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Data_ withMedia(Object media) {
        this.media = media;
        return this;
    }

    public boolean isIsVideo() {
        return isVideo;
    }

    public void setIsVideo(boolean isVideo) {
        this.isVideo = isVideo;
    }

    public Data_ withIsVideo(boolean isVideo) {
        this.isVideo = isVideo;
        return this;
    }

}
