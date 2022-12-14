package com.example.pizzeria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column(name = "date_create")
    private String dateCreate;
    private Long timestamp;
    @Column(name = "with_delivery")
    @Getter
    private Boolean withDelivery;
    private int price;

    @JoinTable(
            name = "order_goods",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id")
    )
    @ManyToMany(fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<GoodsEntity> goods = new ArrayList<>();

    public void addGoods(GoodsEntity goodsItem) {
        this.goods.add(goodsItem);
//        goodsItem.addOrder(this);
    }

    public OrderEntity(UserEntity user, String dateCreate, Boolean withDelivery, int price) {
        this.user = user;
        this.dateCreate = dateCreate;
        this.withDelivery = withDelivery;
        this.price = price;
    }
}
