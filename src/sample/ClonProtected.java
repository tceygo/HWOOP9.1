package sample;

import java.util.List;

public class ClonProtected {
	
	public boolean ClonSearch (List <Student> group, Student student) {
		boolean test = false;
		for (Student students: group) {
			if(student.equals(students))
				test = true;
		}
		return test;
	}

}
