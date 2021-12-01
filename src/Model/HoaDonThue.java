package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.ChiTietThueDiaDAO;

public class HoaDonThue extends HoaDon {
	private Date ngayThue;
	private KhachHang khachHang;
	private List<ChiTietThueDia> dsChiTietThue = new ArrayList<ChiTietThueDia>();
	
	public Date getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(Date ngayThue) {
		this.ngayThue = ngayThue;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public List<ChiTietThueDia> getDsChiTietThue() {
		return new ChiTietThueDiaDAO().getChiTietThueDiaByMaHoaDon(this.getMaHoaDon());
	}
	public void setDsChiTietThue(List<ChiTietThueDia> dsChiTietThue) {
		this.dsChiTietThue = dsChiTietThue;
	}
	
	public HoaDonThue(int maHoaDon, Date ngayThue, KhachHang khachHang, List<ChiTietThueDia> dsChiTietThue) {
		this.ngayThue = ngayThue;
		this.khachHang = khachHang;
		this.dsChiTietThue = dsChiTietThue;
	}
	
	public HoaDonThue(int maHoaDon) {
		super(maHoaDon);
	}
	
	public HoaDonThue() {
		
	}
	
	public HoaDonThue(int maHoaDon, Date ngayThue, KhachHang khachHang) {
		super(maHoaDon);
		this.ngayThue = ngayThue;
		this.khachHang = khachHang;
	}
	
	public HoaDonThue(Date ngayThue, KhachHang khachHang) {
		this.ngayThue = ngayThue;
		this.khachHang = khachHang;
	}
	
	
	
}
