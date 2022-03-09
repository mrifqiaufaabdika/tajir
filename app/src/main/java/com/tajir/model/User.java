package com.tajir.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_pramudi")
    @Expose
    private String namaPramudi;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("ktp")
    @Expose
    private String ktp;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;
    @SerializedName("nomor_hp")
    @Expose
    private String nomorHp;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("status")
    @Expose
    private String status;


    @SerializedName("token_jwt")
    @Expose
    private String tokenJwt;
    @SerializedName("token_firebase")
    @Expose
    private String tokenFirebase;


    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaPramudi() {
        return namaPramudi;
    }

    public void setNamaPramudi(String namaPramudi) {
        this.namaPramudi = namaPramudi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTokenJwt() {
        return tokenJwt;
    }

    public void setTokenJwt(String tokenJwt) {
        this.tokenJwt = tokenJwt;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public String getTokenFirebase() {
        return tokenFirebase;
    }

    public void setTokenFirebase(String tokenFirebase) {
        this.tokenFirebase = tokenFirebase;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
