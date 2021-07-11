package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Role.Role;
import com.sms.demo.Model.Role.RoleUpdate;

import org.springframework.stereotype.Service;


@Service
public interface RoleService {
    List<Role> getList();

    public Boolean Creat(String role);

    Role GetByID(String id);

    Boolean Update(RoleUpdate roleUpdate);

    Boolean Delete(String id);

    List<Role> search(String role);
}
