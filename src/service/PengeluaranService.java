package service;

import java.util.List;
import model.Pengeluaran;

public interface PengeluaranService {
    public Pengeluaran simpan(Pengeluaran pengeluaran);
    public List<Pengeluaran> getAllPengeluaran();
    public Pengeluaran ubah(Pengeluaran pengeluaran);
    public Pengeluaran hapus(Pengeluaran pengeluaran);
}
