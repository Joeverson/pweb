package br.edu.ifpb.calendarwars.db;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.calendarwars.entities.User;
import antlr.collections.List;

public class UserDAO extends GenericDAOQuerys<User, Long>{
	//todo fazer um search melhor		
		public UserDAO(EntityManager instance){
			super(instance);
		}
		public User auth(String login, String pass){		
			
			try{
				Query q = e.createQuery("select t from User t where t.pass = '"+pass+"' and t.user= '"+login+"'");				
				return (User) q.getSingleResult();				
			}catch(NoResultException e){
				System.out.println("erro na autenticação");
				e.getMessage();
				return null;
			}	
		}
		
		//select
		public List getAll(){
			EntityManager e = CoreDB.Instance();
			return (List) e.createQuery("FROM "+UserDAO.class.getName()).getResultList();				
		}
}
