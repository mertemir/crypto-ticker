package com.example.basics.cryptoticker.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class News {

    public String status;
    public int totalResults;
    public List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public class Article
    {
        public String title;
        public String description;
        public String url;
        @SerializedName("urlToImage")
        @Expose
        public String urlToImage;

        public String getUrlToImage() { return urlToImage; }

        public void setUrlToImage(String urlToImage) { this.urlToImage = urlToImage; }

        public String getUrl() { return url; }

        public void setUrl(String url) { this.url = url; }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

}
