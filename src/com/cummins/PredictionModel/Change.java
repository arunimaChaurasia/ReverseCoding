package com.cummins.PredictionModel;

import java.util.ArrayList;

import com.cummins.Stocks.*;

public class Change {

	
	

	public void delta(ArrayList<Stock> stocks,Prediction prediction) {
		// TODO Auto-generated method stub

		for (int i = 0; i < stocks.size(); i++) {
			double change1 = 0;
			for (int j = 0; j < stocks.get(i).getOpens().size(); j++) {

				change1 += (stocks.get(i).getCloses().get(j) - stocks.get(i).getOpens().get(j))
						/ stocks.get(i).getOpens().get(j);
				//
			}
			double average = change1 / stocks.get(i).getOpens().size();
			if (average >= 0) {

				prediction.getBuyStock().add(stocks.get(i));
			} else
				prediction.getSellStock().add(stocks.get(i));

		}

	}

}
