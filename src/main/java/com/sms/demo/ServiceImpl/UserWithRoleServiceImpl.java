package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.UserWithRole.ParameterRoleId;
import com.sms.demo.Model.UserWithRole.ParameterUserId;
import com.sms.demo.Model.UserWithRole.UserWithRole;
import com.sms.demo.Model.UserWithRole.UserWithRoleGetById;
import com.sms.demo.Model.UserWithRole.UserWithRoleList;
import com.sms.demo.Repositories.UserWithRoleRepository;
import com.sms.demo.Service.UserWithRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWithRoleServiceImpl implements UserWithRoleService{

    private UserWithRoleRepository userWithRoleRepository;

    @Autowired
    public UserWithRoleServiceImpl(UserWithRoleRepository userWithRoleRepository) {
        this.userWithRoleRepository = userWithRoleRepository;
    }



    @Override
    public java.util.List<UserWithRoleList> List() {
        return this.userWithRoleRepository.List();
    }



    @Override
    public UserWithRoleGetById getById(String id) {
        return this.userWithRoleRepository.getById(id);
    }



    @Override
    public Boolean Create(UserWithRole userWithRole) {
        return this.userWithRoleRepository.Create(userWithRole);
    }



    @Override
    public java.util.List<ParameterUserId> parameterUserIds() {
        return this.userWithRoleRepository.parameterUserIds();
    }



    @Override
    public java.util.List<ParameterRoleId> parameterRoleIds() {
        return this.userWithRoleRepository.parameterRoleIds();
    }



    @Override
    public Boolean Delete(String id) {
        return this.userWithRoleRepository.Delete(id);
    }



    @Override
    public Boolean Update(UserWithRoleGetById userWithRoleGetById) {
        return this.userWithRoleRepository.Update(userWithRoleGetById);
    }



    @Override
    public java.util.List<UserWithRoleList> search(String id) {
        return this.userWithRoleRepository.search(id);
    }

}
