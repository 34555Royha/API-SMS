package com.sms.demo.ServiceImpl;

import java.util.List;

import com.sms.demo.Model.Role.Role;
import com.sms.demo.Model.Role.RoleUpdate;
import com.sms.demo.Repositories.RoleRepository;
import com.sms.demo.Service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getList() {
        return this.roleRepository.getList();
    }

    @Override
    public Boolean Creat(String role) {
        return this.roleRepository.Create(role);
    }

    @Override
    public Role GetByID(String id) {
        return this.roleRepository.GetByID(id);
    }

    @Override
    public Boolean Update(RoleUpdate roleUpdate) {
        return this.roleRepository.Update(roleUpdate);
    }

    @Override
    public Boolean Delete(String id) {
        return this.roleRepository.Delete(id);
    }

    @Override
    public List<Role> search(String role) {
        return this.roleRepository.search(role);
    }
    
}
