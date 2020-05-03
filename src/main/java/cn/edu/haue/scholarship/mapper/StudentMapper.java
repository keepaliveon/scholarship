package cn.edu.haue.scholarship.mapper;

import cn.edu.haue.scholarship.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 * 学生 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface StudentMapper extends BaseMapper<Student> {

    IPage<Student> findAllByYearUnitId(Page<?> page, Integer unitId);

    Student findStudentById(String id);

}
