package BLL;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAL.BienBanDAL;
import DAL.ChiTietMuonDAL;
import DAL.DocGiaDAL;
import DTO.BienBanXuLyDTO;
import DTO.ChiTietPhieuMuonDTO;
import MyException.ContainException;
import MyException.MyException;
import MyException.MyNullException;

public class BienBanBLL {
	public static BienBanBLL instance;

	private BienBanBLL() {

	}

	public static BienBanBLL getInstance() {
		if (instance == null)
			instance = new BienBanBLL();
		return instance;
	}

	private boolean checkData(String maPhieuMuon,String maQuyenSach, String loivipham,String xuly) throws MyNullException, MyException {
		boolean isCheck = false;
		ArrayList<ChiTietPhieuMuonDTO> dsChiTietPM = new ArrayList<ChiTietPhieuMuonDTO>();
		dsChiTietPM = ChiTietMuonDAL.getInstance().getResources(maPhieuMuon);
		for (ChiTietPhieuMuonDTO chiTietPhieuMuonDTO : dsChiTietPM) {
			if(chiTietPhieuMuonDTO.getMaQuyenSach().equals(maQuyenSach)) isCheck = true;
		}
		if(isCheck) throw new MyNullException("Ma phieu muon va ma quyen sach khong trung khop");
		if (maPhieuMuon.equals("")) {
			throw new MyNullException("Ma phieu muon dang bi de trong");
		}
		if (maQuyenSach.equals("")) {
			throw new MyNullException("Ma quyen sach dang bi de trong");
		}
		if (loivipham.equals("")) {
			throw new MyNullException("Loi vi pham dang bi de trong");
		}
		if (xuly.equals("")) {
			throw new MyNullException("Xu ly dang bi de trong");
		}

		return true;
	}

	public String addProcessing(String maPhieuMuon,String maQuyenSach,String manv,String loivipham,String xuly) {
		try {
			checkData(maPhieuMuon, maQuyenSach, loivipham, xuly);
			String msg;
			int result = BienBanDAL.getInstance().addProcessing(maPhieuMuon,maQuyenSach,manv,loivipham,xuly);
			switch (result) {
			case -1:
			case 0:
				msg = "Them khong thanh cong";
				break;
			default:
				msg = "Them thanh cong";
			}
			return msg;
		} catch (MyNullException ex1) {
			System.out.println(ex1);
			return ex1.getMessage();
		} catch (MyException ex2) {
			return ex2.getMessage();
		} 
		
	}

	



	public DefaultTableModel getResources() {
		ArrayList<BienBanXuLyDTO> dsBienBan = new ArrayList<BienBanXuLyDTO>();
		dsBienBan = BienBanDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma bien ban");
			dtm.addColumn("Ma phieu muon");
			dtm.addColumn("Ma quyen sach");
			dtm.addColumn("Ten nhan vien");
			dtm.addColumn("Ten sinh vien");
			dtm.addColumn("Ngay lap");
			dtm.addColumn("Loi vi pham");
			dtm.addColumn("Xu ly");
			for (BienBanXuLyDTO bb : dsBienBan) {
				Object[] row = { bb.getMaBienBan(),bb.getMaPhieuMuon(),bb.getMaQuyenSach(),bb.getTenNV(),bb.getTenSV(),bb.getNgayLap(),bb.getLoiViPham(),bb.getXuLy()};
				dtm.addRow(row);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return dtm;
	}
	
	public DefaultTableModel reloadResources() {
		ArrayList<BienBanXuLyDTO> dsBienBan = new ArrayList<BienBanXuLyDTO>();
		dsBienBan = BienBanDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma bien ban");
			dtm.addColumn("Ma phieu muon");
			dtm.addColumn("Ma quyen sach");
			dtm.addColumn("Ten nhan vien");
			dtm.addColumn("Ten sinh vien");
			dtm.addColumn("Ngay lap");
			dtm.addColumn("Loi vi pham");
			dtm.addColumn("Xu ly");
			for (BienBanXuLyDTO bb : dsBienBan) {
				Object[] row = { bb.getMaBienBan(),bb.getMaPhieuMuon(),bb.getMaQuyenSach(),bb.getTenNV(),bb.getTenSV(),bb.getNgayLap(),bb.getLoiViPham(),bb.getXuLy()};
				dtm.addRow(row);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return dtm;
	}
}
