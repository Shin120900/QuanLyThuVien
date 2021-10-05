package BLL;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import DAL.MuonTraDAL;
import DAL.SachDAL;
import DTO.DauSachDTO;
import DTO.PhieuMuonDTO;


public class QLBaoCaoTreBLL {

	public static QLBaoCaoTreBLL instance;
	DefaultTableModel dtm;
	private ArrayList<Object[]> dataRow;
	private QLBaoCaoTreBLL() {
		dataRow= new ArrayList<Object[]>();
	}
	
	public static QLBaoCaoTreBLL getInstance() {
		if(instance==null)
			instance=new QLBaoCaoTreBLL();
		return instance;
	}
	
	

	/*public DefaultTableModel thongke() {
		dtm=new DefaultTableModel();
		dtm.addColumn("Mã sách");
		dtm.addColumn("Tên sách");
		dtm.addColumn("Ngày mượn");
		dtm.addColumn("Số ngày trễ");
		ArrayList<PhieuMuonDTO> dsMuonTra=MuonTraDAL.getInstance().getResources();
		ArrayList<DauSachDTO> dsSach=SachDAL.getInstance().getResources();
		
		Date date=new Date();
		for(PhieuMuonDTO mt: dsMuonTra) {
			if(mt.getNgayTra().compareTo(date) < 0) {
				String maSach=mt.getMaSach();
				String tenSach = null;
				for(SachDTO sach:dsSach) {
					if(maSach.equals(sach.getMaSach())) {
						tenSach=sach.getTenSach();
						break;
					}
				}
				
				Date ngaytra = mt.getNgayTra();
				Object[] row = {mt.getMaSach(), tenSach, mt.getNgayMuon(), (date.getTime()- ngaytra.getTime())/(24*3600*1000)};
				dataRow.add(row);
				dtm.addRow(row);
			}
			else
				continue;
		}
		
		return dtm;
	}
	public void lapBaoCaoTre() {
		XWPFDocument document=new XWPFDocument();
		XWPFParagraph p1=document.createParagraph();
		p1.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun run =p1.createRun();
		run.setFontSize(16);
		run.setBold(true);
		run.setText("Sở GD và ĐT TP.HÀ NỘI          CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");
		
		
		XWPFParagraph p6=document.createParagraph();
		p6.setAlignment(ParagraphAlignment.LEFT);
		run=p6.createRun();
		run.setFontSize(14);
		run.setBold(true);
		run.setText("Trường THPT MỸ THO               Độc lập - Tự do - Hạnh phúc");
		
		XWPFParagraph p5=document.createParagraph();
		p5.setAlignment(ParagraphAlignment.CENTER);
		run=p5.createRun();
		run.setFontSize(20);
		run.setBold(true);
		run.setText("BÁO CÁO THỐNG KÊ");
		
		XWPFParagraph p2 = document.createParagraph();
		p2.setAlignment(ParagraphAlignment.CENTER);
		run = p2.createRun();
		run.setFontSize(20);
		run.setBold(true);
		run.setText("TÌNH HÌNH TRẢ SÁCH TRỄ");
		
		XWPFParagraph p3 = document.createParagraph();
		p3.setAlignment(ParagraphAlignment.RIGHT);
		run = p3.createRun();
		run.setFontSize(14);
		SimpleDateFormat sdfNgay = new SimpleDateFormat("dd");
		SimpleDateFormat sdfThang = new SimpleDateFormat("MM");
		SimpleDateFormat sdfNam = new SimpleDateFormat("YYYY");
		Date now = new Date();
		run.setText("Ngày "+ sdfNgay.format(now) + " tháng "+ sdfThang.format(now) + " năm "+ sdfNam.format(now));
		
		
		XWPFParagraph p4 = document.createParagraph();

		p4.setAlignment(ParagraphAlignment.CENTER);
	
		XWPFTable tb = document.createTable();
		XWPFTableRow row = tb.getRow(0);
		
		
		row.getCell(0).setText("Mã sách");
		row.addNewTableCell().setText("Tên sách");
		row.addNewTableCell().setText("Ngày mượn");
		row.addNewTableCell().setText("Số ngày trễ");
		tb.setCellMargins(200, 200, 100, 1300);
		for(int i=0; i < dataRow.size(); i++) {
			Object[] iRow=dataRow.get(i);
			XWPFTableRow tableRow=tb.createRow();
			tableRow.setHeight(30);
			tableRow.getCell(0).setText(iRow[0].toString());
			tableRow.getCell(1).setText(iRow[1].toString());
			tableRow.getCell(2).setText(iRow[2].toString());
			tableRow.getCell(3).setText(iRow[3].toString());
		}
		
		XWPFParagraph p7=document.createParagraph();
		p7.setAlignment(ParagraphAlignment.RIGHT);
		run=p7.createRun();
		run.setFontSize(16);
		run.setBold(true);
		run.setText("Người lập báo cáo");
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd MM yyyy");
		try {
			FileOutputStream out=new FileOutputStream(new File("D://Báo cáo trả trễ ngày "+sdf.format(now)+".docx"));
			document.write(out);
			out.close();
			document.close();
			JOptionPane.showMessageDialog(null, "Thành công!","Thông báo",1);
			System.out.println("Thành công");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}*/
}
