package BLL;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAL.BienBanDAL;
import DAL.DocGiaDAL;
import DTO.BienBanXuLyDTO;
import MyException.ContainException;
import MyException.MyException;
import MyException.MyNullException;

public class BienBanBLL {
	public static BienBanBLL instance;

	private BienBanBLL() {

	}

	public static BienBanBLL getInstance() {
		if (instance == null)
			instance = new BienBanBLL();
		return instance;
	}
//
//	private boolean checkData(PhatTienDTO pt) throws MyNullException, MyException {
//		if (pt.getMaLanPhat().equals("")) {
//			throw new MyNullException("MÃ£ láº§n pháº¡t khÃ´ng Ä‘Æ°á»£c bá»� trá»‘ng");
//		}
//		if (pt.getSoTien().equals("")) {
//			throw new MyNullException("Sá»‘ tiá»�n khÃ´ng Ä‘Æ°á»£c bá»� trá»‘ng");
//		}
//		if (pt.getMaDocGia().equals("")) {
//			throw new MyNullException("MÃ£ Ä‘á»™c giáº£ khÃ´ng Ä‘Æ°á»£c bá»� trá»‘ng");
//		}
//		if (pt.getNgayPhat().equals("")) {
//			throw new MyNullException("NgÃ y pháº¡t khÃ´ng Ä‘Æ°á»£c bá»� trá»‘ng");
//		}
//		try {
//			int t = Integer.parseInt(pt.getSoTien());
//			if (t < 0)
//				throw new MyException("Sá»‘ tiá»�n pháº¡t pháº£i lá»›n hÆ¡n 0");
//		} catch (Exception e) {
//			throw new MyException("Sá»‘ tiá»�n pháº£i lÃ  sá»‘");
//		}
//
//		return true;
//	}

	public String addProcessing(String maPhieuMuon,String manv,String loivipham,String xuly) {
		try {
//			checkData(pt);
			String msg;
			int result = BienBanDAL.getInstance().addProcessing(maPhieuMuon,manv,loivipham,xuly);
			switch (result) {
			case -1:
			case 0:
				msg = "ThÃªm khÃ´ng thÃ nh cÃ´ng! Vui lÃ²ng thá»­ láº¡i";
				break;
			default:
				msg = "Ä�Ã£ thÃªm";
			}
			return msg;
//		} catch (MyNullException ex1) {
//			System.out.println(ex1);
//			return ex1.getMessage();
//		} catch (ContainException ex2) {
//			return ex2.getMessage();
//		} catch (MyException e) {
//			return e.getMessage();
//		}
		}catch (Exception e) {
			return e.toString();
		}
	}

	

//	public DefaultTableModel reloadResources() {
//		ArrayList<PhatTienDTO> dsPhatTien = new ArrayList<PhatTienDTO>();
//		dsPhatTien = PhatTienDAL.getInstance().reloadResources();
//		DefaultTableModel dtm = new DefaultTableModel();
//		try {
//			dtm.addColumn("STT");
//			dtm.addColumn("MÃ£ láº§n pháº¡t");
//			dtm.addColumn("Sá»‘ tiá»�n");
//			dtm.addColumn("MÃ£ Ä‘á»™c giáº£");
//			dtm.addColumn("NgÃ y pháº¡t");
//			dtm.addColumn("LÃ½ do");
//			int i = 1;
//			for (PhatTienDTO phat : dsPhatTien) {
//				Object[] row = { i++, phat.getMaLanPhat(), phat.getSoTien(), phat.getMaDocGia(), phat.getNgayPhat(),
//						phat.getLyDo() };
//				dtm.addRow(row);
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//
//		}
//		return dtm;
//
//	}

	public DefaultTableModel getResources() {
		ArrayList<BienBanXuLyDTO> dsBienBan = new ArrayList<BienBanXuLyDTO>();
		dsBienBan = BienBanDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma bien ban");
			dtm.addColumn("Ma phieu muon");
			dtm.addColumn("Ten nhan vien");
			dtm.addColumn("Ten sinh vien");
			dtm.addColumn("Ngay lap");
			dtm.addColumn("Loi vi pham");
			dtm.addColumn("Xu ly");
			for (BienBanXuLyDTO bb : dsBienBan) {
				Object[] row = { bb.getMaBienBan(),bb.getMaPhieuMuon(),bb.getTenNV(),bb.getTenSV(),bb.getNgayLap(),bb.getLoiViPham(),bb.getXuLy()};
				dtm.addRow(row);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return dtm;
	}
}
