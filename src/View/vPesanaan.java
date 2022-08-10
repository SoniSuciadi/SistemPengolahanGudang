package View;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sonys
 */

public class vPesanaan extends vBackground{
    JTextField jtTanggal;
    JLabel idPembeli,namaPembeli,total,noinvoice,tanggal;
    JTable tblDetailPesanan;
    JButton btnSearch,btnTerima;
    JDateChooser chooser;
    JTable tblPesanan;
    String selectedRow;
    JFrame fdisplay;
    public vPesanaan(){
        JLabel lTitle= new JLabel("DATA PESANAN");
        lTitle.setBounds(0, 60, 1366, 50);
        lTitle.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        lTitle.setForeground(new java.awt.Color(0,255,234));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lTanggal=new JLabel("Tanggal");
        lTanggal.setBounds(400, 130, 180, 30); 
        lTanggal.setFont(new java.awt.Font("Tahoma", 1, 22));
        lTanggal.setForeground(Color.BLACK);
        
        
        chooser = new JDateChooser();
        chooser.setLocale(Locale.US);
        chooser.getJCalendar().setPreferredSize(new Dimension(200, 200));
//        chooser.setFont(new java.awt.Font("Tahoma", 1, 22));
        chooser.setForeground(Color.BLACK);
        

       
        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Tanggal Pesanan"));
        panel.add(chooser);
        panel.setBounds(500, 130, 250, 50); 
        panel.setBackground(Color.WHITE);
        
        jtTanggal=new JTextField();
        jtTanggal.setBounds(585, 130, 200, 30);
        jtTanggal.setFont(new java.awt.Font("Tahoma", 0, 21));
        jtTanggal.setForeground(Color.BLACK);
        
        btnSearch=new JButton("SEARCH");
        btnSearch.setBounds(800, 130, 160, 30);
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setForeground(Color.BLACK);
        
        btnTerima=new JButton("Terima");
        btnTerima.setBounds(400, 140, 160, 30);
        btnTerima.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnTerima.setBackground(Color.WHITE);
        btnTerima.setForeground(Color.BLACK);
        btnTerima.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fdisplay.dispose();
            }
        });
        
        tblPesanan=new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPesanan.setBounds(200, 200, 950, 400);
        tblPesanan.setFont(new java.awt.Font("Tahoma", 0, 21));
        tblPesanan.setRowHeight(30);
        tblPesanan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tblPesanan.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                showDetailOrder();
                selectedRow=(String) tblPesanan.getValueAt(tblPesanan.getSelectedRow(), 0).toString();
                idPembeli.setText((String) tblPesanan.getValueAt(tblPesanan.getSelectedRow(), 1).toString()); 
                namaPembeli.setText((String) tblPesanan.getValueAt(tblPesanan.getSelectedRow(), 2).toString()); 
                total.setText( tblPesanan.getValueAt(tblPesanan.getSelectedRow(), 3).toString()); 
                noinvoice.setText((String) tblPesanan.getValueAt(tblPesanan.getSelectedRow(), 0).toString()); 
                tanggal.setText((String) tblPesanan.getValueAt(tblPesanan.getSelectedRow(), 4).toString()); 
//                System.err.println(tblPesanan.getValueAt(tblPesanan.getSelectedRow(), 5));
                if (tblPesanan.getValueAt(tblPesanan.getSelectedRow(), 5).toString().equals("Belum Diterima")) {
                    fdisplay.add(btnTerima);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {
               
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }

           
        });
        JScrollPane scrollPane = new JScrollPane(tblPesanan);
        scrollPane.setBounds(200, 200, 950, 400);
        
//        add(lTanggal);
//        add(jtTanggal);
        add(btnSearch);
        add(panel);
        add(lTitle);
