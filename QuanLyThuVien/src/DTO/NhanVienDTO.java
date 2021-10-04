package DTO;

import java.sql.Date;

public class NhanVienDTO {

private String manv;
private String hoTen;
private String gioiTinh;
private Date ngaySinh;
private String sdt;
private String diaChi;
private String taiKhoan;
private String matKhau;
private String loaiTaiKhoan;



public NhanVienDTO(String hoTen, String gioiTinh, Date ngaySinh, String sdt, String diaChi, String taiKhoan,
		String matKhau, String loaiTaiKhoan) {
	super();
	this.hoTen = hoTen;
	this.gioiTinh = gioiTinh;
	this.ngaySinh = ngaySinh;
	this.sdt = sdt;
	this.diaChi = diaChi;
	this.taiKhoan = taiKhoan;
	this.matKhau = matKhau;
	this.loaiTaiKhoan = loaiTaiKhoan;
}
public NhanVienDTO(String manv, String hoTen, String gioiTinh, Date ngaySinh, String sdt, String diaChi,
		String taiKhoan, String matKhau, String loaiTaiKhoan) {
	super();
	this.manv = manv;
	this.hoTen = hoTen;
	this.gioiTinh = gioiTinh;
	this.ngaySinh = ngaySinh;
	this.sdt = sdt;
	this.diaChi = diaChi;
	this.taiKhoan = taiKhoan;
	this.matKhau = matKhau;
	this.loaiTaiKhoan = loaiTaiKhoan;
}
public String getManv() {
	return manv;
}
public void setManv(String manv) {
	this.manv = manv;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(String gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public Date getNgaySinh() {
	return ngaySinh;
}
public void setNgaySinh(Date ngaySinh) {
	this.ngaySinh = ngaySinh;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getTaiKhoan() {
	return taiKhoan;
}
public void setTaiKhoan(String taiKhoan) {
	this.taiKhoan = taiKhoan;
}
public String getMatKhau() {
	return matKhau;
}
public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
}
public String getLoaiTaiKhoan() {
	return loaiTaiKhoan;
}
public void setLoaiTaiKhoan(String loaiTaiKhoan) {
	this.loaiTaiKhoan = loaiTaiKhoan;
}


}
