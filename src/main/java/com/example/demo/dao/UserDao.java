package com.example.demo.dao;
import java.sql.*;
import org.springframework.stereotype.*;
import com.example.demo.util.DBConnection;
import com.example.demo.entity.*;
import java.util.*;

@Repository("userDao")
public class UserDao {
	final Connection conn = DBConnection.getConnection();
	// method for database to store the created todo 
	public void createTDL(String title, String description, boolean is_completed) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO TDL_LIST(TITLE, DESCRIPTION, IS_COMPLETED) VALUES (?,?,?)"
			)) {
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setBoolean(3, is_completed);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// method for database to be updated using the id
	public void updateTDL(int id, String title, String description, boolean is_completed) throws Exception {
		try (PreparedStatement ps = conn.prepareStatement(
				"UPDATE TDL_LIST SET TITLE = ?, DESCRIPTION = ?, IS_COMPLETED = ? WHERE ID = (?)"
				)) {
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setBoolean(3, is_completed);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// method for deleting a todo from database
	public void deleteTDL(int id) throws Exception{
		try(PreparedStatement ps = conn.prepareStatement(
				"DELETE FROM TDL_LIST WHERE ID = (?)"
				)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// method for viewing todo all list
	// still not working
	// must fix this later
	public List<TDL> viewTDL() throws Exception{
		String sql = "SELECT * FROM TDL_LIST";
		List<TDL> todos = new ArrayList<>();
		
		try(PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				Boolean is_completed = rs.getBoolean("is_completed");
				
				todos.add(new TDL(id, title, description, is_completed));
				
			}
		}
		return todos;
	}
	
}






