package dao;

import connect.KoneksiDatabase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pakaian;
import model.Penjualan;

public class PenjualanDao {
        
    private KoneksiDatabase koneksiDB;
    
    public PenjualanDao(KoneksiDatabase kon){
        this.koneksiDB = kon;            
    }
    
    public void simpan(Penjualan penjualan) throws SQLException{
        
        String sql = "INSERT INTO t_penjualan(kode_merk, merk, jenis, tanggal, jumlah, harga_beli, harga_jual, total_beli, subtotal) VALUES(?, ?, ?, NOW(), ?, ?, ?, ?, ?)";   
        
        Connection con = koneksiDB.connectToDB();
        PreparedStatement ps = con.prepareStatement(sql);
        // isi parameter
        ps.setString(1, penjualan.getKodeMerk());
        ps.setString(2, penjualan.getMerk());
        ps.setString(3, penjualan.getJenis());         
        ps.setInt(4, penjualan.getJumlah());
        ps.setBigDecimal(5, penjualan.getHargaBeli());
        ps.setBigDecimal(6, penjualan.getHargaJual());        
        ps.setBigDecimal(7, penjualan.getTotalBeli());  
        ps.setBigDecimal(8, penjualan.getSubTotal());
        int hasil = ps.executeUpdate();        
        
        String sql2 = "UPDATE t_pakaian SET stok = stok - ? WHERE kode_merk = ?";
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setInt(1, penjualan.getJumlah());
        ps2.setString(2, penjualan.getKodeMerk());
        ps2.executeUpdate();
        
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnectDB();
    }
    
    public void hapus(Penjualan penjualan) throws SQLException{        
        Connection con = koneksiDB.connectToDB();
        String sql = "DELETE FROM t_penjualan WHERE id_penjualan = ?"; 
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, penjualan.getIdPenjualan());
        ps.executeUpdate();
        koneksiDB.disconnectDB();
    }
    
    public List<Pakaian> fillComboBox() throws SQLException{
        
        List<Pakaian> hasil = new ArrayList<Pakaian>();
        
        String sql = "SELECT * FROM t_pakaian";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Pakaian pakaian = new Pakaian();
            pakaian.setKodeMerk(rs.getString("kode_merk"));            
            hasil.add(pakaian);
        }
        koneksiDB.disconnectDB();
        return hasil;
    }
    
    public List<Pakaian> setTextFromPakaian(Pakaian pakaian) throws SQLException{
        
        List<Pakaian> hasil = new ArrayList<Pakaian>();
        String sql = "SELECT * FROM t_pakaian WHERE kode_merk = ?";
        Connection kon = koneksiDB.connectToDB();
        PreparedStatement ps = kon.prepareStatement(sql);
        ps.setString(1, pakaian.getKodeMerk());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            pakaian.setMerk(rs.getString("merk"));
            pakaian.setKategori(rs.getString("kategori"));
            pakaian.setTipe(rs.getString("tipe"));
            pakaian.setJenis(rs.getString("jenis"));
            pakaian.setHargaBeli(rs.getBigDecimal("harga_beli"));
            pakaian.setHargaJual(rs.getBigDecimal("harga_jual"));
            hasil.add(pakaian);
        }
        koneksiDB.disconnectDB();
        return hasil;
    }
    
    public List<Penjualan> getAllPenjualan() throws SQLException{
        List<Penjualan> hasil = new ArrayList<Penjualan>();
        String sql = "SELECT * FROM t_penjualan";
        Connection kon = koneksiDB.connectToDB();
        PreparedStatement ps = kon.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Penjualan penjualan = new Penjualan();            
            penjualan.setIdPenjualan(rs.getInt("id_penjualan"));
            penjualan.setKodeMerk(rs.getString("kode_merk"));
            penjualan.setMerk(rs.getString("merk"));
            penjualan.setJenis(rs.getString("jenis"));
            penjualan.setTanggal(rs.getDate("tanggal"));
            penjualan.setJumlah(rs.getInt("jumlah"));            
            penjualan.setHargaJual(rs.getBigDecimal("harga_jual")); 
            penjualan.setTotalBeli(rs.getBigDecimal("total_beli"));
            penjualan.setSubTotal(rs.getBigDecimal("subtotal"));             
            hasil.add(penjualan);
        }        
        koneksiDB.disconnectDB();
        return hasil;
    }
    
    public List<Pakaian> getAllPakaian() throws SQLException{
        String sql = "SELECT * FROM t_pakaian";
        List<Pakaian> listPakaian = new ArrayList<Pakaian>();
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Pakaian pakaian = new Pakaian();
            pakaian.setKodeMerk(rs.getString("kode_merk"));
            pakaian.setMerk(rs.getString("merk"));
            pakaian.setKategori(rs.getString("kategori"));
            pakaian.setTipe(rs.getString("tipe"));
            pakaian.setJenis(rs.getString("jenis"));
            pakaian.setStok(rs.getInt("stok"));
            pakaian.setHargaBeli(rs.getBigDecimal("harga_beli"));
            pakaian.setHargaJual(rs.getBigDecimal("harga_jual"));
            listPakaian.add(pakaian);
        }
        koneksiDB.disconnectDB();
        return listPakaian;        
    }
    
    public List<Pakaian> validateStock(Penjualan penjualan) throws SQLException{
        List<Pakaian> listPakaian = new ArrayList<Pakaian>();
        String sql = "SELECT stok FROM t_pakaian WHERE kode_merk = ?";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, penjualan.getKodeMerk());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Pakaian pakaian = new Pakaian();
            pakaian.setStok(rs.getInt("stok"));
            listPakaian.add(pakaian);
        }
        return listPakaian;
    }    
}
