package S201_n3;

public class Seguiment implements Comparable<Seguiment> {
	private int id;
	private int usuariId;
	private int artistaId;

	
	public Seguiment(int id, int usuariId, int artistaId) {
		this.id = id;
		this.usuariId = usuariId;
		this.artistaId = artistaId;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Seguiment o) {
		int comparaCodi = ((Seguiment)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n3.seguiments (usuari_id, artista_id) " 
				+ "VALUES (" + usuariId + ", " + artistaId + ");";
		return sql;
	}
	
}
