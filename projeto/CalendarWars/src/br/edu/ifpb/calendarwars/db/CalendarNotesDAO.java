package br.edu.ifpb.calendarwars.db;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import antlr.collections.List;
import br.edu.ifpb.calendarwars.entities.CalendarNote;
import br.edu.ifpb.calendarwars.entities.User;

public class CalendarNotesDAO extends GenericDAOQuerys<CalendarNote, Long>{
	public CalendarNotesDAO(EntityManager instance){
		super(instance);
	}
	
	
	//select
	public List getAll(){		
		return (List) e.createQuery("select t from CalendarNote t").getResultList();				
	}
}
