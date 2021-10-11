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
						resultSet.getObject(1).toString(), 
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
		String query="INSERT INTO v_Sach(TENSACH,TENTG,TENTL,TENNXB,NAMXB) values(N'"+s.getTenSach()+"',N'"+s.getTenTG()+"',N'"+
				s.getTenTL()+"',N'"+s.getTenNXB()+"','"+s.getNamXB()+"')";
		int result = DAL.getInstance().executeQueryUpdate(query);
		System.out.println(result);
		if (result>0)
			dsSach.add(s);
		return result;
	}
	
	
	
	public ArrayList<DauSachDTO> getResources(){
		return  dsSach;
	}


	public String getThongTin(String maSach) {
		for (DauSachDTO s: dsSach) {
			if (s.getMaDauSach().equals(maSach))
				return s.getMaDauSach()+s.getTenSach() + s.getTenTG()+s.getTenTL();
		}
		return "";
	}
//	
	public int changeProcessing(DauSachDTO s) {
		int result;
		String query = "UPDATE v_SACH SET TENSACH=N'"+s.getTenSach()+"',TENTG=N'"+s.getTenTG()+"',TENTL=N'"+s.getTenTL()+"',TENNXB=N'"+s.getTenNXB()+"',NAMXB='"+s.getNamXB()+"' WHERE MADAUSACH="+s.getMaDauSach();
		result = DAL.getInstance().executeQueryUpdate(query);
		
		if (result > 0) 
			for (int i = 0; i<dsSach.size(); i++) {
				DauSachDTO e = dsSach.get(i);
				if (e.getMaDauSach().equals(s.getMaDauSach()))
				{
					dsSach.set(i, s);
					break;
				}
			}
		return result;
	}
}
