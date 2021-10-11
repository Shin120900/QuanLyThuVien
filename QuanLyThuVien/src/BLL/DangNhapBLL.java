package BLL;

import java.sql.Date;
import java.util.ArrayList;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import GUI.QuanTriHeThongGUI;
import GUI.TrangChuGUI;
import MyException.MyNullException;

public class DangNhapBLL {
	static DangNhapBLL instance;
	
	private DangNhapBLL(){
		
	}
	
	public static DangNhapBLL getInstance() {
		if (instance == null) {
			instance = new DangNhapBLL();
		}
		return instance;
	}
	
	private void checkData(String taiKhoan, String matKhau) throws MyNullException{
		try {
			if (taiKhoan.equals(""))
				throw new MyNullException();
			if (matKhau.equals(""))
				throw new MyNullException();
		}catch(NullPointerException e) {
			throw new MyNullException();
		}
	}
	
	public boolean dangNhap(String taiKhoan, String matKhau) {
		try {
			ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
			//dsNhanVien = NhanVienDAL.getInstance().getResources();
			NhanVienDTO nv2 = new NhanVienDTO("1", "Tuan", "Nam", Date.valueOf("2000-9-12"), "01234", "diaChi", "1", "1", "Thủ thư");
			dsNhanVien.add(nv2);
			checkData(taiKhoan, matKhau);
			
			for (NhanVienDTO nv: dsNhanVien) {
				if (nv.getTaiKhoan().equals(taiKhoan) && nv.getMatKhau().equals(matKhau)) {
					if(nv.getLoaiTaiKhoan().equals("Thủ thư")) {
						QLThongTinCaNhanBLL.GetInstance().setNhanVien(nv);
						TrangChuGUI trangchu=TrangChuGUI.getInstance();
						trangchu.getFrmTrangChu().setVisible(true);
					}
					else {
						QuanTriHeThongGUI.getInstance().getFrmMain().setVisible(true);
					}
					return true;
				}			
			}
			return false;
		}catch(MyNullException e) {
			return false;
		}
	}
}
