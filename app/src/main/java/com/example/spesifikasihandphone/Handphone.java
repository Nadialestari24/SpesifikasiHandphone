package com.example.spesifikasihandphone;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.List;

public class Handphone implements Serializable {
    private String nama_produk;
    private String ram;
    private String internal_memory;
    private String pic;
    private String harga;

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getInternal_memory() {
        return internal_memory;
    }

    public void setInternal_memory(String internal_memory) {
        this.internal_memory = internal_memory;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
