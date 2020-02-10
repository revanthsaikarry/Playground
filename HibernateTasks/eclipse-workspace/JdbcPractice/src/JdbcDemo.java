import java.sql.*;
public class JdbcDemo {

	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		String username = "root";
		String pass = "root";
		String query = "select * from student;";
		String query1 = "insert into student "+" values(4,'karan')";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,pass);
			Statement st = con.createStatement();
			st.executeUpdate(query1);
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString("std_name");				
				System.out.println(name);

			}

			
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
