package com.example.newsapplication;

public class NewsModel {
    String content, imageUrl, url;

    public NewsModel(String content, String imageUrl, String url) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
