# Roulette Simple

###  Implementation
The implementation of this solution is based on a service interface that provides the features for a basic roulette bets: Straight/Single and Even Or Odd. 
The roulette Engine is based on the RouletteWheel class, the constructor accepts a String[] wheelNumbers. I provided in the Constants class, the array String[] containing the numbers for the Single zero wheel and for the double zero wheel. The constructor calls the private method setWheelPockets which loads a LinkedHashMap<String,String>, having the Key an number of Pocket and the value is the related color (calculated directly by the Pocket Plain Old Java Object). The use of the LinkedHashMap is to mantain the order to have a good model of the object RouletteWheel in line to a real roulette. 

##### Service interface
The Service interface "BetService" provides the method:
 - 	public BigDecimal StraightSingle(BigDecimal bet, Pocket pocketBet);
 -	public BigDecimal EvenOrOdd(BigDecimal bet, Pocket pocketBet);

   BigDecimal is for the return of a currency
 
> **Note/assumptions:**  The RouletteWheel class has a basic implementation of the method spin() using the java.util.Random object. For the test this methd is overloaded by a sub hinner class used just for the tests. BetServiceImplTest included in the BetServiceImplTes class.    

----------

##### Class diagram
![Roulette Simple](/RouletteSimple/doc/class-diagram.jpg)

----------

###  Execution
you can import into Eclipse as a maven project. 

Using the command
```
maven clean install
```
maven will compile and will execute the test provided for the scenarios requested.

----------

