package ui.master;

import connect.KoneksiDatabase;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import main.Main;
import model.Kategori;
import org.apache.log4j.Logger;
import service.KategoriService;
import service.impl.KategoriServiceImpl;
import ui.renderer.TableCellRenderCenterAlignment;

public class KategoriPanel extends javax.swing.JInternalFrame {

    private Logger log = Logger.getLogger(KategoriPanel.class);
    private KoneksiDatabase koneksiDB = new KoneksiDatabase();
    private KategoriService kategoriService = new KategoriServiceImpl(koneksiDB);
    private Kategori kategori;
    private KategoriTableModel kategoriTableModel;
    
    public KategoriPanel() {
        initComponents();
        refreshTable();
    }
    
    public void refreshTable(){
        List<Kategori> listKategori = kategoriService.getAllKategori();
        kategoriTableModel = new KategoriTableModel(listKategori);
        tblKategori.setModel(kategoriTableModel);
        tblKategori.getColumnModel().getColumn(0).setCellRenderer( new TableCellRenderCenterAlignment());
    }
    
    public void setData(){        
        kategori.setKodeKategori(txtKodeKategori.getText());
        kategori.setKategori(txtKategori.getText());         
    }
    
    public boolean validateData(){
        if(txtKodeKategori.getText() != null && txtKodeKategori.getText().length() > 0 
                && txtKategori.getText() != null && txtKategori.getText().length() > 0){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Semua textfield harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public void clearData(){
        txtKodeKategori.setText("");
        txtKategori.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKategori = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtKodeKategori = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtKategori = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Data Kategori Barang");
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKategori);

        jLabel1.setText("Kode Kategori");

        jLabel2.setText("Kategori");

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuManuaEdit.png"))); // NOI18N
        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKodeKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(txtKategori)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKeluar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnClear)
                    .addComponent(btnKeluar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Main.getFrame().kategoriPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tblKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKategoriMouseClicked
        // TODO add your handling code here:
        int i = tblKategori.getSelectedRow();
        String kodeKategoriT = (String) kategoriTableModel.getValueAt(i, 1);
        txtKodeKategori.setText(kodeKategoriT);
        String kategoriT = (String) kategoriTableModel.getValueAt(i, 2);
        txtKategori.setText(kategoriT);
    }//GEN-LAST:event_tblKategoriMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().kategoriPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(kategori == null){
            kategori = new Kategori();
        }
        int i = tblKategori.getSelectedRow();

        if(i > -1){
            int validateDelete = JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ?",
                "Konfirmasi penghapusan data", JOptionPane.YES_NO_OPTION);
            if(validateDelete == 0){
                Integer idKategori = (Integer) kategoriTableModel.getValueAt(i, 0);
                kategori.setIdKategori(idKategori);
                kategoriService.hapus(kategori);
                refreshTable();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Pilih baris pada tabel yang mau dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        if(kategori == null){
            kategori = new Kategori();
        }
        int i = tblKategori.getSelectedRow();
        if(i > -1){
            setData();
            Integer idKategori = (Integer) kategoriTableModel.getValueAt(i, 0);
            kategori.setIdKategori(idKategori);
            kategoriService.ubah(kategori);
            refreshTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Pilih baris pada tabel yang mau diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(kategori == null){
            kategori = new Kategori();
        }
        if(validateData()){
            setData();
            kategoriService.simpan(kategori);
            refreshTable();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private class KategoriTableModel extends AbstractTableModel{
        private List<Kategori> listKategori = new ArrayList<Kategori>();
        
        public KategoriTableModel(List<Kategori> listK){
            this.listKategori = listK;
        } 
        
        public int getRowCount(){
            return listKategori.size();
        }
        
        public int getColumnCount(){
            return 3;
        }
        
        public Object getValueAt(int baris, int kolom){
            Kategori kategori = listKategori.get(baris);
            if(kolom == 0){
                return kategori.getIdKategori();
            }
            if(kolom == 1){
                return kategori.getKodeKategori();
            }
            if(kolom == 2){
                return kategori.getKategori();
            }
            return "";
        }
        
        public String getColumnName(int kolom){
            if(kolom == 0){
                return "ID Kategori";
            }
            if(kolom == 1){
                return "Kode Kategori";
            }
            if(kolom == 2){
                return "Kategori";
            }
            return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKategori;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextField txtKodeKategori;
    // End of variables declaration//GEN-END:variables
}
