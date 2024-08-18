package model.composition;

import javax.persistence.Embeddable;

//Colocando a table address dentro de supplier and employee
@Embeddable
public class Address {
	
	private String publicPlace;
	private String complement;
	
	
	public String getPublicPlace() {
		return publicPlace;
	}
	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}

}
