/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import fyp.database.DatabaseFunction;
import javax.swing.JOptionPane;

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
        if(checkIC == true){
            boolean checkDate = new ReadWriteDate().CheckDate();
                if(checkDate == false){
                        new UpdateWatchlist().UpdateWatchlist();
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
        
        //new LoadStockDetails().LoadStockDetails();
        //new Watchlist().Watchlist();
        //new LoadEPS().LoadEPS();
        //new LoadDPS().LoadDPS();
        //new LoadFCF().LoadFCF();
        //new Load5YrsGrowth().Load5YrsGrowth();
        //new setStockDEM().setStockDEM();
        //new setStockGGM().setStockGGM();
        //new setStockBGF().setStockBGF();
        //new ReadWriteDate().WriteDate();
        
        //new StockScreener().setVisible(true);
    }
    
    private static boolean checkInternetConnection(){
        try{
                String cmd = "ping -n 1 finance.yahoo.com";
                
                Process myProcess = Runtime.getRuntime().exec(cmd);
                myProcess.waitFor();

                if(myProcess.exitValue() == 0) {
                        return true;
                } else {
                        JOptionPane.showMessageDialog(null, "No Connection, Data not updated!", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                }

        } catch( Exception e ) {
                JOptionPane.showMessageDialog(null, "No Connection, Data not updated!", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                return false;
        }
    }
    
}
