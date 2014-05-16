/**
File Name:          Chapter12Project02.java
Programmer:         Andrew Caldwell
Date Last Modified: March. 21, 2014

Problem Statement:


Overall Plan:

Classes needed and Purpose:
main class - Chapter12Project02
AJTTArrayList - holding a list of pizzas
Pizza - the pizza model
PizzaOrder - pizza list wrapper
*/

public class Chapter12Project02 {
	public static void main(String[] args) {
		PizzaOrder order = new PizzaOrder();
		Pizza[] pizzas = {new Pizza(), new Pizza(true,false,true,Pizza.SIZE_TYPE.MEDIUM), new Pizza(true,true,true,Pizza.SIZE_TYPE.LARGE)};
		for (Pizza p : pizzas) {
			order.add(p);
		}
		System.out.println("Total cost for order is "+ order.getCost());
	}
}