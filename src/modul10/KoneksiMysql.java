/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul10;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author rpl
 */
public class KoneksiMysql {
    private Connection connect;
    private String driverName = "com.mysql.jdbc.Driver";
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost:";
    private String port = "3306/";
    private String database = "crud9235";
    private String url = jdbc + host + port + database;
    private String username = "root";
    private String password = "";
    
    public Connection getKoneksi() throws SQLException {
        if(connect == null){
            try{
                Class.forName(driverName);
                System.out.println("Class Driver Ditemukan !");
                
                try {
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi Database Sukses !");
                } catch (SQLException se){
                    System.out.println("Koneksi Database Gagal !" + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe){
                System.out.println("Class Driver Ditemukan, Terjadi Kesalahan Pada : " + cnfe);
                System.exit(0);
            }
        }
        
        return connect;
    }
}
