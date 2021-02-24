package com.lcj.eduService.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcj.commonutils.R;
import com.lcj.eduService.entity.EduTeacher;
import com.lcj.eduService.entity.vo.TeacherQuery;
import com.lcj.eduService.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Slf4j
@CrossOrigin
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


    /**
     * @param current 当前页
     * @param limit 每页记录数
     * @return
     */
    @PostMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,
                             @PathVariable long limit){

        //创建page对象
        Page<EduTeacher> pageTeacher=new Page<>(current,limit);
        //调用方法时，底层封装，把分页数据封装到pageTeacher对象里面
        eduTeacherService.page(pageTeacher,null);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records=pageTeacher.getRecords();
        Map map=new HashMap();
        map.put("total",total);
        map.put("row",records);
        return R.ok().data(map);
    }


    /**
     * 条件查询
     * @param current
     * @param limit
     * @param teacherQuery
     * @return
     */
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,
                             @PathVariable long limit,
                             @RequestBody(required = false) TeacherQuery teacherQuery){
        //创建一个配置对象
        Page<EduTeacher> pageTeacher=new Page<>(current,limit);
        //构造条件
        QueryWrapper<EduTeacher> wrapper=new QueryWrapper<>();
        //判断条件是否为空，如果不为空拼接条件
        String name=teacherQuery.getName();
        String level=teacherQuery.getLevel();
        String begin=teacherQuery.getBegin();
        String end=teacherQuery.getEnd();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }

        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }

        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gnt_create",begin);
        }

        if(!StringUtils.isEmpty(end)){
            wrapper.le("gnt_create",end);
        }

        wrapper.orderByDesc("gnt_create");
        eduTeacherService.page(pageTeacher,wrapper);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records=pageTeacher.getRecords();
        Map map=new HashMap();
        map.put("total",total);
        map.put("row",records);
        return R.ok().data(map);
    }


    //添加讲师
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if(!save){
            return R.error();
        }
        return R.ok();
    }


    //根据id查询讲师
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }

    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(!flag){
            return R.error();
        }
        return R.ok();
    }




    }

