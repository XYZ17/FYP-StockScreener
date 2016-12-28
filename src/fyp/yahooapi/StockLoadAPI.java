package fyp.yahooapi;

import org.junit.Test;

public class StockLoadAPI { 
	
	@Test
        
        public String getStockName(String StockSymbol){
            String SS = StockSymbol;
            StockDetailsAPI s = StockFetcherAPI.getStock(SS);
            String SName = s.getName();
            return SName;
        }
	public double getStockLow(String StockSymbol) { 
                StockDetailsAPI s = StockFetcherAPI.getStock(StockSymbol);
                return s.getDaylow();
	} 
        public double getStockHigh(String StockSymbol) { 
                StockDetailsAPI s = StockFetcherAPI.getStock(StockSymbol);
                return s.getDayhigh();
	} 
        public double getStockPrev(String StockSymbol) { 
                StockDetailsAPI s = StockFetcherAPI.getStock(StockSymbol);
                return s.getPreviousClose();
	} 
        public double getStockLast(String StockSymbol) { 
                StockDetailsAPI s = StockFetcherAPI.getStock(StockSymbol);
                return s.getPrice();
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