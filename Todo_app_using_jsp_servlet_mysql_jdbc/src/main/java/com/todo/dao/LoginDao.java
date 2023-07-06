package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.model.Login_User;
import com.demo.util.JDBCUtil;

public class LoginDao {

	public String query="Select * from users where email=? and password=?";
	public boolean validuser(Login_User user) {
		boolean status= false;
		
		try (Connection con = JDBCUtil.getConnection();
				PreparedStatement ps= con.prepareStatement(query);) {
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				status=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
