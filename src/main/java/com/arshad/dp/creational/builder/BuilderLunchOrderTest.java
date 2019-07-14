package com.arshad.dp.creational.builder;

public class BuilderLunchOrderTest {

	public static void main(String[] args) {
		
		LunchOrder.Builder builder = new LunchOrder.Builder();
		
		builder.bread("wheat").condiments("Lettuce").dressing("Mayo").meat("Turkey");
		
		LunchOrder lunchOrder = builder.build();
		
		System.out.println(lunchOrder);
	}
}
