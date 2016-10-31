package eu.spinup.salestaxes.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import eu.spinup.salestaxes.model.Category;
import eu.spinup.salestaxes.model.Good;
import eu.spinup.salestaxes.model.Order;
import eu.spinup.salestaxes.model.Receipt;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SimpleApplication implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		
		showOutput1();
		showOutput2();
		showOutput3();
		
	}
	
	public void showOutput1(){
		
		Good good1 = new Good("Book", 1, 12.49, Category.BOOKS, false);
		Good good2 = new Good("CD", 1, 14.99, Category.GENERIC, false);
		Good good3 = new Good("Chocolate bar", 1, 0.85, Category.FOOD, false);
		
		Order order = new Order();
		order.addGood(good1);
		order.addGood(good2);
		order.addGood(good3);
		
		Receipt receipt = order.getReceipt();
		
		System.out.println(receipt);
		
	}
	
	public void showOutput2(){
		
		Good good1 = new Good("Imported box of chocolates", 1, 10.00, Category.FOOD, true);
		Good good2 = new Good("Imported bottle of perfume", 1, 47.50, Category.GENERIC, true);
		
		Order order = new Order();
		order.addGood(good1);
		order.addGood(good2);
		
		Receipt receipt = order.getReceipt();
		
		System.out.println(receipt);
		
	}

	public void showOutput3(){
	
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
		
		
		System.out.println(receipt);
		
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SimpleApplication.class, args);
	}

}
