package br.edu.ifpb.calendarwars.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifpb.calendarwars.entities.User;

public class CoreDB {
	private static EntityManager entity;
	
	private CoreDB(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("calendar");
		this.entity = factory.createEntityManager();
	}
	
	//criando uma unica instancia do db e recuperando caso ela ja esteja sido criado.
	public static EntityManager Instance(){
		if(entity == null)
			new CoreDB();
		
		return entity;
	}
	public static void InstanceNull(){
		entity = null;
	}

}
