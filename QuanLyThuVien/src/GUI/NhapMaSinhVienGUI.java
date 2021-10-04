package GUI;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NhapMaSinhVienGUI {
	private JFrame frmMain;
	private static NhapMaSinhVienGUI instance = null;
	private NhapMaSinhVienGUI(){
		init();
	}
	
	public static NhapMaSinhVienGUI getInstance() {
		if (instance == null)
			instance = new NhapMaSinhVienGUI();
		return instance;
	}
	
	public JFrame getFrmMain() {
		return frmMain;
	}
	
	void init() {
		frmMain = new JFrame("Quản lý thư viện");
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setBounds(500, 500, 400, 500);//595
		frmMain.getContentPane().setLayout(null);
		
		JPanel pnNhapMSSV = new JPanel();
		pnNhapMSSV.setBounds(0, 560, 1072, 50);
		frmMain.getContentPane().add(pnNhapMSSV);
		pnNhapMSSV.setLayout(null);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThoat.setIcon(new ImageIcon("icon//logout.png"));
		btnThoat.setBounds(896, 5, 138, 41);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmMain.setVisible(false);
				QLDangNhapGUI.getInstance().getFrame().setVisible(true);
			}
		});
		pnNhapMSSV.add(btnThoat);
		pnNhapMSSV.setBackground(SystemColor.activeCaption);
		frmMain.repaint();
		frmMain.invalidate();
	}
}