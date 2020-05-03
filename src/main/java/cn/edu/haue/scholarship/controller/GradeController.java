package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Grade;
import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.service.IGradeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 成绩平均分 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/api/grade")
public class GradeController {

    @Resource
    private IGradeService gradeService;

    @PostMapping("{year}")
    public ResponseEntity<?> upload(@RequestBody List<Grade> data, @PathVariable("year") String year) {
        return new ResponseEntity<>(gradeService.upload(data, year), HttpStatus.OK);
    }

    @GetMapping("{unitId}")
    public ResponseEntity<IPage<Grade>> list(@PathVariable("unitId") Integer unitId, Long current, Long size) {
        Page<Student> page = new Page<>(current, size);
        return new ResponseEntity<>(gradeService.listByYearUnitId(page, unitId), HttpStatus.OK);
    }

    @DeleteMapping("{id}/{year}")
    public ResponseEntity<String> delete(@PathVariable("id") String id, @PathVariable String year) {
        QueryWrapper<Grade> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", id).eq("year", year);
        boolean b = gradeService.remove(queryWrapper);
        if (b) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败", HttpStatus.OK);
        }
    }
}

