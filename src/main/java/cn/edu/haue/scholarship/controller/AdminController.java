package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Admin;
import cn.edu.haue.scholarship.security.CurrentUser;
import cn.edu.haue.scholarship.security.UserPrincipal;
import cn.edu.haue.scholarship.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学生资助中心管理员 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Resource
    private IAdminService adminService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("current")
    @ApiOperation("获取当前管理员")
    public ResponseEntity<Admin> auth(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        Admin admin = adminService.getById(userPrincipal.getUsername());
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @GetMapping("year/current")
    public ResponseEntity<?> getCurrentYear() {
        return new ResponseEntity<>(redisTemplate.opsForValue().get("year"), HttpStatus.OK);
    }

    @PutMapping("year/set_current/{year}")
    public ResponseEntity<?> setCurrentYear(@PathVariable("year") String year) {
        redisTemplate.opsForValue().set("year", year);
        return new ResponseEntity<>("设置成功", HttpStatus.OK);
    }

    @PostMapping("year/add/{year}")
    public ResponseEntity<?> addYear(@PathVariable("year") String year) {
        redisTemplate.opsForList().leftPush("years", year);
        return new ResponseEntity<>("添加成功", HttpStatus.OK);
    }

    @GetMapping("year")
    public ResponseEntity<List<String>> getYears() {
        Long size = redisTemplate.opsForList().size("years");
        List<String> years = redisTemplate.opsForList().range("years", 0L, size - 1);
        return new ResponseEntity<>(years, HttpStatus.OK);
    }

    @DeleteMapping("year/del/{year}")
    public ResponseEntity<?> delYear(@PathVariable("year") String year) {
        redisTemplate.opsForList().remove("years", -1, year);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }
}

