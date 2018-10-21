/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import client.Client;


/**
 * @author formation
 *
 */
public class ClientDao{

	private List<Client> listClient = new ArrayList<Client>();
	
	
	public ClientDao(){
		super();
		
		Client client1 = new Client(0, "Zueras", "Alexis", 500.0F);
		this.listClient.add(client1);
		
		Client client2 = new Client(1, "Maurice", "Noel", 50.0F);
		this.listClient.add(client2);
	}
	
	public List<Client> afficherAllClients() {
		// TODO Auto-generated method stub
		return listClient;
	}
	
	public void saveNewClient(Client client) {
		listClient.add(client);
		
	}

	public void updateClient(String nom, Client client) {
		Client clientOld = findClientByName(nom);
		
		if (clientOld != null)
		{
			listClient.remove(clientOld);
			listClient.add(client);
		}
		
	}

	
	public void deleteClient(String nom) {
		Client client = findClientByName(nom);
		
		if (client != null)
		{
			listClient.remove(client);
		}
		
	}

	public Client findClientByName(String nom) {

		boolean trouveP = false;
		Client result = null;
		
		for (int i = 0; i < listClient.size() && !trouveP; i++) 
		{
			Client client = listClient.get(i);
			
			if (client.getNom().equalsIgnoreCase(nom))
			{
				trouveP = true;
				
				result = client;				
			}
		}
		
		return result;
	}

	public boolean pizzaExists(String nom) {

		Client client = findClientByName(nom);
		
		return client != null;
	}
	
	@Override
	public String toString() {
		return "ClientDao [listClient=" + listClient + "]";
	}

	
}
