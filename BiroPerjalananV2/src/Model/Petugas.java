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
    public class Petugas extends Orang{
	public Petugas(String nama, long id, String alamat) {
		super(nama, id, alamat);
	}
	
	public void setNama(String nama){
		super.setNama(nama);
	}
	
	public String getNama(){
		return super.getNama();
	}
	
	public void setId(long id){
		super.setId(id);
	}
	
	public long getId(){
		return super.getId();
	}
	
	public void setAlamat(String alamat){
		super.setAlamat(alamat);
	}
	
	public String getAlamat(){
		return super.getAlamat();
	}
	
}

