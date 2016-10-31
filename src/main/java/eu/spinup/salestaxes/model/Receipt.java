package eu.spinup.salestaxes.model;

import eu.spinup.salestaxes.service.TaxesService;
import eu.spinup.salestaxes.utils.NumberUtils;

public class Receipt {

	private Order order;
	private double taxesAmount;
	private double receiptAmount;

	public Receipt(Order order){
		
		this.order = order;
		
		calculateReceipt();
		
	}
	
	private void calculateReceipt(){
		
		taxesAmount = 0D;
		receiptAmount = 0D;
		
		for(Good good : order.getGoods()){
			TaxesService.applyTax(good);
			
			taxesAmount += good.getTax();
			receiptAmount += good.getFinalCost();
			
		}
		
	}
	
	public double getTaxesAmount() {
		return NumberUtils.roundToNearest(taxesAmount, 0.01D); // I could use BigDecimal to avoid arithmetic floating point errors, e.g. 6.679999999999999 == 6.68
	}

	public double getReceiptAmount() {
		return NumberUtils.roundToNearest(receiptAmount, 0.01D); // I could use BigDecimal to avoid arithmetic floating point errors, e.g. 6.679999999999999 == 6.68
	}

	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		for(Good good : order.getGoods()){
			sb.append(good + "\n");
		}
		
		sb.append("Sales Taxes: " + taxesAmount + "\n");
		sb.append("Total: " + receiptAmount);
		
		return sb.toString();
		
	}
	
}
