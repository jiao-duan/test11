package com.dj.codingdog.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import com.alibaba.cola.dto.*;

import javax.annotation.Resource;
import java.util.List;

import com.dj.codingdog.student.service.StudentsService;
import com.dj.codingdog.student.model.Students;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dj
 * @since 2024-01-29
 */
@RestController
@RequestMapping("/students")
public class StudentsController {
    @Resource
    private StudentsService studentsService;

    /**
    * 新增
    */
    @PostMapping
    public SingleResponse<Integer> save(@RequestBody Students entity){
        studentsService.save(entity);
        return SingleResponse.of(entity.getId());
    }

    /**
    * 更新
    */
    @PutMapping
    public SingleResponse<Boolean> modify(@RequestBody Students entity){
        Boolean result =  studentsService.updateById(entity);
        return SingleResponse.of(result);
    }

    /**
    * 删除
    */
    @DeleteMapping("/{id}")
    public SingleResponse<Boolean> remove(@PathVariable Integer id){
        Boolean result =  studentsService.removeById(id);
        return SingleResponse.of(result);
    }

    /**
    * 批量删除
    */
    @PostMapping("/remove/batch")
    public SingleResponse<Boolean> removeBatch(@RequestBody List<Integer> ids){
        //批量删除
        Boolean result = studentsService.removeByIds(ids);
        return SingleResponse.of(result);
    }

    /**
    * 查询所有数据
    */
    @GetMapping
    public MultiResponse<Students> listAll(){
        return MultiResponse.of(studentsService.list());
    }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    public SingleResponse<Students> get(@PathVariable Integer id){
        return SingleResponse.of(studentsService.getById(id));
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public PageResponse<Students> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        QueryWrapper<Students> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        Page<Students> page = studentsService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return PageResponse.of(page.getRecords(), (int)page.getTotal(), (int)page.getPages(), (int)page.getCurrent());
    }
}
