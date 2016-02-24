package br.edu.ifpb.tsi.pweb.dao;


import javax.persistence.EntityManager;
import br.edu.ifpb.tsi.pweb.model.Holydays;
import org.jboss.logging.Logger;

public class HolydaysDAO extends GenericDAOJPAImpl<Holydays, Long>{
	private static Logger logger = Logger.getLogger(HolydaysDAO.class);
	
	public HolydaysDAO(EntityManager instance){
		super(instance);
	}	
}
