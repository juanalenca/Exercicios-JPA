package model.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Nephew {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;

	
	//Colocando o mappedBy na class Nephew, a relação mapeada estará na class Uncle
	//nephews é o nome do atributo que e na class Uncle que interliga as duas classes
	@ManyToMany(mappedBy = "nephews")
	private List<Uncle> uncles = new ArrayList<>();

	
	
	public Nephew() {
	}

	public Nephew(String name) {
		super();
		this.name = name;
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


	public List<Uncle> getUncles() {
		return uncles;
	}


	public void setUncles(List<Uncle> uncles) {
		this.uncles = uncles;
	}
	
}
