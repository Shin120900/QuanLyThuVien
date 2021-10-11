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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DTO.BienBanXuLyDTO;

import javax.swing.ScrollPaneConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class QLPhatTienGUI {
	private JTable tbQLViPham;
	private JPanel pnTongQuanQLViPham;

	static QLPhatTienGUI instance = null;
	private JTextField tfMaPhieuMuon;
	private JTextField tfMaQuyenSach;
	private JTextField tfXuLy;
	JTextArea taLyDo;

	private boolean isEdit = true;

	private QLPhatTienGUI() {
		initialize();
		loadResources();
	}

	private void loadResources() {
//		tbQLViPham.setModel(QLPhatTienBLL.getInstance().getResources());
	}

	public static QLPhatTienGUI getInstance() {
		if (instance == null)
			instance = new QLPhatTienGUI();
		return instance;
	}

	public JPanel getPnTongQuanQLPhatTien() {
		return pnTongQuanQLViPham;
	}

	private void setStateForTextfeild() {
	}

	private void reloadResources() {
//		DefaultTableModel dm = (DefaultTableModel) tbQLViPham.getModel();
//		dm.getDataVector().removeAllElements();
//		dm.fireTableDataChanged();
//		tbQLViPham.setModel(QLPhatTienBLL.getInstance().reloadResources());
	}

	private void clearField() {
		tfMaPhieuMuon.setText("");
		tfMaQuyenSach.setText("");
		tfXuLy.setText("");
		taLyDo.setText("");
	}

	private void initialize() {

		pnTongQuanQLViPham = new JPanel();
		pnTongQuanQLViPham.setBackground(SystemColor.activeCaption);
		pnTongQuanQLViPham.setBounds(0, 0, 1065, 560);
		pnTongQuanQLViPham.setLayout(null);

		JPanel pnTieuDeQLViPham = new JPanel();
		pnTieuDeQLViPham.setBackground(SystemColor.activeCaption);
		pnTieuDeQLViPham.setBounds(0, 0, 1065, 62);
		pnTongQuanQLViPham.add(pnTieuDeQLViPham);
		pnTieuDeQLViPham.setLayout(null);

		JLabel lblQLViPham = new JLabel("QUAN LY VI PHAM");
		lblQLViPham.setForeground(Color.RED);
		lblQLViPham.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLViPham.setBounds(434, 13, 221, 33);
		pnTieuDeQLViPham.add(lblQLViPham);

		JPanel pnQLViPham = new JPanel();
		pnQLViPham.setBounds(0, 67, 1065, 237);
		pnTongQuanQLViPham.add(pnQLViPham);
		pnQLViPham.setLayout(null);

		tbQLViPham = new JTable();
		tbQLViPham.setBounds(0, 0, 1050, 170);
		JScrollPane sc = new JScrollPane(tbQLViPham, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1055, 237);
		tbQLViPham.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if (tbQLViPham.getSelectedRow() < 0)
					return;
				isEdit = false;
				setStateForTextfeild();
				tfMaPhieuMuon.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 2).toString());
				tfMaQuyenSach.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 3).toString());
				tfXuLy.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 4).toString());
				taLyDo.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 5).toString());
			}
		});
		pnQLViPham.add(sc, BorderLayout.CENTER);

		JPanel pnThongTinDocGia = new JPanel();
		pnThongTinDocGia.setBackground(SystemColor.activeCaption);
		pnThongTinDocGia.setBounds(0, 304, 1065, 256);
		pnTongQuanQLViPham.add(pnThongTinDocGia);
		pnThongTinDocGia.setLayout(null);

		JLabel lblThongTinDocGia = new JLabel("THEM BIEN BAN XU LY");
		lblThongTinDocGia.setBounds(10, 5, 220, 22);
		lblThongTinDocGia.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pnThongTinDocGia.add(lblThongTinDocGia);

		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBounds(10, 34, 862, 208);
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinDocGia.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);

		JLabel lblMaPhieuMuon = new JLabel("Ma phieu muon:*");
		lblMaPhieuMuon.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMaPhieuMuon.setBounds(30, 52, 100, 30);
		pnThongTinNhap.add(lblMaPhieuMuon);

		tfMaPhieuMuon = new JTextField();
		tfMaPhieuMuon.setBounds(132, 52, 263, 31);
		tfMaPhieuMuon.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnThongTinNhap.add(tfMaPhieuMuon);
		tfMaPhieuMuon.setColumns(10);
		
		JLabel lblMaQuyenSach = new JLabel("Ma quyen sach:*");
		lblMaQuyenSach.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMaQuyenSach.setBounds(30, 109, 100, 30);
		pnThongTinNhap.add(lblMaQuyenSach);
		
		tfMaQuyenSach = new JTextField();
		tfMaQuyenSach.setBounds(132, 109, 263, 31);
		tfMaQuyenSach.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnThongTinNhap.add(tfMaQuyenSach);
		tfMaQuyenSach.setColumns(10);
		
		JLabel lblXuLy = new JLabel("Xu ly:*");
		lblXuLy.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblXuLy.setBounds(30, 167, 72, 30);
		pnThongTinNhap.add(lblXuLy);
		
		tfXuLy= new JTextField();
		tfXuLy.setBounds(132, 166, 263, 31);
		tfXuLy.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnThongTinNhap.add(tfXuLy);
		tfXuLy.setColumns(10);

