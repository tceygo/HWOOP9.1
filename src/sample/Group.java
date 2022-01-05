package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Group {

	private String name = "";
	private List<Student> group = new ArrayList<>();

	public Group(String name, List<Student> group) {
		super();
		this.name = name;
		this.group = group;
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
		super();

	}

	public String getName() {
		return name;
	}

	public List<Student> getGroup() {
		return group;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGroup(List<Student> group) {
		this.group = group;
	}

	ClonProtected clon = new ClonProtected();

	public void addStudent(Student stud) {
		try {
			if (clon.ClonSearch(group, stud))
				throw new CloneExeption();
			if (group.size() > 10) {
				throw new FullExeption();
			} else if (stud != null) {
				group.add(stud);
			}
		} catch (FullExeption e) {
			System.out.println("Група заповнена студент не доданий");
		} catch (CloneExeption e) {
			System.out.println("Даний студент вже внесений в групу");
		}

	}

	public void dellStudent(long id) {
		for (Student student2 : group) {
			
			if (student2 != null && student2.getId() == id) {
				group.remove(student2);
				break;
			}
		}
	}

	public Student searchStudent(String lastName) {
		Student temp = new Student();
		try {
		for (Student student: group) {
			if (student.getLastName().equals(lastName)) {
				temp = student;
				break;
			} else {
				throw new searchStudentExeption();
			}
		}
		
		} catch (searchStudentExeption e) {
			System.out.println("Студента з прізвищем " + lastName + " не знайдено!");
		}
		return temp;
	}

	public void sortStudentsByLastName() {
		Collections.sort(group, new StudentComparator());
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", group=" + group + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(group, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(group, other.group) && Objects.equals(name, other.name);
	}
	
	

}
