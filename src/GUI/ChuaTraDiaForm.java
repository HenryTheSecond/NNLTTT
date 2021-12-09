package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.BangDia;
import Model.ChiTietBanHang;
import Model.ChiTietThueDia;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ChuaTraDiaForm extends JFrame {

	private JPanel contentPane;
	private JTable tableChuaTra;
	public BangDia dia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuaTraDiaForm frame = new ChuaTraDiaForm();
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
	public ChuaTraDiaForm(BangDia dia) {
		
		this.dia = dia;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneChuaTra = new JScrollPane();
		scrollPaneChuaTra.setBounds(10, 158, 533, 189);
		contentPane.add(scrollPaneChuaTra);
		
		tableChuaTra = new JTable();
		scrollPaneChuaTra.setViewportView(tableChuaTra);
		
		InitTableChuaTraDia();
	}
	
	public void InitTableChuaTraDia() {
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã hóa đơn"); mod.addColumn("Ngày thuê"); mod.addColumn("Tên khách hàng");
		mod.addColumn("Số ngày thuê"); mod.addColumn("Giá thuê");
		for(ChiTietThueDia ct: dia.getDsChiTietThue()) {
			if(ct.getNgayTra() == null) {
				Object[] item = {ct.getHoaDon().getMaHoaDon(), ct.getHoaDon().getNgayThue(), ct.getHoaDon().getKhachHang().getTenKH(), ct.getSoNgayThue(), ct.getGia()};
				mod.addRow(item);
			}
		}
		tableChuaTra.setModel(mod);
	}
}
