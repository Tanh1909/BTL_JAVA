/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.mycompany.connect.ConnectionSQL;
import com.mycompany.model.BangDiem;
import com.mycompany.model.Mon;
import com.mycompany.model.NguoiDung;
import com.mycompany.model.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tienanh03
 */
public class NguoiDungManager {

    private NguoiDung nd;
    private ConnectionSQL con;

    public NguoiDungManager() throws ClassNotFoundException, SQLException {
        con = new ConnectionSQL();
        nd = new NguoiDung();
    }

    public NguoiDung dangnhap(String tenTK, String matKhau, JOptionPane jp) {
        String sql = "SELECT tenTK,matKhau,vaiTro FROM NguoiDung WHERE tenTK=? AND matKhau=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, tenTK);
            PS.setString(2, matKhau);
            ResultSet rs = PS.executeQuery();
            if (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setTenTK(rs.getString(1));
                nd.setMatKhau(rs.getString(2));
                nd.setVaiTro(rs.getString(3));
                return nd;
            } else {
                JOptionPane.showMessageDialog(jp, "Tên Tài Khoản hoặc Mật Khẩu không chính xác");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jp, "Có lỗi phát sinh: " + e.getMessage());
        }
        return null;
    }

    public SinhVien layTTSV(String msv) {
        String sql = "SELECT * FROM SINHVIEN WHERE maSV=?";
        try {
            PreparedStatement ps = con.connect().prepareStatement(sql);
            ps.setString(1, msv);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(msv);
                sv.setHoTen(rs.getString(2));
                sv.setEmail(rs.getString(3));
                sv.setSdt(rs.getString(4));
                sv.setGioiTinh(rs.getInt(5));
                sv.setDiaChi(rs.getString(6));
                return sv;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public List<BangDiem> layDSDIEM(String msv) {
        String sql = "SELECT BangDiem.maMH,tenMH,diem,soTC FROM BangDiem inner join Mon on  BangDiem.maMH=mon.maMH WHERE maSV=?";
        List<BangDiem> list = new ArrayList<>();
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, msv);
            ResultSet rs = PS.executeQuery();
            while (rs.next()) {
                BangDiem bd = new BangDiem();
                bd.setMaMH(rs.getString(1));
                bd.setTenMH(rs.getString(2));
                bd.setDiem(rs.getDouble(3));
                bd.setSoTC(rs.getInt(4));
                list.add(bd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public List<Mon> layDSMH( ) {
        String sql = "SELECT * FROM Mon";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            List<Mon> list = new ArrayList<>();
            ResultSet rs = PS.executeQuery();
            while (rs.next()) {
                Mon m = new Mon();
                m.setMaMH(rs.getString(1));
                m.setTenMH(rs.getString(2));
                m.setSoTC(rs.getInt(3));
                list.add(m);
            }
            return list;
        } catch (SQLException ex) {

        }
        return null;
    }
    public List<SinhVien> layDSSV() {
        String sql = "SELECT * FROM SinhVien";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            List<SinhVien> list = new ArrayList<>();
            ResultSet rs = PS.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setHoTen(rs.getString(2));
                sv.setEmail(rs.getString(3));
                sv.setSdt(rs.getString(4));
                sv.setGioiTinh(rs.getInt(5));
                sv.setDiaChi(rs.getString(6));
                list.add(sv);

            }
            return list;
        } catch (SQLException ex) {

        }
        return null;
    }

    public SinhVien timKiem(String msv) {
        String sql = "SELECT * FROM SinhVien WHERE maSV=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, msv);
            ResultSet rs = PS.executeQuery();
            if (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setHoTen(rs.getString(2));
                sv.setEmail(rs.getString(3));
                sv.setSdt(rs.getString(4));
                sv.setGioiTinh(rs.getInt(5));
                sv.setDiaChi(rs.getString(6));
                return sv;

            }
        } catch (SQLException ex) {
        }
        return null;
    }
    public boolean timkiemMH(String maMH){
        String sql = "SELECT * FROM Mon WHERE maMH=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, maMH);
            ResultSet rs = PS.executeQuery();
            if (rs.next()) {

                return true;

            }
        } catch (SQLException ex) {
        }
        return false;
    }
    public boolean Them(SinhVien sv, JOptionPane jp) {
        String sql = "INSERT INTO SinhVien VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, sv.getMaSV());
            PS.setString(2, sv.getHoTen());
            PS.setString(3, sv.getEmail());
            PS.setString(4, sv.getSdt());
            PS.setInt(5, sv.getGioiTinh());
            PS.setString(6, sv.getDiaChi());
            themUser(sv.getMaSV());
            return PS.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jp, "TRUNG MA SINH VIEN");
        }
        return false;
    }
     public boolean ThemMH(Mon m, JOptionPane jp) {
        String sql = "INSERT INTO Mon VALUES(?,?,?)";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, m.getMaMH());
            PS.setString(2, m.getTenMH());
            PS.setInt(3, m.getSoTC());
            return PS.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jp, "TRUNG MA MON HOC!");
        }
        return false;
    }
    public boolean Sua(SinhVien sv) {
        String sql = "UPDATE SinhVien SET hoTen=?,email=?,soDT=?,gioiTinh=?,diaChi=? WHERE maSV=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, sv.getHoTen());
            PS.setString(2, sv.getEmail());
            PS.setString(3, sv.getSdt());
            PS.setInt(4, sv.getGioiTinh());
            PS.setString(5, sv.getDiaChi());
            PS.setString(6, sv.getMaSV());
            return PS.executeUpdate() > 0;
        } catch (SQLException ex) {
      
        }
        return false;
    }
    public boolean SuaMH(Mon m,JOptionPane jp) {
        String sql = "UPDATE Mon SET tenMH=?,soTC=? WHERE maMH=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
          
            PS.setString(1, m.getTenMH());
            PS.setInt(2, m.getSoTC());
             PS.setString(3, m.getMaMH());
            return PS.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jp, "Không Tìm THấy!");
        }
        return false;
    }
    public void themUser(String msv) {
        String sql = "INSERT INTO NguoiDung VALUES(?,?,?)";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, msv);
            PS.setString(2, msv);
            PS.setString(3, "Sinh Vien");
            PS.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void themDiem(String s1, String s2, double s3) {
        String sql = "INSERT INTO BangDiem VALUES(?,?,?)";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, s1);
            PS.setString(2, s2);
            PS.setDouble(3, s3);
            PS.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void suaDiem(double diem,String maMH,String maSV) {
        String sql = "UPDATE BangDiem SET diem=? WHERE maMH=? AND maSV=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
 
           PS.setDouble(1,diem );
          PS.setString(2, maMH);
             PS.setString(3, maSV);
             PS.executeUpdate();
        } catch (SQLException ex) {
          
        }
       
    }

    public boolean xoaSV(String msv) {
        String sql = "DElETE FROM SinhVien WHERE maSV=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, msv);
            PS.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean xoaMH(String msv,JOptionPane jp) {
        String sql = "DElETE FROM Mon WHERE maMH=?";
        String sql2="DElETE FROM BangDiem WHERE maMH=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PreparedStatement PS2 = con.connect().prepareStatement(sql2);
            PS2.setString(1, msv);
            PS2.executeUpdate();
            PS.setString(1, msv);
            PS.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jp, "Không Tìm Thấy!");
        }
        return false;
    }

    public void xoaUser(String msv) {
        String sql = "DElETE FROM NguoiDung WHERE maSV=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, msv);
            PS.executeUpdate();

        } catch (Exception e) {
        }
    }

    public boolean Xoa(String msv) {
        String sql = "DElETE FROM BangDiem WHERE maSV=?";
        try {
            PreparedStatement PS = con.connect().prepareStatement(sql);
            PS.setString(1, msv);
            PS.executeUpdate();
            xoaSV(msv);
            xoaUser(msv);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
