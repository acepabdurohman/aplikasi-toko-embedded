package model;

import java.math.BigDecimal;

public class Pakaian {
    
    private Integer idMerk;
    private String kodeMerk;
    private String kodeKategori;
    private String kodeJenis;
    private String merk;
    private String kategori;
    private String tipe;
    private String jenis;
    private Integer stok;
    private BigDecimal hargaBeli;
    private BigDecimal hargaJual;

    public Integer getIdMerk() {
        return idMerk;
    }

    public void setIdMerk(Integer idMerk) {
        this.idMerk = idMerk;
    }

    public String getKodeMerk() {
        return kodeMerk;
    }

    public void setKodeMerk(String kodeMerk) {
        this.kodeMerk = kodeMerk;
    }

    public String getKodeKategori() {
        return kodeKategori;
    }

    public void setKodeKategori(String kodeKategori) {
        this.kodeKategori = kodeKategori;
    }

    public String getKodeJenis() {
        return kodeJenis;
    }

    public void setKodeJenis(String kodeJenis) {
        this.kodeJenis = kodeJenis;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public BigDecimal getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(BigDecimal hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public BigDecimal getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(BigDecimal hargaJual) {
        this.hargaJual = hargaJual;
    }    
}
