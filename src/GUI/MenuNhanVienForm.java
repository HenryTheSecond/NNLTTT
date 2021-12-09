package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuNhanVienForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuNhanVienForm frame = new MenuNhanVienForm();
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
	public MenuNhanVienForm() {
		setTitle("Menu Nhan Vien Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("B\u00E1n \u0111\u0129a");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("L\u1EADp h\u00F3a \u0111\u01A1n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MuaDiaForm muaDiaForm = new MuaDiaForm();
				muaDiaForm.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Thu\u00EA \u0111\u0129a");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("L\u1EADp h\u00F3a \u0111\u01A1n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThueDiaForm thueDiaForm = new ThueDiaForm();
				thueDiaForm.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Tr\u1EA3 \u0111\u0129a");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TraDiaForm().setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Kh\u00E1ch h\u00E0ng");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmThmKhchHng = new JMenuItem("Th\u00EAm kh\u00E1ch h\u00E0ng");
		mntmThmKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThemKhachHangForm().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmThmKhchHng);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangXuatClicked();
			}
		});
		menuBar.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void DangXuatClicked() {
		new DangNhapForm().setVisible(true);
		this.setVisible(false);
	}
}
