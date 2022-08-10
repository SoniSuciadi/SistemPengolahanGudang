/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sonys
 */
public class vPengguna extends vBackground{
    JTextField jtNama;
    String snamaPengguna=null;
    JTable tblPengguna;
    JButton btnSearch,btnTambah,btnSimpan,btnHapus;
    JTextField idPengguna,namaPengguna,alamat,noHpPengguna,password;
    JComboBox jabatan;
    JFrame fdisplay;
    public vPengguna(){
        JLabel lTitle= new JLabel("DATA PENGGUNA");
        lTitle.setBounds(0, 60, 1366, 50);
        lTitle.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        lTitle.setForeground(new java.awt.Color(0,255,234));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lNama=new JLabel("Nama Pengguna");
        lNama.setBounds(400, 130, 180, 30); 
        lNama.setFont(new java.awt.Font("Tahoma", 1, 22));
        lNama.setForeground(Color.BLACK);
        
        
        

        btnTambah=new JButton("TAMBAH");
        btnTambah.setBounds(990, 650, 160, 30);
        btnTambah.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnTambah.setBackground(Color.WHITE);
        btnTambah.setForeground(Color.BLACK);
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showFormPengguna();
            }
        });
        
        
        jtNama=new JTextField();
        jtNama.setBounds(585, 130, 200, 30);
        jtNama.setFont(new java.awt.Font("Tahoma", 0, 21));
        jtNama.setForeground(Color.BLACK);
        
        btnSearch=new JButton("SEARCH");
        btnSearch.setBounds(800, 130, 160, 30);
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setForeground(Color.BLACK);
        
        btnSimpan=new JButton("SIMPAN");
        btnSimpan.setBounds(30, 400, 160, 30);
        btnSimpan.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnSimpan.setBackground(Color.WHITE);
        btnSimpan.setForeground(Color.BLACK);
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fdisplay.dispose();
            }
        });
        
        btnHapus=new JButton("HAPUS");
        btnHapus.setBounds(220, 400, 160, 30);
        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 21));
        btnHapus.setBackground(Color.WHITE);
        btnHapus.setForeground(Color.BLACK);
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fdisplay.dispose();
            }
        });
        
        tblPengguna=new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPengguna.setBounds(200, 200, 950, 400);
        tblPengguna.setFont(new java.awt.Font("Tahoma", 0, 21));
        tblPengguna.setRowHeight(30);
        tblPengguna.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tblPengguna.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                snamaPengguna=tblPengguna.getValueAt(tblPengguna.getSelectedRow(), 1).toString();
                showFormPengguna();
                idPengguna.setText((String) tblPengguna.getValueAt(tblPengguna.getSelectedRow(), 0).toString());
                namaPengguna.setText((String) tblPengguna.getValueAt(tblPengguna.getSelectedRow(), 1).toString());
                alamat.setText((String) tblPengguna.getValueAt(tblPengguna.getSelectedRow(), 2).toString());
                noHpPengguna.setText((String) tblPengguna.getValueAt(tblPengguna.getSelectedRow(), 3).toString());
                jabatan.setSelectedItem((String) tblPengguna.getValueAt(tblPengguna.getSelectedRow(), 3).toString());
                password.setText("");
                
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
        
        JScrollPane scrollPane = new JScrollPane(tblPengguna);
        scrollPane.setBounds(200, 200, 950, 400);
        

        
        add(lTitle);
        add(lNama);
        add(jtNama);
        add(btnSearch);
        add(btnTambah);
        add(scrollPane);

      
        
        setTitle("DATA PENGGUNA");
        setVisible(true);
        
    }
    public String getNamaPengguna(){
        return snamaPengguna;
    }
    public void tblPenggunaAddActionListener(MouseListener a){
        tblPengguna.addMouseListener(a);
    }
    public String getNama(){
       return jtNama.getText();
    }
    public void setTablePengguna(ArrayList rows){
        DefaultTableModel dtmPengguna=new DefaultTableModel();
//        dtmPengguna.setColumnCount(0);
        dtmPengguna.setColumnCount(6);
        dtmPengguna.setRowCount(0);
        String[] col={"ID Pengguna","Nama Pengguna","Alamat","Nomor HP","Jabatan","Password"};
        dtmPengguna.setColumnIdentifiers(col);
        
        for (int i = 0; i < rows.size(); i++) {
            HashMap row= (HashMap) rows.get(i);
//            String kodeBarang=row.get("kd_Barang").toString();
//            String namaBarang=row.get("nama_Barang").toString();
//            String stok=row.get("Stok").toString();
//            String hargabeli=row.get("harga_beli").toString(); 
//            String hargajual=row.get("harga_jual").toString(); 
            dtmPengguna.addRow(new Object[]{row.get("id_pengguna"),row.get("nama_pengguna"),row.get("alamat_pengguna"),row.get("nohp_pengguna"),row.get("jabatan"),"*****************"});
        }
        
        tblPengguna.setModel(dtmPengguna);
        
    }
    
    
    public void showFormPengguna(){
        
         fdisplay=new JFrame("DISPLAY PENGGUNA");
        
        JLabel lidPengguna=new JLabel("ID Pengguna");
        lidPengguna.setBounds(30, 20, 180, 30);
        lidPengguna.setFont(new java.awt.Font("Calibri", 1, 22));
        lidPengguna.setForeground(Color.BLACK);
        
        idPengguna=new JTextField();
        idPengguna.setBounds(200, 20, 180, 30);
        idPengguna.setFont(new java.awt.Font("Calibri", 1, 22));
        idPengguna.setForeground(Color.BLACK);
        idPengguna.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JLabel lnamaPengguna=new JLabel("Nama Pengguna");
        lnamaPengguna.setBounds(30, 80, 180, 30);
        lnamaPengguna.setFont(new java.awt.Font("Calibri", 1, 22));
        lnamaPengguna.setForeground(Color.BLACK);
        
        namaPengguna=new JTextField();
        namaPengguna.setBounds(200, 80, 180, 30);
        namaPengguna.setFont(new java.awt.Font("Calibri", 1, 22));
        namaPengguna.setForeground(Color.BLACK);
        namaPengguna.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JLabel lAlamatPengguna=new JLabel("Alamat");
        lAlamatPengguna.setBounds(30, 140, 180, 30);
        lAlamatPengguna.setFont(new java.awt.Font("Calibri", 1, 22));
        lAlamatPengguna.setForeground(Color.BLACK);
        
        alamat=new JTextField();
        alamat.setBounds(200, 140, 180, 30);
        alamat.setFont(new java.awt.Font("Calibri", 1, 22));
        alamat.setForeground(Color.BLACK);
        alamat.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel lNoHP=new JLabel("No Hp");
        lNoHP.setBounds(30, 200, 180, 30);
        lNoHP.setFont(new java.awt.Font("Calibri", 1, 22));
        lNoHP.setForeground(Color.BLACK);
        
        noHpPengguna=new JTextField();
        noHpPengguna.setBounds(200, 200, 180, 30);
        noHpPengguna.setFont(new java.awt.Font("Calibri", 1, 22));
        noHpPengguna.setForeground(Color.BLACK);
        noHpPengguna.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));        
        
        JLabel lJabatan=new JLabel("Jabatan");
        lJabatan.setBounds(30, 260, 180, 30);
        lJabatan.setFont(new java.awt.Font("Calibri", 1, 22));
        lJabatan.setForeground(Color.BLACK);
        
        jabatan=new JComboBox();
        jabatan.addItem("Pembeli");
        jabatan.addItem("Gudang");
        jabatan.addItem("Penjualan");
        jabatan.addItem("Resign");
        jabatan.setBounds(200, 260, 180, 30);
        jabatan.setFont(new java.awt.Font("Calibri", 1, 22));
        jabatan.setForeground(Color.BLACK);
        jabatan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
        
        JLabel lPassword=new JLabel("Password");
        lPassword.setBounds(30, 320, 180, 30);
        lPassword.setFont(new java.awt.Font("Calibri", 1, 22));
        lPassword.setForeground(Color.BLACK);
        
        password=new JPasswordField();
        password.setBounds(200, 320, 180, 30);
        password.setFont(new java.awt.Font("Calibri", 1, 22));
        password.setForeground(Color.BLACK);
        password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
        
        
        
        fdisplay.add(lidPengguna);
        fdisplay.add(idPengguna);
        fdisplay.add(lnamaPengguna);
        fdisplay.add(namaPengguna);
        fdisplay.add(lAlamatPengguna);
        fdisplay.add(alamat);
        fdisplay.add(lNoHP);
        fdisplay.add(noHpPengguna);
        fdisplay.add(lJabatan);
        fdisplay.add(jabatan);
        fdisplay.add(lPassword);
        fdisplay.add(password);
        fdisplay.add(btnSimpan);
//        fdisplay.add(btnHapus);
        fdisplay.setSize(450,500);
        fdisplay.setLayout(null);
        fdisplay.setVisible(true);
        fdisplay.setDefaultCloseOperation(1);
    }
    public void btnSimpanAddActionListener(ActionListener a){
        btnSimpan.addActionListener(a);
    }
    public void btnHapusAddActionListener ( ActionListener a){
        btnHapus.addActionListener(a);
    }
    public void btnSearchAddActionListener ( ActionListener a){
        btnSearch.addActionListener(a);
    }
    public HashMap getFormPengguna(){
        HashMap hm=new HashMap();
        hm.put("id_pengguna", idPengguna.getText());
        hm.put("nama_pengguna", namaPengguna.getText());
        hm.put("alamat_pengguna", alamat.getText());
        hm.put("nohp_pengguna", noHpPengguna.getText());
        hm.put("jabatan", jabatan.getSelectedItem().toString());
        hm.put("password", password.getText());
        return hm;
        
    }
}
