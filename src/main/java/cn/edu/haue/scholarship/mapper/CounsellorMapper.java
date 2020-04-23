package cn.edu.haue.scholarship.mapper;

import cn.edu.haue.scholarship.entity.Counsellor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 辅导员 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface CounsellorMapper extends BaseMapper<Counsellor> {

    List<Counsellor> list();

}
