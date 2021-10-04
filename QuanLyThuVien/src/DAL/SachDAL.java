package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import MyException.ContainException;
import MyException.MyException;

public class SachDAL {
	
	private static SachDAL instance;
	private ArrayList<DauSachDTO> dsSach;
	private SachDAL() {
		dsSach=new ArrayList<DauSachDTO>();
		loadResources();
	}
	
	public static SachDAL getInstance() {
		if(instance==null)
			instance = new SachDAL();
		return instance;
	}
	
	private void loadResources() {
		try {
			String query = new String("select * from dbo.v_Sach");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			
			while(resultSet.next()) {
				dsSach.add(new DauSachDTO(
						Integer.parseInt( resultSet.getObject(1).toString()), 
						resultSet.getObject(2).toString(), 
						resultSet.getObject(3).toString(), 
						resultSet.getObject(4).toString(),
						resultSet.getObject(5).toString(),
						Date.valueOf(resultSet.getObject(6).toString())));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public int addProcessing(DauSachDTO s) throws ContainException{
		String query="INSERT INTO v_Sach(TENSACH,TENTG,TENTL,TENNXB,NAMXB) values("+s.getTenSach()+","+s.getTenTG()+","+
				s.getTenTL()+","+s.getTenNXB()+","+s.getNamXB()+")";
		int result = DAL.getInstance().executeQueryUpdate(query);
		System.out.println(result);
		if (result>0)
			dsSach.add(s);
		return result;
	}
	
	
	public DauSachDTO getSach(int maDauSach) {
		for (DauSachDTO item:dsSach) {
			
			if (item.getMaDauSach()==maDauSach)
				return item;
		}
		return null;
	}
	
	public String getTenSach(int maSach) {
		for (DauSachDTO s: dsSach) {
			if (maSach==s.getMaDauSach())
				return s.getTenSach();
		}
		return "";
	}
	public ArrayList<DauSachDTO> getResources(){
		return  dsSach;
	}

//	public int deleteProcessing(String s) {
//		int result = DAL.getInstance().executeQueryUpdate("delete from sach where MaSach=\""+ s +"\"");
//		if (result > 0)
//			for (int i = 0; i <dsSach.size(); i++) {
//				if (dsSach.get(i).getMaSach().equals(s))
//					dsSach.remove(i);
//			}
//		return result;
//	}
//
//	public String getThongTin(String maSach) {
//		for (SachDTO s: dsSach) {
//			if (s.getMaSach().equals(maSach))
//				return s.getMaSach()+s.getTenSach() + s.getTacGia();
//		}
//		return "";
//	}
//	
//	public int changeProcessing(SachDTO s) {
//		int result;
//		String query = "update sach set TenSach=\"" + s.getTenSach() 
//		+"\", GiaSach=\""  + s.getGiaSach() 
//		+"\", TacGia=\"" + s.getTacGia() 
//		+"\",  TheLoai=\"" + s.getTheLoai()
//		+"\", NhaXuatBan=\"" + s.getNhaXuatBan() 
//		+"\",  NgayNhap=\"" + s.getNgayNhap()
//		+ "\", TrangThai=\"" + s.getTrangThai() 
//		+ "\", NamXuatBan=\"" + s.getNamXuatBan() 
//		+ "\" where MaSach=\"" + s.getMaSach()+"\"";
//		//System.out.println("Query = "+ query);
//		result = DAL.getInstance().executeQueryUpdate(query);
//		
//		if (result > 0)
//			for (int i = 0; i<dsSach.size(); i++) {
//				SachDTO e = dsSach.get(i);
//				if (e.getMaSach().equals(s.getMaSach()))
//				{
//					dsSach.set(i, s);
//					break;
//				}
//			}
//		return result;
//	}
}