//        add(tblPesanan);
        add(scrollPane);
        
        setTitle("DATA PESANAAN");
        setVisible(true);
    }
    public String getJDateChooser(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strdtver1=(String) sdf.format(chooser.getDate());
        return strdtver1;
    }
    public String getSelectedRow(){
        return selectedRow;
    }
    public String getDateSelected(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tgll=sdf.format(chooser.getDate());
        return tgll;
    }
    public void btnSearchAddActionListener(ActionListener a){
        btnSearch.addActionListener(a);
    }
    public String getnoinvoice(){
        return noinvoice.getText().toString();
    }
    
    
    public void setTableDetailPesanan(ArrayList detailPesanan){
        DefaultTableModel dtmdetail=new DefaultTableModel();
        dtmdetail.setColumnCount(5);
        dtmdetail.setRowCount(0);
        String[] col={"Kode Barang","Nama Barang","Jumlah","Harga","Total"};
        dtmdetail.setColumnIdentifiers(col);
        for (int i = 0; i < detailPesanan.size(); i++) {
            HashMap row=(HashMap) detailPesanan.get(i);
            dtmdetail.addRow(new Object[]{row.get("kd_barang"),row.get("nama_barang"),row.get("jumlah"),row.get("harga_jual"),row.get("total")});
        }
        tblDetailPesanan.setModel(dtmdetail);
       
                
    }
    public void setTable(ArrayList rows){
        DefaultTableModel dtmPesanan=new DefaultTableModel();
        dtmPesanan.addColumn("ID Pesanan");
        dtmPesanan.addColumn("ID Pengguna");
        dtmPesanan.addColumn("Nama Pengguna");
        dtmPesanan.addColumn("Total Harga");
        dtmPesanan.addColumn("Tanggal");
        dtmPesanan.addColumn("Status");
        
        for (int i = 0; i < rows.size(); i++) {
            HashMap row= (HashMap) rows.get(i);
//            String kodeBarang=row.get("kd_Barang").toString();
//            String namaBarang=row.get("nama_Barang").toString();
//            String stok=row.get("Stok").toString();
//            String hargabeli=row.get("harga_beli").toString(); 
//            String hargajual=row.get("harga_jual").toString(); 
            dtmPesanan.addRow(new Object[]{row.get("id_pesanan"),row.get("id_pengguna"),row.get("nama_pengguna"),row.get("total_harga"),row.get("tanggal"),row.get("status")});
        }
        tblPesanan.setModel(dtmPesanan);
        
       
    }
    
    public void showDetailOrder(){
        
        fdisplay=new JFrame("DISPLAY PENJUALAN");
        
        JLabel lidPembeli=new JLabel("ID Pembeli");
        lidPembeli.setBounds(30, 20, 180, 30);
        lidPembeli.setFont(new java.awt.Font("Calibri", 1, 22));
        lidPembeli.setForeground(Color.BLACK);
        
        idPembeli=new JLabel();
        idPembeli.setBounds(200, 20, 180, 30);
        idPembeli.setFont(new java.awt.Font("Calibri", 1, 22));
        idPembeli.setForeground(Color.BLACK);
        idPembeli.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JLabel lnamaPembeli=new JLabel("Nama Pembeli");
        lnamaPembeli.setBounds(30, 80, 180, 30);
        lnamaPembeli.setFont(new java.awt.Font("Calibri", 1, 22));
        lnamaPembeli.setForeground(Color.BLACK);
        
        namaPembeli=new JLabel();
        namaPembeli.setBounds(200, 80, 180, 30);
        namaPembeli.setFont(new java.awt.Font("Calibri", 1, 22));
        namaPembeli.setForeground(Color.BLACK);
        namaPembeli.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JLabel ltotal=new JLabel("Total");
        ltotal.setBounds(30, 140, 180, 30);
        ltotal.setFont(new java.awt.Font("Calibri", 1, 22));
        ltotal.setForeground(Color.BLACK);
        
        total=new JLabel("Total");
        total.setBounds(200, 140, 180, 30);
        total.setFont(new java.awt.Font("Calibri", 1, 22));
        total.setForeground(Color.BLACK);
        total.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel lnoinvoice=new JLabel("No. Invoice");
        lnoinvoice.setBounds(30, 200, 180, 30);
        lnoinvoice.setFont(new java.awt.Font("Calibri", 1, 22));
        lnoinvoice.setForeground(Color.BLACK);
        
        noinvoice=new JLabel();
        noinvoice.setBounds(200, 200, 180, 30);
        noinvoice.setFont(new java.awt.Font("Calibri", 1, 22));
        noinvoice.setForeground(Color.BLACK);
        noinvoice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));        
        
        JLabel ltanggal=new JLabel("Tanggal");
        ltanggal.setBounds(30, 260, 180, 30);
        ltanggal.setFont(new java.awt.Font("Calibri", 1, 22));
        ltanggal.setForeground(Color.BLACK);
        
        tanggal=new JLabel();
        tanggal.setBounds(200, 260, 180, 30);
        tanggal.setFont(new java.awt.Font("Calibri", 1, 22));
        tanggal.setForeground(Color.BLACK);
        tanggal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
        
        tblDetailPesanan = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblDetailPesanan.setBounds(10, 320, 563,320);
        tblDetailPesanan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JScrollPane scrollPane = new JScrollPane(tblDetailPesanan);
        scrollPane.setBounds(10, 320, 563,320);
        
        
//        fdisplay.add(tblDetailPesanan);
        fdisplay.add(lidPembeli);
        fdisplay.add(idPembeli);
        fdisplay.add(lnamaPembeli);
        fdisplay.add(namaPembeli);
        fdisplay.add(ltotal);
        fdisplay.add(total);
        fdisplay.add(lnoinvoice);
        fdisplay.add(noinvoice);
        fdisplay.add(ltanggal);
        fdisplay.add(tanggal);
        fdisplay.setBackground(Color.WHITE);
        fdisplay.setSize(600,700);
        fdisplay.setLayout(null);
        fdisplay.setVisible(true);
        fdisplay.add(scrollPane);
        fdisplay.setDefaultCloseOperation(1);
    }
    public JTable getTblPesanan(){
        return tblPesanan;
    }
    public void btnTerimaAddActionListener(ActionListener a){
        btnTerima.addActionListener(a);
    }
}
