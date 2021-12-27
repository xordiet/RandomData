package S201_n3;

public class PLDetails implements Comparable<PLDetails> {
	private int id;
	private int playListId;
	private int videoId;
	private String afegit;

	
	public PLDetails(int id, int playListId, int videoId, String afegit) {
		this.id = id;
		this.playListId = playListId;
		this.videoId = videoId;
		this.afegit = afegit;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(PLDetails o) {
		int comparaCodi = ((PLDetails)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n2.playlist_content (playlist_id, video_id, afegit) " 
				+ "VALUES (" + playListId + ", " + videoId + ", \"" + afegit + "\");";
		return sql;
	}
	
}
