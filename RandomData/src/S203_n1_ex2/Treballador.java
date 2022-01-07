package S203_n1_ex2;

public class Treballador implements Comparable<Treballador> {
	private int id;
	private String nom;
	private String cognoms;
	private String nif;
	private int telefon;
	private String categoria;
	private int botigaID;
	
	public Treballador(int id, String nom, String cognoms, String nif, int telefon,
			String categoria, int botigaid) {
		this.id = id;
		this.nom = nom;
		this.cognoms = cognoms;
		this.nif = nif;
		this.telefon = telefon;
		this.categoria = categoria;
		this.botigaID = botigaid;
	}

	@Override
	public String toString() {
		return "{ \"_id\": " + id + ", \"nom\": \"" + nom + "\", \"cognoms\": \"" + cognoms + "\", \"nif\": \"" + nif + "\", \"telefon\": " + telefon + ", \"botiga\": " + botigaID + ", \"categoria\": \"" + categoria + "\"}";

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
		return botigaID;
	}
	
	@Override
	public int compareTo(Treballador o) {
		int comparaCodi = ((Treballador)o).getId();
		return this.id - comparaCodi;
	}
	
}
