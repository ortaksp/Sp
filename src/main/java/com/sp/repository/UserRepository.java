/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.repository;

import com.sp.entity.User;
import com.sp.persunit.PersistenceUtilites;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



/**
 *
 * @author Oguzhan
 */
public class UserRepository {
    

   private EntityManager em;
  
    public UserRepository(EntityManager entityManager){
       this.em = entityManager;
    }

    public UserRepository() {
       
    }
    
      
    public void persist(User user){
        em.persist(user);  
    }
   
      public void create (User user){

      EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
          try {
               entityManager.getTransaction().begin();
               entityManager.persist(user); 
               entityManager.getTransaction().commit();
          } catch (Exception e) {
               entityManager.close();
          }      
    }
         
    public List<User> findAll(User user) {
          EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
          TypedQuery<User> query;
          query = entityManager.createQuery("SELECT u FROM User u", User.class);
          //List<User> userList = new ArrayList<>();
         // for(User User : userList){
         //     System.err.println(user.getName());
        // }
          List<User> results = query.getResultList();
          
          return results ;
        
        
    }
    
    public void delete(User user){
       // em = PersistenceUtilites.getFactory().createEntityManager();
       // em.getTransaction().begin();
       // em.remove(category);
       //em.getTransaction().commit();
       
        EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        entityManager.find(User.class,user.getUserid());

        entityManager.getTransaction().begin();
        user = entityManager.merge(user);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        
        
       
       
        //EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        //entityManager.getTransaction().begin();
        //entityManager.merge(category);
        //entityManager.find(CategoryEntity.class,category.getCategoryId());
        //entityManager.remove(category);
        //entityManager.getTransaction().commit();

        
        
    }
    
    public void update (User user){
        EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        entityManager.find(User.class,user.getUserid());

        entityManager.getTransaction().begin();
         user = entityManager.merge(user);
        entityManager.remove(user);
        UserRepository categoryRepository = new UserRepository(entityManager);
        categoryRepository.persist(user);
        
        entityManager.getTransaction().commit();
    }
}
