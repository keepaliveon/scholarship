package cn.edu.haue.scholarship.service;

import cn.edu.haue.scholarship.entity.Grade;
import cn.edu.haue.scholarship.entity.Student;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 成绩平均分 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-23
 */
public interface IGradeService extends IService<Grade> {
    IPage<Grade> listByYearUnitId(Page<Student> page, Integer unitId);
}
