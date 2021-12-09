package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.TheLoaiDAO;
import DAO.TienPhatDAO;
import Model.TheLoai;
import Model.TienPhat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TienPhatForm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTienPhat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TienPhatForm frame = new TienPhatForm();
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
	public TienPhatForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTienPhat = new JLabel("Tiền Phạt");
		lblTienPhat.setBounds(12, 25, 117, 48);
		contentPane.add(lblTienPhat);
		
		textFieldTienPhat = new JTextField();
		textFieldTienPhat.setBounds(141, 32, 169, 35);
		contentPane.add(textFieldTienPhat);
		textFieldTienPhat.setColumns(10);
		load();
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateClicked();
			}
		});
		btnUpdate.setBounds(68, 86, 106, 41);
		contentPane.add(btnUpdate);
	}
	
	public void load() {
		float tienphat = new TienPhatDAO().get();
		textFieldTienPhat.setText(String.valueOf(tienphat));
	}
	
	public void btnUpdateClicked() {
		try {
			float tienphat=Float.parseFloat(textFieldTienPhat.getText());
			new TienPhatDAO().update(tienphat);
			JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			load();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
		}
	}

}
