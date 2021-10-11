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
	
	

	
	public ArrayList<ChiTietPhieuMuonDTO> getResources() {
		return dsChiTietMuon;
	}

	public int addProcessing(String maPhieuMuon,String maQuyenSach) {
		int result=0;
		try {
			String query ="INSERT INTO CHITIETPHIEUMUON (MAPHIEUMUON,MAQUYENSACH) VALUES('"+maPhieuMuon+"','"+maQuyenSach+"')";
			 result = DAL.getInstance().executeQueryUpdate(query);			
			if(result > 0) loadResources(maPhieuMuon);

		}catch(Exception e) {
		}
		return result;
	}


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

	public ArrayList<ChiTietPhieuMuonDTO> reloadResources() {
		// TODO Auto-generated method stub
		return dsChiTietMuon;
	}
}
