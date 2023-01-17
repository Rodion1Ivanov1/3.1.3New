package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.util.Init;

@Controller
public class UserController {


    private final UserRepository userRepository;
    private final Init init;

    @Autowired
    public UserController(UserRepository userRepository, Init init) {
        this.userRepository = userRepository;
        this.init = init;
    }

    @RequestMapping("/")
    public String homePage() {
        init.createUser();
        return "redirect:/login";
    }


    @RequestMapping("/user")
    public String mainPageUserInfo(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("userModel", user);
        return "user";
    }
}
