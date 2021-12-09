package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.TheLoaiDAO;
import DAO.UserDAO;
import Model.TheLoai;
import Model.User;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class QuanLiNhanVienForm extends JFrame {

	private JPanel contentPane;
	private JTable table_NhanVien;
	private JTextField textFieldUsername;
	private JTextField textField_NV;
	private JTextField textField_sdt;
	private JTextField textField_ngaysinh;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiNhanVienForm frame = new QuanLiNhanVienForm();
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
	public QuanLiNhanVienForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 801, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 169, 759, 249);
		contentPane.add(scrollPane);
		
		table_NhanVien = new JTable();
		table_NhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClicked();
			}
		});
		InitTableTheLoai();
		scrollPane.setViewportView(table_NhanVien);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 13, 112, 35);
		contentPane.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setEditable(false);
		textFieldUsername.setBounds(116, 19, 152, 22);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblTnNhanVien = new JLabel("Tên nhân viên");
		lblTnNhanVien.setBounds(12, 61, 112, 35);
		contentPane.add(lblTnNhanVien);
		
		textField_NV = new JTextField();
		textField_NV.setColumns(10);
		textField_NV.setBounds(116, 67, 152, 22);
		contentPane.add(textField_NV);
		
		JLabel lblSdt = new JLabel("Số điện thoại");
		lblSdt.setBounds(12, 109, 112, 35);
		contentPane.add(lblSdt);
		
		JLabel lblNgaysinh = new JLabel("Ngày sinh");
		lblNgaysinh.setBounds(314, 13, 112, 35);
		contentPane.add(lblNgaysinh);
		
		JLabel lblGt = new JLabel("Giới tính");
		lblGt.setBounds(360, 61, 112, 35);
		contentPane.add(lblGt);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(116, 115, 152, 22);
		contentPane.add(textField_sdt);
		
		textField_ngaysinh = new JTextField();
		textField_ngaysinh.setColumns(10);
		textField_ngaysinh.setBounds(388, 19, 152, 22);
		contentPane.add(textField_ngaysinh);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateClicked();
				textFieldUsername.setText("");
				textField_NV.setText("");
				textField_sdt.setText("");
				textField_ngaysinh.setText("");
				rdbtnNam.setSelected(false);
				rdbtnNu.setSelected(false);
			}
		});
		btnUpdate.setBounds(669, 18, 102, 45);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteClicked();
			}
		});
		btnDelete.setBounds(669, 92, 102, 45);
		contentPane.add(btnDelete);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnNu.setSelected(false);
			}
		});
		rdbtnNam.setBounds(299, 114, 127, 25);
		contentPane.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nu");
		rdbtnNu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnNam.setSelected(false);
			}
		});
		rdbtnNu.setBounds(451, 114, 127, 25);
		contentPane.add(rdbtnNu);
	}
	
	
	
	
	public void InitTableTheLoai() {
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Id");
		mod.addColumn("Username");
		mod.addColumn("Password");
		mod.addColumn("Tên nhân viên"); 
		mod.addColumn("Số điện thoại");
		mod.addColumn("Ngày sinh");
		mod.addColumn("Giới tính");
		
		table_NhanVien.setModel(mod);
		
		List<User> list = new UserDAO().getUser();
		fillTable(list);
	}
	
	public void fillTable(List<User> list) {
		DefaultTableModel mod = (DefaultTableModel)table_NhanVien.getModel();
		mod.setRowCount(0);
		for(User user :list) {
			Object item[] = {user.getId(),user.getUsername(),user.getPassword(),user.getTenNV(),user.getSDT(),user.getNgaySinh(),user.getGioiTinh()};
			mod.addRow(item);
		}
	}
	
	public void tableClicked() {
		int row = table_NhanVien.getSelectedRow();
		textFieldUsername.setText(table_NhanVien.getValueAt(row, 1).toString());
		textField_NV.setText(table_NhanVien.getValueAt(row, 3).toString());
		textField_sdt.setText(table_NhanVien.getValueAt(row, 4).toString());
		textField_ngaysinh.setText(table_NhanVien.getValueAt(row, 5).toString());
		String gt = table_NhanVien.getValueAt(row, 6).toString();
		if(gt.equals("Nam")) {
			rdbtnNam.setSelected(true);
			rdbtnNu.setSelected(false);
		}else {
			rdbtnNu.setSelected(true);
			rdbtnNam.setSelected(false);
		}
	}
	
	public void btnUpdateClicked() {
		int row = table_NhanVien.getSelectedRow();
		User user = new User();
		try {
			user.setId(Integer.parseInt(table_NhanVien.getValueAt(row, 0).toString()));
			user.setTenNV(textField_NV.getText());
			user.setSDT(textField_sdt.getText());
			user.setNgaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(textField_ngaysinh.getText()));
			String gt="Nam";
			if(rdbtnNu.isSelected()==true) {
				gt="Nu";
			}
			user.setGioiTinh(gt);
			new UserDAO().update(user);
			JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			InitTableTheLoai();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
		}
	}
	
	public void btnDeleteClicked() {
		int row = table_NhanVien.getSelectedRow();
		try {
			int id = Integer.parseInt(table_NhanVien.getValueAt(row, 0).toString());
			if( JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa thể loại") == JOptionPane.YES_OPTION ) {
				new UserDAO().delete(id);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				InitTableTheLoai();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại");
		}
	}
}
