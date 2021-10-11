package BLL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.QuyenSachDAL;
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
	private boolean checkData(DauSachDTO s) throws MyNullException, MyException{
		
		if(s.getTenSach().toString().equals(""))
			throw new MyNullException("Ten sach khong duoc de trong");
		if(s.getTenTG().equals(""))
			throw new MyNullException("Ten tac gia khong duoc de trong");
		if(s.getTenTL().equals(""))
			throw new MyNullException("Ten the loai khong duoc de trong");
		if(s.getTenNXB().equals(""))
			throw new MyNullException("Ten nha xuat ban khong duoc de trong");
		if(s.getNamXB().equals(""))
			throw new MyNullException("Nam xuat ban khong duoc de trong");
		return true;
	}
	

	public String addProcessing(DauSachDTO s) {
		try {
			checkData(s);
			String msg;
			int result = SachDAL.getInstance().addProcessing(s);
			if (result > 0)
				msg = "Them thanh cong";
			else
				msg = "Them loi! Vui long kiem tra lai";
			return msg;
		}
		catch(MyNullException e1) {
			return e1.getMessage();
		}
		catch(ContainException e2) {
			return e2.getMessage();
		}
		catch(MyException e3) {
			return e3.getMessage();
		}
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

	public String changeProcessing(DauSachDTO s) {
		try {
			String msg;
			checkData(s);
			
			int result = SachDAL.getInstance().changeProcessing(s);
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
		catch(MyNullException e) {
			return e.toString();
		}
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
	public TableModel timKiem(String key) {
		DefaultTableModel dtm=new DefaultTableModel();
		ArrayList<DauSachDTO> dsSach = new ArrayList<DauSachDTO>();
		dsSach = SachDAL.getInstance().getResources();
		dtm.addColumn("Ma dau sach");
		dtm.addColumn("Ten sach");
		dtm.addColumn("Ten tac gia");
		dtm.addColumn("Ten the loai");
		dtm.addColumn("Ten nha xuat ban");
		dtm.addColumn("Nam xuat ban");
			for(DauSachDTO sach : dsSach) {
				String thongTin=SachDAL.getInstance().getThongTin(sach.getMaDauSach());
				thongTin=thongTin.toLowerCase();
				key=key.toLowerCase();
				if(thongTin.contains(key)) {
					Object[] row = { sach.getMaDauSach(),sach.getTenSach(),sach.getTenTG(),sach.getTenTL(),
							sach.getTenNXB(), sach.getNamXB()};
					dtm.addRow(row);
					}
				}
			return dtm;
			}

	public boolean isContain(String maQuyenSach) {
		boolean isCheck = false;
		ArrayList<QuyenSachDTO> dsQuyenSach = new ArrayList<QuyenSachDTO>();
		dsQuyenSach = QuyenSachDAL.getInstance().getResources();
		for (QuyenSachDTO quyenSachDTO : dsQuyenSach) {
			if(quyenSachDTO.getMaQuyenSach().equals(maQuyenSach)) isCheck = true;
		}
		return isCheck;
	}
	}
	

