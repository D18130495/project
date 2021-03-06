package com.shun.eduservice.entity.subject;

public class TwoSubject {
    private String id;
    private String title;

    public TwoSubject() {
    }

    public TwoSubject(String id, String title) {
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
        return "OneSubject{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
