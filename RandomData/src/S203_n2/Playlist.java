package S203_n2;

import java.util.List;

public class Playlist implements Comparable<Playlist> {
	private int id;
	private int creador;
	private String nom;
	private String creacio;
	private String estat;
	private List<Integer> videos;

	
	public Playlist(int id, int creador, String nom, String creacio, boolean publica, List<Integer> videos) {
		this.id = id;
		this.creador = creador;
		this.nom = nom;
		this.creacio = creacio;
		if(publica) {
			this.estat="pública";
		} else {
			this.estat="privada";
		}
		this.videos = videos;
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
		return "{ \"creador\": " + creador + ", \"nom\": \"" + nom + "\", \"data_creacio\": "
				+ "\"" + creacio + "\", \"estat\": \"" + estat + "\", \"videos\": " + videos +"}";
	}
	
}
