package com.example.pizzeria.controller;

import com.example.pizzeria.DTO.FilterGoodsDTO;
import com.example.pizzeria.DTO.SetDiscountDto;
import com.example.pizzeria.entity.CertificateEntity;
import com.example.pizzeria.entity.GoodsEntity;
import com.example.pizzeria.entity.UserEntity;
import com.example.pizzeria.model.Goods;
import com.example.pizzeria.model.User;
import com.example.pizzeria.service.GoodsService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.UUID;

@Component
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping
    public String getGoodsPage(Model model, RedirectAttributes attrs) {
        return  null;

    }
    @PostMapping
    public String filterGoodsPage(RedirectAttributes attrs, FilterGoodsDTO dto) {
        return  null;

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{goodsId}/discount")
    public String editGoodsDiscount(RedirectAttributes attrs, SetDiscountDto dto, @PathVariable UUID goodsId, Model model) {
        return  null;

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{goodsId}/edit")
    public String editGoodsInfo(RedirectAttributes attrs, GoodsEntity goodsItem, @PathVariable UUID goodsId, Model model) {
        return  null;

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public String createGoods(RedirectAttributes attrs, GoodsEntity goodsItem, Model model) {
        return  null;

    }
}
