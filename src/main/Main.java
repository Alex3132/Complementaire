/**
 * 
 */
package main;

import client.Client;
import dao.ClientDao;
import enumerations.EnumTypePizza;
import exceptions.DebitException;
import exceptions.PizzaException;
import pizza.Pizza;

/**
 * @author formation
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws DebitException 
	 */
	public static void main(String[] args) throws DebitException {
		// TODO Auto-generated method stub
		ClientDao clientDao = new ClientDao();
		System.out.println(clientDao.afficherAllClients());
		
		Pizza p1;
		try {
			p1 = new Pizza("HAW", "Hawaii", 9.0F, EnumTypePizza.AUTRE);
			System.out.println(p1.toString());
		} catch (PizzaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Client client = new Client(3, "Toto", "Tata", 1000.0F);
		try {
			client.debiterCompte(1000.0);
		} catch (DebitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
