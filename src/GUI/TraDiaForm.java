package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.BangDiaDAO;
import DAO.ChiTietThueDiaDAO;
import DAO.HoaDonThueDAO;
import DAO.KhachHangDAO;
import DAO.TienPhatDAO;
import Model.BangDia;
import Model.ChiTietThueDia;
import Model.HoaDonThue;
import Model.KhachHang;

import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class TraDiaForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTable tableKhachHang;
	private JTable tableDsDia;
	private JScrollPane scrollPaneDsDia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraDiaForm frame = new TraDiaForm();
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
	public TraDiaForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(10, 11, 136, 20);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JButton btnSearchKH = new JButton("T\u00ECm kh\u00E1ch h\u00E0ng");
		btnSearchKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchKHClicked();
			}
		});
		btnSearchKH.setBounds(156, 10, 120, 23);
		contentPane.add(btnSearchKH);
		
		JScrollPane scrollPaneKhachHang = new JScrollPane();
		scrollPaneKhachHang.setBounds(10, 55, 539, 240);
		contentPane.add(scrollPaneKhachHang);
		
		tableKhachHang = new JTable();
		scrollPaneKhachHang.setViewportView(tableKhachHang);
		
		scrollPaneDsDia = new JScrollPane();
		scrollPaneDsDia.setBounds(10, 332, 715, 209);
		contentPane.add(scrollPaneDsDia);
		
		//Khởi tạo table Danh sách Thuê Đĩa
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("ID"); mod.addColumn("Mã hóa đơn"); mod.addColumn("Đĩa ID"); mod.addColumn("Tên Đĩa"); mod.addColumn("Ngày thuê"); mod.addColumn("Số ngày"); 
		mod.addColumn("Giá"); mod.addColumn("Ngày Trả"); mod.addColumn("Thanh Toán"); mod.addColumn("");
		tableDsDia = new JTable();
		tableDsDia.setModel(mod);
		tableDsDia.removeColumn(tableDsDia.getColumnModel().getColumn(0)); tableDsDia.removeColumn(tableDsDia.getColumnModel().getColumn(1));
		//tableDsDia.removeColumn(tableDsDia.getColumnModel().getColumn(0));
		scrollPaneDsDia.setViewportView(tableDsDia);
		
		tableKhachHang.addMouseListener(new  MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			@Override
			public void mouseExited(MouseEvent e) {

			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableKhachHang.getSelectedColumn() == 4)
					lichSuThueDia();
				else if(tableKhachHang.getSelectedColumn() == 5)
					diaChuTra();
			}
		});
		
		tableDsDia.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
			@Override
			public void mousePressed(MouseEvent e) {
	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			// Xử lý thanh toán trả đĩa
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tableDsDia.getSelectedColumn()==7 && tableDsDia.getValueAt(tableDsDia.getSelectedRow(), 7)!="") {
					if( JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán") == JOptionPane.YES_OPTION ) {
						DefaultTableModel mod = (DefaultTableModel)tableDsDia.getModel();
						int row = tableDsDia.getSelectedRow();
						int id =  (int)mod.getValueAt(row, 0);
						ChiTietThueDiaDAO chiTietDAO = new ChiTietThueDiaDAO();
						ChiTietThueDia ct = chiTietDAO.get(id);
						ct.setNgayTra(new Date());
						ct.setThanhToan(  Float.parseFloat(mod.getValueAt(row, 8).toString() )  );
						BangDia dia = ct.getDia();
						dia.setDangThue( dia.getDangThue()-1 );
						chiTietDAO.update(ct);
						new BangDiaDAO().update(dia);
						JOptionPane.showMessageDialog(null, "Thanh toán thành công");
					}					
				}
			}
		});
	}
	
	
	public void searchKHClicked() {
		String kw = txtTenKH.getText();
		List<KhachHang> list = new KhachHangDAO().searchByName(kw);
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã Khách Hàng");
		mod.addColumn("Tên Khách Hàng");
		mod.addColumn("Địa chỉ");
		mod.addColumn("Số điện thoại");
		mod.addColumn("aa");
		mod.addColumn("");
		for(KhachHang kh: list) {
			Object[] item = {kh.getMaKH(), kh.getTenKH(), kh.getDiaChi(), kh.getSoDT(), "Đĩa đã thuê", "Đĩa chưa trả"};
			mod.addRow(item);
		}
		
		tableKhachHang.setModel(mod);
	}
	
	public void lichSuThueDia() {
		HoaDonThueDAO hoaDonThueDAO = new HoaDonThueDAO();
		int maKH = Integer.parseInt(tableKhachHang.getValueAt(tableKhachHang.getSelectedRow(), 0).toString());
		List<HoaDonThue> list = hoaDonThueDAO.getHoaDonThueTheoKhachHang(maKH);
		DefaultTableModel mod = (DefaultTableModel)tableDsDia.getModel();
		mod.setRowCount(0);
		for(HoaDonThue hd:list) {
			for(ChiTietThueDia ct: hd.getDsChiTietThue()) {
				Object[] item = {ct.getId(), ct.getHoaDon().getMaHoaDon(), ct.getDia().getMaDia(), ct.getDia().getTenLoaiDia(), ct.getHoaDon().getNgayThue(),
								ct.getSoNgayThue(), ct.getGia(), ct.getNgayTra()==null? "Chưa trả":ct.getNgayTra(), ct.getNgayTra()==null? tinhTienThanhToan(ct):ct.getThanhToan(), ct.getNgayTra()==null? "Thanh Toán":""};
				mod.addRow(item);
			}
		}
	}
	
	public void diaChuTra() {
		DefaultTableModel mod = (DefaultTableModel)tableDsDia.getModel();
		mod.setRowCount(0);
		ChiTietThueDiaDAO chiTietDAO = new ChiTietThueDiaDAO();
		int maKH = Integer.parseInt(tableKhachHang.getValueAt(tableKhachHang.getSelectedRow(), 0).toString());
		List<ChiTietThueDia> list = chiTietDAO.getDiaChuTraByMaKH(maKH);
		
		for(ChiTietThueDia ct: list) {
			Object[] item = {ct.getId(), ct.getHoaDon().getMaHoaDon(), ct.getDia().getMaDia(), ct.getDia().getTenLoaiDia(), ct.getHoaDon().getNgayThue(),
					ct.getSoNgayThue(), ct.getGia(), ct.getNgayTra()==null? "Chưa trả":ct.getNgayTra(), tinhTienThanhToan(ct), "Thanh Toán"};
			mod.addRow(item);
		}
	}
	
	public float tinhTienThanhToan(ChiTietThueDia ct) {
		float tong= ct.getGia() * ct.getSoNgayThue();
		SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd"); 
		long diff = new Date().getTime() - ct.getHoaDon().getNgayThue().getTime();
		long soNgayTre = TimeUnit.MILLISECONDS.toDays(diff) - ct.getSoNgayThue();
		TienPhatDAO tienPhat = new TienPhatDAO();
		tong += tienPhat.get()*soNgayTre;
		return tong;
	}
}
