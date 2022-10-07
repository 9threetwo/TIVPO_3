package com.example.pizzeria.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "goods")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "good_type")
    private String goodsType = "";
    private int discount = 0;
    private int price;
    @Column(name = "current_price")
    private int currentPrice;
    private String name = "";
    private String description = "";
    private String img = "";

    @ManyToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private Set<OrderEntity> orders = new HashSet<>();

    public void addOrder(OrderEntity order) {
        this.orders.add(order);
    }

    public GoodsEntity(String goodsType, int discount, int price) {
        this.goodsType = goodsType;
        this.discount = discount;
        this.price = price;
    }
}
