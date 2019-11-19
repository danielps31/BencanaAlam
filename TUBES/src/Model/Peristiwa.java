/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Shamgar
 */
public class Peristiwa extends Bantuan{
    private String id_peristiwa;
    private String jenis_bencana;
    private String jam;
    private String lokasi;
    private String keterangan_peristiwa;
    private Bantuan[] bantuan;

    public Peristiwa(String id_peristiwa, String jenis_bencana, String jam, String lokasi, String keterangan_peristiwa, Bantuan[] bantuan, String id_bantuan, String jenis_bantuan, String tanggal_bantuan, String keterangan_bantuan) {
        super(id_bantuan, jenis_bantuan, tanggal_bantuan, keterangan_bantuan);
        this.id_peristiwa = id_peristiwa;
        this.jenis_bencana = jenis_bencana;
        this.jam = jam;
        this.lokasi = lokasi;
        this.keterangan_peristiwa = keterangan_peristiwa;
        this.bantuan = bantuan;
    }

    public String getId_peristiwa() {
        return id_peristiwa;
    }

    public void setId_peristiwa(String id_peristiwa) {
        this.id_peristiwa = id_peristiwa;
    }

    public String getJenis_bencana() {
        return jenis_bencana;
    }

    public void setJenis_bencana(String jenis_bencana) {
        this.jenis_bencana = jenis_bencana;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKeterangan_peristiwa() {
        return keterangan_peristiwa;
    }

    public void setKeterangan_peristiwa(String keterangan_peristiwa) {
        this.keterangan_peristiwa = keterangan_peristiwa;
    }

    public Bantuan[] getBantuan() {
        return bantuan;
    }

    public void setBantuan(Bantuan[] bantuan) {
        this.bantuan = bantuan;
    }

}
