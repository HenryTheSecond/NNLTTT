package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserDAO;
import Model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class DangKiForm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldTenNV;
	private JTextField textFieldSDT;
	private JTextField textFieldNgaySinh;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnNhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKiForm frame = new DangKiForm();
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
	public DangKiForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngKTi = new JLabel("ĐĂNG KÍ TÀI KHOẢN");
		lblngKTi.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblngKTi.setBounds(132, 32, 288, 38);
		contentPane.add(lblngKTi);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblUsername.setBounds(47, 93, 128, 25);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(47, 142, 128, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Nhân Viên :");
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 184, 167, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số Điện Thoại :");
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(20, 226, 167, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày sinh :");
		lblNewLabel_1_4.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(51, 268, 147, 25);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Giới tính :");
		lblNewLabel_1_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_4_1.setBounds(60, 314, 167, 25);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Quyền :");
		lblNewLabel_1_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_4_2.setBounds(73, 349, 167, 25);
		contentPane.add(lblNewLabel_1_4_2);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(202, 90, 255, 32);
		contentPane.add(textFieldUsername);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(202, 135, 255, 32);
		contentPane.add(textFieldPassword);
		
		textFieldTenNV = new JTextField();
		textFieldTenNV.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		textFieldTenNV.setColumns(10);
		textFieldTenNV.setBounds(202, 181, 255, 32);
		contentPane.add(textFieldTenNV);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(202, 223, 255, 32);
		contentPane.add(textFieldSDT);
		
		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(202, 265, 255, 32);
		contentPane.add(textFieldNgaySinh);
		textFieldNgaySinh.setText("YYYY-MM-DD");
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setSelected(true);
		rdbtnNam.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		rdbtnNam.setBounds(202, 312, 112, 25);
		contentPane.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		rdbtnNu.setBounds(330, 314, 112, 25);
		contentPane.add(rdbtnNu);
		
		ButtonGroup btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setSelected(true);
		rdbtnAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		rdbtnAdmin.setBounds(202, 349, 112, 25);
		contentPane.add(rdbtnAdmin);
		
		rdbtnNhanVien = new JRadioButton("Nhân Viên");
		rdbtnNhanVien.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		rdbtnNhanVien.setBounds(330, 351, 112, 25);
		contentPane.add(rdbtnNhanVien);
		
		ButtonGroup btnGroupQuyen = new ButtonGroup();
		btnGroupQuyen.add(rdbtnAdmin);
		btnGroupQuyen.add(rdbtnNhanVien);
		
		JButton btnHuy = new JButton("HỦY");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnHuy.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnHuy.setBounds(133, 405, 107, 39);
		contentPane.add(btnHuy);
		
		JButton btnDangKi = new JButton("ĐĂNG KÍ");
		btnDangKi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDangKiClicked();
			}
		});
		btnDangKi.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnDangKi.setBounds(273, 405, 147, 39);
		contentPane.add(btnDangKi);
	}
	public void btnDangKiClicked() {
		UserDAO userDAO = new UserDAO();
		int id = 10; // gán giá trị ngẫu nhiên để khởi tạo user, vì id trong csdl tự tăng
		String username = textFieldUsername.getText() ;
		String password = textFieldPassword.getText();
		String tenNV = textFieldTenNV.getText();
		String sdt = textFieldSDT.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd"); 
		Date ngaySinh = new Date();
		int flag = 0;
		try {
			ngaySinh = format.parse(textFieldNgaySinh.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đúng trường ngày sinh theo mẫu 'yyyy-mm-dd' !!!" , "Error", 
                    JOptionPane.ERROR_MESSAGE);
			flag = 1;
			e.printStackTrace();
		}
		String gioiTinh = "Nam";
		if(rdbtnNam.isSelected() == false)
			gioiTinh = "Nu";
		int isAdmin = 1;
		if(rdbtnAdmin.isSelected() == false)
			isAdmin = 0;
		if(flag == 0) {
			if(userDAO.getByUsername(username) != null)
				JOptionPane.showMessageDialog(contentPane, "Đăng ký thất bại, Vui lòng nhập username khác" , "Error", 
	                    JOptionPane.ERROR_MESSAGE);
			else {
				User user = new User(id,username,password,tenNV,sdt, ngaySinh,gioiTinh,isAdmin);
				userDAO.insert(user);
				JOptionPane.showMessageDialog(contentPane, "Đăng ký thành công", "Successfully", 
	                    JOptionPane.ERROR_MESSAGE);
			}
		}else
			JOptionPane.showMessageDialog(contentPane, "Đăng ký thất bại", "Error", 
                    JOptionPane.ERROR_MESSAGE);
	}
}