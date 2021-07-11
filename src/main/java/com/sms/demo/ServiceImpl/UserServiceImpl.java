package com.sms.demo.ServiceImpl;

import java.util.List;

import com.sms.demo.Model.User.UserCreate;
import com.sms.demo.Model.User.UserGetById;
import com.sms.demo.Model.User.UserUpdate;
import com.sms.demo.Repositories.UserRepository;
import com.sms.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserGetById> List() {
        return this.userRepository.List();
    }

    @Override
    public UserGetById GetById(String id) {
        return this.userRepository.GetById(id);
    }

    @Override
    public Boolean Create(UserCreate userCreate) {
        return this.userRepository.Create(userCreate);
    }

    @Override
    public Boolean Update(UserUpdate userUpdate) {
        return this.userRepository.Update(userUpdate);
    }

    @Override
    public Boolean Delete(String id) {
        return this.userRepository.Delete(id);
    }

    @Override
    public List<UserGetById> search(String username) {
        return this.userRepository.search(username);
    }

    @Override
    public UserGetById login(String apiKey) {
        return this.userRepository.login(apiKey);
    }

}
