package S201_n3;

public class Album implements Comparable<Album> {
	private int id;
	private int artista;
	private String titol;
	private int anyPublicacio;
	private String portada;

	public Album(int id, int artista, String titol, int anyPublicacio, String portada) {
		this.id = id;
		this.artista = artista;
		this.titol = titol;
		this.anyPublicacio = anyPublicacio;
		this.portada = portada;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Album o) {
		int comparaCodi = ((Album)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n3.albums (artista, titol, any_publicacio, img_portada) "
				+ "VALUES (" + artista + ", \"" + titol + "\", " + anyPublicacio + ", \"" + portada + "\");";
		return sql;
	}

	
	
}
