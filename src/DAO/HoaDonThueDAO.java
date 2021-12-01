package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Connection.DBConnect;
import Model.BangDia;
import Model.HoaDonBanHang;
import Model.HoaDonThue;
import Model.KhachHang;

public class HoaDonThueDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public HoaDonThue get(int maHoaDon) {
		String sql = "Select * from HoaDonThue where MaHoaDon=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maHoaDon);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new HoaDonThue(rs.getInt(1), rs.getDate(2), new KhachHangDAO().get(rs.getInt(3)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(HoaDonThue hoaDon) {
		String sql = "Insert into HoaDonThue(NgayThue,MaKH) values(?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setDate(1,  new java.sql.Date(hoaDon.getNgayThue().getTime()) );
			ps.setInt(2, hoaDon.getKhachHang().getMaKH());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(HoaDonThue hoaDon) {
		String sql = "Update HoaDonThue set NgayThue=?, MaKH=? Where MaHoaDon=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setDate(1,  new java.sql.Date(hoaDon.getNgayThue().getTime()) );
			ps.setInt(2, hoaDon.getKhachHang().getMaKH());
			ps.setInt(3, hoaDon.getMaHoaDon());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int maHoaDon) {
		String sql = "Delete From HoaDonThue Where MaHoaDon=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maHoaDon);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<HoaDonThue> getHoaDonThueTheoKhachHang(int maKH){
		String sql = "Select * From HoaDonThue Where MaKH=?";
		List<HoaDonThue> list = new ArrayList<HoaDonThue>();
		KhachHang kh = new KhachHangDAO().get(maKH);
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maKH);
			rs = ps.executeQuery();
			while(rs.next()) {
				HoaDonThue hd = new HoaDonThue(rs.getInt(1), rs.getDate(2), kh);
				list.add(hd);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		/*HoaDonThueDAO dao = new HoaDonThueDAO();
		HoaDonThue hd = new HoaDonThue(new Date(), new KhachHangDAO().get(1));
		dao.insert(hd);*/
		
		System.out.println(new KhachHangDAO().get(1).getDsThue());
		
	}
}
