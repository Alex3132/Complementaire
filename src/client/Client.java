/**
 * 
 */
package client;


import exceptions.CreditException;
import exceptions.DebitException;
import interfaces.ICompteStat;
import pizza.Pizza;

/**
 * @author formation
 *
 */
public class Client implements ICompteStat {
	private Integer id = new Integer(Integer.MIN_VALUE);
	private String nom = null;
	private String prenom = null;
	protected double solde = new Integer(Integer.MIN_VALUE);
	public final static int CREDIT_MAX = 5000;
	public final static int CREDIT_DECOUVERT = 0;
	
	public Client(Integer id, String nom, String prenom, double solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public void crediterCompte(double montant) throws CreditException{
		
		if(this.getSolde() + montant > CREDIT_MAX) {
			throw new CreditException("5000€ sont dépassés");
		}
		this.setSolde(this.getSolde()+montant);
	}
	
	public void debiterCompte(double montant) throws DebitException{
		if(this.getSolde()- montant<=CREDIT_DECOUVERT) {
			throw new DebitException("Le compte est vide");
		}
		this.setSolde(this.getSolde()-montant);
	}
	
	public void commandePizza(Pizza pizza) {
		try {
			debiterCompte(pizza.getPrix());
		} catch (DebitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", solde=" + solde + "]";
	}

	
	
}

