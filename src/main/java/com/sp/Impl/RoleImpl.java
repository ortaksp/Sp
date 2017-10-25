/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.Impl;

import com.sp.entity.Role;


public class RoleImpl extends Role {

    public RoleImpl() {
    }

    public RoleImpl(Integer roleid) {
        super(roleid);
    }

    public RoleImpl(Integer roleid, String roleName) {
        super(roleid, roleName);
    }
    
}
