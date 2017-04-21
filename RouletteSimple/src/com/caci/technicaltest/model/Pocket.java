/**
 * 
 */
package com.caci.technicaltest.model;

import com.caci.technicaltest.roulette.RouletteGameException;

/**
 * @author Fabrizio
 *
 */
public class Pocket {

	private String number;
	private String color;

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
		this.color = getColor(number);
	}
	
	public String getColor() {
		return color;
	}
 
	/**
	 * 	In number ranges from 1 to 10 and 19 to 28, odd numbers are red and even are black.<br> 
	 * 	In ranges from 11 to 18 and 29 to 36, odd numbers are black and even are red.<br>
	 *  There is a green pocket numbered 0 (zero). In American roulette, there is a second <br>
	 *  green pocket marked 00.<br>
	 * @param number
	 * @return
	 */

	private final String getColor(String number){
		
		try {
			Integer n = Integer.parseInt(number);
			if((n >=1 && n <=10) || (n >=19 && n <=28) ){
				return n%2 == 0?Constants.BLACK:Constants.RED;
			}
			if((n >=11 && n <=18) || (n >=29 && n <=36) ){
				return n%2 == 0?Constants.RED:Constants.BLACK;
			}
			return Constants.GREEN;
		} catch (NumberFormatException e) {
		 
			throw new RouletteGameException("Format not valid");
		}
		
	}	


}
