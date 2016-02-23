package br.edu.ifpb.tsi.pweb.dao;



import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.edu.ifpb.tsi.pweb.model.User;
import antlr.collections.List;

public class UserDAO extends GenericDAOJPAImpl<User, Long>{
	
	private static Logger logger = Logger.getLogger(UserDAO.class);
	
	//todo fazer um search melhor		
		public UserDAO(EntityManager instance){
			super(instance);
		}
		public User auth(String login, String pass){		
			
			try{
				Query q = this.getEntityManager().createQuery("select t from User t where t.pass = '"+pass+"' and t.user= '"+login+"'");				
				return (User) q.getSingleResult();				
			}catch(NoResultException e){
				System.out.println("erro na autenticação");
				e.getMessage();
				return null;
			}	
		}
		
		//select
		public List getAll(){
			return (List) this.getEntityManager().createQuery("from User t").getResultList();				
		}
}
