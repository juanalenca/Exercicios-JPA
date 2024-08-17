package test.onetoone;

import infra.DAO;
import model.onetoone.Client;
import model.onetoone.Seat;

public class GetClientSeat {

	public static void main(String[] args) {


		DAO<Client> daoClient = new DAO<>(Client.class);
		Client client = daoClient.getById(1L);
		
		System.out.println(client.getSeat().getName());
		System.out.println(client.getSeat().getClient().getName());
		
		daoClient.closeEntityManager();
		
		
		DAO<Seat> daoSeat = new DAO<>(Seat.class);
		Seat seat = daoSeat.getById(4L);
		
		System.out.println(seat.getClient().getName());
		
		daoSeat.closeEntityManager();

		
	}

}
