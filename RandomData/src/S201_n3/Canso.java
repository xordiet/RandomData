package S201_n3;

public class Canso implements Comparable<Canso> {
	private int id;
	private int usuariId;
	private String estat;
	private String titol;
	private String descripcio;
	private int grandaria;
	private String nomArxiu;
	private String durada;
	private String thumbnail;
	private int reproduccions;
	private int likes;
	private int dislikes;
	private String publicat;
	

	public Canso(int id, int usuariId, String estat, String titol, String descripcio, int grandaria, String nomArxiu,
			String durada, String thumbnail, int reproduccions, int likes, int dislikes, String publicat) {
		this.id = id;
		this.usuariId = usuariId;
		this.estat = estat;
		this.titol = titol;
		this.descripcio = descripcio;
		this.grandaria = grandaria;
		this.nomArxiu = nomArxiu;
		this.durada = durada;
		this.thumbnail = thumbnail;
		this.reproduccions = reproduccions;
		this.likes = likes;
		this.dislikes = dislikes;
		this.publicat = publicat;
	}

	public int getId() {
		return id;
	}

	public String getTitol() {
		return titol;
	}
	
	public int getUsuariId() {
		return usuariId;
	}

	public String getEstat() {
		return estat;
	}

	public int getLikes() {
		return likes;
	}

	public int getDislikes() {
		return dislikes;
	}	

	@Override
	public int compareTo(Canso o) {
		int comparaCodi = ((Canso)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "";
		sql += "INSERT INTO S201_n2.videos (usuari_id, estat, titol, descripcio, "
				+ "grandaria, nom_arxiu, durada, thumbnail, reproduccions, likes, dislikes, "
				+ "publicat) " + "VALUES (" + usuariId + ", \"" + estat + "\", \""
				+ titol + "\", \"" + descripcio + "\", " + grandaria + ", \"" 
				+ nomArxiu + "\", \"" + durada + "\", \"" + thumbnail + "\", " 
				+ reproduccions + ", " + likes + ", " + dislikes + ", \"" + publicat + "\" );";
		return sql;
	}

	
	
}
