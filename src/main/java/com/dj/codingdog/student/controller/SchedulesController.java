package com.dj.codingdog.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import com.alibaba.cola.dto.*;

import javax.annotation.Resource;
import java.util.List;

import com.dj.codingdog.student.service.SchedulesService;
import com.dj.codingdog.student.model.Schedules;

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
@RequestMapping("/schedules")
public class SchedulesController {
    @Resource
    private SchedulesService schedulesService;

    /**
    * 新增
    */
    @PostMapping
    public SingleResponse<Integer> save(@RequestBody Schedules entity){
        schedulesService.save(entity);
        return SingleResponse.of(entity.getId());
    }

    /**
    * 更新
    */
    @PutMapping
    public SingleResponse<Boolean> modify(@RequestBody Schedules entity){
        Boolean result =  schedulesService.updateById(entity);
        return SingleResponse.of(result);
    }

    /**
    * 删除
    */
    @DeleteMapping("/{id}")
    public SingleResponse<Boolean> remove(@PathVariable Integer id){
        Boolean result =  schedulesService.removeById(id);
        return SingleResponse.of(result);
    }

    /**
    * 批量删除
    */
    @PostMapping("/remove/batch")
    public SingleResponse<Boolean> removeBatch(@RequestBody List<Integer> ids){
        //批量删除
        Boolean result = schedulesService.removeByIds(ids);
        return SingleResponse.of(result);
    }

    /**
    * 查询所有数据
    */
    @GetMapping
    public MultiResponse<Schedules> listAll(){
        return MultiResponse.of(schedulesService.list());
    }

    /**
    * 查询详情
    */
    @GetMapping("/{id}")
    public SingleResponse<Schedules> get(@PathVariable Integer id){
        return SingleResponse.of(schedulesService.getById(id));
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public PageResponse<Schedules> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        QueryWrapper<Schedules> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        Page<Schedules> page = schedulesService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return PageResponse.of(page.getRecords(), (int)page.getTotal(), (int)page.getPages(), (int)page.getCurrent());
    }
}
