/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import fyp.database.DatabaseFunction;
import java.util.ArrayList;

/**
 *
 * @author Lim
 */
public class setStockBGF {
    DatabaseFunction df = new DatabaseFunction();
    
    private ArrayList<String> StkCodeList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkCodeList.size()];
    
    public void setStockBGF()
    {
        setStkCodeList();
        BGF();
    }
    
    public void setStkCodeList()
    {
        StkCodeList = df.getStockCodeList();
    }
    
    public ArrayList<String> getStkCodeList()
    {return StkCodeList;};

    public void BGF()
        {
            double Earnings = 0.0;
            double Growth =0.0;
            double PE = 7;
            double AvgYieldBond = 4.4;
            double Bond = 4.82;
            double BGF = 0.0 ;
            
            StkSymbol = getStkCodeList().toArray(StkSymbol);
                
            for(int i=0; i<StkCodeList.size(); i++)
                {   
                    String StkCd = StkSymbol[i].replaceAll(" ","");
                    Earnings = df.getEarning(StkCd);
                    Growth = (df.getGrowth(StkCd))/100;
                    
                    BGF = (Earnings*((PE+(1.5*Growth))*AvgYieldBond)/Bond);

                    df.updateStockBGF(StkCd, BGF);
                    System.out.println(StkCd + " Updated");
                }

            
        }
}
