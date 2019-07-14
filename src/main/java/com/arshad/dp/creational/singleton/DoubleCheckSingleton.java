package com.arshad.dp.creational.singleton;

public class DoubleCheckSingleton {
	
	private static volatile DoubleCheckSingleton instance = null;
	
	private DoubleCheckSingleton() {
		if(instance != null) {      //Prevent object being created through reflection
			throw new RuntimeException("Use getInstance() to create object!");
		}
	}
	
	public static DoubleCheckSingleton getInstance() {
		
		if(instance == null) {
			synchronized(DoubleCheckSingleton.class) {
				if(instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		
		return instance;
	}
	
	
	public static void main(String[] args) {

	}

}
