package ui.transaction;

import connect.KoneksiDatabase;
import dao.PenjualanDao;
import java.awt.Component;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import main.Main;
import model.Pakaian;
import model.Penjualan;
import service.PenjualanService;
import service.impl.PenjualanServiceImpl;
import ui.renderer.TableCellRenderCenterAlignment;
import ui.renderer.TableCellRenderDate;
import ui.renderer.TableCellRenderDouble;

public class PenjualanPanel extends javax.swing.JInternalFrame {

    private KoneksiDatabase koneksiDB = new KoneksiDatabase();    
    private PenjualanService penjualanService = new PenjualanServiceImpl(koneksiDB);
    private Pakaian pakaian;
    private Penjualan penjualan;    
    private PenjualanTableModel penjualanTableModel;
    
    public PenjualanPanel() {
        initComponents();        
        setEditable(false);
        setComboBox();
        refreshTable();   
        
    }
   
    public void setRenderer(){
        tblPenjualan.getColumnModel().getColumn(4).setCellRenderer( new TableCellRenderDate());   
        tblPenjualan.getColumnModel().getColumn(6).setCellRenderer( new TableCellRenderDouble());
        tblPenjualan.getColumnModel().getColumn(7).setCellRenderer( new TableCellRenderDouble());
        tblPenjualan.getColumnModel().getColumn(0).setCellRenderer( new TableCellRenderCenterAlignment());
        tblPenjualan.getColumnModel().getColumn(5).setCellRenderer( new TableCellRenderCenterAlignment());  
    }
    public void refreshTable(){
        List<Penjualan> dataPenjualan = penjualanService.getAllPenjualan();
        penjualanTableModel = new PenjualanTableModel(dataPenjualan);
        // masukan ke tabel        
        tblPenjualan.setModel(penjualanTableModel);
        setRenderer();
    }
    
    // kode merk
    public void setComboBox(){
        List<Pakaian> showToCombo = penjualanService.fillComboBox();
        for(Pakaian pak : showToCombo){
            cmbKodeMerk.addItem(pak.getKodeMerk());
        }        
    }
        
    public void clearData(){        
        txtMerk.setText("");
        txtKategori.setText("");
        txtTipe.setText("");
        txtJenis.setText("");
        txtJumlah.setText("");
        txtHargaBeli.setText("");
        txtHargaJual.setText("");
    }
    
    public void setEditable(boolean status){        
        txtMerk.setEnabled(status);
        txtKategori.setEnabled(status);
        txtTipe.setEnabled(status);
        txtJenis.setEnabled(status);
        txtHargaBeli.setEnabled(status);
        txtHargaJual.setEnabled(status);
    }
  
