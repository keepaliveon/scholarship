package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.security.CurrentUser;
import cn.edu.haue.scholarship.security.UserPrincipal;
import cn.edu.haue.scholarship.service.IStudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 学生 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @ApiOperation("学生导入")
    @PostMapping("{id}")
    public ResponseEntity<?> upload(@RequestBody List<Student> data, @PathVariable Integer id) {
        int count = 0;
        for (Student item : data) {
            item.setPassword(passwordEncoder.encode(item.getIdNumber().substring(item.getIdNumber().length() - 6)));
            item.setUnitId(id);
            try {
                if (studentService.saveOrUpdate(item)) {
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>("成功导入" + count + "条记录", HttpStatus.OK);
    }

    @GetMapping("auth")
    @ApiOperation("从认证上下文获取学生信息")
    public ResponseEntity<Student> auth(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        Student student = studentService.getById(userPrincipal.getUsername());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("获取学生信息")
    public ResponseEntity<Student> student(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        Student student = studentService.findStudentById(userPrincipal.getUsername());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("{unitId}")
    public ResponseEntity<IPage<Student>> list(@PathVariable("unitId") Integer unitId, Long current, Long size) {
        Page<Student> page = new Page<>(current, size);
        return new ResponseEntity<>(studentService.listByYearUnitId(page, unitId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        boolean b = studentService.removeById(id);
        if (b) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败", HttpStatus.OK);
        }
    }
}

