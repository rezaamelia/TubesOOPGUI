/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Pelanggan;
import Model.Petugas;
import Model.TempatWisata;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.*;

/**
 *
 * @author Reza Amelia
 */
public class Controller implements ActionListener {

    Database db;
    View.mainMenu mm;
    View.Pelanggan pel;
    View.Petugas pet;
    View.Paket pak;
    View.Perjalanan pjl;
    View.Tempat tem;
    View.TambahPerjalanan tp;
    View.TambahPelanggan tpel;
    View.TambahPetugas tpet;
    tubes.TambahPaket tpk;
    View.TambahTempat ttm;
    View.ViewTempatWisata vt;
    View.ViewPelanggan vpel;
    View.ViewPetugas vpet;
    View.ViewPerjalanan vpjl;
    View.ViewPaketWisata vpkt;
    View.DeletePelanggan dpel;
    View.DeletePetugas dpet;
    View.DeleteTempat dtem;
    View.DeletePaket dpak;
    View.DeletePerjalanan dpjl;
    View.EditPelanggan edpel;
    View.EditPetugas edpet;
    View.EditTempat edtem;
    View.EditPaket edpak;
    View.EditPerjalanan edpjl;
    

    public Controller() {
        db = new Database();

        //View Menu Pelanggan
        pel = new View.Pelanggan();
        pel.getTmbhplng().addActionListener(this);
        pel.getDeleteplng().addActionListener(this);
        pel.getEditplng().addActionListener(this);
        pel.getViewplng().addActionListener(this);
        pel.getKembaliplng().addActionListener(this);
        
        //View Menu Petugas
        pet = new View.Petugas();
        pet.getTmbhptg().addActionListener(this);
        pet.getDeleteptg().addActionListener(this);
        pet.getViewptg().addActionListener(this);
        pet.getEditptg().addActionListener(this);
        pet.getKembaliptg().addActionListener(this);
        
        //View Menu Tempat
        tem = new View.Tempat();
        tem.getTmbhtmp().addActionListener(this);
        tem.getDeletetmp().addActionListener(this);
        tem.getViewtmp().addActionListener(this);
        tem.getEdittmp().addActionListener(this);
        tem.getKembalitmp().addActionListener(this);
        
        //View Menu Paket
        pak = new View.Paket();
        pak.getTmbhpkt().addActionListener(this);
        pak.getDeletepkt().addActionListener(this);
        pak.getViewpkt().addActionListener(this);
        pak.getKembalipkt().addActionListener(this);
        
        //View Menu Perjalanan
        pjl = new View.Perjalanan();
        pjl.getTmbhpjl().addActionListener(this);
        pjl.getDeletepjl().addActionListener(this);
        pjl.getViewpjl().addActionListener(this);
        pjl.getKembalipjl().addActionListener(this);
        
        // View Tambah Perjalanan
        tp = new View.TambahPerjalanan();
        tp.getBtnkembalipjl().addActionListener(this);
        tp.getBtnsmpnpjl().addActionListener(this);
        tp.getCbpwisata().addActionListener(this);
        tp.getBtnCek().addActionListener(this);
        tp.getBtnCek2().addActionListener(this);
        
        // View Tambah Pelanggan 
        tpel = new View.TambahPelanggan();
        tpel.getBtnsmpnplg().addActionListener(this);
        tpel.getBtnkembaliplg().addActionListener(this);

        // View Tambah Petugas
        tpet = new View.TambahPetugas();
        tpet.getBtnsmpnptgs().addActionListener(this);
        tpet.getBtnkembaliptgs().addActionListener(this);

        // View Tambah Paket
        tpk = new tubes.TambahPaket();

        // View Tambah Tempat
        ttm = new View.TambahTempat();
        ttm.getBtnsmpntmp().addActionListener(this);
        ttm.getBtnkembalitmp().addActionListener(this);

        // View View Tempat Wisata
        vt = new View.ViewTempatWisata();

        // View Main Menu
        mm = new View.mainMenu();
        mm.getBtnperjalanan().addActionListener(this);
        mm.getBtntempatwisata().addActionListener(this);
        mm.getBtnpaketwisata().addActionListener(this);
        mm.getBtnpelanggan().addActionListener(this);
        mm.getBtnpetugas().addActionListener(this);
        
        // View Pelanggan
        vpel = new View.ViewPelanggan();
        vpel.getKembaliViewPel().addActionListener(this);

        // View Petugas
        vpet = new View.ViewPetugas();
        vpet.getKembaliViewPet().addActionListener(this);
        
        // View Tempat
        vt = new View.ViewTempatWisata();
        vt.getKembaliViewTem().addActionListener(this);
        
        //Menu Delete Pelanggan
        dpel = new View.DeletePelanggan();
        dpel.getBtnDelPel().addActionListener(this);
        dpel.getBtnKembali().addActionListener(this);
        
        //Menu Delete Petugas
        dpet = new View.DeletePetugas();
        dpet.getBtnDelPet().addActionListener(this);
        dpet.getBtnKembali().addActionListener(this);
        
        //Menu Delete Tempat
        dtem = new View.DeleteTempat();
        dtem.getBtnDelTem().addActionListener(this);
        dtem.getBtnKembali().addActionListener(this);
        
        //Menu Delete Perjalanan
        dpjl = new View.DeletePerjalanan();
        dpjl.getBtnDelPjl().addActionListener(this);
        dpjl.getBtnKembali().addActionListener(this);
        
        //Menu Delete Paket
        dpak = new View.DeletePaket();
        dpak.getBtnDelPak().addActionListener(this);
        dpak.getBtnKembali().addActionListener(this);
        
        //Menu Edit Pelanggan
        edpel = new View.EditPelanggan();
        edpel.getBtnKembali().addActionListener(this);
        edpel.getBtnSimpan().addActionListener(this);
        
        //Menu Edit Petugas
        edpet = new View.EditPetugas();
        edpet.getBtnKembali().addActionListener(this);
        edpet.getBtnSimpan().addActionListener(this);
        
        //Menu Edit Tempat
        edtem = new View.EditTempat();
        edtem.getBtnKembali().addActionListener(this);
        edtem.getBtnSimpan().addActionListener(this);
        
        //Menu Edit Paket
        edpak = new View.EditPaket();
        
        //Menu Edit Perjalanan
        edpjl = new View.EditPerjalanan();
        
        mm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        
        //Main Menu
        if (x.equals(mm.getBtnperjalanan())){
            pjl.setVisible(true);
            mm.setVisible(false);
        }else if (x.equals(mm.getBtnpaketwisata())){
            pak.setVisible(true);
            mm.setVisible(false);
        }else if (x.equals(mm.getBtnpelanggan())){
            pel.setVisible(true);
            mm.setVisible(false);
        }else if (x.equals(mm.getBtnpetugas())){
            pet.setVisible(true);
            mm.setVisible(false);
        }else if (x.equals(mm.getBtntempatwisata())){
            tem.setVisible(true);
            mm.setVisible(false);
        }
        
        //Menu Perjalanan
        if (x.equals(pjl.getKembalipjl())){
            mm.setVisible(true);
            pjl.setVisible(false);
        }else if (x.equals(pjl.getTmbhpjl())){
            try {
                tp.setVisible(true);
                String query = "select idPerjalanan from Perjalanan";
                ResultSet rs = db.getData(query);
                if (rs.next()) {
                    tp.getTxtidpjl().setText(((rs.getInt("IdPerjalanan"))+1)+"");
                }else {
                    tp.getTxtidpjl().setText("1");
                }
                
                query = "select idPaket from PaketWisata";
                rs = db.getData(query);
                ArrayList<String> list = new ArrayList<String>();
                while (rs.next()) {
                    list.add(rs.getString("idPaket"));
                }
                tp.addCombo(tp.getCbpwisata(), list);
                
                query = "select idPelanggan from Pelanggan";
                rs = db.getData(query);
                list = new ArrayList<String>();
                while (rs.next()) {
                    list.add(rs.getString("idPelanggan"));
                }
                tp.addCombo(tp.getCbox1(), list);
                
                pjl.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (x.equals(pjl.getViewpjl())){
            tp.setVisible(true);
            pjl.setVisible(false);
        }else if (x.equals(pjl.getDeletepjl())){
            dpjl.setVisible(true);
            pjl.setVisible(false);
        }
        
        
        //Menu Paket 
        if (x.equals(pak.getKembalipkt())){
            mm.setVisible(true);
            pak.setVisible(false);
        }else if (x.equals(pak.getTmbhpkt())){
            tp.setVisible(true);
            pak.setVisible(false);
        }else if (x.equals(pak.getViewpkt())){
            tp.setVisible(true);
            pak.setVisible(false);
        }else if (x.equals(pak.getDeletepkt())){
            dpak.setVisible(true);
            pak.setVisible(false);
        }
        
        //Menu Tempat
        if (x.equals(tem.getKembalitmp())){
            mm.setVisible(true);
            tem.setVisible(false);
        }else if (x.equals(tem.getTmbhtmp())){
            ttm.setVisible(true);
            tem.setVisible(false);
        }else if (x.equals(tem.getDeletetmp())){
            dtem.setVisible(true);
            tem.setVisible(false);
        }else if (x.equals(tem.getEdittmp())){
            edtem.setVisible(true);
            tem.setVisible(false);
        }else if (x.equals(tem.getViewtmp())){
            try {
                tem.setVisible(false);
                vt.setVisible(true);
                vt.changeHeader();
                String query = "select * from tempatWisata ";
                ResultSet rs = db.getData(query);
                ArrayList<TempatWisata> list = new ArrayList<TempatWisata>();
                while (rs.next()) {
                    list.add(new TempatWisata(rs.getString("NamaTempat"), rs.getLong("Harga"), rs.getInt("IdTempat")));
                }
                vt.insertData(list);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        //Menu Petugas
        if (x.equals(pet.getKembaliptg())){
            mm.setVisible(true);
            pet.setVisible(false);
        }else if (x.equals(pet.getTmbhptg())){
            tpet.setVisible(true);
            pet.setVisible(false);
        }else if (x.equals(pet.getDeleteptg())){
            dpet.setVisible(true);
            pet.setVisible(false);
        }else if (x.equals(pet.getEditptg())){
            edpet.setVisible(true);
            pet.setVisible(false);
        }else if (x.equals(pet.getViewptg())){
            try {
                pet.setVisible(false);
                vpet.setVisible(true);
                vpet.changeHeader();
                String query = "select * from petugas ";
                ResultSet rs = db.getData(query);
                ArrayList<Petugas> list = new ArrayList<Petugas>();
                while (rs.next()) {
                    list.add(new Petugas(rs.getString("Nama"), rs.getLong("idPetugas"), rs.getString("Alamat")));
                }
                vpet.insertData(list);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Menu Pelanggan
        if (x.equals(pel.getKembaliplng())){
            mm.setVisible(true);
            pel.setVisible(false);
        }else if (x.equals(pel.getTmbhplng())){
            tpel.setVisible(true);
            pel.setVisible(false);
        }else if (x.equals(pel.getDeleteplng())){
            dpel.setVisible(true);
            pel.setVisible(false);
        }else if (x.equals(pel.getEditplng())){
            edpel.setVisible(true);
            pel.setVisible(false);
        }else if (x.equals(pel.getViewplng())){
            try {
                pel.setVisible(false);
                vpel.setVisible(true);
                vpel.changeHeader();
                String query = "select * from pelanggan ";
                ResultSet rs = db.getData(query);
                ArrayList<Pelanggan> list = new ArrayList<Pelanggan>();
                while (rs.next()) {
                    list.add(new Pelanggan(rs.getString("Nama"), rs.getLong("idPelanggan"), rs.getString("Alamat")));
                }
                vpel.insertData(list);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
        
        // Handler GUI Tambah Perjalanan
        
        if (x.equals(tp.getBtnsmpnpjl())) {
            String query = "insert into Perjalanan values("
                    + tp.getTxtidpjl()+ "',"
                    + tp.getCbox1().getSelectedItem().toString() + "',"
                    + tp.getCbpwisata().getSelectedItem().toString() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data perjalanan berhasil disimpan", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data perjalanan tidak lengkap", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        else if (x.equals(tp.getBtnCek())){
            try {
                String query = "select * from PaketWisata where idPaket = "
                        + tp.getCbpwisata().getSelectedItem().toString();
                ResultSet rs = db.getData(query);
                while (rs.next()){
                    tp.getTxtTempatWisata().setText(rs.getString("TempatWisata"));
                    tp.getTxtHargaPaket().setText(rs.getString("HargaPaket"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (x.equals(tp.getBtnCek2())){
            try {
                String query = "select * from Pelanggan where idPelanggan = "
                        + tp.getCbox1().getSelectedItem().toString();
                ResultSet rs = db.getData(query);
                while (rs.next()){
                    tp.getTxtNamaPelanggan().setText(rs.getString("Nama"));
                    tp.getTxtAlamatPelanggan().setText(rs.getString("Alamat"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (e.getSource().equals(tp.getBtnkembalipjl())) {
            tp.setVisible(false);
            pjl.setVisible(true);
        }
        
        // Handler GUI Tambah Petugas
        if (x.equals(tpet.getBtnsmpnptgs())) {
            String query = "insert into Petugas values("
                    + tpet.getTxtidptgs().getText() + ","
                    + "'" + tpet.getTxtnamaptgs().getText() + "',"
                    + "'" + tpet.getTxtalamatptgs().getText() +  "');";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data petugas berhasil disimpan", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data petugas tidak lengkap", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource().equals(tpet.getBtnkembaliptgs())) {
            tpet.setVisible(false);
            pet.setVisible(true);
        }
        
        // Handler GUI Tambah Pelanggan
        if (e.getSource().equals(tpel.getBtnsmpnplg())) {
            String query = "insert into Pelanggan values("
                    + tpel.getTxtidplg().getText() + ","
                    + "'" + tpel.getTxtnamaplg().getText() + "',"
                    + "'" + tpel.getTxtalamatplg().getText() + "');";
             if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data pelanggan berhasil disimpan", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data pelanggan tidak lengkap", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource().equals(tpel.getBtnkembaliplg())) {
            tpel.setVisible(false);
            pel.setVisible(true);
        }
        
        // Handler GUI Tambah Tempat
        if (e.getSource().equals(ttm.getBtnsmpntmp())) {
            String query = "insert into TempatWisata values("
                    + ttm.getTxtIdTem().getText() + ","
                    + "'" + ttm.getTxtNamaTem().getText() + "',"
                    + "'" + ttm.getTxtHarga().getText() + "');";
             if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data tempat wisata berhasil disimpan", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data tempat wisata tidak lengkap", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource().equals(ttm.getBtnkembalitmp())) {
            ttm.setVisible(false);
            tem.setVisible(true);
        }
        
        // Handler GUI Tambah Paket
        /*if (e.getSource().equals(ttm.getBtnsmpntmp())) {
            String query = "insert into TempatWisata values("
                    + ttm.getTxtIdTem().getText() + ","
                    + "'" + ttm.getTxtNamaTem().getText() + "',"
                    + "'" + ttm.getTxtHarga().getText() + "');";
            db.runQuery(query);
            JOptionPane.showMessageDialog(null, "Data Tempat Wisata berhasil disimpan", "Informasi View Tambah Pelanggan", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(ttm.getBtnkembalitmp())) {
            ttm.setVisible(false);
            tem.setVisible(true);
        }*/
        
        //Handler GUI Lihat Pelanggan
        if (x.equals(vpel.getKembaliViewPel())) {
            vpel.setVisible(false);
            pel.setVisible(true);
        }
        
        //Handler GUI Lihat Petugas
        if (x.equals(vpet.getKembaliViewPet())) {
            vpet.setVisible(false);
            pet.setVisible(true);
        }
        
        //Handler GUI Lihat Tempat
        if (x.equals(vt.getKembaliViewTem())) {
            vt.setVisible(false);
            tem.setVisible(true);
        }
        
        //Handler GUI Delete Pelanggan
        if (x.equals(dpel.getBtnKembali())) {
            dpel.setVisible(false);
            pel.setVisible(true);
        }else if (e.getSource().equals(dpel.getBtnDelPel())) {
            String query = "delete from Pelanggan where idPelanggan = '"
                    + dpel.getTxtDelPel().getText() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data pelanggan berhasil dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data pelanggan gagal dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Handler GUI Delete Petugas
        if (x.equals(dpet.getBtnKembali())) {
            dpet.setVisible(false);
            pet.setVisible(true);
        }else if (e.getSource().equals(dpet.getBtnDelPet())) {
            String query = "delete from Petugas where idPetugas = '"
                    + dpet.getTxtDelPet().getText() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data petugas berhasil dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data petugas gagal dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Handler GUI Delete Tempat
        if (x.equals(dtem.getBtnKembali())) {
            dtem.setVisible(false);
            tem.setVisible(true);
        }else if (e.getSource().equals(dtem.getBtnDelTem())) {
            String query = "delete from TempatWisata where idTempat = '"
                    + dtem.getTxtDelTem().getText() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data tempat wisata berhasil dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data tempat wisata gagal dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Handler GUI Delete Paket
        if (x.equals(dpak.getBtnKembali())) {
            dpak.setVisible(false);
            pak.setVisible(true);
        }else if (e.getSource().equals(dpak.getBtnDelPak())) {
            String query = "delete from PaketWisata where idPaket = '"
                    + dpak.getTxtDelPak().getText() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data paket wisata berhasil dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data paket wisata gagal dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Handler GUI Delete Perjalanan
        if (x.equals(dpjl.getBtnKembali())) {
            dpjl.setVisible(false);
            pjl.setVisible(true);
        }else if (e.getSource().equals(dpjl.getBtnDelPjl())) {
            String query = "delete from Perjalanan where idPerjalanan = '"
                    + dpjl.getTxtDelPjl().getText() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data perjalanan berhasil dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data perjalanan gagal dihapus", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Handler GUI Edit Pelanggan
        if (x.equals(edpel.getBtnKembali())) {
            edpel.setVisible(false);
            pel.setVisible(true);
        }else if (e.getSource().equals(edpel.getBtnSimpan())) {
            String query = "update pelanggan SET idPelanggan = '"
                    + edpel.getTxtIdPelBaru().getText() + "' ,Nama = '"
                    + edpel.getTxtNamaPelBaru().getText() + "' ,Alamat = '"
                    + edpel.getTxtAlamatPelBaru().getText() + "' where IdPelanggan = '"
                    + edpel.getTxtIdPelBaru().getText() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data pelanggan berhasil diubah", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data pelanggan gagal diubah", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Handler GUI Edit Petugas
        if (x.equals(edpet.getBtnKembali())) {
            edpet.setVisible(false);
            pet.setVisible(true);
        }else if (e.getSource().equals(edpet.getBtnSimpan())) {
            String query = "update petugas SET idPetugas = '"
                    + edpet.getTxtIdPetBaru().getText() + "' ,Nama = '"
                    + edpet.getTxtNamaPetBaru().getText() + "' ,Alamat = '"
                    + edpet.getTxtAlamatPetBaru().getText() + "' where IdPetugas = '"
                    + edpet.getTxtIdPetBaru().getText() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data petugas berhasil diubah", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data petugas gagal diubah", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        //Handler GUI Edit Tempat
        if (x.equals(edtem.getBtnKembali())) {
            edtem.setVisible(false);
            tem.setVisible(true);
        }else if (e.getSource().equals(edtem.getBtnSimpan())) {
            String query = "update TempatWisata SET IdTempat = '"
                    + edtem.getTxtIdTemBaru().getText() + "' ,NamaTempat = '"
                    + edtem.getTxtNamaTemBaru().getText() + "' ,Harga = '"
                    + edtem.getTxtHargaBaru().getText() + "' where IdTempat = '"
                    + edtem.getTxtIdTemBaru().getText() + "'";
            if (db.runQuery(query)){
                JOptionPane.showMessageDialog(null, "Data tempat wisata berhasil diubah", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Data tempat wisata gagal diubah", "Informasi Tambah Perjalanan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
