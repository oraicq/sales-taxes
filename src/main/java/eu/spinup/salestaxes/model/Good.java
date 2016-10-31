package eu.spinup.salestaxes.model;

import eu.spinup.salestaxes.utils.NumberUtils;

public class Good {

	private final String name;
	private final Category category;
	private final double unitCost;
	private final double initialCost;
	private double finalCost;
	private double tax;
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	private final int qty;
	private final boolean isImported;
	
	public Good(String name, int qty, double unitCost, Category category, boolean isImported){
		this.name = name;
		this.qty = qty;
		this.category = category;
		this.isImported = isImported;
		this.unitCost = unitCost;
		this.initialCost = unitCost * qty;
	}
	
	public double getFinalCost() {
		return finalCost = NumberUtils.roundToNearest(tax + unitCost * qty, 0.01D);
	}

	public double getUnitCost() {
		return unitCost;
	}

	public Category getCategory() {
		return category;
	}

	public boolean isImported() {
		return isImported;
	}

	public String getName() {
		return name;
	}
	public int getQty() {
		return qty;
	}
	
	@Override
	public String toString(){
		return qty + "\t " + name + "\t " + finalCost;
	}

	public double getInitialCost() {
		return initialCost;
	}
	
}
