package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Unit;
import cn.edu.haue.scholarship.service.IUnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 组织单位 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/scholarship/unit")
public class UnitController {

    @Resource
    private IUnitService unitService;

    @GetMapping("tree")
    public ResponseEntity<List<Unit>> getUnitTree() {
        return new ResponseEntity<>(unitService.getUnitTree(), HttpStatus.OK);
    }
}

