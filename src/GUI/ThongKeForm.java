package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.BangDiaDAO;
import DAO.ChiTietBanHangDAO;
import DAO.ChiTietThueDiaDAO;
import DAO.KhachHangDAO;
import Model.BangDia;
import Model.ChiTietBanHang;
import Model.ChiTietThueDia;
import Model.KhachHang;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongKeForm extends JFrame {

	private JPanel contentPane;
	private JLabel labelTongDoanhThu;
	private JLabel labelDoanhThuBanDia;
	private JLabel labelDoanhThuThueDia;
	private JTable tableThongKe;

	
	private JTextField txtSearch;
	private JTable tableKhachHang;
	private JTextField txtKhachHang;
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
		setBounds(100, 100, 1300, 592);
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
		
		JScrollPane scrollPaneThongKe = new JScrollPane();
		scrollPaneThongKe.setBounds(10, 255, 700, 230);
		contentPane.add(scrollPaneThongKe);
		
		tableThongKe = new JTable();
		tableThongKe.setAutoCreateRowSorter(true);
		scrollPaneThongKe.setViewportView(tableThongKe);
		InitTableThongKe();
		

 
		 txtSearch = new JTextField();
		 txtSearch.setBounds(399, 496, 185, 20);
		 contentPane.add(txtSearch);
		 txtSearch.setColumns(10);
		 
		 JButton btnSearch = new JButton("Search");
		 btnSearch.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		btnSearchClicked();
		 	}
		 });
		 btnSearch.setBounds(621, 496, 89, 23);
		 contentPane.add(btnSearch);
		 
		 JScrollPane scrollPaneKhachHang = new JScrollPane();
		 scrollPaneKhachHang.setBounds(771, 255, 503, 230);
		 contentPane.add(scrollPaneKhachHang);
		 
		 tableKhachHang = new JTable();
		 scrollPaneKhachHang.setViewportView(tableKhachHang);
		 InitTableKhachHang();
		 
		 JButton btnSearchKH = new JButton("Search");
		 btnSearchKH.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		btnSearchKHClicked();
		 	}
		 });
		 btnSearchKH.setBounds(1185, 495, 89, 23);
		 contentPane.add(btnSearchKH);
		 
		 txtKhachHang = new JTextField();
		 txtKhachHang.setBounds(1020, 496, 155, 20);
		 contentPane.add(txtKhachHang);
		 txtKhachHang.setColumns(10);
		
		loadDoanhThu();
	}
	
	public void InitTableThongKe() {
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã đĩa"); mod.addColumn("Tên đĩa"); mod.addColumn("Số lượng bán"); mod.addColumn("Doanh thu bán");
		mod.addColumn("Số lượng thuê"); mod.addColumn("Doanh thu thuê"); mod.addColumn("Số đĩa chưa trả");
		
		tableThongKe.setModel(mod);
		List<BangDia> list = new BangDiaDAO().getAll();
		fillTableThongKe(list);
	}
	
	public void fillTableThongKe(List<BangDia> list) {
		DefaultTableModel mod = (DefaultTableModel)tableThongKe.getModel();
		mod.setRowCount(0);
		for(BangDia dia:list) {
			Object item[] = {dia.getMaDia(), dia.getTenLoaiDia(), dia.getDoanhSoBan(), dia.getDoanhThuBan(), dia.getDoanhSoThue(), dia.getDoanhThuThue(), dia.getSoLuongDiaChuaTra()};
			mod.addRow(item);
		}
		int tongSoLuongBan=0, tongDoanhThuBan=0, tongSoLuongThue=0, tongDoanhThuThue=0, tongChuaTra=0;
		for(int i=0; i<mod.getRowCount(); i++) {
			tongSoLuongBan += Integer.parseInt( mod.getValueAt(i, 2).toString() );
			tongDoanhThuBan += Float.parseFloat( mod.getValueAt(i, 3).toString() );
			tongSoLuongThue += Integer.parseInt( mod.getValueAt(i, 4).toString() );
			tongDoanhThuThue += Float.parseFloat( mod.getValueAt(i, 5).toString() );
			tongChuaTra += Integer.parseInt( mod.getValueAt(i, 6).toString() );
		}
		Object item[] = {"", "TỔNG", tongSoLuongBan, tongDoanhThuBan, tongSoLuongThue, tongDoanhThuThue, tongChuaTra};
		mod.addRow(item);
	}
	
	public void InitTableKhachHang() {
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã KH"); mod.addColumn("Tên KH"); mod.addColumn("Địa chỉ"); mod.addColumn("SDT");
		mod.addColumn("Số lượng thuê"); mod.addColumn("Đĩa chưa trả"); mod.addColumn("Số tiền");
		
		tableKhachHang.setModel(mod);
		List<KhachHang> list = new KhachHangDAO().searchByName("");
		fillTableKhachHang(list);
	}
	
	public void fillTableKhachHang(List<KhachHang> list) {
		DefaultTableModel mod = (DefaultTableModel)tableKhachHang.getModel();
		mod.setRowCount(0);
		for(KhachHang kh:list) {
			List<Object> thongKe = kh.getThongKe();
			Object[] item= {kh.getMaKH(), kh.getTenKH(), kh.getDiaChi(), kh.getSoDT(), thongKe.get(0), thongKe.get(1), thongKe.get(2)};
			mod.addRow(item);
		}
	}
	
	public void btnSearchClicked() {
		String kw = txtSearch.getText();
		List<BangDia> list = new BangDiaDAO().searchByName(kw);
		fillTableThongKe(list);
	}
	
	public void btnSearchKHClicked() {
		String kw = txtKhachHang.getText();
		List<KhachHang> list = new KhachHangDAO().searchByName(kw);
		fillTableKhachHang(list);
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
