package com.ruksana.model;

public class Model_For_Video {

    String name,category,videoLink;

    public Model_For_Video() {
    }

    public Model_For_Video(String name, String category, String videoLink) {
        this.name = name;
        this.category = category;
        this.videoLink = videoLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
}
