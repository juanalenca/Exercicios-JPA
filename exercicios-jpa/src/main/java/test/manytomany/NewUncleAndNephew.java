package test.manytomany;

import infra.DAO;
import model.manytomany.Nephew;
import model.manytomany.Uncle;

public class NewUncleAndNephew {

	public static void main(String[] args) {

		Uncle aunt1 = new Uncle("Mary");
		Uncle uncle2 = new Uncle("John");

		Nephew nephew1 = new Nephew("David");
		Nephew nephew2 = new Nephew("Ana");

		aunt1.getNephews().add(nephew1);
		nephew1.getUncles().add(aunt1);

		aunt1.getNephews().add(nephew2);
		nephew2.getUncles().add(aunt1);

		uncle2.getNephews().add(nephew1);
		nephew1.getUncles().add(uncle2);

		uncle2.getNephews().add(nephew2);
		nephew2.getUncles().add(uncle2);

		DAO<Object> dao = new DAO<>();

		try {
			dao.openTransaction()
				.includeTransaction(aunt1)
				.includeTransaction(uncle2)
				.includeTransaction(nephew1)
				.includeTransaction(nephew2)
				.closeTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.closeEntityManager();
		}

	}

}
