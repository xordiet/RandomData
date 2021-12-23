package S201_n2;

import java.time.LocalDate;
import java.util.Calendar;

public class Comentari implements Comparable<Comentari> {
	private int id;
	private int comandaID;
	private int quantitat;
	private int producteID;

	
	public Comentari(int id, int comandaID, int quantitat, int producteID) {
		this.id = id;
		this.comandaID = comandaID;
		this.quantitat = quantitat;
		this.producteID = producteID;
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
		String sql = "";
		sql += "INSERT INTO S201_n1_ex2.comandes_detall (comanda_id, quantitat, "
				+ "producte_id) " + "VALUES (" + comandaID + ", " + quantitat
				+ ", " + producteID + ");";
		return sql;
	}
	
}
