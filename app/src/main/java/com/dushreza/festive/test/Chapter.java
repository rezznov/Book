package com.dushreza.festive.test;

public class Chapter {
    int id;
    String title;
    String content;
    String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Chapter(int id, String title, String content, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
    }
}