//		JLabel lblNgayPhat = new JLabel("Ngay phat:*");
//		lblNgayPhat.setFont(new Font("Times New Roman", Font.BOLD, 13));
//		lblNgayPhat.setBounds(30, 167, 72, 30);
//		pnThongTinNhap.add(lblNgayPhat);
//		
//		dcNgayPhat = new JDateChooser();
//		dcNgayPhat.setBounds(112, 166, 263, 31);
//		dcNgayPhat.setDateFormatString("yyyy-MM-dd");
//		dcNgayPhat.setFont(new Font("Times New Roman", Font.BOLD, 13));
//		pnThongTinNhap.add(dcNgayPhat);

		JLabel lblLyDo = new JLabel("Loi vi pham:");
		lblLyDo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLyDo.setBounds(441, 52, 69, 30);
		pnThongTinNhap.add(lblLyDo);

		JLabel lblMessage = new JLabel("(*)Khong duoc de trong");
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(112, 11, 683, 30);
		pnThongTinNhap.add(lblMessage);

		taLyDo = new JTextArea();
		taLyDo.setBackground(SystemColor.controlHighlight);
		taLyDo.setBounds(520, 53, 308, 142);
		taLyDo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		taLyDo.setLineWrap(true);
		pnThongTinNhap.add(taLyDo);

		JButton btnThem = new JButton("Them");
		btnThem.setBounds(897, 93, 138, 41);
		pnThongTinDocGia.add(btnThem);
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					

					String maLanPhat;
					if (tbQLViPham.getRowCount() == 0)
						maLanPhat = "P0";
					else {
						maLanPhat = "P" + (1 + Integer.parseInt(
								tbQLViPham.getValueAt(tbQLViPham.getRowCount() - 1, 1).toString().substring(1)));
					}
					/*BienBanXuLyDTO pt = new BienBanXuLyDTO(maLanPhat, tfSoTien.getText(), tfMaDocGia.getText(),
							Date.valueOf(ngayPhat), taLyDo.getText());
					String result = QLPhatTienBLL.getInstance().addProcessing(pt);
					lblMessage.setText(result);*/
					reloadResources();
				} catch (Exception ex) {
					lblMessage.setText("Ngày phạt phải đúng định dạng ngày");
				}

			}
		});

		JButton btnHuy = new JButton("Huy");
		btnHuy.setBounds(897, 148, 138, 41);
		pnThongTinDocGia.add(btnHuy);
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearField();
				isEdit = true;
				setStateForTextfeild();

			}
		});

//		JButton btnXoa = new JButton("Xoa");
//		btnXoa.setBounds(897, 201, 138, 41);
//		pnThongTinDocGia.add(btnXoa);
//		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
//		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		btnXoa.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String msg = QLPhatTienBLL.getInstance()
//						.deleteProcessing(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 1).toString());
//				lblMessage.setText(msg);
//				reloadResources();
//				clearField();
//			}
//		});

//		JButton btnSua = new JButton("Sua");
//		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
//		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		btnSua.setBounds(897, 93, 138, 41);
//		btnSua.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		pnThongTinDocGia.add(btnSua);
	}
}
