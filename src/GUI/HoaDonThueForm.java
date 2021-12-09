package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.BangDia;
import Model.ChiTietThueDia;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class HoaDonThueForm extends JFrame {

	private JPanel contentPane;
	private JTable tableChiTiet;
	public BangDia dia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonThueForm frame = new HoaDonThueForm();
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
	public HoaDonThueForm(BangDia dia) {
		
		this.dia = dia;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneChiTiet = new JScrollPane();
		scrollPaneChiTiet.setBounds(10, 96, 475, 199);
		contentPane.add(scrollPaneChiTiet);
		
		tableChiTiet = new JTable();
		scrollPaneChiTiet.setViewportView(tableChiTiet);
		
		InitTableChiTiet();
	}
	
	public void InitTableChiTiet() {
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã hóa đơn"); mod.addColumn("Ngày thuê"); mod.addColumn("Khách hàng");
		mod.addColumn("Số ngày thuê"); mod.addColumn("Giá thuê"); mod.addColumn("Ngày trả"); mod.addColumn("Thanh toán");
		for(ChiTietThueDia ct: dia.getDsChiTietThue()) {
			Object[] item = {ct.getHoaDon().getMaHoaDon(), ct.getHoaDon().getNgayThue(), ct.getHoaDon().getKhachHang().getTenKH(),
							ct.getSoNgayThue(), ct.getGia(), ct.getNgayTra(), ct.getThanhToan()};
			mod.addRow(item);
		}
		tableChiTiet.setModel(mod);
	}

}
