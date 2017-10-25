/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.Impl;

import com.sp.entity.Operationtype;


public class OperationtypeImpl extends Operationtype {

    public OperationtypeImpl() {
    }

    public OperationtypeImpl(Integer operationTypeid) {
        super(operationTypeid);
    }

    public OperationtypeImpl(Integer operationTypeid, String operationTypeName) {
        super(operationTypeid, operationTypeName);
    }
    
}
