package ui.master;

import connect.KoneksiDatabase;
import dao.PakaianDao;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import main.Main;
import model.Jenis;
import model.Kategori;
import model.Pakaian;
import model.Penjualan;
import org.apache.log4j.Logger;
import service.PakaianService;
import service.impl.PakaianServiceImpl;
import ui.renderer.TableCellRenderCenterAlignment;
import ui.renderer.TableCellRenderDouble;

public class PakaianPanel extends javax.swing.JInternalFrame {

    private Logger log = Logger.getLogger(PakaianPanel.class);
    private KoneksiDatabase koneksiDB = new KoneksiDatabase();   
    private PakaianService pakaianService = new PakaianServiceImpl(koneksiDB);
    private Pakaian pakaian;          
    private Penjualan penjualan;
    private PakaianTableModel tableModel;
    private Kategori kategori;
    private Jenis jenis;
    
    public PakaianPanel() {
        initComponents();         
        refreshTable();        
        setComboBox();
        setEditable(false);   
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtKodeMerk = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMerk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTipe = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        txtHargaBeli = new javax.swing.JTextField();
        txtHargaJual = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbKodeKategori = new javax.swing.JComboBox();
        cmbKodeJenis = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtKategori = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPakaian = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Data Barang");
        setToolTipText("null");
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

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuManuaEdit.png"))); // NOI18N
        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        jLabel7.setText("Pencarian : ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Data"));
        jPanel1.setToolTipText("");

        jLabel6.setText("Kode Merk");

        jLabel2.setText("Merk");

        txtMerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMerkActionPerformed(evt);
            }
        });

        jLabel3.setText("Kode Kategori");

        jLabel4.setText("Tipe");

        txtStok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStokKeyTyped(evt);
            }
        });

        txtHargaBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaBeliActionPerformed(evt);
            }
        });
        txtHargaBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaBeliKeyTyped(evt);
            }
        });

        txtHargaJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaJualKeyTyped(evt);
            }
        });

        jLabel1.setText("Kode Jenis");

        jLabel5.setText("Stok");

        jLabel8.setText("Harga Beli");

        jLabel9.setText("Harga Jual");

        cmbKodeKategori.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbKodeKategoriPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cmbKodeJenis.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbKodeJenisPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel10.setText("Kategori");

        jLabel11.setText("Jenis");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMerk, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtKodeMerk)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(cmbKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHargaJual)
                            .addComponent(txtHargaBeli)
                            .addComponent(txtStok)
                            .addComponent(txtJenis)
                            .addComponent(cmbKodeJenis, 0, 193, Short.MAX_VALUE)
                            .addComponent(txtTipe))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKodeMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        tblPakaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPakaian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPakaianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPakaian);

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
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mnuSave.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKeluar)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnClear)
                    .addComponent(btnKeluar)
                    .addComponent(jLabel7)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setEditable(boolean status){
        txtKategori.setEnabled(status);
        txtJenis.setEnabled(status);
    }
    
    public void rendererData(){
        tblPakaian.getColumnModel().getColumn(0).setCellRenderer( new TableCellRenderCenterAlignment());
        tblPakaian.getColumnModel().getColumn(8).setCellRenderer( new TableCellRenderCenterAlignment());
        tblPakaian.getColumnModel().getColumn(9).setCellRenderer( new TableCellRenderDouble());
        tblPakaian.getColumnModel().getColumn(10).setCellRenderer( new TableCellRenderDouble());
    }
    
    public void setComboBox(){
        List<Kategori> listKategori = pakaianService.fillComboBoxKategori();
        List<Jenis> listJenis = pakaianService.fillComboBoxJenis();
        for(Kategori kat : listKategori){
            cmbKodeKategori.addItem(kat.getKodeKategori());
        }
        for(Jenis jen : listJenis){
            cmbKodeJenis.addItem(jen.getKodeJenis());
        }
    }
    
    public void clearForm(){
       
       txtKodeMerk.setText("");
       txtMerk.setText("");  
       txtKategori.setText("");
       txtTipe.setText(""); 
       txtJenis.setText("");
       txtStok.setText("");
       txtCari.setText("");
       txtHargaBeli.setText("");
       txtHargaJual.setText("");
    }
    
    public void refreshTable(){
        
        List<Pakaian> dataPakaian = pakaianService.getAllPakaian();
        tableModel = new PakaianTableModel(dataPakaian);
        // masukan ke tabel
        tblPakaian.setModel(tableModel); 
        rendererData();
    }
    
    public void showSearch(Pakaian pakaian){
        
        List<Pakaian> dataPakaian = pakaianService.cari(pakaian);
        tableModel = new PakaianTableModel(dataPakaian);
        // masukan ke tabel
        tblPakaian.setModel(tableModel);
        rendererData();
    }
    
    public boolean validateData(){
        if(txtKodeMerk.getText().length() > 0 && txtKodeMerk.getText() != null && txtMerk.getText().length() > 0 && txtMerk.getText() != null
                && txtKategori.getText() != null && txtKategori.getText().length() > 0
                && txtTipe.getText().length() > 0 && txtTipe.getText() != null
                && txtJenis.getText() != null && txtJenis.getText().length() > 0
                && txtStok.getText() != null && txtStok.getText().length() > 0
                && txtHargaBeli.getText().length() > 0 && txtHargaBeli.getText() != null && txtHargaJual.getText().length() > 0 && txtHargaJual.getText() != null){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Semua text field harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }        
    }
    
    public void setData(){
        
        pakaian.setKodeMerk(txtKodeMerk.getText());               
        pakaian.setMerk(txtMerk.getText());
        pakaian.setKodeKategori((String) cmbKodeKategori.getSelectedItem());
        pakaian.setKategori(txtKategori.getText());
        pakaian.setTipe(txtTipe.getText());
        pakaian.setKodeJenis((String) cmbKodeJenis.getSelectedItem());  
        pakaian.setJenis(txtJenis.getText());
        Integer konvertStok = Integer.parseInt(txtStok.getText());
        pakaian.setStok(konvertStok);  
        BigDecimal konvertHargaBeli = new BigDecimal(txtHargaBeli.getText());
        pakaian.setHargaBeli(konvertHargaBeli);
        BigDecimal konvertHargaJual = new BigDecimal(txtHargaJual.getText());
        pakaian.setHargaJual(konvertHargaJual);
                               
    }   
    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(validateData()){
            if(pakaian == null){
                pakaian = new Pakaian();                
            }
            setData();       
            try{                      
                pakaianService.simpan(pakaian);                
                clearForm();
                refreshTable();                            
            } catch(Exception ex){
                log.error(ex);
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }       
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
       clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        Main.getFrame().pakaianPanel = null;
        
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Main.getFrame().pakaianPanel = null;        
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void txtMerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMerkActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_txtMerkActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        int i = tblPakaian.getSelectedRow();
        if(i == -1){
            // tidak ada baris terseleksi
            JOptionPane.showMessageDialog(null, "Pilih baris yang mau diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            if(validateData()){
                if(pakaian == null){
                    pakaian = new Pakaian();
                }
                setData();       
                try{ 
                    Integer idMerk = (Integer) tableModel.getValueAt(i, 0);
                    pakaian.setIdMerk(idMerk);
                    pakaianService.ubah(pakaian);                
                    clearForm();
                    refreshTable();                            
                } catch(Exception ex){
                    log.error(ex);                                                   
                }
            }
        }        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblPakaianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPakaianMouseClicked
        // TODO add your handling code here:
        
        try{
            int i = tblPakaian.getSelectedRow();
            if(i == -1){
                // tidak ada baris terseleksi
                return;
            }
            String kodeMerk = (String) tableModel.getValueAt(i, 1);
            txtKodeMerk.setText(kodeMerk);
            String merk = (String) tableModel.getValueAt(i, 2);
            txtMerk.setText(merk);
            String kodeKategori = (String) tableModel.getValueAt(i, 3);
            cmbKodeKategori.setSelectedItem(kodeKategori);
            String kategori = (String) tableModel.getValueAt(i, 4);
            txtKategori.setText(kategori);
            String tipe = (String) tableModel.getValueAt(i, 5);
            txtTipe.setText(tipe);
            String kodeJenis = (String) tableModel.getValueAt(i, 6);
            cmbKodeJenis.setSelectedItem(kodeJenis);
            String jenis = (String) tableModel.getValueAt(i, 7);
            txtJenis.setText(jenis);
            Integer stok = (Integer) tableModel.getValueAt(i, 8);
            txtStok.setText(stok.toString());
            BigDecimal hargaBeli = (BigDecimal) tableModel.getValueAt(i, 9);
            txtHargaBeli.setText(hargaBeli.toString());
            BigDecimal hargaJual = (BigDecimal) tableModel.getValueAt(i, 10);
            txtHargaJual.setText(hargaJual.toString());
        } catch(Exception ex){
            log.error(ex);
        }        
       
    }//GEN-LAST:event_tblPakaianMouseClicked

    private void txtStokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStokKeyTyped
        // TODO add your handling code here:
        // batasi inputan hanya numeric
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
        
            evt.consume();
        }
    }//GEN-LAST:event_txtStokKeyTyped

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int i = tblPakaian.getSelectedRow();
        if(i == -1){
            // tidak ada baris terseleksi
            JOptionPane.showMessageDialog(null, "Pilih baris yang mau dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah anda yakin mau menghapus data ? ", "Konfirmasi menghapus data", 
                        JOptionPane.YES_NO_OPTION);
            if(konfirmasi == 0){
                if(pakaian == null){
                    pakaian = new Pakaian();
                }
                Integer hapus = (Integer) tableModel.getValueAt(i, 0);
                pakaian.setIdMerk(hapus);
                pakaianService.hapus(pakaian);
                refreshTable();
                clearForm();
            }
        }        
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        
        List<Pakaian> dataPakaian = pakaianService.getAllPakaian();
        tableModel = new PakaianTableModel(dataPakaian);
        tblPakaian.setModel(tableModel);         
        final TableRowSorter<TableModel> sort = new TableRowSorter<TableModel>(tableModel);
        tblPakaian.setRowSorter(sort);    
        String key = txtCari.getText();
        if(key.length() == 0){
            sort.setRowFilter(null);
        }
        else{
            sort.setRowFilter(RowFilter.regexFilter("(?i)" + key));
        }
    }//GEN-LAST:event_txtCariKeyPressed

    private void txtHargaBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaBeliActionPerformed

    private void txtHargaBeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaBeliKeyTyped
        // TODO add your handling code here:
        // batasi inputan hanya numeric
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
        
            evt.consume();
        }
    }//GEN-LAST:event_txtHargaBeliKeyTyped

    private void txtHargaJualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaJualKeyTyped
        // TODO add your handling code here:
        // batasi inputan hanya numeric
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
        
            evt.consume();
        }
    }//GEN-LAST:event_txtHargaJualKeyTyped

    private void cmbKodeKategoriPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbKodeKategoriPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
       if(kategori == null){
           kategori = new Kategori();
       }
       String kodeKategori = (String) cmbKodeKategori.getSelectedItem();
       kategori.setKodeKategori(kodeKategori);
       List<Kategori> listKategori = pakaianService.setTextFromKategori(kategori);
       for(Kategori kat : listKategori){
           txtKategori.setText(kat.getKategori());
       }
    }//GEN-LAST:event_cmbKodeKategoriPopupMenuWillBecomeInvisible

    private void cmbKodeJenisPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbKodeJenisPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if(jenis == null){
           jenis = new Jenis();
       }
       String kodeJenis = (String) cmbKodeJenis.getSelectedItem();
       jenis.setKodeJenis(kodeJenis);
       List<Jenis> listJenis = pakaianService.setTextFromJenis(jenis);
       for(Jenis jen : listJenis){
           txtJenis.setText(jen.getJenis());
       }
    }//GEN-LAST:event_cmbKodeJenisPopupMenuWillBecomeInvisible

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:      
        
    }//GEN-LAST:event_txtCariKeyReleased

    private class PakaianTableModel extends AbstractTableModel{
    
        private List<Pakaian> dataPakaian;

        public PakaianTableModel(List<Pakaian> pakai){
            this.dataPakaian = pakai;
        }

        public int getRowCount(){
            return dataPakaian.size();
        }
        public int getColumnCount(){
            return 11;
        }

        public Object getValueAt(int baris, int kolom){
            Pakaian pakaian = dataPakaian.get(baris);

            if(kolom == 0){
                return pakaian.getIdMerk();
            }           
            if(kolom == 1){
                return pakaian.getKodeMerk();
            }                                
            if(kolom == 2){
                return pakaian.getMerk();
            }
            if(kolom == 3){
                return pakaian.getKodeKategori();
            }
            if(kolom == 4){
                return pakaian.getKategori();
            }
            if(kolom == 5){
                return pakaian.getTipe();
            }
            if(kolom == 6){
                return pakaian.getKodeJenis();
            }
            if(kolom == 7){
                return pakaian.getJenis();
            }
            if(kolom == 8){
                return pakaian.getStok();
            }
            if(kolom == 9){
                return pakaian.getHargaBeli();
            }
            if(kolom == 10){
                return pakaian.getHargaJual();
            }
            return "";
        }
        public String getColumnName(int kolom){
            if(kolom == 0){
                return "ID Merk";
            }
            if(kolom == 1){
                return "Kode Merk";
            }
            if(kolom == 2){
                return "Merk";
            }
            if(kolom == 3){
                return "Kode Kategori";
            }
            if(kolom == 4){
                return "Kategori";
            }
            if(kolom == 5){
                return "Tipe";
            }
            if(kolom == 6){
                return "Kode Jenis";
            }
            if(kolom == 7){
                return "Jenis";
            }
            if(kolom == 8){
                return "Stok";
            }
            if(kolom == 9){
                return "Harga Beli";
            }
            if(kolom == 10){
                return "Harga Jual";
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
    private javax.swing.JComboBox cmbKodeJenis;
    private javax.swing.JComboBox cmbKodeKategori;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPakaian;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextField txtKodeMerk;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtTipe;
    // End of variables declaration//GEN-END:variables
}
