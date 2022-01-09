package S203_n2;

public class Usuari implements Comparable<Usuari> {
	private int id;
	private String email;
	private String password;
	private String username;
	private String dataNaixement;
	private String sexe;
	private String isoPais;
	private String nomPais;
	private int codiPostal;
	
	public Usuari(int id, String email, String password, String username, 
			String dataNaixement, String sexe, String isoPais, String nomPais, int codiPostal) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.dataNaixement = dataNaixement;
		this.sexe = sexe;
		this.isoPais = isoPais;
		this.nomPais = nomPais;
		this.codiPostal = codiPostal;
	}

	@Override
	public String toString() {
		return "{ \"_id\": " + id + ", \"email\": \"" + email + "\", \"password\": \"" 
				+ password + "\", \"username\": \"" + username + "\", \"data_naixement\":  ISODate(\"" 
				+ dataNaixement + "\"), \"sexe\": \"" + sexe + "\", \"pais\": [\"" 
				+ isoPais + "\", \"" + nomPais + "\"], \"codi_postal\": " + codiPostal + "}";
	}
	
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public int compareTo(Usuari o) {
		int comparaCodi = ((Usuari)o).getId();
		return this.id - comparaCodi;
	}
	
}
