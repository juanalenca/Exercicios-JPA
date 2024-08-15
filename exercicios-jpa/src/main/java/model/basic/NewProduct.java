package model.basic;

import infra.DAO;

public class NewProduct {

	public static void main(String[] args) {


		Product product = new Product("Pen", 64.66);
		
		DAO<Product> dao = new DAO<>(Product.class);
		dao.includeAtomic(product).closeEntityManager();
		
		System.out.println("Product Id: " + product.getId());
		

	}

}
