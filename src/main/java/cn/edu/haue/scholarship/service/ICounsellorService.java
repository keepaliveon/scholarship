package cn.edu.haue.scholarship.service;

import cn.edu.haue.scholarship.entity.Counsellor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 辅导员 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface ICounsellorService extends IService<Counsellor> {

    List<Counsellor> listAll();
}
