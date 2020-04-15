package cn.edu.haue.scholarship;

import cn.edu.haue.scholarship.entity.Admin;
import cn.edu.haue.scholarship.entity.Unit;
import cn.edu.haue.scholarship.mapper.AdminMapper;
import cn.edu.haue.scholarship.mapper.UnitMapper;
import cn.edu.haue.scholarship.service.IAdminService;
import cn.edu.haue.scholarship.service.IUnitService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ScholarshipApplicationTests {

    @Resource
    private IAdminService adminService;

    @Resource
    private IUnitService unitService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UnitMapper unitMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void t1() {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        adminService.saveOrUpdate(admin);
    }

    @Test
    void t2() {
        Unit unit = new Unit();
        unit.setName("河南工程学院");
        unit.setLevel(0);
        unitService.save(unit);
    }

    @Test
    void t3() {
        Unit unit2 = new Unit();
        unit2.setName("计算机学院");
        unit2.setLevel(1);
        unit2.setPid(1);
        unitService.save(unit2);

        Unit unit3 = new Unit();
        unit3.setName("电气信息工程学院");
        unit3.setLevel(1);
        unit3.setPid(1);
        unitService.save(unit3);

        Unit unit4 = new Unit();
        unit4.setName("机械工程学院");
        unit4.setLevel(1);
        unit4.setPid(1);
        unitService.save(unit4);
    }

    @Test
    void t4() {
        Unit unit0 = new Unit();
        unit0.setPid(2);
        unit0.setName("2015级");
        unit0.setLevel(2);
        unitService.save(unit0);

        Unit unit3 = new Unit();
        unit3.setPid(2);
        unit3.setName("2016级");
        unit3.setLevel(2);
        unitService.save(unit3);

        Unit unit2 = new Unit();
        unit2.setPid(2);
        unit2.setName("2017级");
        unit2.setLevel(2);
        unitService.save(unit2);
    }

    @Test
    void t5() {
        List<Unit> tree = unitMapper.getTree();
        System.out.println(tree);
    }

}
