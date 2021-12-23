package S201_n1_ex2;

public class Client implements Comparable<Client> {
	private int id;
	private String nom;
	private String cognoms;
	private String adresa;
	private String codiPostal;
	private int localitatID;
	private int provinciaID;
	private int telefon;
	
	public Client(int id, String nom, String cognoms, String adresa, String codiPostal,
			int localitatID, int provinciaID, int telefon) {
		this.id = id;
		this.nom = nom;
		this.cognoms = cognoms;
		this.adresa = adresa;
		this.codiPostal = codiPostal;
		this.localitatID = localitatID;
		this.provinciaID = provinciaID;
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "INSERT INTO S201_n1_ex2.clients (nom, cognoms, adresa, codi_postal, localitat_id, provincia_id, telefon) "
				+ "VALUES (\"" + nom + "\", \"" + cognoms + "\", \"" + adresa 
				+ "\", " + codiPostal + ", " + localitatID + ", " +
				provinciaID + ", " + telefon + ");";
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public String getAdresa() {
		return adresa;
	}

	public String getCodiPostal() {
		return codiPostal;
	}

	public int getLocalitatID() {
		return localitatID;
	}

	public int getProvinciaID() {
		return provinciaID;
	}

	public int getTelefon() {
		return telefon;
	}
	
	@Override
	public int compareTo(Client o) {
		int comparaCodi = ((Client)o).getId();
		return this.id - comparaCodi;
	}
	
}
