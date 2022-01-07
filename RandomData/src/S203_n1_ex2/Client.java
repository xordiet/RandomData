package S203_n1_ex2;

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
		
		return "{ \"_id\": " + id + ", \"nom\": \"" + nom + "\", \"cognoms\": \"" + cognoms + "\", \"adresa\": \"" + adresa + "\", \"codi_postal\": \"" + codiPostal + "\", \"localitat_id\": " + localitatID + ", \"provincia_id\": " + provinciaID + ", \"telefon\": " + telefon + "}";

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
