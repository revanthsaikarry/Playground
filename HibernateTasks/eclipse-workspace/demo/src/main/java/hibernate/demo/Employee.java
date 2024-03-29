package hibernate.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	int emp_id;
	EmpName emp_name;
	String dob;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	public EmpName getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(EmpName emp_name) {
		this.emp_name = emp_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", dob=" + dob + "]";
	}
	
	
}
