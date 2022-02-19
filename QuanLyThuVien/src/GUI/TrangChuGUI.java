package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import BLL.MuonBLL;
import BLL.QLDocGiaBLL;
import BLL.QLSachBLL;

public class TrangChuGUI {

	private JFrame frmTrangChu;
	private JPanel pnTitle;
	private JPanel pnMenu;
	private JPanel pnMain;
	private JPanel pnTrangChu;
	private JMenuBar mbMenu;
	private int soCuonSach;
	private int soTheLoai;
	private int soDocGia;
	private int soSachMuon;
	
	static TrangChuGUI instance = null;
	
	private TrangChuGUI() {
		initialize();
	}
	
	public static TrangChuGUI getInstance() {
		if (instance == null)
			instance = new TrangChuGUI();
		return instance;
	}
	
	public JFrame getFrmTrangChu() {
		return frmTrangChu;
	}
	
	public void initTitle() {
		soCuonSach=QLSachBLL.getInstance().SoCuonSach();
		soTheLoai=QLSachBLL.getInstance().SoTheLoai();
		soDocGia=QLDocGiaBLL.getInstance().SoDocGia();
		soSachMuon=MuonBLL.getInstance().SoSachMuon();
		
		pnTitle = new JPanel();
		pnTitle.setBounds(10, 0, 1060, 118);
		pnTrangChu.add(pnTitle);
		pnTitle.setBackground(SystemColor.activeCaption);
		pnTitle.setLayout(null);
		
		
		JLabel lblQuyenSach = new JLabel("QUYEN SACH");
		lblQuyenSach.setForeground(new Color(255, 69, 0));
		lblQuyenSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblQuyenSach.setIcon(new ImageIcon("icon\\quyensach.png"));
		lblQuyenSach.setBounds(70, 41, 143, 39);
		pnTitle.add(lblQuyenSach);
		
		JLabel lblTheLoai = new JLabel("THE LOAI");
		lblTheLoai.setForeground(new Color(255, 69, 0));
		lblTheLoai.setIcon(new ImageIcon("icon\\theloai.png"));
		lblTheLoai.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTheLoai.setBounds(357, 41, 123, 41);
		pnTitle.add(lblTheLoai);
		
		JLabel lblDocGia = new JLabel("DOC GIA");
		lblDocGia.setForeground(new Color(255, 69, 0));
		lblDocGia.setIcon(new ImageIcon("icon\\367785583.jpg"));
		lblDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDocGia.setBounds(621, 41, 116, 39);
		pnTitle.add(lblDocGia);
		
		JLabel lblSachMuon = new JLabel("LUOT MUON");
		lblSachMuon.setForeground(new Color(255, 69, 0));
		lblSachMuon.setIcon(new ImageIcon("icon\\images.png"));
		lblSachMuon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSachMuon.setBounds(866, 41, 132, 39);
		pnTitle.add(lblSachMuon);
		
		JLabel lblSoCuonSach = new JLabel("");
		lblSoCuonSach.setForeground(new Color(255, 69, 0));
		lblSoCuonSach.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSoCuonSach.setBounds(53, 41, 16, 39);
		lblSoCuonSach.setText(soCuonSach+"");
		pnTitle.add(lblSoCuonSach);
		
		JLabel lblSoTheLoai = new JLabel("");
		lblSoTheLoai.setForeground(new Color(255, 69, 0));
		lblSoTheLoai.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSoTheLoai.setBounds(343, 42, 16, 39);
		lblSoTheLoai.setText(soTheLoai+"");
		pnTitle.add(lblSoTheLoai);
		
		JLabel lblSoDocGia = new JLabel("");
		lblSoDocGia.setForeground(new Color(255, 69, 0));
		lblSoDocGia.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSoDocGia.setBounds(602, 41, 16, 39);
		lblSoDocGia.setText(soDocGia+"");
		pnTitle.add(lblSoDocGia);
		
		JLabel lblSoSachMuon = new JLabel("");
		lblSoSachMuon.setForeground(new Color(255, 69, 0));
		lblSoSachMuon.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSoSachMuon.setBounds(852, 41, 16, 39);
		lblSoSachMuon.setText(soSachMuon+"");
		pnTitle.add(lblSoSachMuon);
		
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		//init the container
		frmTrangChu = new JFrame("QUAN LY THU VIEN");
		frmTrangChu.setBounds(10, 10, 1341, 720);//x,y,r,d
		frmTrangChu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrangChu.getContentPane().setLayout(null);
		//frmTrangChu.setResizable(false);
		
		pnTrangChu = new JPanel();
		pnTrangChu.setBounds(260, 0, 1065, 681);
		frmTrangChu.getContentPane().add(pnTrangChu);
		pnTrangChu.setLayout(null);
		
		
		
		initTitle();
		
		
		

		
		pnMain = new JPanel();
		pnMain.setBackground(SystemColor.inactiveCaptionBorder);
		pnMain.setBounds(10, 121, 1060, 560);
		pnTrangChu.add(pnMain);
		pnMain.setLayout(null);
		
		JLabel lblLoGoTruong = new JLabel("");
		lblLoGoTruong.setBackground(Color.LIGHT_GRAY);
		lblLoGoTruong.setBounds(12, 11, 221, 224);
		lblLoGoTruong.setIcon(new ImageIcon("icon\\PTNKLogo.png"));
		pnMain.add(lblLoGoTruong);
		
		JLabel lblTenTruong = new JLabel("TRUONG DAI HOC XAY DUNG HA NOI");
		lblTenTruong.setBounds(253, 39, 769, 86);
		lblTenTruong.setForeground(Color.BLUE);
		lblTenTruong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnMain.add(lblTenTruong);
		
		JPanel pnLich = new JPanel();
		pnLich.setBackground(SystemColor.controlHighlight);
		pnLich.setBounds(729, 145, 326, 404);
		pnMain.add(pnLich);
		pnLich.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(0, 25, 326, 359);
		pnLich.add(calendar);
		
		JLabel lblNewLabel = new JLabel("Lich nam:");
		lblNewLabel.setBounds(10, 0, 316, 25);
		pnLich.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblTruong = new JLabel("");
		lblTruong.setIcon(new ImageIcon("icon\\PTNK_overview.jpg"));
		lblTruong.setBounds(12, 145, 707, 404);
		pnMain.add(lblTruong);
		
		
		pnMenu = new JPanel();
		pnMenu.setBackground(SystemColor.activeCaption);
		pnMenu.setBounds(0, 0, 261, 681);
		frmTrangChu.getContentPane().add(pnMenu);
		pnMenu.setLayout(null);
		
		
		//init the control
		mbMenu = new JMenuBar();
		mbMenu.setBounds(2, 2, 259, 679);
		mbMenu.setLayout(new GridLayout(0,1));
		mbMenu.setBackground(SystemColor.textHighlight);
		pnMenu.add(mbMenu);
		JMenuItem mnTrangChu = new JMenuItem("TRANG CHU", new ImageIcon("icon\\home.png"));
		mnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		mnTrangChu.setBackground(SystemColor.textHighlight);
		mnTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnTrangChu.setForeground(Color.BLACK);
		mnTrangChu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				QLTrangChuGUI qlTrangChu=QLTrangChuGUI.getInstance();
				pnMain.add(qlTrangChu.getPnTongQuanQLTrangChu());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		
		JMenuItem mnChaoMung = new JMenuItem("THONG TIN CA NHAN");
		mnChaoMung.setForeground(Color.BLACK);
		mnChaoMung.setIcon(new ImageIcon("icon\\taikhoan.png"));
		mnChaoMung.setBackground(SystemColor.textHighlight);
		mnChaoMung.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnChaoMung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				//ChaoMungBLL.GetInstance().setNhanVien(nv);
				QLThongTinCaNhanGUI qlChaoMung=QLThongTinCaNhanGUI.getInstance();
				qlChaoMung.loadResources();
				pnMain.add(qlChaoMung.getPnTongQuanQLChaoMung());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		mbMenu.add(mnChaoMung);
		
		//mnTrangChu.setIcon(new ImageIcon("D:\\LEARNING\\THIRD YEAR\\OOAD\\DOAN\\Source\\icon\\home.png"));
		mbMenu.add(mnTrangChu);
		
		JMenuItem mnQLSach = new JMenuItem("QUAN LY SACH");
		mnQLSach.setIcon(new ImageIcon("icon\\book.png"));
		mnQLSach.setHorizontalAlignment(SwingConstants.LEFT);
		mnQLSach.setForeground(Color.BLACK);
		mnQLSach.setBackground(SystemColor.textHighlight);
		mnQLSach.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mbMenu.add(mnQLSach);
		mnQLSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				QLSachGUI qlSach=QLSachGUI.getInstance();
				qlSach.reloadResources();
				pnMain.add(qlSach.getPnTongQuanQLSach());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		
		JMenuItem mnQLDocGia = new JMenuItem("QUAN LY DOC GIA");
		mnQLDocGia.setHorizontalAlignment(SwingConstants.LEFT);
		mnQLDocGia.setIcon(new ImageIcon("icon\\people.png"));
		mnQLDocGia.setBackground(SystemColor.textHighlight);
		mnQLDocGia.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnQLDocGia.setForeground(Color.BLACK);
		mbMenu.add(mnQLDocGia);
		mnQLDocGia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnMain.removeAll();
				QLDocGiaGUI qlDocGia = QLDocGiaGUI.getInstance();
				qlDocGia.reloadResources();
				pnMain.add(qlDocGia.getPnMain());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		
		
		JMenuItem mnQLMuonTra = new JMenuItem("QUAN LY MUON TRA");
		mnQLMuonTra.setIcon(new ImageIcon("icon\\muontra.png"));
		mnQLMuonTra.setHorizontalAlignment(SwingConstants.LEFT);
		mnQLMuonTra.setBackground(SystemColor.textHighlight);
		mnQLMuonTra.setForeground(Color.BLACK);
		mnQLMuonTra.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mbMenu.add(mnQLMuonTra);
		mnQLMuonTra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnMain.removeAll();
				QLMuonTraGUI qlMuonTraSach = QLMuonTraGUI.getInstance();
				pnMain.add(qlMuonTraSach.getPnMain());
				pnMain.revalidate();
				pnMain.repaint();
				
			}
		});
		
		JMenuItem mnQLPhatTien = new JMenuItem("QUAN LY VI PHAM");
		mnQLPhatTien.setIcon(new ImageIcon("icon\\phattien.png"));
		mnQLPhatTien.setHorizontalAlignment(SwingConstants.LEFT);
		mnQLPhatTien.setForeground(Color.BLACK);
		mnQLPhatTien.setBackground(SystemColor.textHighlight);
		mnQLPhatTien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mbMenu.add(mnQLPhatTien);
		mnQLPhatTien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				QLPhatTienGUI qlPhatTien = QLPhatTienGUI.getInstance();
				pnMain.add(qlPhatTien.getPnTongQuanQLPhatTien());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		JMenu mnThongKe=new JMenu("BAO CAO");
		mnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		mnThongKe.setIcon(new ImageIcon("icon\\chart2.png"));
		mnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnThongKe.setBackground(SystemColor.textHighlight);
		mnThongKe.setForeground(Color.BLACK);
		mbMenu.add(mnThongKe);
		
		JMenuItem mnBaoCao = new JMenuItem("BAO CAO SACH MUON");
		mnBaoCao.setHorizontalAlignment(SwingConstants.LEFT);
		mnBaoCao.setIcon(new ImageIcon("icon\\chart.png"));
		mnBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnBaoCao.setBackground(SystemColor.inactiveCaptionBorder);
		mnBaoCao.setForeground(SystemColor.menuText);
		mnThongKe.add(mnBaoCao);
		mnBaoCao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				QLBaoCaoGUI qlBaoCao = QLBaoCaoGUI.getInstance();
				pnMain.add(qlBaoCao.getPnTongQuanQLTK());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
		
		JMenuItem mnBaoCaoTraTre=new JMenuItem("BAO CAO TRA TRE");
		mnBaoCaoTraTre.setHorizontalAlignment(SwingConstants.LEFT);
		mnBaoCaoTraTre.setIcon(new ImageIcon("icon\\chart.png"));
		mnBaoCaoTraTre.setFont(new Font("Times New Roman", Font.BOLD,14));
		mnBaoCaoTraTre.setBackground(SystemColor.inactiveCaptionBorder);
		mnBaoCaoTraTre.setForeground(SystemColor.menuText);
		mnThongKe.add(mnBaoCaoTraTre);
		mnBaoCaoTraTre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				QLBaoCaoTraTreGUI qlBaoCaoTre=QLBaoCaoTraTreGUI.getInstance();
				pnMain.add(qlBaoCaoTre.getPnTongQuanTKSach());
				pnMain.revalidate();
				pnMain.repaint();
			}
		});
	
	}
	
	public void setBgChiTietPM(String maPhieuMuon, String tenDocGia, boolean isCheck) {
		pnMain.removeAll();
		QLChiTietPhieuMuonGUI qlChiTietPhieuMuonGUI = QLChiTietPhieuMuonGUI.getInstance(maPhieuMuon, tenDocGia, isCheck);
		
		qlChiTietPhieuMuonGUI.initialize(maPhieuMuon, tenDocGia, isCheck);
		qlChiTietPhieuMuonGUI.reloadResources(maPhieuMuon);
		pnMain.add(qlChiTietPhieuMuonGUI.getPnMain());
		pnMain.revalidate();
		pnMain.repaint();
	}
	
	public void setBgPhieuMuon() {
		pnMain.removeAll();
		QLMuonTraGUI qlMuonTraGUI = QLMuonTraGUI.getInstance();
		qlMuonTraGUI.reloadResources();
		pnMain.add(qlMuonTraGUI.getPnMain());
		pnMain.revalidate();
		pnMain.repaint();
	}
}
