package service;

import java.util.List;
import model.Jenis;

public interface JenisService {
    
    public Jenis simpan(Jenis jenis);
    public Jenis ubah(Jenis jenis);
    public Jenis hapus(Jenis jenis);
    public List<Jenis> getAllJenis();
    
}
