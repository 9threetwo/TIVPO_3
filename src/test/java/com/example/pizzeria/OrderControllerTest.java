package com.example.pizzeria;

import com.example.pizzeria.entity.OrderEntity;
import com.example.pizzeria.entity.OrderEntity;
import com.example.pizzeria.entity.UserEntity;
import com.example.pizzeria.repository.OrderRepo;
import com.example.pizzeria.repository.OrderRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
    @Mock
    OrderRepo ordersRepo;

    @Captor
    ArgumentCaptor<OrderEntity> captor;

    @Test
    void orderGet(){
        OrderEntity order = new OrderEntity(new UserEntity("someUrdername1", "someName1", "someLastname1", "somePass1", "someMail1"), "24.09.2022", true, 500);
        List<OrderEntity> orders = new ArrayList<>();
        orders.add(order);
        when(ordersRepo.findAll()).thenReturn(orders);
        OrderEntity neededOrder = new OrderEntity();
        List<OrderEntity> newOrder = ordersRepo.findAll();
        for (OrderEntity itOrderEntity : newOrder){
            if(itOrderEntity.getId() == order.getId()){
                neededOrder = itOrderEntity;
            }
        }
        assertEquals(order.getId(), neededOrder.getId());
    }

    @Test
    void orderPost(){
        OrderEntity order = new OrderEntity(new UserEntity("someUrdername1", "someName1", "someLastname1", "somePass1", "someMail1"), "24.09.2022", true, 500);        when(ordersRepo.save(any())).thenReturn(order);
        OrderEntity newOrder = ordersRepo.save(order);
        verify(ordersRepo).save(captor.capture());
        OrderEntity newnewOrder = captor.getValue();
        assertEquals(order.getId(), newOrder.getId());
        assertEquals(order.getId(), newnewOrder.getId());
    }

    @Test
    void orderDelete(){
        OrderEntity order = new OrderEntity();
        OrderEntity order2 = new OrderEntity();
        List<OrderEntity> orders = new ArrayList<>();
        List<OrderEntity> orders1 = new ArrayList<>();
        List<OrderEntity> orders2 = new ArrayList<>();
        orders.add(order);
        orders1.add(order);
        orders2.add(order);
        orders.add(order2);
        orders2.add(order2);
        when(ordersRepo.findAll()).thenReturn(orders);
        Iterable<OrderEntity> neworders = ordersRepo.findAll();
        for (OrderEntity itorder : neworders){
            if(itorder == order){
                orders2.remove(itorder);
            }
        }
        assertEquals(orders2.get(0).getId(), orders1.get(0).getId());
    }
}
