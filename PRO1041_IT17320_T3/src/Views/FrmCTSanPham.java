/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModel.CTSanPham;
import DomainModel.ChatLieu;
import Services.CTSanPhamService;
import Services.ChatLieuService;
import Services.MauSacService;
import Services.NhaCungCapService;
import Services.SanPhamService;
import Services.SizeService;
import Services.impl.CTSanPhamServiceImpl;
import Services.impl.ChatLieuServiceImpl;
import Services.impl.MauSacServiceImpl;
import Services.impl.NhaCungCapServiceimpl;
import Services.impl.SanPhamServiceImpl;
import Services.impl.SizeServiceImpl;
import ViewModels.CTSanPhamViewModel;
import ViewModels.ChatLieuViewModel;
import ViewModels.MauSacViewModel;
import ViewModels.NhaCungCapVM;
import ViewModels.SanPhamViewmodel;
import ViewModels.SizeVM;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lvh9x
 */
public class FrmCTSanPham extends javax.swing.JFrame {

    private ChatLieuService _ServiceChatLieu;
    private MauSacService _ServiceMauSac;
    private NhaCungCapService _ServiceNcc;
    private SizeService _ServiceSize;
    private SanPhamService _ServiceSanPham;

    private CTSanPhamService _ServiceCTSP;
    //
    private DefaultTableModel _DefaultTableModel;
    //
    private DefaultComboBoxModel _dcbmMauSac;
    private DefaultComboBoxModel _dcbmChatLieu;
    private DefaultComboBoxModel _dcbmSanPham;
    private DefaultComboBoxModel _dcbmNcc;
    private DefaultComboBoxModel _dcbmSize;

    private String _IdWhenClick;

    /**
     * Creates new form FrmCTSanPham
     */
    public FrmCTSanPham() {
        initComponents();
        _ServiceCTSP = new CTSanPhamServiceImpl();
        _ServiceChatLieu = new ChatLieuServiceImpl();
        _ServiceMauSac = new MauSacServiceImpl();
        _ServiceNcc = new NhaCungCapServiceimpl();
        _ServiceSize = new SizeServiceImpl();
        _ServiceSanPham = new SanPhamServiceImpl();

        _dcbmChatLieu = (DefaultComboBoxModel) cboidchatlieu.getModel();
        _dcbmMauSac = (DefaultComboBoxModel) cboidmausac.getModel();
        _dcbmNcc = (DefaultComboBoxModel) cboidncc.getModel();
        _dcbmSize = (DefaultComboBoxModel) cboidsize.getModel();
        _dcbmSanPham = (DefaultComboBoxModel) cboidsp.getModel();
        LoadTable();
        LoadCbo();
    }

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

    public void LoadCbo() {

        cboidchatlieu.removeAllItems();
        List<ChatLieuViewModel> dsChatLieu = _ServiceChatLieu.GetAll();
        for (ChatLieuViewModel chatLieuViewModel : dsChatLieu) {
            cboidchatlieu.addItem(chatLieuViewModel);
        }

        //
        cboidmausac.removeAllItems();
        List<MauSacViewModel> dsMauSac = _ServiceMauSac.getAll();
        for (MauSacViewModel mauSac : dsMauSac) {
            cboidmausac.addItem(mauSac);
        }
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
        cboidsp.removeAllItems();
        List<SanPhamViewmodel> dsSp = _ServiceSanPham.getAll();
        for (SanPhamViewmodel sanPhamViewmodel : dsSp) {
            cboidsp.addItem(sanPhamViewmodel);
        }
    }

    public void LoadTable() {
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
                x.getGiaBan(),
                x.getGiaNhap()
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblctsanpham = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tarmota = new javax.swing.JTextArea();
        txtsoluong = new javax.swing.JTextField();
        txtgiaban = new javax.swing.JTextField();
        cboidsp = new javax.swing.JComboBox<SanPhamViewmodel>();
        cboidsize = new javax.swing.JComboBox<SizeVM>();
        cboidmausac = new javax.swing.JComboBox<MauSacViewModel>();
        cboidncc = new javax.swing.JComboBox<NhaCungCapVM>();
        cboidchatlieu = new javax.swing.JComboBox<ChatLieuViewModel>();
        lblid = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtgianhap = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Chi Tiết Sản Phẩm");

        tblctsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
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
        jScrollPane1.setViewportView(tblctsanpham);

        jLabel2.setText("ID:");

        jLabel3.setText("TênSP:");

        jLabel4.setText("Size:");

        jLabel5.setText("MauSac:");

        jLabel6.setText("Ncc:");

        jLabel7.setText("ChatLieu:");

        jLabel8.setText("Mô tả:");

        jLabel9.setText("Số lượng:");

        jLabel10.setText("Gía bán:");

        tarmota.setColumns(20);
        tarmota.setRows(5);
        jScrollPane2.setViewportView(tarmota);

        cboidsp.setModel(new javax.swing.DefaultComboBoxModel<SanPhamViewmodel>());

        cboidsize.setModel(new javax.swing.DefaultComboBoxModel<SizeVM>());

        cboidmausac.setModel(new javax.swing.DefaultComboBoxModel<MauSacViewModel>());
        cboidmausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboidmausacActionPerformed(evt);
            }
        });

        cboidncc.setModel(new javax.swing.DefaultComboBoxModel<NhaCungCapVM>());

        cboidchatlieu.setModel(new javax.swing.DefaultComboBoxModel<ChatLieuViewModel>());

        lblid.setText("-");

        txttimkiem.setText("Tìm kiếm....");

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jLabel11.setText("Gía Nhập:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboidchatlieu, 0, 173, Short.MAX_VALUE)
                                            .addComponent(cboidncc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(33, 33, 33)
                                                        .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(57, 57, 57)
                                                        .addComponent(cboidsp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cboidsize, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboidmausac, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtsoluong)
                                            .addComponent(txtgiaban, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnthem)
                                                .addGap(35, 35, 35)
                                                .addComponent(btnsua)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnxoa))
                                            .addComponent(txtgianhap, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(lblid))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboidsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboidsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboidmausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboidncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboidchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem)
                            .addComponent(btnsua)
                            .addComponent(btnxoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboidmausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboidmausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboidmausacActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        CTSanPham ctsp = GetDataFromGui();
        _ServiceCTSP.them(ctsp);
        LoadTable();
        System.out.println(ctsp);
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        CTSanPham ctsp = GetDataFromGui();
        ctsp.setId(_IdWhenClick);
        JOptionPane.showMessageDialog(this, _ServiceCTSP.sua(ctsp));
        LoadTable();

    }//GEN-LAST:event_btnsuaActionPerformed

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

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        CTSanPhamViewModel temp = new CTSanPhamViewModel();
        temp.setId(_IdWhenClick);
        JOptionPane.showMessageDialog(this, _ServiceCTSP.xoa(temp));
        LoadTable();
    }//GEN-LAST:event_btnxoaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCTSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCTSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCTSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCTSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCTSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<ChatLieuViewModel> cboidchatlieu;
    private javax.swing.JComboBox<MauSacViewModel> cboidmausac;
    private javax.swing.JComboBox<NhaCungCapVM> cboidncc;
    private javax.swing.JComboBox<SizeVM> cboidsize;
    private javax.swing.JComboBox<SanPhamViewmodel> cboidsp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextArea tarmota;
    private javax.swing.JTable tblctsanpham;
    private javax.swing.JTextField txtgiaban;
    private javax.swing.JTextField txtgianhap;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
