/**
 * 
 */
package com.caci.technicaltest;

import java.math.BigDecimal;

import com.caci.technicaltest.model.Constants;
import com.caci.technicaltest.model.Pocket;
import com.caci.technicaltest.roulette.RouletteGameException;
import com.caci.technicaltest.roulette.RouletteWheel;


/**
 * @author Fabrizio
 *
 */
public class BetServiceImpl implements BetService {

	private RouletteWheel roulette;

	/**
	 * @param roulette
	 */
	public BetServiceImpl(RouletteWheel roulette) {
		super();
		this.roulette = roulette;
	}

 
	@Override
	public BigDecimal StraightSingle(BigDecimal bet, Pocket pocketBet) {

		betValidation(bet, pocketBet);

		if(roulette.spin().getNumber() == pocketBet.getNumber()){
			return bet.multiply(new BigDecimal(36));
		}else{
			return new BigDecimal(0);
		}

	}

	@Override
	public BigDecimal EvenOrOdd(BigDecimal bet, Pocket pocketBet) {

		betValidation(bet, pocketBet);

		if(roulette.spin().getColor().equals(Constants.GREEN)){
			return new BigDecimal(0);
		}else if(Integer.parseInt(roulette.spin().getNumber())%2 == Integer.parseInt(pocketBet.getNumber())%2){
			return bet.multiply(new BigDecimal(2));
		}else{
			return new BigDecimal(0);
		}
	}
    
	/**
	 * 
	 * @param b
	 * @param p
	 */
	private void betValidation(BigDecimal b, Pocket p){
		if(null == b || b.compareTo(new BigDecimal(0))==-1 || b.compareTo(new BigDecimal(0))==0) {
			throw new RouletteGameException("The bet cannot be less or equal to zero, or null");
		}

		if(!roulette.getWheelPocketsMap().containsKey(p.getNumber())){
			throw new RouletteGameException("The pocket number is not valid: " + p.getNumber());
		}

		if(!roulette.getWheelPocketsMap().containsValue(p.getColor())){
			throw new RouletteGameException("The pocket color is not valid: " + p.getColor());
		}


	}

}
