package com.shun.eduservice.entity.vo;

public class TeacherQuery {
    private String name;
    private Integer level;
    private String begin;
    private String end;

    public TeacherQuery() {
    }

    public TeacherQuery(String name, Integer level, String begin, String end) {
        this.name = name;
        this.level = level;
        this.begin = begin;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
