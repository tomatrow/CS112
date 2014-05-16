public class PizzaOrder {
	private AJTTArrayList<Pizza> _pizzas;

	PizzaOrder() {
		_pizzas = new AJTTArrayList<Pizza>();
	}

	public void add(Pizza pizza) {
		_pizzas.add(pizza);
	}
	public int numPizzas() {
		return _pizzas.length();
	}
	public int getCost() {
		int cost = 0;

		for (int x = 0;x < _pizzas.length();x++) {
			cost += _pizzas.get(x).getCost();
		}

		return cost;
	}

}