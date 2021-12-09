package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.KhachHangDAO;
import Model.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemKhachHangForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemKhachHangForm frame = new ThemKhachHangForm();
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
	public ThemKhachHangForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnKhchHng = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		lblTnKhchHng.setBounds(10, 31, 116, 14);
		contentPane.add(lblTnKhchHng);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(136, 28, 139, 20);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setBounds(10, 56, 64, 14);
		contentPane.add(lblaCh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(136, 53, 218, 20);
		contentPane.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setBounds(10, 81, 77, 14);
		contentPane.add(lblSinThoi);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(136, 78, 139, 20);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddClicked();
			}
		});
		btnAdd.setBounds(109, 126, 97, 55);
		contentPane.add(btnAdd);
	}
	
	public void btnAddClicked() {
		if(kiemTraInput()) {
			KhachHang kh = new KhachHang();
			kh.setTenKH(txtTenKH.getText());
			kh.setDiaChi(txtDiaChi.getText());
			kh.setSoDT(txtSDT.getText());
			KhachHangDAO khachHangDAO = new KhachHangDAO();
			try {
				khachHangDAO.insert(kh);
				JOptionPane.showMessageDialog(contentPane, "Thêm thành công" , "Information", 
	                    JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(contentPane, "Thêm thất bại" , "Error", 
	                    JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đủ thông tin" , "Information", 
                    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean kiemTraInput() {
		if(txtTenKH.getText().equals("") || txtDiaChi.getText().equals("") || txtSDT.getText().equals(""))
			return false;
		return true;
	}
}
