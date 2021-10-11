package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;

import DTO.*;
import MyException.ContainException;

public class DocGiaDAL {

	private static DocGiaDAL instance;
	private ArrayList<DocGiaDTO> dsDocGia;
	private DocGiaDAL() {
		loadResources();
	}
	
	private void loadResources(){
		try {	
			String query = new String("select * from v_SINHVIEN");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			while (resultSet.next()) {
				dsDocGia.add(new DocGiaDTO(resultSet.getObject(1).toString(),
						resultSet.getObject(2).toString(),
						resultSet.getObject(3).toString(),
						resultSet.getObject(4).toString(),
						resultSet.getObject(5).toString(),
						resultSet.getObject(6).toString(),
						Date.valueOf(resultSet.getObject(7).toString())
						));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public static DocGiaDAL getInstance() {
		if (instance == null)
			instance = new DocGiaDAL();
		return instance;
	}
		

	public int addProcessing(DocGiaDTO dg) throws ContainException{

		String query ="INSERT INTO v_SINHVIEN(HOTEN,GIOITINH,LOP,KHOA,DIACHI,NGAYSINH) VALUES (N'"+dg.getTenDocGia()+"',N'"+dg.getGioiTinh()+"','"+dg.getLop()
		+"',N'"+dg.getKhoa()+"',N'"+dg.getDiaChi()+"','"+dg.getNgaySinh()+"')";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if (result>0) loadResources();
//			dsDocGia.add(dg);
		return result;
	}
	
	public int changeProcessing(DocGiaDTO dg) {
		int result;
		String query ="UPDATE v_SINHVIEN SET HOTEN=N'"+dg.getTenDocGia()+"',GIOITINH=N'"+dg.getGioiTinh()+"',LOP='"+dg.getLop()+"',KHOA=N'"+dg.getKhoa()+"',DIACHI=N'"
				+dg.getDiaChi()+"',NGAYSINH='"+dg.getNgaySinh()+"' WHERE MSSV=" + dg.getMaDocGia();
		result = DAL.getInstance().executeQueryUpdate(query);
		
		if (result > 0)
			for (int i = 0; i<dsDocGia.size(); i++) {
				DocGiaDTO e = dsDocGia.get(i);
				if (e.getMaDocGia().equals(dg.getMaDocGia()))
				{
					dsDocGia.set(i, dg);
					break;
				}
			}
		return result;
	}
	
	public int deleteProcessing(String madg) {
		int result = DAL.getInstance().executeQueryUpdate("delete from v_SINHVIEN where MSSV="+ madg );
		if (result > 0) 
			for (int i = 0; i <dsDocGia.size(); i++) {
				if (dsDocGia.get(i).getMaDocGia().equals(madg))
					dsDocGia.remove(i);
			}
		return result;
	}
	public ArrayList<DocGiaDTO> getResources(){
		return dsDocGia;
	}
	
	public ArrayList<DocGiaDTO> reloadResources(){
		return dsDocGia;
	}

	public String thongTin(String maDocGia) {
		for (DocGiaDTO dg:dsDocGia) {
			if(dg.getMaDocGia().equals(maDocGia)){
				return dg.getMaDocGia()+dg.getTenDocGia()+dg.getGioiTinh();
		}
		}
		return "";
	}
	
	public int getSodocgia() {	
		return dsDocGia.size();
	}
}
