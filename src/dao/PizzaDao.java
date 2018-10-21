package dao;

import java.util.ArrayList;
import java.util.List;

import pizza.Pizza;
import enumerations.EnumTypePizza;
import exceptions.PizzaException;

public class PizzaDao{

	private List<Pizza> listPizza = null;
	
	
	public PizzaDao() throws PizzaException {
		super();

		listPizza = new ArrayList<Pizza>();
		
		this.saveNewPizza(new Pizza("MAR", "Margarita", 6.20F, EnumTypePizza.FROMAGE));
		this.saveNewPizza(new Pizza("MER", "Merguez", 8.10F, EnumTypePizza.VIANDE));
		this.saveNewPizza(new Pizza("FRO", "Fromages", 7.20F, EnumTypePizza.FROMAGE));
		this.saveNewPizza(new Pizza("DYN", "Dynamite", 8.20F, EnumTypePizza.VIANDE));
		
	}

	public List<Pizza> findAllPizzas() {
		
		return listPizza;
	}

	public void saveNewPizza(Pizza pizza) {
		listPizza.add(pizza);
		
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza pizzaOld = findPizzaByCode(codePizza);
		
		if (pizzaOld != null)
		{
			listPizza.remove(pizzaOld);
			listPizza.add(pizza);
		}
		
	}

	public void deletePizza(String codePizza) {
		Pizza pizza = findPizzaByCode(codePizza);
		
		if (pizza != null)
		{
			listPizza.remove(pizza);
		}
		
	}

	public Pizza findPizzaByCode(String codePizza) {

		boolean trouveP = false;
		Pizza result = null;
		
		for (int i = 0; i < listPizza.size() && !trouveP; i++) 
		{
			Pizza pizza = listPizza.get(i);
			
			if (pizza.getCode().equalsIgnoreCase(codePizza))
			{
				trouveP = true;
				
				result = pizza;				
			}
		}
		
		return result;
	}

	public boolean pizzaExists(String codePizza) {

		Pizza pizza = findPizzaByCode(codePizza);
		
		return pizza != null;
	}
	
	@Override
	public String toString() {
		
		String result = new String();
		
		for (Pizza pizza : listPizza) {
			result += pizza.toString() + "\r\n";
		}
		
		return result + "\r\n" + "\r\n";
	}

}
