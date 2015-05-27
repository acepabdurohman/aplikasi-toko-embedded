package ui;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ui.master.JenisPanel;
import ui.master.KategoriPanel;
import ui.master.PakaianPanel;
import ui.master.PengeluaranPanel;
import ui.reports.ReportPengeluaranPanel;
import ui.reports.ReportPenjualanPanel;
import ui.transaction.PenjualanPanel;

public class MainFrame extends javax.swing.JFrame {
    // daftarkan setiap panel
    public PakaianPanel pakaianPanel;
    public PenjualanPanel penjualanPanel;
    public PengeluaranPanel pengeluaranPanel;
    public KategoriPanel kategoriPanel;
    public JenisPanel jenisPanel;
    public ReportPenjualanPanel reportPanel;
    public ReportPengeluaranPanel reportPengeluaranPanel;
    
    public MainFrame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenuItem();
        menuMasterData = new javax.swing.JMenu();
        menuKategori = new javax.swing.JMenuItem();
        menuJenis = new javax.swing.JMenuItem();
        menuPakaian = new javax.swing.JMenuItem();
        menuPengeluaran = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenu();
        menuPenjualan = new javax.swing.JMenuItem();
        menuLaporan = new javax.swing.JMenu();
        menuReportPenjualan = new javax.swing.JMenuItem();
        menuReportPengeluaran = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Aplikasi Toko Jakarta");

        desktopPane.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        menuBar.add(jMenu1);

        menuMasterData.setText("Master Data");

