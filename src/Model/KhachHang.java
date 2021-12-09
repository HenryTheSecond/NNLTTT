package Model;

import java.util.ArrayList;
import java.util.List;

import DAO.HoaDonThueDAO;
import DAO.KhachHangDAO;

public class KhachHang {
	private int maKH;
	private String tenKH;
	private String diaChi;
	private String soDT;
	private List<HoaDonThue> dsThue = new ArrayList<HoaDonThue>();
	
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public List<HoaDonThue> getDsThue() {
		return new HoaDonThueDAO().getHoaDonThueTheoKhachHang(maKH);
	}
	public void setDsThue(List<HoaDonThue> dsThue) {
		this.dsThue = dsThue;
	}
	
	public KhachHang(int maKH, String tenKH, String diaChi, String soDT, List<HoaDonThue> dsThue) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.dsThue = dsThue;
	}
	
	public KhachHang() {

	}
	
	public KhachHang(int maKH, String tenKH, String diaChi, String soDT) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDT = soDT;
	}
	public KhachHang(String tenKH, String diaChi, String soDT) {
		super();
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDT = soDT;
	}
	
	public List<Object> getThongKe() {
		List<Object> item = new ArrayList<Object>();
		int soLuongThue=0;
		int soLuongChuaTra=0;
		float soLuongTien = 0;
		for(HoaDonThue hd: this.getDsThue()) {
			for(ChiTietThueDia ct: hd.getDsChiTietThue()) {
				if(ct.getNgayTra() == null) {
					soLuongChuaTra++;
				}
				soLuongThue++;
				soLuongTien += ct.getThanhToan();
			}
		}
		item.add(soLuongThue); 
		item.add(soLuongChuaTra); 
		item.add(soLuongTien);
		return item;
	}
	
	public static void main(String[] args) {
		KhachHang kh = new KhachHangDAO().get(3);
		for(HoaDonThue hd: kh.getDsThue()) {
			for(ChiTietThueDia ct: hd.getDsChiTietThue())
				System.out.println(ct.getNgayTra()==null);
		}
	}
	
}
