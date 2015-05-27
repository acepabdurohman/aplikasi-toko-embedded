package dao;

import connect.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Kategori;

public class KategoriDao {
    
    private KoneksiDatabase koneksiDB;
    
    public KategoriDao(KoneksiDatabase kon){
        this.koneksiDB = kon;
    }
    
    public void simpan(Kategori kategori) throws SQLException{
        String sql = "INSERT INTO t_kategori(kode_kategori, kategori) VALUES(?, ?)";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, kategori.getKodeKategori());
        ps.setString(2, kategori.getKategori());
        int hasil = ps.executeUpdate();      

        if(hasil != 0){

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan", "Informasi simpan data", JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan", "Informasi simpan data", JOptionPane.ERROR_MESSAGE);
        }            
        koneksiDB.disconnectDB(); 
    }
    
    public void ubah(Kategori kategori) throws SQLException{
        String sql = "UPDATE t_kategori SET kode_kategori = ?, kategori = ? WHERE id_kategori = ? ";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, kategori.getKodeKategori());
        ps.setString(2, kategori.getKategori());
        ps.setInt(3, kategori.getIdKategori());
        int hasil = ps.executeUpdate();      

        if(hasil != 0){

            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi ubah data", JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            JOptionPane.showMessageDialog(null, "Data gagal diubah", "Informasi ubah data", JOptionPane.ERROR_MESSAGE);
        }            
        koneksiDB.disconnectDB();
    }
    
    public void hapus(Kategori kategori) throws SQLException{
            
        String sql = "DELETE FROM t_kategori WHERE id_kategori = ?";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, kategori.getIdKategori());
        ps.executeUpdate();
        koneksiDB.disconnectDB();
    }
    
    public List<Kategori> getAllKategori() throws SQLException{
        List<Kategori> listKategori = new ArrayList<Kategori>();
        String sql = "SELECT * FROM t_kategori";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Kategori kategori = new Kategori();
            kategori.setIdKategori(rs.getInt("id_kategori"));
            kategori.setKodeKategori(rs.getString("kode_kategori"));
            kategori.setKategori(rs.getString("kategori"));
            listKategori.add(kategori);
        }
        koneksiDB.disconnectDB();
        return listKategori;
    }
}
