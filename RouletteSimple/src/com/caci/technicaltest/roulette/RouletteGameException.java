/**
 * 
 */
package com.caci.technicaltest.roulette;

/**
 * @author Fabrizio
 *
 */
public class RouletteGameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RouletteGameException(String msg, Throwable rootException) {
		super(msg, rootException);
	}	

	public RouletteGameException(String msg) {
		super(msg);
	}
	
}
