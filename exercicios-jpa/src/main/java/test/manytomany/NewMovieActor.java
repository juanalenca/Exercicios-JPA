package test.manytomany;

import infra.DAO;
import model.manytomany.Actor;
import model.manytomany.Movie;

public class NewMovieActor {

	public static void main(String[] args) {

		Movie movieA = new Movie("The Wolf Of Wall Street", 8.9);
		Movie movieB = new Movie("Shutter Island", 8.1);
		
		Actor actorA = new Actor("Leonardo DiCaprio");
		Actor actressB = new Actor("Margot Robbie");
		
		movieA.addActor(actorA);
		movieA.addActor(actressB);
		
		movieB.addActor(actorA);
		
		DAO<Movie> dao = new DAO<Movie>();
		dao.includeAtomic(movieA);		

	}

}
