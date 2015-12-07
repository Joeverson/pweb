package br.com.dup.lostlabirinty.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO<T> implements DAOInterface<T> {
	protected static EntityManager manager;

	public static void open() {
		if (manager == null) {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("labirinty");
			manager = factory.createEntityManager();
		}
	}

	public static void close() {
		if (manager != null)
			manager = null;
	}

	public void create(T obj) {
		manager.persist(obj);
	}

	public void delete(T obj) {
		manager.remove(obj);
	}

	public T update(T obj) {
		return manager.merge(obj);
	}

	public void refresh(T obj) {
		manager.refresh(obj);
	}

	@SuppressWarnings("unchecked")
	public T read(Object chaveprimaria) {
		// determinar o tipo (a classe) da chave primaria
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return manager.find(type, chaveprimaria);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll() {
		// determinar o tipo (a classe) de T
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println("nome da classe que retornara uma lista é: "
				+ type.getSimpleName());
		Query query = manager.createQuery("select x from "
				+ type.getSimpleName() + " x");

		return (List<T>) query.getResultList();
	}

	// ----------------------- TRANSA��O ----------------------

	public static void begin() {
		open();
		if (!manager.getTransaction().isActive()) // evita duas transações
			manager.getTransaction().begin();
	}

	public static void commit() {
		if (manager.getTransaction().isActive()) {
			manager.getTransaction().commit();
			manager.clear(); // esvaziar o cache de objetos
			close();
		}
	}

	public static void rollback() {
		if (manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}

	public static void flush() { // commit local
		manager.flush();
	}

	// open()
	// modificacao dinamica do persistent.xml
	// if(manager==null){
	// HashMap<String,String> properties = new HashMap<String,String>();
	//
	// substituindo as propriedades do persistence.xml
	// properties.put(PersistenceUnitProperties.JDBC_DRIVER,
	// "org.postgresql.Driver" );
	// properties.put(PersistenceUnitProperties.JDBC_URL,
	// "jdbc:postgresql://localhost:5432/agenda");
	// properties.put(PersistenceUnitProperties.JDBC_USER, "postgres");
	// properties.put(PersistenceUnitProperties.JDBC_PASSWORD, "ifpb");
	// properties.put(PersistenceUnitProperties.LOGGING_LEVEL, "fine");
	// properties.put(PersistenceUnitProperties.DDL_GENERATION,
	// "create-tables");
	// properties.put(PersistenceUnitProperties.DDL_GENERATION_MODE,
	// "database");
	// EntityManagerFactory factory =
	// Persistence.createEntityManagerFactory("agenda",properties);
	// manager = factory.createEntityManager();
	// }

}
