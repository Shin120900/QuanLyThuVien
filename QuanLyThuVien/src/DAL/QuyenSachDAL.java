package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.DauSachDTO;
import DTO.QuyenSachDTO;

public class QuyenSachDAL {
	private static QuyenSachDAL instance;
	private ArrayList<QuyenSachDTO> dsSach;
	private QuyenSachDAL() {
		dsSach=new ArrayList<QuyenSachDTO>();
		loadResources();
	}
	
	public static QuyenSachDAL getInstance() {
		if(instance==null)
			instance = new QuyenSachDAL();
		return instance;
	}
	
	private void loadResources() {
		try {
			String query = new String("SELECT * FROM dbo.QUYENSACH");;
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			
			while(resultSet.next()) {
				dsSach.add(new QuyenSachDTO(
						resultSet.getObject(1).toString(), 
						resultSet.getObject(2).toString()));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public ArrayList<QuyenSachDTO> getResources(){
		return  dsSach;
	}

}
