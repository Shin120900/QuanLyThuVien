package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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

import CustomControl.ButtonEditor;
import CustomControl.ButtonRenderer;
import MyException.ContainException;
import MyException.MyException;

import com.toedter.calendar.JDateChooser;

import BLL.MuonBLL;

public class QLMuonTraGUI {

	static QLMuonTraGUI instance = null;
	private JPanel pnMain;
	private JTable tbMuonTra;
	private JTextField tfTimKiem;
	

	private boolean isEdit = true;

	private QLMuonTraGUI() {
		initialize();
		loadResources();
	}

	private void loadResources() {
		tbMuonTra.setModel(MuonBLL.getInstance().getResources());
//		tbMuonTra.getColumn("Tráº£ sÃ¡ch").setCellRenderer(new ButtonRenderer());
//		tbMuonTra.getColumn("Tráº£ sÃ¡ch").setCellEditor(new ButtonEditor(new JCheckBox()));
	}
	
	public void reloadResources() {
		tbMuonTra.setModel(MuonBLL.getInstance().reloadResources());
	}

	public static QLMuonTraGUI getInstance() {
		if (instance == null)
			instance = new QLMuonTraGUI();
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



		// them tieu de
		JLabel lblTitle = new JLabel("QUAN LY MUON TRA SACH");
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTitle.setBounds(349, 16, 377, 39);
		pnTitle.add(lblTitle);

		JButton btnThem = new JButton();
		btnThem.setText("Them");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(10, 15, 134, 30);
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NhapMaSinhVienGUI.getInstance().getFrmMain().setVisible(true);
			}
		});
		pnDanhSachMuon.add(btnThem);
		
		tfTimKiem = new JTextField();
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
					tbMuonTra.setModel(MuonBLL.getInstance().timKiem(tfTimKiem.getText()));
					
				}
			}
		});

		tbMuonTra = new JTable();
		tbMuonTra.setBounds(0, 0, 1060, 230);
		JScrollPane sc = new JScrollPane(tbMuonTra, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(10, 60, 1040, 412);
		tbMuonTra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
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
					TrangChuGUI.getInstance().setBgChiTietPM(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 0).toString(),
							tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 2).toString(), false);	
					
			}
		});
		pnDanhSachMuon.add(sc, BorderLayout.CENTER);

	}
	
}

