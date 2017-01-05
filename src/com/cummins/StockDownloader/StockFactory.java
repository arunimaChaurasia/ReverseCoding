package com.cummins.StockDownloader;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;

import com.cummins.Stocks.*;

public class StockFactory {
	
	public void stockFactory(){
	Scanner in=new Scanner(System.in);
	GregorianCalendar today = new GregorianCalendar();
	int todayMonth = today.get(Calendar.MONTH);

    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);

    int todayYear = today.get(Calendar.YEAR);
    
    Calendar calendar = Calendar.getInstance(); // this would default to now
    //System.out.println("Date 2 weeks-"calendar.add(Calendar.DATE, -14));
    calendar.add(Calendar.DATE, -14);
    int historyMonth=calendar.get(Calendar.MONTH);
    int historyDayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
    int historyYear=calendar.get(Calendar.YEAR);
    GregorianCalendar start=new GregorianCalendar(todayYear,todayMonth,todayDayOfMonth);
    GregorianCalendar end=new GregorianCalendar(historyYear,historyMonth,historyDayOfMonth);
    System.out.println("Enter the company name");
    String symbol=in.nextLine();
    Stock stock=new Stock();
	HistoricalStock stockdownloader=new HistoricalStock(stock,symbol,start,end);
	
	
	CurrentStockData.getStock(stock,symbol);
//	System.out.println(stock.getAveragePrice());
//	System.out.println(stock.getOpens());
//	System.out.println(stock.getEps());
//	System.out.println(stock.getCloses());
//	System.out.println(stock.getDeliveryToTradedQuaantity());
	}
}
