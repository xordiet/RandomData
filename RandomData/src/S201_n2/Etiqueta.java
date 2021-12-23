package S201_n2;

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
		return "INSERT INTO S201_n1_ex2.categories_pizzes (nom) " + "VALUES (\"" + nom + "\");";
	}
	
}
