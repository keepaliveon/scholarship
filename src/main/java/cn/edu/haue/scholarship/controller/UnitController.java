package cn.edu.haue.scholarship.controller;


import cn.edu.haue.scholarship.entity.Unit;
import cn.edu.haue.scholarship.service.IUnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 组织单位 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/api/unit")
public class UnitController {

    @Resource
    private IUnitService unitService;

    @GetMapping("first")
    public ResponseEntity<List<Unit>> getFirst() {
        return new ResponseEntity<>(unitService.getFirstUnit(), HttpStatus.OK);
    }

    @GetMapping("tree/{id}")
    public ResponseEntity<List<Unit>> getTree(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(unitService.getTree(id), HttpStatus.OK);
    }

    @GetMapping("no_root_tree/{id}")
    public ResponseEntity<List<Unit>> getNoRootTree(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(unitService.getNoRootTree(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Unit unit) {
        if (unitService.save(unit)) {
            return new ResponseEntity<>("添加成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("添加失败", HttpStatus.OK);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody List<Integer> ids) {
        Collections.reverse(ids);
        for (Integer id : ids) {
            unitService.removeById(id);
        }
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }
}

