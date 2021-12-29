package S201_n3;

public class Artista implements Comparable<Artista> {
	private int id;
	private String nom;
	private String imatge;

	public Artista(int id, String nom, String imatge) {
		this.id = id;
		this.nom = nom;
		this.imatge = imatge;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Artista o) {
		int comparaCodi = ((Artista)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n3.artistes (nom, imatge) VALUES (\"" 
				+ nom + "\", \"" + imatge + "\");";
		return sql;
	}

	
	
}
