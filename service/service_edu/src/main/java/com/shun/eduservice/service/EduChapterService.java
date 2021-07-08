package com.shun.eduservice.service;

import com.shun.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shun.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 画若雨幕
 * @since 2021-07-07
 */
public interface EduChapterService extends IService<EduChapter> {
    List<ChapterVo> getChapterVideoByCourseId(String courseId);
}
