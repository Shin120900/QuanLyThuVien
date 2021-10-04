package DTO;

import java.sql.Date;

public class DocGiaDTO {
	
	private int maDocGia;
	private String tenDocGia;
	private String gioiTinh;
	private String lop;
	private String khoa;
	private String diaChi;
	private Date ngaySinh;
	
	
	public DocGiaDTO() {
		super();
	}


	public DocGiaDTO(String tenDocGia, String gioiTinh, String lop, String khoa, String diaChi, Date ngaySinh) {
		super();
		this.tenDocGia = tenDocGia;
		this.gioiTinh = gioiTinh;
		this.lop = lop;
		this.khoa = khoa;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
	}


	public DocGiaDTO(int maDocGia, String tenDocGia, String gioiTinh, String lop, String khoa, String diaChi,
			Date ngaySinh) {
		super();
		this.maDocGia = maDocGia;
		this.tenDocGia = tenDocGia;
		this.gioiTinh = gioiTinh;
		this.lop = lop;
		this.khoa = khoa;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
	}


	public int getMaDocGia() {
		return maDocGia;
	}


	public void setMaDocGia(int maDocGia) {
		this.maDocGia = maDocGia;
	}


	public String getTenDocGia() {
		return tenDocGia;
	}


	public void setTenDocGia(String tenDocGia) {
		this.tenDocGia = tenDocGia;
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
