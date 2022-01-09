package S203_n2;

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
		return "{ \"_id\": " + id + ", \"usuari_id\": " + usuariID + ", \"video_id\": " + videoID 
				+ ", \"text\": \"" + text + "\", \"moment\": \"" + publicat +"\" }";

	}
	
}
