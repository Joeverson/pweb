package br.edu.ifpb.calendarwars.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class CalendarNote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String date;
	@Column
	private String note;
	@Column
	private String type;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	
	public CalendarNote(String date, String note, String type, User user) {
		this.date = date;
		this.note = note;
		this.type = type;
		this.user = user;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDay() {
		return this.date;
	}


	public User getUser() {
		return user;
	}
	
	
}
