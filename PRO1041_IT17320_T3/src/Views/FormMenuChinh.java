/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DomainModel.CTSanPham;
import DomainModel.GioHang;
import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import DomainModel.KhachHang;
import Reponsitories.GioHangReponsitory;
import Reponsitories.HoaDonChiTietRepo;
import Reponsitories.HoaDonRepo;
import Services.CTSanPhamService;
import Services.ChatLieuService;
import Services.DsSanPhamService;
import Services.HoaDonService;
import Services.KhachHangService;
import Services.MauSacService;
import Services.NhaCungCapService;
import Services.NhanVienService;
import Services.SanPhamService;
import Services.SizeService;
import Services.impl.CTSanPhamServiceImpl;
import Services.impl.ChatLieuServiceImpl;
import Services.impl.DsSanPhamServiceImpl;
import Services.impl.HoaDonServiceImpl;
import Services.impl.KhachHangServiceImpl;
import Services.impl.MauSacServiceImpl;
import Services.impl.NhaCungCapServiceimpl;
import Services.impl.NhanVienServiceImpl;
import Services.impl.SanPhamServiceImpl;
import Services.impl.SizeServiceImpl;
import ViewModels.CTSanPhamViewModel;
import ViewModels.ChatLieuViewModel;
import ViewModels.DsSanPhamViewModel;
import ViewModels.GioHangViewModel;
import ViewModels.HoaDonChiTietViewModel;
import ViewModels.HoaDonChoViewModel;
import ViewModels.HoaDonViewModel;
import ViewModels.KhachHangVM;
import ViewModels.MauSacViewModel;
import ViewModels.NhaCungCapVM;
import ViewModels.NhanVienViewModel;
import ViewModels.SanPhamViewmodel;
import ViewModels.SizeVM;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FormMenuChinh extends javax.swing.JFrame {

    private DefaultComboBoxModel dfcbkh;
    private DefaultComboBoxModel dfnvbh;

    //
    private DefaultComboBoxModel _DefaultComboBoxModel;
    private DefaultTableModel _DefaultTableModel;
    private String _IdWhenClick;
    private DefaultComboBoxModel _dcbMauSac;
    private DefaultComboBoxModel _dcbChatLieu;
    private DefaultComboBoxModel _dcbNcc;
    private DefaultComboBoxModel _dcbSize;
    private DefaultComboBoxModel _dcbSp;

    ArrayList<HoaDonChoViewModel> listHDC = new ArrayList<>();

    private ArrayList<GioHangViewModel> list = new ArrayList<>();
    private DefaultTableModel defaultTableModelGioHang;
    private DefaultTableModel defaultTableModelDSSP;
    private DefaultTableModel defaultTableModelHoaDon;
    private DefaultTableModel defaultTableModelHoaDon1;
    private DefaultTableModel defaultTableModelHoaDonChiTiet;
    private GioHangReponsitory gioHangReponsitory = new GioHangReponsitory();
    private DsSanPhamService dsService = new DsSanPhamServiceImpl();
    private KhachHangService khService = new KhachHangServiceImpl();
    private NhanVienService nvService = new NhanVienServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();
    //
    private MauSacService _ServiceMauSac;
    private ChatLieuService _ServiceChatLieu;
    private NhaCungCapService _ServiceNcc;
    private SizeService _ServiceSize;
    private SanPhamService _ServiceSp;
    private CTSanPhamService _ServiceCTSP;
    private NhanVienService _ServiceNhanVien;
    private HoaDonService _ServiceHoaDon;
    String findMS = "";
    private HoaDonRepo hoaDonRepo = new HoaDonRepo();

    /**
     * Creates new form FormMenuChinh
     */
    public FormMenuChinh() {
        initComponents();
        //LoadGioHang(gioHangReponsitory.GetAll());
        LoadDSSP(null);

        this.setLocationRelativeTo(null);
        //LoadHoaDonCho(hoaDonRepo.GetAll());
        LoadHDCT(hoaDonChiTietRepo.GetAll());
        //
        _ServiceChatLieu = new ChatLieuServiceImpl();
        _ServiceMauSac = new MauSacServiceImpl();
        _ServiceNcc = new NhaCungCapServiceimpl();
        _ServiceSize = new SizeServiceImpl();
        _ServiceSp = new SanPhamServiceImpl();
        _ServiceCTSP = new CTSanPhamServiceImpl();
        _ServiceNhanVien = new NhanVienServiceImpl();
        _ServiceHoaDon = new HoaDonServiceImpl();
        //
        _dcbChatLieu = (DefaultComboBoxModel) cboidchatlieu.getModel();
        _dcbMauSac = (DefaultComboBoxModel) cboidmausac.getModel();
        _dcbNcc = (DefaultComboBoxModel) cboidncc.getModel();
        _dcbSize = (DefaultComboBoxModel) cboidsize.getModel();
        _dcbSp = (DefaultComboBoxModel) cboidsp.getModel();
        LoadHoaDon();
        LoadCbo();
        LoadCboLoc();
        LoadTableDSSP(null);
        LoadTableSP(null);
        //LoadHoaDon(hoaDonRepo.GetAll());
        //LoadHoaDon();
        //findMS();

        Icon iconKH = new ImageIcon("kyc.png");
        this.btnKhachHang.setIcon(iconKH);
        Icon iconHD = new ImageIcon("bill.png");
        this.btnHoaDon.setIcon(iconHD);
        Icon iconNV = new ImageIcon("trader.png");
        this.btnNhanVien.setIcon(iconNV);
        Icon iconBH = new ImageIcon("sell.png");
        this.btnBanHang.setIcon(iconBH);
        Icon iconSP = new ImageIcon("clothing.png");
        this.btnSanPham.setIcon(iconSP);
        Icon iconExit = new ImageIcon("exit.png");
        this.btnExit.setIcon(iconExit);
        Icon iconOut = new ImageIcon("log-out.png");
        this.btnDangXuat.setIcon(iconOut);

//        Icon mo = new ImageIcon("mo.png");
//        this.lblMo.setIcon(mo);
        lblMo.setIcon(new ImageIcon(new ImageIcon("mo.png").getImage().getScaledInstance(282, 174, Image.SCALE_DEFAULT)));

        Icon iconThem = new ImageIcon("plus.png");
        this.btnThem.setIcon(iconThem);

        Icon iconUp = new ImageIcon("update.png");
        this.btnSuaSP.setIcon(iconUp);
        Icon iconXoa = new ImageIcon("xoa.png");
        this.btnXoaSP.setIcon(iconXoa);
        Icon iconRe = new ImageIcon("reset.png");
        this.btnreset.setIcon(iconRe);

        btnthemsp.setIcon(new ImageIcon(new ImageIcon("pl.png").getImage().getScaledInstance(33, 25, Image.SCALE_DEFAULT)));
        btnthemSize.setIcon(new ImageIcon(new ImageIcon("pl.png").getImage().getScaledInstance(30, 25, Image.SCALE_DEFAULT)));
        btnthemmausac.setIcon(new ImageIcon(new ImageIcon("pl.png").getImage().getScaledInstance(33, 25, Image.SCALE_DEFAULT)));
        btnthemncc.setIcon(new ImageIcon(new ImageIcon("pl.png").getImage().getScaledInstance(33, 25, Image.SCALE_DEFAULT)));
        btnthemchatlieu.setIcon(new ImageIcon(new ImageIcon("pl.png").getImage().getScaledInstance(33, 25, Image.SCALE_DEFAULT)));
        btntaohd.setIcon(new ImageIcon(new ImageIcon("add-folder.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        lblHome.setIcon(new ImageIcon(new ImageIcon("monn.svg").getImage().getScaledInstance(1157, 800, Image.SCALE_DEFAULT)));
//        Icon sp = new ImageIcon("pl.png");
//        this.btnthemsp.setIcon(sp);
//        Icon size = new ImageIcon("pl.png");
//        this.btnthemsize.setIcon(size);
//        Icon ms = new ImageIcon("pl.png");
//        this.btnthemmausac.setIcon(ms);
//        Icon ncc = new ImageIcon("pl.png");
//        this.btnthemncc.setIcon(ncc);
//        Icon cl = new ImageIcon("pl.png");
//        this.btnthemchatlieu.setIcon(cl);

        Icon lm = new ImageIcon("cleaning.png");
        this.btnLamMoi.setIcon(lm);
        Icon huy = new ImageIcon("document.png");
        this.btnHuyHoaDon.setIcon(huy);
        Icon thanhtoan = new ImageIcon("pay.png");
        this.btnThanhToan.setIcon(thanhtoan);

        chayChu();
    }

    public void chayChu() {
        Thread t1 = new Thread() {
            public void run() {
                String txt = lblChu.getText() + " ";
                while (true) {
                    txt = txt.charAt(txt.length() - 1) + txt.substring(0, txt.length() - 1);
                    try {
                        sleep(1500);
                    } catch (InterruptedException ex) {
                        //Logger.getLoggger(FormMenuChinh.getName()).log(Level.SEVERE,null,ex);
                    }
                    lblChu.setText(txt);
                }
            }
        };
        t1.start();
    }

    //
    private CTSanPham GetDataFromGui() {
        try {
            SanPhamViewmodel idSanPham = (SanPhamViewmodel) cboidsp.getSelectedItem();
            MauSacViewModel idMauSac = (MauSacViewModel) cboidmausac.getSelectedItem();
            SizeVM idSize = (SizeVM) cboidsize.getSelectedItem();
            NhaCungCapVM idNcc = (NhaCungCapVM) cboidncc.getSelectedItem();
            ChatLieuViewModel idChatLieu = (ChatLieuViewModel) cboidchatlieu.getSelectedItem();

            String mota = tarmota.getText();
            Double soLuong = Double.parseDouble(txtsoluong.getText());
            Double giaBan = Double.parseDouble(txtgiaban.getText());
            Double giaNhap = Double.parseDouble(txtgianhap.getText());

            CTSanPham ctspv = new CTSanPham();
            ctspv.setIdSp(idSanPham.getId());
            ctspv.setIdMauSac(idMauSac.getId());
            ctspv.setIdSize(idSize.getId());
            ctspv.setIdNhaCungCap(idNcc.getId());
            ctspv.setIdChatLieu(idChatLieu.getId());
            ctspv.setMoTa(mota);
            ctspv.setSoLuongTon(soLuong);
            ctspv.setGiaBan(giaBan);
            ctspv.setGiaNhap(giaNhap);

            return ctspv;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //
    public void LoadCboLoc() {
        cbolocchatlieu.removeAllItems();
        List<ChatLieuViewModel> dsChatLieu1 = _ServiceChatLieu.GetAll();
        for (ChatLieuViewModel chatLieuViewModel1 : dsChatLieu1) {
            cbolocchatlieu.addItem(chatLieuViewModel1);
        }
        //
        cbolocmausac.removeAllItems();
        List<MauSacViewModel> dsMauSac1 = _ServiceMauSac.getAll();
        for (MauSacViewModel mauSac : dsMauSac1) {
            cbolocmausac.addItem(mauSac);
        }
        //
        cbolocsize.removeAllItems();
        List<SizeVM> dsSize1 = _ServiceSize.getListSize();
        for (SizeVM size : dsSize1) {
            cbolocsize.addItem(size);
        }
    }

    //
    public void LoadCbo() {

        cbKhachHang.removeAllItems();
        List<KhachHangVM> listKH = khService.getall();
        for (KhachHangVM khachHangVM : listKH) {
            cbKhachHang.addItem(khachHangVM);
        }
        //
        cbNhanVien.removeAllItems();
        List<NhanVienViewModel> listNV = nvService.GetAll();
        for (NhanVienViewModel nvv : listNV) {
            cbNhanVien.addItem(nvv);
        }

        cboidchatlieu.removeAllItems();
        List<ChatLieuViewModel> dsChatLieu = _ServiceChatLieu.GetAll();
        for (ChatLieuViewModel chatLieuViewModel : dsChatLieu) {
            cboidchatlieu.addItem(chatLieuViewModel);
        }
        //
//        cbolocchatlieu.removeAllItems();
//        List<ChatLieuViewModel> dsChatLieu1 = _ServiceChatLieu.GetAll();
//        for (ChatLieuViewModel chatLieuViewModel : dsChatLieu) {
//            cbolocchatlieu.addItem(chatLieuViewModel);
//        }

        //
        cboidmausac.removeAllItems();
        List<MauSacViewModel> dsMauSac = _ServiceMauSac.getAll();
        for (MauSacViewModel mauSac : dsMauSac) {
            cboidmausac.addItem(mauSac);
        }
        //
//        cbolocmausac.removeAllItems();
//        List<MauSacViewModel> dsMauSac1 = _ServiceMauSac.getAll();
//        for (MauSacViewModel mauSac : dsMauSac) {
//            cbolocmausac.addItem(mauSac);
//        }
        //
        cboidncc.removeAllItems();
        List<NhaCungCapVM> dsNcc = _ServiceNcc.getAll();
        for (NhaCungCapVM ncc : dsNcc) {
            cboidncc.addItem(ncc);
        }
        //
        cboidsize.removeAllItems();
        List<SizeVM> dsSize = _ServiceSize.getListSize();
        for (SizeVM size : dsSize) {
            cboidsize.addItem(size);
        }
        //
//        cbolocsize.removeAllItems();
//        List<SizeVM> dsSize1 = _ServiceSize.getListSize();
//        for (SizeVM size : dsSize) {
//            cbolocsize.addItem(size);
//        }
        //
        cboidsp.removeAllItems();
        List<SanPhamViewmodel> dsSp = _ServiceSp.getAll();
        for (SanPhamViewmodel sanPhamViewmodel : dsSp) {
            cboidsp.addItem(sanPhamViewmodel);
        }
        //
//        cbNhanVien.removeAllItems();
//        List<NhanVienViewModel> dsNv = _ServiceNhanVien.GetAll();
//        for (NhanVienViewModel nvv : dsNv) {
//            cbNhanVien.addItem(nvv);
//        }
//        cbolocchatlieu.removeAllItems();
//        List<ChatLieuViewModel> dsChatLieu1 = _ServiceChatLieu.GetAll();
//        for (ChatLieuViewModel chatLieuViewModel1 : dsChatLieu1) {
//            cbolocchatlieu.addItem(chatLieuViewModel1);
//        }
//        //
//        cbolocmausac.removeAllItems();
//        List<MauSacViewModel> dsMauSac1 = _ServiceMauSac.getAll();
//        for (MauSacViewModel mauSac : dsMauSac1) {
//            cbolocmausac.addItem(mauSac);
//        }
//        //
//        cbolocsize.removeAllItems();
//        List<SizeVM> dsSize1 = _ServiceSize.getListSize();
//        for (SizeVM size : dsSize1) {
//            cbolocsize.addItem(size);
//        }
    }

//    public void LoadCboDSSP() {
//
//        cbCL.removeAllItems();
//        List<ChatLieuViewModel> dsChatLieu = _ServiceChatLieu.GetAll();
//        for (ChatLieuViewModel chatLieuViewModel : dsChatLieu) {
//            cbCL.addItem(chatLieuViewModel.toString());
//        }
//        //
////        cbolocchatlieu.removeAllItems();
////        List<ChatLieuViewModel> dsChatLieu1 = _ServiceChatLieu.GetAll();
////        for (ChatLieuViewModel chatLieuViewModel : dsChatLieu) {
////            cbolocchatlieu.addItem(chatLieuViewModel);
////        }
//
//        //
//        cboidmausac.removeAllItems();
//        List<MauSacViewModel> dsMauSac = _ServiceMauSac.getAll();
//        for (MauSacViewModel mauSac : dsMauSac) {
//            cboidmausac.addItem(mauSac);
//        }
//        //
////        cbolocmausac.removeAllItems();
////        List<MauSacViewModel> dsMauSac1 = _ServiceMauSac.getAll();
////        for (MauSacViewModel mauSac : dsMauSac) {
////            cbolocmausac.addItem(mauSac);
////        }
//        //
//        cboidncc.removeAllItems();
//        List<NhaCungCapVM> dsNcc = _ServiceNcc.getAll();
//        for (NhaCungCapVM ncc : dsNcc) {
//            cboidncc.addItem(ncc);
//        }
//        //
//        cboidsize.removeAllItems();
//        List<SizeVM> dsSize = _ServiceSize.getListSize();
//        for (SizeVM size : dsSize) {
//            cboidsize.addItem(size);
//        }
//        //
////        cbolocsize.removeAllItems();
////        List<SizeVM> dsSize1 = _ServiceSize.getListSize();
////        for (SizeVM size : dsSize) {
////            cbolocsize.addItem(size);
////        }
//        //
//        cboidsp.removeAllItems();
//        List<SanPhamViewmodel> dsSp = _ServiceSp.getAll();
//        for (SanPhamViewmodel sanPhamViewmodel : dsSp) {
//            cboidsp.addItem(sanPhamViewmodel);
//        }
//    }
    //
    public void LoadTableSP(String input) {
        _DefaultTableModel = (DefaultTableModel) tblctsanpham.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;

        for (CTSanPhamViewModel x : _ServiceCTSP.getAll(input)) {
            _DefaultTableModel.addRow(new Object[]{
                x.getId(),
                x.getIdSp(),
                x.getIdSize(),
                x.getIdMauSac(),
                x.getIdNhaCungCap(),
                x.getIdChatLieu(),
                x.getSoLuongTon(),
                x.getGiaNhap(),
                x.getGiaBan()
            });
        }
    }

    public void LoadTableSPNew(List<CTSanPhamViewModel> list) {
        _DefaultTableModel = (DefaultTableModel) tblctsanpham.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;

        for (CTSanPhamViewModel x : list) {
            _DefaultTableModel.addRow(new Object[]{
                x.getId(),
                x.getIdSp(),
                x.getIdSize(),
                x.getIdMauSac(),
                x.getIdNhaCungCap(),
                x.getIdChatLieu(),
                x.getSoLuongTon(),
                x.getGiaNhap(),
                x.getGiaBan()
            });
        }
    }

    public void LoadTableDSSP(String input) {
        defaultTableModelDSSP = (DefaultTableModel) tbSanPham.getModel();
        defaultTableModelDSSP.setRowCount(0);
        int stt = 1;
        for (DsSanPhamViewModel x : dsService.getAll(input)) {
            defaultTableModelDSSP.addRow(new Object[]{
                stt++, x.getId(), x.getSanPham(), x.getSize(), x.getMauSac(), x.getNcc(), x.getChatLieu(), x.getSoLuong(), x.getGiaBan()
            });
        }
    }

    public void LoadTableLocDSSPSize(String input) {
        defaultTableModelDSSP = (DefaultTableModel) tbSanPham.getModel();
        defaultTableModelDSSP.setRowCount(0);
        int stt = 1;
        for (DsSanPhamViewModel x : dsService.GetAllSize(input)) {
            defaultTableModelDSSP.addRow(new Object[]{
                stt++, x.getId(), x.getSanPham(), x.getSize(), x.getMauSac(), x.getNcc(), x.getChatLieu(), x.getSoLuong(), x.getGiaBan()
            });
        }
    }

    //
    public void LoadTableLocDSSPChatLieu(String input) {
        defaultTableModelDSSP = (DefaultTableModel) tbSanPham.getModel();
        defaultTableModelDSSP.setRowCount(0);
        int stt = 1;
        for (DsSanPhamViewModel x : dsService.GetAllCL(input)) {
            defaultTableModelDSSP.addRow(new Object[]{
                stt++, x.getId(), x.getSanPham(), x.getSize(), x.getMauSac(), x.getNcc(), x.getChatLieu(), x.getSoLuong(), x.getGiaBan()
            });
        }
    }

    //
    public void LoadTableLocDSSPMauSac(String input) {
        defaultTableModelDSSP = (DefaultTableModel) tbSanPham.getModel();
        defaultTableModelDSSP.setRowCount(0);
        int stt = 1;
        for (DsSanPhamViewModel x : dsService.GetAllMS(input)) {
            defaultTableModelDSSP.addRow(new Object[]{
                stt++, x.getId(), x.getSanPham(), x.getSize(), x.getMauSac(), x.getNcc(), x.getChatLieu(), x.getSoLuong(), x.getGiaBan()
            });
        }
    }

    //
    public void LoadTableLocDSSPNcc(String input) {
        defaultTableModelDSSP = (DefaultTableModel) tbSanPham.getModel();
        defaultTableModelDSSP.setRowCount(0);
        int stt = 1;
        for (DsSanPhamViewModel x : dsService.GetAllNCC(input)) {
            defaultTableModelDSSP.addRow(new Object[]{
                stt++, x.getId(), x.getSanPham(), x.getSize(), x.getMauSac(), x.getNcc(), x.getChatLieu(), x.getSoLuong(), x.getGiaBan()
            });
        }
    }
    //
//    public void findMS() {
//        DefaultTableModel dtm=(DefaultTableModel) tbSanPham.getModel();
//        dtm.setRowCount(0);
//        int stt = 1;
//        for (DsSanPhamViewModel x : this.dsService.findMauSac(findMS)) {
//            dtm.addRow(new Object[]{
//                stt++, x.getId(), x.getSanPham(), x.getSize(), x.getMauSac(), x.getNcc(), x.getChatLieu(), x.getSoLuong(), x.getGiaBan()
//            });
//        }
//    }
    //

    public void LoadTableSPLoc(SizeVM obj) {
        _DefaultTableModel = (DefaultTableModel) tblctsanpham.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;

        for (CTSanPhamViewModel x : _ServiceCTSP.GetAll()) {
            _DefaultTableModel.addRow(new Object[]{
                x.getId(),
                x.getIdSp(),
                x.getIdSize(),
                x.getIdMauSac(),
                x.getIdNhaCungCap(),
                x.getIdChatLieu(),
                x.getSoLuongTon(),
                x.getGiaNhap(),
                x.getGiaBan()
            });
        }
    }

    //
//    void addCbKh() {
//        dfcbkh = (DefaultComboBoxModel) cbKhachHang.getModel();
//        for (KhachHangVM kh : khService.getall()) {
//            dfcbkh.addElement(kh.getSdt());
//        }
//    }
//
//    void addnvbh() {
//        dfnvbh = (DefaultComboBoxModel) cbNhanVien.getModel();
//        for (NhanVienViewModel nv : nvService.GetAll()) {
//            dfnvbh.addElement(nv.getTen());
//        }
//    }
    public String GetTrangThai(int tt) {
        if (tt == 0) {
            return "Da Thanh Toan";
        } else if (tt == 1) {
            return "Cho Thanh Toan";
        }
        return null;
    }
    private int sl;

    public void LoadGioHang(ArrayList<GioHangViewModel> list) {
        defaultTableModelGioHang = (DefaultTableModel) tbgiohang.getModel();
        defaultTableModelGioHang.setRowCount(0);
        int stt = 1;
        for (GioHangViewModel x : list) {
            defaultTableModelGioHang.addRow(new Object[]{
                stt++, x.getMaSP(), x.getTenSP(), x.getSoLuong(), x.getDonGia(), x.getSoLuong() * x.getDonGia()
            });
        }
    }

    public void LoadDSSP(String input) {
        defaultTableModelDSSP = (DefaultTableModel) tbSanPham.getModel();
        defaultTableModelDSSP.setRowCount(0);
        int stt = 1;
        for (DsSanPhamViewModel x : dsService.getAll(input)) {
            defaultTableModelDSSP.addRow(new Object[]{
                stt++, x.getId(), x.getSanPham(), x.getSize(), x.getMauSac(), x.getNcc(), x.getChatLieu(), x.getSoLuong(), x.getGiaBan()
            });
        }
    }

    public void LoadHoaDonCho() {
        defaultTableModelHoaDon = (DefaultTableModel) tbhdc.getModel();
        defaultTableModelHoaDon.setRowCount(0);
        int stt = 1;
        for (HoaDonChoViewModel x : listHDC) {
            defaultTableModelHoaDon.addRow(new Object[]{
                stt++, x.getMaHD(), x.getNgayTao(), GetTrangThai(x.getTrangThai())
            });
        }
    }

    //
    public void LoadHoaDon() {
        defaultTableModelHoaDon1 = (DefaultTableModel) tbhd.getModel();
        defaultTableModelHoaDon1.setRowCount(0);
        int stt = 1;
        for (HoaDonViewModel x : hoaDonService.GetAll()) {
            defaultTableModelHoaDon1.addRow(new Object[]{
                stt++,
                x.getIdKH(),
                x.getIdNV(),
                x.getMa(),
                x.getNgayThanhToan(),
                GetTrangThai(x.getTinhTrang())
            });
        }
    }

    private HoaDon GetDataFromGuiHD() {
        try {

            KhachHangVM idKH = (KhachHangVM) cbKhachHang.getSelectedItem();
            NhanVienViewModel idNV = (NhanVienViewModel) cbNhanVien.getSelectedItem();
            String ma = lblID.getText();
            String ntt = lblNgayTao.getText();

            //
            HoaDon hd = new HoaDon();
            hd.setIdKH(idKH.getId());
            hd.setIdNV(idNV.getId());
            hd.setMa(ma);
            hd.setNgayThanhToan(ntt);
            hd.setTinhTrang(0);
            return hd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void LoadHDCT(ArrayList<HoaDonChiTietViewModel> list) {
        defaultTableModelHoaDonChiTiet = (DefaultTableModel) tbhdct.getModel();
        defaultTableModelHoaDonChiTiet.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTietViewModel x : list) {
            defaultTableModelHoaDonChiTiet.addRow(new Object[]{
                stt++, x.getIdHoaDon(), x.getIdChiTietSP(), x.getSoLuong(), x.getDonGia()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnNhanVien = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        lblMo = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        NV = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblChu = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbgiohang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        txtTimkiemDssp = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        txtMS = new javax.swing.JTextField();
        txtNCC = new javax.swing.JTextField();
        txtCL = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btntaohd = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbKhachHang = new javax.swing.JComboBox<KhachHangVM>();
        cbNhanVien = new javax.swing.JComboBox<NhanVienViewModel>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblsdtkhachhang = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        lblTienThanhToan = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        lblNgayTao = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbhdc = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDisplay = new javax.swing.JTextArea();
        btnInHD = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cboidchatlieu = new javax.swing.JComboBox<ChatLieuViewModel>();
        lblid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnXoaSP = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtgianhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tarmota = new javax.swing.JTextArea();
        txtsoluong = new javax.swing.JTextField();
        txtgiaban = new javax.swing.JTextField();
        cboidsp = new javax.swing.JComboBox<SanPhamViewmodel>();
        cboidsize = new javax.swing.JComboBox<SizeVM>();
        cboidmausac = new javax.swing.JComboBox<MauSacViewModel>();
        cboidncc = new javax.swing.JComboBox<NhaCungCapVM>();
        btnthemsp = new javax.swing.JButton();
        btnthemmausac = new javax.swing.JButton();
        btnthemncc = new javax.swing.JButton();
        btnthemchatlieu = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblctsanpham = new javax.swing.JTable();
        txttimkiem = new javax.swing.JTextField();
        cbolocsize = new javax.swing.JComboBox<SizeVM>();
        cbolocmausac = new javax.swing.JComboBox<MauSacViewModel>();
        cbolocchatlieu = new javax.swing.JComboBox<ChatLieuViewModel>();
        btnthemSize = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbhd = new javax.swing.JTable();
        txttimkiem2 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        txttimkiem3 = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbhdct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hệ thống quản lý cửa hàng quần áo MonoShop");
        setBackground(new java.awt.Color(102, 255, 255));
        setName("Hệ thống quản lý quần áo MonoShop"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(102, 255, 255));

        btnNhanVien.setBackground(new java.awt.Color(102, 255, 204));
        btnNhanVien.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNhanVien.setText("Nhân Viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(102, 255, 204));
        btnSanPham.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSanPham.setText("Sản Phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(102, 255, 204));
        btnBanHang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnBanHang.setText("Bán Hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(102, 255, 204));
        btnKhachHang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnKhachHang.setText("Khách Hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(102, 255, 204));
        btnDangXuat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(102, 255, 204));
        btnExit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnHoaDon.setBackground(new java.awt.Color(102, 255, 204));
        btnHoaDon.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHoaDon.setText("Hóa Đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
            .addComponent(btnDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblMo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel9.setBackground(new java.awt.Color(102, 255, 255));

        NV.setBackground(new java.awt.Color(153, 51, 255));
        NV.setForeground(new java.awt.Color(255, 0, 51));

        lblChu.setBackground(new java.awt.Color(102, 255, 255));
        lblChu.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        lblChu.setText("Hệ Thống Quản Lý Cửa Hàng Quần Áo Mono Shop");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(lblChu, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
            .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblChu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NV.addTab("Home", jPanel11);

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbgiohang.setBackground(new java.awt.Color(204, 255, 255));
        tbgiohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Tên SP", "Số lượng ", "Đơn giá", "Thành tiền"
            }
        ));
        tbgiohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbgiohangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbgiohang);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách SP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbSanPham.setBackground(new java.awt.Color(204, 255, 255));
        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID SP", "Sản Phẩm", "Size", "Màu Sắc", "Nhà Cung Cấp", "Chất Liệu", "Số Lượng", "Giá Bán"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSanPham);

        txtTimkiemDssp.setText("Tìm kiếm ...");
        txtTimkiemDssp.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimkiemDsspCaretUpdate(evt);
            }
        });
        txtTimkiemDssp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimkiemDsspMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTimkiemDsspMouseExited(evt);
            }
        });

        txtSize.setText("Tim Kiem Size");
        txtSize.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSizeCaretUpdate(evt);
            }
        });
        txtSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSizeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSizeMouseExited(evt);
            }
        });

        txtMS.setText("Tim Kiem MS");
        txtMS.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMSCaretUpdate(evt);
            }
        });
        txtMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMSMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtMSMouseExited(evt);
            }
        });

        txtNCC.setText("Tim Kiem NCC");
        txtNCC.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNCCCaretUpdate(evt);
            }
        });
        txtNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNCCMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNCCMouseExited(evt);
            }
        });

        txtCL.setText("Tim Kiem CL");
        txtCL.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCLCaretUpdate(evt);
            }
        });
        txtCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCLMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCLMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTimkiemDssp, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMS)
                        .addGap(18, 18, 18)
                        .addComponent(txtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCL, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimkiemDssp, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtSize)
                    .addComponent(txtMS)
                    .addComponent(txtNCC)
                    .addComponent(txtCL))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btntaohd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntaohd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaohdActionPerformed(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(204, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("SĐT Khách Hàng");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Tên Khách Hàng");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Tên Nhân Viên");

        cbKhachHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<KhachHangVM>());
        cbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbKhachHangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbKhachHangMouseExited(evt);
            }
        });
        cbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhachHangActionPerformed(evt);
            }
        });

        cbNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<NhanVienViewModel>());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbKhachHang, 0, 107, Short.MAX_VALUE)
                            .addComponent(cbNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lblsdtkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblsdtkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Mã HD");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Tổng Tiền");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Giảm Giá");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Tiền Thanh Toán");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Tiền Khách Đưa");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Tiền Thừa");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Ngày Tạo");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 51, 0));

        txtGiamGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiamGiaCaretUpdate(evt);
            }
        });

        lblTienThanhToan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTienThanhToan.setForeground(new java.awt.Color(255, 51, 0));

        lblTienThua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 51, 0));

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        lblNgayTao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNgayTao.setForeground(new java.awt.Color(255, 51, 0));

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseClicked(evt);
            }
        });

        btnHuyHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHuyHoaDon.setText("Hủy Hóa Đơn");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyHoaDon)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(44, 44, 44)
                                        .addComponent(btntaohd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTienThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(jLabel15))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btntaohd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(204, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbhdc.setBackground(new java.awt.Color(204, 255, 255));
        tbhdc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Ngày Tạo", "Trạng Thái"
            }
        ));
        tbhdc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbhdcMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbhdc);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        txtDisplay.setColumns(20);
        txtDisplay.setRows(5);
        jScrollPane6.setViewportView(txtDisplay);

        btnInHD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInHD.setText("In \nHóa \nĐơn");
        btnInHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        NV.addTab("BH", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));

        cboidchatlieu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboidchatlieu.setModel(new javax.swing.DefaultComboBoxModel<ChatLieuViewModel>());

        lblid.setText("-");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Quản Lý Sản Phẩm");

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSuaSP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSuaSP.setText("Sửa");
        btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID:");

        btnXoaSP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoaSP.setText("Xóa");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TênSP:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Gía Nhập:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Size:");

        txtgianhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("MauSac:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ncc:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ChatLieu:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Mô tả:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Số lượng:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Gía bán:");

        tarmota.setColumns(20);
        tarmota.setRows(5);
        jScrollPane4.setViewportView(tarmota);

        txtsoluong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtgiaban.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cboidsp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboidsp.setModel(new javax.swing.DefaultComboBoxModel<SanPhamViewmodel>());

        cboidsize.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboidsize.setModel(new javax.swing.DefaultComboBoxModel<SizeVM>());

        cboidmausac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboidmausac.setModel(new javax.swing.DefaultComboBoxModel<MauSacViewModel>());
        cboidmausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboidmausacActionPerformed(evt);
            }
        });

        cboidncc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboidncc.setModel(new javax.swing.DefaultComboBoxModel<NhaCungCapVM>());

        btnthemsp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnthemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemspActionPerformed(evt);
            }
        });

        btnthemmausac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnthemmausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemmausacActionPerformed(evt);
            }
        });

        btnthemncc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnthemncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemnccActionPerformed(evt);
            }
        });

        btnthemchatlieu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnthemchatlieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemchatlieuActionPerformed(evt);
            }
        });

        btnreset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnreset.setText("Reset");
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresetMouseClicked(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblctsanpham.setBackground(new java.awt.Color(204, 255, 255));
        tblctsanpham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblctsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "TênSP", "Size", "Màu Sắc", "NCC", "Chất Liệu", "Số Lượng", "Gía Nhập", "Gía Bán"
            }
        ));
        tblctsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblctsanphamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblctsanpham);

        txttimkiem.setText("Tìm kiếm");
        txttimkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttimkiemCaretUpdate(evt);
            }
        });
        txttimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttimkiemMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txttimkiemMouseExited(evt);
            }
        });

        cbolocsize.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbolocsize.setModel(new javax.swing.DefaultComboBoxModel<SizeVM>());
        cbolocsize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbolocsizeItemStateChanged(evt);
            }
        });

        cbolocmausac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbolocmausac.setModel(new javax.swing.DefaultComboBoxModel<MauSacViewModel>());
        cbolocmausac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbolocmausacItemStateChanged(evt);
            }
        });
        cbolocmausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbolocmausacActionPerformed(evt);
            }
        });

        cbolocchatlieu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbolocchatlieu.setModel(new javax.swing.DefaultComboBoxModel<ChatLieuViewModel>());
        cbolocchatlieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbolocchatlieuItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cbolocsize, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(cbolocmausac, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(cbolocchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                        .addGap(19, 19, 19))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttimkiem)
                    .addComponent(cbolocsize, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(cbolocmausac)
                    .addComponent(cbolocchatlieu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnthemSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(304, 304, 304)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(171, 171, 171)
                                        .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSuaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel7))
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cboidncc, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboidchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboidsp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboidsize, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboidmausac, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnthemncc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnthemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnthemmausac, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnthemchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnthemSize, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnreset)))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsoluong)
                            .addComponent(txtgiaban, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(txtgianhap, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboidncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(lblid))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnreset, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(cboidsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnthemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboidsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addComponent(btnthemSize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(cboidmausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthemmausac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthemncc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboidchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthemchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        NV.addTab("SP", jPanel2);

        jPanel22.setBackground(new java.awt.Color(102, 255, 255));

        jPanel23.setBackground(new java.awt.Color(204, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        tbhd.setBackground(new java.awt.Color(204, 255, 255));
        tbhd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên KH", "Tên NV", "MaHD", "NgayThanhToan", "TrangThai"
            }
        ));
        tbhd.setGridColor(new java.awt.Color(204, 255, 255));
        jScrollPane11.setViewportView(tbhd);

        txttimkiem2.setText("Tìm kiếm ...");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttimkiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txttimkiem2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel24.setBackground(new java.awt.Color(204, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        txttimkiem3.setText("Tìm kiếm ...");

        tbhdct.setBackground(new java.awt.Color(204, 255, 255));
        tbhdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID Hóa Đơn", "ID Chi Tiết SP", "Số lượng ", "Đơn giá"
            }
        ));
        jScrollPane12.setViewportView(tbhdct);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(txttimkiem3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttimkiem3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        NV.addTab("HD", jPanel22);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NV, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NV, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        //NV.setSelectedIndex(1);
        NhanVienForm nv = new NhanVienForm();
        nv.setVisible(true);
        nv.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:
        NV.setSelectedIndex(2);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        // TODO add your handling code here:
        NV.setSelectedIndex(1);

    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        KhachHangForm kh = new KhachHangForm();
        kh.setVisible(true);
        kh.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        FormDangNhap dn = new FormDangNhap();
        dn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:
        NV.setSelectedIndex(3);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnthemSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemSizeActionPerformed
        // TODO add your handling code here:
        SizeForm frms = new SizeForm();
        frms.setVisible(true);
        frms.setLocationRelativeTo(null);
        frms.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_btnthemSizeActionPerformed

    private void cbolocchatlieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbolocchatlieuItemStateChanged
        // TODO add your handling code here:
        int index = cbolocchatlieu.getSelectedIndex();
        String id = _ServiceChatLieu.GetAll().get(index).getId();
        List<CTSanPhamViewModel> listTemp = new ArrayList<>();
        for (CTSanPhamViewModel x : _ServiceCTSP.GetAll()) {
            if (x.getIdChatLieu().getId().equals(id)) {
                listTemp.add(x);
            }
        }
        LoadTableSPNew(listTemp);
    }//GEN-LAST:event_cbolocchatlieuItemStateChanged

    private void cbolocmausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbolocmausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbolocmausacActionPerformed

    private void cbolocmausacItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbolocmausacItemStateChanged
        // TODO add your handling code here:
        int index = cbolocmausac.getSelectedIndex();
        String id = _ServiceMauSac.getAll().get(index).getId();
        List<CTSanPhamViewModel> listTemp = new ArrayList<>();
        for (CTSanPhamViewModel x : _ServiceCTSP.GetAll()) {
            if (x.getIdMauSac().getId().equals(id)) {
                listTemp.add(x);
            }
        }
        LoadTableSPNew(listTemp);
    }//GEN-LAST:event_cbolocmausacItemStateChanged

    private void cbolocsizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbolocsizeItemStateChanged
        // TODO add your handling code here:
        int index = cbolocsize.getSelectedIndex();
        String id = _ServiceSize.getListSize().get(index).getId();
        List<CTSanPhamViewModel> listTemp = new ArrayList<>();
        for (CTSanPhamViewModel x : _ServiceCTSP.GetAll()) {
            if (x.getIdSize().getId().equals(id)) {
                listTemp.add(x);
            }
        }
        LoadTableSPNew(listTemp);
    }//GEN-LAST:event_cbolocsizeItemStateChanged

    private void txttimkiemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttimkiemMouseExited
        // TODO add your handling code here:
        txttimkiem.setText("Tìm kiếm");
        LoadTableSP(null);
    }//GEN-LAST:event_txttimkiemMouseExited

    private void txttimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttimkiemMouseClicked
        // TODO add your handling code here:
        txttimkiem.setText("");
        LoadTableSP(null);
    }//GEN-LAST:event_txttimkiemMouseClicked

    private void txttimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimkiemCaretUpdate
        // TODO add your handling code here:
        if (txttimkiem.getText().isEmpty()) {
            LoadTableSP(null);
            return;
        }
        LoadTableSP(txttimkiem.getText());
    }//GEN-LAST:event_txttimkiemCaretUpdate

    private void tblctsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblctsanphamMouseClicked
        // TODO add your handling code here:
        int index = tblctsanpham.getSelectedRow();
        _IdWhenClick = _ServiceCTSP.GetAll().get(index).getId();

        Double soLuong = (Double) tblctsanpham.getValueAt(index, 6);
        Double giaNhap = (Double) tblctsanpham.getValueAt(index, 7);
        Double giaBan = (Double) tblctsanpham.getValueAt(index, 8);

        SanPhamViewmodel spv = (SanPhamViewmodel) tblctsanpham.getValueAt(index, 1);
        SizeVM svm = (SizeVM) tblctsanpham.getValueAt(index, 2);
        MauSacViewModel msv = (MauSacViewModel) tblctsanpham.getValueAt(index, 3);
        NhaCungCapVM nccv = (NhaCungCapVM) tblctsanpham.getValueAt(index, 4);
        ChatLieuViewModel clv = (ChatLieuViewModel) tblctsanpham.getValueAt(index, 5);
        tarmota.setText(_ServiceCTSP.GetAll().get(index).getMoTa());
        txtsoluong.setText(soLuong.toString());
        txtgianhap.setText(giaNhap.toString());
        txtgiaban.setText(giaBan.toString());

        int soLuongSp = cboidsp.getItemCount();
        for (int i = 0; i < soLuongSp; i++) {
            SanPhamViewmodel spv1 = cboidsp.getItemAt(i);
            if (spv1.getId().equals(spv.getId())) {
                cboidsp.setSelectedIndex(i);
            }
        }
        //
        int soLuongSize = cboidsize.getItemCount();
        for (int i = 0; i < soLuongSize; i++) {
            SizeVM svm1 = cboidsize.getItemAt(i);
            if (svm1.getId().equals(svm.getId())) {
                cboidsize.setSelectedIndex(i);
            }
        }
        //
        int soLuongMs = cboidmausac.getItemCount();
        for (int i = 0; i < soLuongMs; i++) {
            MauSacViewModel msv1 = cboidmausac.getItemAt(i);
            if (msv1.getId().equals(msv.getId())) {
                cboidmausac.setSelectedIndex(i);
            }
        }
        //
        int soLuongNcc = cboidncc.getItemCount();
        for (int i = 0; i < soLuongNcc; i++) {
            NhaCungCapVM ncc1 = cboidncc.getItemAt(i);
            if (ncc1.getId().equals(nccv.getId())) {
                cboidncc.setSelectedIndex(i);
            }
        }
        //
        int soLuongChatLieu = cboidchatlieu.getItemCount();
        for (int i = 0; i < soLuongChatLieu; i++) {
            ChatLieuViewModel cl1 = cboidchatlieu.getItemAt(i);
            if (cl1.getId().equals(clv.getId())) {
                cboidchatlieu.setSelectedIndex(i);
            }
        }
        System.out.println(_IdWhenClick);
    }//GEN-LAST:event_tblctsanphamMouseClicked

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
        // TODO add your handling code here:
        LoadCbo();
        //LoadCboLoc();
    }//GEN-LAST:event_btnresetMouseClicked

    private void btnthemchatlieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemchatlieuActionPerformed
        // TODO add your handling code here:
        FrmChatLieu frmcl = new FrmChatLieu();
        frmcl.setVisible(true);
        frmcl.setLocationRelativeTo(null);
        frmcl.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_btnthemchatlieuActionPerformed

    private void btnthemnccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemnccActionPerformed
        // TODO add your handling code here:
        NhaCungCapForm frmncc = new NhaCungCapForm();
        frmncc.setVisible(true);
        frmncc.setLocationRelativeTo(null);
        frmncc.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_btnthemnccActionPerformed

    private void btnthemmausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemmausacActionPerformed
        // TODO add your handling code here:
        MauSacForm frmms = new MauSacForm();
        frmms.setVisible(true);
        frmms.setLocationRelativeTo(null);
        frmms.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_btnthemmausacActionPerformed

    private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemspActionPerformed
        // TODO add your handling code here:
        SanPhamForm frmsp = new SanPhamForm();
        frmsp.setVisible(true);
        frmsp.setLocationRelativeTo(null);
        frmsp.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_btnthemspActionPerformed

    private void cboidmausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboidmausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboidmausacActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        // TODO add your handling code here:
        CTSanPhamViewModel temp = new CTSanPhamViewModel();
        temp.setId(_IdWhenClick);
        JOptionPane.showMessageDialog(this, _ServiceCTSP.xoa(temp));
        LoadTableSP(null);
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPActionPerformed
        // TODO add your handling code here:
        CTSanPham ctsp = GetDataFromGui();
        ctsp.setId(_IdWhenClick);
        JOptionPane.showMessageDialog(this, _ServiceCTSP.sua(ctsp));
        LoadTableSP(null);
    }//GEN-LAST:event_btnSuaSPActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        CTSanPham ctsp = GetDataFromGui();
        _ServiceCTSP.them(ctsp);
        LoadTableSP(null);
        System.out.println(ctsp);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbhdcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhdcMouseClicked
        // TODO add your handling code here:
        int row = tbhdc.getSelectedRow();
        lblID.setText(tbhdc.getValueAt(row, 1).toString());
        lblNgayTao.setText(tbhdc.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tbhdcMouseClicked

    private void btnLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseClicked
        // TODO add your handling code here:
        //LoadCbo();
        ClearThanhToan();
    }//GEN-LAST:event_btnLamMoiMouseClicked

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        // TODO add your handling code here:
        if (txtTienKhachDua.getText().trim().length() == 0) {
            lblTienThua.setText("0");
        }
        double tienDua = 0;
        try {
            tienDua = Double.parseDouble(txtTienKhachDua.getText());
        } catch (Exception e) {
        }
        double tongTien = Double.parseDouble(lblTienThanhToan.getText());
        double tienThua = tienDua - tongTien;

        lblTienThua.setText(String.valueOf(tienThua));
        if (tienThua < 0) {
            btnThanhToan.setEnabled(false);
        } else {
            btnThanhToan.setEnabled(true);
        }

        //        if (Integer.parseInt(lblTongTien.getText()) >= 100000 && Integer.parseInt(lblTongTien.getText()) <= 150000) {
        //            txtGiamGia.setText(String.valueOf(tongTien * 0.1));
        //
        //        } else if (Integer.parseInt(lblTongTien.getText()) >= 150000 && Integer.parseInt(lblTongTien.getText()) <= 200000) {
        //            txtGiamGia.setText(String.valueOf(tongTien * 0.2));
        //        }
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void txtGiamGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiamGiaCaretUpdate
        // TODO add your handling code here:
        //        if (txtTienKhachDua.getText().trim().length() == 0) {
        //            lblTienThua.setText("0");
        //        }
        double giamGia = 1;
        try {
            giamGia = Double.parseDouble(txtGiamGia.getText());
        } catch (Exception e) {
        }
        double tongTien = Double.parseDouble(lblTongTien.getText());
        double tienThanhToan = tongTien - giamGia * tongTien;
        lblTienThanhToan.setText(String.valueOf(tienThanhToan));
        //        if (giamGia < 0) {
        //            btnThanhToan.setEnabled(false);
        //        } else {
        //            btnThanhToan.setEnabled(true);
        //        }
    }//GEN-LAST:event_txtGiamGiaCaretUpdate

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        NhanVienForm nv = new NhanVienForm();
        nv.setVisible(true);
        nv.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        KhachHangForm kh = new KhachHangForm();
        kh.setVisible(true);
        kh.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhachHangActionPerformed
        // TODO add your handling code here:
        KhachHangVM idkh = (KhachHangVM) cbKhachHang.getSelectedItem();
        lblsdtkhachhang.setText(idkh.getSdt());
    }//GEN-LAST:event_cbKhachHangActionPerformed

    private void btntaohdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaohdActionPerformed
        // TODO add your handling code here:
        HoaDonChoViewModel hdc = new HoaDonChoViewModel();
        for (int i = 1; i < listHDC.size() + 2; i++) {
            hdc.setMaHD("HD" + i);
            hdc.setNgayTao(java.time.LocalDate.now().toString());
        }
        hdc.setTrangThai(1);
        listHDC.add(hdc);
        LoadHoaDonCho();


    }//GEN-LAST:event_btntaohdActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        int row1 = tbhdc.getSelectedRow();
        listHDC.remove(row1);
        LoadHoaDonCho();
        int row2 = tbgiohang.getSelectedRow();
        list.remove(row2);
        LoadGioHang(list);
        HoaDon hd = GetDataFromGuiHD();
        hoaDonService.them(hd);
        //getData();
        LoadHoaDon();
        System.out.println(hd.getIdKH());
        JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");

        //        int rowhd = tbhdc.getSelectedRow();
        //        HoaDonViewModel hd = hoaDonService.getAll().get(rowhd);
        //        String MaHD = hd.getMa();
        //        hoaDonService.update(MaHD);
        //        //JOptionPane.showMessageDialog(this, hoaDonService.update(MaHD));
        //
        //        defaultTableModelGioHang = (DefaultTableModel) tbgiohang.getModel();
        //        defaultTableModelGioHang.setRowCount(0);
        //        //LoadHoaDonCho(hoaDonRepo.GetAll());
        //        HoaDonViewModel hdvm = new HoaDonViewModel();
        //        hdvm.setMa(tbhdc.getValueAt(rowhd, 1).toString());
        //        hdvm.setNgayThanhToan(tbhdc.getValueAt(rowhd, 2).toString());
        //
        //        ArrayList<HoaDonViewModel> listhd = new ArrayList<>();
        //        for (HoaDonViewModel x : hoaDonService.getAll()) {
        //            if (x.getTinhTrang() == 0) {
        //                listhd.add(x);
        //            }
        //        }
        //        LoadHoaDon(listhd);
        //        JOptionPane.showMessageDialog(this, "Thanh toan thanh cong");
        //        this.ClearThanhToan();
        txtDisplay.setText("                                         Mono Shop\n" + "                              ------------------------------\n" + "                                  Hóa Đơn Bán Hàng\n" + "____________________******___________________\n" + "Tổng Tiền:          " + lblTongTien.getText() + "\nGiảm Giá:           " + txtGiamGia.getText() + "\nTiền Thanh Toán:    " + lblTienThanhToan.getText() + "\nTiền Khách Đưa:     " + txtTienKhachDua.getText() + "\nTiền Thừa:          " + lblTienThua.getText() + "\nNgày Tạo:           " + lblNgayTao.getText() + "\n                             Cảm Ơn Quý Khách");
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void docFile() throws FileNotFoundException, IOException, DocumentException {
        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream("HoaDon.pdf"));

            document.open();

            document.add(new Paragraph(txtDisplay.getText()));

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void txtCLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCLMouseExited
        // TODO add your handling code here:
        txtCL.setText("Tim Kiem CL");
        LoadTableDSSP(null);
    }//GEN-LAST:event_txtCLMouseExited

    private void txtCLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCLMouseClicked
        // TODO add your handling code here:
        txtCL.setText("");
    }//GEN-LAST:event_txtCLMouseClicked

    private void txtCLCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCLCaretUpdate
        // TODO add your handling code here:
        if (txtCL.getText().isEmpty()) {
            LoadTableLocDSSPChatLieu(null);
            return;
        }
        LoadTableLocDSSPChatLieu(txtCL.getText());
    }//GEN-LAST:event_txtCLCaretUpdate

    private void txtNCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNCCMouseExited
        // TODO add your handling code here:
        txtNCC.setText("Tim Kiem NCC");
        LoadTableDSSP(null);
    }//GEN-LAST:event_txtNCCMouseExited

    private void txtNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNCCMouseClicked
        // TODO add your handling code here:
        txtNCC.setText("");
    }//GEN-LAST:event_txtNCCMouseClicked

    private void txtNCCCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNCCCaretUpdate
        // TODO add your handling code here:
        if (txtNCC.getText().isEmpty()) {
            LoadTableLocDSSPNcc(null);
            return;
        }
        LoadTableLocDSSPNcc(txtNCC.getText());
    }//GEN-LAST:event_txtNCCCaretUpdate

    private void txtMSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMSMouseExited
        // TODO add your handling code here:
        txtMS.setText("Tim Kiem MS");
        LoadTableDSSP(null);
    }//GEN-LAST:event_txtMSMouseExited

    private void txtMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMSMouseClicked
        // TODO add your handling code here:
        txtMS.setText("");
    }//GEN-LAST:event_txtMSMouseClicked

    private void txtMSCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMSCaretUpdate
        // TODO add your handling code here:
        if (txtMS.getText().isEmpty()) {
            LoadTableLocDSSPMauSac(null);
            return;
        }
        LoadTableLocDSSPMauSac(txtMS.getText());
    }//GEN-LAST:event_txtMSCaretUpdate

    private void txtSizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSizeMouseExited
        // TODO add your handling code here:
        txtSize.setText("Tim Kiem Size");
        LoadTableDSSP(null);
    }//GEN-LAST:event_txtSizeMouseExited

    private void txtSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSizeMouseClicked
        // TODO add your handling code here:
        txtSize.setText("");
    }//GEN-LAST:event_txtSizeMouseClicked

    private void txtSizeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSizeCaretUpdate
        // TODO add your handling code here:
        //        findMS = cbMauSac.getSelectedItem().toString();
        //        findMS();
        if (txtSize.getText().isEmpty()) {
            LoadTableLocDSSPSize(null);
            return;
        }
        LoadTableLocDSSPSize(txtSize.getText());
    }//GEN-LAST:event_txtSizeCaretUpdate

    private void txtTimkiemDsspMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimkiemDsspMouseExited
        // TODO add your handling code here:
        txtTimkiemDssp.setText("Tìm kiếm ...");
        LoadDSSP(null);
    }//GEN-LAST:event_txtTimkiemDsspMouseExited

    private void txtTimkiemDsspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimkiemDsspMouseClicked
        // TODO add your handling code here:
        txtTimkiemDssp.setText("");
    }//GEN-LAST:event_txtTimkiemDsspMouseClicked

    private void txtTimkiemDsspCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimkiemDsspCaretUpdate
        // TODO add your handling code here:
        if (txtTimkiemDssp.getText().isEmpty()) {
            LoadDSSP(null);
            return;
        }
        LoadDSSP(txtTimkiemDssp.getText());
    }//GEN-LAST:event_txtTimkiemDsspCaretUpdate

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        // TODO add your handling code here:
        int sl;
        int row = tbSanPham.getSelectedRow();
        GioHangViewModel gioHangViewModel = new GioHangViewModel();
        int slton = Integer.parseInt(tbSanPham.getValueAt(row, 7).toString());
        gioHangViewModel.setMaSP((String) tbSanPham.getValueAt(row, 1));
        gioHangViewModel.setTenSP((String) tbSanPham.getValueAt(row, 2));
        sl = Integer.parseInt(JOptionPane.showInputDialog("Moi nhap so luong: "));
        gioHangViewModel.setSoLuong(sl);
        System.out.println(sl);
        gioHangViewModel.setDonGia((Double) tbSanPham.getValueAt(row, 8));
        list.add(gioHangViewModel);
        LoadGioHang(list);
        tbSanPham.setValueAt(slton - sl, row, 7);
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void tbgiohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbgiohangMouseClicked
        // TODO add your handling code here:
        int row = tbgiohang.getSelectedRow();
        lblTongTien.setText(tbgiohang.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tbgiohangMouseClicked

    private void btnInHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHDActionPerformed
        try {
            // TODO add your handling code here:
            this.docFile();
            JOptionPane.showMessageDialog(this, "Xuất file PDF thành công");
        } catch (IOException ex) {
            Logger.getLogger(FormMenuChinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(FormMenuChinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInHDActionPerformed

    private void cbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbKhachHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKhachHangMouseClicked

    private void cbKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbKhachHangMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKhachHangMouseExited

    public void ClearThanhToan() {
        lblID.setText("");
        lblTongTien.setText("");
        txtGiamGia.setText("");
        txtTienKhachDua.setText("");
        lblTienThanhToan.setText("");
        lblTienThua.setText("");
        lblNgayTao.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMenuChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenuChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenuChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenuChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuChinh().setVisible(true);
            }
        });
    }

//    public String checkHDC() {
//        if (hoaDonService.getAll().size() >= 10) {
//            JOptionPane.showMessageDialog(this, "Hóa đơn chờ không quá 10");
//
//        } else {
//            //LoadHoaDonCho(hoaDonRepo.GetAll());
//        }
//        return null;
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane NV;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnInHD;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btntaohd;
    private javax.swing.JButton btnthemSize;
    private javax.swing.JButton btnthemchatlieu;
    private javax.swing.JButton btnthemmausac;
    private javax.swing.JButton btnthemncc;
    private javax.swing.JButton btnthemsp;
    private javax.swing.JComboBox<KhachHangVM> cbKhachHang;
    private javax.swing.JComboBox<NhanVienViewModel> cbNhanVien;
    private javax.swing.JComboBox<ChatLieuViewModel> cboidchatlieu;
    private javax.swing.JComboBox<MauSacViewModel> cboidmausac;
    private javax.swing.JComboBox<NhaCungCapVM> cboidncc;
    private javax.swing.JComboBox<SizeVM> cboidsize;
    private javax.swing.JComboBox<SanPhamViewmodel> cboidsp;
    private javax.swing.JComboBox<ChatLieuViewModel> cbolocchatlieu;
    private javax.swing.JComboBox<MauSacViewModel> cbolocmausac;
    private javax.swing.JComboBox<SizeVM> cbolocsize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblChu;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMo;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblTienThanhToan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblsdtkhachhang;
    private javax.swing.JTextArea tarmota;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tbgiohang;
    private javax.swing.JTable tbhd;
    private javax.swing.JTable tbhdc;
    private javax.swing.JTable tbhdct;
    private javax.swing.JTable tblctsanpham;
    private javax.swing.JTextField txtCL;
    private javax.swing.JTextArea txtDisplay;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMS;
    private javax.swing.JTextField txtNCC;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimkiemDssp;
    private javax.swing.JTextField txtgiaban;
    private javax.swing.JTextField txtgianhap;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttimkiem2;
    private javax.swing.JTextField txttimkiem3;
    // End of variables declaration//GEN-END:variables
}
