package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import GUI.QLThongTinCaNhanGUI;

public class QLThongTinCaNhanBLL {
	private static QLThongTinCaNhanBLL instance;
	NhanVienDTO nv;
	
	private QLThongTinCaNhanBLL() {
	
	}
	
	public static QLThongTinCaNhanBLL GetInstance() {
		if (instance == null) {
			instance = new QLThongTinCaNhanBLL();
		}
		return instance;
	}
	
	public void setNhanVien(NhanVienDTO nv) {
		this.nv = nv;
	}

	public void luu() {
		if (QLThongTinCaNhanGUI.getInstance().tfMatKhau.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Máº­t kháº©u Ä‘ang bá»‹ trá»‘ng");
			return;
		}
		if (QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Máº­t kháº©u má»›i Ä‘ang bá»‹ trá»‘ng");
			return;
		}
		if (QLThongTinCaNhanGUI.getInstance().tfNhapLaiMatKhauMoi.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Nháº­p láº¡i máº­t kháº©u má»›i Ä‘ang bá»‹ trá»‘ng");
			return;
		}
		if(!QLThongTinCaNhanGUI.getInstance().tfNhapLaiMatKhauMoi.getText().equals(QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText())) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Nháº­p láº¡i máº­t kháº©u khÃ¡c vá»›i Máº­t kháº©u má»›i");
			return;
		}
		if (!QLThongTinCaNhanGUI.getInstance().tfMatKhau.getText().equals(nv.getMatKhau())) {
			System.out.println(nv.getMatKhau());
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Máº­t kháº©u sai");
			return;
		}
		nv.setMatKhau(QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText());
		int result = NhanVienDAL.getInstance().changeProcessing(nv);
		if (result > 0) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Ä�á»•i máº­t kháº©u thÃ nh cÃ´ng");
			QLThongTinCaNhanGUI.getInstance().huyPro();
		}
		else
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Ä�á»•i máº­t kháº©u tháº¥t báº¡i");
	}
	
	public void LoadResources() {
		System.out.println(nv.getTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfMaNhanVien.setText(nv.getTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfChucVu.setText(nv.getLoaiTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfTenNhanVien.setText(nv.getHoTen());
	}
	
	
}
