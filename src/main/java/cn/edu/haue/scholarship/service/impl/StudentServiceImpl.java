package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.mapper.StudentMapper;
import cn.edu.haue.scholarship.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-11
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
