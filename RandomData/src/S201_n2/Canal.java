package S201_n2;

public class Canal implements Comparable<Canal> {
	private int id;
	private String nom;
	private String descripcio;
	private int creador;
	private String dataCreacio;

	
	public Canal(int id, String nom, String descripcio, int creador, String dataCreacio) {
		this.id = id;
		this.nom = nom;
		this.descripcio = descripcio;
		this.creador = creador;
		this.dataCreacio = dataCreacio;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Canal o) {
		int comparaCodi = ((Canal)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n2.canals (nom, descripcio, creador, "
				+ "creacio) VALUES (\"" + nom + "\", \"" + descripcio + "\", " 
				+ creador + ", \"" + dataCreacio + "\");";
		return sql;
	}
	
}
