package S203_n1_ex2;

public class Categoria implements Comparable<Categoria> {
	private int id;
	private String nom;

	
	public Categoria(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public int compareTo(Categoria o) {
		int comparaCodi = ((Categoria)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		return "{ \"_id\": " + id + ", \"nom\": \"" + nom + "\"}";
	}
	
}
