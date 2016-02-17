package br.edu.ifpb.calendarwars.db;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;


public class GenericDAOQuerys<T, PK extends Serializable> implements GenericDAO<T, PK>{
	
	protected Class<T> entityClass;
	protected EntityManager e;
	
	public GenericDAOQuerys(EntityManager instance) {		
		this.e = instance;
		
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	//create
	public T insert(T user){
		try{
			System.out.println(e);
			e.getTransaction().begin();
			e.persist(user);
			e.getTransaction().commit();	
		}catch(Exception exc){
			exc.printStackTrace();
			e.getTransaction().rollback();			
		}
		return user;	
	}
	
	//select
	public T find(PK id){
		return e.find(entityClass, id);		
	}		
	
	//update
	
	public void update(T t){		
		try{
			e.getTransaction().begin();
			e.merge(t);
			e.getTransaction().commit();	
		}catch(Exception exc){
			exc.printStackTrace();
			e.getTransaction().rollback();			
		}	
	}
	
	//delete	
	public void delete(T t){
		try{
			e.getTransaction().begin();
			t = e.merge(t);
			e.remove(t);
			e.getTransaction().commit();	
		}catch(Exception exc){
			exc.printStackTrace();
			e.getTransaction().rollback();			
		}	
	}
}
