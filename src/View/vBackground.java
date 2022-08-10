/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sonys
 */
public class vBackground extends JFrame{
    private  JButton btnLogout;
    public vBackground(){
        JPanel pAtas=new JPanel();
        pAtas.setBackground(new java.awt.Color(0,255,234));
        pAtas.setBounds(0, 0, 1366, 50);
        
        JLabel lNamaApk=new JLabel("APLIKASI PENJUALAN DAN MONITORING STOK AHONG CELL");
        lNamaApk.setBounds(10, 0, 900, 50);
        lNamaApk.setFont(new java.awt.Font("Tahoma", Font.BOLD, 21));
        lNamaApk.setForeground(Color.WHITE);
        
        btnLogout=new JButton("LOGOUT");
        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnLogout.setBounds(1230, 10, 100, 30);
        btnLogout.setForeground(new java.awt.Color(92,203,194));
        btnLogout.setBackground(Color.WHITE);
        
        add(lNamaApk);
        add(btnLogout);
        add(pAtas);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1366, 768);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        
    }
    public void btnLogoutAddActionListener( ActionListener a){
        btnLogout.addActionListener(a);
    }
     
    
}
