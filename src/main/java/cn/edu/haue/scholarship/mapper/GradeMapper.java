package cn.edu.haue.scholarship.mapper;

import cn.edu.haue.scholarship.entity.Grade;
import cn.edu.haue.scholarship.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 成绩平均分 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-04-23
 */
public interface GradeMapper extends BaseMapper<Grade> {

    IPage<Grade> findAllByYearUnitId(Page<?> page, Integer unitId);

    Grade getStudentGradeInfoByStudentIdAndYear(@Param("studentId") String id, @Param("year") String year);
}
