package com.cummins.demo;

import java.util.ArrayList;

public class SectorDB {
	ArrayList<Sector> sectors    = new ArrayList<Sector>();
	public SectorDB()
	{
		//ArrayList<Sector> sectors    = new ArrayList<Sector>();
		Sector newSector=new Sector();
		Sector newSector1=new Sector();
		
		newSector1.setName("automobile");
		newSector1.setSymbol("auto");
		sectors.add(newSector1);
		
			newSector.setName("Pharmaceutical");
			newSector.setSymbol("PHRM");
			sectors.add(newSector);
		
	}
	public ArrayList<Sector> returnJson()
	{
		return sectors;
	}
}
