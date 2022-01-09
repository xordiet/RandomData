package S203_n2;

import java.util.ArrayList;
import java.util.List;

public class Video implements Comparable<Video> {
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
	private List<Integer> etiquetes;
	private String publicat;
	

	public Video(int id, int usuariId, String estat, String titol, String descripcio, int grandaria, String nomArxiu,
			String durada, String thumbnail, int reproduccions, int likes, int dislikes, List<Integer> etiquetes, String publicat) {
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
		this.etiquetes = etiquetes;
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
	public int compareTo(Video o) {
		int comparaCodi = ((Video)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		return "{ \"_id\": " + id + ", \"estat\": \"" + estat + "\", \"descripcio\": \"" +
				descripcio  + "\", \"grandaria\": " + grandaria + ", \"nom_arxiu\": \"" 
				+ nomArxiu + "\", \"durada\": \"" + durada + "\", \"thumbnail\": \"" + thumbnail
				+ "\", \"reproduccions\": " + reproduccions + ", \"reaccions\": {" 
				+ "\"likes\": " + likes + ", \"dislikes\": " + dislikes + "}" 
				+ ", \"etiquetes\": " + etiquetes +", \"autor\": " + usuariId + ", \"publicat_moment\": "
				+ "\"" + publicat + "\"}";

		}

	
	
}
