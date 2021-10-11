package BLL;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.ChiTietMuonDAL;
import DAL.DocGiaDAL;
import DAL.SachDAL;
import DTO.ChiTietPhieuMuonDTO;
import MyException.ContainException;
import MyException.MyException;
import MyException.MyNullException;

public class ChiTietMuonBLL {
	public static ChiTietMuonBLL instance;
	public ChiTietPhieuMuonDTO ctMuon;// SÃ¡ch Ä‘ang thao tÃ¡c Ä‘á»ƒ thay Ä‘á»•i thÃ´ng tin
	private ChiTietMuonBLL(){
	}
	
	public static ChiTietMuonBLL getInstance() {
		if (instance == null)
			instance = new ChiTietMuonBLL();
		return instance;
	}

	public DefaultTableModel getResources(String maPhieuMuon) {
		ArrayList<ChiTietPhieuMuonDTO> dsctMuon = new ArrayList<ChiTietPhieuMuonDTO>();
		dsctMuon = ChiTietMuonDAL.getInstance().getResources(maPhieuMuon);
		DefaultTableModel dtm = new DefaultTableModel();
		try {			dtm.addColumn("Ma phieu muon");
			dtm.addColumn("Ma quyen sach");
			dtm.addColumn("Ten Sach");
			dtm.addColumn("Trang thai");
			for(ChiTietPhieuMuonDTO ctMuon : dsctMuon) {
				Object[] row = {
						ctMuon.getMaQuyenSach(),
						ctMuon.getTenSach(),
						ctMuon.getTrangThai(),
						"Trả"};
				dtm.addRow(row);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	}
	
	public DefaultTableModel reloadResources(String maPhieuMuon) {
		ArrayList<ChiTietPhieuMuonDTO> dsctMuon = new ArrayList<ChiTietPhieuMuonDTO>();
		dsctMuon = ChiTietMuonDAL.getInstance().reloadResources(maPhieuMuon);
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma quyen sach");
			dtm.addColumn("Ten Sach");
			dtm.addColumn("Trang thai");
			for(ChiTietPhieuMuonDTO ctMuon : dsctMuon) {
				Object[] row = {
						ctMuon.getMaQuyenSach(),
						ctMuon.getTenSach(),
						ctMuon.getTrangThai(),
						"Trả"};
				dtm.addRow(row);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	}
	
	public DefaultTableModel loadResources(String maPhieuMuon) {
		ArrayList<ChiTietPhieuMuonDTO> dsctMuon = new ArrayList<ChiTietPhieuMuonDTO>();
		dsctMuon = ChiTietMuonDAL.getInstance().getResources(maPhieuMuon);
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma phieu muon");
			dtm.addColumn("Ma quyen sach");
			dtm.addColumn("Ten Sach");
			dtm.addColumn("Trang thai");
			for(ChiTietPhieuMuonDTO ctMuon : dsctMuon) {
				Object[] row = {ctMuon.getMaPhieuMuon(),
						ctMuon.getMaQuyenSach(),
						ctMuon.getTenSach(),
						ctMuon.getTrangThai()};
				dtm.addRow(row);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	}

	
	public int deleteProcessing(String maPhieuMuon,String maQuyenSach) {
		try {

			int result = ChiTietMuonDAL.getInstance().deleteProcessing(maPhieuMuon, maQuyenSach);
			return result;
		}catch (Exception e) {
			return -1;
		}
	}
	
	public int addProcessing(String maPhieuMuon,String maQuyenSach) {
		try {

			int result = ChiTietMuonDAL.getInstance().addProcessing(maPhieuMuon,maQuyenSach);
			return result;

		}catch (Exception e) {
		return -1;
		}
	}

//		public String changeProcessing(MuonTraDTO mt) {
//		try {
//			String msg;
//			checkData(mt);
//			if(!mt.getMaDocGia().equals(mt.getMaDocGia())) {
//				msg= "MÃ£ Ä‘á»™c giáº£ khÃ´ng Ä‘Æ°á»£c thay Ä‘á»•i";
//				
//			}
//			if(!mt.getMaSach().equalsIgnoreCase(mt.getMaSach())) {
//				msg= "MÃ£ sÃ¡ch khÃ´ng Ä‘Æ°á»£c thay Ä‘á»•i";
//			}
//			int result = MuonTraDAL.getInstance().changeProcessing(mt);
//			if(result>0)
//				msg= "Thay Ä‘á»•i thÃ nh cÃ´ng";
//			else
//				msg= "Thay Ä‘á»•i khÃ´ng thÃ nh cÃ´ng";
//			return msg;
//		}catch(MyNullException e1) {
//			return e1.getMessage();
//		}catch(MyException e2) {
//			return e2.getMessage();
//		}
//	}

	public String traSach(String maPhieuMuon, String maQuyenSach) {
		try{
			int result = ChiTietMuonDAL.getInstance().traSach(maPhieuMuon, maQuyenSach);
			if (result > 0)
				return "Tra thanh cong";
			else
				return "Tra khong thanh cong";
		}catch(Exception e1) {
			return e1.getMessage();
		}	
	}



}
