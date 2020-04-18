package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DBUtils;

public class Account {
	private Integer user_id;
	private String username;
	private String password;
	private String email;
	
	public Integer getUserId() {
		return user_id;
	}
	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Account doLogin() {
		Account acc = new Account();
		String sql_stmt = "SELECT * FROM Account WHERE email = ? AND password = ?";
		Connection cn = DBUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = cn.prepareStatement(sql_stmt);
			statement.setString(1, this.getEmail());
			statement.setString(2, this.getPassword());
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				acc.setUserId(Integer.parseInt(resultSet.getString("user_id")));
				acc.setEmail(resultSet.getString("email"));
				acc.setUsername(resultSet.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	

}
