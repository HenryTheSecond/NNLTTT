package Model;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private String tenNV;
	private String SDT;
	private Date ngaySinh;
	private String gioiTinh;
	private int isAdmin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public User(int id, String username, String password, String tenNV, String sDT, Date ngaySinh, String gioiTinh,
			int isAdmin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.tenNV = tenNV;
		SDT = sDT;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.isAdmin = isAdmin;
	}
	public User() {

	}
	public User(String username, String password, String tenNV, String sDT, Date ngaySinh, String gioiTinh,
			int isAdmin) {
		this.username = username;
		this.password = password;
		this.tenNV = tenNV;
		SDT = sDT;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.isAdmin = isAdmin;
	}
	
	
}
