package cn.edu.haue.scholarship.service;

import cn.edu.haue.scholarship.entity.Student;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 学生 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface IStudentService extends IService<Student> {

    IPage<Student> listByYearUnitId(Page<Student> page, Integer unitId);

    Student findStudentById(String id);
}
