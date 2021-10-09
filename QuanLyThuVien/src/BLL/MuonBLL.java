package BLL;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.DocGiaDAL;
import DAL.PhieuMuonDAL;
import DAL.SachDAL;
import DTO.PhieuMuonDTO;
import MyException.ContainException;
import MyException.MyException;
import MyException.MyNullException;

public class MuonBLL {
	public static MuonBLL instance;
	public PhieuMuonDTO muonTra;// SÃ¡ch Ä‘ang thao tÃ¡c Ä‘á»ƒ thay Ä‘á»•i thÃ´ng tin
	private MuonBLL() {
	}
	public static MuonBLL getInstance() {
		if (instance == null)
			instance = new MuonBLL();
		return instance;
	}

	
	


	public DefaultTableModel getResources() {		
		ArrayList<PhieuMuonDTO> dsPhieuMuon = new ArrayList<PhieuMuonDTO>();
		dsPhieuMuon = PhieuMuonDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma phieu muon");
			dtm.addColumn("Ten nhan vien");
			dtm.addColumn("Ten sinh vien");
			dtm.addColumn("So luong");
			dtm.addColumn("Ngay muon");
			dtm.addColumn("Ngay hen tra");
			for(PhieuMuonDTO pm : dsPhieuMuon) {
				Object[] row = { pm.getMaPhieuMuon(), 
						pm.getTenNV(), 
						pm.getTenSV(),
						pm.getSoLuong(),
						pm.getNgayMuon(),
						pm.getNgayHenTra(),
						"Xem Chi Tiết"};				
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
	
	public String addProcessing(String manv,String mssv) throws MyException, ContainException  {
		try {
//			checkData(mt);	
			String msg;
//			boolean trong = SachDAL.getInstance().isTrong(pm.getMaSach());
//			if (!trong) {
//				return "SÃ¡ch nháº­p vÃ o Ä‘ang Ä‘Æ°á»£c mÆ°á»£n! Vui lÃ²ng kiá»ƒm tra láº¡i";
//			}
			int result = PhieuMuonDAL.getInstance().addProcessing(manv,mssv);
			if (result> 0)
				msg= "Ä�Ã£ thÃªm thÃ nh cÃ´ng";
			else
				msg= "ThÃªm lá»—i! Vui lÃ²ng thá»­ láº¡i";
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

//	public String traSach(String maDocGia, String maSach) {
//		try{
//			int result = MuonTraDAL.getInstance().traSach(maDocGia, maSach);
//			if (result > 0)
//				return "Tráº£ sÃ¡ch thÃ nh cÃ´ng";
//			else
//				return "Tráº£ sÃ¡ch khÃ´ng thÃ nh cÃ´ng";
//		}catch(Exception e1) {
//			return e1.getMessage();
//		}	
//	}

//	public int SoSachMuon() {
//		// TODO Auto-generated method stub
//		return MuonTraDAL.getInstance().getResources().size();
//	}

//	public DefaultTableModel reloadResources() {
//		ArrayList<MuonTraDTO> dsMuonTra = new ArrayList<MuonTraDTO>();
//		dsMuonTra = MuonTraDAL.getInstance().reloadResources();
//		DefaultTableModel dtm = new DefaultTableModel();
//		try {
//			dtm.addColumn("STT");
//			dtm.addColumn("MÃ£ Ä‘á»™c giáº£");
//			dtm.addColumn("Há»� vÃ  tÃªn");
//			dtm.addColumn("MÃ£ sÃ¡ch");
//			dtm.addColumn("TÃªn sÃ¡ch");
//			dtm.addColumn("NgÃ y mÆ°á»£n");
//			dtm.addColumn("NgÃ y tráº£");
//			dtm.addColumn("Tráº¡ng thÃ¡i");
//			dtm.addColumn("Tráº£ sÃ¡ch");
//			int i = 1;
//			for(MuonTraDTO mt : dsMuonTra) {
//				if (mt.getTrangThai().equals("-1"))//Ä‘Ã£ tráº£
//					continue;
//				Object[] row = {i++, mt.getMaDocGia(), 
//						DocGiaDAL.getInstance().getTenDocGia(mt.getMaDocGia()), 
//						mt.getMaSach(),
//						SachDAL.getInstance().getTenSach(mt.getMaSach()),
//						mt.getNgayMuon(),
//						mt.getNgayTra(),
//						mt.getTrangThai(),
//						"Tráº£"};
//				dtm.addRow(row);
//			}
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		finally {
//			
//		}
//		return dtm;
//	}
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
