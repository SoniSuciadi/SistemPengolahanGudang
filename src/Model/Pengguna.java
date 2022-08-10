/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author sonys
 */
public class Pengguna extends DataBaseHelper{
    public ArrayList getPengguna() throws SQLException{
        ResultSet pengguna=getmodel("pengguna");
        
        ArrayList dataPengguna=new ArrayList();
        while (pengguna.next()) {      
            HashMap hm =new HashMap();
            hm.put("id_pengguna", pengguna.getString(1));
            hm.put("nama_pengguna", pengguna.getString(2));
            hm.put("alamat_pengguna", pengguna.getString(3));
            hm.put("nohp_pengguna",pengguna.getString(4));
            hm.put("jabatan", pengguna.getString(5));
            hm.put("password", pengguna.getString(6));
            
            dataPengguna.add(hm);
        }
        return dataPengguna;
    }
    public ArrayList getPenggunaByName(String nama) throws SQLException{
        statement= connection.createStatement();
        resultSet=statement.executeQuery("SELECT * FROM `pengguna` WHERE nama_pengguna='"+nama+"'");
        
        ArrayList dataPengguna=new ArrayList();
        while (resultSet.next()) {      
            HashMap hm =new HashMap();
            hm.put("id_pengguna", resultSet.getString(1));
            hm.put("nama_pengguna", resultSet.getString(2));
            hm.put("alamat_pengguna", resultSet.getString(3));
            hm.put("nohp_pengguna",resultSet.getString(4));
            hm.put("jabatan", resultSet.getString(5));
            hm.put("password", resultSet.getString(6));
            
            dataPengguna.add(hm);
        }
        return dataPengguna;
    }
    public boolean insertPengguna(HashMap pengguna){
        PreparedStatement preparedStatement=null;
        String query="INSERT INTO `pengguna` (`id_pengguna`, `nama_pengguna`, `alamat_pengguna`, `nohp_pengguna`, `jabatan`, `password`) VALUES (?, ?,?,?,?,?);";
        try {
            preparedStatement =this.connection.prepareStatement(query);
            preparedStatement.setString(1, (String) pengguna.get("id_pengguna"));
            preparedStatement.setString(2, (String) pengguna.get("nama_pengguna"));
            preparedStatement.setString(3, (String) pengguna.get("alamat_pengguna"));
            preparedStatement.setString(4, (String) pengguna.get("nohp_pengguna"));
            preparedStatement.setString(5, (String) pengguna.get("jabatan"));
            preparedStatement.setString(6, (String) pengguna.get("password"));
            preparedStatement.execute();
            JOptionPane.showMessageDialog( null, "Data Berhasil Disimpan");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, "Penyimpanan Gagal", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean updatePengguna(HashMap barang){
        PreparedStatement preparedStatement=null;
        String query="UPDATE `pengguna` SET `nama_pengguna` = ?, `alamat_pengguna` = ?, `nohp_pengguna` = ?, `jabatan` = ?, `password` =? WHERE `pengguna`.`id_pengguna` = ?;";
        try {
            preparedStatement =this.connection.prepareStatement(query);
            preparedStatement.setString(1, (String) barang.get("nama_pengguna"));
            preparedStatement.setString(2, (String) barang.get("alamat_pengguna"));
            preparedStatement.setString(3, (String) barang.get("nohp_pengguna"));
            preparedStatement.setString(4, (String) barang.get("jabatan"));
            preparedStatement.setString(5, (String) barang.get("password"));
            preparedStatement.setString(6, (String) barang.get("id_pengguna"));
            preparedStatement.execute();
            JOptionPane.showMessageDialog( null, "Perubahan Berhasil");
            return true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog( null, "Penyimpanan Gagal", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean hapusPengguna(String id_pengguna){
        PreparedStatement preparedStatement=null;
        String query="DELETE FROM `pengguna` WHERE `pengguna`.`id_pengguna` = ?;";
        try {
            preparedStatement =this.connection.prepareStatement(query);
            preparedStatement.setString(1,id_pengguna);
            preparedStatement.execute();
            JOptionPane.showMessageDialog( null, "Penghapusan Berhasil");
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, "Gagal Menghapus", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public String getPasswordByIdPengguna(String id_pengguna) throws SQLException{
        statement= connection.createStatement();
        resultSet=statement.executeQuery("SELECT password FROM `pengguna` WHERE id_pengguna="+id_pengguna+";");
        String password = null;
        while (resultSet.next()) {      
            HashMap hm =new HashMap();
            password=resultSet.getString(0);
        }
           return password;
    
    }
}
