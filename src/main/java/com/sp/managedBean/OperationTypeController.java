/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.managedBean;

import com.sp.entity.Operationtype;
import com.sp.repository.OperationTypeRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

/**
 *
 * @author Oguzhan
 */
@ManagedBean(name = "operationTypeController")
@RequestScoped
public class OperationTypeController {
    private Operationtype operationType;
    private List<Operationtype> operationTypes;
   


    public OperationTypeController() {
        OperationTypeRepository operationTypeRepository = new OperationTypeRepository();
        setOperationTypes(operationTypeRepository.findAll(operationType));
        
   
    }
    
    public void addOperationType(){
        operationType = new Operationtype();
    }
    
    public void save(){
        OperationTypeRepository operationTypeRepository = new OperationTypeRepository();
        operationTypeRepository.create(operationType);
    }

    public Operationtype getOperationType() {
        return operationType;
    }

    public void setOperationType(Operationtype operationType) {
        this.operationType = operationType;
    }

    public List<Operationtype> getOperationTypes() {
        return operationTypes;
    }

    public void setOperationTypes(List<Operationtype> operationTypes) {
        this.operationTypes = operationTypes;
    }


    
    
}
