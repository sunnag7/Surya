
package com.sun.surya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article {

    @SerializedName("topHeading")
    @Expose
    private String topHeading;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("articleId")
    @Expose
    private Integer articleId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ingress")
    @Expose
    private String ingress = "";
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("publisherUrl")
    @Expose
    private String publisherUrl;
    @SerializedName("claimedEstatesAffected")
    @Expose
    private List<ClaimedEstatesAffected> claimedEstatesAffected = null;
    @SerializedName("followingEstatesEffected")
    @Expose
    private List<FollowingEstatesAffected> followingEstatesEffected = null;
    @SerializedName("dateOrder")
    @Expose
    private String dateOrder;
    @SerializedName("dateOrderFormatted")
    @Expose
    private String dateOrderFormatted;
    @SerializedName("header")
    @Expose
    private Header header;

    public String getTopHeading() {
        return topHeading;
    }

    public void setTopHeading(String topHeading) {
        this.topHeading = topHeading;
    }

    public String getType() {
        return ""+type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return ""+title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngress() {
        return (""+ingress).replace("null","");
    }

    public void setIngress(String ingress) {
        this.ingress = ingress;
    }

    public String getImageUrl() {
        return ""+imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return ""+url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublisher() {
        return ""+publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherUrl() {
        return publisherUrl;
    }

    public void setPublisherUrl(String publisherUrl) {
        this.publisherUrl = publisherUrl;
    }

    public List<ClaimedEstatesAffected> getClaimedEstatesAffected() {
        return claimedEstatesAffected;
    }

    public void setClaimedEstatesAffected(List<ClaimedEstatesAffected> claimedEstatesAffected) {
        this.claimedEstatesAffected = claimedEstatesAffected;
    }

    public List<FollowingEstatesAffected> getFollowingEstatesEffected() {
        return followingEstatesEffected;
    }

    public void setFollowingEstatesEffected(List<FollowingEstatesAffected> followingEstatesEffected) {
        this.followingEstatesEffected = followingEstatesEffected;
    }

    public String getDateOrder() {
        return ""+dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getDateOrderFormatted() {
        return dateOrderFormatted;
    }

    public void setDateOrderFormatted(String dateOrderFormatted) {
        this.dateOrderFormatted = dateOrderFormatted;
    }
}