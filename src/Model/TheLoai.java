package Model;

import java.util.ArrayList;
import java.util.List;

import DAO.BangDiaDAO;

public class TheLoai {
	private int maTL;
	private String tenTL;
	private List<BangDia> dsBangDia = new ArrayList<BangDia>();
	
	public TheLoai(int maTL, String tenTL, List<BangDia> dsBangDia) {
		this.maTL = maTL;
		this.tenTL = tenTL;
		this.dsBangDia = dsBangDia;
	}

	public TheLoai() {
		
	}

	public int getMaTL() {
		return maTL;
	}

	public void setMaTL(int maTL) {
		this.maTL = maTL;
	}

	public String getTenTL() {
		return tenTL;
	}

	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}

	public List<BangDia> getDsBangDia() {
		return new BangDiaDAO().getBangDiaTheoTheLoai(this.maTL);
	}

	public void setDsBangDia(List<BangDia> dsBangDia) {
		this.dsBangDia = dsBangDia;
	}

	public TheLoai(int maTL, String tenTL) {
		this.maTL = maTL;
		this.tenTL = tenTL;
	}

	public TheLoai(String tenTL) {
		this.tenTL = tenTL;
	}
	
	
	
}
