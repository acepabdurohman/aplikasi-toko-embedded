package service;

import java.util.List;
import model.Pakaian;
import model.Penjualan;

public interface PenjualanService {
    
    public Penjualan simpan(Penjualan penjualan);
    public void hapus(Penjualan penjualan);
    public List<Pakaian> fillComboBox();
    public List<Pakaian> setTextFromPakaian(Pakaian pakaian);
    public List<Penjualan> getAllPenjualan();
    public List<Pakaian> getAllPakaian();
    public List<Pakaian> validateStock(Penjualan penjualan);
}
