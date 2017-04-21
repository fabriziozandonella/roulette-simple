/**
 * 
 */
package com.caci.technicaltest;

import java.math.BigDecimal;

import com.caci.technicaltest.model.Pocket;

/**
 * @author Fabrizio
 *
 */
public interface BetService {

	public BigDecimal StraightSingle(BigDecimal bet, Pocket pocketBet);
	
	public BigDecimal EvenOrOdd(BigDecimal bet, Pocket pocketBet);
	
	
}
