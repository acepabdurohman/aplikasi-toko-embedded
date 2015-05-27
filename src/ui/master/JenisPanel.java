package ui.master;

import connect.KoneksiDatabase;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import main.Main;
import model.Jenis;
import model.Kategori;
import org.apache.log4j.Logger;
import service.JenisService;
import service.KategoriService;
import service.impl.JenisServiceImpl;
import service.impl.KategoriServiceImpl;
import ui.renderer.TableCellRenderCenterAlignment;

public class JenisPanel extends javax.swing.JInternalFrame {

    private Logger log = Logger.getLogger(JenisPanel.class);
    private KoneksiDatabase koneksiDB = new KoneksiDatabase();
    private JenisService jenisService = new JenisServiceImpl(koneksiDB);
    private Jenis jenis;
    private JenisTableModel jenisTableModel;
    
    public JenisPanel() {
        initComponents();
        refreshTable();
    }
    
    public void refreshTable(){
        List<Jenis> listJenis = jenisService.getAllJenis();
        jenisTableModel = new JenisTableModel(listJenis);
        tblJenis.setModel(jenisTableModel);
        tblJenis.getColumnModel().getColumn(0).setCellRenderer( new TableCellRenderCenterAlignment());
    }
    
    public void setData(){        
        jenis.setKodeJenis(txtKodeJenis.getText());
        jenis.setJenis(txtJenis.getText());
    }
    
    public boolean validateData(){
        if(txtKodeJenis.getText() != null && txtKodeJenis.getText().length() > 0 
                &&txtJenis.getText() != null && txtJenis.getText().length() > 0){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Textfield harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public void clearData(){
        txtKodeJenis.setText("");
        txtJenis.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJenis = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtKodeJenis = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setIconifiable(true);
        setTitle("Data Jenis Barang");
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

        jLabel2.setText("Jenis");

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

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnudoor.png"))); // NOI18N
        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuClear.png"))); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblJenis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblJenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJenisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblJenis);

        jLabel1.setText("Kode Jenis");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtKodeJenis, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                .addComponent(txtJenis)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnSimpan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnUbah)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnHapus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnClear)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnKeluar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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

    
    private void tblJenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJenisMouseClicked
        // TODO add your handling code here:
        int i = tblJenis.getSelectedRow();        
        String kodeJenisT = (String) jenisTableModel.getValueAt(i, 1);
        txtKodeJenis.setText(kodeJenisT);
        String jenisT = (String) jenisTableModel.getValueAt(i, 2);
        txtJenis.setText(jenisT);
    }//GEN-LAST:event_tblJenisMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        if(jenis == null){
            jenis = new Jenis();
        }        
        try{
            int i = tblJenis.getSelectedRow();
            if(i > -1){
                setData();
                Integer idJenis = (Integer) jenisTableModel.getValueAt(i, 0);
                jenis.setIdJenis(idJenis);
                jenisService.ubah(jenis);
                refreshTable();
            }
            else{            
                JOptionPane.showMessageDialog(null, "Pilih baris pada tabel yang mau diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        } catch(Exception e){
            log.error(e);
            JOptionPane.showMessageDialog(this, "adasdasdasd");
        }        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(jenis == null){
            jenis = new Jenis();
        }
        try{
            if(validateData()){
                setData();
                jenisService.simpan(jenis);
                refreshTable();
            }
        } catch(Exception ex){
            log.error(ex);
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(jenis == null){
            jenis = new Jenis();
        }
            int i = tblJenis.getSelectedRow();        

            if(i > -1){
                int validateDelete = JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ?",
                    "Konfirmasi penghapusan data", JOptionPane.YES_NO_OPTION);
                try{
                    if(validateDelete == 0){
                        Integer idJenis = (Integer) jenisTableModel.getValueAt(i, 0);
                        jenis.setIdJenis(idJenis);
                        jenisService.hapus(jenis);
                        refreshTable();
                    }
                } catch(Exception ex){
                    log.error(ex);
                    JOptionPane.showMessageDialog(this, "asdasdasdasd");
                }                            
            }
            else{
                JOptionPane.showMessageDialog(null, "Pilih baris pada tabel yang mau dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }                
    }//GEN-LAST:event_btnHapusActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Main.getFrame().jenisPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().jenisPanel = null;
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private class JenisTableModel extends AbstractTableModel{
        private List<Jenis> listJenis = new ArrayList<Jenis>();
        
        public JenisTableModel(List<Jenis> listJ){
            this.listJenis = listJ;
        } 
        
        public int getRowCount(){
            return listJenis.size();
        }
        
        public int getColumnCount(){
            return 3;
        }
        
        public Object getValueAt(int baris, int kolom){
            Jenis jenis = listJenis.get(baris);
            if(kolom == 0){
                return jenis.getIdJenis();
            }
            if(kolom == 1){
                return jenis.getKodeJenis();
            }
            if(kolom == 2){
                return jenis.getJenis();
            }
            return "";
        }
        
        public String getColumnName(int kolom){
            if(kolom == 0){
                return "ID Jenis";
            }
            if(kolom == 1){
                return "Kode Jenis";
            }
            if(kolom == 2){
                return "Jenis";
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
    private javax.swing.JTable tblJenis;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtKodeJenis;
    // End of variables declaration//GEN-END:variables
}
