package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.BangDiaDAO;
import DAO.TheLoaiDAO;
import Model.BangDia;
import Model.TheLoai;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLyBangDiaForm extends JFrame {

	private JPanel contentPane;
	private JTable tableBangDia;
	private JTextField txtMaDia;
	private JTextField txtTenDia;
	private JTextField txtSoLuong;
	private JTextField txtSoLuongThue;
	private JTextField txtDangThue;
	private JTextField txtGiaBan;
	private JTextField txtGiaThue;
	private JComboBox comboBoxTheLoai;
	private JTextField txtSearch;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyBangDiaForm frame = new QuanLyBangDiaForm();
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
	public QuanLyBangDiaForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneBangDia = new JScrollPane();
		scrollPaneBangDia.setBounds(290, 11, 795, 261);
		contentPane.add(scrollPaneBangDia);
		
		tableBangDia = new JTable();
		InitTableBangDia();
		scrollPaneBangDia.setViewportView(tableBangDia);
		
		JLabel lblMa = new JLabel("M\u00E3 \u0111\u0129a");
		lblMa.setBounds(20, 28, 46, 14);
		contentPane.add(lblMa);
		
		JLabel lblTna = new JLabel("T\u00EAn \u0111\u0129a");
		lblTna.setBounds(20, 51, 46, 14);
		contentPane.add(lblTna);
		
		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSLng.setBounds(20, 76, 69, 14);
		contentPane.add(lblSLng);
		
		JLabel lblSLngThu = new JLabel("S\u1ED1 l\u01B0\u1EE3ng thu\u00EA");
		lblSLngThu.setBounds(20, 101, 85, 14);
		contentPane.add(lblSLngThu);
		
		JLabel lblNewLabel = new JLabel("\u0110ang thu\u00EA");
		lblNewLabel.setBounds(20, 126, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGiBn = new JLabel("Gi\u00E1 b\u00E1n");
		lblGiBn.setBounds(20, 151, 46, 14);
		contentPane.add(lblGiBn);
		
		JLabel lblGiThu = new JLabel("Gi\u00E1 thu\u00EA");
		lblGiThu.setBounds(20, 176, 46, 14);
		contentPane.add(lblGiThu);
		
		comboBoxTheLoai = new JComboBox();
		comboBoxTheLoai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxTheLoaiSelectChanged();
			}
		});
		comboBoxTheLoai.setBounds(123, 198, 142, 20);
		InitComboBoxTheLoai();
		contentPane.add(comboBoxTheLoai);
		
		JLabel lblThLoi = new JLabel("Th\u1EC3 lo\u1EA1i");
		lblThLoi.setBounds(20, 201, 46, 14);
		contentPane.add(lblThLoi);
		
		txtMaDia = new JTextField();
		txtMaDia.setBounds(123, 25, 53, 20);
		contentPane.add(txtMaDia);
		txtMaDia.setColumns(10);
		
		txtTenDia = new JTextField();
		txtTenDia.setColumns(10);
		txtTenDia.setBounds(123, 48, 136, 20);
		contentPane.add(txtTenDia);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(123, 73, 53, 20);
		contentPane.add(txtSoLuong);
		
		txtSoLuongThue = new JTextField();
		txtSoLuongThue.setColumns(10);
		txtSoLuongThue.setBounds(123, 98, 53, 20);
		contentPane.add(txtSoLuongThue);
		
		txtDangThue = new JTextField();
		txtDangThue.setColumns(10);
		txtDangThue.setBounds(123, 123, 53, 20);
		contentPane.add(txtDangThue);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(123, 148, 53, 20);
		contentPane.add(txtGiaBan);
		
		txtGiaThue = new JTextField();
		txtGiaThue.setColumns(10);
		txtGiaThue.setBounds(123, 173, 53, 20);
		contentPane.add(txtGiaThue);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddClicked();
			}
		});
		btnAdd.setBounds(20, 249, 69, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateClicked();
			}
		});
		btnUpdate.setBounds(99, 249, 84, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteClicked();
			}
		});
		btnDelete.setBounds(193, 249, 87, 23);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSearchClicked();
			}
		});
		btnSearch.setBounds(996, 282, 89, 23);
		contentPane.add(btnSearch);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(644, 283, 342, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		
		//Add Listener
		tableBangDia.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tableBangDiaClicked();
			}
		});
	}
	
	
	public void InitTableBangDia() {
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã đĩa"); mod.addColumn("Tên đĩa"); mod.addColumn("Số lượng"); mod.addColumn("Số lượng thuê"); mod.addColumn("Đang Thuê"); mod.addColumn("Giá bán");
		mod.addColumn("Giá thuê"); mod.addColumn("Mã thể loại"); mod.addColumn("Thể loại");
		
		tableBangDia.setModel(mod);
		tableBangDia.removeColumn( tableBangDia.getColumnModel().getColumn(7) );
		
		List<BangDia> list = new BangDiaDAO().getAll();
		fillTableBangDia(list);
	}
	
	public void fillTableBangDia(List<BangDia> list) {
		DefaultTableModel mod = (DefaultTableModel)tableBangDia.getModel();
		mod.setRowCount(0);
		for(BangDia dia:list) {
			Object item[] = {dia.getMaDia(), dia.getTenLoaiDia(), dia.getSoLuong(), dia.getSoLuongThue(), dia.getDangThue(), dia.getGiaBan(), dia.getGiaThue(),
								dia.getTheLoai().getMaTL(), dia.getTheLoai()!=null? dia.getTheLoai().getTenTL():""};
			mod.addRow(item);
		}
	}
	
	
	public void tableBangDiaClicked() {
		int row = tableBangDia.getSelectedRow();
		TheLoai tl;
		
		txtMaDia.setText( tableBangDia.getValueAt(row, 0).toString() );
		txtTenDia.setText( tableBangDia.getValueAt(row, 1).toString() );
		txtSoLuong.setText( tableBangDia.getValueAt(row, 2).toString() );
		txtSoLuongThue.setText( tableBangDia.getValueAt(row, 3).toString() );
		txtDangThue.setText( tableBangDia.getValueAt(row, 4).toString() );
		txtGiaBan.setText( tableBangDia.getValueAt(row, 5).toString() );
		txtGiaThue.setText( tableBangDia.getValueAt(row, 6).toString() );
		
		int maTL = Integer.parseInt( tableBangDia.getModel().getValueAt(row, 7).toString() );
		
		for(int i=0; i<comboBoxTheLoai.getItemCount(); i++) {
			tl = (TheLoai)comboBoxTheLoai.getItemAt(i);
			if(tl.getMaTL() == maTL) {
				comboBoxTheLoai.setSelectedIndex(i);
				break;
			}
		}
	}
	
	public void InitComboBoxTheLoai() {
		List<TheLoai> list = new TheLoaiDAO().getAll();
		for(TheLoai tl:list) {
			comboBoxTheLoai.addItem(tl);
		}
	}
	
	
	public void btnAddClicked() {
		if(kiemTraInput()) {
			BangDia dia = new BangDia();
			dia.setTenLoaiDia( txtTenDia.getText() );
			dia.setSoLuong( Integer.parseInt(txtSoLuong.getText()) );
			dia.setSoLuongThue( Integer.parseInt(txtSoLuongThue.getText()) );
			dia.setDangThue( Integer.parseInt( txtDangThue.getText() ) );
			dia.setGiaBan( Float.parseFloat(txtGiaBan.getText()) );
			dia.setGiaThue( Float.parseFloat(txtGiaThue.getText()) );
			dia.setTheLoai( (TheLoai)comboBoxTheLoai.getSelectedItem() );
			
			new BangDiaDAO().insert(dia);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			InitTableBangDia();
		}
		else
			JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại dữ liệu nhập");
	}
	
	public boolean kiemTraInput() {
		try {
			Integer.parseInt(txtSoLuong.getText());
			Integer.parseInt(txtSoLuongThue.getText());
			Integer.parseInt( txtDangThue.getText() );
			Float.parseFloat(txtGiaBan.getText());
			Float.parseFloat(txtGiaThue.getText());
		}catch(Exception e) {
			return false;
		}
		if(txtTenDia.getText().equals(""))
			return false;
		return true;
	}
	
	public void btnUpdateClicked() {
		if(kiemTraInput()) {
			BangDia dia = new BangDia();
			try {
				dia.setMaDia( Integer.parseInt( txtMaDia.getText() ) );
				dia.setTenLoaiDia( txtTenDia.getText() );
				dia.setSoLuong( Integer.parseInt(txtSoLuong.getText()) );
				dia.setSoLuongThue( Integer.parseInt(txtSoLuongThue.getText()) );
				dia.setDangThue( Integer.parseInt( txtDangThue.getText() ) );
				dia.setGiaBan( Float.parseFloat(txtGiaBan.getText()) );
				dia.setGiaThue( Float.parseFloat(txtGiaThue.getText()) );
				dia.setTheLoai( (TheLoai)comboBoxTheLoai.getSelectedItem() );
				new BangDiaDAO().update(dia);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				InitTableBangDia();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại dữ liệu nhập");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại dữ liệu nhập");
		}
	}
	
	public void btnDeleteClicked() {
		try {
			int maDia = Integer.parseInt( txtMaDia.getText() );
			if( JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa đĩa") == JOptionPane.YES_OPTION ) {
				new BangDiaDAO().delete(maDia);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				InitTableBangDia();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại Mã Đĩa");
		}
	}
	
	public void btnSearchClicked() {
		List<BangDia> list = new BangDiaDAO().searchByName( txtSearch.getText().trim() );
		fillTableBangDia(list);
	}
	
	public void comboBoxTheLoaiSelectChanged() {

	}
}











