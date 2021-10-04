package DTO;

import java.sql.Date;

public class BienBanXuLyDTO {
	private int maBienBan;
	private int maPhieuMuon;
	private String tenNV;
	private String tenSV;
	private Date ngayLap;
	private String loiViPham;
	private String xuLy;
	public BienBanXuLyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BienBanXuLyDTO(int maPhieuMuon, String tenNV, String tenSV, Date ngayLap, String loiViPham, String xuLy) {
		super();
		this.maPhieuMuon = maPhieuMuon;
		this.tenNV = tenNV;
		this.tenSV = tenSV;
		this.ngayLap = ngayLap;
		this.loiViPham = loiViPham;
		this.xuLy = xuLy;
	}
	public BienBanXuLyDTO(int maBienBan, int maPhieuMuon, String tenNV, String tenSV, Date ngayLap, String loiViPham,
			String xuLy) {
		super();
		this.maBienBan = maBienBan;
		this.maPhieuMuon = maPhieuMuon;
		this.tenNV = tenNV;
		this.tenSV = tenSV;
		this.ngayLap = ngayLap;
		this.loiViPham = loiViPham;
		this.xuLy = xuLy;
	}
	public int getMaBienBan() {
		return maBienBan;
	}
	public void setMaBienBan(int maBienBan) {
		this.maBienBan = maBienBan;
	}
	public int getMaPhieuMuon() {
		return maPhieuMuon;
	}
	public void setMaPhieuMuon(int maPhieuMuon) {
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
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getLoiViPham() {
		return loiViPham;
	}
	public void setLoiViPham(String loiViPham) {
		this.loiViPham = loiViPham;
	}
	public String getXuLy() {
		return xuLy;
	}
	public void setXuLy(String xuLy) {
		this.xuLy = xuLy;
	}
	
	
}
