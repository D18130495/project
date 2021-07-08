package com.shun.eduservice.service.impl;

import com.shun.eduservice.entity.EduChapter;
import com.shun.eduservice.entity.chapter.ChapterVo;
import com.shun.eduservice.mapper.EduChapterMapper;
import com.shun.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author 画若雨幕
 * @since 2021-07-07
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        return null;
    }
}
