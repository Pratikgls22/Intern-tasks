package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Vo.RegVo;

public class RegDao {
	public void save(RegVo regVo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mvc","root","root");
			Statement st = con.createStatement();
			String sql = "insert into jdbc (firstname,lastname) values ('"+regVo.getFirstName()+"','"+regVo.getLastName()+"')";
			st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		};
		
	}
}
