package model.onetomany;

import infra.DAO;

public class GetOrder {

	public static void main(String[] args) {


		DAO<CustomerOrder> dao = new DAO<>(CustomerOrder.class);
		CustomerOrder order = dao.getById(1L);
		
		for(ItemOrdered item: order.getItems()) {
			System.out.println(item.getQuantity());
			System.out.println(item.getProduct().getName());
		}
		
		dao.closeEntityManager();
		

	}

}
