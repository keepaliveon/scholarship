package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Grade;
import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.mapper.GradeMapper;
import cn.edu.haue.scholarship.service.IGradeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 成绩平均分 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-23
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements IGradeService {

    @Resource
    private GradeMapper gradeMapper;

    @Override
    public IPage<Grade> listByYearUnitId(Page<Student> page, Integer unitId) {
        return gradeMapper.findAllByYearUnitId(page, unitId);
    }
}
