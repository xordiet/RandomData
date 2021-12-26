package S201_n2;

public class Like implements Comparable<Like> {
	private int id;
	private String tipus;
	private int usuariID;
	private int videoID;
	private String moment;

	
	public Like(int id, String tipus, int usuariID, int videoID, String moment) {
		this.id = id;
		this.tipus = tipus;
		this.usuariID = usuariID;
		this.videoID = videoID;
		this.moment = moment;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Like o) {
		int comparaCodi = ((Like)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "";
		sql += "INSERT INTO S201_n2.likes (tipus, usuari_id, video_id, moment) "
				+ "VALUES (\"" + tipus + "\", " + usuariID + ", " + videoID 
				+ ", \"" + moment + "\");";
		return sql;
	}
	
}
