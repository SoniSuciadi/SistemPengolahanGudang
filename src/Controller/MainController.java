/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Barang;
import Model.DetailPesanan;
import Model.Pengguna;
import Model.Pesanan;
import View.vBackground;
import View.vBarang;
import View.vLaporan;
import View.vLogin;
import View.vMainMenu;
import View.vPengguna;
import View.vPesanaan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author sonys
 */
public class MainController {

    public void MainController() {
        vLogin login=new vLogin();
        Pengguna pengguna=new Pengguna();
        Barang barang=new Barang();
        Pesanan pesanan=new Pesanan();
        login.btnLoginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean statusLogin=false;
                String userID="";
                String nama="";
                try {
                    ArrayList dataPenggunas=pengguna.getPengguna();
                    for (int i = 0; i < dataPenggunas.size(); i++) {
                        HashMap dataPengguna=(HashMap) dataPenggunas.get(i);
                        System.out.println(dataPengguna.get("id_pengguna"));
                        System.out.println(dataPengguna.get("password"));
                        if ((dataPengguna.get("id_pengguna").equals(login.getUsername())) && (dataPengguna.get("password").equals(login.getPassword()))) {
                            statusLogin=true;
//                            userID=dataPengguna.get(dataPengguna.get("id_pengguna")).toString();
//                            nama=dataPengguna.get(dataPengguna.get("nama_pengguna")).toString();
                            
                        }
                        
                        
                    }
                    if (statusLogin==true) {
                        JOptionPane.showMessageDialog( null, "Mantap");
                        login.dispose();
                        vMainMenu mainMenu=new vMainMenu("", "");
                        mainMenu.btnLogoutAddActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                reload();
                                mainMenu.dispose();
                            }
                        });
                        mainMenu.btnLogoutAddActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                mainMenu.dispose();
                                reload();
                            }
                        });
                        mainMenu.btnDataBarangAddActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                mainMenu.dispose();
                                vBarang dataBarang=new vBarang();
                                try {
                                    dataBarang.setTable(barang.getDataBarang());
                                } catch (SQLException ex) {
                                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                mainMenu.btnLogoutAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        dataBarang.dispose();
                                        reload();
                                    }
                                });
                                dataBarang.btnAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        HashMap hm= dataBarang.getForm();
                                        
                                        Integer next=0;
                                        int hrgjual=Integer.parseInt(hm.get("harga_jual").toString());
                                        int hrgbeli=Integer.parseInt(hm.get("harga_beli").toString());
                                        if (hrgbeli==0 | hrgjual==0) {
                                            JOptionPane.showMessageDialog( null, "Harga Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                                            next=3;
                                        }else if (hrgbeli<=0 | hrgjual<=0) {
                                            JOptionPane.showMessageDialog( null, "Harga Tidak Boleh Minus", "Error", JOptionPane.ERROR_MESSAGE);
                                            next=3;
                                        }  else if (hrgjual<=hrgbeli) {
                                            JOptionPane.showMessageDialog( null, "Harga Jual Tidak Boleh Lebih Kecil", "Error", JOptionPane.ERROR_MESSAGE);
                                            next=3;
                                        } else if (Integer.parseInt(hm.get("stok").toString())<=0) {
                                            JOptionPane.showMessageDialog( null, "Input Stok Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                                            next=3;
                                        }else if (hm.get("nama_barang").equals("")) {
                                            JOptionPane.showMessageDialog( null, "Nama Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                                            next=3;
                                        }else if (hm.get("kd_barang").equals("")) {
                                            JOptionPane.showMessageDialog( null, "Kode Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                                            next=3;
                                        }
                                        
                                        
                                        try {
                                            boolean updateStatus=false;
                                            for (int i = 0; i < barang.getDataBarang().size(); i++) {
                                                HashMap hmbarang=(HashMap) barang.getDataBarang().get(i);
                                                if (hm.get("kd_barang").equals(hmbarang.get("kd_barang"))) {
                                                    updateStatus=true;
                                                    break;
                                                }
                                                
                                            }
                                            if (updateStatus==true && next ==0) {
                                                int jawab = JOptionPane.showOptionDialog(null, "Yakin Ingin Merubah Data ?", "Ubah", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                                                switch(jawab){
                                                    case JOptionPane.YES_OPTION: 
                                                        barang.editbarang(hm);
                                                        break;
                                                    case JOptionPane.NO_OPTION:
                                                        JOptionPane.showMessageDialog(null, "Dibatalkan");
                                                        break;
                                           
                                        }
                                                
                                                
                                            }else if (updateStatus==false && next ==0) {
                                                barang.insertBarang(hm);
                                            }
{
                                               
                                            }
                                            dataBarang.setTable(new Barang().getDataBarang());
                                            
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                      
                                    }
                                    
                                });
                                dataBarang.btnDeleteAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        int jawab = JOptionPane.showOptionDialog(null, "Yakin Ingin Menghapus Data ?", "Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                                                switch(jawab){
                                                    case JOptionPane.YES_OPTION: 
                                                        barang.hapusbarang(dataBarang.getForm().get("kd_barang").toString());
                                                        break;
                                                    case JOptionPane.NO_OPTION:
                                                        JOptionPane.showMessageDialog(null, "Dibatalkan");
                                                        break;
                                           
                                        }
                                        
                                        
                                        try {
                                            dataBarang.setTable(new Barang().getDataBarang());
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                dataBarang.btnSearchAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        try {
                                            dataBarang.setTable(barang.getDataBarangByName(dataBarang.getNameField()));
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                dataBarang.btnLogoutAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        dataBarang.dispose();
                                        reload();
                                    }
                        });
                                
                            }
                        });
                        mainMenu.btnDataPesananAddActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                mainMenu.dispose();
                                vPesanaan pesanaan=new vPesanaan();
                                try {
                                    pesanaan.setTable(pesanan.getDataPesanan());
                                    pesanaan.getTblPesanan().addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent me) {
                                            try {
                                                pesanaan.setTableDetailPesanan(new DetailPesanan().getPesananFormId(pesanaan.getSelectedRow()));
                                                System.out.println("berhasil");
                                                
                                            } catch (SQLException ex) {
                                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                                System.out.println("gagal");
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
                                } catch (SQLException ex) {
                                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                pesanaan.btnTerimaAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        try {
                                            ArrayList dataPesanan=new DetailPesanan().getPesananFormId(pesanaan.getnoinvoice());
                                            for (int i = 0; i < dataPesanan.size(); i++) {
                                                HashMap hashMap=(HashMap) dataPesanan.get(i); 
                                                barang.potongStok(hashMap.get("kd_barang").toString(), (Integer) hashMap.get("jumlah"));
                                            }
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        int jawab = JOptionPane.showOptionDialog(null, "Yakin Ingin Terima Pesanan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                                                switch(jawab){
                                                    case JOptionPane.YES_OPTION: 
                                                        if (pesanaan.getTblPesanan().getValueAt(pesanaan.getTblPesanan().getSelectedRow(), 5).toString().equals("Belum Diterima")) {
                                                            pesanan.terimaPesanan(pesanaan.getnoinvoice());
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "Pesanan Telah Diterima");
                                                        }
                                                        
                                                        break;
                                                    case JOptionPane.NO_OPTION:
                                                        JOptionPane.showMessageDialog(null, "Dibatalkan");
                                                        break;
                                           
                                        }
                                        
                                        
                                        
                                        try {
                                            pesanaan.setTable(new Pesanan().getDataPesanan());
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        
                                    }
                                });
                                pesanaan.btnSearchAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        try {
                                            System.out.println(pesanaan.getJDateChooser());
                                            pesanaan.setTable(pesanan.getDataPesananbyDate(pesanaan.getJDateChooser()));
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                pesanaan.btnLogoutAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        pesanaan.dispose();
                                        reload();
                                    }
                                });
                            }
                            
                        });
                        mainMenu.btnDataPenggunaAddActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                mainMenu.dispose();
                                vPengguna vpengguna=new vPengguna();
                                vpengguna.btnLogoutAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        vpengguna.dispose();
                                       
                                        reload();
                                        
                                    }
                                });
                                try {
                                    vpengguna.setTablePengguna(new Pengguna().getPengguna());
                                } catch (SQLException ex) {
                                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                vpengguna.btnSimpanAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        boolean statusUpdate=false;
                                        try {
                                            for (int i = 0; i < pengguna.getPengguna().size(); i++) {
                                                HashMap hm=(HashMap) pengguna.getPengguna().get(i);
                                                if (vpengguna.getFormPengguna().get("id_pengguna").equals(hm.get("id_pengguna"))) {
                                                    statusUpdate=true;
                                                    break;
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        boolean valid=true;
                                        HashMap hm=vpengguna.getFormPengguna();
                                        if (hm.get("id_pengguna").equals("")) {
                                            JOptionPane.showMessageDialog( null, "ID Pengguna Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                                            valid=false;
                                        }else if (hm.get("nama_pengguna").equals("")) {
                                            JOptionPane.showMessageDialog( null, "Nama Pengguna Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                                            valid=false;
                                        }else if (hm.get("alamat_pengguna").equals("")) {
                                            JOptionPane.showMessageDialog( null, "Alamat Pengguna Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                                            valid=false;
                                        }else if (hm.get("nohp_pengguna").equals("")) {
                                            JOptionPane.showMessageDialog( null, "NO HP Pengguna Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                                            valid=false;
                                        }else if (hm.get("password").equals("")) {
                                            JOptionPane.showMessageDialog( null, "Password Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
                                            valid=false;
                                        }
                                        
                                        
                                        if (statusUpdate==true && valid==true) {
                                            int jawab = JOptionPane.showOptionDialog(null, "Yakin Ingin Merubah Data ?", "Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                                            switch(jawab){
                                                case JOptionPane.YES_OPTION: 
                                                    pengguna.updatePengguna(vpengguna.getFormPengguna());
                                                    break;
                                                case JOptionPane.NO_OPTION:
                                                    JOptionPane.showMessageDialog(null, "Dibatalkan");
                                                    break;
                                           
                                        }
                                            
                                            
                                        }else if (statusUpdate==false && valid==true) {
                                            pengguna.insertPengguna(vpengguna.getFormPengguna());
                                        }
{
                                            
                                            
                                        }
                                        try {
                                            vpengguna.setTablePengguna(pengguna.getPengguna());
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    
                                    
                                });
                                
                                vpengguna.btnHapusAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        int jawab = JOptionPane.showOptionDialog(null, "Yakin Ingin Menghapus Data ?", "Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                                        switch(jawab){
                                            case JOptionPane.YES_OPTION: 
                                                pengguna.hapusPengguna(vpengguna.getFormPengguna().get("id_pengguna").toString());
                                                break;
                                            case JOptionPane.NO_OPTION:
                                                JOptionPane.showMessageDialog(null, "Dibatalkan");
                                                break;
                                           
                                        }
                                       
                                        try {
                                            vpengguna.setTablePengguna(new Pengguna().getPengguna());
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                vpengguna.btnSearchAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        try {
                                            vpengguna.setTablePengguna(new Pengguna().getPenggunaByName(vpengguna.getNama()));
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                            }
                            
                        });
                        mainMenu.btnLaporanAddActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                vLaporan laporan=new vLaporan();
                                mainMenu.dispose();
                                laporan.btnPilihAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (laporan.getSelectJCBLaporan().equals("Pemasukan")) {
                                            Date now = new Date();
                                            String pattern = "yyyy-MM-dd";
                                            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
                                            String mysqlDateString = formatter.format(now);

                                            try {
                                                laporan.inquiryPemasukan(pesanan.getDataPesananbyDate(mysqlDateString));
                                            } catch (SQLException ex) {
                                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }else if (laporan.getSelectJCBLaporan().equals("Sisa Barang")) {
                                            try {
                                                laporan.inquirySisaBarang(barang.getDataBarangASC());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        
                                        
                                    }
                                });
                                laporan.btnLogoutAddActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                       laporan.dispose();
                                        reload();
                                    }
                                });
                            }
                        });
                        
                    
                    
                    }else{
                    JOptionPane.showMessageDialog( null, "Gagal", "Error", JOptionPane.ERROR_MESSAGE);
                }
                } catch (SQLException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               
            }
        });
    }
    public void reload(){
        MainController();
    }
    
}
