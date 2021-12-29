package S201_n2;

public class Playlist implements Comparable<Playlist> {
	private int id;
	private int creador;
	private String nom;
	private String creacio;
	private boolean publica;

	
	public Playlist(int id, int creador, String nom, String creacio, boolean publica) {
		this.id = id;
		this.creador = creador;
		this.nom = nom;
		this.creacio = creacio;
		this.publica = publica;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Playlist o) {
		int comparaCodi = ((Playlist)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n2.playlist (creador, nom, creacio, publica) " 
				+ "VALUES (" + creador + ", \"" + nom + "\", \"" + creacio + "\", " + publica + ");";
		return sql;
	}
	
}
