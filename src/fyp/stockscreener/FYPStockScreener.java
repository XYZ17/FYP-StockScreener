/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import fyp.database.DatabaseFunction;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.net.*;

/**
 *
 * @author Lim
 */
public class FYPStockScreener {

    /**
     * @param args the command line arguments
     */
    
    DatabaseFunction df = new DatabaseFunction();
    public static void main(String[] args) {
        // TODO code application logic here
        boolean checkIC = checkInternetConnection();
        System.out.println(checkIC);
        if(checkIC == true){
            new ReadWriteDate().CheckDate();
                if(true){
                        new Watchlist().Watchlist();
                        new ReadWriteDate().WriteDate();
                        new Dashboard().setVisible(true);
                }
                else{
                    new Dashboard().setVisible(true);
                }
        }
        else{
            new Dashboard().setVisible(true);
        }
        
        //new Watchlist().Watchlist();
        //new LoadEPS().LoadEPS();
        //new LoadDPS().LoadDPS();
        //new Load5YrsGrowth().Load5YrsGrowth();
        //new setStockDEM().setStockDEM();
        //new setStockGGM().setStockGGM();
        //new setStockBGF().setStockBGF();
        //new ReadWriteDate().WriteDate();
        
        //new StockScreener().setVisible(true);
    }
    
    private static boolean checkInternetConnection(){
        Socket sock = new Socket();
        InetSocketAddress addr = new InetSocketAddress("http://finance.yahoo.com",80);
        try{
            sock.connect(addr,3000);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No Connection, Data not updated!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            try{sock.close();}
            catch(Exception e){}
        }
    }
    
}
