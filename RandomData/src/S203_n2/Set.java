package S203_n2;

public class Set implements Comparable<Set> {
	private int id;
	private int videoId;
	private int etiquetaId;

	
	public Set(int id, int videoId, int etiquetaId) {
		this.id = id;
		this.videoId = videoId;
		this.etiquetaId = etiquetaId;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Set o) {
		int comparaCodi = ((Set)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n2.set_etiquetes (video_id, etiqueta_id) " 
				+ "VALUES (" + videoId + ", " + etiquetaId + ");";
		return sql;
	}
	
}
