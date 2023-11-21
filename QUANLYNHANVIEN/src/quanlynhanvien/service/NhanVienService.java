package quanlynhanvien.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import quanlynhanvien.model.NhanVien;

public class NhanVienService {

    public static List loadData() {
        List<NhanVien> listNhanvien;
        try {
            listNhanvien = new ArrayList<>();
            String sql = "Select * from Nhanvien";
            Connection con = ConnectDB.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String gioitinh = rs.getString(4);
                int tuoi = rs.getInt(5);
                int luong = rs.getInt(6);
                String email = rs.getString(7);
                String phone = rs.getString(8);
                NhanVien nv = new NhanVien(id, ma, ten, gioitinh, tuoi, luong, email, phone);
                listNhanvien.add(nv);
            }
            con.close();
            return listNhanvien;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int Insert(NhanVien nv) {
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "Insert into nhanvien values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getGioitinh());
            ps.setInt(4, nv.getTuoi());
            ps.setInt(5, nv.getLuong());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getSdt());
           return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int deleteSV(String ma) {
        String sql = "delete nhanvien\n"
                + "where MaNV = ?";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int Update(String ma, NhanVien nv) {
        String sql = "update nhanvien set hoten=?,gioitinh=?,tuoi=?,luong =?,email=?,sodienthoai=?\n"
                + "where MaNV = ?;";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTen());
            ps.setString(2, nv.getGioitinh());
            ps.setInt(3, nv.getTuoi());
            ps.setInt(4, nv.getLuong());
            ps.setString(5, nv.getEmail());
            ps.setString(6, nv.getSdt());
            ps.setString(7, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static List<NhanVien> Timtheoma(String ma){
        try {
            List<NhanVien> listNhanvien = new ArrayList<>();
            String sql = "select * from nhanvien where Manv = ? ";
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Long id = rs.getLong(1);
                String ma1 = rs.getString(2);
                String ten = rs.getString(3);
                String gioitinh = rs.getString(4);
                int tuoi = rs.getInt(5);
                int luong = rs.getInt(6);
                String email = rs.getString(7);
                String phone = rs.getString(8);
                NhanVien nv = new NhanVien(id, ma, ten, gioitinh, tuoi, luong, email, phone);
                listNhanvien.add(nv);
            }
            return listNhanvien;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
