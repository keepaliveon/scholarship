package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Grade;
import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.mapper.GradeMapper;
import cn.edu.haue.scholarship.service.IGradeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public String upload(List<Grade> grades, String year) {
        int add = 0;
        int update = 0;

        Map<String, Object> columnMap = new HashMap<>();

        for (Grade item : grades) {
            item.setYear(year);
            columnMap.put("student_id", item.getStudentId());
            columnMap.put("year", item.getYear());
            QueryWrapper<Grade> queryWrapper = new QueryWrapper<>();
            queryWrapper.allEq(columnMap);
            Grade grade = gradeMapper.selectOne(queryWrapper);
            if (grade == null) {
                gradeMapper.insert(item);
                add++;
            } else {
                UpdateWrapper<Grade> updateWrapper = new UpdateWrapper<>();
                updateWrapper.allEq(columnMap);
                gradeMapper.update(item, updateWrapper);
                update++;
            }
        }
        return "成功添加" + add + "条记录" + "更新" + update + "条记录";
    }

    @Override
    public Grade getStudentInfo(String studentId, String year) {
        return gradeMapper.getStudentGradeInfoByStudentIdAndYear(studentId, year);
    }

}
