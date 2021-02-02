package com.lcj.eduService.controller;


import com.lcj.commonutils.R;
import com.lcj.eduService.entity.EduTeacher;
import com.lcj.eduService.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-01-19
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    //查询所有的讲师
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        List<EduTeacher> list=eduTeacherService.list(null);
        return R.ok().data("teachers",list);
    }

    //讲师逻辑删除
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@PathVariable String id){
        boolean flag=eduTeacherService.removeById(id);
        if(!flag){
            return R.error();
        }
        return R.ok();
    }











}

