package cn.edu.haue.scholarship.service.impl;

import cn.edu.haue.scholarship.entity.Unit;
import cn.edu.haue.scholarship.mapper.UnitMapper;
import cn.edu.haue.scholarship.service.IUnitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 组织单位 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements IUnitService {

    @Resource
    private UnitMapper unitMapper;

    @Override
    public List<Unit> getTree(Integer id) {
        return unitMapper.getTree(id);
    }

    @Override
    public List<Unit> getNoRootTree(Integer id) {
        return unitMapper.getTree(id).get(0).getChildren();
    }

    @Override
    public List<Unit> getFirstUnit() {
        return unitMapper.getFirstUnit();
    }
}
