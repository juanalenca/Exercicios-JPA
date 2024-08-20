package test.consult;

import infra.DAO;
import model.consult.NoteMovie;

public class GetAverageMovies {

	public static void main(String[] args) {
		
		DAO<NoteMovie> dao = new DAO<>(NoteMovie.class);
		NoteMovie note = dao.consultOne("getOverallAverageOfMovies");
		
		
		System.out.println(note.getAverage());

		
		dao.closeEntityManager();
		
	}

}
