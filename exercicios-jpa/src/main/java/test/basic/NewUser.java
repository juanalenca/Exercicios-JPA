package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class NewUser {
	
	public static void main(String[] args) {
		
		//cria o EntityManager
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		
		//classe que nos ajuda a persistir os dados no database
		EntityManager em = emf.createEntityManager();
		
		User newUser = new User("Juan", "juan@lanche.com.br");
		
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		
		System.out.println("The Id generated was " + newUser.getId());
		
		em.clear();
		emf.close();
		
	}

}
