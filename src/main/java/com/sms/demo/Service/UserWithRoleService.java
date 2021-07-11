package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.UserWithRole.ParameterRoleId;
import com.sms.demo.Model.UserWithRole.ParameterUserId;
import com.sms.demo.Model.UserWithRole.UserWithRole;
import com.sms.demo.Model.UserWithRole.UserWithRoleGetById;
import com.sms.demo.Model.UserWithRole.UserWithRoleList;

import org.springframework.stereotype.Service;


@Service
public interface UserWithRoleService {
    List<UserWithRoleList> List();
    UserWithRoleGetById getById(String id);
    Boolean Create(UserWithRole userWithRole);
    List<ParameterUserId> parameterUserIds();
    List<ParameterRoleId> parameterRoleIds();
    Boolean Delete(String id);
    Boolean Update(UserWithRoleGetById userWithRoleGetById);
    List<UserWithRoleList> search(String id);
}
