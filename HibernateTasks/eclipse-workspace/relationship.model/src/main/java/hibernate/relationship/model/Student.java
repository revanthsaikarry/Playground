package hibernate.relationship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
	
	@Id @GeneratedValue
	@Column(name = "roll_number")
	private int roll_no;
	
	@Column(name = "student_name")
	private StudentName std_name;
	
	@Column(name = "marks")
	private int marks;
	
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public StudentName getStd_name() {
		return std_name;
	}
	public void setStd_name(StudentName std_name) {
		this.std_name = std_name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", std_name=" + std_name + ", marks=" + marks + "]";
	}
	
}
