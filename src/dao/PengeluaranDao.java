package dao;

import connect.KoneksiDatabase;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pengeluaran;

public class PengeluaranDao {
    
    private KoneksiDatabase koneksiDB;
    private PengeluaranDao pengeluaranDao;
    
    public PengeluaranDao(KoneksiDatabase kon){
        this.koneksiDB = kon;
    }
    
    public void simpan(Pengeluaran pengeluaran) throws SQLException{
        String sql = "INSERT INTO t_pengeluaran(tanggal, jenis_pengeluaran, biaya_pengeluaran) VALUES(now(), ?, ?)";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);        
        ps.setString(1, pengeluaran.getJenisPengeluaran());
        ps.setBigDecimal(2, pengeluaran.getBiayaPengeluaran());
        int hasil = ps.executeUpdate();
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnectDB();
    }
    
    public void ubah(Pengeluaran pengeluaran) throws SQLException{
        Connection koneksi = koneksiDB.connectToDB();
        String sql = "UPDATE t_pengeluaran SET jenis_pengeluaran = ?, biaya_pengeluaran = ? WHERE id_pengeluaran = ?";             
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setString(1, pengeluaran.getJenisPengeluaran());
        ps.setBigDecimal(2, pengeluaran.getBiayaPengeluaran());
        ps.setInt(3, pengeluaran.getIdPengeluaran());
        int hasil = ps.executeUpdate();
        if(hasil != 0){
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);            
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        koneksiDB.disconnectDB();
    }
    
    public void hapus(Pengeluaran pengeluaran) throws SQLException{
        String sql = "DELETE FROM t_pengeluaran WHERE id_pengeluaran = ?";
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, pengeluaran.getIdPengeluaran());
        ps.executeUpdate();
        koneksiDB.disconnectDB();
    }    
    
    public List<Pengeluaran> getAllPengeluaran() throws SQLException{
        List<Pengeluaran> listPengeluaran = new ArrayList<Pengeluaran>();
        String sql = "SELECT * FROM t_pengeluaran";                    
        Connection koneksi = koneksiDB.connectToDB();
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            // set semua parameter di kelas pengeluaran dari tabel pengeluaran
            // untuk dimunculkan di tabel pengeluaran panel
            Pengeluaran pengeluaran = new Pengeluaran();            
            pengeluaran.setIdPengeluaran(rs.getInt("id_pengeluaran"));
            pengeluaran.setTanggal(rs.getDate("tanggal"));
            pengeluaran.setJenisPengeluaran(rs.getString("jenis_pengeluaran"));
            pengeluaran.setBiayaPengeluaran(rs.getBigDecimal("biaya_pengeluaran"));
            listPengeluaran.add(pengeluaran);
        }
        koneksiDB.disconnectDB();
        return listPengeluaran;
    }
}
