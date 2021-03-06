package cn.edu.haue.scholarship.service;

import cn.edu.haue.scholarship.entity.Scholarship;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 奖学金 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
public interface IScholarshipService extends IService<Scholarship> {
    List<Scholarship> findAll();

    List<Scholarship> findYear(String year);
}
