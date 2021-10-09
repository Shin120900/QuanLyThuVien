package DTO;

public class QuyenSachDTO {
	private String maQuyenSach;
	private String maDauSach;
	public QuyenSachDTO(String maQuyenSach, String maDauSach) {
		super();
		this.maQuyenSach = maQuyenSach;
		this.maDauSach = maDauSach;
	}
	public String getMaQuyenSach() {
		return maQuyenSach;
	}
	public void setMaQuyenSach(String maQuyenSach) {
		this.maQuyenSach = maQuyenSach;
	}
	public String getMaDauSach() {
		return maDauSach;
	}
	public void setMaDauSach(String maDauSach) {
		this.maDauSach = maDauSach;
	}
	
}
