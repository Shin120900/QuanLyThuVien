package BLL;

import java.util.ArrayList;

import MyException.ContainException;
import MyException.MyNullException;

import javax.swing.table.DefaultTableModel;

import DAL.NhanVienDAL;
import DTO.*;

public class QLNhanVienBLL {
	
	public static QLNhanVienBLL instance;
	private QLNhanVienBLL(){
		
	}
	
//	private boolean checkData(NhanVienDTO nv) throws MyNullException {
//		if (nv.getMaTaiKhoan().equals(""))
//		{
//			throw new MyNullException("MÃ£ tÃ i khoáº£n Ä‘ang bá»‹ trá»‘ng");
//		}
//		if (nv.getTenTaiKhoan().equals(""))
//		{
//			throw new MyNullException("TÃªn tÃ i khoáº£n Ä‘ang bá»‹ trá»‘ng");
//		}
//		if (nv.getTenNhanVien().equals(""))
//		{
//			throw new MyNullException("TÃªn nhÃ¢n viÃªn Ä‘ang bá»‹ trá»‘ng");
//		}
//		if (nv.getMatKhau().equals(""))
//		{
//			throw new MyNullException("Máº­t kháº©u Ä‘ang bá»‹ trá»‘ng");
//		}
//		if (nv.getLoaiTaiKhoan().equals(""))
//		{
//			throw new MyNullException("Loáº¡i tÃ i khoáº£n Ä‘ang bá»‹ trá»‘ng");
//		}
//		return true;
//	}
	
	public static QLNhanVienBLL getInstance() {
		if (instance == null)
			instance = new QLNhanVienBLL();
		return instance;
	}
//	
//	public String addProcessing(NhanVienDTO nv) {
//		try{
//			checkData(nv);
//			ArrayList<NhanVienDTO> dsNhanVien = NhanVienDAL.getInstance().getResource();
//			for(NhanVienDTO item: dsNhanVien) {
//				if(item.getTenTaiKhoan().equals(nv.getTenTaiKhoan()))
//					return "TÃªn tÃ i khoáº£n Ä‘Ã£ tá»“n táº¡i";
//			}
//			String msg;
//			int result = NhanVienDAL.getInstance().addProcessing(nv);
//			switch(result)
//			{
//			case -1:
//				//msg = "Error";
//			case 0:
//				msg = "ThÃªm khÃ´ng thÃ nh cÃ´ng! Vui lÃ²ng thá»­ láº¡i";
//				break;
//				default:
//					msg = "Ä�Ã£ thÃªm";
//			}
//			return msg;
//		}
//		catch(MyNullException ex1) {
//			return ex1.getMessage();
//		}
//		catch(ContainException ex2) {
//			return ex2.getMessage();
//		}
//	}
	
//	public DefaultTableModel reloadResources() {
//		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
//		dsNhanVien = NhanVienDAL.getInstance().getResource();
//		DefaultTableModel dtm = new DefaultTableModel();
//		try {
//			dtm.addColumn("STT");
//			dtm.addColumn("MÃ£ tÃ i khoáº£n");
//			dtm.addColumn("TÃªn tÃ i khoáº£n");
//			dtm.addColumn("Máº­t kháº©u");
//			dtm.addColumn("TÃªn nhÃ¢n viÃªn");
//			dtm.addColumn("Loáº¡i tÃ i khoáº£n");
//			dtm.addColumn("Email");
//			int i = 1;
//			for(NhanVienDTO nv : dsNhanVien) {
//				Object[] row = {i++,nv.getMaTaiKhoan(),nv.getTenTaiKhoan(),nv.getMatKhau(),nv.getTenNhanVien(),nv.getLoaiTaiKhoan(),nv.getEmail() };
//				dtm.addRow(row);
//			}
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		finally {
//			
//		}
//		return dtm;
//	}
	
//	public DefaultTableModel getResources() {
//		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
//		dsNhanVien = NhanVienDAL.getInstance().getResource();
//		DefaultTableModel dtm = new DefaultTableModel();
//		try {
//			dtm.addColumn("STT");
//			dtm.addColumn("MÃ£ tÃ i khoáº£n");
//			dtm.addColumn("TÃªn tÃ i khoáº£n");
//			dtm.addColumn("Máº­t kháº©u");
//			dtm.addColumn("TÃªn nhÃ¢n viÃªn");
//			dtm.addColumn("Loáº¡i "
//					+ "tÃ i khoáº£n");
//			dtm.addColumn("Email");
//			int i = 1;
//			for(NhanVienDTO nv : dsNhanVien) {
//				Object[] row = {i++,nv.getMaTaiKhoan(),nv.getTenTaiKhoan(),nv.getMatKhau(),nv.getTenNhanVien(),nv.getLoaiTaiKhoan(),nv.getEmail() };
//				dtm.addRow(row);
//			}
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		finally {
//			
//		}
//		return dtm;
//	}
//	
//	public String changeProcessing(NhanVienDTO nv) {
//		String msg;
//		ArrayList<NhanVienDTO> dsNhanVien = NhanVienDAL.getInstance().getResource();
//		boolean check = false;
//		for (NhanVienDTO item: dsNhanVien) {
//			if (nv.getMaTaiKhoan().equals(item.getMaTaiKhoan())) {
//				if (item.getLoaiTaiKhoan().equals("Quáº£n trá»‹ há»‡ thá»‘ng"))
//					check = true;
//				break;
//			}
//		}
//		if (check && nv.getLoaiTaiKhoan().equalsIgnoreCase("Thá»§ thÆ°") && NhanVienDAL.getInstance().countAdminAcount() == 1)
//			return "Há»‡ thá»‘ng cáº§n cÃ³ Ã­t nháº¥t 1 Quáº£n trá»‹ há»‡ thá»‘ng";
//		try {
//			checkData(nv);
//			int result = NhanVienDAL.getInstance().changeProcessing(nv);
//			switch(result)
//			{
//			case -1:
//			case 0:
//				msg = "Sá»­a khÃ´ng thÃ nh cÃ´ng! Vui lÃ²ng thá»­ láº¡i";
//				break;
//				default:
//					msg = "Ä�Ã£ chá»‰nh sá»­a";
//			}
//			return msg;
//		}
//		catch(MyNullException e) {
//			return e.toString();
//		}
//	}
//	
//	public String deleteProcessing(String matk, String loaiTaiKhoan) {
//		
//		if (matk.equals(""))
//			return "KhÃ´ng cÃ³ tÃ i khoáº£n nÃ o Ä‘Æ°á»£c chá»�n Ä‘á»ƒ xÃ³a";
//		if (loaiTaiKhoan.equalsIgnoreCase("Quáº£n trá»‹ há»‡ thá»‘ng") && NhanVienDAL.getInstance().countAdminAcount() == 1)
//			return "Há»‡ thá»‘ng cáº§n cÃ³ Ã­t nháº¥t 1 Quáº£n trá»‹ há»‡ thá»‘ng";
//		int result = NhanVienDAL.getInstance().deleteProcessing(matk);
//		if (result > 0)
//			return "XÃ³a thÃ nh cÃ´ng";
//		else
//			return "XÃ³a khÃ´ng thÃ nh cÃ´ng! Vui lÃ²ng kiá»ƒm tra láº¡i";
//	}
}
