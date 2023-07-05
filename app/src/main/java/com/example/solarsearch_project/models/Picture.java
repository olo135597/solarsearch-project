package com.example.solarsearch_project.models;

public class Picture {
    String url;

    String title;
    String copyright;

    public Picture(String url, String title, String copyright) {
        this.url = url;

        this.title = title;
        this.copyright = copyright;
    }

    public Picture() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }



}
