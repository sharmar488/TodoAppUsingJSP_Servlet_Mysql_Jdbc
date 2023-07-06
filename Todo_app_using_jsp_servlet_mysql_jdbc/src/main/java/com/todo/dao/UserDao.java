package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.model.User;
import com.demo.util.JDBCUtil;

public class UserDao {
	
	public static int registerUser(User person) throws SQLException {
		
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("Insert into users(name,email,password) values(?,?,?)");
		stmt.setString(1, person.getName());		
		stmt.setString(2, person.getEmail());
		stmt.setString(3,person.getPassword());
		;
	
		int result=stmt.executeUpdate();
		
	    return result;
		
	}

}
