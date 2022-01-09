package S203_n2;

public class ComentLike implements Comparable<ComentLike> {
	private int id;
	private String tipus;
	private int usuariID;
	private int comentariID;
	private String moment;

	
	public ComentLike(int id, String tipus, int usuariID, int comentariID, String moment) {
		this.id = id;
		this.tipus = tipus;
		this.usuariID = usuariID;
		this.comentariID = comentariID;
		this.moment = moment;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(ComentLike o) {
		int comparaCodi = ((ComentLike)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		return "{ \"tipus\": \"" + tipus + "\", \"usuari_id\": " + usuariID + 
				", \"comentari_id\": " + comentariID + ", \"moment\": \"" + moment + "\"}";
	}
	
}
