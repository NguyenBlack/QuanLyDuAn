package quanlynhanvien.service;



import java.sql.*;


public class LoginService {

    public static boolean CheckLogin(String user, String pass) {
        boolean isCheck = false;
        try {
            String sql = "select * from Logins where username = ? and passwords = ?";
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            isCheck = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return isCheck = false;
        }
        return isCheck;
    }
}