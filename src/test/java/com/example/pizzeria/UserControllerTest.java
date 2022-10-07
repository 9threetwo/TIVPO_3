package com.example.pizzeria;

import com.example.pizzeria.entity.UserEntity;
import com.example.pizzeria.entity.UserEntity;
import com.example.pizzeria.repository.UserRepo;
import com.example.pizzeria.repository.UserRepo;
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
public class UserControllerTest {
    @Mock
    UserRepo usersRepo;

    @Captor
    ArgumentCaptor<UserEntity> captor;

    @Test
    void userGet(){
        UserEntity user = new UserEntity("username1", "firstname1", "lastname1", "password1", "email1");
        List<UserEntity> users = new ArrayList<>();
        users.add(user);
        when(usersRepo.findAll()).thenReturn(users);
        UserEntity neededUser = new UserEntity();
        List<UserEntity> newUser = usersRepo.findAll();
        for (UserEntity itUserEntity : newUser){
            if(itUserEntity.getId() == user.getId()){
                neededUser = itUserEntity;
            }
        }
        assertEquals(user.getId(), neededUser.getId());
    }

    @Test
    void userPost(){
        UserEntity user = new UserEntity("username1", "firstname1", "lastname1", "password1", "email1");
        when(usersRepo.save(any())).thenReturn(user);
        UserEntity newUser = usersRepo.save(user);
        verify(usersRepo).save(captor.capture());
        UserEntity newnewUser = captor.getValue();
        assertEquals(user.getId(), newUser.getId());
        assertEquals(user.getId(), newnewUser.getId());
    }

    @Test
    void userDelete(){
        UserEntity user = new UserEntity("username1", "firstname1", "lastname1", "password1", "email1");
        UserEntity user2 = new UserEntity("username2", "firstname2", "lastname2", "password2", "email2");
        List<UserEntity> users = new ArrayList<>();
        List<UserEntity> users1 = new ArrayList<>();
        List<UserEntity> users2 = new ArrayList<>();
        users.add(user);
        users1.add(user);
        users2.add(user);
        users.add(user2);
        users2.add(user2);
        when(usersRepo.findAll()).thenReturn(users);
        Iterable<UserEntity> newusers = usersRepo.findAll();
        for (UserEntity ituser : newusers){
            if(ituser == user){
                users2.remove(ituser);
            }
        }
        assertEquals(users2.get(0).getId(), users1.get(0).getId());
    }
}
