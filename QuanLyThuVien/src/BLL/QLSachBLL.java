package BLL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.SachDAL;
import DTO.*;
import MyException.ContainException;
import MyException.MyException;
import MyException.MyNullException;
public class QLSachBLL {
public static QLSachBLL instance;
	
	private QLSachBLL(){
		
	}
	
	public static QLSachBLL getInstance() {
		if (instance == null)
			instance = new QLSachBLL();
		return instance;
	}
//	private boolean checkData(DauSachDTO s) throws MyNullException, MyException{
//		
//		if(s.getTenSach().toString().equals(""))
//			throw new MyNullException("Ten sach khong duoc");
//		if(s.getTenTG().equals(""))
//			throw new MyNullException("TÃªn tÃ¡c giáº£ Ä‘ang bá»‹ bá»� trá»‘ng");
//		
//		return true;
//	}
//	

	public String addProcessing(DauSachDTO s) {
		try {
//			checkData(s);
			String msg;
			int result = SachDAL.getInstance().addProcessing(s);
			if (result > 0)
				msg = "Ä�Ã£ thÃªm thÃ nh cÃ´ng";
			else
				msg = "ThÃªm lá»—i! Vui lÃ²ng thá»­ láº¡i";
			return msg;
		}
//		catch(MyNullException e1) {
//			return e1.getMessage();
//		}
		catch(ContainException e2) {
			return e2.getMessage();
		}
//		catch(MyException e3) {
//			return e3.getMessage();
//		}
	}
	
	public DefaultTableModel getResources() {
		ArrayList<DauSachDTO> dsSach = new ArrayList<DauSachDTO>();
		dsSach = SachDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma dau sach");
			dtm.addColumn("Ten sach");
			dtm.addColumn("Ten tac gia");
			dtm.addColumn("Ten the loai");
			dtm.addColumn("Ten nha xuat ban");
			dtm.addColumn("Nam xuat ban");

			for(DauSachDTO sach : dsSach) {
				Object[] row = { sach.getMaDauSach(),sach.getTenSach(),sach.getTenTG(),sach.getTenTL(),
						sach.getTenNXB(), sach.getNamXB()};
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
//
	public String deleteProcessing(String s) {
		if(s.equals("")) 
			return "KhÃ´ng cÃ³ tÃ i khoáº£n nÃ o Ä‘Æ°á»£c chá»�n";
		
		int result = SachDAL.getInstance().deleteProcessing(s);
		if (result > 0)
			return "XÃ³a thÃ nh cÃ´ng";
		else
			return "XÃ³a khÃ´ng thÃ nh cÃ´ng! Vui lÃ²ng thá»­ láº¡i";
	}
//
	public String changeProcessing(DauSachDTO s) {
		try {
			String msg;
//			checkData(s);
			
			int result = SachDAL.getInstance().changeProcessing(s);
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
		}
//		catch(MyNullException e) {
//			return e.toString();
//		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
//
	public int SoCuonSach() {
		// TODO Auto-generated method stub
		return SachDAL.getInstance().getResources().size();
	}

	public int SoTheLoai() {
		ArrayList<DauSachDTO> dsSach = SachDAL.getInstance().getResources();
		ArrayList<String> theLoai = new ArrayList<String>();
		for(DauSachDTO s: dsSach) {
			if (!theLoai.contains(s.getTenTL()))
				theLoai.add(s.getTenTL());
		}
		return theLoai.size();
	}
//	public TableModel timKiem(String key) {
//		DefaultTableModel dtm=new DefaultTableModel();
//		ArrayList<SachDTO> dsSach = new ArrayList<SachDTO>();
//		dsSach = SachDAL.getInstance().getResources();
//			dtm.addColumn("STT");
//			dtm.addColumn("MÃ£ sÃ¡ch");
//			dtm.addColumn("TÃªn sÃ¡ch");
//			dtm.addColumn("Thá»ƒ loáº¡i");
//			dtm.addColumn("TÃ¡c giáº£");
//			dtm.addColumn("NhÃ  xuáº¥t báº£n");
//			dtm.addColumn("NgÃ y nháº­p");
//			dtm.addColumn("GiÃ¡ sÃ¡ch");
//			dtm.addColumn("Tráº¡ng thÃ¡i");
//			dtm.addColumn("NÄƒm xuáº¥t báº£n");
//			int i=0;
//			System.out.println(key);
//			for(SachDTO sach:dsSach) {
//				String thongTin=SachDAL.getInstance().getThongTin(sach.getMaSach());
//				thongTin=thongTin.toLowerCase();
//				key=key.toLowerCase();
//				if(thongTin.contains(key)) {
//					Object[] row= {i++,sach.getMaSach(),
//							sach.getTenSach(),
//							sach.getTheLoai(),
//							sach.getTacGia(),
//							sach.getNhaXuatBan(),
//							sach.getNgayNhap(),
//							sach.getGiaSach(),
//							sach.getTrangThai(),
//							sach.getNamXuatBan()};
//					dtm.addRow(row);
//					}
//				}
//			return dtm;
//			}
	}
	

