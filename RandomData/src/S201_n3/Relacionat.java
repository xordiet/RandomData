package S201_n3;

public class Relacionat implements Comparable<Relacionat> {
	private int id;
	private int artistaBase;
	private int artistaRelacionat;

	
	public Relacionat(int id, int artistaBase, int artistaRelacionat) {
		this.id = id;
		this.artistaBase = artistaBase;
		this.artistaRelacionat = artistaRelacionat;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Relacionat o) {
		int comparaCodi = ((Relacionat)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n3.artistes_relacionats (artista_base, artista_relacionat) " 
				+ "VALUES (" + artistaBase + ", " + artistaRelacionat + ");";
		return sql;
	}
	
}
