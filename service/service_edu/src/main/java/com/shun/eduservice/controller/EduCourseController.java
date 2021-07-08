package com.shun.eduservice.controller;


import com.shun.commonutils.R;
import com.shun.eduservice.entity.EduTeacher;
import com.shun.eduservice.entity.vo.CourseInfoVo;
import com.shun.eduservice.service.EduCourseService;
import com.shun.eduservice.service.impl.EduCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author 画若雨幕
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String id = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("id", id);
    }
}

