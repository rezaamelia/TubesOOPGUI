/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

//import com.mysql.jdbc.*;
import java.sql.*;
import javax.swing.JOptionPane;




/**
 *
 * @author Reza Amelia
 */
public class Database {
    private Connection c = null;
    private Statement s = null;
    private ResultSet rs = null;
    
    public Database(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TubesOOP", "root","");
            s = c.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Koneksi 1: " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ResultSet getData(String query){
        try {
            rs = s.executeQuery(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Koneksi 1: " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    public boolean runQuery(String query){
        int x = -1;
        try {
            x = s.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        if (x>=1){
            return true;
        }else{
            return false;
        }
    }
}