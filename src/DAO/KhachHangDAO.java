package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnect;
import Model.KhachHang;

public class KhachHangDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public KhachHang get(int maKH) {
		String sql = "select * from KhachHang where MaKH=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maKH);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(KhachHang kh) {
		String sql = "Insert into KhachHang(TenKH, DiaChi, SoDT) values(?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, kh.getTenKH());
			ps.setString(2, kh.getDiaChi());
			ps.setString(3, kh.getSoDT());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(KhachHang kh) {
		String sql = "Update KhachHang set TenKH=?, DiaChi=?, SoDT=? WHERE MaKH=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, kh.getTenKH());
			ps.setString(2, kh.getDiaChi());
			ps.setString(3, kh.getSoDT());
			ps.setInt(4, kh.getMaKH());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int maKH) {
		String sql = "Delete from KhachHang where MaKH=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maKH);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		KhachHangDAO dao = new KhachHangDAO();
		/*KhachHang kh= new KhachHang("Tuyen", "Binh Duong", "1234");
		dao.insert(kh);*/
		KhachHang kh = dao.get(1);
		kh.setDiaChi("Bình Dương Thuận An");
		dao.update(kh);
		System.out.println(dao.get(1).getTenKH());
	}
}
