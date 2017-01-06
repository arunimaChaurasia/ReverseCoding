package com.cummins.PredictionModel;

import com.cummins.Stocks.*;
import java.util.ArrayList;

public class Prediction {

	ArrayList<Stock> buyStock=new ArrayList<Stock>();
	

	ArrayList<Stock> sellStock=new ArrayList<Stock>();;

	public Prediction(ArrayList<Stock> stocks) {
		
		Change change=new Change();
		change.delta(stocks,this);
		
		
	}
	public ArrayList<Stock> getBuyStock() {
		return buyStock;
	}

	public void setBuyStock(ArrayList<Stock> buyStock) {
		this.buyStock = buyStock;
	}

	public ArrayList<Stock> getSellStock() {
		return sellStock;
	}

	public void setSellStock(ArrayList<Stock> sellStock) {
		this.sellStock = sellStock;
	}
}
