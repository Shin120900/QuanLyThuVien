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
			String query = new String("select * from docgia");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			while (resultSet.next()) {
				
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/*public String getTenDocGia(int maDocGia) {
		for (DocGiaDTO item: dsDocGia) {
			if (item.getMaDocGia() == maDocGia)
				return item.getTenDocGia();
		}
		return "";
	}
	
	public DocGiaDTO getDocGia(String maDocGia) {
		for (DocGiaDTO item : dsDocGia) {
			if (item.getMaDocGia().equals(maDocGia))
				return item;
		}
		return null;
	}
	
	public static DocGiaDAL getInstance() {
		if (instance == null)
			instance = new DocGiaDAL();
		return instance;
	}
	
	/*public boolean isContain(DocGiaDTO dg) {
		for (DocGiaDTO item: dsDocGia)
			if (item.getMaDocGia().equals(dg.getMaDocGia()))
				return true;
		return false;
	}
	
	public boolean isContain(String maDocGia) {
		for (DocGiaDTO item: dsDocGia)
			if (item.getMaDocGia().equals(maDocGia))
				return true;
		return false;
	}
	
	public int addProcessing(DocGiaDTO dg) throws ContainException{
		if (isContain(dg))
			throw new ContainException("Độc giả đã tồn tại, hoặc Mã độc giả bị trùng!");
		String query = "insert into docgia values(\"" + dg.getMaDocGia()+"\", \""+ dg.getTenDocGia()+"\", "
				+ "\""+ dg.getLoaiDocGia().getMaLoaiDocGia()+"\", \""+ 
				dg.getLopMon()+ "\", \""+ dg.getNgaySinh()+"\", \"" + dg.getSdt() +"\", \""+ dg.getEmail()+"\")";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if (result>0)
			dsDocGia.add(dg);
		return result;
	}
	
	public int changeProcessing(DocGiaDTO dg) {
		int result;
		String query = "update docgia set LopMon=\"" + dg.getLopMon()+"\", LoaiDocGia=\"" + dg.getLoaiDocGia().getMaLoaiDocGia()
				+"\", Email=\""
				+dg.getEmail()+"\",  sdt=\""+dg.getSdt()+"\", TenDocGia=\""+dg.getTenDocGia() +"\",  NgaySinh=\""+dg.getNgaySinh()
				+"\" where MaDocGia=\"" +dg.getMaDocGia()+"\"";
		
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
		int result = DAL.getInstance().executeQueryUpdate("delete from docgia where MaDocGia=\""+ madg +"\"");
		if (result > 0)
			for (int i = 0; i <dsDocGia.size(); i++) {
				if (dsDocGia.get(i).getMaDocGia().equals(madg))
					dsDocGia.remove(i);
			}
		return result;
	}*/
	public ArrayList<DocGiaDTO> getResources(){
		return dsDocGia;
	}
	
	public ArrayList<DocGiaDTO> reloadResources(){
		return dsDocGia;
	}

	public String thongTin(int maDocGia) {
		for (DocGiaDTO dg:dsDocGia) {
			if(dg.getMaDocGia() == maDocGia)
				return dg.getMaDocGia()+dg.getTenDocGia();
		}
		return "";
	}
	
	public int getSodocgia() {
		
		return dsDocGia.size();
	}
}
