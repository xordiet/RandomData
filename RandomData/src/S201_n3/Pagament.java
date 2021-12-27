package S201_n3;

public class Pagament implements Comparable<Pagament> {
	private int id;
	private int subscirpcioID;
	private int targetaID;
	private int ppID;
	private String data;
	private double total;
	private String tipus;

	public Pagament(int id, int subscirpcioID, int targetaID, int ppID, String data, double total, String tipus) {
		this.id = id;
		this.subscirpcioID = subscirpcioID;
		this.targetaID = targetaID;
		this.ppID = ppID;
		this.data = data;
		this.total = total;
		this.tipus = tipus;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Pagament o) {
		int comparaCodi = ((Pagament)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		return "INSERT INTO S201_n3.pagaments (subscripcio_id, targeta_id, pp_id, "
				+ "data, total, tipus) VALUES (" + subscirpcioID + ", " + targetaID 
				+ ", " + ppID + ", \"" + data + "\", " + total + ", \"" + tipus + "\");";
	}
	
}
