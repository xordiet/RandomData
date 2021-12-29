package S201_n3;

public class Favorit implements Comparable<Favorit> {
	private int id;
	private int usuariID;
	private int albumID;
	private int cancoID;
	private String tipus;

	public Favorit(int id, int usuariID, int albumID, int cancoID, String tipus) {
		this.id = id;
		this.usuariID = usuariID;
		this.albumID = albumID;
		this.cancoID = cancoID;
		this.tipus = tipus;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Favorit o) {
		int comparaCodi = ((Favorit)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "";
		sql += "INSERT INTO S201_n3.favorits (usuari_id, album_id, canco_id, tipus) "
				+ "VALUES (" + usuariID + ", " + albumID + ", " + cancoID + ", \"" + tipus + "\");";
		return sql;
	}
	
}
