package eu.spinup.salestaxes.application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.spinup.salestaxes.application.SimpleApplication;
import eu.spinup.salestaxes.model.Category;
import eu.spinup.salestaxes.model.Good;
import eu.spinup.salestaxes.model.Order;
import eu.spinup.salestaxes.model.Receipt;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimpleApplication.class)
public class SimpleApplicationTests {

	
	@Test
	public void TestInput1(){
		
		/*
		 * INPUT
		 * 1 book at 12.49
		 * 1 music CD at 14.99
         * 1 chocolate bar at 0.85
         * 
         * OUTPUT
         * 1 book : 12.49
			1 music CD: 16.49
			1 chocolate bar: 0.85
			Sales Taxes: 1.50
			Total: 29.83
		 */
		
		Good good1 = new Good("Book", 1, 12.49, Category.BOOKS, false);
		Good good2 = new Good("CD", 1, 14.99, Category.GENERIC, false);
		Good good3 = new Good("Chocolate bar", 1, 0.85, Category.FOOD, false);
		
		Order order = new Order();
		order.addGood(good1);
		order.addGood(good2);
		order.addGood(good3);
		
		Receipt receipt = order.getReceipt();
		
		Assert.assertTrue("Wrong Good1 Amount", good1.getFinalCost() == 12.49);
		Assert.assertTrue("Wrong Good2 Amount", good2.getFinalCost() == 16.49);
		Assert.assertTrue("Wrong Good3 Amount", good3.getFinalCost() == 0.85);
		
		
		Assert.assertTrue("Wrong Receipt Amount", receipt.getReceiptAmount() == 29.83);
		Assert.assertTrue("Wrong Taxes Amount", receipt.getTaxesAmount() == 1.50);
		
	}
	
	@Test
	public void TestInput2(){
		
		/*
		 * INPUT
		 * 1 imported box of chocolates at 10.00
			1 imported bottle of perfume at 47.50
         * 
         * OUTPUT
         * 1 imported box of chocolates: 10.50
			1 imported bottle of perfume: 54.65
			Sales Taxes: 7.65
			Total: 65.15
		 */
		
		Good good1 = new Good("Imported box of chocolates", 1, 10.00, Category.FOOD, true);
		Good good2 = new Good("Imported bottle of perfume", 1, 47.50, Category.GENERIC, true);
		
		Order order = new Order();
		order.addGood(good1);
		order.addGood(good2);
		
		Receipt receipt = order.getReceipt();
		
		Assert.assertTrue("Wrong Good1 Amount", good1.getFinalCost() == 10.50);
		Assert.assertTrue("Wrong Good2 Amount", good2.getFinalCost() == 54.65);
		
		
		Assert.assertTrue("Wrong Receipt Amount", receipt.getReceiptAmount() == 65.15);
		Assert.assertTrue("Wrong Taxes Amount", receipt.getTaxesAmount() == 7.65);
		
	}
	
	@Test
	public void TestInput3(){
		
		/*
		 * INPUT
		 * 1 imported bottle of perfume at 27.99
			1 bottle of perfume at 18.99
			1 packet of headache pills at 9.75
			1 box of imported chocolates at 11.25
         * 
         * OUTPUT
			1 imported bottle of perfume: 32.19
			1 bottle of perfume: 20.89
			1 packet of headache pills: 9.75
			1 imported box of chocolates: 11.85
			Sales Taxes: 6.70
			Total: 74.68
		 */
		
		Good good1 = new Good("imported bottle of perfume", 1, 27.99, Category.GENERIC, true);
		Good good2 = new Good("bottle of perfume", 1, 18.99, Category.GENERIC, false);
		Good good3 = new Good("packet of headache pills", 1, 9.75, Category.MEDICAL, false);
		Good good4 = new Good("box of imported chocolates", 1, 11.25, Category.FOOD, true);
		
		Order order = new Order();
		order.addGood(good1);
		order.addGood(good2);
		order.addGood(good3);
		order.addGood(good4);
		
		Receipt receipt = order.getReceipt();
		
		Assert.assertTrue("Wrong Good1 Amount", good1.getFinalCost() == 32.19);
		Assert.assertTrue("Wrong Good2 Amount", good2.getFinalCost() == 20.89);
		Assert.assertTrue("Wrong Good3 Amount", good3.getFinalCost() == 9.75);
		Assert.assertTrue("Wrong Good4 Amount", good4.getFinalCost() == 11.85);
		
		
		Assert.assertTrue("Wrong Receipt Amount", receipt.getReceiptAmount() == 74.68);
		Assert.assertTrue("Wrong Taxes Amount", receipt.getTaxesAmount() == 6.70);
		
	}
	
}
