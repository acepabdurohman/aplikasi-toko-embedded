package dao;
import connect.KoneksiDatabase;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.Jenis;
import model.Kategori;
import model.Pakaian;
import model.Penjualan;

public class PakaianDao {
    private KoneksiDatabase koneksiDB;
    
    public PakaianDao(KoneksiDatabase kon){
        
        this.koneksiDB = kon;
    }
    
    public void simpan(Pakaian pakaian) throws SQLException{         
        
        // query insert
        String sql = "INSERT INTO t_pakaian(kode_merk, kode_kategori, kode_jenis, merk, kategori, tipe, jenis, stok, harga_beli, harga_jual) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // panggil method konek dengan menggunakan objek koneksiDb
        // tampung di variabel dengan tipe Connection
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        // set parameter
        // dapatkan dari kelas pakaian
        ps.setString(1, pakaian.getKodeMerk());
        ps.setString(2, pakaian.getKodeKategori());
        ps.setString(3, pakaian.getKodeJenis());
        ps.setString(4, pakaian.getMerk());
        ps.setString(5, pakaian.getKategori());
        ps.setString(6, pakaian.getTipe());
        ps.setString(7, pakaian.getJenis());
        ps.setInt(8, pakaian.getStok());
        ps.setBigDecimal(9, pakaian.getHargaBeli());
        ps.setBigDecimal(10, pakaian.getHargaJual());
        int hasil = ps.executeUpdate();
        if(hasil != 0){

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan", "Informasi simpan data", JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan", "Informasi simpan data", JOptionPane.ERROR_MESSAGE);
        }            
        koneksiDB.disconnectDB();                                   
            
    }    
    
    public void ubah(Pakaian pakaian) throws SQLException{
    
        // query update
        String sql = "UPDATE t_pakaian SET kode_merk = ?, kode_kategori = ?, kode_jenis = ?, merk = ?, kategori = ?, tipe = ?, jenis = ?, stok = ?, harga_beli = ?, harga_jual = ? WHERE id_merk = ?";
        // panggil method konek dengan menggunakan objek koneksiDb
        // tampung di variabel dengan tipe Connection
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        
        ps.setString(1, pakaian.getKodeMerk());
        ps.setString(2, pakaian.getKodeKategori());
        ps.setString(3, pakaian.getKodeJenis());
        ps.setString(4, pakaian.getMerk());
        ps.setString(5, pakaian.getKategori());
        ps.setString(6, pakaian.getTipe());
        ps.setString(7, pakaian.getJenis());
        ps.setInt(8, pakaian.getStok());
        ps.setBigDecimal(9, pakaian.getHargaBeli());
        ps.setBigDecimal(10, pakaian.getHargaJual());
        ps.setInt(11, pakaian.getIdMerk());

        int hasil = ps.executeUpdate();
        if(hasil != 0){

            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi ubah data", JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            JOptionPane.showMessageDialog(null, "Data gagal diubah", "Informasi ubah data", JOptionPane.ERROR_MESSAGE);
        }
        koneksiDB.disconnectDB();     
    
    }
    
    public void hapus(Pakaian pakaian) throws SQLException{
    
        // query hapus
        String sql = "DELETE FROM t_pakaian WHERE id_merk = ?";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, pakaian.getIdMerk());
        ps.executeUpdate();
        koneksiDB.disconnectDB();
    }
    
    public List<Pakaian> cari(Pakaian pakaian) throws SQLException{
        
        String sql = "SELECT * FROM t_pakaian WHERE merk LIKE ? OR jenis LIKE ? ORDER BY merk";
        List<Pakaian> hasil = new ArrayList<Pakaian>();
        // Pakaian pakaian = new Pakaian();
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, "%" + pakaian.getMerk() + "%");
        ps.setString(2, "%" + pakaian.getJenis() + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){            
            Pakaian pakaian2 = new Pakaian();
            pakaian2.setIdMerk(rs.getInt("id_merk"));
            pakaian2.setKodeMerk(rs.getString("kode_merk"));            
            pakaian2.setMerk(rs.getString("merk"));
            pakaian2.setKodeKategori(rs.getString("kode_kategori"));            
            pakaian2.setKategori(rs.getString("kategori"));
            pakaian2.setTipe(rs.getString("tipe"));
            pakaian2.setKodeJenis(rs.getString("kode_jenis"));
            pakaian2.setJenis(rs.getString("jenis"));
            pakaian2.setStok(rs.getInt("stok"));
            pakaian2.setHargaBeli(rs.getBigDecimal("harga_beli"));
            pakaian2.setHargaJual(rs.getBigDecimal("harga_jual"));
            hasil.add(pakaian2);
        }
        koneksiDB.disconnectDB();
        return hasil;
    }
    
    public List<Pakaian> getAllPakaian() throws SQLException{
        
        // hasil simpan di list
        List<Pakaian> hasil = new ArrayList<>();

        String sql = "SELECT * FROM t_pakaian ORDER BY merk";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        // hasil query di simpan di resultset
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Pakaian pakaian = new Pakaian();
            pakaian.setIdMerk(rs.getInt("id_merk"));
            pakaian.setKodeMerk(rs.getString("kode_merk"));
            pakaian.setKodeKategori(rs.getString("kode_kategori"));
            pakaian.setKodeJenis(rs.getString("kode_jenis"));
            pakaian.setMerk(rs.getString("merk"));
            pakaian.setKategori(rs.getString("kategori"));
            pakaian.setTipe(rs.getString("tipe"));
            pakaian.setJenis(rs.getString("jenis"));
            pakaian.setStok(rs.getInt("stok"));
            pakaian.setHargaBeli(rs.getBigDecimal("harga_beli"));
            pakaian.setHargaJual(rs.getBigDecimal("harga_jual"));
            hasil.add(pakaian);
        }
        koneksiDB.disconnectDB();
        return hasil;
    }    
    
    public List<Kategori> fillComboBoxKategori() throws SQLException{
        List<Kategori> listKategori = new ArrayList<Kategori>();
        String sql = "SELECT * FROM t_kategori";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Kategori kategori = new Kategori();
            kategori.setKodeKategori(rs.getString("kode_kategori"));
            kategori.setKategori(rs.getString("kategori"));
            listKategori.add(kategori);
        }
        koneksiDB.disconnectDB();
        return listKategori;
    }
    
    public List<Jenis> fillComboBoxJenis() throws SQLException{
        List<Jenis> listJenis = new ArrayList<Jenis>();
        String sql = "SELECT * FROM t_jenis";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Jenis jenis = new Jenis();
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            jenis.setJenis(rs.getString("jenis"));
            listJenis.add(jenis);
        }
        koneksiDB.disconnectDB();
        return listJenis;
    }
    
     public List<Kategori> setTextFromKategori(Kategori kategori) throws SQLException{
        List<Kategori> listKategori = new ArrayList<Kategori>();
        String sql = "SELECT * FROM t_kategori WHERE kode_kategori =  ? ";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, kategori.getKodeKategori());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Kategori kategori2 = new Kategori();
            kategori2.setKodeKategori(rs.getString("kode_kategori"));
            kategori2.setKategori(rs.getString("kategori"));
            listKategori.add(kategori2);
        }
        koneksiDB.disconnectDB();
        return listKategori;
    }
    
    public List<Jenis> setTextFromJenis(Jenis jenis) throws SQLException{
        List<Jenis> listJenis = new ArrayList<Jenis>();
        String sql = "SELECT * FROM t_jenis WHERE kode_jenis = ?";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, jenis.getKodeJenis());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Jenis jenis2 = new Jenis();
            jenis2.setKodeJenis(rs.getString("kode_jenis"));
            jenis2.setJenis(rs.getString("jenis"));
            listJenis.add(jenis2);
        }
        koneksiDB.disconnectDB();
        return listJenis;
    }   
}
