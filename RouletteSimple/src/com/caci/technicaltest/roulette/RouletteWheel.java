/**
 * 
 */
package com.caci.technicaltest.roulette;

import java.util.Random;

import com.caci.technicaltest.model.Pocket;

/**
 * @author Fabrizio
 *
 */
public class RouletteWheel extends Roulette{
	
	/**
	 * @param wheelNumbers
	 */
	public RouletteWheel(String[] wheelNumbers) {
		super(wheelNumbers);
	}

	public final Pocket spin(){
		Random r = new Random();
		int i = r.nextInt(wheelNumbers.length);
		Pocket p = new Pocket();
		p.setNumber(wheelNumbers[i]);
		return p;
	}

}