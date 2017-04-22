/**
 * 
 */
package com.caci.technicaltest.roulette;

import java.util.LinkedHashMap;

import com.caci.technicaltest.model.Pocket;

 

/**
 * @author Fabrizio
 *
 */
public abstract class Roulette{

	protected String[] wheelNumbers;
	private LinkedHashMap<String, String> wheelPocketsMap ;

	/**
	 * 
	 * @param wheelNumbers
	 */
	public Roulette(String[] wheelNumbers) {
		this.wheelNumbers = wheelNumbers;
		setWheelPockets();
	}

	public LinkedHashMap<String, String> getWheelPocketsMap() {
		return wheelPocketsMap;
	}


	private void setWheelPockets(){
		LinkedHashMap<String,String> w = new LinkedHashMap<>();
		for(int i = 0; i<wheelNumbers.length; i++){
			Pocket p = new Pocket();
			p.setNumber(wheelNumbers[i]);
			 
			w.put(p.getNumber(), p.getColor());
		}

		this.wheelPocketsMap = w;
	}
 
 
	public abstract Pocket spin();

	
}
