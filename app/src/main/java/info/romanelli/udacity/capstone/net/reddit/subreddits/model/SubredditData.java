package info.romanelli.udacity.capstone.net.reddit.subreddits.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubredditData {

    /*
    Subreddits
        SubredditsData
            Subreddit
                SubredditData
     */

    @SerializedName("notification_level")
    @Expose
    private String notificationLevel;

    @SerializedName("user_flair_background_color")
    @Expose
    private Object userFlairBackgroundColor;

    @SerializedName("wls")
    @Expose
    private int wls;

    @SerializedName("banner_img")
    @Expose
    private String bannerImg;

    @SerializedName("user_sr_theme_enabled")
    @Expose
    private boolean userSrThemeEnabled;

    @SerializedName("user_flair_text")
    @Expose
    private Object userFlairText;

    @SerializedName("submit_text_html")
    @Expose
    private String submitTextHtml;

    @SerializedName("user_flair_css_class")
    @Expose
    private Object userFlairCssClass;

    @SerializedName("user_flair_template_id")
    @Expose
    private Object userFlairTemplateId;

    @SerializedName("user_is_banned")
    @Expose
    private boolean userIsBanned;

    @SerializedName("community_icon")
    @Expose
    private String communityIcon;

    @SerializedName("banner_background_image")
    @Expose
    private String bannerBackgroundImage;

    @SerializedName("header_title")
    @Expose
    private String headerTitle;

    @SerializedName("wiki_enabled")
    @Expose
    private boolean wikiEnabled;

    @SerializedName("over18")
    @Expose
    private boolean over18;

    @SerializedName("show_media")
    @Expose
    private boolean showMedia;

    @SerializedName("banner_background_color")
    @Expose
    private String bannerBackgroundColor;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("user_is_muted")
    @Expose
    private boolean userIsMuted;

    @SerializedName("user_flair_type")
    @Expose
    private String userFlairType;

    @SerializedName("user_can_flair_in_sr")
    @Expose
    private Object userCanFlairInSr;

    @SerializedName("display_name")
    @Expose
    private String displayName;

    @SerializedName("header_img")
    @Expose
    private String headerImg;

    @SerializedName("description_html")
    @Expose
    private String descriptionHtml;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("collapse_deleted_comments")
    @Expose
    private boolean collapseDeletedComments;

    @SerializedName("user_has_favorited")
    @Expose
    private boolean userHasFavorited;

    @SerializedName("emojis_custom_size")
    @Expose
    private Object emojisCustomSize;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("emojis_enabled")
    @Expose
    private boolean emojisEnabled;

    @SerializedName("public_description_html")
    @Expose
    private String publicDescriptionHtml;

    @SerializedName("can_assign_user_flair")
    @Expose
    private boolean canAssignUserFlair;

    @SerializedName("allow_videos")
    @Expose
    private boolean allowVideos;

    @SerializedName("spoilers_enabled")
    @Expose
    private boolean spoilersEnabled;

    @SerializedName("icon_size")
    @Expose
    private Object iconSize;

    @SerializedName("primary_color")
    @Expose
    private String primaryColor;

    @SerializedName("user_is_contributor")
    @Expose
    private boolean userIsContributor;

    @SerializedName("audience_target")
    @Expose
    private String audienceTarget;

    @SerializedName("suggested_comment_sort")
    @Expose
    private Object suggestedCommentSort;

    @SerializedName("active_user_count")
    @Expose
    private Object activeUserCount;

    @SerializedName("icon_img")
    @Expose
    private String iconImg;

    @SerializedName("original_content_tag_enabled")
    @Expose
    private boolean originalContentTagEnabled;

    @SerializedName("display_name_prefixed")
    @Expose
    private String displayNamePrefixed;

    @SerializedName("can_assign_link_flair")
    @Expose
    private boolean canAssignLinkFlair;

    @SerializedName("submit_text")
    @Expose
    private String submitText;

    @SerializedName("allow_videogifs")
    @Expose
    private boolean allowVideogifs;

    @SerializedName("user_flair_text_color")
    @Expose
    private Object userFlairTextColor;

    @SerializedName("accounts_active")
    @Expose
    private Object accountsActive;

    @SerializedName("public_traffic")
    @Expose
    private boolean publicTraffic;

    @SerializedName("header_size")
    @Expose
    private List<Integer> headerSize = null;

    @SerializedName("subscribers")
    @Expose
    private int subscribers;

    @SerializedName("user_flair_position")
    @Expose
    private String userFlairPosition;

    @SerializedName("submit_text_label")
    @Expose
    private Object submitTextLabel;

    @SerializedName("key_color")
    @Expose
    private String keyColor;

    @SerializedName("link_flair_position")
    @Expose
    private String linkFlairPosition;

    @SerializedName("user_flair_richtext")
    @Expose
    private List<Object> userFlairRichtext = null;

    @SerializedName("all_original_content")
    @Expose
    private boolean allOriginalContent;

    @SerializedName("lang")
    @Expose
    private String lang;

    @SerializedName("has_menu_widget")
    @Expose
    private boolean hasMenuWidget;

    @SerializedName("is_enrolled_in_new_modmail")
    @Expose
    private Object isEnrolledInNewModmail;

    @SerializedName("whitelist_status")
    @Expose
    private String whitelistStatus;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("user_flair_enabled_in_sr")
    @Expose
    private boolean userFlairEnabledInSr;

    @SerializedName("created")
    @Expose
    private double created;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("submit_link_label")
    @Expose
    private Object submitLinkLabel;

    @SerializedName("quarantine")
    @Expose
    private boolean quarantine;

    @SerializedName("hide_ads")
    @Expose
    private boolean hideAds;

    @SerializedName("created_utc")
    @Expose
    private double createdUtc;

    @SerializedName("banner_size")
    @Expose
    private Object bannerSize;

    @SerializedName("user_is_moderator")
    @Expose
    private boolean userIsModerator;

    @SerializedName("user_sr_flair_enabled")
    @Expose
    private Object userSrFlairEnabled;

    @SerializedName("allow_discovery")
    @Expose
    private boolean allowDiscovery;

    @SerializedName("accounts_active_is_fuzzed")
    @Expose
    private boolean accountsActiveIsFuzzed;

    @SerializedName("advertiser_category")
    @Expose
    private String advertiserCategory;

    @SerializedName("public_description")
    @Expose
    private String publicDescription;

    @SerializedName("link_flair_enabled")
    @Expose
    private boolean linkFlairEnabled;

    @SerializedName("allow_images")
    @Expose
    private boolean allowImages;

    @SerializedName("show_media_preview")
    @Expose
    private boolean showMediaPreview;

    @SerializedName("comment_score_hide_mins")
    @Expose
    private int commentScoreHideMins;

    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;

    @SerializedName("submission_type")
    @Expose
    private String submissionType;

    @SerializedName("user_is_subscriber")
    @Expose
    private boolean userIsSubscriber;

    /**
     * No args constructor for use in serialization
     *
     */
    public SubredditData() {
    }

    /**
     *
     * @param userFlairPosition
     * @param audienceTarget
     * @param spoilersEnabled
     * @param userIsContributor
     * @param originalContentTagEnabled
     * @param allowImages
     * @param userFlairText
     * @param bannerSize
     * @param created
     * @param keyColor
     * @param primaryColor
     * @param description
     * @param communityIcon
     * @param userFlairTextColor
     * @param bannerBackgroundImage
     * @param displayNamePrefixed
     * @param over18
     * @param emojisCustomSize
     * @param headerTitle
     * @param createdUtc
     * @param submitLinkLabel
     * @param commentScoreHideMins
     * @param userHasFavorited
     * @param userFlairTemplateId
     * @param canAssignUserFlair
     * @param showMediaPreview
     * @param advertiserCategory
     * @param submissionType
     * @param accountsActive
     * @param url
     * @param userFlairRichtext
     * @param iconImg
     * @param userCanFlairInSr
     * @param publicDescription
     * @param iconSize
     * @param allowVideogifs
     * @param emojisEnabled
     * @param accountsActiveIsFuzzed
     * @param submitTextLabel
     * @param suggestedCommentSort
     * @param subscribers
     * @param hasMenuWidget
     * @param publicTraffic
     * @param descriptionHtml
     * @param allowDiscovery
     * @param userIsBanned
     * @param allowVideos
     * @param whitelistStatus
     * @param userFlairCssClass
     * @param quarantine
     * @param lang
     * @param bannerBackgroundColor
     * @param showMedia
     * @param submitTextHtml
     * @param canAssignLinkFlair
     * @param userFlairEnabledInSr
     * @param userFlairType
     * @param id
     * @param title
     * @param isEnrolledInNewModmail
     * @param name
     * @param activeUserCount
     * @param linkFlairEnabled
     * @param bannerImg
     * @param headerSize
     * @param userIsModerator
     * @param subredditType
     * @param allOriginalContent
     * @param userSrFlairEnabled
     * @param publicDescriptionHtml
     * @param userFlairBackgroundColor
     * @param hideAds
     * @param headerImg
     * @param submitText
     * @param linkFlairPosition
     * @param notificationLevel
     * @param userIsSubscriber
     * @param wls
     * @param wikiEnabled
     * @param displayName
     * @param userIsMuted
     * @param userSrThemeEnabled
     * @param collapseDeletedComments
     */
    public SubredditData(String notificationLevel, Object userFlairBackgroundColor, int wls, String bannerImg, boolean userSrThemeEnabled, Object userFlairText, String submitTextHtml, Object userFlairCssClass, Object userFlairTemplateId, boolean userIsBanned, String communityIcon, String bannerBackgroundImage, String headerTitle, boolean wikiEnabled, boolean over18, boolean showMedia, String bannerBackgroundColor, String description, boolean userIsMuted, String userFlairType, Object userCanFlairInSr, String displayName, String headerImg, String descriptionHtml, String title, boolean collapseDeletedComments, boolean userHasFavorited, Object emojisCustomSize, String id, boolean emojisEnabled, String publicDescriptionHtml, boolean canAssignUserFlair, boolean allowVideos, boolean spoilersEnabled, Object iconSize, String primaryColor, boolean userIsContributor, String audienceTarget, Object suggestedCommentSort, Object activeUserCount, String iconImg, boolean originalContentTagEnabled, String displayNamePrefixed, boolean canAssignLinkFlair, String submitText, boolean allowVideogifs, Object userFlairTextColor, Object accountsActive, boolean publicTraffic, List<Integer> headerSize, int subscribers, String userFlairPosition, Object submitTextLabel, String keyColor, String linkFlairPosition, List<Object> userFlairRichtext, boolean allOriginalContent, String lang, boolean hasMenuWidget, Object isEnrolledInNewModmail, String whitelistStatus, String name, boolean userFlairEnabledInSr, double created, String url, Object submitLinkLabel, boolean quarantine, boolean hideAds, double createdUtc, Object bannerSize, boolean userIsModerator, Object userSrFlairEnabled, boolean allowDiscovery, boolean accountsActiveIsFuzzed, String advertiserCategory, String publicDescription, boolean linkFlairEnabled, boolean allowImages, boolean showMediaPreview, int commentScoreHideMins, String subredditType, String submissionType, boolean userIsSubscriber) {
        super();
        this.notificationLevel = notificationLevel;
        this.userFlairBackgroundColor = userFlairBackgroundColor;
        this.wls = wls;
        this.bannerImg = bannerImg;
        this.userSrThemeEnabled = userSrThemeEnabled;
        this.userFlairText = userFlairText;
        this.submitTextHtml = submitTextHtml;
        this.userFlairCssClass = userFlairCssClass;
        this.userFlairTemplateId = userFlairTemplateId;
        this.userIsBanned = userIsBanned;
        this.communityIcon = communityIcon;
        this.bannerBackgroundImage = bannerBackgroundImage;
        this.headerTitle = headerTitle;
        this.wikiEnabled = wikiEnabled;
        this.over18 = over18;
        this.showMedia = showMedia;
        this.bannerBackgroundColor = bannerBackgroundColor;
        this.description = description;
        this.userIsMuted = userIsMuted;
        this.userFlairType = userFlairType;
        this.userCanFlairInSr = userCanFlairInSr;
        this.displayName = displayName;
        this.headerImg = headerImg;
        this.descriptionHtml = descriptionHtml;
        this.title = title;
        this.collapseDeletedComments = collapseDeletedComments;
        this.userHasFavorited = userHasFavorited;
        this.emojisCustomSize = emojisCustomSize;
        this.id = id;
        this.emojisEnabled = emojisEnabled;
        this.publicDescriptionHtml = publicDescriptionHtml;
        this.canAssignUserFlair = canAssignUserFlair;
        this.allowVideos = allowVideos;
        this.spoilersEnabled = spoilersEnabled;
        this.iconSize = iconSize;
        this.primaryColor = primaryColor;
        this.userIsContributor = userIsContributor;
        this.audienceTarget = audienceTarget;
        this.suggestedCommentSort = suggestedCommentSort;
        this.activeUserCount = activeUserCount;
        this.iconImg = iconImg;
        this.originalContentTagEnabled = originalContentTagEnabled;
        this.displayNamePrefixed = displayNamePrefixed;
        this.canAssignLinkFlair = canAssignLinkFlair;
        this.submitText = submitText;
        this.allowVideogifs = allowVideogifs;
        this.userFlairTextColor = userFlairTextColor;
        this.accountsActive = accountsActive;
        this.publicTraffic = publicTraffic;
        this.headerSize = headerSize;
        this.subscribers = subscribers;
        this.userFlairPosition = userFlairPosition;
        this.submitTextLabel = submitTextLabel;
        this.keyColor = keyColor;
        this.linkFlairPosition = linkFlairPosition;
        this.userFlairRichtext = userFlairRichtext;
        this.allOriginalContent = allOriginalContent;
        this.lang = lang;
        this.hasMenuWidget = hasMenuWidget;
        this.isEnrolledInNewModmail = isEnrolledInNewModmail;
        this.whitelistStatus = whitelistStatus;
        this.name = name;
        this.userFlairEnabledInSr = userFlairEnabledInSr;
        this.created = created;
        this.url = url;
        this.submitLinkLabel = submitLinkLabel;
        this.quarantine = quarantine;
        this.hideAds = hideAds;
        this.createdUtc = createdUtc;
        this.bannerSize = bannerSize;
        this.userIsModerator = userIsModerator;
        this.userSrFlairEnabled = userSrFlairEnabled;
        this.allowDiscovery = allowDiscovery;
        this.accountsActiveIsFuzzed = accountsActiveIsFuzzed;
        this.advertiserCategory = advertiserCategory;
        this.publicDescription = publicDescription;
        this.linkFlairEnabled = linkFlairEnabled;
        this.allowImages = allowImages;
        this.showMediaPreview = showMediaPreview;
        this.commentScoreHideMins = commentScoreHideMins;
        this.subredditType = subredditType;
        this.submissionType = submissionType;
        this.userIsSubscriber = userIsSubscriber;
    }

    public String getNotificationLevel() {
        return notificationLevel;
    }

    public void setNotificationLevel(String notificationLevel) {
        this.notificationLevel = notificationLevel;
    }

    public SubredditData withNotificationLevel(String notificationLevel) {
        this.notificationLevel = notificationLevel;
        return this;
    }

    public Object getUserFlairBackgroundColor() {
        return userFlairBackgroundColor;
    }

    public void setUserFlairBackgroundColor(Object userFlairBackgroundColor) {
        this.userFlairBackgroundColor = userFlairBackgroundColor;
    }

    public SubredditData withUserFlairBackgroundColor(Object userFlairBackgroundColor) {
        this.userFlairBackgroundColor = userFlairBackgroundColor;
        return this;
    }

    public int getWls() {
        return wls;
    }

    public void setWls(int wls) {
        this.wls = wls;
    }

    public SubredditData withWls(int wls) {
        this.wls = wls;
        return this;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public SubredditData withBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
        return this;
    }

    public boolean isUserSrThemeEnabled() {
        return userSrThemeEnabled;
    }

    public void setUserSrThemeEnabled(boolean userSrThemeEnabled) {
        this.userSrThemeEnabled = userSrThemeEnabled;
    }

    public SubredditData withUserSrThemeEnabled(boolean userSrThemeEnabled) {
        this.userSrThemeEnabled = userSrThemeEnabled;
        return this;
    }

    public Object getUserFlairText() {
        return userFlairText;
    }

    public void setUserFlairText(Object userFlairText) {
        this.userFlairText = userFlairText;
    }

    public SubredditData withUserFlairText(Object userFlairText) {
        this.userFlairText = userFlairText;
        return this;
    }

    public String getSubmitTextHtml() {
        return submitTextHtml;
    }

    public void setSubmitTextHtml(String submitTextHtml) {
        this.submitTextHtml = submitTextHtml;
    }

    public SubredditData withSubmitTextHtml(String submitTextHtml) {
        this.submitTextHtml = submitTextHtml;
        return this;
    }

    public Object getUserFlairCssClass() {
        return userFlairCssClass;
    }

    public void setUserFlairCssClass(Object userFlairCssClass) {
        this.userFlairCssClass = userFlairCssClass;
    }

    public SubredditData withUserFlairCssClass(Object userFlairCssClass) {
        this.userFlairCssClass = userFlairCssClass;
        return this;
    }

    public Object getUserFlairTemplateId() {
        return userFlairTemplateId;
    }

    public void setUserFlairTemplateId(Object userFlairTemplateId) {
        this.userFlairTemplateId = userFlairTemplateId;
    }

    public SubredditData withUserFlairTemplateId(Object userFlairTemplateId) {
        this.userFlairTemplateId = userFlairTemplateId;
        return this;
    }

    public boolean isUserIsBanned() {
        return userIsBanned;
    }

    public void setUserIsBanned(boolean userIsBanned) {
        this.userIsBanned = userIsBanned;
    }

    public SubredditData withUserIsBanned(boolean userIsBanned) {
        this.userIsBanned = userIsBanned;
        return this;
    }

    public String getCommunityIcon() {
        return communityIcon;
    }

    public void setCommunityIcon(String communityIcon) {
        this.communityIcon = communityIcon;
    }

    public SubredditData withCommunityIcon(String communityIcon) {
        this.communityIcon = communityIcon;
        return this;
    }

    public String getBannerBackgroundImage() {
        return bannerBackgroundImage;
    }

    public void setBannerBackgroundImage(String bannerBackgroundImage) {
        this.bannerBackgroundImage = bannerBackgroundImage;
    }

    public SubredditData withBannerBackgroundImage(String bannerBackgroundImage) {
        this.bannerBackgroundImage = bannerBackgroundImage;
        return this;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public SubredditData withHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
        return this;
    }

    public boolean isWikiEnabled() {
        return wikiEnabled;
    }

    public void setWikiEnabled(boolean wikiEnabled) {
        this.wikiEnabled = wikiEnabled;
    }

    public SubredditData withWikiEnabled(boolean wikiEnabled) {
        this.wikiEnabled = wikiEnabled;
        return this;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public SubredditData withOver18(boolean over18) {
        this.over18 = over18;
        return this;
    }

    public boolean isShowMedia() {
        return showMedia;
    }

    public void setShowMedia(boolean showMedia) {
        this.showMedia = showMedia;
    }

    public SubredditData withShowMedia(boolean showMedia) {
        this.showMedia = showMedia;
        return this;
    }

    public String getBannerBackgroundColor() {
        return bannerBackgroundColor;
    }

    public void setBannerBackgroundColor(String bannerBackgroundColor) {
        this.bannerBackgroundColor = bannerBackgroundColor;
    }

    public SubredditData withBannerBackgroundColor(String bannerBackgroundColor) {
        this.bannerBackgroundColor = bannerBackgroundColor;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubredditData withDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isUserIsMuted() {
        return userIsMuted;
    }

    public void setUserIsMuted(boolean userIsMuted) {
        this.userIsMuted = userIsMuted;
    }

    public SubredditData withUserIsMuted(boolean userIsMuted) {
        this.userIsMuted = userIsMuted;
        return this;
    }

    public String getUserFlairType() {
        return userFlairType;
    }

    public void setUserFlairType(String userFlairType) {
        this.userFlairType = userFlairType;
    }

    public SubredditData withUserFlairType(String userFlairType) {
        this.userFlairType = userFlairType;
        return this;
    }

    public Object getUserCanFlairInSr() {
        return userCanFlairInSr;
    }

    public void setUserCanFlairInSr(Object userCanFlairInSr) {
        this.userCanFlairInSr = userCanFlairInSr;
    }

    public SubredditData withUserCanFlairInSr(Object userCanFlairInSr) {
        this.userCanFlairInSr = userCanFlairInSr;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public SubredditData withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public SubredditData withHeaderImg(String headerImg) {
        this.headerImg = headerImg;
        return this;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    public SubredditData withDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SubredditData withTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isCollapseDeletedComments() {
        return collapseDeletedComments;
    }

    public void setCollapseDeletedComments(boolean collapseDeletedComments) {
        this.collapseDeletedComments = collapseDeletedComments;
    }

    public SubredditData withCollapseDeletedComments(boolean collapseDeletedComments) {
        this.collapseDeletedComments = collapseDeletedComments;
        return this;
    }

    public boolean isUserHasFavorited() {
        return userHasFavorited;
    }

    public void setUserHasFavorited(boolean userHasFavorited) {
        this.userHasFavorited = userHasFavorited;
    }

    public SubredditData withUserHasFavorited(boolean userHasFavorited) {
        this.userHasFavorited = userHasFavorited;
        return this;
    }

    public Object getEmojisCustomSize() {
        return emojisCustomSize;
    }

    public void setEmojisCustomSize(Object emojisCustomSize) {
        this.emojisCustomSize = emojisCustomSize;
    }

    public SubredditData withEmojisCustomSize(Object emojisCustomSize) {
        this.emojisCustomSize = emojisCustomSize;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SubredditData withId(String id) {
        this.id = id;
        return this;
    }

    public boolean isEmojisEnabled() {
        return emojisEnabled;
    }

    public void setEmojisEnabled(boolean emojisEnabled) {
        this.emojisEnabled = emojisEnabled;
    }

    public SubredditData withEmojisEnabled(boolean emojisEnabled) {
        this.emojisEnabled = emojisEnabled;
        return this;
    }

    public String getPublicDescriptionHtml() {
        return publicDescriptionHtml;
    }

    public void setPublicDescriptionHtml(String publicDescriptionHtml) {
        this.publicDescriptionHtml = publicDescriptionHtml;
    }

    public SubredditData withPublicDescriptionHtml(String publicDescriptionHtml) {
        this.publicDescriptionHtml = publicDescriptionHtml;
        return this;
    }

    public boolean isCanAssignUserFlair() {
        return canAssignUserFlair;
    }

    public void setCanAssignUserFlair(boolean canAssignUserFlair) {
        this.canAssignUserFlair = canAssignUserFlair;
    }

    public SubredditData withCanAssignUserFlair(boolean canAssignUserFlair) {
        this.canAssignUserFlair = canAssignUserFlair;
        return this;
    }

    public boolean isAllowVideos() {
        return allowVideos;
    }

    public void setAllowVideos(boolean allowVideos) {
        this.allowVideos = allowVideos;
    }

    public SubredditData withAllowVideos(boolean allowVideos) {
        this.allowVideos = allowVideos;
        return this;
    }

    public boolean isSpoilersEnabled() {
        return spoilersEnabled;
    }

    public void setSpoilersEnabled(boolean spoilersEnabled) {
        this.spoilersEnabled = spoilersEnabled;
    }

    public SubredditData withSpoilersEnabled(boolean spoilersEnabled) {
        this.spoilersEnabled = spoilersEnabled;
        return this;
    }

    public Object getIconSize() {
        return iconSize;
    }

    public void setIconSize(Object iconSize) {
        this.iconSize = iconSize;
    }

    public SubredditData withIconSize(Object iconSize) {
        this.iconSize = iconSize;
        return this;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public SubredditData withPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
        return this;
    }

    public boolean isUserIsContributor() {
        return userIsContributor;
    }

    public void setUserIsContributor(boolean userIsContributor) {
        this.userIsContributor = userIsContributor;
    }

    public SubredditData withUserIsContributor(boolean userIsContributor) {
        this.userIsContributor = userIsContributor;
        return this;
    }

    public String getAudienceTarget() {
        return audienceTarget;
    }

    public void setAudienceTarget(String audienceTarget) {
        this.audienceTarget = audienceTarget;
    }

    public SubredditData withAudienceTarget(String audienceTarget) {
        this.audienceTarget = audienceTarget;
        return this;
    }

    public Object getSuggestedCommentSort() {
        return suggestedCommentSort;
    }

    public void setSuggestedCommentSort(Object suggestedCommentSort) {
        this.suggestedCommentSort = suggestedCommentSort;
    }

    public SubredditData withSuggestedCommentSort(Object suggestedCommentSort) {
        this.suggestedCommentSort = suggestedCommentSort;
        return this;
    }

    public Object getActiveUserCount() {
        return activeUserCount;
    }

    public void setActiveUserCount(Object activeUserCount) {
        this.activeUserCount = activeUserCount;
    }

    public SubredditData withActiveUserCount(Object activeUserCount) {
        this.activeUserCount = activeUserCount;
        return this;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public SubredditData withIconImg(String iconImg) {
        this.iconImg = iconImg;
        return this;
    }

    public boolean isOriginalContentTagEnabled() {
        return originalContentTagEnabled;
    }

    public void setOriginalContentTagEnabled(boolean originalContentTagEnabled) {
        this.originalContentTagEnabled = originalContentTagEnabled;
    }

    public SubredditData withOriginalContentTagEnabled(boolean originalContentTagEnabled) {
        this.originalContentTagEnabled = originalContentTagEnabled;
        return this;
    }

    public String getDisplayNamePrefixed() {
        return displayNamePrefixed;
    }

    public void setDisplayNamePrefixed(String displayNamePrefixed) {
        this.displayNamePrefixed = displayNamePrefixed;
    }

    public SubredditData withDisplayNamePrefixed(String displayNamePrefixed) {
        this.displayNamePrefixed = displayNamePrefixed;
        return this;
    }

    public boolean isCanAssignLinkFlair() {
        return canAssignLinkFlair;
    }

    public void setCanAssignLinkFlair(boolean canAssignLinkFlair) {
        this.canAssignLinkFlair = canAssignLinkFlair;
    }

    public SubredditData withCanAssignLinkFlair(boolean canAssignLinkFlair) {
        this.canAssignLinkFlair = canAssignLinkFlair;
        return this;
    }

    public String getSubmitText() {
        return submitText;
    }

    public void setSubmitText(String submitText) {
        this.submitText = submitText;
    }

    public SubredditData withSubmitText(String submitText) {
        this.submitText = submitText;
        return this;
    }

    public boolean isAllowVideogifs() {
        return allowVideogifs;
    }

    public void setAllowVideogifs(boolean allowVideogifs) {
        this.allowVideogifs = allowVideogifs;
    }

    public SubredditData withAllowVideogifs(boolean allowVideogifs) {
        this.allowVideogifs = allowVideogifs;
        return this;
    }

    public Object getUserFlairTextColor() {
        return userFlairTextColor;
    }

    public void setUserFlairTextColor(Object userFlairTextColor) {
        this.userFlairTextColor = userFlairTextColor;
    }

    public SubredditData withUserFlairTextColor(Object userFlairTextColor) {
        this.userFlairTextColor = userFlairTextColor;
        return this;
    }

    public Object getAccountsActive() {
        return accountsActive;
    }

    public void setAccountsActive(Object accountsActive) {
        this.accountsActive = accountsActive;
    }

    public SubredditData withAccountsActive(Object accountsActive) {
        this.accountsActive = accountsActive;
        return this;
    }

    public boolean isPublicTraffic() {
        return publicTraffic;
    }

    public void setPublicTraffic(boolean publicTraffic) {
        this.publicTraffic = publicTraffic;
    }

    public SubredditData withPublicTraffic(boolean publicTraffic) {
        this.publicTraffic = publicTraffic;
        return this;
    }

    public List<Integer> getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(List<Integer> headerSize) {
        this.headerSize = headerSize;
    }

    public SubredditData withHeaderSize(List<Integer> headerSize) {
        this.headerSize = headerSize;
        return this;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public SubredditData withSubscribers(int subscribers) {
        this.subscribers = subscribers;
        return this;
    }

    public String getUserFlairPosition() {
        return userFlairPosition;
    }

    public void setUserFlairPosition(String userFlairPosition) {
        this.userFlairPosition = userFlairPosition;
    }

    public SubredditData withUserFlairPosition(String userFlairPosition) {
        this.userFlairPosition = userFlairPosition;
        return this;
    }

    public Object getSubmitTextLabel() {
        return submitTextLabel;
    }

    public void setSubmitTextLabel(Object submitTextLabel) {
        this.submitTextLabel = submitTextLabel;
    }

    public SubredditData withSubmitTextLabel(Object submitTextLabel) {
        this.submitTextLabel = submitTextLabel;
        return this;
    }

    public String getKeyColor() {
        return keyColor;
    }

    public void setKeyColor(String keyColor) {
        this.keyColor = keyColor;
    }

    public SubredditData withKeyColor(String keyColor) {
        this.keyColor = keyColor;
        return this;
    }

    public String getLinkFlairPosition() {
        return linkFlairPosition;
    }

    public void setLinkFlairPosition(String linkFlairPosition) {
        this.linkFlairPosition = linkFlairPosition;
    }

    public SubredditData withLinkFlairPosition(String linkFlairPosition) {
        this.linkFlairPosition = linkFlairPosition;
        return this;
    }

    public List<Object> getUserFlairRichtext() {
        return userFlairRichtext;
    }

    public void setUserFlairRichtext(List<Object> userFlairRichtext) {
        this.userFlairRichtext = userFlairRichtext;
    }

    public SubredditData withUserFlairRichtext(List<Object> userFlairRichtext) {
        this.userFlairRichtext = userFlairRichtext;
        return this;
    }

    public boolean isAllOriginalContent() {
        return allOriginalContent;
    }

    public void setAllOriginalContent(boolean allOriginalContent) {
        this.allOriginalContent = allOriginalContent;
    }

    public SubredditData withAllOriginalContent(boolean allOriginalContent) {
        this.allOriginalContent = allOriginalContent;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public SubredditData withLang(String lang) {
        this.lang = lang;
        return this;
    }

    public boolean isHasMenuWidget() {
        return hasMenuWidget;
    }

    public void setHasMenuWidget(boolean hasMenuWidget) {
        this.hasMenuWidget = hasMenuWidget;
    }

    public SubredditData withHasMenuWidget(boolean hasMenuWidget) {
        this.hasMenuWidget = hasMenuWidget;
        return this;
    }

    public Object getIsEnrolledInNewModmail() {
        return isEnrolledInNewModmail;
    }

    public void setIsEnrolledInNewModmail(Object isEnrolledInNewModmail) {
        this.isEnrolledInNewModmail = isEnrolledInNewModmail;
    }

    public SubredditData withIsEnrolledInNewModmail(Object isEnrolledInNewModmail) {
        this.isEnrolledInNewModmail = isEnrolledInNewModmail;
        return this;
    }

    public String getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(String whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    public SubredditData withWhitelistStatus(String whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubredditData withName(String name) {
        this.name = name;
        return this;
    }

    public boolean isUserFlairEnabledInSr() {
        return userFlairEnabledInSr;
    }

    public void setUserFlairEnabledInSr(boolean userFlairEnabledInSr) {
        this.userFlairEnabledInSr = userFlairEnabledInSr;
    }

    public SubredditData withUserFlairEnabledInSr(boolean userFlairEnabledInSr) {
        this.userFlairEnabledInSr = userFlairEnabledInSr;
        return this;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public SubredditData withCreated(double created) {
        this.created = created;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SubredditData withUrl(String url) {
        this.url = url;
        return this;
    }

    public Object getSubmitLinkLabel() {
        return submitLinkLabel;
    }

    public void setSubmitLinkLabel(Object submitLinkLabel) {
        this.submitLinkLabel = submitLinkLabel;
    }

    public SubredditData withSubmitLinkLabel(Object submitLinkLabel) {
        this.submitLinkLabel = submitLinkLabel;
        return this;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

    public SubredditData withQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
        return this;
    }

    public boolean isHideAds() {
        return hideAds;
    }

    public void setHideAds(boolean hideAds) {
        this.hideAds = hideAds;
    }

    public SubredditData withHideAds(boolean hideAds) {
        this.hideAds = hideAds;
        return this;
    }

    public double getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
    }

    public SubredditData withCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
        return this;
    }

    public Object getBannerSize() {
        return bannerSize;
    }

    public void setBannerSize(Object bannerSize) {
        this.bannerSize = bannerSize;
    }

    public SubredditData withBannerSize(Object bannerSize) {
        this.bannerSize = bannerSize;
        return this;
    }

    public boolean isUserIsModerator() {
        return userIsModerator;
    }

    public void setUserIsModerator(boolean userIsModerator) {
        this.userIsModerator = userIsModerator;
    }

    public SubredditData withUserIsModerator(boolean userIsModerator) {
        this.userIsModerator = userIsModerator;
        return this;
    }

    public Object getUserSrFlairEnabled() {
        return userSrFlairEnabled;
    }

    public void setUserSrFlairEnabled(Object userSrFlairEnabled) {
        this.userSrFlairEnabled = userSrFlairEnabled;
    }

    public SubredditData withUserSrFlairEnabled(Object userSrFlairEnabled) {
        this.userSrFlairEnabled = userSrFlairEnabled;
        return this;
    }

    public boolean isAllowDiscovery() {
        return allowDiscovery;
    }

    public void setAllowDiscovery(boolean allowDiscovery) {
        this.allowDiscovery = allowDiscovery;
    }

    public SubredditData withAllowDiscovery(boolean allowDiscovery) {
        this.allowDiscovery = allowDiscovery;
        return this;
    }

    public boolean isAccountsActiveIsFuzzed() {
        return accountsActiveIsFuzzed;
    }

    public void setAccountsActiveIsFuzzed(boolean accountsActiveIsFuzzed) {
        this.accountsActiveIsFuzzed = accountsActiveIsFuzzed;
    }

    public SubredditData withAccountsActiveIsFuzzed(boolean accountsActiveIsFuzzed) {
        this.accountsActiveIsFuzzed = accountsActiveIsFuzzed;
        return this;
    }

    public String getAdvertiserCategory() {
        return advertiserCategory;
    }

    public void setAdvertiserCategory(String advertiserCategory) {
        this.advertiserCategory = advertiserCategory;
    }

    public SubredditData withAdvertiserCategory(String advertiserCategory) {
        this.advertiserCategory = advertiserCategory;
        return this;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public SubredditData withPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
        return this;
    }

    public boolean isLinkFlairEnabled() {
        return linkFlairEnabled;
    }

    public void setLinkFlairEnabled(boolean linkFlairEnabled) {
        this.linkFlairEnabled = linkFlairEnabled;
    }

    public SubredditData withLinkFlairEnabled(boolean linkFlairEnabled) {
        this.linkFlairEnabled = linkFlairEnabled;
        return this;
    }

    public boolean isAllowImages() {
        return allowImages;
    }

    public void setAllowImages(boolean allowImages) {
        this.allowImages = allowImages;
    }

    public SubredditData withAllowImages(boolean allowImages) {
        this.allowImages = allowImages;
        return this;
    }

    public boolean isShowMediaPreview() {
        return showMediaPreview;
    }

    public void setShowMediaPreview(boolean showMediaPreview) {
        this.showMediaPreview = showMediaPreview;
    }

    public SubredditData withShowMediaPreview(boolean showMediaPreview) {
        this.showMediaPreview = showMediaPreview;
        return this;
    }

    public int getCommentScoreHideMins() {
        return commentScoreHideMins;
    }

    public void setCommentScoreHideMins(int commentScoreHideMins) {
        this.commentScoreHideMins = commentScoreHideMins;
    }

    public SubredditData withCommentScoreHideMins(int commentScoreHideMins) {
        this.commentScoreHideMins = commentScoreHideMins;
        return this;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public SubredditData withSubredditType(String subredditType) {
        this.subredditType = subredditType;
        return this;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    public SubredditData withSubmissionType(String submissionType) {
        this.submissionType = submissionType;
        return this;
    }

    public boolean isUserIsSubscriber() {
        return userIsSubscriber;
    }

    public void setUserIsSubscriber(boolean userIsSubscriber) {
        this.userIsSubscriber = userIsSubscriber;
    }

    public SubredditData withUserIsSubscriber(boolean userIsSubscriber) {
        this.userIsSubscriber = userIsSubscriber;
        return this;
    }

}