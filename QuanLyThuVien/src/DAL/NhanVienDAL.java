package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import MyException.ContainException;

public class NhanVienDAL {

	private static NhanVienDAL instance;
	private ArrayList<NhanVienDTO> dsNhanVien;
	
	private NhanVienDAL() {
		dsNhanVien=new ArrayList<NhanVienDTO>();
		try {
			String query=new String("select * from dbo.v_NhanVien");
			ResultSet resultSet=DAL.getInstance().executeQueryToGetData(query);
			while(resultSet.next()) {
				dsNhanVien.add(new NhanVienDTO(
						resultSet.getObject(1).toString(),
						resultSet.getObject(2).toString(),
						resultSet.getObject(3).toString(),
						Date.valueOf(resultSet.getObject(4).toString()),
						resultSet.getObject(5).toString(),
						resultSet.getObject(6).toString(),
						resultSet.getObject(7).toString(),
						resultSet.getObject(8).toString(),
						resultSet.getObject(9).toString()));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static NhanVienDAL getInstance() {
		if(instance==null)
			instance=new NhanVienDAL();
		return instance;
	}
//	
//	public boolean isContain(NhanVienDTO nv) {
//		for (NhanVienDTO e: dsNhanVien)
//			if (e.getMaTaiKhoan().equals(nv.getMaTaiKhoan()))
//				return true;
//		return false;
//	}
//	
//	public int addProcessing(NhanVienDTO nv) throws ContainException{
//		if (isContain(nv))
//			throw new ContainException("NhÃ¢n viÃªn Ä‘Ã£ tá»“n táº¡i");
//		String query = "insert into taikhoan values(\"" + nv.getMaTaiKhoan()+"\", \""+ nv.getTenTaiKhoan()+"\", \""+ nv.getMatKhau()+"\", \""+ 
//				nv.getTenNhanVien()+ "\", \""+ nv.getLoaiTaiKhoan()+"\", \""+ nv.getEmail()+"\")";
//		int result = DAL.getInstance().executeQueryUpdate(query);
//		if (result>0)
//			dsNhanVien.add(nv);
//		return result;
//	}
//	
//	public int changeProcessing(NhanVienDTO nv) {
//		int result;
//		String query = "update taikhoan set TenTaiKhoan=\"" + nv.getTenTaiKhoan()+"\", LoaiTaiKhoan=\"" + nv.getLoaiTaiKhoan()+"\", Email=\""
//				+nv.getEmail()+"\",  MatKhau=\""+nv.getMatKhau()+"\", TenNhanVien=\"" +nv.getTenNhanVien()+"\" where MaTaiKhoan=\"" +nv.getMaTaiKhoan()+"\"";
//		result = DAL.getInstance().executeQueryUpdate(query);
//		
//		if (result > 0)
//			for (int i = 0; i<dsNhanVien.size(); i++) {
//				NhanVienDTO e = dsNhanVien.get(i);
//				if (e.getMaTaiKhoan().equals(nv.getMaTaiKhoan()))
//				{
//					dsNhanVien.set(i, nv);
//					break;
//				}
//			}
//		return result;
//	}
	
	public ArrayList<NhanVienDTO> getResources(){
		return dsNhanVien;
	}
	
//	public int deleteProcessing(String matk) {
//		int result = DAL.getInstance().executeQueryUpdate("delete from taikhoan where MaTaiKhoan=\"" +matk+"\"");
//		if (result > 0)
//		for (int i=0; i< dsNhanVien.size(); i++) {
//			if (dsNhanVien.get(i).getMaTaiKhoan().equals(matk))
//				dsNhanVien.remove(i);
//		}
//		return result;
//	}
	
	public ArrayList<NhanVienDTO> getResource(){
		return dsNhanVien;
	}
	
	public int countAdminAcount() {
		int count =0;
		for(NhanVienDTO item: dsNhanVien) {
			if (item.getLoaiTaiKhoan().equalsIgnoreCase("Quản lý"))
				count++;
		}
		return count;
	}
}
