package com.android.baranghilang.data;

public class Data {
    private String id_brghilang, nama, detail, waktu, src;

    public Data(){

    }
    public Data(String id_brghilang, String nama, String detail, String waktu, String src){
        this.id_brghilang = id_brghilang;
        this.nama = nama;
        this.detail = detail;
        this.waktu = waktu;
        this.src = src;
    }

    public String getId_brghilang() {
        return id_brghilang;
    }

    public void setId_brghilang(String id_brghilang) {
        this.id_brghilang = id_brghilang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        String image = "http://192.168.11.1/barang_hilang/img/";
        this.src = image + src;
    }
}
