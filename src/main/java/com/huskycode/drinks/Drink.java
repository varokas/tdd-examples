package com.huskycode.drinks;

import static com.huskycode.drinks.Drink.Base.CHOCOLATE;
import static com.huskycode.drinks.Drink.Base.COFFEE;
import static com.huskycode.drinks.Drink.CoffeeType.AMERICANO;
import static com.huskycode.drinks.Drink.CoffeeType.LATTE;
import static com.huskycode.drinks.Drink.CoffeeType.MOCHA;
import static com.huskycode.drinks.Drink.CoffeeType.NOT_A_COFFEE;
import static com.huskycode.drinks.Drink.Condiment.CARAMEL;
import static com.huskycode.drinks.Drink.Condiment.JAVA_CHIP;
import static com.huskycode.drinks.Drink.Condiment.WHIP_CREAM;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class Drink {
	enum Base { COFFEE, CHOCOLATE, GREEN_TEA }
	enum CoffeeType { LATTE, MOCHA, AMERICANO, NOT_A_COFFEE } 
	enum Condiment { CARAMEL, WHIP_CREAM, JAVA_CHIP }
	
	public class CondimentNotCompatibleException extends RuntimeException { private static final long serialVersionUID = 1L; }
	public class NotACoffeeException extends RuntimeException { private static final long serialVersionUID = 1L; }
	
	private final Map<Base, Integer> basePriceMap = ImmutableMap.of(
		COFFEE, 0, //Price depends on coffee type
		CHOCOLATE, 1
		//GREEN_TEA, 1 --> Bug !!! HAHAHA
	);
	
	private final Map<CoffeeType, Integer> coffeeTypePriceMap = ImmutableMap.of(
			LATTE, 1,
			MOCHA, 2,
			AMERICANO, 1,
			NOT_A_COFFEE, 0 //Unused
		);
	
	private final Map<Condiment, Integer> condimentPriceMap = ImmutableMap.of(
			CARAMEL, 1, 
			WHIP_CREAM, 1, 
			JAVA_CHIP, 2
		);
	
	
	public int calculatePrice(Base base, CoffeeType coffeeType, List<Condiment> condiments) {
		int price = 0;
		
		if(base != COFFEE & coffeeType != NOT_A_COFFEE) {
			throw new NotACoffeeException();
		}
		
		price += basePriceMap.get(base);
		price += coffeeTypePriceMap.get(coffeeType);
		
		for(Condiment condiment : condiments) {
			price += condimentPriceMap.get(condiment);
		}
		
		//Promotion
		if(base == COFFEE && condiments.contains(Condiment.JAVA_CHIP)) {
			price -= 1;
		}
		
		return price;
	}
}
