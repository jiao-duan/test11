package com.dj.codingdog.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import com.alibaba.cola.dto.*;

import javax.annotation.Resource;
import java.util.List;

import com.dj.codingdog.student.service.TeachersService;
import com.dj.codingdog.student.model.Teachers;

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
@RequestMapping("/teachers")
public class TeachersController {
    @Resource
    private TeachersService teachersService;

    /**
    * 新增
    */
    @PostMapping
    public SingleResponse<Integer> save(@RequestBody Teachers entity){
        teachersService.save(entity);
        return SingleResponse.of(entity.getId());
    }

    /**
    * 更新
    */
    @PutMapping
    public SingleResponse<Boolean> modify(@RequestBody Teachers entity){
        Boolean result =  teachersService.updateById(entity);
        return SingleResponse.of(result);
    }

    /**
    * 删除
    */
    @DeleteMapping("/{id}")
    public SingleResponse<Boolean> remove(@PathVariable Integer id){
        Boolean result =  teachersService.removeById(id);
        return SingleResponse.of(result);
    }

    /**
    * 批量删除
    */
    @PostMapping("/remove/batch")
    public SingleResponse<Boolean> removeBatch(@RequestBody List<Integer> ids){
        //批量删除
        Boolean result = teachersService.removeByIds(ids);
        return SingleResponse.of(result);
    }

    /**
    * 查询所有数据
    */
    @GetMapping
    public MultiResponse<Teachers> listAll(){
        return MultiResponse.of(teachersService.list());
    }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    public SingleResponse<Teachers> get(@PathVariable Integer id){
        return SingleResponse.of(teachersService.getById(id));
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public PageResponse<Teachers> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        QueryWrapper<Teachers> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        Page<Teachers> page = teachersService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return PageResponse.of(page.getRecords(), (int)page.getTotal(), (int)page.getPages(), (int)page.getCurrent());
    }
}
