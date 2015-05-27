package service.impl;

import connect.KoneksiDatabase;
import dao.PakaianDao;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.Jenis;
import model.Kategori;
import model.Pakaian;
import service.PakaianService;

public class PakaianServiceImpl implements PakaianService{
    
    private KoneksiDatabase koneksiDB;
    private Connection koneksi;
    private PakaianDao pakaianDao;
    private Pakaian Pakaian;
    
    // set koneksi ke database
    public PakaianServiceImpl(KoneksiDatabase kon){
        
        this.koneksiDB = kon;
        koneksi = koneksiDB.connectToDB();
        pakaianDao = new PakaianDao(koneksiDB);
    }
    public Pakaian simpan(Pakaian pakaian){
    
        try{            
            koneksi.setAutoCommit(false);
            // eksekusi method simpan pada kelas PakaianDao
            pakaianDao.simpan(pakaian);
            // komit jika berhasil
            koneksi.commit();
            koneksi.setAutoCommit(true);            
        } catch(SQLException ex){
            try{            
                koneksi.rollback();
            } catch(SQLException exe){                
                exe.printStackTrace();
            }            
        }   
        return pakaian;
    }
    
    public Pakaian ubah(Pakaian pakaian){
    
        try{            
            koneksi.setAutoCommit(false);
            // eksekusi method ubah pada kelas PakaianDao
            pakaianDao.ubah(pakaian);
            // komit jika berhasil
            koneksi.commit();
            koneksi.setAutoCommit(true);            
        } catch(SQLException ex){
            try{            
                koneksi.rollback();
            } catch(SQLException exe){                
                exe.printStackTrace();
            }            
        }   
        return pakaian;
    }
    
    public Pakaian hapus(Pakaian pakaian){
    
        try{            
            koneksi.setAutoCommit(false);
            // eksekusi method hapus pada kelas PakaianDao
            pakaianDao.hapus(pakaian);
            // komit jika berhasil
            koneksi.commit();
            koneksi.setAutoCommit(true);            
        } catch(SQLException ex){
            try{            
                koneksi.rollback();
            } catch(SQLException exe){                
                exe.printStackTrace();
            }            
        }   
        return pakaian;
    }
    
    public List<Pakaian> cari(Pakaian pakaian){
        
        try{
            return pakaianDao.cari(pakaian);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Pakaian>();        
    }
    
    public List<Pakaian> getAllPakaian(){
        
        try{
            return pakaianDao.getAllPakaian();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Pakaian>();        
    }   
    
    public List<Kategori> fillComboBoxKategori(){
        try{
            return pakaianDao.fillComboBoxKategori();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Kategori>(); 
    }
    
    public List<Jenis> fillComboBoxJenis(){
        try{
            return pakaianDao.fillComboBoxJenis();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Jenis>();
    }
    
    public List<Kategori> setTextFromKategori(Kategori kategori){
        try{
            return pakaianDao.setTextFromKategori(kategori);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Kategori>();
    }
    
     public List<Jenis> setTextFromJenis(Jenis jenis){
        try{
            return pakaianDao.setTextFromJenis(jenis);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return new ArrayList<Jenis>();
    }
     
}

