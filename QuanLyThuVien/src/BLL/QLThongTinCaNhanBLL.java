package BLL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mat khau dang trong");
			return;
		}
		if (QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mat khau moi dang trong");
			return;
		}
		if (QLThongTinCaNhanGUI.getInstance().tfNhapLaiMatKhauMoi.getText().equals("")) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Nhap lai mat khau moi dang trong");
			return;
		}
		if(!QLThongTinCaNhanGUI.getInstance().tfNhapLaiMatKhauMoi.getText().equals(QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText())) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Nhap lai mat khau moi khac mat khau moi");
			return;
		}
		if (!QLThongTinCaNhanGUI.getInstance().tfMatKhau.getText().equals(nv.getMatKhau())) {
			System.out.println(nv.getMatKhau());
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Mat khau sai");
			return;
		}
		nv.setMatKhau(QLThongTinCaNhanGUI.getInstance().tfMatKhauMoi.getText());
		int result = NhanVienDAL.getInstance().changeProcessing(nv);
		if (result > 0) {
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Doi mat khau thanh cong");
			QLThongTinCaNhanGUI.getInstance().clearField();
		}
		else
			QLThongTinCaNhanGUI.getInstance().lblMessage.setText("Doi mat khau that bai");
	}
	
	public void LoadResources() {
		QLThongTinCaNhanGUI.getInstance().tfMaNhanVien.setText(nv.getTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfTenNhanVien.setText(nv.getHoTen());
		QLThongTinCaNhanGUI.getInstance().tfChucVu.setText(nv.getLoaiTaiKhoan());
		QLThongTinCaNhanGUI.getInstance().tfGioiTinh.setText(nv.getGioiTinh());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String ngaySinh = sdf.format(nv.getNgaySinh());
		QLThongTinCaNhanGUI.getInstance().tfNgaySinh.setText(ngaySinh);
		QLThongTinCaNhanGUI.getInstance().tfDiaChi.setText(nv.getDiaChi());
		QLThongTinCaNhanGUI.getInstance().tfSdt.setText(nv.getSdt());
		
	}
	
	
}
