package com.shun.eduservice.entity.chapter;

public class VideoVo {
    private String id;

    private String title;

    public VideoVo() {
    }

    public VideoVo(String id, String title) {
        this.id = id;
        this.title = title;
    }

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

    public String toString() {
        return "VideoVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

