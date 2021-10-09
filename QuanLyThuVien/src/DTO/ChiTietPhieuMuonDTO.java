package DTO;

public class ChiTietPhieuMuonDTO {
	private String maPhieuMuon;
	private String maQuyenSach;
	private String tenSach;
	private String trangThai;
	public ChiTietPhieuMuonDTO(String maPhieuMuon, String maQuyenSach, String tenSach, String trangThai) {
		super();
		this.maPhieuMuon = maPhieuMuon;
		this.maQuyenSach = maQuyenSach;
		this.tenSach = tenSach;
		this.trangThai = trangThai;
	}
	
	
	public ChiTietPhieuMuonDTO(String maQuyenSach, String tenSach, String trangThai) {
		super();
		this.maQuyenSach = maQuyenSach;
		this.tenSach = tenSach;
		this.trangThai = trangThai;
	}


	public String getMaPhieuMuon() {
		return maPhieuMuon;
	}
	public void setMaPhieuMuon(String maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}
	public String getMaQuyenSach() {
		return maQuyenSach;
	}
	public void setMaQuyenSach(String maQuyenSach) {
		this.maQuyenSach = maQuyenSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
}
