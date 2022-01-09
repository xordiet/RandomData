package S203_n2;

public class Etiqueta implements Comparable<Etiqueta> {
	private int id;
	private String nom;

	
	public Etiqueta(int id, String nom) {
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
	public int compareTo(Etiqueta o) {
		int comparaCodi = ((Etiqueta)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		return "{ \"_id\": " + id + ", \"nom\": \"" + nom + "\"}";
	}
	
}
