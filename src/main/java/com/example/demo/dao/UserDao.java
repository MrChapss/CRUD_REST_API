package com.example.demo.dao;
import java.sql.*;
import org.springframework.stereotype.*;
import com.example.demo.util.DBConnection;

@Repository("userDao")
public class UserDao {
	Connection conn = DBConnection.getConnection();
	public void CreateUser(String name, int age, String underage) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO USERS(USER_NAME, AGE, IS_UNDERAGE) VALUES (?,?,?)"
			)) {
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, underage);
			ps.executeUpdate();
		}
	}
	
	public void DeleteUser(String name) throws Exception{
		try(PreparedStatement ps = conn.prepareStatement(
				"DELETE FROM USERS WHERE USER_NAME = (?)"
				)) {
			ps.setString(1, name);
			ps.executeUpdate();
		}
	}
	// not working 
	public void ViewUser(String name) throws Exception{
		try(PreparedStatement ps = conn.prepareStatement(
				"SELECT USER_nAME FROM USERS VALUES (?)"
				)){
			ps.setString(1, name);
			ps.executeQuery();
		}
	}
}






