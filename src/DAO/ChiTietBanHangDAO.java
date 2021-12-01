package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnect;
import Model.ChiTietBanHang;

public class ChiTietBanHangDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	HoaDonBanHangDAO hoaDonDAO = new HoaDonBanHangDAO();
	BangDiaDAO bangDiaDAO = new BangDiaDAO();
	
	public List<ChiTietBanHang> getChiTietBanHangByMaDia(int maDia){
		String sql = "Select * from ChiTietBanHang where MaDia=?";
		List<ChiTietBanHang> list = new ArrayList<ChiTietBanHang>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maDia);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add( new  ChiTietBanHang(rs.getInt(1), hoaDonDAO.get(rs.getInt(2)), bangDiaDAO.get(rs.getInt(3)), rs.getInt(4), rs.getFloat(5)));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ChiTietBanHang> getChiTietBanHangByMaHoaDon(int maHoaDon){
		String sql = "Select * from ChiTietBanHang where MaHoaDon=?";
		List<ChiTietBanHang> list = new ArrayList<ChiTietBanHang>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maHoaDon);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add( new  ChiTietBanHang(rs.getInt(1), hoaDonDAO.get(rs.getInt(2)), bangDiaDAO.get(rs.getInt(3)), rs.getInt(4), rs.getFloat(5)));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ChiTietBanHang get(int id) {
		String sql = "Select * from ChiTietBanHang where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new ChiTietBanHang(rs.getInt(1), hoaDonDAO.get(rs.getInt(2)), bangDiaDAO.get(rs.getInt(3)), rs.getInt(4), rs.getFloat(5));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public void insert(ChiTietBanHang chiTiet) {
		String sql = "Insert into ChiTietBanHang(MaHoaDon, MaDia, SoLuong, Gia) values(?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, chiTiet.getHoaDon().getMaHoaDon());
			ps.setInt(2, chiTiet.getDia().getMaDia());
			ps.setInt(3, chiTiet.getSoLuong());
			ps.setFloat(4, chiTiet.getGia());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(ChiTietBanHang chiTiet) {
		String sql = "Update ChiTietBanHang set MaHoaDon=?, MaDia=?, SoLuong=?, Gia=? Where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, chiTiet.getHoaDon().getMaHoaDon());
			ps.setInt(2, chiTiet.getDia().getMaDia());
			ps.setInt(3, chiTiet.getSoLuong());
			ps.setFloat(4, chiTiet.getGia());
			ps.setInt(5, chiTiet.getId());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "Delete From ChiTietBanHang where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ChiTietBanHangDAO dao = new ChiTietBanHangDAO();
		HoaDonBanHangDAO hdDAO = new HoaDonBanHangDAO();
		BangDiaDAO bdDAO = new BangDiaDAO();
		ChiTietBanHang ct = new ChiTietBanHang(hdDAO.get(2), bdDAO.get(2), 1, 15);
		dao.insert(ct);
		
		
	}
}
