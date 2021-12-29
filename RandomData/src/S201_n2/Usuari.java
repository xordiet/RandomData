package S201_n2;

public class Usuari implements Comparable<Usuari> {
	private int id;
	private String email;
	private String password;
	private String username;
	private String dataNaixement;
	private String sexe;
	private int pais;
	private int codiPostal;
	
	public Usuari(int id, String email, String password, String username, 
			String dataNaixement, String sexe, int pais, int codiPostal) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.dataNaixement = dataNaixement;
		this.sexe = sexe;
		this.pais = pais;
		this.codiPostal = codiPostal;
	}

	@Override
	public String toString() {
		return "INSERT INTO S201_n2.usuaris (email, password, username, data_naixement, "
				+ "sexe, pais_id, codi_postal) VALUES (\"" + email + "\", \"" + password 
				+ "\", \"" + username + "\", \"" + dataNaixement + "\", \"" + sexe + "\", " 
				+ pais + ", " + codiPostal + ");";
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
