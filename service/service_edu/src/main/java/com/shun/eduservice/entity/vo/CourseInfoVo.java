package com.shun.eduservice.entity.vo;

import java.math.BigDecimal;

public class CourseInfoVo {
    private String id;

    private String teacherId;

    private String subjectId;

    private String subjectParentId;

    private String title;

    private BigDecimal price;

    private Integer lessonNum;

    private String cover;

    private String description;

    public CourseInfoVo() {
    }

    public CourseInfoVo(String id, String teacherId, String subjectId, String subjectParentId, String title, BigDecimal price, Integer lessonNum, String cover, String description) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.subjectParentId = subjectParentId;
        this.title = title;
        this.price = price;
        this.lessonNum = lessonNum;
        this.cover = cover;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getSubjectParentId() {
        return subjectParentId;
    }

    public void setSubjectParentId(String subjectParentId) {
        this.subjectParentId = subjectParentId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "CourseInfoVo{" +
                "id='" + id + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", subjectParentId='" + subjectParentId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", lessonNum=" + lessonNum +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
