package com.fontes.mealtracker.controller.web;

import com.fontes.mealtracker.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {

    @GetMapping(value = "/home")
    public String home(Model model) {

        User user = new User();
        user.setName("JOão Pedro");
        user.setEmail("joao.pedro@gmail.com");
        model.addAttribute("user", user);

        return "userhome";
    }
}
