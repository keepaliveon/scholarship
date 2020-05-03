package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Application;
import cn.edu.haue.scholarship.security.CurrentUser;
import cn.edu.haue.scholarship.security.UserPrincipal;
import cn.edu.haue.scholarship.service.IApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("apply/{scholarshipId}")
    public ResponseEntity<?> apply(@ApiIgnore @CurrentUser UserPrincipal userPrincipal, @PathVariable("scholarshipId") Integer scholarshipId) {
        Application application = new Application();
        application.setState(1);
        application.setStudentId(userPrincipal.getUsername());
        application.setScholarshipId(scholarshipId);
        boolean save;
        try {
            save = applicationService.save(application);
        } catch (Exception e) {
            e.printStackTrace();
            save = false;
        }
        if (save) {
            return new ResponseEntity<>("申请提交成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("申请提交失败", HttpStatus.OK);
        }
    }

    @GetMapping("publicity")
    public ResponseEntity<List<Application>> publicity() {
        return new ResponseEntity<>(applicationService.listPublicity(), HttpStatus.OK);
    }
}

