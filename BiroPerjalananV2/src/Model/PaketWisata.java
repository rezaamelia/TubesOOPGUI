/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Reza Amelia
 */
import java.io.Serializable;
import java.util.ArrayList;
public class PaketWisata implements Serializable {
	private ArrayList<TempatWisata> daftarTujuanWisata;
	private long HargaPaket;
	private int nTempatWisata;
	private int maxTempatWisata;
	private long idPaket;
        
	public PaketWisata(long idPaket, int maxTempatWisata){
		daftarTujuanWisata = new ArrayList();
		this.maxTempatWisata=maxTempatWisata;
		this.idPaket=idPaket;
	}
	
	public void addTempatWisata(TempatWisata w){
		if (nTempatWisata<maxTempatWisata) {
			daftarTujuanWisata.add(w);
			nTempatWisata++;
		}
		else {
			System.out.println("Kuota TempatWisata Penuh");
		}
	}
	
	public void hitungHarga(){
		for (TempatWisata tw : daftarTujuanWisata){
			HargaPaket=HargaPaket+tw.getHarga();
		}
	}
        
        public long getIdPaket(){
            return idPaket;
        }
        
        public void setIdPaket(long idPaket){
            this.idPaket=idPaket;
        }
	
	public TempatWisata getTempatWisata1(int idx){
		return daftarTujuanWisata.get(idx);
	}
	
	public TempatWisata getTempatWisata2(long id){
		TempatWisata a=null;
		for(TempatWisata tw : daftarTujuanWisata){
			if(tw.getId()==id){
				a=tw;
			}
		}
		return a;
	}
	
	public void removeTempatWisata(long id){
		for(TempatWisata tws : daftarTujuanWisata){
			if(tws.getId()==id){
				tws=null;
                                nTempatWisata--;
			}
		}
	}
}