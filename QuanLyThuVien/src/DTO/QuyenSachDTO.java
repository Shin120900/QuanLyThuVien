package DTO;

public class QuyenSachDTO {
	private int maQuyenSach;
	private int maDauSach;
	public QuyenSachDTO(int maQuyenSach, int maDauSach) {
		super();
		this.maQuyenSach = maQuyenSach;
		this.maDauSach = maDauSach;
	}
	public int getMaQuyenSach() {
		return maQuyenSach;
	}
	public void setMaQuyenSach(int maQuyenSach) {
		this.maQuyenSach = maQuyenSach;
	}
	public int getMaDauSach() {
		return maDauSach;
	}
	public void setMaDauSach(int maDauSach) {
		this.maDauSach = maDauSach;
	}
	
}
