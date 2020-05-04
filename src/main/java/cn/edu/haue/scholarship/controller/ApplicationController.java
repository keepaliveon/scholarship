package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Application;
import cn.edu.haue.scholarship.service.IApplicationService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申请 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/api/application")
public class ApplicationController {
    @Resource
    private IApplicationService applicationService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Application application) {
        boolean save;
        try {
            save = applicationService.save(application);
        } catch (Exception e) {
            e.printStackTrace();
            save = false;
        }
        if (save) {
            return new ResponseEntity<>("提交成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("提交失败,无法重复申请", HttpStatus.OK);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Application application) {
        UpdateWrapper<Application> updateWrapper = new UpdateWrapper<>();
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("student_id", application.getStudentId());
        columnMap.put("scholarship_id", application.getScholarshipId());
        updateWrapper.allEq(columnMap);
        if (applicationService.update(application, updateWrapper)) {
            return new ResponseEntity<>("更新成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("更新失败", HttpStatus.OK);
        }
    }

    @GetMapping("publicity")
    public ResponseEntity<List<Application>> publicity() {
        return new ResponseEntity<>(applicationService.listPublicity(), HttpStatus.OK);
    }

    @GetMapping("judge/{unitId}")
    public ResponseEntity<List<Application>> list(@PathVariable("unitId") Integer unitId) {
        String year = redisTemplate.opsForValue().get("year");
        return new ResponseEntity<>(applicationService.listJudge(year, unitId), HttpStatus.OK);
    }
}

