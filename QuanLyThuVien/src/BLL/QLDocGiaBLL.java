package BLL;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.DocGiaDAL;
import DTO.*;
import MyException.ContainException;
import MyException.MyNullException;

public class QLDocGiaBLL {
	public static QLDocGiaBLL instance;
	
	private QLDocGiaBLL(){
		
	}
	
	public static QLDocGiaBLL getInstance() {
		if (instance == null)
			instance = new QLDocGiaBLL();
		return instance;
	}
	
	private boolean checkData(DocGiaDTO dg) throws MyNullException{
		if (dg.getTenDocGia().equals("")) {
			throw new MyNullException("Ten doc gia khong duoc de trong");
		} else if(dg.getLop().toString().equals("")) {
			throw new MyNullException("Lop khong duoc de trong");
		} else if(dg.getKhoa().equals("")) {
			throw new MyNullException("Khoa khong duoc de trong");
		} else if(dg.getGioiTinh().equals("")) {
			throw new MyNullException("Gioi tinh khong duoc de trong");
		} else if(dg.getDiaChi().equals("")){
			throw new MyNullException("Dia chi khong duoc de trong");
		} else {
			try {
				dg.getNgaySinh().toString();
			}catch(NullPointerException e) {
				throw new MyNullException("Ngay sinh dang de trong");
			}
		}
		return true;
	}
	
	public String addProcessing(DocGiaDTO dg) {
		try {
			checkData(dg);
			String msg;
			int result = DocGiaDAL.getInstance().addProcessing(dg);
			if (result > 0) {
				msg = "Them thanh cong";
			}
			else
				msg = "Them loi! Vui long thu lai";
			return msg;
		}
		catch(MyNullException e1) {
			return e1.getMessage();
		}
		catch (ContainException e2) {
			return e2.getMessage();
		}
		
	}
	
	public String changeProcessing(DocGiaDTO dg) {
		try {
			String msg;
			checkData(dg);
			
			int result = DocGiaDAL.getInstance().changeProcessing(dg);
			switch(result)
			{
			case -1:
				//msg = "Error";
			case 0:
				msg = "Sua khong thanh cong! Vui long thu lai";
				break;
				default:
					msg = "Da chinh sua";
			}
			return msg;
		} 
		catch (Exception e) {
			return e.toString();
		}
	}
	
	public DefaultTableModel reloadResources() {
		ArrayList<DocGiaDTO> dsDocGia = new ArrayList<DocGiaDTO>();
		dsDocGia = DocGiaDAL.getInstance().reloadResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("MSSV");
			dtm.addColumn("Ho va ten");
			dtm.addColumn("Gioi Tinh");
			dtm.addColumn("Lop");
			dtm.addColumn("Khoa");
			dtm.addColumn("Dia Chi");
			dtm.addColumn("Ngay Sinh");
			for(DocGiaDTO dg : dsDocGia) {
				Object[] row = { dg.getMaDocGia(), dg.getTenDocGia(),dg.getGioiTinh(),
						dg.getLop(), dg.getKhoa(), dg.getDiaChi(), dg.getNgaySinh()};
				dtm.addRow(row);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	}
	
	public String deleteProcessing(String madg) {
		
		int result = DocGiaDAL.getInstance().deleteProcessing(madg);
		if (result > 0)
			return "Xoa thanh cong";
		else
			return "Xoa khong thanh cong ! Vui long thu lai";
	}
	
	public DefaultTableModel getResources() {
		ArrayList<DocGiaDTO> dsDocGia = new ArrayList<DocGiaDTO>();
		dsDocGia = DocGiaDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("MSSV");
			dtm.addColumn("Ho va ten");
			dtm.addColumn("Gioi Tinh");
			dtm.addColumn("Lop");
			dtm.addColumn("Khoa");
			dtm.addColumn("Dia Chi");
			dtm.addColumn("Ngay Sinh");
			for(DocGiaDTO dg : dsDocGia) {
				Object[] row = { dg.getMaDocGia(), dg.getTenDocGia(),dg.getGioiTinh(),
						dg.getLop(), dg.getKhoa(), dg.getDiaChi(), dg.getNgaySinh()};
				dtm.addRow(row);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	}

	public int SoDocGia() {
		return DocGiaDAL.getInstance().getSodocgia();
	}
	
	public TableModel timKiem(String key) {
		DefaultTableModel dtm=new DefaultTableModel();
		ArrayList<DocGiaDTO> dsDocGia=new ArrayList<DocGiaDTO>();
		dsDocGia=DocGiaDAL.getInstance().reloadResources();
		dtm.addColumn("MSSV");
		dtm.addColumn("Ho va ten");
		dtm.addColumn("Gioi Tinh");
		dtm.addColumn("Lop");
		dtm.addColumn("Khoa");
		dtm.addColumn("Dia Chi");
		dtm.addColumn("Ngay Sinh");
		for(DocGiaDTO dg:dsDocGia) {
			String thongTin=DocGiaDAL.getInstance().thongTin(String.valueOf(dg.getMaDocGia()));
			thongTin=thongTin.toLowerCase();
			key=key.toLowerCase();
			if(thongTin.contains(key)) {
				Object[] row = { dg.getMaDocGia(), dg.getTenDocGia(),dg.getGioiTinh(),
						dg.getLop(), dg.getKhoa(), dg.getDiaChi(), dg.getNgaySinh()};
				dtm.addRow(row);
				}
			}
		return dtm;
		}
	
}
