package S203_n1_ex2;

import java.util.ArrayList;
import java.util.List;

public class Comanda implements Comparable<Comanda> {
	private int id;
	private int clientID;
	private String data;
	private String tipus;
	private ArrayList<Integer> pizzArray;
	private ArrayList<Integer> burgArray;
	private ArrayList<Integer> begArray;
	private double preuTotal;
	private int botigaID;
	private int repartidor;
	private String lliurat;

	
	public Comanda(int id, int clientID, String data, String tipus, double preuTotal, int botigaID, int repartidor, String lliurat) {
		this.id = id;
		this.clientID = clientID;
		this.data = data;
		this.tipus = tipus;
		this.preuTotal = preuTotal;
		this.botigaID = botigaID;
		this.repartidor = repartidor;
		this.lliurat = lliurat;
	}

	public Comanda(int id, int clientID, String data, String tipus, List<Integer> pizzArray, List<Integer> burgArray, List<Integer> begArray, double preuTotal, int botigaID, int repartidor, String lliurat) {
		this.id = id;
		this.clientID = clientID;
		this.data = data;
		this.tipus = tipus;
		this.pizzArray = (ArrayList<Integer>) pizzArray;
		this.burgArray = (ArrayList<Integer>) burgArray;
		this.begArray = (ArrayList<Integer>) begArray;
		this.preuTotal = preuTotal;
		this.botigaID = botigaID;
		this.repartidor = repartidor;
		this.lliurat = lliurat;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Comanda o) {
		int comparaCodi = ((Comanda)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String retorn = "{ \"_id\": " + id + ", \"client_id\": " + clientID + ", \"data_hora\": ISODate(\"" + data + "\"), \"botiga_gestora\": " + botigaID + ", \"tipus\": \""+ tipus + "\", ";
		if (tipus.equals("domicili")) {
			retorn +=  "\"repartidor\": " + repartidor + ", \"lliurada_moment\": ISODate(\"" + lliurat + "\"), ";
		} 
		retorn += "\"quantitat\": {\"pizzes\": " + pizzArray + ", \"hamburgueses\": " + burgArray + ", \"begudes\": " + begArray + "}, \"preu_total\": " + preuTotal + "}";
		return retorn;
	}
	
}
