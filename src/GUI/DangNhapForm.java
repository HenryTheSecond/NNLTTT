package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserDAO;
import Model.User;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class DangNhapForm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTaiKhoan;
	private JPasswordField passwordFieldMatKhau;
	private JRadioButton rdbtnQuanLi;
	private JRadioButton rdbtnNhanVien;
	UserDAO userDao = new UserDAO();
	User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapForm frame = new DangNhapForm();
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
	public DangNhapForm() {
		setTitle("Đăng Nhập Tài Khoản");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnQuanLi = new JRadioButton("Quản lí");
		rdbtnQuanLi.setSelected(true);
		rdbtnQuanLi.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		rdbtnQuanLi.setBounds(44, 51, 128, 28);
		contentPane.add(rdbtnQuanLi);
		
		rdbtnNhanVien = new JRadioButton("Nhân viên");
		rdbtnNhanVien.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		rdbtnNhanVien.setBounds(185, 54, 128, 28);
		contentPane.add(rdbtnNhanVien);
		
		ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnNhanVien);
        bg.add(rdbtnQuanLi);
		
        
		JButton btnDangKi = new JButton("Đăng Kí");
		btnDangKi.setBounds(44, 199, 110, 41);
		contentPane.add(btnDangKi);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDangNhapClicked();
			}
		});
		btnDangNhap.setBounds(185, 199, 110, 41);
		contentPane.add(btnDangNhap);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(316, 199, 110, 41);
		contentPane.add(btnCancel);
		
		JLabel lblTnngNhp = new JLabel("Tên Tài Khoản :");
		lblTnngNhp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblTnngNhp.setBounds(25, 89, 134, 35);
		contentPane.add(lblTnngNhp);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu :");
		lblMtKhu.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblMtKhu.setBounds(56, 134, 98, 35);
		contentPane.add(lblMtKhu);
		
		JLabel lblngNhp = new JLabel("ĐĂNG NHẬP TÀI KHOẢN");
		lblngNhp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblngNhp.setBounds(119, 24, 205, 35);
		contentPane.add(lblngNhp);
		
		textFieldTaiKhoan = new JTextField();
		textFieldTaiKhoan.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldTaiKhoan.setBounds(163, 89, 161, 28);
		contentPane.add(textFieldTaiKhoan);
		textFieldTaiKhoan.setColumns(10);
		
		passwordFieldMatKhau = new JPasswordField();
		passwordFieldMatKhau.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		passwordFieldMatKhau.setBounds(164, 137, 160, 28);
		contentPane.add(passwordFieldMatKhau);
		
		
	}
	public void btnDangNhapClicked() {
		String username = textFieldTaiKhoan.getText();
		String password = String.valueOf(passwordFieldMatKhau.getPassword());
		int isAdmin = 1;
		if(rdbtnNhanVien.isSelected() == true)
			isAdmin = 0;
		try {
			int chuyenHuong = userDao.kiemTraDangNhap(isAdmin, username, password);
			if(chuyenHuong == 2)
				JOptionPane.showMessageDialog(contentPane, "Sai tài khoản hoặc mật khẩu vui lòng chọn quyền truy cập thích hợp!!!", "Error", 
                          JOptionPane.ERROR_MESSAGE);
			else if(chuyenHuong == 1) {
				this.setVisible(false);
				MenuQuanLiForm menuQuanLiF = new MenuQuanLiForm();
				menuQuanLiF.setVisible(true);;
			}else {
				this.setVisible(false);
				MenuNhanVienForm menuNhanVienF = new MenuNhanVienForm();
				menuNhanVienF.setVisible(true);;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
