package br.edu.ifpb.calendarwars.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifpb.calendarwars.entities.User;

public class CoreDB {
	private static EntityManager entity = null;
	private static EntityManagerFactory factory;
	private CoreDB(){
		try{
			factory = Persistence.createEntityManagerFactory("calendar");
			this.entity = factory.createEntityManager();
		}catch(Exception e){
			e.getMessage();
			System.out.println("não conseguiu criar a conexão");
		}
	}
	
	//criando uma unica instancia do db e recuperando caso ela ja esteja sido criado.
	public static EntityManager Instance(){
		if(entity == null)
			new CoreDB();
		
		return entity;
	}
	public static void InstanceNull(){
		if(entity != null){
			entity.close();
			factory.close();
			entity = null;
			factory = null;
		}		
	}
}
