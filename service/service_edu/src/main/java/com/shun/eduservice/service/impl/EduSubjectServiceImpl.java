package com.shun.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shun.eduservice.entity.EduSubject;
import com.shun.eduservice.entity.excel.SubjectData;
import com.shun.eduservice.entity.subject.OneSubject;
import com.shun.eduservice.entity.subject.TwoSubject;
import com.shun.eduservice.listener.SubjectExcelListener;
import com.shun.eduservice.mapper.EduSubjectMapper;
import com.shun.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author 画若雨幕
 * @since 2021-07-06
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream in = file.getInputStream();
            EasyExcel.read(in, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OneSubject> getAllOneTwoSubject() {
        QueryWrapper<EduSubject> wrapper1 = new QueryWrapper<EduSubject>();
        wrapper1.eq("parent_id", "0");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapper1);

        QueryWrapper<EduSubject> wrapper2 = new QueryWrapper<EduSubject>();
        wrapper2.ne("parent_id", "0");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapper2);

        List<OneSubject> finalSubjectList = new ArrayList<>();

        for(int i = 0; i < oneSubjectList.size(); i++) {
            EduSubject eduSubject1 = oneSubjectList.get(i);

            OneSubject oneSubject = new OneSubject();
            oneSubject.setId(eduSubject1.getId());
            oneSubject.setTitle(eduSubject1.getTitle());
//            BeanUtils.copyProperties(eduSubject, oneSubject);
            finalSubjectList.add(oneSubject);


            List<TwoSubject> twoFinalSubjectLits = new ArrayList<>();

            for(int j = 0; j < twoSubjectList.size(); j++) {
                EduSubject eduSubject2 = twoSubjectList.get(j);

                TwoSubject twoSubject = new TwoSubject();
                twoSubject.setId(eduSubject2.getId());
                twoSubject.setTitle(eduSubject2.getTitle());

                if(eduSubject1.getId().equals(eduSubject2.getParentId())) {
                    twoFinalSubjectLits.add(twoSubject);
                }
            }

            oneSubject.setChildren(twoFinalSubjectLits);
        }

        return finalSubjectList;
    }
}
