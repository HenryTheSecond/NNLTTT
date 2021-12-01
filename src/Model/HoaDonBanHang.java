package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.ChiTietBanHangDAO;

public class HoaDonBanHang extends HoaDon {
	private Date ngayBan;
	private List<ChiTietBanHang> dsChiTiet = new ArrayList<ChiTietBanHang>();
	
	public Date getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}
	public List<ChiTietBanHang> getDsChiTiet() {
		return new ChiTietBanHangDAO().getChiTietBanHangByMaHoaDon(this.getMaHoaDon());
	}
	public void setDsChiTiet(List<ChiTietBanHang> dsChiTiet) {
		this.dsChiTiet = dsChiTiet;
	}

	
	
	public HoaDonBanHang(int maHoaDon, Date ngayBan, List<ChiTietBanHang> dsChiTiet) {
		super(maHoaDon);
		this.ngayBan = ngayBan;
		this.dsChiTiet = dsChiTiet;
	}
	public HoaDonBanHang() {

	}
	public HoaDonBanHang(int maHoaDon, Date ngayBan) {
		super(maHoaDon);
		this.ngayBan = ngayBan;
	}
	
	public HoaDonBanHang(Date ngayBan) {
		this.ngayBan = ngayBan;
	}
	
	
}
