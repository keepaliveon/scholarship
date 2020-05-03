package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Scholarship;
import cn.edu.haue.scholarship.mapper.ScholarshipMapper;
import cn.edu.haue.scholarship.service.IScholarshipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 奖学金 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Service
public class ScholarshipServiceImpl extends ServiceImpl<ScholarshipMapper, Scholarship> implements IScholarshipService {

    @Resource
    private ScholarshipMapper scholarshipMapper;

    @Override
    public List<Scholarship> findAll() {
        return scholarshipMapper.findAll();
    }
}
