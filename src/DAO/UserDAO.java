package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import Connection.DBConnect;
import Model.User;

public class UserDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public User get(int id) {
		String sql = "select * from users where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setTenNV(rs.getString(4));
				user.setSDT(rs.getString(5));
				user.setNgaySinh(rs.getDate(6));
				user.setGioiTinh(rs.getString(7));
				user.setIsAdmin(rs.getInt(8));
				
				return user;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(User user) {
		String sql = "Update users set tennv=?, sdt=?, NgaySinh=?, GioiTinh=?, isAdmin=? where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getTenNV());
			ps.setString(2, user.getSDT());
			ps.setDate(3, new java.sql.Date(user.getNgaySinh().getTime()) );
			ps.setString(4, user.getGioiTinh());
			ps.setInt(5, user.getIsAdmin());
			ps.setInt(6, user.getId());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "Delete From users where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(User user) {
		String sql = "Insert into users(username, password, TenNV, SDT, NgaySinh, GioiTinh, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getTenNV());
			ps.setString(4, user.getSDT());
			ps.setDate(5, new java.sql.Date(user.getNgaySinh().getTime()));
			ps.setString(6, user.getGioiTinh());
			ps.setInt(7, user.getIsAdmin());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		/*User u = new User("tuyen", "123", "vct", "123", new Date(), "nam", 1);
		dao.insert(u);*/
		User u = dao.get(1);

		dao.delete(u.getId());
	}
}
