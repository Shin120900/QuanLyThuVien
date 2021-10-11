package GUI;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NhapMaQuyenSachGUI {
	private JFrame frmMain;
	private JTextField tfMaDg;
	private static NhapMaQuyenSachGUI instance = null;
	private NhapMaQuyenSachGUI(){
		init();
	}
	
	public static NhapMaQuyenSachGUI getInstance() {
		if (instance == null)
			instance = new NhapMaQuyenSachGUI();
		return instance;
	}
	
	public JFrame getFrmMain() {
		return frmMain;
	}
	
	void init() {
		frmMain = new JFrame("");
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setBounds(500, 300, 400, 300);//595
		frmMain.getContentPane().setLayout(null);
		
		JPanel pnNhapMSSV = new JPanel();
		pnNhapMSSV.setBounds(0, 0, 400, 300);
		frmMain.getContentPane().add(pnNhapMSSV);
		pnNhapMSSV.setLayout(null);
		

		JLabel lblMaDg = new JLabel("Nhap ma quyen sach:*");
		lblMaDg.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaDg.setBounds(70, 30, 200, 50);
		pnNhapMSSV.add(lblMaDg);
		
		tfMaDg = new JTextField();
		tfMaDg.setBounds(50, 100, 300, 40);
		tfMaDg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnNhapMSSV.add(tfMaDg);
		tfMaDg.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnOk.setBounds(70, 200, 100, 40);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmMain.setVisible(false);

			}
		});
		pnNhapMSSV.add(btnOk);
		
		JButton btnThoat = new JButton("Cancel");
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThoat.setBounds(230, 200, 100, 40);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmMain.setVisible(false);
			}
		});
		pnNhapMSSV.add(btnThoat);
		pnNhapMSSV.setBackground(SystemColor.activeCaption);
		frmMain.repaint();
		frmMain.invalidate();
	}
}
