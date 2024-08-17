package test.onetoone;

import infra.DAO;
import model.onetoone.Client;
import model.onetoone.Seat;

public class NewClientSeat1 {

	public static void main(String[] args) {


		Seat seat = new Seat("16A");
		Client client = new Client("Carlos", seat);
		
		DAO<Object> dao = new DAO<>();
		
		try {
            dao.openTransaction()
               .includeTransaction(seat)
               .includeTransaction(client)
               .closeTransaction();
        } catch (Exception e) {
            if (dao != null) {
                dao.closeTransaction(); 
            }
            e.printStackTrace();
        } finally {
            dao.closeEntityManager();
        }
		

	}

}
