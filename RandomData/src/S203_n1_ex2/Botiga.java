package S203_n1_ex2;

public class Botiga implements Comparable<Botiga> {
	private int id;
	private String nom;
	private String adresa;
	private String codiPostal;
	private int localitatID;
	private int provinciaID;
	
	public Botiga(int id, String nom, String adresa, String codiPostal,
			int localitatID, int provinciaID) {
		this.id = id;
		this.nom = nom;
		this.adresa = adresa;
		this.codiPostal = codiPostal;
		this.localitatID = localitatID;
		this.provinciaID = provinciaID;
	}

	@Override
	public String toString() {
		return "{ \"_id\": " + id + ", \"adresa\": \"" + adresa + "\", \"codi_postal\": \"" + codiPostal + "\", \"localitat_id\": " + localitatID + ", \"provincia_id\": " + provinciaID + "}";
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
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

	@Override
	public int compareTo(Botiga o) {
		int comparaCodi = ((Botiga)o).getId();
		return this.id - comparaCodi;
	}
	
}
