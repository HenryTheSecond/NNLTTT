package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.BangDia;
import Model.ChiTietBanHang;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class HoaDonBanForm extends JFrame {

	private JPanel contentPane;
	private JTable tableHoaDon;
	public BangDia dia;
	JLabel labelTenDia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonBanForm frame = new HoaDonBanForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public HoaDonBanForm(BangDia dia) {
		
		this.dia = dia;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneHoaDon = new JScrollPane();
		scrollPaneHoaDon.setBounds(25, 109, 497, 287);
		contentPane.add(scrollPaneHoaDon);
		
		tableHoaDon = new JTable();
		scrollPaneHoaDon.setViewportView(tableHoaDon);
		
		JLabel labelTenDia = new JLabel("New label");
		labelTenDia.setBounds(25, 11, 247, 37);
		labelTenDia.setText(dia.getTenLoaiDia());
		contentPane.add(labelTenDia);
		
		InitTableHoaDon();
	}
	
	public void InitTableHoaDon() {
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã hóa đơn"); mod.addColumn("Ngày bán"); mod.addColumn("Số lượng"); mod.addColumn("Giá"); mod.addColumn("Tổng");
		for(ChiTietBanHang ct: dia.getDsChiTietBanHang()) {
			Object[] item = {ct.getHoaDon().getMaHoaDon(), ct.getHoaDon().getNgayBan(), ct.getSoLuong(), ct.getGia(), ct.getSoLuong()*ct.getGia()};
			mod.addRow(item);
		}
		tableHoaDon.setModel(mod);
	}
}
