package GUI;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BLL.ChiTietMuonBLL;
import BLL.MuonBLL;
import BLL.QLDocGiaBLL;
import BLL.QLSachBLL;
import BLL.QLThongTinCaNhanBLL;
import DAL.PhieuMuonDAL;
import DTO.PhieuMuonDTO;


public class NhapMaQuyenSachGUI {
	private JFrame frmMain;
	private JTextField tfMaQs;
	private static NhapMaQuyenSachGUI instance = null;
	private NhapMaQuyenSachGUI(String maPhieuMuon, String tenDocGia,boolean isCheck){
		init(maPhieuMuon, tenDocGia, isCheck);
	}
	
	public static NhapMaQuyenSachGUI getInstance(String maPhieuMuon, String tenDocGia,boolean isCheck) {
		if (instance == null)
			instance = new NhapMaQuyenSachGUI(maPhieuMuon, tenDocGia, isCheck);
		return instance;
	}
	
	public JFrame getFrmMain() {
		return frmMain;
	}
	
	public void clearField() {
		tfMaQs.setText("");
	}
	
	private void init(String maPhieuMuon, String tenDocGia,boolean isCheck) {
		frmMain = new JFrame("");
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setBounds(500, 300, 400, 300);//595
		frmMain.getContentPane().setLayout(null);
		
		JPanel pnNhapMSSV = new JPanel();
		pnNhapMSSV.setBounds(0, 0, 400, 300);
		frmMain.getContentPane().add(pnNhapMSSV);
		pnNhapMSSV.setLayout(null);
		

		JLabel lblMaQs = new JLabel("Nhap ma quyen sach:*");
		lblMaQs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaQs.setBounds(70, 30, 200, 50);
		pnNhapMSSV.add(lblMaQs);
		
		tfMaQs = new JTextField();
		tfMaQs.setBounds(50, 100, 300, 40);
		tfMaQs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnNhapMSSV.add(tfMaQs);
		tfMaQs.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnOk.setBounds(70, 200, 100, 40);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!QLSachBLL.getInstance().isContain(tfMaQs.getText())) {
					clearField();
					JOptionPane.showMessageDialog(null, "Ma quyen sach khong ton tai!","Thong bao",1);
				}else {
					int result = ChiTietMuonBLL.getInstance().addProcessing(maPhieuMuon, tfMaQs.getText());
					if (result > 0) {
						QLChiTietPhieuMuonGUI.getInstance(maPhieuMuon, tenDocGia, isCheck).reloadResources(maPhieuMuon);
						
						frmMain.setVisible(false);
					}else {
						clearField();
						JOptionPane.showMessageDialog(null, "Them chi tiet phieu muon khong thanh cong!","Thong bao",1);
					}
				}
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
