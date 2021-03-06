package cn.edu.haue.scholarship;

import cn.edu.haue.scholarship.entity.Admin;
import cn.edu.haue.scholarship.entity.Counsellor;
import cn.edu.haue.scholarship.entity.Grade;
import cn.edu.haue.scholarship.entity.Unit;
import cn.edu.haue.scholarship.mapper.AdminMapper;
import cn.edu.haue.scholarship.mapper.CounsellorMapper;
import cn.edu.haue.scholarship.mapper.GradeMapper;
import cn.edu.haue.scholarship.mapper.UnitMapper;
import cn.edu.haue.scholarship.service.IAdminService;
import cn.edu.haue.scholarship.service.IGradeService;
import cn.edu.haue.scholarship.service.IStudentService;
import cn.edu.haue.scholarship.service.IUnitService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ScholarshipApplicationTests {

    @Resource
    private IAdminService adminService;

    @Resource
    private IStudentService studentService;

    @Resource
    private IUnitService unitService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UnitMapper unitMapper;

    @Resource
    private GradeMapper gradeMapper;

    @Resource
    private CounsellorMapper counsellorMapper;

    @Resource
    private IGradeService gradeService;

    @Autowired
    private StringRedisTemplate redisTemplate;

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
        unitService.save(unit);
    }

    @Test
    void t3() {
        Unit unit2 = new Unit();
        unit2.setName("计算机学院");
        unit2.setPid(1);
        unitService.save(unit2);

        Unit unit3 = new Unit();
        unit3.setName("电气信息工程学院");
        unit3.setPid(1);
        unitService.save(unit3);

        Unit unit4 = new Unit();
        unit4.setName("机械工程学院");
        unit4.setPid(1);
        unitService.save(unit4);
    }

    @Test
    void t4() {
        Unit unit0 = new Unit();
        unit0.setPid(2);
        unit0.setName("2015级");
        unitService.save(unit0);

        Unit unit3 = new Unit();
        unit3.setPid(2);
        unit3.setName("2016级");
        unitService.save(unit3);

        Unit unit2 = new Unit();
        unit2.setPid(2);
        unit2.setName("2017级");
        unitService.save(unit2);
    }

    @Test
    void t5() {
        List<Unit> tree = unitMapper.getTree(1);
        System.out.println(tree);
    }

    @Test
    void t6() {
        List<Counsellor> list = counsellorMapper.list();
        for (Counsellor counsellor : list) {
            System.out.println(counsellor);
        }
    }

    @Test
    void t7() {
        Grade grade = new Grade();
        grade.setStudentId("201612211415");
        grade.setYear("2019-2021");
        grade.setScore(100f);
        UpdateWrapper<Grade> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("student_id", grade.getStudentId()).eq("year", grade.getYear());
        gradeService.saveOrUpdate(grade, updateWrapper);
    }

    @Test
    void t8() {
        QueryWrapper<Grade> queryWrapper = new QueryWrapper<>();
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("student_id", "201610321220");
        columnMap.put("year", "2018-2019");
        queryWrapper.allEq(columnMap);
        Grade grade = gradeMapper.selectOne(queryWrapper);
        System.out.println(grade);
    }

    @Test
    void t9() {
        Grade grade = gradeMapper.getStudentGradeInfoByStudentIdAndYear("201612211415", "2018-2019");
        System.out.println(grade);
    }

    @Test
    void t10() {
        redisTemplate.opsForValue().set("year", "2018-2019");
    }

    @Test
    void t12() {
        redisTemplate.opsForValue().set("year", "2019-2020");
    }

    @Test
    void t11() {
        System.out.println(redisTemplate.opsForValue().get("year"));
    }

    @Test
    void t13() {
        redisTemplate.opsForList().leftPush("years", "2019-2020");
        redisTemplate.opsForList().leftPush("years", "2018-2019");
        redisTemplate.opsForList().leftPush("years", "2017-2018");
        redisTemplate.opsForList().leftPush("years", "2016-2017");
    }

    @Test
    void t14() {
        Long size = redisTemplate.opsForList().size("years");
        List<String> years = redisTemplate.opsForList().range("years", 0L, size - 1);
        System.out.println(years);
    }

    @Test
    void t15() {
    }

}
