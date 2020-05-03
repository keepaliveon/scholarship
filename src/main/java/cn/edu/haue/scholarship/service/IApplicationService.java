package cn.edu.haue.scholarship.service;

import cn.edu.haue.scholarship.entity.Application;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 申请 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface IApplicationService extends IService<Application> {
    List<Application> listPublicity();
}
