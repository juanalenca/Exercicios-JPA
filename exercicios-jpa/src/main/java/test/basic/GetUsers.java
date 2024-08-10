package test.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.basic.User;

public class GetUsers {

	public static void main(String[] args) {


		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setMaxResults(5);
		
		List<User> users = query.getResultList();
		
		for(User user: users) {
			System.out.println("ID: " + user.getId() + " E-mail: " + user.getEmail());
		}
		
		em.close();
		emf.close();
		
		
		
		

	}

}
