package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ChiTietPhieuMuonDTO;
import DTO.PhieuMuonDTO;
import MyException.ContainException;
import MyException.MyException;

public class ChiTietMuonDAL {
	private static ChiTietMuonDAL instance;
	private ArrayList<ChiTietPhieuMuonDTO> dsChiTietMuon;
	
	private ChiTietMuonDAL(String maPhieuMuon) {
		dsChiTietMuon = new ArrayList<ChiTietPhieuMuonDTO>();
		loadResources(maPhieuMuon);
	}
	
	public static ChiTietMuonDAL getInstance(String maPhieuMuon) {
		if (instance == null)
			instance = new ChiTietMuonDAL(maPhieuMuon);
		return instance;
	}
	
	private void loadResources(String maPhieuMuon){
		try {
			String query = new String("SELECT * v_CHITIETCHUATRA WHERE MAPHIEUMUON="+maPhieuMuon);
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);	
			while(resultSet.next()) {
				//khong hien thi ma phieu muon vi ma phieu muon chung nen se hien o phia tren
				dsChiTietMuon.add(new ChiTietPhieuMuonDTO(
						resultSet.getObject(2).toString(), 
						resultSet.getObject(3).toString(), 
						resultSet.getObject(4).toString()));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
//	public int soSachDangMuon(String maDocGia) {
//		int count = 0;
//		for (PhieuMuonDTO item: dsMuonTra) {
//			/*if (item.getMaDocGia().equals(maDocGia) && Integer.parseInt(item.getTrangThai())>= 0)
//				count++;*/
//		}
//		return count;
//	}
	
	public ArrayList<ChiTietPhieuMuonDTO> getResources() {
		return dsChiTietMuon;
	}

	public int addProcessing(String maPhieuMuon,String maQuyenSach) {
		int result=0;
		try {
			String query ="INSERT INTO CHITIETPHIEUMUON (MAQUYENSACH) VALUES('"+maQuyenSach+"')" ;
			 result = DAL.getInstance().executeQueryUpdate(query);			
			if(result > 0) loadResources(maPhieuMuon);
//			{
//				SachDAL.getInstance().changeTrangThai(pm.getMaSach(), "Ä�ang Ä‘Æ°á»£c mÆ°á»£n");
//				dsMuonTra.add(new MuonTraDTO(pm.getMaDocGia(), pm.getMaSach(), pm.getNgayMuon(), mt.getNgayTra(), mt.getTrangThai()));
//			}
		}catch(Exception e) {
		}
		return result;
	}
// Bo chuc nang sua chi tiet phieu muon
//	public int changeProcessing(PhieuMuonDTO pm) {
//		int result;
//		String query ="UPDATE";
//		result = DAL.getInstance().executeQueryUpdate(query);
//		if (result > 0)
//			try {
//				SachDAL.getInstance().changeTrangThai(mt.getMaSach(), "Trá»‘ng");
//			} catch (MyException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			for (MuonTraDTO item:dsMuonTra) {
//				if (item.getMaDocGia().equals(mt.getMaDocGia()) && item.getMaSach().equals(mt.getMaSach()))
//					{
//						item.setNgayMuon(mt.getNgayMuon());
//						item.setNgayTra(mt.getNgayTra());
//						break;
//					}
//			}
//		return result;
//	}

	public int traSach(String maPhieuMuon, String maQuyenSach) throws MyException {
		int result=0;
		String query ="UPDATE v_CHITIETCHUATRA SET TRANGTHAI=1 WHERE MAPHIEUMUON="+maPhieuMuon+",MAQUYENSACH="+maQuyenSach;
		result = DAL.getInstance().executeQueryUpdate(query);
		if (result >0) loadResources(maPhieuMuon);
//		{
//			for (MuonTraDTO item:dsMuonTra) {
//				if(item.getMaDocGia().equals(maDocGia)&& item.getMaSach().equals(maSach))
//					item.setTrangThai("-1");
//			}
//			SachDAL.getInstance().changeTrangThai(maSach, "Trá»‘ng");
//		}
		return result;
		
	}

//	public ArrayList<PhieuMuonDTO> reloadResources() {
//		// TODO Auto-generated method stub
//		return dsMuonTra;
//	}
}
