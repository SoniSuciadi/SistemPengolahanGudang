/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author sonys
 */
public class vLaporan extends vBackground{
    JComboBox jcbKriteria;
    JButton btnSearch,btnPilih,btnReset;
    JDateChooser chooserTanggalAwal,chooserTanggalAkhir;
    JLabel lPemasukan;
    JTable tblLaporan;
    DefaultTableModel dtmPesanan,dtmBarang;
    public vLaporan(){
        JLabel lTitle= new JLabel("LAPORAN");
        lTitle.setBounds(0, 60, 1366, 50);
        lTitle.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        lTitle.setForeground(new java.awt.Color(0,255,234));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lkriteria=new JLabel("Cari Berdasarkan");
        lkriteria.setBounds(400, 130, 250, 30); 
        lkriteria.setFont(new java.awt.Font("Tahoma", 1, 22));
        lkriteria.setForeground(Color.BLACK);
        
        jcbKriteria=new JComboBox();
        jcbKriteria.addItem("Pemasukan");
        jcbKriteria.addItem("Sisa Barang");
        jcbKriteria.setBounds(600, 130, 180, 30);
        jcbKriteria.setFont(new java.awt.Font("Calibri", 1, 22));
        jcbKriteria.setForeground(Color.BLACK);
        jcbKriteria.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
        
         chooserTanggalAwal = new JDateChooser();
        chooserTanggalAwal.setLocale(Locale.US);
        chooserTanggalAwal.getJCalendar().setPreferredSize(new Dimension(200, 200));
//        chooser.setFont(new java.awt.Font("Tahoma", 1, 22));
        chooserTanggalAwal.setForeground(Color.BLACK);

        tblLaporan=new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblLaporan.setBounds(200, 200, 950, 400);
        tblLaporan.setFont(new java.awt.Font("Tahoma", 0, 21));
        tblLaporan.setRowHeight(30);
        tblLaporan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JPanel panelAwal = new JPanel();
        panelAwal.add(new JLabel("Tanggal"));
        panelAwal.add(chooserTanggalAwal);
        panelAwal.setBounds(520, 160, 200, 30); 
        panelAwal.setBackground(Color.WHITE);
        
        btnPilih=new JButton("PILIH");
        btnPilih.setBounds(800, 130, 160, 30);
        btnPilih.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnPilih.setBackground(Color.WHITE);
        btnPilih.setForeground(Color.BLACK);
        
      
        btnSearch=new JButton("SEARCH");
        btnSearch.setBounds(800, 130, 160, 30);
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setForeground(Color.BLACK);
        
        btnReset=new JButton("RESET");
        btnReset.setBounds(1000, 130, 160, 30);
        btnReset.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnReset.setBackground(Color.WHITE);
        btnReset.setForeground(Color.BLACK);
        
        lPemasukan=new JLabel();
        lPemasukan.setBounds(200, 600, 1000, 30); 
        lPemasukan.setFont(new java.awt.Font("Tahoma", 1, 22));
        lPemasukan.setForeground(Color.BLACK);
        
//        add(panelAwal);
        add(tblLaporan);
        add(lkriteria);
        add(jcbKriteria);
        add(btnPilih);
        add(btnReset);
        add(lPemasukan);
//        add(tblLaporan);
        setTitle("LAPORAN");
        setVisible(true);
    }
    public void btnResetAddActionListener (ActionListener a){
        btnReset.addActionListener(a);
        
    }
    public void btnPilihAddActionListener (ActionListener a){
        btnPilih.addActionListener(a);
    }
    public String getJDateChooser(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strdtver1=(String) sdf.format(chooserTanggalAwal.getDate());
        return strdtver1;
    }
    public String getSelectJCBLaporan(){
        return jcbKriteria.getSelectedItem().toString();
    }
    public void inquiryPemasukan(ArrayList rows){
        dtmPesanan=new DefaultTableModel();
        dtmPesanan.setColumnCount(0);
        dtmPesanan.addColumn("ID Pesanan");
        dtmPesanan.addColumn("ID Pengguna");
        dtmPesanan.addColumn("Nama Pengguna");
        dtmPesanan.addColumn("Total Harga");
        dtmPesanan.addColumn("Tanggal");
        dtmPesanan.setRowCount(0);
        Integer total=0;
        for (int i = 0; i < rows.size(); i++) {
            HashMap row= (HashMap) rows.get(i);
            total+=Integer.valueOf(row.get("total_harga").toString());
//            String kodeBarang=row.get("kd_Barang").toString();
//            String namaBarang=row.get("nama_Barang").toString();
//            String stok=row.get("Stok").toString();
//            String hargabeli=row.get("harga_beli").toString(); 
//            String hargajual=row.get("harga_jual").toString(); 
            dtmPesanan.addRow(new Object[]{row.get("id_pesanan"),row.get("id_pengguna"),row.get("nama_pengguna"),row.get("total_harga"),row.get("tanggal")});
        }
        tblLaporan.setModel(dtmPesanan);
        lPemasukan.setText("Rp. "+total);
       
    }
    public void inquirySisaBarang(ArrayList rows){
        dtmBarang=new DefaultTableModel();
        dtmBarang=new DefaultTableModel();
        dtmBarang.setColumnCount(0);
        dtmBarang.addColumn("Kode Barang");
        dtmBarang.addColumn("Nama Barang");
        dtmBarang.addColumn("Stok");
        dtmBarang.addColumn("Harga Beli");
        dtmBarang.addColumn("Harga Jual");
        dtmBarang.addColumn("Status Barang");
//        dtmPesanan.setRowCount(0);
        int dikid=0;
        for (int i = 0; i < rows.size(); i++) {
            HashMap row= (HashMap) rows.get(i);
              if (Integer.parseInt(row.get("stok").toString())<=5) {
                  dikid+=1;
            }
//            String kodeBarang=row.get("kd_Barang").toString();
//            String namaBarang=row.get("nama_Barang").toString();
//            String stok=row.get("Stok").toString();
//            String hargabeli=row.get("harga_beli").toString(); 
//            String hargajual=row.get("harga_jual").toString(); 
            dtmBarang.addRow(new Object[]{row.get("kd_barang"),row.get("nama_barang"),row.get("stok"),row.get("harga_jual"),row.get("harga_beli"),row.get("status_barang")});
        }
        tblLaporan.setModel(dtmBarang);
        lPemasukan.setText("Terdapat "+dikid+" yang Stoknya Kurang dari 5");
    }
}
