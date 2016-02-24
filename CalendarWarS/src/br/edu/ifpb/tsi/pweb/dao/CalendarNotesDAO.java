package br.edu.ifpb.tsi.pweb.dao;



import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.tsi.pweb.model.Note;

public class CalendarNotesDAO extends GenericDAOJPAImpl<Note, Long>{
	private static Logger logger = Logger.getLogger(CalendarNotesDAO.class);
	
	public CalendarNotesDAO(EntityManager instance){
		super(instance);
	}

	
}
