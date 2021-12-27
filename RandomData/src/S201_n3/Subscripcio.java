package S201_n3;

public class Subscripcio implements Comparable<Subscripcio> {
	private int id;
	private int usuariID;
	private String dataInici;
	private String dataRenovacio;
	private String pagament;

	
	public Subscripcio(int id, int usuariID, String dataInici, String dataRenovacio, String pagament) {
		this.id = id;
		this.usuariID = usuariID;
		this.dataInici = dataInici;
		this.dataRenovacio = dataRenovacio;
		this.pagament = pagament;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Subscripcio o) {
		int comparaCodi = ((Subscripcio)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n3.subscripcions (usuari_id, data_inici, data_renovacio, pagament) " 
				+ "VALUES (" + usuariID + ", \"" + dataInici + "\", \"" + dataRenovacio + "\", \"" + pagament + "\");";
		return sql;
	}
	
}
