package eu.spinup.salestaxes.model;

import java.util.ArrayList;

public class Order {

	
	private ArrayList<Good> goods;
	
	public Order(){
		goods = new ArrayList<>();
	}
	
	public ArrayList<Good> getGoods(){
		return goods;
	}
	
	public void addGood(Good good){
		goods.add(good);
	}
	
	public Receipt getReceipt(){
		
		Receipt receipt = new Receipt(this);
		return receipt;
		
	}
	
}
