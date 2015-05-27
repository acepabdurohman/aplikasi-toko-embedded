package service.impl;

import connect.KoneksiDatabase;
import dao.PengeluaranDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pengeluaran;
import service.PengeluaranService;

public class PengeluaranServiceImpl implements PengeluaranService{
    private KoneksiDatabase koneksiDB;
    private Connection koneksi;
    private PengeluaranDao pengeluaranDao;
    
    public PengeluaranServiceImpl(KoneksiDatabase kon){
        this.koneksiDB = kon;
        koneksi = koneksiDB.connectToDB();
        pengeluaranDao = new PengeluaranDao(koneksiDB);
    }
    
    public Pengeluaran simpan(Pengeluaran pengeluaran){
        try{
            koneksi.setAutoCommit(false);
            pengeluaranDao.simpan(pengeluaran);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }            
        }
        return pengeluaran;
    }
    
    public Pengeluaran ubah(Pengeluaran pengeluaran){
        try{
            koneksi.setAutoCommit(false);
            pengeluaranDao.ubah(pengeluaran);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }            
        }
        return pengeluaran;
    }
    
    public Pengeluaran hapus(Pengeluaran pengeluaran){
        try{
            koneksi.setAutoCommit(false);
            pengeluaranDao.hapus(pengeluaran);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }            
        }
        return pengeluaran;
    }
    
    public List<Pengeluaran> getAllPengeluaran(){        
        try{
            return pengeluaranDao.getAllPengeluaran();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Pengeluaran>();
    }
}
