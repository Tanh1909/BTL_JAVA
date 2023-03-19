/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author tienanh03
 */
public class SinhVien {
    private String maSV;
    private String hoTen;
    private String email;
    private String sdt;
    private int gioiTinh;
    private String diaChi;

    public SinhVien() {
    }
    
    
    public SinhVien(String maSV, String hoTen, String email, String sdt, int gioiTinh, String diaChi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", hoTen=" + hoTen + ", email=" + email + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + '}';
    }
    
}
