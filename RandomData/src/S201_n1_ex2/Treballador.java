package S201_n1_ex2;

public class Treballador implements Comparable<Treballador> {
	private int id;
	private String nom;
	private String cognoms;
	private String nif;
	private int telefon;
	private String categoria;
	private int botigaid;
	
	public Treballador(int id, String nom, String cognoms, String nif, int telefon,
			String categoria, int botigaid) {
		this.id = id;
		this.nom = nom;
		this.cognoms = cognoms;
		this.nif = nif;
		this.telefon = telefon;
		this.categoria = categoria;
		this.botigaid = botigaid;
	}

	@Override
	public String toString() {
		return "INSERT INTO S201_n1_ex2.treballadors (nom, cognoms, nif, telefon, categoria, botiga_id) "
				+ "VALUES (\"" + nom + "\", \"" + cognoms + "\", \"" + nif 
				+ "\", " + telefon + ", \"" + categoria + "\", " + botigaid + ");";
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

	public String getNif() {
		return nif;
	}

	public int getTelefon() {
		return telefon;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public int getBotigaid() {
		return botigaid;
	}
	
	@Override
	public int compareTo(Treballador o) {
		int comparaCodi = ((Treballador)o).getId();
		return this.id - comparaCodi;
	}
	
}
