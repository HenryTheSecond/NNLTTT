package Model;

import java.util.ArrayList;
import java.util.List;

import DAO.ChiTietBanHangDAO;
import DAO.ChiTietThueDiaDAO;

public class BangDia {
	private int maDia;
	private String tenLoaiDia;
	private int soLuong;
	private int soLuongThue;
	private int dangThue;
	private float giaBan;
	private float giaThue;
	private TheLoai theLoai;
	private List<ChiTietBanHang> dsChiTietBanHang = new ArrayList<ChiTietBanHang>();
	private List<ChiTietThueDia> dsChiTietThue = new ArrayList<ChiTietThueDia>();
	
	public int getMaDia() {
		return maDia;
	}
	public void setMaDia(int maDia) {
		this.maDia = maDia;
	}
	public String getTenLoaiDia() {
		return tenLoaiDia;
	}
	public void setTenLoaiDia(String tenLoaiDia) {
		this.tenLoaiDia = tenLoaiDia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getSoLuongThue() {
		return soLuongThue;
	}
	public void setSoLuongThue(int soLuongThue) {
		this.soLuongThue = soLuongThue;
	}
	public int getDangThue() {
		return dangThue;
	}
	public void setDangThue(int dangThue) {
		this.dangThue = dangThue;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public float getGiaThue() {
		return giaThue;
	}
	public void setGiaThue(float giaThue) {
		this.giaThue = giaThue;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	public List<ChiTietBanHang> getDsChiTietBanHang() {
		return new ChiTietBanHangDAO().getChiTietBanHangByMaDia(maDia);
	}
	public void setDsChiTietBanHang(List<ChiTietBanHang> dsChiTietBanHang) {
		this.dsChiTietBanHang = dsChiTietBanHang;
	}
	public List<ChiTietThueDia> getDsChiTietThue() {
		return new ChiTietThueDiaDAO().getChiTietThueDiaByMaDia(maDia);
	}
	public void setDsChiTietThue(List<ChiTietThueDia> dsChiTietThue) {
		this.dsChiTietThue = dsChiTietThue;
	}
	public BangDia(int maDia, String tenLoaiDia, int soLuong, int soLuongThue, int dangThue, float giaBan,
			float giaThue, TheLoai theLoai, List<ChiTietBanHang> dsChiTietBanHang, List<ChiTietThueDia> dsChiTietThue) {
		this.maDia = maDia;
		this.tenLoaiDia = tenLoaiDia;
		this.soLuong = soLuong;
		this.soLuongThue = soLuongThue;
		this.dangThue = dangThue;
		this.giaBan = giaBan;
		this.giaThue = giaThue;
		this.theLoai = theLoai;
		this.dsChiTietBanHang = dsChiTietBanHang;
		this.dsChiTietThue = dsChiTietThue;
	}
	public BangDia() {

	}
	public BangDia(String tenLoaiDia, int soLuong, int soLuongThue, int dangThue, float giaBan, float giaThue,
			TheLoai theLoai, List<ChiTietBanHang> dsChiTietBanHang, List<ChiTietThueDia> dsChiTietThue) {
		super();
		this.tenLoaiDia = tenLoaiDia;
		this.soLuong = soLuong;
		this.soLuongThue = soLuongThue;
		this.dangThue = dangThue;
		this.giaBan = giaBan;
		this.giaThue = giaThue;
		this.theLoai = theLoai;
		this.dsChiTietBanHang = dsChiTietBanHang;
		this.dsChiTietThue = dsChiTietThue;
	}
	public BangDia(int maDia, String tenLoaiDia, int soLuong, int soLuongThue, int dangThue, float giaBan,
			float giaThue, TheLoai theLoai) {
		super();
		this.maDia = maDia;
		this.tenLoaiDia = tenLoaiDia;
		this.soLuong = soLuong;
		this.soLuongThue = soLuongThue;
		this.dangThue = dangThue;
		this.giaBan = giaBan;
		this.giaThue = giaThue;
		this.theLoai = theLoai;
	}
	public BangDia(String tenLoaiDia, int soLuong, int soLuongThue, int dangThue, float giaBan, float giaThue,
			TheLoai theLoai) {
		super();
		this.tenLoaiDia = tenLoaiDia;
		this.soLuong = soLuong;
		this.soLuongThue = soLuongThue;
		this.dangThue = dangThue;
		this.giaBan = giaBan;
		this.giaThue = giaThue;
		this.theLoai = theLoai;
	}
	
	
	//THỐNG KẾ
	public int getDoanhSoBan() {
		int soLuong=0;
		for(ChiTietBanHang ct: this.getDsChiTietBanHang()) {
			soLuong += ct.getSoLuong();
		}
		return soLuong;
	}
	
	public int getDoanhSoThue() {
		return this.getDsChiTietThue().size();
	}
	
	public float getDoanhThuBan() {
		float doanhThu=0;
		for(ChiTietBanHang ct: this.getDsChiTietBanHang()) {
			doanhThu += ct.getSoLuong() * ct.getGia();
		}
		return doanhThu;
	}
	
	public float getDoanhThuThue() {
		float doanhThu=0;
		for(ChiTietThueDia ct: this.getDsChiTietThue()) {
			doanhThu += ct.getThanhToan();
		}
		return doanhThu;
	}
	
	public int getSoLuongDiaChuaTra() {
		int soLuong = 0 ;
		for(ChiTietThueDia ct: this.getDsChiTietThue()) {
			if(ct.getNgayTra() == null)
				soLuong++;
		}
		return soLuong;
	}
	
}
