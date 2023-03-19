/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author tienanh03
 */
public class NguoiDung {
    private String tenTK;
    private String matKhau;
    private String vaiTro;

    public NguoiDung() {
    }

    public NguoiDung(String tenTK, String matKhau, String vaiTro) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
}
