package connect;
import java.sql.*;
import javax.swing.JOptionPane;

public class KoneksiDatabase {
    
    private Connection koneksi;
    private String driver;
    private String url;
    private String username;
    private String password;
    
    // masukan value di main
    public KoneksiDatabase(){
    
        // this.driver = "com.mysql.jdbc.Driver";
        // this.url = "jdbc:mysql://localhost:3306/project";
        this.driver = "org.h2.Driver";
        this.url = "jdbc:h2:./project";
        this.username = "root";
        this.password = "admin1234";
    }
    
    public Connection connectToDB(){
    
        // exception handler
        try{
            // load driver
            Class.forName(driver);
            // hubungkan dengan sumber data
            koneksi = DriverManager.getConnection(url, username, password);
            
        } catch(ClassNotFoundException ex){        
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver MySQL tidak ditemukan");
        } catch(SQLException exec){            
            exec.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal terhubung dengan sumber data / database");
        }        
        return koneksi;        
    }
    
    // diskonek setiap melakukan query
    public void disconnectDB(){
        
        try{
            if(koneksi != null){

               koneksi.close();
           }
        } catch(SQLException ex){
            
            ex.printStackTrace();
        }
       
    }
}
