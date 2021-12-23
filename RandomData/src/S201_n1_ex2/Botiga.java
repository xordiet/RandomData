package S201_n1_ex2;

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
		return "INSERT INTO S201_n1_ex2.botigues (nom, adresa, codi_postal, "
				+ "localitat_id, provincia_id) "
				+ "VALUES (\"" + nom + "\", \"" + adresa + "\", " + codiPostal 
				+ ", " + localitatID + ", " + provinciaID + ");";
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
