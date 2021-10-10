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

import BLL.QLSachBLL;
import CustomControl.ButtonEditor;
import CustomControl.ButtonRenderer;
import DTO.DauSachDTO;

public class QLChiTietPhieuMuonGUI {
	static QLChiTietPhieuMuonGUI instance = null;
	private JPanel pnMain;
	private JTable tbChiTietPM;
	private JTextField tfTimKiem;
	

	private QLChiTietPhieuMuonGUI() {
		initialize();
		loadResources();
	}

	private void loadResources() {

	}

	public static QLChiTietPhieuMuonGUI getInstance() {
		if (instance == null)
			instance = new QLChiTietPhieuMuonGUI();
		return instance;
	}

	public JPanel getPnMain() {
		return pnMain;
	}

	public JTextField getText() {
		return tfTimKiem;
	}

	

	private void initialize() {
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
		
		JButton btnThoat = new JButton();
		btnThoat.setIcon(new ImageIcon("icon\\logout.png"));
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThoat.setBounds(10, 10, 50, 50);
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnMain.removeAll();
				QLMuonTraGUI qlMuonTraGUI = QLMuonTraGUI.getInstance();	
				pnMain.add(qlMuonTraGUI.getPnMain());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		pnTitle.add(btnThoat);

	
		
		/*tfTimKiem = new JTextField();
		tfTimKiem.setToolTipText("NHAP MA PHIEU MUON HOAC HO TEN SINH VIEN ...");
		tfTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfTimKiem.setBounds(559, 15, 337, 30);
		pnDanhSachMuon.add(tfTimKiem);


		JButton btnTimKiem = new JButton();
		btnTimKiem.setIcon(new ImageIcon("icon\\find.png"));
		btnTimKiem.setText("Tim kiem");
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTimKiem.setBounds(919, 15, 134, 30);
		pnDanhSachMuon.add(btnTimKiem);
		
		
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfTimKiem.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "Ban chua nhap tu khoa can tim!", "Thong bao", 1);
				else {
					tbMuonTra.setModel(QLMuonTraBLL.getInstance().timKiem(tfTimKiem.getText()));
					tbMuonTra.getColumn("Tráº£ sÃ¡ch").setCellRenderer(new ButtonRenderer());
					tbMuonTra.getColumn("Tráº£ sÃ¡ch").setCellEditor(new ButtonEditor(new JCheckBox()));
				}
			}
		});*/

		tbChiTietPM = new JTable();
		tbChiTietPM.setBounds(10, 34, 855, 433);
		JScrollPane sc = new JScrollPane(tbChiTietPM, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(10, 34, 855, 443);
//		tbMuonTra.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent evt) {
//				int row = tbMuonTra.rowAtPoint(evt.getPoint());
//				int col = tbMuonTra.columnAtPoint(evt.getPoint());
//				if (row >= 0 && col >= 0) {
//					if (col == 7) {
//						String msg = QLMuonTraBLL.getInstance().traSach(
//								tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 1).toString(),
//								tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 3).toString());
//						lblMessage.setText(msg);
//						loadResources();
//					} else {
//						isEdit = false;
//						setStateForTextfeild();
//						// hiá»ƒn thá»‹ thÃ´ng tin vÃ o trong cÃ¡c trÆ°á»�ng
//						tfMaDocGia.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 1).toString());
//						tfHoTen.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 2).toString());
//						tfMaSach.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 3).toString());
//						tfTenSach.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 4).toString());
//						try {
//							dcNgayMuon.setDate(
//									Date.valueOf(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 5).toString()));
//							dcNgayTra.setDate(
//									Date.valueOf(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 6).toString()));
//							tfTrangThai.setText("Ä�ang Ä‘Æ°á»£c mÆ°á»£n");
//							Calendar cal = dcNgayMuon.getCalendar();
//							java.util.Date date = cal.getTime();
//							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//							String nm = sdf.format(date);
//							cal = dcNgayTra.getCalendar();
//							date = cal.getTime();
//							String nt = sdf.format(date);
//							QLMuonTraBLL.getInstance().muonTra = new MuonTraDTO(tfMaDocGia.getText(),
//									tfMaSach.getText(), Date.valueOf(nm), Date.valueOf(nt));
//						} catch (Exception e1) {
//							lblMessage.setText(e1.getMessage());
//
//						}
//					}
//				}
//			}
//		});
		pnDanhSachMuon.add(sc, BorderLayout.CENTER);
		JButton btnThem = new JButton("Them");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(900, 200, 138, 40);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		pnDanhSachMuon.add(btnThem);
		
		JButton btnSua = new JButton("Sua");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
//		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
//		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		btnSua.setBounds(900, 200, 138, 40);
//		pnDanhSachMuon.add(btnSua);
		
//		JButton btnHuy = new JButton("Huy");
//		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
//		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		btnHuy.setBounds(900, 265, 138, 40);
//		pnDanhSachMuon.add(btnHuy);
//		btnHuy.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				clearField();
//				isChanging = true;
//				setStateForTextfield();
//				
//			}
//		});
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(900, 265, 138, 40);
		pnDanhSachMuon.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

	}
	
}
