package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Scholarship;
import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.service.IScholarshipService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
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

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Scholarship scholarship) {
        if (scholarshipService.save(scholarship)) {
            return new ResponseEntity<>("创建成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("创建失败", HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Scholarship>> list() {
        return new ResponseEntity<>(scholarshipService.findAll(), HttpStatus.OK);
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

