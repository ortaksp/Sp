/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.repository;

import com.sp.entity.Role;
import com.sp.persunit.PersistenceUtilites;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



/**
 *
 * @author Oguzhan
 */
public class RoleRepository {
    

   private EntityManager em;
  
    public RoleRepository(EntityManager entityManager){
       this.em = entityManager;
    }

    public RoleRepository() {
       
    }
    
      
    public void persist(Role role){
        em.persist(role);  
    }
   
      public void create (Role role){

      EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
          try {
               entityManager.getTransaction().begin();
               entityManager.persist(role); 
               entityManager.getTransaction().commit();
          } catch (Exception e) {
               entityManager.close();
          }      
    }
         
    public List<Role> findAll(Role role) {
          EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
          TypedQuery<Role> query;
          query = entityManager.createQuery("SELECT r FROM Role r", Role.class);
          //List<Role> RoleList = new ArrayList<>();
         // for(Role Role : RoleList){
         //     System.err.println(Role.getName());
        // }
          List<Role> results = query.getResultList();
          
          return results ;
        
        
    }
    
    public void delete(Role role){
       // em = PersistenceUtilites.getFactory().createEntityManager();
       // em.getTransaction().begin();
       // em.remove(category);
       //em.getTransaction().commit();
       
        EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        entityManager.find(Role.class,role.getRoleid());

        entityManager.getTransaction().begin();
        role = entityManager.merge(role);
        entityManager.remove(role);
        entityManager.getTransaction().commit();
        
        
       
       
        //EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        //entityManager.getTransaction().begin();
        //entityManager.merge(category);
        //entityManager.find(CategoryEntity.class,category.getCategoryId());
        //entityManager.remove(category);
        //entityManager.getTransaction().commit();

        
        
    }
    
    public void update (Role role){
        EntityManager entityManager = PersistenceUtilites.getFactory().createEntityManager();
        entityManager.find(Role.class,role.getRoleid());

        entityManager.getTransaction().begin();
         role = entityManager.merge(role);
        entityManager.remove(role);
        RoleRepository categoryRepository = new RoleRepository(entityManager);
        categoryRepository.persist(role);
        
        entityManager.getTransaction().commit();
    }
}
