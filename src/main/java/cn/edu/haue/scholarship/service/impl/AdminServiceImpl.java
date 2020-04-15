package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Admin;
import cn.edu.haue.scholarship.mapper.AdminMapper;
import cn.edu.haue.scholarship.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生资助中心管理员 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
