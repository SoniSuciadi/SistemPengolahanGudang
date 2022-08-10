/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author sonys
 */
public class DetailPesanan extends DataBaseHelper{
    public ArrayList getPesananFormId(String idPesanan) throws SQLException{
        statement= connection.createStatement();
        resultSet=statement.executeQuery("SELECT barang.kd_barang as kd_barang, barang.nama_barang AS nama_barang, detail_pesanan.jumlah AS jumlah,\n" +
                                        "barang.harga_jual AS harga_jual, barang.harga_jual*jumlah AS total\n" +
                                        "FROM barang,detail_pesanan\n" +
                                        "WHERE detail_pesanan.id_pesanan="+idPesanan+" AND detail_pesanan.kd_barang=barang.kd_barang");
        
        ArrayList dataDetailPesanan=new ArrayList();
        while (resultSet.next()) {      
            HashMap hm =new HashMap();
            hm.put("kd_barang", resultSet.getString(1));
            hm.put("nama_barang", resultSet.getString(2));
            hm.put("jumlah", resultSet.getInt(3));
            hm.put("harga_jual", resultSet.getString(4));
            hm.put("total", resultSet.getString(5));
            
            dataDetailPesanan.add(hm);
        }
        return dataDetailPesanan;
    }
}
