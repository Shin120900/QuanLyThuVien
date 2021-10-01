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
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mật khẩu đang bị trống");
			return;
		}
		if (QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mật khẩu mới đang bị trống");
			return;
		}
		if (QLThongTinCaNhanGUI.getInstance().tfNhapLaiMatKhauMoi.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Nhập lại mật khẩu mới đang bị trống");
			return;
		}
		if(!QLThongTinCaNhanGUI.getInstance().tfNhapLaiMatKhauMoi.getText().equals(QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText())) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Nhập lại mật khẩu khác với Mật khẩu mới");
			return;
		}
		if (!QLThongTinCaNhanGUI.getInstance().tfMatKhau.getText().equals(nv.getMatKhau())) {
			System.out.println(nv.getMatKhau());
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mật khẩu sai");
			return;
		}
		nv.setMatKhau(QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText());
		int result = NhanVienDAL.getInstance().changeProcessing(nv);
		if (result > 0) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Đổi mật khẩu thành công");
			QLThongTinCaNhanGUI.getInstance().huyPro();
		}
		else
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Đổi mật khẩu thất bại");
	}
	
	public void LoadResources() {
		System.out.println(nv.getMaTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfMaNhanVien.setText(nv.getMaTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfChucVu.setText(nv.getLoaiTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfTenNhanVien.setText(nv.getTenNhanVien());
	}
	
	
}
