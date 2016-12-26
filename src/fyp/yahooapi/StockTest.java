package fyp.yahooapi;

import org.junit.Test;

public class StockTest { 
	
	@Test
	public void testStock() { 
		
            for(int i=0; i<9; i++){
                Stock s = StockFetcher.getStock("509"+i +".KL");
		System.out.println(s.getName() + s.getCurrency() + s.getPrice());
            }
	} 
}

/*
                System.out.println("Price: " + s.getPrice());
		System.out.println("Volume: " + s.getVolume()); 
		System.out.println("P/E: " + s.getPe());
		System.out.println("EPS: " + s.getEps());
		System.out.println("Year Low: " + s.getWeek52low());
		System.out.println("Year High: " + s.getWeek52high());
		System.out.println("Day Low: " + s.getDaylow());
		System.out.println("Day High: " + s.getDayhigh());
		System.out.println("50 Day Moving Av: " + s.getMovingav50day());
		System.out.println("Market Cap: " + s.getMarketcap());
		System.out.println("The full name is: " + s.getName());
		System.out.println("The currency is: " + s.getCurrency());
		System.out.println("The short ratio is: " + s.getShortRatio());
		System.out.println("The previous close was: " + s.getPreviousClose());
		System.out.println("The open for today was: " + s.getOpen());
		System.out.println("The exchange is " + s.getExchange());

*/