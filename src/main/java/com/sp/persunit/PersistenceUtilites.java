/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.persunit;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oguzhan
 */
public class PersistenceUtilites {
     private static EntityManagerFactory emf = null;
     
     
      public static EntityManagerFactory getFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("SPMav");
            
        }
        return emf;
    }
    public static void closeFactory(){
        emf.close();
    }
}
