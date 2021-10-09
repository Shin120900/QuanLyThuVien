package DTO;

import java.sql.Date;

public class DocGiaDTO {
	
	private String maDocGia;
	private String hoTen;
	private String gioiTinh;
	private String lop;
	private String khoa;
	private String diaChi;
	private Date ngaySinh;
	
	
	public DocGiaDTO() {
		super();
	}


	public DocGiaDTO(String hoTen, String gioiTinh, String lop, String khoa, String diaChi, Date ngaySinh) {
		super();
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.lop = lop;
		this.khoa = khoa;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
	}


	public DocGiaDTO(String maDocGia, String hoTen, String gioiTinh, String lop, String khoa, String diaChi,
			Date ngaySinh) {
		super();
		this.maDocGia = maDocGia;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.lop = lop;
		this.khoa = khoa;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
	}


	public String getMaDocGia() {
		return maDocGia;
	}


	public void setMaDocGia(String maDocGia) {
		this.maDocGia = maDocGia;
	}


	public String getTenDocGia() {
		return hoTen;
	}


	public void setTenDocGia(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getLop() {
		return lop;
	}


	public void setLop(String lop) {
		this.lop = lop;
	}


	public String getKhoa() {
		return khoa;
	}


	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
}
