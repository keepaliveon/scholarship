package cn.edu.haue.scholarship.mapper;

import cn.edu.haue.scholarship.entity.Application;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 申请 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface ApplicationMapper extends BaseMapper<Application> {

    List<Application> listPublicity();

}
