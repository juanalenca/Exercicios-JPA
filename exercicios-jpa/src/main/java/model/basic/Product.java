package model.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products", schema = "course_java")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//nullable é se aceita ou não valores núlos
	@Column(name = "product_name", length = 200, nullable = false)
	private String name; 

	//precision é o tamanho do valora antes da vírgula
	//lae é o numero de casas decimais após a vírgula
	@Column(name = "product_price", nullable = false, precision = 11, scale = 2)
	private double price;
	
	
	
	public Product() {
	}
	
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
