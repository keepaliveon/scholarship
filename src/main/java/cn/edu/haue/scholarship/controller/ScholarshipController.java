package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Scholarship;
import cn.edu.haue.scholarship.service.IScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 奖学金 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/api/scholarship")
public class ScholarshipController {

    @Resource
    private IScholarshipService scholarshipService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Scholarship scholarship) {
        if (scholarshipService.save(scholarship)) {
            return new ResponseEntity<>("创建成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("创建失败", HttpStatus.OK);
        }
    }

    @PutMapping
    private ResponseEntity<?> update(@RequestBody Scholarship scholarship) {
        if (scholarshipService.updateById(scholarship)) {
            return new ResponseEntity<>("更新成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("更新失败", HttpStatus.OK);
        }
    }

    @GetMapping("all")
    public ResponseEntity<List<Scholarship>> listAll() {
        return new ResponseEntity<>(scholarshipService.findAll(), HttpStatus.OK);
    }

    @GetMapping("year")
    public ResponseEntity<List<Scholarship>> listCurrentYear() {
        String year = redisTemplate.opsForValue().get("year");
        return new ResponseEntity<>(scholarshipService.findYear(year), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(scholarshipService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        String message;
        try {
            scholarshipService.removeById(id);
            message = "删除成功";
        } catch (Exception e) {
            message = "删除失败";
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}

