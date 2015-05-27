package service.impl;

import connect.KoneksiDatabase;
import dao.PenjualanDao;
import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
import model.Pakaian;
import model.Penjualan;
import service.PenjualanService;

public class PenjualanServiceImpl implements PenjualanService {
    
    private KoneksiDatabase koneksiDB;
    private PenjualanDao penjualanDao;
    private Connection koneksi;
    
    public PenjualanServiceImpl(KoneksiDatabase kon){
        this.koneksiDB = kon;
        koneksi = koneksiDB.connectToDB();
        penjualanDao = new PenjualanDao(koneksiDB);
    }
    
    public Penjualan simpan(Penjualan penjualan){
        try{
            koneksi.setAutoCommit(false);
            penjualanDao.simpan(penjualan);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{            
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return penjualan;
    }
    public void hapus(Penjualan penjualan){
        try{
            koneksi.setAutoCommit(false);
            penjualanDao.hapus(penjualan);
            koneksi.commit();
            koneksi.setAutoCommit(true);
        } catch(SQLException exe){
            try{
                koneksi.rollback();
            } catch(SQLException ex){
                ex.printStackTrace();
            }         
        }        
    }
    
    public List<Pakaian> fillComboBox(){
        try{
            return penjualanDao.fillComboBox();
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<Pakaian>();
    }
    
    public List<Pakaian> setTextFromPakaian(Pakaian pakaian){
        try{
            return penjualanDao.setTextFromPakaian(pakaian);
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<Pakaian>();
    }
    
    public List<Penjualan> getAllPenjualan(){
        try{
            return penjualanDao.getAllPenjualan();
        } catch(SQLException exe){
            exe.printStackTrace();
        }
        return new ArrayList<Penjualan>();
    } 
    
    public List<Pakaian> getAllPakaian(){
        try{
            return penjualanDao.getAllPakaian();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Pakaian>();
    }
    public List<Pakaian> validateStock(Penjualan penjualan){
        try{
            return penjualanDao.validateStock(penjualan);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Pakaian>();
    }
}
