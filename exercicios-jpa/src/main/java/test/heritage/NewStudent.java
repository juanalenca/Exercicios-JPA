package test.heritage;

import infra.DAO;
import model.heritage.ScholarshipStudent;
import model.heritage.Student;

public class NewStudent {

	public static void main(String[] args) {


		DAO<Student> studentDAO = new DAO<>();
		
		Student student1 = new Student(123L, "Juan");
		ScholarshipStudent student2 = new ScholarshipStudent(345L, "Maria", 1000);
				
		studentDAO.includeAtomic(student1);
		studentDAO.includeAtomic(student2);
		
		studentDAO.closeEntityManager();
		

	}

}
