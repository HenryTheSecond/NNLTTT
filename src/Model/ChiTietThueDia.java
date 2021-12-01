package Model;

import java.util.Date;

public class ChiTietThueDia {
	private int id;
	private HoaDonThue hoaDon;
	private BangDia dia;
	private int soNgayThue;
	private float gia;
	private Date ngayTra;
	private float thanhToan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HoaDonThue getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDonThue hoaDon) {
		this.hoaDon = hoaDon;
	}
	public BangDia getDia() {
		return dia;
	}
	public void setDia(BangDia dia) {
		this.dia = dia;
	}
	public int getSoNgayThue() {
		return soNgayThue;
	}
	public void setSoNgayThue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public float getThanhToan() {
		return thanhToan;
	}
	public void setThanhToan(float thanhToan) {
		this.thanhToan = thanhToan;
	}
	
	public ChiTietThueDia(int id, HoaDonThue hoaDon, BangDia dia, int soNgayThue, float gia, Date ngayTra,
			float thanhToan) {
		this.id = id;
		this.hoaDon = hoaDon;
		this.dia = dia;
		this.soNgayThue = soNgayThue;
		this.gia = gia;
		this.ngayTra = ngayTra;
		this.thanhToan = thanhToan;
	}
	public ChiTietThueDia() {

	}
	
	public ChiTietThueDia(HoaDonThue hoaDon, BangDia dia, int soNgayThue, float gia, Date ngayTra, float thanhToan) {
		super();
		this.hoaDon = hoaDon;
		this.dia = dia;
		this.soNgayThue = soNgayThue;
		this.gia = gia;
		this.ngayTra = ngayTra;
		this.thanhToan = thanhToan;
	}
	
	
}
