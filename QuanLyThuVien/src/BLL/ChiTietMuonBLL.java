package BLL;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.ChiTietMuonDAL;
import DAL.DocGiaDAL;
import DAL.SachDAL;
import DTO.ChiTietPhieuMuonDTO;
import MyException.ContainException;
import MyException.MyException;
import MyException.MyNullException;

public class ChiTietMuonBLL {
	public static ChiTietMuonBLL instance;
	public ChiTietPhieuMuonDTO ctMuon;
	private ChiTietMuonBLL(){
	}
	
	public static ChiTietMuonBLL getInstance() {
		if (instance == null)
			instance = new ChiTietMuonBLL();
		return instance;
	}
	
	public boolean isCheck(String maQuyenSach) {
		ArrayList<ChiTietPhieuMuonDTO> dsChiTietPM = new ArrayList<ChiTietPhieuMuonDTO>();
		dsChiTietPM = ChiTietMuonDAL.getInstance().loadAll();
		for (ChiTietPhieuMuonDTO chiTietPhieuMuonDTO : dsChiTietPM) {
			if(chiTietPhieuMuonDTO.getMaQuyenSach().equals(maQuyenSach)) return true;
		}
		return false;
	}

	
	public DefaultTableModel loadResources(String maPhieuMuon) {
		ArrayList<ChiTietPhieuMuonDTO> dsctMuon = new ArrayList<ChiTietPhieuMuonDTO>();
		dsctMuon = ChiTietMuonDAL.getInstance().getResources(maPhieuMuon);
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma quyen sach");
			dtm.addColumn("Ten Sach");
			dtm.addColumn("Trang thai");
			dtm.addColumn("Tra sach");
			for(ChiTietPhieuMuonDTO ctMuon : dsctMuon) {
				Object[] row = {
						ctMuon.getMaQuyenSach(),
						ctMuon.getTenSach(),
						ctMuon.getTrangThai(),
						"Tra"};
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
	
	public DefaultTableModel reloadResources(String maPhieuMuon) {
		ArrayList<ChiTietPhieuMuonDTO> dsctMuon = new ArrayList<ChiTietPhieuMuonDTO>();
		dsctMuon = ChiTietMuonDAL.getInstance().reloadResources(maPhieuMuon);
		
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("Ma quyen sach");
			dtm.addColumn("Ten sach");
			dtm.addColumn("Trang thai");
			dtm.addColumn("Tra sach");
			for(ChiTietPhieuMuonDTO ctMuon : dsctMuon) {
				Object[] row = {
						ctMuon.getMaQuyenSach(),
						ctMuon.getTenSach(),
						ctMuon.getTrangThai(),
						"Trả"};
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

	
	public int deleteProcessing(String maPhieuMuon,String maQuyenSach) {
		try {

			int result = ChiTietMuonDAL.getInstance().deleteProcessing(maPhieuMuon, maQuyenSach);
			return result;
		}catch (Exception e) {
			return -1;
		}
	}
	
	public int addProcessing(String maPhieuMuon,String maQuyenSach) {
		try {

			int result = ChiTietMuonDAL.getInstance().addProcessing(maPhieuMuon,maQuyenSach);
			return result;

		}catch (Exception e) {
		return -1;
		}
	}



	public String traSach(String maPhieuMuon, String maQuyenSach) {
		try{
			int result = ChiTietMuonDAL.getInstance().traSach(maPhieuMuon, maQuyenSach);
			if (result > 0)
				return "Tra thanh cong";
			else
				return "Tra khong thanh cong";
		}catch(Exception e1) {
			return e1.getMessage();
		}	
	}



}
