package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class AlterUser1 {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		User user = em.find(User.class, 1L);
		user.setName("Fulano");
		user.setEmail("Fulano@lanche.com.br");
		
		//faz o update no estado gerenciado
		em.merge(user);
		
		em.getTransaction().commit();

		
		em.close();
		emf.close();
		
		
	}

}
