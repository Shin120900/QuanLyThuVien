package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.BienBanXuLyDTO;
import MyException.ContainException;

public class BienBanDAL {
	private static BienBanDAL instance;
	private ArrayList<BienBanXuLyDTO> dsBienBan;
	private BienBanDAL() {
		dsBienBan=new ArrayList<BienBanXuLyDTO>();
		loadResources();
	}
	
	public static BienBanDAL getInstance() {
		if(instance==null)
			instance=new BienBanDAL();
		return instance;
	}
//	public boolean isContain(BienBanXuLyDTO bb) {
//		for(PhatTienDTO p:dsPhatTien)
//			if(p.getMaLanPhat().equals(pt.getMaLanPhat()))
//				return true;
//		return false;
//	}
	
	public int addProcessing(String maPhieuMuon,String maQuyenSach,String manv,String loiViPham,String xuLy){

		String query="INSERT INTO BIENBANXULY(MAPHIEUMUON,MANV,LOIVIPHAM,XULY) VALUES ('"+maPhieuMuon+"','"+maQuyenSach+"','"+manv+"',N'"+loiViPham+"',N'"+xuLy+"')";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if(result>0) loadResources();
//			dsPhatTien.add(pt);
		return result;
	}
	

	public ArrayList<BienBanXuLyDTO> getResources(){
		try {
			String query=new String("select * from v_BIENBANXULY");
			ResultSet resultSet=DAL.getInstance().executeQueryToGetData(query);
			while(resultSet.next()) {
				dsBienBan.add(new BienBanXuLyDTO(
						resultSet.getObject(1).toString(),
						resultSet.getObject(2).toString(),
						resultSet.getObject(3).toString(),
						resultSet.getObject(4).toString(),
						resultSet.getObject(5).toString(),
						Date.valueOf(resultSet.getObject(6).toString()),
						resultSet.getObject(7).toString(),
						resultSet.getObject(8).toString()));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return dsBienBan;
	}
	
	public ArrayList<BienBanXuLyDTO> loadResources(){
		return dsBienBan;
	}
}
