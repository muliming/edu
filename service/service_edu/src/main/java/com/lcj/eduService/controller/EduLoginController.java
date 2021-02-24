package com.lcj.eduService.controller;

import com.lcj.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Author：LCJ
 * @Description：
 * @Date：Create in 10:57 2021/2/21 0021
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class EduLoginController {


    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R getInfo(){
        return R.ok().data("roles","admin")
                .data("name","admin")
                .data("avatar","https://picsum.photos/536/354");
    }

}
