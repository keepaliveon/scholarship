package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Counsellor;
import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.security.CurrentUser;
import cn.edu.haue.scholarship.security.UserPrincipal;
import cn.edu.haue.scholarship.service.ICounsellorService;
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
 * 辅导员 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/api/counsellor")
public class CounsellorController {

    @Resource
    private ICounsellorService counsellorService;

    @Resource
    private IStudentService studentService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @GetMapping("current")
    @ApiOperation("获取当前辅导员")
    public ResponseEntity<Counsellor> current(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        Counsellor counsellor = counsellorService.getById(userPrincipal.getUsername());
        return new ResponseEntity<>(counsellor, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("辅导员列表")
    public ResponseEntity<List<Counsellor>> list() {
        return new ResponseEntity<>(counsellorService.listAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ApiOperation("根据工号查找辅导员信息")
    public ResponseEntity<Counsellor> findById(@PathVariable("id") String id) {
        return new ResponseEntity<>(counsellorService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("更新辅导员信息")
    public ResponseEntity<String> update(@RequestBody Counsellor counsellor) {
        if (counsellorService.updateById(counsellor)) {
            return new ResponseEntity<>("更新成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("更新失败", HttpStatus.OK);
        }
    }

    @PostMapping
    @ApiOperation("新建辅导员")
    public ResponseEntity<String> create(@RequestBody Counsellor counsellor) {
        counsellor.setPassword(passwordEncoder.encode(counsellor.getStaffId()));
        if (counsellorService.save(counsellor)) {
            return new ResponseEntity<>("创建成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("创建失败", HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation("删除辅导员")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        if (counsellorService.removeById(id)) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败", HttpStatus.OK);
        }
    }
}

