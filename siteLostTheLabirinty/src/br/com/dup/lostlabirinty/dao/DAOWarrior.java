package br.com.dup.lostlabirinty.dao;

import javax.persistence.*;

import br.com.dup.lostlabirinty.base.Warrior;

public class DAOWarrior extends DAO<Warrior> {

	public DAOWarrior() {
		// TODO Auto-generated constructor stub
	}

	public Warrior findMyWarrior(String str) {
		try {
			Query q = manager
					.createQuery("SELECT w FROM Warrior w WHERE w.name like '%"
							+ str + "%'");
			return (Warrior) q.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("null nada");
			return null;
		}
	}

	// gets
	public Warrior getWarriors() {
		try {
			Query q = manager.createQuery("SELECT w FROM Warrior w");
			return (Warrior) q.getResultList();

		} catch (NoResultException e) {
			return null;
		}
	}

	// update status warrior
	public int updateMyWarrior(Warrior w) {
		try {
			Query q = manager.createQuery("UPDATE Warrior w SET w.lv = "
					+ w.getLv() + " , w.hp = " + w.getHp()
					+ " WHERE w.name = '" + w.getName() + "'");
			return q.executeUpdate();

		} catch (NoResultException e) {
			return 0;
		}
	}

}