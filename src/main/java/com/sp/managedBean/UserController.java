/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.managedBean;

import com.sp.entity.User;
import com.sp.repository.UserRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

/**
 *
 * @author Oguzhan
 */
@ManagedBean(name = "userController")
@RequestScoped
public class UserController {
    private User user;
    private List<User> users;
   


    public UserController() {
        user = new User();
        UserRepository userRepository = new UserRepository();
        setUsers(userRepository.findAll(user));
        
   
    }
    
    public void addUser(){
        user = new User();
    }
    
    public void save(){
        UserRepository userRepository = new UserRepository();
        userRepository.create(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    
    
}
