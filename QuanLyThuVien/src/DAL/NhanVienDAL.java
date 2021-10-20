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

		loadResource();
	}
	
	public static NhanVienDAL getInstance() {
		if(instance==null)
			instance=new NhanVienDAL();
		return instance;
	}
	public void loadResource() {
		try {
			dsNhanVien=new ArrayList<NhanVienDTO>();
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
//	public boolean isContain(NhanVienDTO nv) {
//		for (NhanVienDTO e: dsNhanVien)
//			if (e.getMaTaiKhoan().equals(nv.getMaTaiKhoan()))
//				return true;
//		return false;
//	}
//	
	public int addProcessing(NhanVienDTO nv) throws ContainException{
//		if (isContain(nv))
//			throw new ContainException("NhÃ¢n viÃªn Ä‘Ã£ tá»“n táº¡i");
		String query = "insert into v_NHANVIEN (HOTEN,GIOITINH,NGAYSINH,SDT,DIACHI,TAIKHOAN,MATKHAU,LOAITAIKHOAN) values(N'"+nv.getHoTen()
		+"',N'"+nv.getGioiTinh()+"','"+nv.getNgaySinh()+"','"+nv.getSdt()+"',N'"+nv.getDiaChi()+"','"+nv.getTaiKhoan()+"','"
		+nv.getMatKhau()+"',N'"+nv.getLoaiTaiKhoan()+"')";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if (result>0)
			dsNhanVien.add(nv);
		return result;
	}
//	
	public int changeProcessing(NhanVienDTO nv) {
		int result;
		String query = "update v_NHANVIEN set HOTEN=N'"+nv.getHoTen()+"',GIOITINH=N'"+nv.getGioiTinh()+"',NGAYSINH='"+nv.getNgaySinh()+"',SDT='"+nv.getSdt()+"',DIACHI=N'"
				+nv.getDiaChi()+"',TAIKHOAN='"+nv.getTaiKhoan()+"',MATKHAU='"+nv.getMatKhau()+"',LOAITAIKHOAN=N'"+nv.getLoaiTaiKhoan()+"' WHERE MANV="+nv.getManv();
		result = DAL.getInstance().executeQueryUpdate(query);		
		if (result > 0) {
			for (int i = 0; i<dsNhanVien.size(); i++) {
				NhanVienDTO e = dsNhanVien.get(i);
				if (e.getTaiKhoan().equals(nv.getTaiKhoan()))
				{
					dsNhanVien.set(i, nv);
					break;
				}
			}

		}
					return result;
	}
	
	public ArrayList<NhanVienDTO> getResources(){
		return dsNhanVien;
	}
	
	public int deleteProcessing(String manv) {
		int result = DAL.getInstance().executeQueryUpdate("delete from v_NHANVIEN where MANV=" +manv);
		if (result > 0) 
			for (int i=0; i< dsNhanVien.size(); i++) {
			if (dsNhanVien.get(i).getManv().equals(manv))
				dsNhanVien.remove(i);
		}
		return result;
	}
	
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
