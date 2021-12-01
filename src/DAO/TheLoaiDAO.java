package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnect;
import Model.TheLoai;

public class TheLoaiDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public TheLoai get(int maTL) {
		String sql = "Select * from TheLoai Where MaTL=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maTL);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new TheLoai(rs.getInt(1), rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(TheLoai theLoai) {
		String sql = "Insert into TheLoai(TenTL) VALUES(?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, theLoai.getTenTL());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(TheLoai theLoai) {
		String sql = "Update TheLoai set TenTL=? Where MaTL=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, theLoai.getTenTL());
			ps.setInt(2, theLoai.getMaTL());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int maTL) {
		String sql = "Delete from TheLoai where MaTL=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maTL);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TheLoaiDAO dao = new TheLoaiDAO();
		TheLoai tl = new TheLoai("Hành động");
		dao.insert(tl);
	}
}
