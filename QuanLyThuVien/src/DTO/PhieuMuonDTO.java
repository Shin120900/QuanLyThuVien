package DTO;

import java.sql.Date;

public class PhieuMuonDTO {
	private String maPhieuMuon;
	private String tenNV;
	private String tenSV;
	private int soLuong;
	private Date ngayMuon;
	private Date ngayHenTra;
	public PhieuMuonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuMuonDTO(String tenNV, String tenSV, int soLuong, Date ngayMuon, Date ngayHenTra) {
		super();
		this.tenNV = tenNV;
		this.tenSV = tenSV;
		this.soLuong = soLuong;
		this.ngayMuon = ngayMuon;
		this.ngayHenTra = ngayHenTra;
	}
	public PhieuMuonDTO(String maPhieuMuon, String tenNV, String tenSV, int soLuong, Date ngayMuon, Date ngayHenTra) {
		super();
		this.maPhieuMuon = maPhieuMuon;
		this.tenNV = tenNV;
		this.tenSV = tenSV;
		this.soLuong = soLuong;
		this.ngayMuon = ngayMuon;
		this.ngayHenTra = ngayHenTra;
	}
	public String getMaPhieuMuon() {
		return maPhieuMuon;
	}
	public void setMaPhieuMuon(String maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public Date getNgayHenTra() {
		return ngayHenTra;
	}
	public void setNgayHenTra(Date ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}
	
}