    public boolean validateData(){
        if(txtMerk.getText() != null && txtMerk.getText().length() > 0 
                && txtKategori != null && txtKategori.getText().length() > 0 && txtTipe.getText() != null 
                && txtTipe.getText().length() > 0 && txtJenis.getText() != null & txtJenis.getText().length() > 0 
                && txtJumlah.getText() != null && txtJumlah.getText().length() > 0 && txtHargaBeli.getText() != null
                && txtHargaBeli.getText().length() > 0 && txtHargaJual.getText() != null && txtHargaJual.getText().length() > 0){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Pilih kode merk dan quantity tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbKodeMerk = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMerk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKategori = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTipe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHargaBeli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtHargaJual = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPenjualan = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Transaksi Penjualan");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Data"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        cmbKodeMerk.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbKodeMerkPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setText("Kode Merk");

        jLabel2.setText("Merk");

        jLabel3.setText("Kategori");

        jLabel4.setText("Tipe");

        jLabel5.setText("Jenis");

        txtJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJenisActionPerformed(evt);
            }
        });

        jLabel7.setText("Jumlah");

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahKeyTyped(evt);
            }
        });

        jLabel8.setText("Harga Beli");

        jLabel9.setText("Harga Jual");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbKodeMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(17, 17, 17)
                        .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKodeMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        tblPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Merk", "Tanggal", "Quantity", "Harga beli", "Harga Jual"
            }
        ));
        tblPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPenjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPenjualan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudelete.png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuClear.png"))); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudoor.png"))); // NOI18N
        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnKeluar)
                        .addContainerGap(254, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnClear)
                    .addComponent(btnKeluar))
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Main.getFrame().penjualanPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    public void setData(){      
        penjualan.setKodeMerk((String) cmbKodeMerk.getSelectedItem());
        penjualan.setMerk(txtMerk.getText());
        penjualan.setJenis(txtJenis.getText());          
        List<Pakaian> listPakaian = penjualanService.validateStock(penjualan);
        penjualan.setJumlah( new Integer(txtJumlah.getText()));
        for(Pakaian pakaian : listPakaian){
            if(penjualan.getJumlah() > pakaian.getStok()){
                JOptionPane.showMessageDialog(null, "Stok barang tidak mencukupi", "Peringatan", JOptionPane.WARNING_MESSAGE);
                
            }
            else{
                penjualan.setHargaBeli( new BigDecimal(txtHargaBeli.getText()));
                penjualan.setHargaJual( new BigDecimal(txtHargaJual.getText()));
                BigDecimal hargaBeli = new BigDecimal(txtHargaBeli.getText());
                BigDecimal hargaJual = new BigDecimal(txtHargaJual.getText());
                BigDecimal totalBeli = hargaBeli.multiply( new BigDecimal(txtJumlah.getText()));
                penjualan.setTotalBeli(totalBeli);
                BigDecimal subTotal = hargaJual.multiply(new BigDecimal(txtJumlah.getText())); 
                penjualan.setSubTotal(subTotal);  
            }
        }  
    }
    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        if(validateData()){
            if(penjualan == null){
                penjualan = new Penjualan();
            }
            setData();      
            try{
                penjualanService.simpan(penjualan);  
                penjualan = null;
                refreshTable();
                clearData();
            } catch(Exception ex){
                ex.printStackTrace();
            }            
        }       
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:    
        int i = tblPenjualan.getSelectedRow();
        if(penjualan == null){
            penjualan = new Penjualan();
        }        
        if(i > -1){            
            Integer idPenjualan = (Integer) penjualanTableModel.getValueAt(i, 0);
            penjualan.setIdPenjualan(idPenjualan);
            int validateDelete = JOptionPane.showConfirmDialog(null, "Apakah anda yakin mau menghapus data ?", "Peringatan", JOptionPane.YES_NO_OPTION);
            if(validateDelete == 0){
                penjualanService.hapus(penjualan);
                refreshTable();                
            }            
        }
        else{
            JOptionPane.showMessageDialog(null, "Pilih baris yang mau dihapus", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPenjualanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPenjualanMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().penjualanPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void txtJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyTyped
        // TODO add your handling code here:
        // membatasi length angka
        if(txtJumlah.getText().length() > 5){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtJumlahKeyTyped

    private void txtJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJenisActionPerformed

    private void cmbKodeMerkPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbKodeMerkPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        // jika true eksekusi
        if(pakaian == null){
            pakaian = new Pakaian();
        }
        String item = (String) cmbKodeMerk.getSelectedItem();
        pakaian.setKodeMerk(item);
        List<Pakaian> setText = penjualanService.setTextFromPakaian(pakaian);
        for(Pakaian pak : setText){
            txtMerk.setText(pak.getMerk());
            txtKategori.setText(pak.getKategori());
            txtTipe.setText(pak.getTipe());
            txtJenis.setText(pak.getJenis());
            txtHargaBeli.setText(pak.getHargaBeli().toString());
            txtHargaJual.setText(pak.getHargaJual().toString());
        }
    }//GEN-LAST:event_cmbKodeMerkPopupMenuWillBecomeInvisible

    
    private class PenjualanTableModel extends AbstractTableModel{
        private List<Penjualan> dataPenjualan;

        public PenjualanTableModel(List<Penjualan> dataPen){
            this.dataPenjualan = dataPen;
        }    
        
        public int getRowCount(){
            return dataPenjualan.size(); 
        }
        public int getColumnCount(){
            return 8;    
        }
        
        public Object getValueAt(int i, int k){
            Penjualan penjualan = dataPenjualan.get(i);
            if(k == 0){
                return penjualan.getIdPenjualan();
            }
            if(k == 1){
                return penjualan.getKodeMerk();
            }
            if(k == 2){
                return penjualan.getMerk();
            }
            if(k == 3){
                return penjualan.getJenis();
            }
            if(k == 4){
                return penjualan.getTanggal();
            }
            if(k == 5){
                return penjualan.getJumlah();
            }
            if(k == 6){
                return penjualan.getHargaJual();
            }        
            if(k == 7){
                return penjualan.getSubTotal();
            }       
            
            return ""; // return nothing
        }   
        
        public String getColumnName(int k){
            if(k == 0){
                return "ID Penjualan";
            }
            if(k == 1){
                return "Kode Merk";
            }
            if(k == 2){
                return "Merk";
            }
            if(k == 3){
                return "Jenis";
            }
            if(k == 4){
                return "Tanggal";
            }
            if(k == 5){
                return "Jumlah";
            }        
            if(k == 6){
                return "Harga Jual";
            }        
            if(k == 7){
                return "Subtotal";
            }                 
            return "";
        }
    }      
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbKodeMerk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPenjualan;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtTipe;
    // End of variables declaration//GEN-END:variables
}
