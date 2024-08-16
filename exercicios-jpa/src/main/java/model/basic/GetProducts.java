package model.basic;

import java.util.List;

import infra.ProductDAO;

public class GetProducts {
	
	
	public static void main(String[] args) {
		
		
		ProductDAO dao = new ProductDAO();
		
		List<Product> products = dao.getAll();
		
		for(Product product: products) {
			System.out.println("ID: " + product.getId() + ", Name: " + product.getName());
		}
		
		double absolutPrice = products
				.stream()
				.map(p -> p.getPrice())
				.reduce(0.0, (absolute, price) -> absolute + price) 
				.doubleValue();
		
		System.out.println("The absolute price is $" + absolutPrice);
		
		dao.closeEntityManager();
		
	}

}
