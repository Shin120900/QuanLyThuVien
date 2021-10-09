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
		dsctMuon = ChiTietMuonDAL.getInstance(maPhieuMuon).getResources();
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
		dsctMuon = ChiTietMuonDAL.getInstance(maPhieuMuon).getResources();
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

	
//	private void checkData(MuonTraDTO mt) throws MyNullException, MyException{
//		if (mt.getMaDocGia().equals(""))
//			throw new MyNullException("MÃ£ Ä‘á»™c giáº£ Ä‘ang bá»‹ trá»‘ng");
//		if(mt.getMaSach().equals(""))
//			throw new MyNullException("MÃ£ Ä‘á»™c giáº£ Ä‘ang bá»‹ trá»‘ng");
//		if(!SachDAL.getInstance().isTrong(mt.getMaSach()))
//			throw new MyException("SÃ¡ch nÃ y Ä‘ang Ä‘Æ°á»£c mÆ°á»£n");
//		try {
//			Date nm;
//			Date nt;
//			
//				 nm = mt.getNgayMuon();
//				 nt = mt.getNgayTra();
//				
//			SachDTO s = SachDAL.getInstance().getSach(mt.getMaSach());	
//			
//			if(nm.compareTo(nt) > 0) {
//				throw new MyException("NgÃ y mÆ°á»£n pháº£i bÃ© hÆ¡n ngÃ y tráº£");
//			}
//			
//			Date nn = (Date) s.getNgayNhap();
//			
//			if(nm.compareTo(nn) < 0) {
//				throw new MyException("NgÃ y mÆ°á»£n Ä‘ang bÃ© hÆ¡n ngÃ y nháº­p sÃ¡ch vÃ o");
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			throw new MyException("NgÃ y thÃ¡ng bá»‹ lá»—i hoáº·c sÃ¡ch khÃ´ng tá»“n táº¡i");
//		}
//		
//	}
	
	public String addProcessing(String maPhieuMuon,String maQuyenSach) {
		try {
//			checkData(mt);
			String msg;
			int result = ChiTietMuonDAL.getInstance(maPhieuMuon).addProcessing(maPhieuMuon,maQuyenSach);
			if (result> 0)
				msg= "Them thanh cong";
			else
				msg= "Them that bai";
			return msg;
//		}catch(MyNullException e1) {
//			return e1.getMessage();
//		}catch(MyException e2) {
//			return e2.getMessage();
//		}
		}catch (Exception e) {
		return e.toString();
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
			int result = ChiTietMuonDAL.getInstance(maPhieuMuon).traSach(maPhieuMuon, maQuyenSach);
			if (result > 0)
				return "Tra thanh cong";
			else
				return "Tra khong thanh cong";
		}catch(Exception e1) {
			return e1.getMessage();
		}	
	}


//	public TableModel timKiem(String key) {
//		DefaultTableModel dtm = new DefaultTableModel();
//		ArrayList<MuonTraDTO> dsMuonTra = new ArrayList<MuonTraDTO>();
//		dsMuonTra = MuonTraDAL.getInstance().reloadResources();
//		dtm.addColumn("STT");
//		dtm.addColumn("MÃ£ Ä‘á»™c giáº£");
//		dtm.addColumn("Há»� vÃ  tÃªn");
//		dtm.addColumn("MÃ£ sÃ¡ch");
//		dtm.addColumn("TÃªn sÃ¡ch");
//		dtm.addColumn("NgÃ y mÆ°á»£n");
//		dtm.addColumn("NgÃ y tráº£");
//		dtm.addColumn("Tráº£ sÃ¡ch");
//		int i = 0;
//		System.out.println(key);
//		for(MuonTraDTO mt : dsMuonTra) {
//			if (mt.getTrangThai().equals("-1"))//Ä‘Ã£ tráº£
//				continue;
//			String thongTin = SachDAL.getInstance().getThongTin(mt.getMaSach())+ DocGiaDAL.getInstance().thongTin(mt.getMaDocGia());
//			thongTin = thongTin.toLowerCase();
//			key = key.toLowerCase();
//			if(thongTin.contains(key)) {
//				Object[] row = {i++, mt.getMaDocGia(), 
//						DocGiaDAL.getInstance().getTenDocGia(mt.getMaDocGia()), 
//						mt.getMaSach(),
//						SachDAL.getInstance().getTenSach(mt.getMaSach()),
//						mt.getNgayMuon(),
//						mt.getNgayTra(),
//						//mt.getTrangThai(),
//						"Tráº£"};
//				dtm.addRow(row);
//			}
//		}
//		return dtm;
//	}
}
