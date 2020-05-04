package cn.edu.haue.scholarship.mapper;

import cn.edu.haue.scholarship.entity.Scholarship;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 奖学金 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface ScholarshipMapper extends BaseMapper<Scholarship> {
    List<Scholarship> findAll();
    List<Scholarship> findYear(String year);
}
