package com.dimas4ek.YoMaYo.controller;

import com.dimas4ek.YoMaYo.domain.UserInfo;
import com.dimas4ek.YoMaYo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        return "home";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<UserInfo> users = userRepo.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam int age, Map<String, Object> model) {
        UserInfo user = new UserInfo(name, age);

        userRepo.save(user);

        Iterable<UserInfo> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<UserInfo> users;

        if (filter != null && !filter.isEmpty()) {
            users = userRepo.findByName(filter);
        } else {
            users = userRepo.findAll();
        }

        model.put("users", users);

        return "main";
    }
}
