package S201_n3;

public class Usuari implements Comparable<Usuari> {
	private int id;
	private boolean premium;
	private String email;
	private String password;
	private String username;
	private String dataNaixement;
	private String sexe;
	private int pais;
	private int codiPostal;
	
	public Usuari(int id, boolean premium, String email, String password, String username, 
			String dataNaixement, String sexe, int pais, int codiPostal) {
		this.id = id;
		this.premium = premium;
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
		return "INSERT INTO S201_n3.usuaris (premium, email, password, username, naixement, "
				+ "sexe, pais, codi_postal) VALUES (" + premium + ", \"" + email + "\", \"" + password 
				+ "\", \"" + username + "\", \"" + dataNaixement + "\", \"" + sexe + "\", " 
				+ pais + ", " + codiPostal + ");";
	}
	
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	
	public boolean isPremium() {
		return premium;
	}

	@Override
	public int compareTo(Usuari o) {
		int comparaCodi = ((Usuari)o).getId();
		return this.id - comparaCodi;
	}

	
	
}
