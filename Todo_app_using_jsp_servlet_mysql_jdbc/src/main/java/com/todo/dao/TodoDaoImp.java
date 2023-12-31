package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Todo;
import com.demo.util.JDBCUtil;

public class TodoDaoImp implements TodoDao {

	private static final String INSERT_TODOS_SQL = "INSERT INTO todos" +
	        "  (title, email, description, target_date,  isDone) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_TODO_BY_ID = "select id,title,email,description,target_date,isDone from todos where id =?";
	private static final String SELECT_ALL_TODOS = "select * from todos where email =?";
	private static final String DELETE_TODO_BY_ID = "delete from todos where id = ?;";
	private static final String UPDATE_TODO = "update todos set title = ?, email= ?, description =?, target_date =?, isDone = ? where id = ?;";

	public TodoDaoImp() {}
	
	@Override
	public void insertTodo(Todo todo) throws SQLException {
		System.out.println(INSERT_TODOS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBCUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL)) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getEmail());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setDate(4, JDBCUtil.getSQLDate(todo.getTargetDate()));
            preparedStatement.setBoolean(5, todo.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JDBCUtil.printSQLException(exception);
        }
		
	}
	
	@Override
	public Todo selectTodo(int todoId) {
		Todo todo = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtil.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID);) {
			preparedStatement.setInt(1, todoId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String username = rs.getString("email");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean isDone = rs.getBoolean("isDone");
				todo = new Todo(id, title, username, description, targetDate, isDone);
			}
		} catch (SQLException exception) {
			JDBCUtil.printSQLException(exception);
		}
		return todo;
	}
	
	@Override
	public List<Todo> selectAllTodos(String email) {
		List < Todo > todos = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtil.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS);) {
        	preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String username = rs.getString("email");
                String description = rs.getString("description");
                LocalDate targetDate = rs.getDate("target_date").toLocalDate();
                boolean isDone = rs.getBoolean("isDone");
                todos.add(new Todo(id, title, username, description, targetDate, isDone));
            }
        } catch (SQLException exception) {
            JDBCUtil.printSQLException(exception);
        }
        return todos;
	}

	@Override
	public boolean deleteTodo(int id) throws SQLException {
		boolean rowDeleted;
        try (Connection connection = JDBCUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TODO_BY_ID);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
	}

	@Override
	public boolean updateTodo(Todo todo) throws SQLException {
		boolean rowUpdated;
        try (Connection connection = JDBCUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TODO);) {
            statement.setString(1, todo.getTitle());
            statement.setString(2, todo.getEmail());
            statement.setString(3, todo.getDescription());
            statement.setDate(4, JDBCUtil.getSQLDate(todo.getTargetDate()));
            statement.setBoolean(5, todo.getStatus());
            statement.setLong(6, todo.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
	}

}
