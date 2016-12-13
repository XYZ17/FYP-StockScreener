/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

/**
 *
 * @author Lim
 */
public class setStockDEM {
    public static double main(String[] args)
  {
    double Earnings = 0.079;
    double EPS_GrowthRate = 0.12;
    double RiskFreeRate = 0.04;
    double DiscountRate, DiscountedEarnings;
    double DEM = 0 ;
    double[] CumulativeEarnings = new double[11];
    
	for(int i=1;i<11;i++){
		Earnings *= (1+EPS_GrowthRate);
		DiscountRate = 1/(Math.pow((1+RiskFreeRate),i));
		DiscountedEarnings = Earnings*DiscountRate;
		if(i==1){
			CumulativeEarnings[i] = DiscountedEarnings;
		}
		else{
			CumulativeEarnings[i] = DiscountedEarnings + CumulativeEarnings[i-1];
		}
	}
    	DEM = CumulativeEarnings[10];

	return DEM;
  }
}
