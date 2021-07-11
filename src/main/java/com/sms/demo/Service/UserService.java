package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.User.UserCreate;
import com.sms.demo.Model.User.UserGetById;
import com.sms.demo.Model.User.UserUpdate;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserGetById GetById(String id);

    List<UserGetById> List();

    Boolean Create(UserCreate userCreate);

    Boolean Update(UserUpdate userUpdate);

    Boolean Delete(String id);

    List<UserGetById> search(String username);

    UserGetById login(String apiKey);
}