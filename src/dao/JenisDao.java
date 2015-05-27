package dao;

import connect.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Jenis;

public class JenisDao {
    
    private KoneksiDatabase koneksiDB;
    
    public JenisDao(KoneksiDatabase konek){
        this.koneksiDB = konek;
    }
    
    public void simpan(Jenis jenis) throws SQLException{
        String sql = "INSERT INTO t_jenis(kode_jenis, jenis) VALUES(?, ?)";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, jenis.getKodeJenis());
        ps.setString(2, jenis.getJenis());
        int hasil = ps.executeUpdate();      

        if(hasil != 0){

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan", "Informasi simpan data", JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan", "Informasi simpan data", JOptionPane.ERROR_MESSAGE);
        }            
        koneksiDB.disconnectDB();
    }
    
    public void ubah(Jenis jenis) throws SQLException{
            
        String sql = "UPDATE t_jenis SET kode_jenis = ?, jenis = ? WHERE id_jenis = ?";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, jenis.getKodeJenis());
        ps.setString(2, jenis.getJenis());
        ps.setInt(3, jenis.getIdJenis());
        int hasil = ps.executeUpdate();      

        if(hasil != 0){

            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi ubah data", JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            JOptionPane.showMessageDialog(null, "Data gagal diubah", "Informasi ubah data", JOptionPane.ERROR_MESSAGE);
        }            
        koneksiDB.disconnectDB();
    }
    
    public void hapus(Jenis jenis) throws SQLException{
        String sql = "DELETE FROM t_jenis WHERE id_jenis = ?";
        Connection kon = koneksiDB.connectToDB();
        PreparedStatement ps = kon.prepareStatement(sql);
        ps.setInt(1, jenis.getIdJenis());
        ps.executeUpdate();
        koneksiDB.disconnectDB();
    }
    
    public List<Jenis> getAllJenis() throws SQLException{
        List<Jenis> listJenis = new ArrayList<Jenis>();
        String sql = "SELECT * FROM t_jenis";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Jenis jenis = new Jenis();
            jenis.setIdJenis(rs.getInt("id_jenis"));
            jenis.setKodeJenis(rs.getString("kode_jenis"));
            jenis.setJenis(rs.getString("jenis"));
            listJenis.add(jenis);
        }
        koneksiDB.disconnectDB();
        return listJenis;
    }
}
