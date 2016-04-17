/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Reza Amelia
 */
public class Perjalanan {

    private ArrayList<Pelanggan> pelanggan = new ArrayList();
    private ArrayList<PaketWisata> daftarPaketWisata;
    private ArrayList<Pelanggan> daftarPelanggan;
    int jum=0;
    long noPerjalanan;

    public Perjalanan(long noPerjalanan) {
        this.noPerjalanan = noPerjalanan;
    }

    public long getNoPerjalanan() {
        return noPerjalanan;
    }

    public void setNoPerjalanan(long noPerjalanan) {
        this.noPerjalanan = noPerjalanan;
        
    }

    
    public Perjalanan(long noPerjalanan, PaketWisata pw, Pelanggan pel) {
        daftarPelanggan = new ArrayList();
        daftarPelanggan.add(pel);
        daftarPaketWisata = new ArrayList();
        daftarPaketWisata.add(pw);
        this.noPerjalanan = noPerjalanan;
    }
    
       
    public void addPelanggan(Pelanggan p) {
        if (pelanggan.size() < 40) {
            pelanggan.add(p);
            jum++;
            
        } else {
            System.out.println("Kuota Pelanggan Penuh");
        }
    }
    
    public int getJumlahPelanggan(){
        return jum;
    }

    public ArrayList<PaketWisata> getDaftarPaketWisata() {
        return daftarPaketWisata;
    }

    public ArrayList<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }
    
    
        
    public void removePelanggan(long id) {
        for (Pelanggan p : pelanggan) {
            if (p.getId() == id) {
                p = null;
            }
        }
    }
	
    public void editPelanggan(String nama, long id, String alamat) {
        for (Pelanggan p : pelanggan) {
            if (p.getId() == id) {
                p.setNama(nama);
                p.setAlamat(alamat);
            }
        }
    }
    
    public Pelanggan getPelanggan(int idx) {
        return pelanggan.get(idx);
    }    
    
    public Pelanggan getPelanggan(long id) {
        Pelanggan a = null;
        for (Pelanggan p : pelanggan) {
            if (p.getId() == id) {
                a = p;
            }
        }
        return a;
    }
    
}
