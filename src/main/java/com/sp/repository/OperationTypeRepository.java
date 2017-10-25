/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.repository;

import com.sp.entity.Operationtype;
import com.sp.persunit.PersistenceUtilites;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



/**
 *
 * @author Oguzhan
 */
public class OperationTypeRepository {
    

   private EntityManager em;
  
    public OperationTypeRepository(EntityManager entityManager){
       this.em = entityManager;
    }

    public OperationTypeRepository() {
       
    }
    
      
    public void persist(Operationtype operationType){
        em.persist(operationType);  
    }
   
      public void create (Operationtype operationType){

      EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
          try {
               entityManager.getTransaction().begin();
               entityManager.persist(operationType); 
               entityManager.getTransaction().commit();
          } catch (Exception e) {
               entityManager.close();
          }      
    }
         
    public List<Operationtype> findAll(Operationtype operationType) {
          EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
          TypedQuery<Operationtype> query;
          query = entityManager.createQuery("SELECT o FROM Operationtype o", Operationtype.class);
          //List<User> userList = new ArrayList<>();
         // for(User User : userList){
         //     System.err.println(user.getName());
        // }
          List<Operationtype> results = query.getResultList();
          
          return results ;
        
        
    }
    
    public void delete(Operationtype operationType){
       // em = PersistenceUtilites.getFactory().createEntityManager();
       // em.getTransaction().begin();
       // em.remove(category);
       //em.getTransaction().commit();
       
        EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        entityManager.find(Operationtype.class,operationType.getOperationTypeid());

        entityManager.getTransaction().begin();
        operationType = entityManager.merge(operationType);
        entityManager.remove(operationType);
        entityManager.getTransaction().commit();
        
        
       
       
        //EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        //entityManager.getTransaction().begin();
        //entityManager.merge(category);
        //entityManager.find(CategoryEntity.class,category.getCategoryId());
        //entityManager.remove(category);
        //entityManager.getTransaction().commit();

        
        
    }
    
    public void update (Operationtype operationType){
        EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        entityManager.find(Operationtype.class,operationType.getOperationTypeid());

        entityManager.getTransaction().begin();
         operationType = entityManager.merge(operationType);
        entityManager.remove(operationType);
        OperationTypeRepository categoryRepository = new OperationTypeRepository(entityManager);
        categoryRepository.persist(operationType);
        
        entityManager.getTransaction().commit();
    }
}
