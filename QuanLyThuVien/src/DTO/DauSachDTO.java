package DTO;

import java.sql.Date;

public class DauSachDTO {
	private int maDauSach;
	private String tenSach;
	private String tenTG;
	private String tenTL;
	private String tenNXB;
	private Date namXB;
	public DauSachDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DauSachDTO(String tenSach, String tenTG, String tenTL, String tenNXB, Date namXB) {
		super();
		this.tenSach = tenSach;
		this.tenTG = tenTG;
		this.tenTL = tenTL;
		this.tenNXB = tenNXB;
		this.namXB = namXB;
	}
	public DauSachDTO(int maDauSach, String tenSach, String tenTG, String tenTL, String tenNXB, Date namXB) {
		super();
		this.maDauSach = maDauSach;
		this.tenSach = tenSach;
		this.tenTG = tenTG;
		this.tenTL = tenTL;
		this.tenNXB = tenNXB;
		this.namXB = namXB;
	}
	public int getMaDauSach() {
		return maDauSach;
	}
	public void setMaDauSach(int maDauSach) {
		this.maDauSach = maDauSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public String getTenTL() {
		return tenTL;
	}
	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	public Date getNamXB() {
		return namXB;
	}
	public void setNamXB(Date namXB) {
		this.namXB = namXB;
	}
	
}
