package quanlynhanvien.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import quanlynhanvien.model.Logins;

public class LoginService {

    public static List CheckLogin() {
        try {
            List<Logins> listLogin = new ArrayList<>();
            String sql = "select * from Logins";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Logins lg = new Logins(rs.getInt(1),rs.getString(2), rs.getString(3));
                listLogin.add(lg);
            }
            return listLogin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void register(String user, String pass) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "insert into Logins values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
