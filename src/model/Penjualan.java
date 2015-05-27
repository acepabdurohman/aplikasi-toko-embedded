package model;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Penjualan {

    private Integer idPenjualan;
    private String kodeMerk;
    private String merk;
    private String jenis;
    private Date tanggal;   
    private Integer jumlah;
    private BigDecimal hargaBeli;
    private BigDecimal hargaJual;    
    private BigDecimal totalBeli;
    private BigDecimal subTotal;   

    public Integer getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(Integer idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public String getKodeMerk() {
        return kodeMerk;
    }

    public void setKodeMerk(String kodeMerk) {
        this.kodeMerk = kodeMerk;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
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

    public BigDecimal getTotalBeli() {
        return totalBeli;
    }

    public void setTotalBeli(BigDecimal totalBeli) {
        this.totalBeli = totalBeli;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }           
    
}
