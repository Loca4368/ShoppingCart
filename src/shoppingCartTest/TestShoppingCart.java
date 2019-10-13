/*
 * Simple Unit test for Tour ShoppingCart
 * Created by: Ming
 */
package shoppingCartTest;

import java.util.ArrayList;
import java.util.List;

import shoppingCart.*;

import org.junit.Test;

import junit.framework.TestCase;

public class TestShoppingCart extends TestCase {

	List<PromotionRule> promoRules = new ArrayList<PromotionRule>();
	ShoppingCart sp = new ShoppingCart(promoRules);

	ShoppingItem tour1;
	ShoppingItem tour2;
	ShoppingItem tour3;

	public void setUp()

	{

		tour1 = new ShoppingItem("OH", "Opera house tour", 300.0);
		tour2 = new ShoppingItem("BC", "Sydney Bridge Climb", 110.0);
		tour3 = new ShoppingItem("SK", "Sydney Sky Tower", 30.0);

		promoRules.add(new Buy2Get1OH());
		promoRules.add(new Buy1OHGet1SK());
		promoRules.add(new BuyMoreThan4BCDiscount());

	}

	
	/* Test for Shopping Cart
	 * Conditions: 
	 * 1: OH,OH,OH,BC => $710,
	 * 2: OH,SK => $300,
	 * 3: BC,BC,BC,BC,BC,OH => $750,
	 * 4: OH,OH,OH => $600,
	 * 5: OH,OH,SK,SK => $600,
	 * 6: OH,OH,OH,SK,SK => $600,
	 * 7: BC,BC,BC,BC=> $440,
	 * 8: BC,BC,BC,BC,BC=> $450.
	 */

	@Test
	public void testShoppingCartConditionOne() {
		sp.add(tour1);
		sp.add(tour1);
		sp.add(tour1);
		sp.add(tour2);

		double excpetedResult = 710;

		assertEquals(excpetedResult, sp.total());
	}

	@Test
	public void testShoppingCartConditionTwo() {
		sp.add(tour1);
		sp.add(tour3);

		double excpetedResult = 300;

		assertEquals(excpetedResult, sp.total());
	}

	@Test
	public void testShoppingCartConditionThree() {
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour1);

		double excpetedResult = 750;

		assertEquals(excpetedResult, sp.total());
	}

	@Test
	public void testShoppingCartConditionFour() {

		sp.add(tour1);
		sp.add(tour1);
		sp.add(tour1);

		double excpetedResult = 600;

		assertEquals(excpetedResult, sp.total());
	}

	@Test
	public void testShoppingCartConditionFive() {

		sp.add(tour1);
		sp.add(tour1);
		sp.add(tour3);
		sp.add(tour3);

		double excpetedResult = 600;

		assertEquals(excpetedResult, sp.total());
	}

	@Test
	public void testShoppingCartConditionSix() {

		sp.add(tour1);
		sp.add(tour1);
		sp.add(tour1);
		sp.add(tour3);
		sp.add(tour3);

		double excpetedResult = 600;

		assertEquals(excpetedResult, sp.total());
	}

	@Test
	public void testShoppingCartConditionSeven() {

		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);

		double excpetedResult = 440;

		assertEquals(excpetedResult, sp.total());
	}

	@Test
	public void testShoppingCartConditionEight() {

		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);

		double excpetedResult = 450;

		assertEquals(excpetedResult, sp.total());
	}
}
