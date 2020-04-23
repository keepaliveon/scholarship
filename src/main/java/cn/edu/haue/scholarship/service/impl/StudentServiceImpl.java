package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.mapper.StudentMapper;
import cn.edu.haue.scholarship.service.IStudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public IPage<Student> listByYearUnitId(Page<Student> page, Integer unitId) {
        return studentMapper.findAllByYearUnitId(page, unitId);
    }

}
