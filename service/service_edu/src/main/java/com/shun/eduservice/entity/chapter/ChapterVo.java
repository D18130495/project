package com.shun.eduservice.entity.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterVo {
    private String id;

    private String title;

    private List<VideoVo> children = new ArrayList<VideoVo>();

    public ChapterVo() {
    }

    public ChapterVo(String id, String title, List<VideoVo> children) {
        this.id = id;
        this.title = title;
        this.children = children;
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

    public List<VideoVo> getChildren() {
        return children;
    }

    public void setChildren(List<VideoVo> children) {
        this.children = children;
    }

    public String toString() {
        return "ChapterVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", children=" + children +
                '}';
    }
}
