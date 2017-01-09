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
public class setStockGGM {
    
    DatabaseFunction df = new DatabaseFunction();
    
    private ArrayList<String> StkCodeList = new ArrayList<String>() ;
    private String[] StkSymbol = new String[StkCodeList.size()];
    
    public void setStockGGM()
    {
        setStkCodeList();
        GGM();
    }
    
    public void setStkCodeList()
    {
        StkCodeList = df.getStockCodeList();
    }
    
    public ArrayList<String> getStkCodeList()
    {return StkCodeList;};

    public void GGM()
        {
            double Dividend = 0.0;
            double DividendGrowth = 0.0;
            double RateOfReturn = (3.608/100) + ((4.36/100) * 0.779);
            double GGM = 0.0 ;
            
            StkSymbol = getStkCodeList().toArray(StkSymbol);
                
            for(int i=0; i<StkCodeList.size(); i++)
                {   
                    String StkCd = StkSymbol[i].replaceAll(" ","");
                    Dividend = df.getDividend(StkCd);
                    DividendGrowth = (df.getDividendGrowth(StkCd)/100);
                    GGM = Dividend/(RateOfReturn - DividendGrowth);

                    df.updateStockGGM(StkCd, GGM);
                    System.out.println(StkCd + " Updated");
                }

            
        }
}
