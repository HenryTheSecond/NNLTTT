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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TheLoaiForm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaTL;
	private JTextField textFieldTenML;
	private JTable tableTheLoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheLoaiForm frame = new TheLoaiForm();
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
	public TheLoaiForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaTL = new JLabel("Mã Thể Loại");
		lblMaTL.setBounds(30, 13, 137, 55);
		contentPane.add(lblMaTL);
		
		textFieldMaTL = new JTextField();
		textFieldMaTL.setEnabled(false);
		textFieldMaTL.setBounds(148, 29, 143, 22);
		contentPane.add(textFieldMaTL);
		textFieldMaTL.setColumns(10);
		
		JLabel lblTenTL = new JLabel("Tên Thể Loại");
		lblTenTL.setBounds(30, 94, 137, 55);
		contentPane.add(lblTenTL);
		
		textFieldTenML = new JTextField();
		textFieldTenML.setColumns(10);
		textFieldTenML.setBounds(148, 110, 219, 22);
		contentPane.add(textFieldTenML);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 186, 710, 238);
		contentPane.add(scrollPane);
		
		tableTheLoai = new JTable();
		tableTheLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClicked();
			}
		});
		InitTableTheLoai();
		scrollPane.setViewportView(tableTheLoai);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddClicked();
			}
		});
		btnAdd.setBounds(629, 13, 111, 42);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateClicked();
			}
		});
		btnUpdate.setBounds(629, 68, 111, 42);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteClicked();
			}
		});
		btnDelete.setBounds(629, 123, 111, 42);
		contentPane.add(btnDelete);
	}
	

	public void InitTableTheLoai() {
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã thể loại"); 
		mod.addColumn("Tên thể loại");
		
		tableTheLoai.setModel(mod);
		
		List<TheLoai> list = new TheLoaiDAO().getAll();
		fillTable(list);
	}
	
	public void fillTable(List<TheLoai> list) {
		DefaultTableModel mod = (DefaultTableModel)tableTheLoai.getModel();
		mod.setRowCount(0);
		for(TheLoai tl:list) {
			Object item[] = {tl.getMaTL(), tl.getTenTL()};
			mod.addRow(item);
		}
	}
	
	public void tableClicked() {
		int row = tableTheLoai.getSelectedRow();
		textFieldMaTL.setText(tableTheLoai.getValueAt(row, 0).toString());
		textFieldTenML.setText(tableTheLoai.getValueAt(row, 1).toString());
	}
	
	public boolean kiemTraInput() {
		if(textFieldTenML.getText().equals(""))
			return false;
		return true;
	}
	
	public void btnAddClicked() {
		if(kiemTraInput()) {
			TheLoai tl = new TheLoai();
			tl.setTenTL(textFieldTenML.getText());
			
			new TheLoaiDAO().insert(tl);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			InitTableTheLoai();
		}
		else
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thể loại");
	}
	
	public void btnUpdateClicked() {
		TheLoai theLoai = new TheLoai();
		try {
			theLoai.setMaTL(Integer.parseInt(textFieldMaTL.getText()));
			theLoai.setTenTL(textFieldTenML.getText());
			new TheLoaiDAO().update(theLoai);
			JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			InitTableTheLoai();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
		}
	}
	
	
	public void btnDeleteClicked() {
		try {
			int maTheLoai = Integer.parseInt(textFieldMaTL.getText());
			if( JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa thể loại") == JOptionPane.YES_OPTION ) {
				new TheLoaiDAO().delete(maTheLoai);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				InitTableTheLoai();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại");
		}
	}
}

