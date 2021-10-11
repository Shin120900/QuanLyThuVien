package GUI;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BLL.MuonBLL;
import BLL.QLDocGiaBLL;
import BLL.QLThongTinCaNhanBLL;
import DAL.PhieuMuonDAL;
import DTO.DocGiaDTO;
import DTO.PhieuMuonDTO;


public class NhapMaSinhVienGUI {
	private JFrame frmMain;
	private JTextField tfMaDg;
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
	
	private void clearField() {
		tfMaDg.setText("");
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
		

		JLabel lblMaDg = new JLabel("Nhap ma doc gia:*");
		lblMaDg.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaDg.setBounds(100, 30, 170, 50);
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
				if(!QLDocGiaBLL.getInstance().isContain(tfMaDg.getText())) {
					clearField();
					JOptionPane.showMessageDialog(null, "Ma sinh vien khong ton tai!","Thong bao",1);
				}else {
					int result = MuonBLL.getInstance().addProcessing(QLThongTinCaNhanBLL.GetInstance().getNv().getManv(), tfMaDg.getText());
					if (result > 0) {
						ArrayList<PhieuMuonDTO> dsPhieuMuon = new ArrayList<PhieuMuonDTO>();
						dsPhieuMuon = PhieuMuonDAL.getInstance().getResources();
						frmMain.setVisible(false);
						TrangChuGUI.getInstance().setBgChiTietPM(PhieuMuonDAL.getInstance().getMaMuon(),
								PhieuMuonDAL.getInstance().getTenSV(), true);
					}else {
						clearField();
						JOptionPane.showMessageDialog(null, "Them phieu muon khong thanh cong!","Thong bao",1);
					}
				}
				
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
