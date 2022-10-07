package com.example.pizzeria;


import com.example.pizzeria.entity.GoodsEntity;
import com.example.pizzeria.entity.UserEntity;

import com.example.pizzeria.repository.GoodsRepo;
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
public class GoodsControllerTests {
    @Mock
    GoodsRepo goodsRepo;

    @Captor
    ArgumentCaptor<GoodsEntity> captor;

    @Test
    void goodGet(){
        GoodsEntity good = new GoodsEntity("Pizza",5,500);
        List<GoodsEntity> goods = new ArrayList<>();
        goods.add(good);
        when(goodsRepo.findAll()).thenReturn(goods);
        GoodsEntity neededGood = new GoodsEntity();
        List<GoodsEntity> newGoods = goodsRepo.findAll();
        for (GoodsEntity itGoodEntity : newGoods){
            if(itGoodEntity.getId() == good.getId()){
                neededGood = itGoodEntity;
            }
        }
        assertEquals(good.getId(), neededGood.getId());
    }

    @Test
    void goodPost(){
        GoodsEntity good = new GoodsEntity("Pizza",5,500);
        when(goodsRepo.save(any())).thenReturn(good);
        GoodsEntity newGood = goodsRepo.save(good);
        verify(goodsRepo).save(captor.capture());
        GoodsEntity newnewGood = captor.getValue();
        assertEquals(good.getId(), newGood.getId());
        assertEquals(good.getId(), newnewGood.getId());
    }

    @Test
    void goodDelete(){
        GoodsEntity good = new GoodsEntity("Pizza",5,500);
        GoodsEntity good2 = new GoodsEntity("Pizza",5,500);
        List<GoodsEntity> goods = new ArrayList<>();
        List<GoodsEntity> goods1 = new ArrayList<>();
        List<GoodsEntity> goods2 = new ArrayList<>();
        goods.add(good);
        goods1.add(good);
        goods2.add(good);
        goods.add(good2);
        goods2.add(good2);
        when(goodsRepo.findAll()).thenReturn(goods);
        Iterable<GoodsEntity> newgoods = goodsRepo.findAll();
        for (GoodsEntity itgood : newgoods){
            if(itgood == good){
                goods2.remove(itgood);
            }
        }
        assertEquals(goods2.get(0).getId(), goods1.get(0).getId());
    }
}
