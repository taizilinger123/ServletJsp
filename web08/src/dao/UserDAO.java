package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

import entity.User;

public class UserDAO {
     public User findByUsername(String username) throws Exception{
    	 User user = null;
    	 Connection conn = null;
    	 PreparedStatement prep = null;
    	 ResultSet rst = null;
    	 try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement("SELECT * FROM user " + 
					                     "WHERE username=?");
			prep.setString(1, username);
			rst = prep.executeQuery();
			if(rst.next()){
				user = new User();
				user.setId(rst.getInt("id"));
				user.setUsername(username);
				user.setPwd(rst.getString("pwd"));
				user.setName(rst.getString("name"));
				user.setGender(rst.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
    	 return user;
     }
     
     public static void main(String[] args) throws Exception{
    	 UserDAO dao = new UserDAO();
    	 User user = dao.findByUsername("king");
    	 System.out.println(user);
     }
}
