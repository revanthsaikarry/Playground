package hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Employee emp = new Employee();
    	
    	EmpName emp_name = new EmpName();
    	
//    	emp_name.setFname("Revanth");
//    	emp_name.setMname("sai");
//    	emp_name.setLname("Karry");
    	
    	emp.setEmp_id(101);
    	
    	emp.setEmp_name(emp_name);
    	
    	emp.setDob("30-05-1996");
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
    	
    	SessionFactory sf = con.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
//    	session.save(emp);
    	
    	emp = (Employee) session.get(Employee.class, 101);
    	
    	tx.commit();
    	
    	System.out.println(emp);
    	
    }
}
