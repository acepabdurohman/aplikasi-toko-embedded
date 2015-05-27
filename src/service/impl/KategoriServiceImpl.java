package service.impl;

import connect.KoneksiDatabase;
import dao.KategoriDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Kategori;
import service.KategoriService;

public class KategoriServiceImpl implements KategoriService{
    private KoneksiDatabase koneksiDB;
    private KategoriDao kategoriDao;
    private Connection koneksi;
    
    public KategoriServiceImpl(KoneksiDatabase kon){
        this.koneksiDB = kon;
        kategoriDao = new KategoriDao(koneksiDB);
        koneksi = koneksiDB.connectToDB();
    }
    
    public Kategori simpan(Kategori kategori){
        try{
            koneksi.setAutoCommit(false);
            kategoriDao.simpan(kategori);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException ex){
            try{
                koneksi.rollback();
            } catch(SQLException exe){
                exe.printStackTrace();
            }
        }
        return kategori;
    }
    
    public Kategori ubah(Kategori kategori){
        try{
            koneksi.setAutoCommit(false);
            kategoriDao.ubah(kategori);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException ex){
            try{
                koneksi.rollback();
            } catch(SQLException exe){
                exe.printStackTrace();
            }
        }
        return kategori;
    }
    
    public Kategori hapus(Kategori kategori){
        try{
            koneksi.setAutoCommit(false);
            kategoriDao.hapus(kategori);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException ex){
            try{
                koneksi.rollback();
            } catch(SQLException exe){
                exe.printStackTrace();
            }
        }
        return kategori;
    }
    
    public List<Kategori> getAllKategori(){
        try{
            return kategoriDao.getAllKategori();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Kategori>();
    }
}
