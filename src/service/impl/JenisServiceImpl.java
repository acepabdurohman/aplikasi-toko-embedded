package service.impl;

import connect.KoneksiDatabase;
import dao.JenisDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Jenis;
import service.JenisService;

public class JenisServiceImpl implements JenisService{
    private KoneksiDatabase koneksiDB;
    private JenisDao jenisDao;
    private Connection koneksi;
    
    public JenisServiceImpl(KoneksiDatabase konek){
        this.koneksiDB = konek;
        jenisDao = new JenisDao(koneksiDB);
        koneksi = koneksiDB.connectToDB();
    }
    // override
    public Jenis simpan(Jenis jenis){
        try{
            koneksi.setAutoCommit(false);
            jenisDao.simpan(jenis);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return jenis;
    }
    
    public Jenis ubah(Jenis jenis){
        try{
            koneksi.setAutoCommit(false);
            jenisDao.ubah(jenis);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return jenis;
    }
    
    public Jenis hapus(Jenis jenis){
        try{
            koneksi.setAutoCommit(false);
            jenisDao.hapus(jenis);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return jenis;
    }
    
    public List<Jenis> getAllJenis(){
        try{
            return jenisDao.getAllJenis();                    
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<Jenis>();
    }
}
