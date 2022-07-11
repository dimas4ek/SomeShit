package com.dimas4ek.YoMaYo.controller;

import com.dimas4ek.YoMaYo.domain.User;
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
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam int age, Map<String, Object> model) {
        User user = new User(name, age);

        userRepo.save(user);

        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<User> users;

        if (filter != null && !filter.isEmpty()) {
            users = userRepo.findByName(filter);
        } else {
            users = userRepo.findAll();
        }

        model.put("users", users);

        return "main";
    }
}
