package com.shun.eduservice.entity.subject;

import java.util.ArrayList;
import java.util.List;

public class OneSubject {
    private String id;
    private String title;

    private List<TwoSubject> children = new ArrayList<TwoSubject>();

    public OneSubject() {
    }

    public OneSubject(String id, String title, List<TwoSubject> children) {
        this.id = id;
        this.title = title;
        this.children = children;
    }

    public OneSubject(String id, String title) {
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

    public List<TwoSubject> getChildren() {
        return children;
    }

    public void setChildren(List<TwoSubject> children) {
        this.children = children;
    }

    public String toString() {
        return "OneSubject{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", children=" + children +
                '}';
    }
}
