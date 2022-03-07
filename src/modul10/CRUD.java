/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul10;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author rpl
 */
public class CRUD {
    private String id, nama, alamat;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUD(){
        try{
            KoneksiMysql connection = new KoneksiMysql();
            CRUDkoneksi = connection.getKoneksi();
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setID(String id){
        this.id = id;
    }
    
    public String getID(){
        return id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM siswa";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch(Exception e) {
        
        }
        return CRUDhasil;
    }
    
    public void simpanData(String id, String nama, String alamat){
        CRUDquery = "INSERT INTO siswa VALUES (?, ?, ?)";
        
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.setString(2, nama);
            CRUDpsmt.setString(3, alamat);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void ubahData(String id, String nama, String alamat){
        CRUDquery = "UPDATE siswa SET nama=?, alamat=? WHERE id=?";
        
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, alamat);
            CRUDpsmt.setString(3, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String id){
        CRUDquery = "DELETE FROM siswa WHERE id=?";
        
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
}