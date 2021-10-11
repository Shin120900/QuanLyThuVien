package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BLL.QLThongTinCaNhanBLL;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLThongTinCaNhanGUI {

	private JPanel pnTongQuanQLChaoMung;

	static QLThongTinCaNhanGUI instance = null;
	public JTextField tfMaNhanVien;
	public JTextField tfTenNhanVien;
	public JTextField tfChucVu;
	public JTextField tfGioiTinh;
	public JTextField tfNgaySinh;
	public JTextField tfDiaChi;
	public JTextField tfSdt;
	public JTextField tfMatKhau;
	public JTextField tfMatKhauMoi;
	public JTextField tfNhapLaiMatKhauMoi;
	public JLabel lblMessage;
	
	public QLThongTinCaNhanGUI() {
		initialize();
	}
	
	public void loadResources() {
		QLThongTinCaNhanBLL.GetInstance().LoadResources();
	}
	
	public static QLThongTinCaNhanGUI getInstance() {
		if(instance == null)
			instance = new QLThongTinCaNhanGUI();
		return instance;
	}
	
	public void clearField() {
		tfMatKhau.setText("");
		tfMatKhauMoi.setText("");
		tfNhapLaiMatKhauMoi.setText("");
	}
	
	public JPanel getPnTongQuanQLChaoMung() {
		return pnTongQuanQLChaoMung;
	}
	private void initialize() {
		
		
		pnTongQuanQLChaoMung = new JPanel();
		pnTongQuanQLChaoMung.setBounds(0, 0, 1065, 560);
		pnTongQuanQLChaoMung.setLayout(null);
		
		JPanel pnTieuDeTTCN = new JPanel();
		pnTieuDeTTCN.setBackground(SystemColor.activeCaption);
		pnTieuDeTTCN.setBounds(0, 0, 1065, 87);
		pnTongQuanQLChaoMung.add(pnTieuDeTTCN);
		pnTieuDeTTCN.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUAN LY THONG TIN CA NHAN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(348, 11, 391, 57);
		pnTieuDeTTCN.add(lblNewLabel);
		
		JPanel pnThongTinCaNhan = new JPanel();
		pnThongTinCaNhan.setBackground(SystemColor.activeCaption);
		pnThongTinCaNhan.setBounds(0, 90, 1065, 210);
		pnTongQuanQLChaoMung.add(pnThongTinCaNhan);
		pnThongTinCaNhan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("THONG TIN CA NHAN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 5, 226, 34);
		pnThongTinCaNhan.add(lblNewLabel_1);
		
		JPanel pnQLTTCN = new JPanel();
		pnQLTTCN.setBounds(10, 35, 1045, 164);
		pnThongTinCaNhan.add(pnQLTTCN);
		pnQLTTCN.setLayout(null);
		
		JLabel lblMaNhanVien = new JLabel("Ma nhan vien:");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMaNhanVien.setBounds(140, 45, 80, 15);
		pnQLTTCN.add(lblMaNhanVien);
		
		tfMaNhanVien = new JTextField();
		tfMaNhanVien.setBounds(220, 40, 160, 30);
		tfMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfMaNhanVien);
		tfMaNhanVien.setEditable(false);
		tfMaNhanVien.setColumns(10);
		
		JLabel lblTenNhanVien = new JLabel("Ten nhan vien:");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTenNhanVien.setBounds(400, 45, 80, 15);
		pnQLTTCN.add(lblTenNhanVien);
		
		tfTenNhanVien = new JTextField();
		tfTenNhanVien.setBounds(482, 40, 160, 30);
		tfTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfTenNhanVien);
		tfTenNhanVien.setEditable(false);
		tfTenNhanVien.setColumns(10);
		
		JLabel lblChucVu = new JLabel("Chuc vu:");
		lblChucVu.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblChucVu.setBounds(684, 45, 80, 15);
		pnQLTTCN.add(lblChucVu);
		
		tfChucVu = new JTextField();
		tfChucVu.setBounds(742, 40, 160, 30);
		tfChucVu.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfChucVu);
		tfChucVu.setEditable(false);
		tfChucVu.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Gioi tinh:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGioiTinh.setBounds(20, 110, 80, 15);
		pnQLTTCN.add(lblGioiTinh);
		
		tfGioiTinh = new JTextField();
		tfGioiTinh.setBounds(100, 105, 160, 30);
		tfGioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfGioiTinh);
		tfGioiTinh.setEditable(false);
		tfGioiTinh.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngay sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNgaySinh.setBounds(280, 110, 80, 15);
		pnQLTTCN.add(lblNgaySinh);
		
		tfNgaySinh = new JTextField();
		tfNgaySinh.setBounds(360, 105, 160, 30);
		tfNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfNgaySinh);
		tfNgaySinh.setEditable(false);
		tfNgaySinh.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Dia chi:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDiaChi.setBounds(540, 110, 80, 15);
		pnQLTTCN.add(lblDiaChi);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setBounds(620, 105, 160, 30);
		tfDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfDiaChi);
		tfDiaChi.setEditable(false);
		tfDiaChi.setColumns(10);
		
		JLabel lblSdt = new JLabel("So dien thoai:");
		lblSdt.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSdt.setBounds(800, 110, 80, 15);
		pnQLTTCN.add(lblSdt);
		
		tfSdt = new JTextField();
		tfSdt.setBounds(880, 105, 160, 30);
		tfSdt.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLTTCN.add(tfSdt);
		tfSdt.setEditable(false);
		tfSdt.setColumns(10);
		
		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setBackground(SystemColor.activeCaption);
		pnMatKhau.setBounds(0, 303, 1065, 257);
		pnTongQuanQLChaoMung.add(pnMatKhau);
		pnMatKhau.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("DOI MAT KHAU");
		lblNewLabel_7.setIcon(new ImageIcon("icon\\changpass.png"));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(10, 5, 174, 24);
		pnMatKhau.add(lblNewLabel_7);
		
		JPanel pnQLMatKhau = new JPanel();
		pnQLMatKhau.setBounds(10, 40, 1045, 206);
		pnMatKhau.add(pnQLMatKhau);
		pnQLMatKhau.setLayout(null);
		
		JLabel lblMatKhau = new JLabel("Mat khau cu:");
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMatKhau.setBounds(289, 27, 109, 14);
		pnQLMatKhau.add(lblMatKhau);
		
		JLabel lblMatKhauMoi = new JLabel("Mat khau moi:");
		lblMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMatKhauMoi.setBounds(289, 71, 123, 14);
		pnQLMatKhau.add(lblMatKhauMoi);
		
		JLabel lblNhapLaiMatKhauMoi = new JLabel("Xac nhan mat khau moi:");
		lblNhapLaiMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNhapLaiMatKhauMoi.setBounds(289, 116, 137, 14);
		pnQLMatKhau.add(lblNhapLaiMatKhauMoi);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setBounds(436, 19, 258, 31);
		pnQLMatKhau.add(tfMatKhau);
		tfMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tfMatKhau.setColumns(10);
		
		tfMatKhauMoi = new JTextField();
		tfMatKhauMoi.setBounds(436, 63, 258, 31);
		tfMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLMatKhau.add(tfMatKhauMoi);
		tfMatKhauMoi.setColumns(10);
		
		tfNhapLaiMatKhauMoi = new JTextField();
		tfNhapLaiMatKhauMoi.setBounds(436, 108, 258, 31);
		tfNhapLaiMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnQLMatKhau.add(tfNhapLaiMatKhauMoi);
		tfNhapLaiMatKhauMoi.setColumns(10);
		
		JButton btnLuu = new JButton("Luu");
		btnLuu.setIcon(new ImageIcon("icon\\save.png"));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLuu.setBounds(289, 154, 168, 41);
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QLThongTinCaNhanBLL.GetInstance().luu();
				
			}
		});
		pnQLMatKhau.add(btnLuu);
		
		JButton btnHuy = new JButton("Huy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(576, 154, 168, 41);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearField();
			}
		});
		pnQLMatKhau.add(btnHuy);
		
		JButton btnDangXuat = new JButton("Dang Xuat");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI.getInstance().getFrmTrangChu().setVisible(false);
				QLDangNhapGUI.getInstance().getFrame().setVisible(true);
			}
		});
		btnDangXuat.setIcon(new ImageIcon("icon\\logout.png"));
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDangXuat.setBounds(867, 156, 168, 41);
		pnQLMatKhau.add(btnDangXuat);
		
		lblMessage = new JLabel();
		lblMessage.setFont(new Font("Times New Romen", Font.PLAIN, 13));
		lblMessage.setForeground(Color.red);
		lblMessage.setBounds(723, 19, 312, 31);
		pnQLMatKhau.add(lblMessage);
	}
}
