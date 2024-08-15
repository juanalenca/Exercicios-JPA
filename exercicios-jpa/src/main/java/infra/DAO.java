package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.basic.Product;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> Class;
	
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// logar -> log4j
		}
	}
	
	
	public DAO() {
		this(null);
	}
	
	
	public DAO(Class<E> ConstructorClass) {
		this.Class = ConstructorClass;
		em = emf.createEntityManager();
	}
	
	
	public DAO<E> test(){
		
		return this;
	}
	
	
	public DAO<E> openTransaction(){
		em.getTransaction().begin();
		return this;
	}
	
	
	public DAO<E> closeTransaction(){
		em.getTransaction().commit();
		return this;
	}
	
	
	public DAO<E> includeTransaction(E entity){
		em.persist(entity);
		return this;
	}
	
	
	public DAO<E> includeAtomic(E entity){
		return this.openTransaction().includeTransaction(entity).closeTransaction();
	}
	
	
	public List<E> getAll() {
		return this.getAll(10, 0);
	}
	
	
	//numberOfRecords = quantidade de registros, displacement = delocamento
	public List<E> getAll(int numberOfRecords, int displacement) {
		
		if(Class == null) {
			throw new UnsupportedOperationException("The class is null.");
		}
		
		String jpql = "select e from " + Class.getName() + " e";
		
		TypedQuery<E> query = em.createQuery(jpql, Class);
		
		query.setMaxResults(numberOfRecords);
		query.setFirstResult(displacement);
		
		return query.getResultList();
		
	}
	
	
	public void closeEntityManager() {
		em.close(); 
	}

	
	
	public static void main(String[] args) {
		
		new DAO<Product>().test().test();
		
	}
	
}
