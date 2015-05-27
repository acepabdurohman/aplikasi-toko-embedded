package service;

import java.sql.ResultSet;
import java.util.*;
import model.Jenis;
import model.Kategori;
import model.Pakaian;

public interface PakaianService{

    public Pakaian simpan(Pakaian pakaian); 
    public Pakaian ubah(Pakaian pakaian);
    public Pakaian hapus(Pakaian pakaian);
    public List<Pakaian> cari(Pakaian pakaian);
    public List<Pakaian> getAllPakaian();
    public List<Kategori> fillComboBoxKategori();
    public List<Kategori> setTextFromKategori(Kategori kategori);
    public List<Jenis> fillComboBoxJenis();
    public List<Jenis> setTextFromJenis(Jenis jenis);
    
}