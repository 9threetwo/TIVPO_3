package com.example.pizzeria.controller;

import com.example.pizzeria.DTO.CreateOrderDTO;
import com.example.pizzeria.DTO.FilterGoodsDTO;
import com.example.pizzeria.entity.GoodsEntity;
import com.example.pizzeria.entity.OrderEntity;
import com.example.pizzeria.entity.UserEntity;
import com.example.pizzeria.model.Goods;
import com.example.pizzeria.service.GoodsService;
import com.example.pizzeria.service.OrderService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    @PostMapping
    public String createOrder(CreateOrderDTO orderDTO, @AuthenticationPrincipal UserEntity user, RedirectAttributes attrs) {
        return  null;

    }

    @GetMapping
    public String getOrders(Model model, @AuthenticationPrincipal UserEntity user) {
        return  null;

    }

    @GetMapping("/add")
    public String getCreateOrdersPage(Model model) {
        return  null;

    }
    @PostMapping("/add")
    public String updateCreateOrderPage(RedirectAttributes attrs, FilterGoodsDTO dto, CreateOrderDTO orderDto) {
        return  null;

    }
}
