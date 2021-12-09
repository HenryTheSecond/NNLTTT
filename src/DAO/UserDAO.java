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
	
	public User getByUsername(String username) {
		String sql = "select * from users where Username=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
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
	
	
	public int kiemTraDangNhap(int isAdmin, String username, String password ) {
		String sql = "Select * from users where isAdmin = ? and Username = ? and Password = ?;";
		User user = new User();
		user.setIsAdmin(2);
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, isAdmin);
			ps.setString(2, username);
			ps.setString(3, password);
			rs = ps.executeQuery();
			//Lấy về đối tượng để mốt có muốn trả về đối tượng thì chỉ cần thay kiểu giá trị trả về
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setTenNV(rs.getString(4));
				user.setSDT(rs.getString(5));
				user.setNgaySinh(rs.getDate(6));
				user.setGioiTinh(rs.getString(7));
				user.setIsAdmin(rs.getInt(8));
				if(user.getIsAdmin() == 1)
					return 1;
				else if(user.getIsAdmin() == 0)
					return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 2;
	}
	
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		/*User u = new User("tuyen", "123", "vct", "123", new Date(), "nam", 1);
		dao.insert(u);*/
		User u = dao.get(1);

		dao.delete(u.getId());
	}
}
