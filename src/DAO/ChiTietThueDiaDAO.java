package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Connection.DBConnect;
import Model.BangDia;
import Model.ChiTietBanHang;
import Model.ChiTietThueDia;
import Model.HoaDonThue;

public class ChiTietThueDiaDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	HoaDonThueDAO hoaDonDAO = new HoaDonThueDAO();
	BangDiaDAO bangDiaDAO = new BangDiaDAO();
	
	public List<ChiTietThueDia> getAllChiTietThueDia(){
		String sql = "Select * From ChiTietThueDia";
		List<ChiTietThueDia> list = new ArrayList<ChiTietThueDia>();
		BangDiaDAO bangDiaDAO = new BangDiaDAO();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add( new ChiTietThueDia(rs.getInt(1), hoaDonDAO.get(rs.getInt(2)), bangDiaDAO.get(rs.getInt(3)), rs.getInt(4), rs.getFloat(5), rs.getDate(6), rs.getFloat(7)) );
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<ChiTietThueDia> getChiTietThueDiaByMaDia(int maDia){
		String sql = "Select * From ChiTietThueDia where DiaID=?";
		List<ChiTietThueDia> list = new ArrayList<ChiTietThueDia>();
		BangDia dia = bangDiaDAO.get(maDia);
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maDia);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add( new ChiTietThueDia(rs.getInt(1), hoaDonDAO.get(rs.getInt(2)), dia, rs.getInt(4), rs.getFloat(5), rs.getDate(6), rs.getFloat(7)) );
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ChiTietThueDia> getChiTietThueDiaByMaHoaDon(int maHoaDon){
		String sql = "select * from ChiTietThueDia where MaHoaDon=?";
		List<ChiTietThueDia> list = new ArrayList<ChiTietThueDia>();
		HoaDonThue hoaDon = hoaDonDAO.get(maHoaDon);
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maHoaDon);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add( new ChiTietThueDia(rs.getInt(1), hoaDon, bangDiaDAO.get(rs.getInt(3)), rs.getInt(4), rs.getFloat(5), rs.getDate(6), rs.getFloat(7)) );

			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<ChiTietThueDia> getDiaChuTraByMaKH(int maKH){
		String sql = "select * from ChiTietThueDia where NgayTra is null and MaHoaDon in (select MaHoaDon from HoaDonThue where MaKH=?)";
		List<ChiTietThueDia> list = new ArrayList<ChiTietThueDia>();

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maKH);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add( new ChiTietThueDia(rs.getInt(1), hoaDonDAO.get(rs.getInt(2)), bangDiaDAO.get(rs.getInt(3)), rs.getInt(4), rs.getFloat(5), rs.getDate(6), rs.getFloat(7)) );

			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ChiTietThueDia get(int id) {
		String sql = "select * from ChiTietThueDia where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new ChiTietThueDia(rs.getInt(1), hoaDonDAO.get(rs.getInt(2)), bangDiaDAO.get(rs.getInt(3)), rs.getInt(4), rs.getFloat(5), rs.getDate(6), rs.getFloat(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public void insert(ChiTietThueDia chiTiet) {
		String sql = "Insert into ChiTietThueDia(MaHoaDon, DiaID, SoNgayThue, GiaThue, NgayTra, ThanhToan) values(?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, chiTiet.getHoaDon().getMaHoaDon());
			ps.setInt(2, chiTiet.getDia().getMaDia());
			ps.setInt(3, chiTiet.getSoNgayThue());
			ps.setFloat(4, chiTiet.getGia());
			ps.setDate(5, chiTiet.getNgayTra()==null? null : new java.sql.Date(chiTiet.getNgayTra().getTime()) );
			ps.setFloat(6, chiTiet.getThanhToan());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(ChiTietThueDia chiTiet) {
		String sql = "Update ChiTietThueDia set MaHoaDon=?, DiaID=?, SoNgayThue=?, GiaThue=?, NgayTra=?, ThanhToan=? Where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, chiTiet.getHoaDon().getMaHoaDon());
			ps.setInt(2, chiTiet.getDia().getMaDia());
			ps.setInt(3, chiTiet.getSoNgayThue());
			ps.setFloat(4, chiTiet.getGia());
			ps.setDate(5, chiTiet.getNgayTra()==null? null : new java.sql.Date(chiTiet.getNgayTra().getTime()) );
			ps.setFloat(6, chiTiet.getThanhToan());
			ps.setInt(7, chiTiet.getId());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "Delete From ChiTietThueDia where id=?";
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
		ChiTietThueDiaDAO dao = new ChiTietThueDiaDAO();
		/*ChiTietThueDia ct = new ChiTietThueDia(new HoaDonThueDAO().get(2), new BangDiaDAO().get(2), 10, 10, null, 0);
		dao.insert(ct);*/
		
		ChiTietThueDia ct = dao.get(2);
		/*ct.setNgayTra(new Date());
		dao.update(ct);*/
		
		//System.out.println( new HoaDonThueDAO().get(2).getDsChiTietThue()  );
		System.out.println(dao.getDiaChuTraByMaKH(1));
	}
	
}
