package service;

import java.util.List;
import model.Kategori;

public interface KategoriService {
    public Kategori simpan(Kategori kategori);
    public Kategori ubah(Kategori kategori);
    public Kategori hapus(Kategori kategori);
    public List<Kategori> getAllKategori();
}
