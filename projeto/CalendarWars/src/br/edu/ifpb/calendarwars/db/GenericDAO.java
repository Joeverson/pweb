package br.edu.ifpb.calendarwars.db;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {	
	    T insert(T t);
	    T find(PK id);
	    void update(T t);
	    void delete(T t);	   
}
