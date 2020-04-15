package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Application;
import cn.edu.haue.scholarship.mapper.ApplicationMapper;
import cn.edu.haue.scholarship.service.IApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 申请 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements IApplicationService {

}
