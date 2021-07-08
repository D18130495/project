package com.shun.eduservice.service;

import com.shun.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shun.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author 画若雨幕
 * @since 2021-07-06
 */
public interface EduSubjectService extends IService<EduSubject> {
    void saveSubject(MultipartFile file, EduSubjectService eduSubjectService);
    List<OneSubject> getAllOneTwoSubject();
}
