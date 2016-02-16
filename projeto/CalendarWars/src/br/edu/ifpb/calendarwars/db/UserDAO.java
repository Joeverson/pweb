package br.edu.ifpb.calendarwars.db;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.calendarwars.entities.User;
import antlr.collections.List;

public class UserDAO extends GenericDAOQuerys<User, Long>{
	//todo fazer um search melhor		
		public User auth(String login, String pass){					
			System.out.println("gravou");  
			Query q = e.createQuery("from Turma t where t.pass = :pass and t.name= :login");
			 
			 q.setParameter(":pass", pass);
			 q.setParameter(":login", pass);
			 System.out.println(e.toString());	
			 return (User) q.getResultList().get(0);			 
		}
		
		//select
		public List getAll(){
			EntityManager e = CoreDB.Instance();
			return (List) e.createQuery("FROM "+UserDAO.class.getName()).getResultList();				
		}
}
