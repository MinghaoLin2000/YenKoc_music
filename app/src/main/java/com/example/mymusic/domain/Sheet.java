package com.example.mymusic.domain;

public class Sheet {
    /**
     * 歌单id
     */
        private String id;
    /**
     * 歌单标题
     */
    private String title;
    /**
     * 歌单封面
     */
    private String banner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