        menuKategori.setText("Kategori");
        menuKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKategoriActionPerformed(evt);
            }
        });
        menuMasterData.add(menuKategori);

        menuJenis.setText("Jenis");
        menuJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJenisActionPerformed(evt);
            }
        });
        menuMasterData.add(menuJenis);

        menuPakaian.setText("Barang");
        menuPakaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPakaianActionPerformed(evt);
            }
        });
        menuMasterData.add(menuPakaian);

        menuPengeluaran.setText("Pengeluaran");
        menuPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPengeluaranActionPerformed(evt);
            }
        });
        menuMasterData.add(menuPengeluaran);

        menuBar.add(menuMasterData);

        menuTransaksi.setText("Transaksi");

        menuPenjualan.setText("Penjualan");
        menuPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenjualanActionPerformed(evt);
            }
        });
        menuTransaksi.add(menuPenjualan);

        menuBar.add(menuTransaksi);

        menuLaporan.setText("Laporan");
        menuLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLaporanActionPerformed(evt);
            }
        });

        menuReportPenjualan.setText("Laporan Penjualan");
        menuReportPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportPenjualanActionPerformed(evt);
            }
        });
        menuLaporan.add(menuReportPenjualan);

        menuReportPengeluaran.setText("Laporan Pengeluaran");
        menuReportPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportPengeluaranActionPerformed(evt);
            }
        });
        menuLaporan.add(menuReportPengeluaran);

        menuBar.add(menuLaporan);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPakaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPakaianActionPerformed
        // TODO add your handling code here:
        try{
            if(pakaianPanel == null){

                pakaianPanel = new PakaianPanel();
                desktopPane.add(pakaianPanel);
            }
            else{

                pakaianPanel.toFront();
            }
            Dimension parentSize = desktopPane.getSize();
            Dimension childSize = pakaianPanel.getSize();
            // set center screen
            pakaianPanel.setLocation((parentSize.width - childSize.width) / 2, (parentSize.height - childSize.height) / 2);
            pakaianPanel.setVisible(true);
            pakaianPanel.setSelected(true);          
            
        } catch(PropertyVetoException ex){
            // log.error("asdas", ex);
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error ketika menampilkan panel pakaian");
        }
        
        
    }//GEN-LAST:event_menuPakaianActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenjualanActionPerformed
        // TODO add your handling code here:
        try{
            
            if(penjualanPanel == null){
                penjualanPanel = new PenjualanPanel();
                desktopPane.add(penjualanPanel);
            }
            else{
                penjualanPanel.toFront();
            }
            Dimension parentSize = desktopPane.getSize();
            Dimension childSize = penjualanPanel.getSize();
            penjualanPanel.setLocation((parentSize.width - childSize.width) / 2, (parentSize.height - childSize.height) / 2);
            penjualanPanel.setVisible(true);
            penjualanPanel.setSelected(true);
            
        } catch(PropertyVetoException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error ketika menampilkan panel penjualan");
        }
    }//GEN-LAST:event_menuPenjualanActionPerformed

    private void menuLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLaporanActionPerformed
        // TODO add your handling code here:     
        
    }//GEN-LAST:event_menuLaporanActionPerformed

    private void menuReportPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportPenjualanActionPerformed
        // TODO add your handling code here:
        if(reportPanel == null){
            reportPanel = new ReportPenjualanPanel();
            desktopPane.add(reportPanel);
        }
        else{
            reportPanel.toFront();
        }
        Dimension x = desktopPane.getSize();
        Dimension y = reportPanel.getSize();
        reportPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
        reportPanel.setVisible(true);
        
    }//GEN-LAST:event_menuReportPenjualanActionPerformed

    private void menuPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPengeluaranActionPerformed
        // TODO add your handling code here:
        try{
            if(pengeluaranPanel == null){
                pengeluaranPanel = new PengeluaranPanel();
                // tambahkan ke desktopPane
                desktopPane.add(pengeluaranPanel);
            }
            else{
                pengeluaranPanel.toFront();                    
            }
            // atur supaya berada di tengah
            Dimension x = desktopPane.getSize();
            Dimension y = pengeluaranPanel.getSize();
            pengeluaranPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
            pengeluaranPanel.setVisible(true);
            pengeluaranPanel.setSelected(true);
        } catch(PropertyVetoException ex){
            ex.printStackTrace();
        }        
    }//GEN-LAST:event_menuPengeluaranActionPerformed

    private void menuKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKategoriActionPerformed
        // TODO add your handling code here:
        try{
            if(kategoriPanel == null){
                kategoriPanel = new KategoriPanel();
                desktopPane.add(kategoriPanel);
            }
            else{
                kategoriPanel.toFront();
            }
            Dimension x = desktopPane.getSize();
            Dimension y = kategoriPanel.getSize();
            // x * y
            kategoriPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
            kategoriPanel.setVisible(true);
            kategoriPanel.setSelected(true);
        } catch(PropertyVetoException ex){
            ex.printStackTrace();
        }        
    }//GEN-LAST:event_menuKategoriActionPerformed

    private void menuJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJenisActionPerformed
        // TODO add your handling code here:
        try{
            if(jenisPanel == null){
                jenisPanel = new JenisPanel();
                desktopPane.add(jenisPanel);                    
            }
            else{
                jenisPanel.toFront();
            }
            Dimension x = desktopPane.getSize();
            Dimension y = jenisPanel.getSize();
            jenisPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
            jenisPanel.setVisible(true);
            jenisPanel.setSelected(true);
        } catch(PropertyVetoException exe){
            exe.printStackTrace();
        }        
    }//GEN-LAST:event_menuJenisActionPerformed

    private void menuReportPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportPengeluaranActionPerformed
        // TODO add your handling code here:
        try{
            if(reportPengeluaranPanel == null){
                reportPengeluaranPanel = new ReportPengeluaranPanel();
                desktopPane.add(reportPengeluaranPanel);
            }
            else{
                reportPengeluaranPanel.toFront();
            }
            Dimension x = desktopPane.getSize();
            Dimension y = reportPengeluaranPanel.getSize();
            reportPengeluaranPanel.setLocation((x.width - y.width) / 2, (x.height - y.height) / 2);
            reportPengeluaranPanel.setVisible(true);
            reportPengeluaranPanel.setSelected(true);
        } catch(PropertyVetoException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_menuReportPengeluaranActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuJenis;
    private javax.swing.JMenuItem menuKategori;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenu menuMasterData;
    private javax.swing.JMenuItem menuPakaian;
    private javax.swing.JMenuItem menuPengeluaran;
    private javax.swing.JMenuItem menuPenjualan;
    private javax.swing.JMenuItem menuReportPengeluaran;
    private javax.swing.JMenuItem menuReportPenjualan;
    private javax.swing.JMenu menuTransaksi;
    // End of variables declaration//GEN-END:variables
}
