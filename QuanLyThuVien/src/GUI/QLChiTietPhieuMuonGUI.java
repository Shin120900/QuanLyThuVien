package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BLL.BienBanBLL;
import BLL.ChiTietMuonBLL;
import BLL.QLSachBLL;
import CustomControl.ButtonEditor;
import CustomControl.ButtonRenderer;
import DTO.DauSachDTO;

public class QLChiTietPhieuMuonGUI {
	static QLChiTietPhieuMuonGUI instance = null;
	private JPanel pnMain;
	private JTable tbChiTietPM;
	private JTextField tfMaPM;
	private JTextField tfTenDocGia;
	
	private String maQuyenSach;

	private QLChiTietPhieuMuonGUI(String maPhieuMuon, String tenDocGia, boolean isCheck) {
		initialize(maPhieuMuon, tenDocGia, isCheck);
		loadResources(maPhieuMuon);
	}

	private void loadResources(String maPhieuMuon) {
		tbChiTietPM.setModel(ChiTietMuonBLL.getInstance().getResources(maPhieuMuon));
	}
	
	public void reloadResources(String maPhieuMuon) {
		tbChiTietPM.setModel(ChiTietMuonBLL.getInstance().reloadResources(maPhieuMuon));
	}

	public static QLChiTietPhieuMuonGUI getInstance(String maPhieuMuon, String tenDocGia, boolean isCheck) {
		if (instance == null)
			instance = new QLChiTietPhieuMuonGUI(maPhieuMuon, tenDocGia, isCheck);
		return instance;
	}

	public JPanel getPnMain() {
		return pnMain;
	}


	private void initialize(String maPhieuMuon, String tenDocGia, boolean isCheck) {
		pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 0, 1065, 560);
		pnMain.setBackground(Color.WHITE);

		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(null);
		pnTitle.setBackground(SystemColor.activeCaption);
		pnTitle.setBounds(0, 0, 1065, 70);
		pnMain.add(pnTitle);

		JPanel pnDanhSachMuon = new JPanel();
		pnDanhSachMuon.setLayout(null);
		pnDanhSachMuon.setBackground(SystemColor.activeCaption);
		pnDanhSachMuon.setBounds(0, 73	, 1065, 487);
		pnMain.add(pnDanhSachMuon);


		JLabel lblTitle = new JLabel("QUAN LY CHI TIET PHIEU MUON");
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTitle.setBounds(340, 16, 400, 40);
		pnTitle.add(lblTitle);
		
		if(!isCheck) {
			JButton btnThoat = new JButton();
			btnThoat.setIcon(new ImageIcon("icon\\logout.png"));
			btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnThoat.setBounds(10, 10, 50, 50);
			btnThoat.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					TrangChuGUI.getInstance().setBgPhieuMuon();
				}
			});
			pnTitle.add(btnThoat);
		}

		JLabel lblMaPM = new JLabel("Ma phieu muon:");
		lblMaPM.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMaPM.setBounds(120, 45, 90, 15);
		pnDanhSachMuon.add(lblMaPM);
		
		tfMaPM = new JTextField();
		tfMaPM.setBounds(210, 40, 160, 30);
		tfMaPM.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnDanhSachMuon.add(tfMaPM);
		tfMaPM.setText(maPhieuMuon);
		tfMaPM.setEditable(false);
		tfMaPM.setColumns(10);
		
		JLabel lblTenDG = new JLabel("Ten doc gia:");
		lblTenDG.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTenDG.setBounds(500, 45, 90, 15);
		pnDanhSachMuon.add(lblTenDG);
		
		tfTenDocGia = new JTextField();
		tfTenDocGia.setBounds(580, 40, 160, 30);
		tfTenDocGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnDanhSachMuon.add(tfTenDocGia);
		tfTenDocGia.setText(tenDocGia);
		tfTenDocGia.setEditable(false);
		tfTenDocGia.setColumns(10);

		tbChiTietPM = new JTable();
		tbChiTietPM.setBounds(10, 34, 855, 350);
		JScrollPane sc = new JScrollPane(tbChiTietPM, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(40, 100, 855, 380);
		tbChiTietPM.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tbChiTietPM.getSelectedRow()< 0)
					return;
				if(isCheck) {
					maQuyenSach = tbChiTietPM.getValueAt(tbChiTietPM.getSelectedRow(), 1).toString();
				}
				
			}
		});
		pnDanhSachMuon.add(sc, BorderLayout.CENTER);
		
		if(isCheck) {
			JButton btnThem = new JButton("Them");
			btnThem.setIcon(new ImageIcon("icon\\new.png"));
			btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnThem.setBounds(900, 200, 138, 40);
			btnThem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					NhapMaQuyenSachGUI.getInstance(maPhieuMuon, tenDocGia, isCheck).getFrmMain().setVisible(true);
				}
			});
			pnDanhSachMuon.add(btnThem);
			
			
			JButton btnXoa = new JButton("Xoa");
			btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
			btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnXoa.setBounds(900, 265, 138, 40);
			pnDanhSachMuon.add(btnXoa);
			btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ChiTietMuonBLL.getInstance().deleteProcessing(maPhieuMuon, maQuyenSach);
				}
			});
			
			JButton btnLuu = new JButton("Luu");
			btnLuu.setIcon(new ImageIcon("icon\\save.png"));
			btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnLuu.setBounds(900, 330, 138, 40);
			pnDanhSachMuon.add(btnLuu);
			btnLuu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TrangChuGUI.getInstance().setBgPhieuMuon();
				}
			});
		}

	}
	
}
