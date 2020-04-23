package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Admin;
import cn.edu.haue.scholarship.security.CurrentUser;
import cn.edu.haue.scholarship.security.UserPrincipal;
import cn.edu.haue.scholarship.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

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

    @GetMapping("auth")
    @ApiOperation("从认证上下文获取管理员信息")
    public ResponseEntity<Admin> auth(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        Admin admin = adminService.getById(userPrincipal.getUsername());
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}

