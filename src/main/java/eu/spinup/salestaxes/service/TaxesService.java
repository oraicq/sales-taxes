package eu.spinup.salestaxes.service;

import java.util.HashMap;



import eu.spinup.salestaxes.model.Category;
import eu.spinup.salestaxes.model.Good;
import eu.spinup.salestaxes.utils.NumberUtils;


public class TaxesService {

	private static HashMap<Category, Double> taxesRepository;
	
	static{
		taxesRepository = new HashMap<>();
		taxesRepository.put(Category.BOOKS, 0D);
		taxesRepository.put(Category.FOOD, 0D);
		taxesRepository.put(Category.MEDICAL, 0D);
		taxesRepository.put(Category.GENERIC, 0.1D);
	}

	
	public static void applyTax(Good good){
		
		double taxToApply = taxesRepository.get(good.getCategory());
		double goodInitialCost = good.getInitialCost();
		
		double tax = goodInitialCost * taxToApply; //Apply tax searched through good's category
		
		if(good.isImported()){
			tax += goodInitialCost * 0.05D; //Apply 5% taxes If good is imported
		}
		
		
		tax = NumberUtils.roundUpToNearest(tax, 0.05D); //rounded to nearest 0.05
		good.setTax(tax); //Set good's taxes
		
	}
	
}
