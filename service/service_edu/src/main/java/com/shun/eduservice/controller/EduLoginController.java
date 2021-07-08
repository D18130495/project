package com.shun.eduservice.controller;

import com.shun.commonutils.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {
    @PostMapping("/login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @GetMapping("/info")
    public R info() {
        Map map = new HashMap<String, Object>();
        map.put("roles", "admin");
        map.put("name", "jim");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return R.ok().data(map);
    }

    @PostMapping("/logout")
    public R logout() {
        Map map = new HashMap<String, Object>();
        return R.ok();
    }
}
