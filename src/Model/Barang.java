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
public class Barang extends DataBaseHelper{
    public ArrayList getDataBarang() throws SQLException{
        ResultSet barang=getmodel("barang");
        
        ArrayList databarang=new ArrayList();
        while (barang.next()) {      
            HashMap hm =new HashMap();
            hm.put("kd_barang", barang.getString(1));
            hm.put("nama_barang", barang.getString(2));
            hm.put("stok", barang.getInt(3));
            hm.put("harga_beli", barang.getInt(4));
            hm.put("harga_jual", barang.getInt(5));
            hm.put("status_barang", barang.getString(6));
            databarang.add(hm);
        }
        return databarang;
    }
    public boolean insertBarang(HashMap barang){
        PreparedStatement preparedStatement=null;
        String query="INSERT INTO `barang` (`kd_barang`, `nama_barang`, `stok`, `harga_beli`,`harga_jual`,`status_barang`) VALUES (?,?, ?,?,?,?);";
        try {
            preparedStatement =this.connection.prepareStatement(query);
            preparedStatement.setString(1, (String) barang.get("kd_barang"));
            preparedStatement.setString(2, (String) barang.get("nama_barang"));
            preparedStatement.setInt(3, (int) barang.get("stok"));
            preparedStatement.setInt(4, (int) barang.get("harga_beli"));
            preparedStatement.setInt(5, (int) barang.get("harga_jual"));
            preparedStatement.setString(6, (String) barang.get("status_barang"));
            preparedStatement.execute();
            JOptionPane.showMessageDialog( null, "Data Berhasil Disimpan");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, "Penyimpanan Gagal", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean editbarang(HashMap barang){
        PreparedStatement preparedStatement=null;
        String query="UPDATE `barang` SET `nama_barang` = ?, `stok` = ?, `harga_beli` = ?, `harga_jual` = ?, `status_barang`=? WHERE `barang`.`kd_barang` = ?;";
        try {
            preparedStatement =this.connection.prepareStatement(query);
            preparedStatement.setString(1, (String) barang.get("nama_barang"));
            preparedStatement.setInt(2, (int) barang.get("stok"));
            preparedStatement.setInt(3, (int) barang.get("harga_beli"));
            preparedStatement.setInt(4, (int) barang.get("harga_jual"));
            preparedStatement.setString(5, (String)barang.get("status_barang"));
            preparedStatement.setString(6, (String) barang.get("kd_barang"));
            preparedStatement.execute();
            JOptionPane.showMessageDialog( null, "Data Berhasil Diubah");
            return true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog( null, "Penyimpanan Gagal", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public ArrayList getDataBarangASC() throws SQLException{
        statement= connection.createStatement();
        resultSet=statement.executeQuery("SELECT * FROM barang WHERE status_barang='Available' ORDER BY stok ASC");
        
        ArrayList databarang=new ArrayList();
        while (resultSet.next()) {      
            HashMap hm =new HashMap();
            hm.put("kd_barang", resultSet.getString(1));
            hm.put("nama_barang", resultSet.getString(2));
            hm.put("stok", resultSet.getInt(3));
            hm.put("harga_beli", resultSet.getInt(4));
            hm.put("harga_jual", resultSet.getInt(5));
            hm.put("status_barang", resultSet.getString(6));
            databarang.add(hm);
        }
        return databarang;
    
    }
    public ArrayList getDataBarangByName(String name) throws SQLException{
        statement= connection.createStatement();
        resultSet=statement.executeQuery("SELECT * FROM barang WHERE nama_barang='"+name+"'");
        
        ArrayList databarang=new ArrayList();
        while (resultSet.next()) {      
            HashMap hm =new HashMap();
            hm.put("kd_barang", resultSet.getString(1));
            hm.put("nama_barang", resultSet.getString(2));
            hm.put("stok", resultSet.getInt(3));
            hm.put("harga_beli", resultSet.getInt(4));
            hm.put("harga_jual", resultSet.getInt(5));
            hm.put("status_barang", resultSet.getString(6));
            databarang.add(hm);
        }
        return databarang;
    
    }
    public boolean hapusbarang(String kdBarang){
        PreparedStatement preparedStatement=null;
        String query="DELETE FROM `barang` WHERE `barang`.`kd_barang` = ?;";
        try {
            preparedStatement =this.connection.prepareStatement(query);
            preparedStatement.setString(1,kdBarang);
            preparedStatement.execute();
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    public boolean potongStok(String kd_barang,Integer jumlah){
        PreparedStatement preparedStatement=null;
        String query="UPDATE `barang` SET `stok` = `stok`-? WHERE `barang`.`kd_barang` = ?;";
        try {
            preparedStatement =this.connection.prepareStatement(query);
            preparedStatement.setInt(1,jumlah);
            preparedStatement.setString(2, kd_barang);
            preparedStatement.execute();
//            JOptionPane.showMessageDialog( null, "Data Berhasil Disimpan");
            return true;
        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog( null, "Penyimpanan Gagal", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
