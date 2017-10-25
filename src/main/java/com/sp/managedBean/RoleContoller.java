/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.managedBean;

import com.sp.entity.Role;
import com.sp.repository.RoleRepository;
import com.sp.repository.UserRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

/**
 *
 * @author Oguzhan
 */
@ManagedBean(name = "roleController")
@RequestScoped
public class RoleContoller {
    private Role role;
    private List<Role> roles;
   


    public RoleContoller() {
        role = new Role();
        RoleRepository roleRepository = new RoleRepository();
        setRoles(roleRepository.findAll(role));
        
   
    }
    
    public void addRole(){
        role = new Role();
    }
    
    public void save(){
        RoleRepository roleRepository = new RoleRepository();
        roleRepository.create(role);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    
}
