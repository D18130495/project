package com.shun.eduservice.service;

import com.shun.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shun.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 画若雨幕
 * @since 2021-07-07
 */
public interface EduCourseService extends IService<EduCourse> {
    String saveCourseInfo(CourseInfoVo courseInfoVo);
}
