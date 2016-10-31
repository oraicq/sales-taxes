package eu.spinup.salestaxes.utils;

public class NumberUtils {

	public static double roundUpToNearest(double number, double nearest){
		
		double factor = 100 / (nearest * 100);
		
		return Math.ceil(number * factor) / factor;
		
	}
	
	public static double roundToNearest(double number, double nearest){
		
		double factor = 100 / (nearest * 100);
		
		return Math.round(number * factor) / factor;
		
	}
	
}
