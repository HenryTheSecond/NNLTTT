package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import Connection.DBConnect;
import Model.HoaDon;
import Model.HoaDonBanHang;

public class HoaDonBanHangDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public HoaDonBanHang get(int maHoaDon) {
		String sql = "Select * from HoaDonbanHang where MaHoaDon=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maHoaDon);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new HoaDonBanHang(rs.getInt(1), rs.getDate(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(HoaDonBanHang hoaDon) {
		String sql = "Insert into HoaDonBanHang(Ngayban) values(?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(hoaDon.getNgayBan().getTime()));
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(HoaDonBanHang hoaDon) {
		String sql = "Update HoaDonBanHang set NgayBan=? Where MaHoaDon=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(hoaDon.getNgayBan().getTime()));
			ps.setInt(2, hoaDon.getMaHoaDon());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int maHoaDon) {
		String sql = "Delete From HoaDonBanHang where MaHoaDon=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maHoaDon);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*HoaDonBanHangDAO dao = new HoaDonBanHangDAO();
		HoaDon hoaDon = new HoaDonBanHang(new Date());
		dao.insert( (HoaDonBanHang)hoaDon);
		dao.delete(dao.get(1).getMaHoaDon());*/
	}
}
