package model.heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SS")
public class ScholarshipStudent extends Student {
	
	private double valueScholarship;
	
	
	public ScholarshipStudent() {
	}

	public ScholarshipStudent(Long registration, String name, double valueScholarship) {
		super(registration, name);
		this.valueScholarship = valueScholarship;
	}

	
	public double getValueScholarship() {
		return valueScholarship;
	}

	public void setValueScholarship(double valueScholarship) {
		this.valueScholarship = valueScholarship;
	}
	
}
