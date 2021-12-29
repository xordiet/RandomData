package S201_n3;

public class Canso implements Comparable<Canso> {
	private int id;
	private String titol;
	private String durada;
	private int artista;
	private int album;
	private int reproduccions;
	
	public Canso(int id, String titol, String durada, int artista, int album, int reproduccions) {
		this.id = id;
		this.titol = titol;
		this.durada = durada;
		this.artista = artista;
		this.album = album;
		this.reproduccions = reproduccions;
	}

	public int getId() {
		return id;
	}

	public String getTitol() {
		return titol;
	}
	
	@Override
	public int compareTo(Canso o) {
		int comparaCodi = ((Canso)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "";
		sql += "INSERT INTO S201_n3.cancons (titol, durada, artista, album, reproduccions) "
				+ "VALUES (\"" + titol + "\", \"" + durada + "\", " + artista + ", " 
				+ album + ", " + reproduccions + ");";
		return sql;
	}

	
	
}
