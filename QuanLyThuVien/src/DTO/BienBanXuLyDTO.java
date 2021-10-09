package DTO;

import java.sql.Date;

public class BienBanXuLyDTO {
	private String maBienBan;
	private String maPhieuMuon;
	private String maQuyenSach;
	private String tenNV;
	private String tenSV;
	private Date ngayLap;
	private String loiViPham;
	private String xuLy;
	public BienBanXuLyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BienBanXuLyDTO(String maPhieuMuon,String maQuyenSach, String tenNV, String tenSV, Date ngayLap, String loiViPham, String xuLy) {
		super();
		this.maPhieuMuon = maPhieuMuon;
		this.maQuyenSach=maQuyenSach;
		this.tenNV = tenNV;
		this.tenSV = tenSV;
		this.ngayLap = ngayLap;
		this.loiViPham = loiViPham;
		this.xuLy = xuLy;
	}
	public BienBanXuLyDTO(String maBienBan, String maPhieuMuon,String maQuyenSach, String tenNV, String tenSV, Date ngayLap, String loiViPham,
			String xuLy) {
		super();
		this.maBienBan = maBienBan;
		this.maPhieuMuon = maPhieuMuon;
		this.maQuyenSach=maQuyenSach;
		this.tenNV = tenNV;
		this.tenSV = tenSV;
		this.ngayLap = ngayLap;
		this.loiViPham = loiViPham;
		this.xuLy = xuLy;
	}
	public String getMaQuyenSach() {
		return maQuyenSach;
	}
	public void setMaQuyenSach(String maQuyenSach) {
		this.maQuyenSach = maQuyenSach;
	}
	public String getMaBienBan() {
		return maBienBan;
	}
	public void setMaBienBan(String maBienBan) {
		this.maBienBan = maBienBan;
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
