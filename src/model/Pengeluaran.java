package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Pengeluaran {
    private Integer idPengeluaran;
    private Date tanggal;
    private String jenisPengeluaran;
    private BigDecimal biayaPengeluaran;

    public Integer getIdPengeluaran() {
        return idPengeluaran;
    }

    public void setIdPengeluaran(Integer idPengeluaran) {
        this.idPengeluaran = idPengeluaran;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenisPengeluaran() {
        return jenisPengeluaran;
    }

    public void setJenisPengeluaran(String jenisPengeluaran) {
        this.jenisPengeluaran = jenisPengeluaran;
    }

    public BigDecimal getBiayaPengeluaran() {
        return biayaPengeluaran;
    }

    public void setBiayaPengeluaran(BigDecimal biayaPengeluaran) {
        this.biayaPengeluaran = biayaPengeluaran;
    }    
    
}
