package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import DAO.BangDiaDAO;
import DAO.ChiTietBanHangDAO;
import DAO.ChiTietThueDiaDAO;
import DAO.HoaDonBanHangDAO;
import DAO.HoaDonThueDAO;
import DAO.KhachHangDAO;
import Model.BangDia;
import Model.ChiTietBanHang;
import Model.ChiTietThueDia;
import Model.HoaDonBanHang;
import Model.HoaDonThue;
import Model.KhachHang;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MuaDiaForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_dia;
	private JTable table_Dia;
	private JTable table_chitietmua;
	private JScrollPane scrollPane_Chitietmua;
	private JLabel lblThngTinMua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuaDiaForm frame = new MuaDiaForm();
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
	public MuaDiaForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 965, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_dia = new JTextField();
		textField_dia.setBounds(12, 13, 208, 22);
		contentPane.add(textField_dia);
		textField_dia.setColumns(10);
		
		JButton btnTmKima_dia = new JButton("Tìm kiếm đĩa");
		btnTmKima_dia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBangDiaClicked();
			}
		});
		btnTmKima_dia.setBounds(237, 12, 130, 25);
		contentPane.add(btnTmKima_dia);
		
		JScrollPane scrollPane_Dia = new JScrollPane();
		scrollPane_Dia.setBounds(12, 48, 469, 452);
		contentPane.add(scrollPane_Dia);
		
		table_Dia = new JTable();
		table_Dia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableDiaThemClicked();
			}
		});
		scrollPane_Dia.setViewportView(table_Dia);
		
		scrollPane_Chitietmua = new JScrollPane();
		scrollPane_Chitietmua.setBounds(514, 121, 400, 327);
		contentPane.add(scrollPane_Chitietmua);
		
		table_chitietmua = new JTable();
		table_chitietmua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*tableChiTietThueXoaClicked();*/
			}
		});
		
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã Đĩa");
		mod.addColumn("Tên Đĩa");
		mod.addColumn("Số lượng");
		mod.addColumn("Giá");
		mod.addColumn("Tổng giá");
		mod.addColumn("");
		table_chitietmua.setModel(mod);
		table_chitietmua.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {
				if (arg0.getColumn() != 4) {
					try {
						int row = table_chitietmua.getSelectedRow();
						float thanhTien = Float.parseFloat(table_chitietmua.getValueAt(row, 2).toString())
								* Float.parseFloat(table_chitietmua.getValueAt(row, 3).toString());
						table_chitietmua.setValueAt(thanhTien, row, 4);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		scrollPane_Chitietmua.setViewportView(table_chitietmua);
		
		JButton btnXacNhan = new JButton("Xác nhận mua");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XacNhan();
			}
		});
		btnXacNhan.setBounds(792, 471, 122, 49);
		contentPane.add(btnXacNhan);
		
		lblThngTinMua = new JLabel("Thông tin mua");
		lblThngTinMua.setBounds(514, 62, 148, 42);
		contentPane.add(lblThngTinMua);
		
		
		//XÓA CHI TIẾT
		table_chitietmua.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table_chitietmua.getSelectedColumn();
				if(col == 5) {
					XoaChiTiet();
				}
			}
		});
	}
	
	
	public void searchBangDiaClicked() {
		String kw = textField_dia.getText();
		List<BangDia> list = new BangDiaDAO().searchByName(kw);
		DefaultTableModel mod = new DefaultTableModel();
		mod.addColumn("Mã đĩa");
		mod.addColumn("Tên");
		mod.addColumn("Số lượng");
		mod.addColumn("Gía bán");
		mod.addColumn("Tên thể loại");
		mod.addColumn("");
		
		for(BangDia bd: list) {
			Object[] item = {bd.getMaDia(), bd.getTenLoaiDia(), bd.getSoLuong(), bd.getGiaBan(), bd.getTheLoai().getTenTL(), "Thêm"};
			mod.addRow(item);
		}
		table_Dia.setModel(mod);
	}
	
	public boolean kiemTraTrungChiTiet(String maDia) {
		for(int i=0; i<table_chitietmua.getRowCount();i++) {
			if(maDia.equals(table_chitietmua.getValueAt(i, 0).toString()))
				return false;
		}
		return true;
	}
	
	public void tableDiaThemClicked() {
		int column = table_Dia.getSelectedColumn();
		if(column==5) {
			int row = table_Dia.getSelectedRow();
			if(kiemTraTrungChiTiet(table_Dia.getValueAt(row, 0).toString())) {
				
				Object[] item = {table_Dia.getValueAt(row, 0), table_Dia.getValueAt(row, 1),"", table_Dia.getValueAt(row, 3),"", "XÓA"};
				DefaultTableModel mod = (DefaultTableModel)table_chitietmua.getModel();
				mod.addRow(item);
			}
		}
		/*int row = table_Dia.getSelectedRow();
		String MaDia = table_Dia.getModel().getValueAt(row, 0).toString();
		textField_MaDia.setText(MaDia);*/
	}
	
	public void tableChiTietThueXoaClicked() {
		DefaultTableModel mod = (DefaultTableModel)table_chitietmua.getModel();
		mod.removeRow(table_chitietmua.getSelectedRow());
	}
	
	public void XoaChiTiet() {
		DefaultTableModel mod = (DefaultTableModel)table_chitietmua.getModel();
		int row = table_chitietmua.getSelectedRow();
		mod.removeRow(row);
	}
	
	public void XacNhan() {
		int kt = kiemTraDuLieu();
		if(kt == -1) {
			JOptionPane.showMessageDialog(new JFrame(), "Số lượng nhập không hợp lệ");  
			return;
		}
		else if(kt==0) {
			JOptionPane.showMessageDialog(new JFrame(), "Số lượng không đủ");  
			return;
		}
		HoaDonBanHangDAO hoaDonBanHangDAO = new HoaDonBanHangDAO();
		ChiTietBanHangDAO chiTietBanHangDAO = new ChiTietBanHangDAO();
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		BangDiaDAO bangDiaDAO = new BangDiaDAO();
		
		HoaDonBanHang hdBan = new HoaDonBanHang();
		hdBan.setNgayBan(new Date());
		int maHoaDon = hoaDonBanHangDAO.insert(hdBan);
		hdBan.setMaHoaDon(maHoaDon);
		for(int i=0; i<table_chitietmua.getRowCount(); i++) {
			BangDia dia = bangDiaDAO.get(Integer.parseInt(table_chitietmua.getValueAt(i, 0).toString()));
			ChiTietBanHang ct = new ChiTietBanHang(hdBan, dia, 
										Integer.parseInt(table_chitietmua.getValueAt(i, 2).toString()), Float.parseFloat(table_chitietmua.getValueAt(i, 3).toString()));
			chiTietBanHangDAO.insert(ct);
			dia.setSoLuong(dia.getSoLuong()-Integer.parseInt(table_chitietmua.getValueAt(i, 2).toString()));
			bangDiaDAO.update(dia);
		}
		JOptionPane.showMessageDialog(null, "Thêm thành công");
	}
	
	public int kiemTraDuLieu() {
		BangDiaDAO bangDiaDAO = new BangDiaDAO();
		BangDia dia;
		for(int i=0; i<table_chitietmua.getRowCount(); i++) {
			try {
				if(table_chitietmua.getValueAt(i, 2).toString()=="")
					return -1;
			}catch(Exception e) {
				return -1;
			}
			dia = bangDiaDAO.get( Integer.parseInt(table_chitietmua.getValueAt(i, 0).toString()) );
			if(dia.getSoLuong() < Integer.parseInt( table_chitietmua.getValueAt(i, 2).toString() ) )
				return 0;
		}
		return 1;
		
	}
}
