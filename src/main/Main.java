package main;

// kelas yang menghubungkan backend dengan front end

import ui.*;

public class Main {
    
    private static MainFrame mainFrame;      
    
    public static MainFrame getFrame(){
        
        return mainFrame;
    } 
    
    public static void main(String[] args){    
                
        java.awt.EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {  
                mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}
