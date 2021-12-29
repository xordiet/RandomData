package S201_n3;

public class Playlist implements Comparable<Playlist> {
	private int id;
	private String titol;
	private int numCansons;
	private String creacio;
	private boolean eliminada;
	private String dataEliminacio;
	private int userCreador;

	public Playlist(int id, String titol, int numCansons, String creacio, boolean eliminada, String dataEliminacio, int userCreador) {
		this.id = id;
		this.titol = titol;
		this.numCansons = numCansons;
		this.creacio = creacio;
		this.eliminada = eliminada;
		this.dataEliminacio = dataEliminacio;
		this.userCreador = userCreador;
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
		String sql = "INSERT INTO S201_n3.playlist (titol, num_cancons, creacio, "
				+ "eliminada, data_eliminacio, usuari_creador) VALUES (\"" + titol 
				+ "\", " + numCansons + ", \"" + creacio + "\", " + eliminada;
		if(eliminada) {
			sql += ", \"" + dataEliminacio + "\", ";
		} else {
			sql += ", NULL, ";
		}
		sql += userCreador + ");";
		return sql;
	}
	
}
