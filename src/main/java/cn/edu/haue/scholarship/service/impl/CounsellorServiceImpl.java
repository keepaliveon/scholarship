package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Counsellor;
import cn.edu.haue.scholarship.mapper.CounsellorMapper;
import cn.edu.haue.scholarship.service.ICounsellorService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 辅导员 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Service
public class CounsellorServiceImpl extends ServiceImpl<CounsellorMapper, Counsellor> implements ICounsellorService {

    @Resource
    private CounsellorMapper counsellorMapper;

    @Override
    public List<Counsellor> listAll() {
        return counsellorMapper.list();
    }
}
