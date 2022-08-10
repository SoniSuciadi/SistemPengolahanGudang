/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sonys
 */
public class Pesanan extends DataBaseHelper{
    
    public ArrayList getDataPesanan() throws SQLException{
        statement= connection.createStatement();
        resultSet=statement.executeQuery("SELECT pesanan.id_pesanan,pesanan.id_pengguna,pengguna.nama_pengguna, pesanan.total_harga,pesanan.created_at,pesanan.status FROM pesanan,pengguna \n" +
"WHERE pesanan.id_pengguna=pengguna.id_pengguna");
        
        ArrayList dataPesanan=new ArrayList();
        while (resultSet.next()) {      
            HashMap hm =new HashMap();
            hm.put("id_pesanan", resultSet.getString(1));
            hm.put("id_pengguna", resultSet.getString(2));
            hm.put("nama_pengguna", resultSet.getString(3));
            hm.put("total_harga", resultSet.getInt(4));
            hm.put("tanggal", resultSet.getString(5));
            hm.put("status", resultSet.getString(6));
            
            dataPesanan.add(hm);
        }
        return dataPesanan;
    
    }
    public ArrayList getDataPesananbyDate(String date) throws SQLException{
        statement= connection.createStatement();
        resultSet=statement.executeQuery("SELECT pesanan.id_pesanan,pesanan.id_pengguna,pengguna.nama_pengguna,pesanan.total_harga,pesanan.created_at,pesanan.status FROM pesanan,pengguna "
                + "WHERE pesanan.created_at= '"+date+"' and pesanan.id_pengguna=pengguna.id_pengguna");
        
        ArrayList dataPesanan=new ArrayList();
        while (resultSet.next()) {      
            HashMap hm =new HashMap();
            hm.put("id_pesanan", resultSet.getString(1));
            hm.put("id_pengguna", resultSet.getString(2));
            hm.put("nama_pengguna", resultSet.getString(3));
            hm.put("total_harga", resultSet.getInt(4));
            hm.put("tanggal", resultSet.getString(5));
            hm.put("status", resultSet.getString(6));
            
            dataPesanan.add(hm);
        }
        return dataPesanan;
    
    }
    public boolean terimaPesanan(String id_pesanan){
        PreparedStatement preparedStatement=null;
        String query="UPDATE `pesanan` SET `status` = 'Diterima' WHERE `pesanan`.`id_pesanan` = ?;";
        try {
            preparedStatement =this.connection.prepareStatement(query);
            preparedStatement.setString(1, (String) id_pesanan);
            preparedStatement.execute();
            JOptionPane.showMessageDialog( null, "Data Berhasil Diterima");
            return true;
        
        } catch (SQLException ex) {
            Logger.getLogger(Pesanan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog( null, "Gagal Menerima", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
         
        
    }
    
    
}
