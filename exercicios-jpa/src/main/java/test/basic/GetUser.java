package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class GetUser {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, 7L);
		System.out.println(user.getName());
		
		em.close();
		emf.close();
		

	}

}
