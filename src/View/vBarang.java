/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sonys
 */
public class vBarang extends vBackground{
    private JTextField jtNamaBarang, tfKodeBarang,jtFNamaBarang,jtStok,jtHargaJual,jtHargaBeli;
    private JButton btnSearch, btnTambah, btnAdd,btnDelete;
    private JTable tblBarang;
    JComboBox jcbStatusBarang,jcbKodeBarang;
    JFrame jFormBarang;
    private DefaultTableModel dtmBarang;
    
    public vBarang(){
        JLabel lTitle= new JLabel("DATA BARANG");
        lTitle.setBounds(0, 60, 1366, 50);
        lTitle.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        lTitle.setForeground(new java.awt.Color(0,255,234));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);        
      
        JLabel lNamaBarang=new JLabel("Nama Barang");
        lNamaBarang.setBounds(400, 130, 180, 30);
        lNamaBarang.setFont(new java.awt.Font("Tahoma", 1, 22));
        lNamaBarang.setForeground(Color.BLACK);
        
        jtNamaBarang=new JTextField();
        jtNamaBarang.setBounds(585, 130, 200, 30);
        jtNamaBarang.setFont(new java.awt.Font("Tahoma", 0, 21));
        jtNamaBarang.setForeground(Color.BLACK);
        
        btnSearch=new JButton("SEARCH");
        btnSearch.setBounds(800, 130, 160, 30);
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setForeground(Color.BLACK);
        
       btnAdd= new JButton("ADD");
        btnAdd.setBounds(15, 470, 160, 50);
        btnAdd.setFont(new java.awt.Font("Calibri", 1, 22));
        btnAdd.setForeground(Color.BLACK);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jFormBarang.dispose();
            }
        });
        
        tblBarang=new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblBarang.setBounds(200, 200, 950, 400);
        tblBarang.setFont(new java.awt.Font("Tahoma", 0, 21));
        tblBarang.setRowHeight(30);
        tblBarang.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        
        tblBarang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
               formBarang();
               
