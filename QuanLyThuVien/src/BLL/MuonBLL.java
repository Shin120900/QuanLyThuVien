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
						pm.getNgayHenTra()};				
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

	
	
	public int addProcessing(String manv,String mssv) {
			int result;
			try {
				result = PhieuMuonDAL.getInstance().addProcessing(manv,mssv);
				return result;
			} catch (Exception e) {
				return -1;
			}
	}



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

	public DefaultTableModel reloadResources() {
		ArrayList<PhieuMuonDTO> dsPhieuMuon = new ArrayList<PhieuMuonDTO>();
		dsPhieuMuon = PhieuMuonDAL.getInstance().reloadResources();
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
						pm.getNgayHenTra()};				
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
	public TableModel timKiem(String key) {
		DefaultTableModel dtm = new DefaultTableModel();
		ArrayList<PhieuMuonDTO> dsMuonTra = new ArrayList<PhieuMuonDTO>();
		dsMuonTra = PhieuMuonDAL.getInstance().reloadResources();
		dtm.addColumn("Ma phieu muon");
		dtm.addColumn("Ten nhan vien");
		dtm.addColumn("Ten sinh vien");
		dtm.addColumn("So luong");
		dtm.addColumn("Ngay muon");
		dtm.addColumn("Ngay hen tra");
		
		for(PhieuMuonDTO pm : dsMuonTra) {
			String thongTin = SachDAL.getInstance().getThongTin(pm.getMaPhieuMuon())+ pm.getTenSV();
			thongTin = thongTin.toLowerCase();
			key = key.toLowerCase();
			if(thongTin.contains(key)) {
				Object[] row = { pm.getMaPhieuMuon(), 
						pm.getTenNV(), 
						pm.getTenSV(),
						pm.getSoLuong(),
						pm.getNgayMuon(),
						pm.getNgayHenTra()};				
				dtm.addRow(row);
			}
		}
		return dtm;
	}
}
