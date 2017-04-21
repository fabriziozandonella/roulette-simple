/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.caci.technicaltest.BetService;
import com.caci.technicaltest.BetServiceImpl;
import com.caci.technicaltest.model.Constants;
import com.caci.technicaltest.model.Pocket;
import com.caci.technicaltest.roulette.RouletteGameException;
import com.caci.technicaltest.roulette.RouletteWheel;

/**
 * @author Fabrizio
 *
 */
public class BetServiceImplTest {

	private BetService bs;
	private RouletteWheelTest rouletteTest;

	@Before
	public void init(){
		rouletteTest = new RouletteWheelTest(Constants.SINGLE_ZERO_WHEEL);
		bs = new BetServiceImpl(rouletteTest);
	}

	/*
     Given
        A customer places a bet of £10 on a pocket
    When 
        I spin the roulette wheel and ball lands in a losing pocket
    Then
        The customer will receive £0 winnings
	 */
	@Test
	public void testStraightSingleStage_1() {
		rouletteTest.setKey(2);
		assertEquals("15", rouletteTest.spin().getNumber());
		Pocket p = new Pocket();
		p.setNumber("12");
		assertEquals(new BigDecimal(0), bs.StraightSingle(new BigDecimal(10), p));		

	}

	/*
     Given
        A customer places a bet of £10 on a pocket
    When 
        I spin the roulette wheel and the ball lands in a winning pocket
    Then
        The customer will receive £360 winnings	
	 */
	@Test
	public void testStraightSingleStage_1_1() {
		rouletteTest.setKey(2);
		assertEquals("15", rouletteTest.spin().getNumber());
		Pocket p = new Pocket();	
		p.setNumber("15");
		assertEquals(new BigDecimal(360), bs.StraightSingle(new BigDecimal(10), p));
	}


	/*
     Given
        A customer has placed a bet
    When 
        That bet is less than or equal to £0
    Then
        The application will throw a RouletteGameException with a suitable message	
	 */

	@Rule
	public ExpectedException thrown= ExpectedException.none();	

	@Test 
	public void testStraightSingleStage_2_2() {
		Pocket p = new Pocket();
		p.setNumber("15");
		thrown.expect(RouletteGameException.class);
		thrown.expectMessage("The bet cannot be less or equal to zero, or null");		
		bs.StraightSingle(new BigDecimal(0), p);		
	}

	@Test 
	public void testStraightSingleStage_2_3() {
		Pocket p = new Pocket();
		p.setNumber("15");
		thrown.expect(RouletteGameException.class);
		thrown.expectMessage("The bet cannot be less or equal to zero, or null");
		bs.StraightSingle(new BigDecimal(-10), p);

	}
	@Test
	public void testStraightSingleStage_2_4() {
		Pocket p = new Pocket();
		p.setNumber("15");
		thrown.expect(RouletteGameException.class);
		thrown.expectMessage("The bet cannot be less or equal to zero, or null");
		bs.StraightSingle(null, p);
	}
	/*
     Given
        A customer has placed a bet
    When 
        A customer has selected an invalid pocket
    Then
        The application will throw a RouletteGameException with a suitable message
	 */
	@Test
	public void testStraightSingleStage_2_1() {
		Pocket p = new Pocket();
		p.setNumber("50");	
		thrown.expect(RouletteGameException.class);
		thrown.expectMessage("The pocket number is not valid: 50");		
		bs.StraightSingle(new BigDecimal(10), p);
	}


	/*
    Given 
        A customer has placed a bet of £10 on odd or even
    When
        I spin the roulette wheel and the ball lands in pocket 0
    Then
        The customer will receive £0 winnings
	 */
	@Test
	public void EvenOrOdd_3_1() {
		rouletteTest.setKey(0);
		assertEquals("0", rouletteTest.spin().getNumber());		
		Pocket p = new Pocket();
		p.setNumber("12");
		assertEquals(new BigDecimal(0), bs.EvenOrOdd(new BigDecimal(10), p));
		p.setNumber("15");
		assertEquals(new BigDecimal(0), bs.EvenOrOdd(new BigDecimal(10), p));		
	}

	/*
    Given 
        A customer has placed a bet of £10 on even
    When
        I spin the roulette wheel and the ball lands on an even pocket
    Then
        The customer will receive £20 winnings
	 */
	@Test
	public void EvenOrOdd_3_2() {
		rouletteTest.setKey(1);
		assertEquals("32", rouletteTest.spin().getNumber());		
		Pocket p = new Pocket();
		p.setNumber("12");
		assertEquals(new BigDecimal(20), bs.EvenOrOdd(new BigDecimal(10), p));	
	}	
	/*
    Given 
        A customer has placed a bet of £10 on even
    When
        I spin the roulette wheel and the ball lands on an odd pocket
    Then
        The customer will receive £0 winnings
	 */
	@Test
	public void EvenOrOdd_3_3() {
		rouletteTest.setKey(2);
		assertEquals("15", rouletteTest.spin().getNumber());		
		Pocket p = new Pocket();
		p.setNumber("12");
		assertEquals(new BigDecimal(0), bs.EvenOrOdd(new BigDecimal(10), p));	
	}	
	/*
    Given 
        A customer has placed a bet of £10 on odd
    When
        I spin the roulette wheel and the ball lands on an even pocket
    Then
        The customer will receive £0 winnings
	 */
	@Test
	public void EvenOrOdd_3_4() {
		rouletteTest.setKey(1);
		assertEquals("32", rouletteTest.spin().getNumber());		
		Pocket p = new Pocket();
		p.setNumber("15");
		assertEquals(new BigDecimal(0), bs.EvenOrOdd(new BigDecimal(10), p));	
	}		

	/*
     Given 
        A customer has placed a bet of £10 on odd
    When
        I spin the roulette wheel and the ball lands on an odd pocket
    Then
        The customer will receive £20 winnings
	 */
	@Test
	public void EvenOrOdd_3_5() {
		rouletteTest.setKey(3);
		assertEquals("19", rouletteTest.spin().getNumber());		
		Pocket p = new Pocket();
		p.setNumber("15");
		assertEquals(new BigDecimal(20), bs.EvenOrOdd(new BigDecimal(10), p));	
	}		

	//    Implement a second house pocket named 00
	@Test
	public void EvenOrOdd_4() {
		rouletteTest = new RouletteWheelTest(Constants.DOUBLE_ZERO_WHEEL);
		System.out.println(rouletteTest.getWheelPocketsMap().size());
		assertTrue(rouletteTest.getWheelPocketsMap().containsKey("00"));
	}


}		
class RouletteWheelTest extends RouletteWheel{
	private int key;
	private String[] wheelNumbers;
	/**
	 * @param wheelNumbers
	 */
	public RouletteWheelTest(String[] wheelNumbers) {
		super(wheelNumbers);
		this.wheelNumbers = wheelNumbers;
	}

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public Pocket spin(){
		Pocket p = new Pocket();
		p.setNumber(wheelNumbers[key]);

		return p ;
	}

}