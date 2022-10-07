package com.example.pizzeria.controller;

import com.example.pizzeria.entity.CertificateEntity;
import com.example.pizzeria.entity.UserEntity;
import com.example.pizzeria.model.Certificate;
import com.example.pizzeria.model.User;
import com.example.pizzeria.service.CertificateService;
import com.example.pizzeria.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private UserService userService;
    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public String getCertPage(@AuthenticationPrincipal UserEntity user, Model model) {
        return  null;
    }
    @GetMapping("/addd")
    public String getAddCertPage(Model model, RedirectAttributes attrs) {
        return  null;

    }
    @PostMapping("/addd")
    public String updateAddCertPage(Model model, UserEntity user, RedirectAttributes attrs) {
        return  null;

    }

    @PostMapping("/{toUserId}/add")
    public String addCertificate(
            RedirectAttributes attrs,
            @AuthenticationPrincipal UserEntity currentUser,
            CertificateEntity certInfo,
            @PathVariable UUID toUserId
    ) {
        return  null;

    }
}
