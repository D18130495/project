package com.shun.eduservice.controller;


import com.shun.eduservice.entity.EduTeacher;
import com.shun.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 画若雨幕
 * @since 2021-07-03
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("/findAll")
    public List<EduTeacher> findAllTeacher() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }

    @DeleteMapping("/{id}")
    public boolean deleteTeacher(@PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        return flag;
    }

}

