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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		searchBangDia = new JButton("T??m ki???m ????a");
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
		
		JLabel lblNewLabel = new JLabel("M?? Kh??ch H??ng");
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
		mod.addColumn("????a ID");
		mod.addColumn("T??n ????a");
		mod.addColumn("S??? ng??y Thu??");
		mod.addColumn("Gi??");
		mod.addColumn("");
		tableChiTietThue.setModel(mod);
		scrollPaneChiTietThue.setViewportView(tableChiTietThue);
		
		btnThem = new JButton("Th??m");
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
		mod.addColumn("M?? Kh??ch H??ng");
		mod.addColumn("T??n Kh??ch H??ng");
		mod.addColumn("?????a ch???");
		mod.addColumn("S??? ??i???n tho???i");
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
		mod.addColumn("M?? ????a");
		mod.addColumn("T??n");
		mod.addColumn("S??? l?????ng thu??");
		mod.addColumn("??ang thu??");
		mod.addColumn("Gi?? thu??");
		mod.addColumn("T??n th??? lo???i");
		mod.addColumn("");
		
		for(BangDia bd: list) {
			Object[] item = {bd.getMaDia(), bd.getTenLoaiDia(), bd.getSoLuongThue(), bd.getDangThue(), bd.getGiaThue(), bd.getTheLoai().getTenTL(), "TH??M"};
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
				Object[] item = {tableBangDia.getValueAt(row, 0), tableBangDia.getValueAt(row, 1), 1, tableBangDia.getValueAt(row, 4), "X??A"};
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
		int kt = kiemTraDuLieu();
		if(kt == -1) {
			JOptionPane.showMessageDialog(new JFrame(), "D??? li???u kh??ng ph?? h???p");  
			return;
		}
		else if(kt==0) {
			JOptionPane.showMessageDialog(new JFrame(), "S??? l?????ng kh??ng ?????");  
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
		JOptionPane.showMessageDialog(contentPane, "Thu?? th??nh c??ng", "Thu?? ????a", 
                JOptionPane.INFORMATION_MESSAGE);
		DefaultTableModel mod = (DefaultTableModel)tableChiTietThue.getModel();
		mod.setRowCount(0);
		
	}
	
	public int kiemTraDuLieu() {
		try {
			Integer.parseInt(txtMaKH.getText());
		}catch(Exception e) {
			return -1;
		}
		for(int i=0; i<tableChiTietThue.getRowCount(); i++) {
			try {
				int maDia = Integer.parseInt(tableChiTietThue.getValueAt(i, 0).toString());
				Integer.parseInt(tableChiTietThue.getValueAt(i, 2).toString());
				Float.parseFloat(tableChiTietThue.getValueAt(i, 3).toString());
				BangDia dia = new BangDiaDAO().get(maDia);
				if( dia.getSoLuongThue() - dia.getDangThue() <= 0 )
					return 0;
			}catch(Exception e) {
				return -1;
			}
		}
		return 1;
		
	}
}
