/**
 * 
 */
package enumerations;

/**
 * @author Alex
 *
 */
public enum EnumTypePizza {
	
	VIANDE("Viande"),
	POISSON("Poisson"),
	CRUDITE("Crudité"),
	FROMAGE("Fromage"),
	AUTRE("Autre");
	
	private String nom;

	private EnumTypePizza(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}

