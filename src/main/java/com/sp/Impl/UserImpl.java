/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.Impl;

import com.sp.entity.User;


public class UserImpl extends User {

    public UserImpl() {
    }

    public UserImpl(Integer userid) {
        super(userid);
    }

    public UserImpl(Integer userid, String userName, String password, String name, String surName, String mail) {
        super(userid, userName, password, name, surName, mail);
    }
    
}
