package S201_n2;

public class Comentari implements Comparable<Comentari> {
	private int id;
	private int usuariID;
	private int videoID;
	private String text;
	private String publicat;

	
	public Comentari(int id, int usuariID, int videoID, String text, String publicat) {
		this.id = id;
		this.usuariID = usuariID;
		this.videoID = videoID;
		this.text = text;
		this.publicat = publicat;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Comentari o) {
		int comparaCodi = ((Comentari)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "";
		sql += "INSERT INTO S201_n2.comentaris (usuari_id, video_id, text, publicat) " 
		+ "VALUES (" + usuariID + ", " + videoID + ", \"" + text + "\", \"" + publicat + "\");";
		return sql;
	}
	
}
