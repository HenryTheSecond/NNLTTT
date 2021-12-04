package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ChiTietBanHangDAO;
import DAO.ChiTietThueDiaDAO;
import Model.ChiTietBanHang;
import Model.ChiTietThueDia;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;

public class ThongKeForm extends JFrame {

	private JPanel contentPane;
	private JLabel labelTongDoanhThu;
	private JLabel labelDoanhThuBanDia;
	private JLabel labelDoanhThuThueDia;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeForm frame = new ThongKeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThongKeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatistic = new JLabel("THỐNG KÊ DOANH THU");
		lblStatistic.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblStatistic.setBounds(300, 10, 307, 48);
		contentPane.add(lblStatistic);
		
		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu : ");
		lblTngDoanhThu.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblTngDoanhThu.setBounds(44, 68, 222, 41);
		contentPane.add(lblTngDoanhThu);
		
		JLabel lblDoanhThuBn = new JLabel("Doanh thu bán đĩa : ");
		lblDoanhThuBn.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDoanhThuBn.setBounds(21, 112, 222, 41);
		contentPane.add(lblDoanhThuBn);
		
		JLabel lblDoanhThuThu = new JLabel("Doanh thu thuê đĩa : ");
		lblDoanhThuThu.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDoanhThuThu.setBounds(10, 156, 222, 41);
		contentPane.add(lblDoanhThuThu);
		
		JLabel lblBiuDoanh = new JLabel("BIỂU ĐỒ DOANH THU");
		lblBiuDoanh.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblBiuDoanh.setBounds(417, 517, 222, 41);
		contentPane.add(lblBiuDoanh);
		
		labelTongDoanhThu = new JLabel("Tổng doanh thu ");
		labelTongDoanhThu.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		labelTongDoanhThu.setBounds(253, 68, 222, 41);
		contentPane.add(labelTongDoanhThu);
		
		labelDoanhThuBanDia = new JLabel("Doanh thu bán đĩa");
		labelDoanhThuBanDia.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		labelDoanhThuBanDia.setBounds(253, 112, 222, 41);
		contentPane.add(labelDoanhThuBanDia);
		
		labelDoanhThuThueDia = new JLabel("Doanh thu thuê đĩa");
		labelDoanhThuThueDia.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		labelDoanhThuThueDia.setBounds(253, 156, 222, 41);
		contentPane.add(labelDoanhThuThueDia);
		
		loadDoanhThu();
	}
	
	public void loadDoanhThu() {
		float tongDoanhThu = 0, doanhThuThueDia = 0, doanhThuBanDia = 0;
		ChiTietBanHangDAO chiTietBanHangDAO = new ChiTietBanHangDAO();
		ChiTietThueDiaDAO chiTietThueDiaDAO = new ChiTietThueDiaDAO();
		for (ChiTietBanHang chiTietBanHang : chiTietBanHangDAO.getAllChiTietBanHang()) {
			doanhThuBanDia += (chiTietBanHang.getGia() * chiTietBanHang.getSoLuong());
		}
		for (ChiTietThueDia chiTietThueDia : chiTietThueDiaDAO.getAllChiTietThueDia()) {
			doanhThuThueDia += chiTietThueDia.getThanhToan();
		}
		tongDoanhThu = doanhThuBanDia + doanhThuThueDia;
		labelTongDoanhThu.setText(String.valueOf(tongDoanhThu));
		labelDoanhThuThueDia.setText(String.valueOf(doanhThuThueDia));
		labelDoanhThuBanDia.setText(String.valueOf(doanhThuBanDia));
		
		
	}
}
