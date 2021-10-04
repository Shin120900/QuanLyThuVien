package DTO;

import java.sql.Date;

public class DocGiaDTO {
	
	private String maDocGia;
	private String tenDocGia;
	private String lopMon;
	private Date ngaySinh;
	private String sdt;
	private String email;
	
	public DocGiaDTO() {
		super();
	}
	public DocGiaDTO(String maDocGia, String tenDocGia, String lopMon, Date ngaySinh, String sdt, String email) {
		super();
		this.maDocGia = maDocGia;
		this.tenDocGia = tenDocGia;
		this.lopMon = lopMon;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.email = email;
	}
	
	public String getMaDocGia() {
		return maDocGia;
	}
	public void setMaDocGia(String maDocGia) {
		this.maDocGia = maDocGia;
	}
	public String getTenDocGia() {
		return tenDocGia;
	}
	public void setTenDocGia(String tenDocGia) {
		this.tenDocGia = tenDocGia;
	}

	public String getLopMon() {
		return lopMon;
	}
	public void setLopMon(String lopMon) {
		this.lopMon = lopMon;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return tenDocGia;
	}
}
