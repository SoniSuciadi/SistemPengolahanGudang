/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author sonys
 */

public class vMainMenu extends vBackground{
    private JLabel lUserId,lNama;
    private JButton btnDataBarang, btnDataPesanan,btnDataPengguna,btnLaporan;
    public vMainMenu(String userid, String nama){
        
        
        JLabel lWellcome= new JLabel("SELAMAT DATANG " + userid + " - " +nama);
        lWellcome.setBounds(0, 60, 1366, 50);
        lWellcome.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        lWellcome.setForeground(new java.awt.Color(0,255,234));
        lWellcome.setHorizontalAlignment(SwingConstants.CENTER);
        
        btnDataBarang=new JButton("DATA BARANG");
        btnDataBarang.setIcon(new ImageIcon(getClass().getResource("/Image/btn_data_barang.png")));
        btnDataBarang.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        btnDataBarang.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
        btnDataBarang.setVerticalAlignment      ( SwingConstants.TOP ) ;
        btnDataBarang.setHorizontalTextPosition ( SwingConstants.CENTER );
        btnDataBarang.setIconTextGap (10);
        btnDataBarang.setBounds(60, 230, 300, 300);
        btnDataBarang.setBackground(Color.WHITE);
        
        btnDataPesanan=new JButton("DATA PESANAN");
        btnDataPesanan.setIcon(new ImageIcon(getClass().getResource("/Image/btn_data_pesanan.png")));
        btnDataPesanan.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        btnDataPesanan.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
        btnDataPesanan.setVerticalAlignment      ( SwingConstants.TOP ) ;
        btnDataPesanan.setHorizontalTextPosition ( SwingConstants.CENTER );
        btnDataPesanan.setIconTextGap (10);
        btnDataPesanan.setBounds(370, 230, 300, 300);
        btnDataPesanan.setBackground(Color.WHITE);
        
        btnDataPengguna=new JButton("DATA PENGGUNA");
        btnDataPengguna.setIcon(new ImageIcon(getClass().getResource("/Image/btn_data_pengguna.png")));
        btnDataPengguna.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        btnDataPengguna.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
        btnDataPengguna.setVerticalAlignment      ( SwingConstants.TOP ) ;
        btnDataPengguna.setHorizontalTextPosition ( SwingConstants.CENTER );
        btnDataPengguna.setIconTextGap (10);
        btnDataPengguna.setBounds(680, 230, 300, 300);
        btnDataPengguna.setBackground(Color.WHITE);
        
        btnLaporan=new JButton("LAPORAN");
        btnLaporan.setIcon(new ImageIcon(getClass().getResource("/Image/btn_laporan.png")));
        btnLaporan.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
        btnLaporan.setVerticalTextPosition   ( SwingConstants.BOTTOM ) ;
        btnLaporan.setVerticalAlignment      ( SwingConstants.TOP ) ;
        btnLaporan.setHorizontalTextPosition ( SwingConstants.CENTER );
        btnLaporan.setIconTextGap (10);
        btnLaporan.setBounds(990, 230, 300, 300);
        btnLaporan.setBackground(Color.WHITE);
        
        add(lWellcome);
        add(btnDataBarang);
        add(btnDataPesanan);
        add(btnDataPengguna);
        add(btnLaporan);
        
        setTitle("HOME");
        setVisible(true);
    }
    public void btnDataBarangAddActionListener(ActionListener a){
        btnDataBarang.addActionListener(a);
    }
    public void btnDataPesananAddActionListener (ActionListener a){
        btnDataPesanan.addActionListener(a);
    }
    public void btnDataPenggunaAddActionListener(ActionListener a){
        btnDataPengguna.addActionListener(a);
    }
    public void btnLaporanAddActionListener (ActionListener a){
        btnLaporan.addActionListener(a);
    }
}
