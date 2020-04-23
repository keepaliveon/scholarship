package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Counsellor;
import cn.edu.haue.scholarship.security.CurrentUser;
import cn.edu.haue.scholarship.security.UserPrincipal;
import cn.edu.haue.scholarship.service.ICounsellorService;
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
    private PasswordEncoder passwordEncoder;

    @GetMapping("auth")
    @ApiOperation("从认证上下文获取辅导员信息")
    public ResponseEntity<Counsellor> auth(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        Counsellor counsellor = counsellorService.getById(userPrincipal.getUsername());
        return new ResponseEntity<>(counsellor, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Counsellor>> list() {
        return new ResponseEntity<>(counsellorService.listAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Counsellor> findById(@PathVariable("id") String id) {
        return new ResponseEntity<>(counsellorService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Counsellor counsellor) {
        if (counsellorService.updateById(counsellor)) {
            return new ResponseEntity<>("更新成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("更新失败", HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Counsellor counsellor) {
        counsellor.setPassword(passwordEncoder.encode(counsellor.getStaffId()));
        if (counsellorService.save(counsellor)) {
            return new ResponseEntity<>("创建成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("创建失败", HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        if (counsellorService.removeById(id)) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败", HttpStatus.OK);
        }
    }
}

