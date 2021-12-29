package S201_n3;

public class PLDetails implements Comparable<PLDetails> {
	private int id;
	private int llistaID;
	private int cancoId;
	private int afegitPer;
	private String DataAfegit;

	
	public PLDetails(int id, int llistaID, int cancoId, int afegitPer, String DataAfegit) {
		this.id = id;
		this.llistaID = llistaID;
		this.cancoId = cancoId;
		this.afegitPer = afegitPer;
		this.DataAfegit = DataAfegit;
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
		String sql = "INSERT INTO S201_n3.playlist_detalls (llista_id, canco_id, afegit_per, data_addicio) " 
				+ "VALUES (" + llistaID + ", " + cancoId + ", " + afegitPer + ", \"" + DataAfegit + "\");";
		return sql;
	}
	
}
