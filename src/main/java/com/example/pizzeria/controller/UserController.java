package com.example.pizzeria.controller;

import com.example.pizzeria.entity.UserEntity;
import com.example.pizzeria.model.User;
import com.example.pizzeria.repository.UserRepo;
import com.example.pizzeria.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAll(Model model) {
        return  null;

    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    Object add(UserEntity userEntity, Model model, RedirectAttributes redirectAttributes) {
        return  null;

    }


}
