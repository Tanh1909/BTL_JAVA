/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author tienanh03
 */
public class BangDiem {
    private String maMH;
    private String tenMH;
    private double diem;
    private int soTC;

    public BangDiem() {
    }

    public BangDiem(String maMH, String tenMH, double diem, int soTC) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.diem = diem;
        this.soTC = soTC;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public int getSoTC() {
        return soTC;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }
    
}
