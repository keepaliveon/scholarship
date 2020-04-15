package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Distribution;
import cn.edu.haue.scholarship.mapper.DistributionMapper;
import cn.edu.haue.scholarship.service.IDistributionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 名额分配 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Service
public class DistributionServiceImpl extends ServiceImpl<DistributionMapper, Distribution> implements IDistributionService {

}
