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
	
//	private boolean checkData(DocGiaDTO dg) throws MyNullException{
//		/*if (dg.getMaDocGia().equals("")) {
//			throw new MyNullException("MÃ£ Ä‘á»�c giáº£ Ä‘ang bá»‹ trá»‘ng");
//		} else if(dg.getLoaiDocGia().toString().equals("")) {
//			throw new MyNullException("Loáº¡i Ä‘á»�c giáº£ Ä‘ang bá»‹ trá»‘ng");
//		} else if(dg.getLopMon().equals("")) {
//			throw new MyNullException("Lá»›p/MÃ´n Ä‘ang bá»‹ bá»� trá»‘ng");
//		} else if(dg.getTenDocGia().equals("")) {
//			throw new MyNullException("TÃªn Ä‘á»�c giáº£ khÃ´ng Ä‘Æ°á»£c bá»� trá»‘ng");
//		}else {
//			try {
//				dg.getNgaySinh().toString();
//			}catch(NullPointerException e) {
//				throw new MyNullException("NgÃ y sinh Ä‘ang bá»‹ bá»� trá»‘ng");
//			}
//		}*/
//		return true;
//	}
	
	public String addProcessing(DocGiaDTO dg) {
		try {
//			checkData(dg);
			String msg;
			int result = DocGiaDAL.getInstance().addProcessing(dg);
			if (result > 0) {
				msg = "Ä�Ã£ thÃªm thÃ nh cÃ´ng";
			}
			else
				msg = "ThÃªm lá»—i! Vui lÃ²ng thá»­ láº¡i";
			return msg;
		}
//		catch(MyNullException e1) {
//			return e1.getMessage();
//		}
		catch (ContainException e2) {
			return e2.getMessage();
		}
		
	}
	
	public String changeProcessing(DocGiaDTO dg) {
		try {
			String msg;
//			checkData(dg);
			
			int result = DocGiaDAL.getInstance().changeProcessing(dg);
			switch(result)
			{
			case -1:
				//msg = "Error";
			case 0:
				msg = "Sá»­a khÃ´ng thÃ nh cÃ´ng! Vui lÃ²ng thá»­ láº¡i";
				break;
				default:
					msg = "Ä�Ã£ chá»‰nh sá»­a";
			}
			return msg;
		} catch (Exception e) {
			return e.toString();
		}
//		catch(MyNullException e) {
//			return e.toString();
//		}
	}
	
//	public DefaultTableModel reloadResources() {
//		ArrayList<DocGiaDTO> dsDocGia = new ArrayList<DocGiaDTO>();
//		dsDocGia = DocGiaDAL.getInstance().reloadResources();
//		DefaultTableModel dtm = new DefaultTableModel();
//		try {
//			dtm.addColumn("STT");
//			dtm.addColumn("MÃ£ Ä‘á»™c giáº£");
//			dtm.addColumn("Há»� vÃ  tÃªn");
//			dtm.addColumn("Loáº¡i Ä‘á»™c giáº£");
//			dtm.addColumn("Lá»›p");
//			dtm.addColumn("NgÃ y sinh");
//			dtm.addColumn("SÄ�T");
//			dtm.addColumn("Email");
//			int i = 1;
//			for(DocGiaDTO dg : dsDocGia) {
//				/*Object[] row = {i++, dg.getMaDocGia(), dg.getTenDocGia(),dg.getLoaiDocGia().toString(),
//						dg.getLopMon(), dg.getNgaySinh(), dg.getSdt(), dg.getEmail()};
//				dtm.addRow(row);*/
//			}
//			
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		finally {
//			
//		}
//		return dtm;
//	}
	
	public String deleteProcessing(String madg) {
		if(madg.equals("")) 
			return "KhÃ´ng cÃ³ tÃ i khoáº£n nÃ o Ä‘Æ°á»£c chá»�n";
		
		int result = DocGiaDAL.getInstance().deleteProcessing(madg);
		if (result > 0)
			return "XÃ³a thÃ nh cÃ´ng";
		else
			return "XÃ³a khÃ´ng thÃ nh cÃ´ng! Vui lÃ²ng thá»­ láº¡i";
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
//	
//	public TableModel timKiem(String key) {
//		DefaultTableModel dtm=new DefaultTableModel();
//		ArrayList<DocGiaDTO> dsDocGia=new ArrayList<DocGiaDTO>();
//		dsDocGia=DocGiaDAL.getInstance().reloadResources();
//		dtm.addColumn("STT");
//		dtm.addColumn("MÃ£ Ä‘á»™c giáº£");
//		dtm.addColumn("Há»� vÃ  tÃªn");
//		dtm.addColumn("Loáº¡i Ä‘á»™c giáº£");
//		dtm.addColumn("Lá»›p/ ChuyÃªn mÃ´n");
//		dtm.addColumn("NgÃ y sinh");
//		dtm.addColumn("SÄ�T");
//		dtm.addColumn("Email");
//		int i=0;
//		System.out.println(key);
//		for(DocGiaDTO dg:dsDocGia) {
//			String thongTin=DocGiaDAL.getInstance().thongTin(String.valueOf(dg.getMaDocGia()));
//			thongTin=thongTin.toLowerCase();
//			key=key.toLowerCase();
//			if(thongTin.contains(key)) {
//				/*Object[] row= {i++,dg.getMaDocGia(),
//						dg.getTenDocGia(),
//						dg.getLoaiDocGia(),
//						dg.getLopMon(),
//						dg.getNgaySinh(),
//						dg.getSdt(),
//						dg.getEmail()};
//				dtm.addRow(row);*/
//				}
//			}
//		return dtm;
//		}
	
}
