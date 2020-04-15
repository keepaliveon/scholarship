package cn.edu.haue.scholarship.mapper;

import cn.edu.haue.scholarship.entity.Unit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 组织单位 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface UnitMapper extends BaseMapper<Unit> {
    List<Unit> getTree();
}
