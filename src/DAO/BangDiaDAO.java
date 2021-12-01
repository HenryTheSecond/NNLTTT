package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnect;
import Model.BangDia;
import Model.User;

public class BangDiaDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public BangDia get(int maDia) {
		String sql = "select * from BangDia where MaDia=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maDia);
			rs = ps.executeQuery();
			while(rs.next()) {
				BangDia dia = new BangDia(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getFloat(6), rs.getFloat(7), new TheLoaiDAO().get(rs.getInt(8)));
				
				return dia;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(BangDia dia) {
		String sql = "Insert into BangDia(TenLoaiDia, SoLuong, SoLuongThue, DangThue, GiaBan, GiaThue, MaTL) VALUES(?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dia.getTenLoaiDia());
			ps.setInt(2, dia.getSoLuong());
			ps.setInt(3, dia.getSoLuongThue());
			ps.setInt(4, dia.getDangThue());
			ps.setFloat(5, dia.getGiaBan());
			ps.setFloat(6, dia.getGiaThue());
			ps.setInt(7, dia.getTheLoai().getMaTL());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(BangDia dia) {
		String sql = "Update BangDia Set TenLoaiDia=?, SoLuong=?, SoLuongThue=?, DangThue=?, GiaBan=?, GiaThue=?, MaTL=? WHERE MaDia=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dia.getTenLoaiDia());
			ps.setInt(2, dia.getSoLuong());
			ps.setInt(3, dia.getSoLuongThue());
			ps.setInt(4, dia.getDangThue());
			ps.setFloat(5, dia.getGiaBan());
			ps.setFloat(6, dia.getGiaThue());
			ps.setInt(7, dia.getTheLoai().getMaTL());
			ps.setInt(8, dia.getMaDia());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int maDia) {
		String sql = "Delete From BangDia Where MaDia=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maDia);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BangDia> getBangDiaTheoTheLoai(int maTL){
		String sql = "Select * From BangDia where MaTL=?";
		List<BangDia> list = new ArrayList<BangDia>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maTL);
			rs = ps.executeQuery();
			while(rs.next()) {
				BangDia dia = new BangDia(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getFloat(6), rs.getFloat(7), new TheLoaiDAO().get(rs.getInt(8)));
				list.add(dia);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		BangDiaDAO dao = new BangDiaDAO();
		/*BangDia dia = new BangDia("Departure", 10, 5, 0, 15, 3, new TheLoaiDAO().get(2));
		dao.insert(dia);*/
		
		System.out.println(dao.get(2).getDsChiTietBanHang().get(0).getGia());
	}
}
