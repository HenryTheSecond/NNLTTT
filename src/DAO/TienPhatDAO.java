package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnect;

public class TienPhatDAO {
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public float get() {
		String sql = "select * from TienPhat";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getFloat(1);
			}
		}catch(Exception e) {
			
		}
		return 0;
	}
	
	public void update(float soTien) {
		String sql = "Update TienPhat set SoTien=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setFloat(1, soTien);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TienPhatDAO().update(2);
	}
}
