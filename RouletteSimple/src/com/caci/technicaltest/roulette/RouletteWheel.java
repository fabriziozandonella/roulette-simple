/**
 * 
 */
package com.caci.technicaltest.roulette;

import java.util.LinkedHashMap;
import java.util.Random;

import com.caci.technicaltest.model.Pocket;

/**
 * @author Fabrizio
 *
 */
public class RouletteWheel {

	private String[] wheelNumbers;
	private LinkedHashMap<String, String> wheelPocketsMap ;


	/**
	 * 
	 * @param wheelNumbers
	 */
	public RouletteWheel(String[] wheelNumbers) {
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



	public Pocket spin(){
		Random r = new Random();
		int i = r.nextInt(wheelNumbers.length);
		Pocket p = new Pocket();
		p.setNumber(wheelNumbers[i]);
 
		return p;
	}

}