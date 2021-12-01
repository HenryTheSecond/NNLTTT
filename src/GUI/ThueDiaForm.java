package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import DAO.BangDiaDAO;
import DAO.ChiTietThueDiaDAO;
import DAO.HoaDonThueDAO;
import DAO.KhachHangDAO;
import Model.BangDia;
import Model.ChiTietThueDia;
import Model.HoaDonThue;
import Model.KhachHang;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ThueDiaForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTable tableKhachHang;
	private JScrollPane scrollPaneKhachHang;
	private JTextField txtBangDia;
	private JButton searchBangDia;
	private JTable tableBangDia;
	private JScrollPane scrollPaneBangDia;
	private JTextField txtMaKH;
	private JTable tableChiTietThue;
	private JScrollPane scrollPaneChiTietThue;
	private JButton btnThem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThueDiaForm frame = new ThueDiaForm();
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
	public ThueDiaForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(10, 11, 139, 20);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JButton searchKH = new JButton("T\u00ECm Kh\u00E1ch H\u00E0ng");
		searchKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				searchKHClicked();
			}
		});
		searchKH.setBounds(159, 10, 139, 23);
		contentPane.add(searchKH);
		
		scrollPaneKhachHang = new JScrollPane();
		scrollPaneKhachHang.setBounds(10, 56, 608, 164);
		contentPane.add(scrollPaneKhachHang);
		
		tableKhachHang = new JTable();
		scrollPaneKhachHang.setViewportView(tableKhachHang);
		
		txtBangDia = new JTextField();
		txtBangDia.setBounds(10, 252, 139, 20);
		contentPane.add(txtBangDia);
		txtBangDia.setColumns(10);
		
		searchBangDia = new JButton("Tìm kiếm đĩa");
		searchBangDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchBangDiaClicked();
			}
		});
		searchBangDia.setBounds(159, 251, 139, 23);
		contentPane.add(searchBangDia);
		
		scrollPaneBangDia = new JScrollPane();
		scrollPaneBangDia.setBounds(10, 307, 608, 185);
		contentPane.add(scrollPaneBangDia);
		
		tableBangDia = new JTable();
		scrollPaneBangDia.setViewportView(tableBangDia);
		
		JLabel lblNewLabel = new JLabel("Mã Khách Hàng");
		lblNewLabel.setBounds(682, 14, 106, 14);
		contentPane.add(lblNewLabel);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(820, 11, 80, 20);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		scrollPaneChiTietThue = new JScrollPane();
		scrollPaneChiTietThue.setBounds(665, 56, 509, 436);
		contentPane.add(scrollPaneChiTietThue);
		
		tableChiTietThue = new JTable();
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Đĩa ID");
		mod.addColumn("Tên Đĩa");
		mod.addColumn("Số ngày Thuê");
		mod.addColumn("Giá");
		mod.addColumn("");
		tableChiTietThue.setModel(mod);
		scrollPaneChiTietThue.setViewportView(tableChiTietThue);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnThemClicked();
			}
		});
		btnThem.setBounds(1051, 503, 123, 46);
		contentPane.add(btnThem);
		
		
		
		tableKhachHang.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {

			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {

			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tableKHClicked();
				
			}
		});
		
		tableBangDia.addMouseListener(new MouseListener() {
			
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
				tableBangDiaThemClicked();
			}
		});
		
		tableChiTietThue.addMouseListener(new MouseListener() {
			
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
				if(tableChiTietThue.getSelectedColumn() == 4)
					tableChiTietThueXoaClicked();
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
		for(KhachHang kh: list) {
			Object[] item = {kh.getMaKH(), kh.getTenKH(), kh.getDiaChi(), kh.getSoDT()};
			mod.addRow(item);
		}
		
		tableKhachHang.setModel(mod);
	}
	
	public void searchBangDiaClicked() {
		String kw = txtBangDia.getText();
		List<BangDia> list = new BangDiaDAO().searchByName(kw);
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã đĩa");
		mod.addColumn("Tên");
		mod.addColumn("Số lượng thuê");
		mod.addColumn("Đang thuê");
		mod.addColumn("Giá thuê");
		mod.addColumn("Tên thể loại");
		mod.addColumn("");
		
		for(BangDia bd: list) {
			Object[] item = {bd.getMaDia(), bd.getTenLoaiDia(), bd.getSoLuongThue(), bd.getDangThue(), bd.getGiaThue(), bd.getTheLoai().getTenTL(), "THÊM"};
			mod.addRow(item);
		}
		tableBangDia.setModel(mod);
	}
	
	public void tableKHClicked() {
		int row = tableKhachHang.getSelectedRow();
		txtMaKH.setText(tableKhachHang.getValueAt(row, 0).toString());
	}
	
	public void tableBangDiaThemClicked() {
		int column = tableBangDia.getSelectedColumn();
		if(column==6) {
			int row = tableBangDia.getSelectedRow();
			if(kiemTraTrungChiTiet(tableBangDia.getValueAt(row, 0).toString())) {
				Object[] item = {tableBangDia.getValueAt(row, 0), tableBangDia.getValueAt(row, 1), 1, tableBangDia.getValueAt(row, 4), "XÓA"};
				DefaultTableModel mod = (DefaultTableModel)tableChiTietThue.getModel();
				mod.addRow(item);
			}
		}
	}
	
	public boolean kiemTraTrungChiTiet(String maDia) {
		for(int i=0; i<tableChiTietThue.getRowCount();i++) {
			if(maDia.equals(tableChiTietThue.getValueAt(i, 0).toString()))
				return false;
		}
		return true;
	}
	
	public void tableChiTietThueXoaClicked() {
		DefaultTableModel mod = (DefaultTableModel)tableChiTietThue.getModel();
		mod.removeRow(tableChiTietThue.getSelectedRow());
	}
	
	public void btnThemClicked() {
		if(kiemTraDuLieu() == false) {
			JOptionPane.showMessageDialog(new JFrame(), "Hello, Welcome to Javatpoint.");  
			return;
		}
		HoaDonThueDAO hoaDonThueDAO = new HoaDonThueDAO();
		ChiTietThueDiaDAO chiTietThueDiaDAO = new ChiTietThueDiaDAO();
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		BangDiaDAO bangDiaDAO = new BangDiaDAO();
		
		KhachHang kh = khachHangDAO.get(Integer.parseInt(txtMaKH.getText()));
		HoaDonThue hdThue = new HoaDonThue(new Date(), kh);
		int maHoaDon = hoaDonThueDAO.insert(hdThue);
		hdThue.setMaHoaDon(maHoaDon);
		for(int i=0; i<tableChiTietThue.getRowCount(); i++) {
			BangDia dia = bangDiaDAO.get(Integer.parseInt(tableChiTietThue.getValueAt(i, 0).toString()));
			ChiTietThueDia ct = new ChiTietThueDia(hdThue, dia, 
										Integer.parseInt(tableChiTietThue.getValueAt(i, 2).toString()), Float.parseFloat(tableChiTietThue.getValueAt(i, 3).toString()), 
										null, 0);
			chiTietThueDiaDAO.insert(ct);
			dia.setDangThue( dia.getDangThue()+1 );
			bangDiaDAO.update(dia);
		}
		
	}
	
	public boolean kiemTraDuLieu() {
		try {
			Integer.parseInt(txtMaKH.getText());
		}catch(Exception e) {
			return false;
		}
		for(int i=0; i<tableChiTietThue.getRowCount(); i++) {
			try {
				int maDia = Integer.parseInt(tableChiTietThue.getValueAt(i, 0).toString());
				Integer.parseInt(tableChiTietThue.getValueAt(i, 2).toString());
				Float.parseFloat(tableChiTietThue.getValueAt(i, 3).toString());
				BangDia dia = new BangDiaDAO().get(maDia);
				if( dia.getSoLuongThue() - dia.getDangThue() == 0 )
					return false;
			}catch(Exception e) {
				return false;
			}
		}
		return true;
		
	}
}
