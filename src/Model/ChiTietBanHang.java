package Model;

public class ChiTietBanHang {
	private int id;
	private HoaDonBanHang hoaDon;
	private BangDia dia;
	private int soLuong;
	private float gia;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HoaDonBanHang getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDonBanHang hoaDon) {
		this.hoaDon = hoaDon;
	}
	public BangDia getDia() {
		return dia;
	}
	public void setDia(BangDia dia) {
		this.dia = dia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	
	public ChiTietBanHang(int id, HoaDonBanHang hoaDon, BangDia dia, int soLuong, float gia) {
		this.id = id;
		this.hoaDon = hoaDon;
		this.dia = dia;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	public ChiTietBanHang() {

	}
	
	public ChiTietBanHang(HoaDonBanHang hoaDon, BangDia dia, int soLuong, float gia) {
		this.hoaDon = hoaDon;
		this.dia = dia;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	
	
}
