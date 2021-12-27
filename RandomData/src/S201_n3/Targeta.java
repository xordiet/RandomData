package S201_n3;

public class Targeta implements Comparable<Targeta> {
	private int id;
	private String numero;
	private int mesCad;
	private int anyCad;
	private int cvv;

	
	public Targeta(int id, String numero, int mesCad, int anyCad, int cvv) {
		this.id = id;
		this.numero = numero;
		this.mesCad = mesCad;
		this.anyCad = anyCad;
		this.cvv = cvv;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Targeta o) {
		int comparaCodi = ((Targeta)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "INSERT INTO S201_n3.credit_cards (numero, mes_cad, any_cad, cvv) " 
				+ "VALUES (" + numero + ", " + mesCad + ", " + anyCad + ", " + cvv + ");";
		return sql;
	}
	
}
