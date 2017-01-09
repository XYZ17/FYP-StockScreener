/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lim
 */
public class FYPStockScreener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new ReadWriteDate().WriteDate();
        new ReadWriteDate().CheckDate();
        if(true){
            new StockScreener().setVisible(true);
        }
        else{
            new Watchlist().Watchlist();
            new ReadWriteDate().WriteDate();
            new StockScreener().setVisible(true);
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
    
}
