package cn.edu.haue.scholarship.service;

import cn.edu.haue.scholarship.entity.Unit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 组织单位 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface IUnitService extends IService<Unit> {

    List<Unit> getTree(Integer id);

    List<Unit> getNoRootTree(Integer id);
}

