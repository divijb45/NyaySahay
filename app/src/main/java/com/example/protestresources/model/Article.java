package com.example.protestresources.model;

public class Article {

    private String title;
    private String subtitle;
    private String content;

    public Article() {}

    public Article(String title, String subtitle, String content) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getContent() {
        return content;
    }

}