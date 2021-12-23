package S201_n2;

import java.time.LocalDate;
import java.util.Calendar;

public class Like implements Comparable<Like> {
	private int id;
	private int clientID;
	private String data;
	private String tipus;
	private double preuTotal;
	private int botigaID;
	private int repartidor;
	private String lliurat;

	
	public Like(int id, int clientID, String data, String tipus, double preuTotal, int botigaID, int repartidor, String lliurat) {
		this.id = id;
		this.clientID = clientID;
		this.data = data;
		this.tipus = tipus;
		this.preuTotal = preuTotal;
		this.botigaID = botigaID;
		this.repartidor = repartidor;
		this.lliurat = lliurat;
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
		sql += "INSERT INTO S201_n1_ex2.comandes (client_id, data, tipus, preu_total,"
				+ " botiga_id, repartidor_id, lliurat_hora) " + "VALUES (" 
				+ clientID + ", \"" + data + "\", \"" + tipus + "\", " + preuTotal
				+ ", " + botigaID + ", ";
		if (tipus.equals("domicili")) {
			sql += repartidor + ", " + "\"" + lliurat + "\"";
		} else {
			sql += "NULL, NULL";
		}
		sql += ");";
		return sql;
	}
	
}
