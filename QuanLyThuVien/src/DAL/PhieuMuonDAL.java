package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ChiTietPhieuMuonDTO;
import DTO.PhieuMuonDTO;
import MyException.ContainException;

public class PhieuMuonDAL {
	private static PhieuMuonDAL instance;
	private ArrayList<PhieuMuonDTO> dsPhieuMuon;
	
	private PhieuMuonDAL() {
		dsPhieuMuon = new ArrayList<PhieuMuonDTO>();
		loadResources();
	}
	
	public static PhieuMuonDAL getInstance() {
		if (instance == null)
			instance = new PhieuMuonDAL();
		return instance;
	}
	
	private void loadResources(){
		try {
			String query = new String("SELECT * v_PHIEUMUONCHUATRA");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);	
			while(resultSet.next()) {
				dsPhieuMuon.add(new PhieuMuonDTO(
						resultSet.getObject(1).toString(), 
						resultSet.getObject(2).toString(), 
						resultSet.getObject(3).toString(),
						Integer.parseInt(resultSet.getObject(4).toString()),
						Date.valueOf(resultSet.getObject(5).toString()), 
						Date.valueOf(resultSet.getObject(6).toString())));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
//	private void loadResourcesChiTietPhieuMuon(){
//		try {
//			String query = new String("select * from quanlymuonsach");
//			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
//			
//			while(resultSet.next()) {
//				/*dsMuonTra.add(new MuonTraDTO(
//						resultSet.getObject(1).toString(), 
//						resultSet.getObject(2).toString(), 
//						Date.valueOf(resultSet.getObject(3).toString()), 
//						Date.valueOf(resultSet.getObject(4).toString()),
//						resultSet.getObject(5).toString()));*/
//			}
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//	}
	public int soPhieuMuon() {
		int count = 0;
		for (PhieuMuonDTO item: dsPhieuMuon) {
			count++;
		}
		return count;
	}
	
	public ArrayList<PhieuMuonDTO> getResources() {
		return dsPhieuMuon;
	}

	public int addProcessing(String manv,String mssv) throws ContainException{
		int result=0;
		try {
			String query = "INSERT INTO PHIEUMUON(MANV,MSSV) VALUES ('"+manv+"','"+mssv+"')";
			 result = DAL.getInstance().executeQueryUpdate(query);
			if(result > 0) loadResources();
//			{
//				SachDAL.getInstance().changeTrangThai(pm.getMaSach(), "Ä�ang Ä‘Æ°á»£c mÆ°á»£n");
//				dsMuonTra.add(new MuonTraDTO(pm.getMaDocGia(), pm.getMaSach(), pm.getNgayMuon(), mt.getNgayTra(), mt.getTrangThai()));
//			}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
// 	Bo phan sua phieu muon
//	public int changeProcessing(PhieuMuonDTO pm) {
//		int result;
//		String query ="UPDATE PHIEUMUON SET MSSV='";
//		
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

	
}
