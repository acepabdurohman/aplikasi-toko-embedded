package ui.master;

import connect.KoneksiDatabase;
import dao.PengeluaranDao;
import java.awt.Component;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import main.Main;
import model.Pengeluaran;
import service.PengeluaranService;
import service.impl.PengeluaranServiceImpl;
import ui.renderer.TableCellRenderCenterAlignment;
import ui.renderer.TableCellRenderDate;
import ui.renderer.TableCellRenderDouble;

public class PengeluaranPanel extends javax.swing.JInternalFrame {
    private KoneksiDatabase koneksiDB = new KoneksiDatabase();    
    private PengeluaranService pengeluaranService = new PengeluaranServiceImpl(koneksiDB);
    private PengeluaranTableModel pengeluaranTableModel;
    private Pengeluaran pengeluaran;
            
    public PengeluaranPanel() {
        initComponents();
        refreshTable();
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtJenisPengeluaran = new javax.swing.JTextField();
        txtBiayaPengeluaran = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPengeluaran = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Data Pengeluaran");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Jenis Pengeluaran");

        jLabel2.setText("Biaya Pengeluaran");

        txtBiayaPengeluaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBiayaPengeluaranKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBiayaPengeluaranKeyTyped(evt);
            }
        });

        tblPengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPengeluaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPengeluaran);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKeluar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtJenisPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(txtBiayaPengeluaran))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtJenisPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBiayaPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnClear)
                    .addComponent(btnKeluar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void refreshTable(){
        List<Pengeluaran> listPengeluaran = pengeluaranService.getAllPengeluaran();
        pengeluaranTableModel = new PengeluaranTableModel(listPengeluaran);
        tblPengeluaran.setModel(pengeluaranTableModel);
        rendererData();
    }
    
    public void rendererData(){
        tblPengeluaran.getColumnModel().getColumn(0).setCellRenderer( new TableCellRenderCenterAlignment());
        tblPengeluaran.getColumnModel().getColumn(1).setCellRenderer( new TableCellRenderDate());
        tblPengeluaran.getColumnModel().getColumn(3).setCellRenderer( new TableCellRenderDouble());        
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Main.getFrame().pengeluaranPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    public void setData(){
        
        pengeluaran.setJenisPengeluaran(txtJenisPengeluaran.getText());
        pengeluaran.setBiayaPengeluaran( new BigDecimal(txtBiayaPengeluaran.getText()));
                
    }
    
    public void clearData(){
        txtJenisPengeluaran.setText("");
        txtBiayaPengeluaran.setText("");
    }
    
    public boolean validateData(){
        if(txtJenisPengeluaran.getText() != null && txtJenisPengeluaran.getText().length() > 0 
                && txtBiayaPengeluaran.getText() != null && txtBiayaPengeluaran.getText().length() > 0){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Semua text field harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(pengeluaran == null){
            pengeluaran = new Pengeluaran();
        }
        if(validateData()){
            setData();
            try{
                pengeluaranService.simpan(pengeluaran);
                refreshTable();
            } catch(Exception exe){
                exe.printStackTrace();
            }    
        }       
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtBiayaPengeluaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBiayaPengeluaranKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBiayaPengeluaranKeyPressed

    private void txtBiayaPengeluaranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBiayaPengeluaranKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
        
            evt.consume();
        }
    }//GEN-LAST:event_txtBiayaPengeluaranKeyTyped

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        int i = tblPengeluaran.getSelectedRow();
        if(pengeluaran == null){
                pengeluaran = new Pengeluaran();
        }
        // kalau baris terseleksi
        if(i > -1){            
            try{
                setData();
                Integer idPengeluaran = (Integer) pengeluaranTableModel.getValueAt(i, 0);
                pengeluaran.setIdPengeluaran(idPengeluaran);
                pengeluaranService.ubah(pengeluaran);
                refreshTable();
            } catch(Exception ex){
                ex.printStackTrace();
            }            
        }
        else{
            JOptionPane.showMessageDialog(null, "Pilih baris yang mau diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPengeluaranMouseClicked
        // TODO add your handling code here:
        int i = tblPengeluaran.getSelectedRow();
        // jika baris terseleksi
        if(i > -1){
            String jenisPengeluaran = (String) pengeluaranTableModel.getValueAt(i, 2);
            txtJenisPengeluaran.setText(jenisPengeluaran);
            BigDecimal biayaPengeluaran = (BigDecimal) pengeluaranTableModel.getValueAt(i, 3);
            txtBiayaPengeluaran.setText(biayaPengeluaran.toString());
        }        
    }//GEN-LAST:event_tblPengeluaranMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int i = tblPengeluaran.getSelectedRow();
        if(pengeluaran == null){
            pengeluaran = new Pengeluaran();
        }        
        if(i > -1){
            Integer idPengeluaran = (Integer) pengeluaranTableModel.getValueAt(i, 0);
            pengeluaran.setIdPengeluaran(idPengeluaran);
            int validateDelete = JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(validateDelete == 0){
                pengeluaranService.hapus(pengeluaran);
                refreshTable();
            }        
        }
        else{
            JOptionPane.showMessageDialog(null, "Pilih baris yang mau dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().pengeluaranPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private class PengeluaranTableModel extends AbstractTableModel{
        private List<Pengeluaran> listPengeluaran = new ArrayList<Pengeluaran>();
        // buat konstruktor untuk menampung list record pengeluaran
        public PengeluaranTableModel(List<Pengeluaran> listPeng){
            this.listPengeluaran = listPeng;
        }
        
        // override
        public int getRowCount(){
            return listPengeluaran.size();
        }
        
        public int getColumnCount(){
            return 4;
        }
        
        public Object getValueAt(int baris, int kolom){
            // gunakan get untuk mendapatkan baris
            Pengeluaran pengeluaran = listPengeluaran.get(baris);
            if(kolom == 0){
                return pengeluaran.getIdPengeluaran();
            }
            if(kolom == 1){
                return pengeluaran.getTanggal();
            }
            if(kolom == 2){
                return pengeluaran.getJenisPengeluaran();
            }
            if(kolom == 3){
                return pengeluaran.getBiayaPengeluaran();
            }
            return "";
        }
        
        public String getColumnName(int kolom){
            if(kolom == 0){
                return "ID Pengeluaran";
            }
            if(kolom == 1){
                return "Tanggal Pengeluaran";
            }
            if(kolom == 2){
                return "Jenis Pengeluaran";
            }
            if(kolom == 3){
                return "Biaya pengeluaran";
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPengeluaran;
    private javax.swing.JTextField txtBiayaPengeluaran;
    private javax.swing.JTextField txtJenisPengeluaran;
    // End of variables declaration//GEN-END:variables
}