//               .setText(tblBarang.getValueAt(tblBarang.getSelectedRow(), 0).toString()); 
               jtFNamaBarang.setText( tblBarang.getValueAt(tblBarang.getSelectedRow(), 1).toString()); 
               jtStok.setText(tblBarang.getValueAt(tblBarang.getSelectedRow(), 2).toString());
               jtHargaBeli.setText( tblBarang.getValueAt(tblBarang.getSelectedRow(), 3).toString()); 
               jtHargaJual.setText( tblBarang.getValueAt(tblBarang.getSelectedRow(), 4).toString()); 
               
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
        
        btnTambah=new JButton("TAMBAH");
        btnTambah.setBounds(990, 650, 160, 30);
        btnTambah.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnTambah.setBackground(Color.WHITE);
        btnTambah.setForeground(Color.BLACK);
        
        btnDelete= new JButton("HAPUS");
        btnDelete.setBounds(210, 400, 160, 50);
        btnDelete.setFont(new java.awt.Font("Calibri", 1, 22));
        btnDelete.setForeground(Color.BLACK);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jFormBarang.dispose();
            }
        });
        
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                formBarang();
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(tblBarang);
        scrollPane.setBounds(200, 200, 950, 400);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane);
        
        add(lTitle);
        add(lNamaBarang);
        add(jtNamaBarang);
        add(btnSearch);
        add(btnTambah);
        
        
        setTitle("DATA BARANG");
        setVisible(true);
    }
    

    public void setTable(ArrayList rows){
        dtmBarang=new DefaultTableModel();
        dtmBarang.setColumnCount(0);
        dtmBarang.addColumn("Kode Barang");
        dtmBarang.addColumn("Nama Barang");
        dtmBarang.addColumn("Stok");
        dtmBarang.addColumn("Harga Beli");
        dtmBarang.addColumn("Harga Jual");
        dtmBarang.addColumn("Status Barang");
        for (int i = 0; i < rows.size(); i++) {
            HashMap row= (HashMap) rows.get(i);
//            String kodeBarang=row.get("kd_Barang").toString();
//            String namaBarang=row.get("nama_Barang").toString();
//            String stok=row.get("Stok").toString();
//            String hargabeli=row.get("harga_beli").toString(); 
//            String hargajual=row.get("harga_jual").toString(); 
            dtmBarang.addRow(new Object[]{row.get("kd_barang"),row.get("nama_barang"),row.get("stok"),row.get("harga_beli"),row.get("harga_jual"),row.get("status_barang")});
        }
        tblBarang.setModel(dtmBarang);
        
       
    }
    public void formBarang( ){
         jFormBarang=new JFrame("FORM BARANG");
        
        JLabel lKategori=new JLabel("Kategori ");
        lKategori.setBounds(15, 20, 130, 30);
        lKategori.setFont(new java.awt.Font("Calibri", 1, 22));
        lKategori.setForeground(Color.BLACK);
        
        jcbKodeBarang=new JComboBox();
        jcbKodeBarang.addItem("Case");
        jcbKodeBarang.addItem("Power Bank");
        jcbKodeBarang.addItem("Tempred Glass");
        jcbKodeBarang.addItem("Flashdisk");
        jcbKodeBarang.addItem("Hardisk");
        jcbKodeBarang.setBounds(210, 20, 160, 30);
        jcbKodeBarang.setFont(new java.awt.Font("Calibri", 1, 22));
        jcbKodeBarang.setForeground(Color.BLACK);
        jcbKodeBarang.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JLabel lNamaBarang=new JLabel("Nama Barang");
        lNamaBarang.setBounds(15, 95, 130, 30);
        lNamaBarang.setFont(new java.awt.Font("Calibri", 1, 22));
        lNamaBarang.setForeground(Color.BLACK);
        
        jtFNamaBarang =new JTextField();
        jtFNamaBarang.setBounds(210, 95, 160, 30);
        jtFNamaBarang.setFont(new java.awt.Font("Calibri", 0, 21));
        jtFNamaBarang.setForeground(Color.BLACK);
                
        JLabel lStok=new JLabel("Stok");
        lStok.setBounds(15, 170, 130, 30);
        lStok.setFont(new java.awt.Font("Calibri", 1, 22));
        lStok.setForeground(Color.BLACK);
        
        
        jtStok=new JTextField();
        jtStok.setBounds(210, 170, 160, 30);
        jtStok.setFont(new java.awt.Font("Calibri", 1, 22));
        jtStok.setForeground(Color.BLACK);
        jtStok.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JLabel lHargaJual=new JLabel("Harga Jual");
        lHargaJual.setBounds(15, 245, 130, 30);
        lHargaJual.setFont(new java.awt.Font("Calibri", 1, 22));
        lHargaJual.setForeground(Color.BLACK);
        
        jtHargaJual=new JTextField();
        jtHargaJual.setBounds(210, 245, 160, 30);
        jtHargaJual.setFont(new java.awt.Font("Calibri", 0, 20));
        jtHargaJual.setForeground(Color.BLACK);
        
        JLabel lHargaBeli=new JLabel("Harga Beli");
        lHargaBeli.setBounds(15, 320, 130, 30);
        lHargaBeli.setFont(new java.awt.Font("Calibri", 1, 22));
        lHargaBeli.setForeground(Color.BLACK);
        
        jtHargaBeli=new JTextField();
        jtHargaBeli.setBounds(210, 320, 160, 30);
        jtHargaBeli.setFont(new java.awt.Font("Calibri", 0, 20));
        jtHargaBeli.setForeground(Color.BLACK);
       
        JLabel lStatusBarang=new JLabel("Status");
        lStatusBarang.setBounds(15, 395, 130, 30);
        lStatusBarang.setFont(new java.awt.Font("Calibri", 1, 22));
        lStatusBarang.setForeground(Color.BLACK);
        
        
        jcbStatusBarang=new JComboBox();
        jcbStatusBarang.addItem("Available");
        jcbStatusBarang.addItem("Not Available");
        jcbStatusBarang.setBounds(210, 395, 150, 30);
        jcbStatusBarang.setFont(new java.awt.Font("Calibri", 1, 22));
        jcbStatusBarang.setForeground(Color.BLACK);
        jcbStatusBarang.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
//        btnAdd= new JButton("ADD");
//        btnAdd.setBounds(15, 400, 160, 50);
//        btnAdd.setFont(new java.awt.Font("Calibri", 1, 22));
//        btnAdd.setForeground(Color.BLACK);
        
        
        
        jFormBarang.add(lKategori);
        jFormBarang.add(jcbKodeBarang);
        jFormBarang.add(lNamaBarang);
        jFormBarang.add(jtFNamaBarang);
        jFormBarang.add(lStok);
        jFormBarang.add(jtStok);
        jFormBarang.add(lHargaJual);
        jFormBarang.add(jtHargaJual);
        jFormBarang.add(lHargaBeli);
        jFormBarang.add(jtHargaBeli);
        jFormBarang.add(lStatusBarang);
        jFormBarang.add(jcbStatusBarang);
        jFormBarang.add(btnAdd);
//        jFormBarang.add(btnDelete);
        jFormBarang.getContentPane().setBackground(Color.WHITE);
        
        jFormBarang.setSize(400,600);
        jFormBarang.setLayout(null);
        jFormBarang.setVisible(true);
        jFormBarang.setDefaultCloseOperation(1);
    }
    public void btnAddActionListener(ActionListener a){
        btnAdd.addActionListener(a);
    }
    public void btnDeleteAddActionListener(ActionListener a){
        btnDelete.addActionListener(a);
    }
    public void btnSearchAddActionListener (ActionListener a){
        btnSearch.addActionListener(a);
    }
    public String getNameField(){
        return jtNamaBarang.getText().toString();
    }
    public JTable getTable(){
        return tblBarang;
    }
    public HashMap getForm(){
        
        HashMap hashMap=new HashMap();
        Random rand = new Random();
        int randomNum = rand.nextInt((1000 - 99) +1) + 99;
        System.out.println(randomNum);
        if (jcbKodeBarang.getSelectedItem().toString().equals("Case")) {
            hashMap.put("kd_barang", "CS"+randomNum);
        }else if (jcbKodeBarang.getSelectedItem().toString().equals("Power Bank")) {
            hashMap.put("kd_barang", "PB"+randomNum);
        }else if (jcbKodeBarang.getSelectedItem().toString().equals("Tempred Glass")) {
            hashMap.put("kd_barang", "TG"+randomNum);
        }else if (jcbKodeBarang.getSelectedItem().toString().equals("Flashdisk")) {
            hashMap.put("kd_barang", "FD"+randomNum);
        }else if (jcbKodeBarang.getSelectedItem().toString().equals("Hardisk")) {
            hashMap.put("kd_barang", "HD"+randomNum);
        }
        
            hashMap.put("nama_barang", jtFNamaBarang.getText().toString());
            hashMap.put("stok", Integer.valueOf(jtStok.getText()));
            hashMap.put("harga_beli",Integer.valueOf(jtHargaBeli.getText()));
            hashMap.put("harga_jual",Integer.valueOf(jtHargaJual.getText()));
            hashMap.put("status_barang",jcbStatusBarang.getSelectedItem().toString());
        return hashMap;
    }
    public void setForm(String kdBarang, String namaBarang, String stok, String hargaBeli, String hargaJual){
        formBarang();
        tfKodeBarang.setText(kdBarang);
        jtFNamaBarang.setText(namaBarang);
        jtStok      .setText(stok);
        jtHargaJual        .setText(hargaJual);
        jtHargaBeli        .setText(hargaBeli);
                
    }
}
