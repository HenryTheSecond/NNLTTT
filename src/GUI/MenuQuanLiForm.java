package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuQuanLiForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuQuanLiForm frame = new MenuQuanLiForm();
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
	public MenuQuanLiForm() {
		setTitle("Menu Quan Li Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnngK = new JMenu("Nh\u00E2n vi\u00EAn");
		menuBar.add(mnngK);
		
		JMenuItem mntmngKNhn = new JMenuItem("\u0110\u0103ng k\u00ED nh\u00E2n vi\u00EAn");
		mntmngKNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangKiForm().setVisible(true);
			}
		});
		mnngK.add(mntmngKNhn);
		
		JMenuItem mntmQunLNhn = new JMenuItem("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		mntmQunLNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLiNhanVienForm().setVisible(true);
			}
		});
		mnngK.add(mntmQunLNhn);
		
		JMenu mnBnga = new JMenu("B\u0103ng \u0111\u0129a");
		menuBar.add(mnBnga);
		
		JMenuItem mntmQunLBng = new JMenuItem("Qu\u1EA3n l\u00FD b\u0103ng \u0111\u0129a");
		mntmQunLBng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLyBangDiaForm().setVisible(true);
			}
		});
		mnBnga.add(mntmQunLBng);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Th\u1EC3 lo\u1EA1i");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TheLoaiForm().setVisible(true);
			}
			
		});
		mnBnga.add(mntmNewMenuItem);
		
		JMenu mnThngK = new JMenu("Th\u1ED1ng k\u00EA");
		menuBar.add(mnThngK);
		
		JMenuItem mntmXemThngK = new JMenuItem("Xem th\u1ED1ng k\u00EA");
		mntmXemThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThongKeForm().setVisible(true);
			}
		});
		mnThngK.add(mntmXemThngK);
		
		JMenu mnChnhSa = new JMenu("Ch\u1EC9nh s\u1EEDa");
		menuBar.add(mnChnhSa);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ti\u1EC1n ph\u1EA1t");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TienPhatForm().setVisible(true);
			}
		});
		mnChnhSa.add(mntmNewMenuItem_1);
		
		JMenuItem mntmngXut = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
		mntmngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangXuatClicked();
			}
		});
		menuBar.add(mntmngXut);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	public void DangXuatClicked() {
		new DangNhapForm().setVisible(true);
		this.setVisible(false);
	}
}
