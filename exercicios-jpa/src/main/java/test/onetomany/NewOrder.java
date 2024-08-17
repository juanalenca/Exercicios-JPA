package test.onetomany;

import infra.DAO;
import model.basic.Product;
import model.onetomany.ItemOrdered;
import model.onetomany.CustomerOrder;

public class NewOrder {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		CustomerOrder order = new CustomerOrder();
		Product product = new Product("Refrigerator", 599.69);
		ItemOrdered item = new ItemOrdered(order, product, 10);
		
		order.addItem(item);
		
		try {
			dao.openTransaction()
				.includeTransaction(product)
				.includeTransaction(order)
				.closeTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            dao.closeEntityManager();
        }

	}

}
