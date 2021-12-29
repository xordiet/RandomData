package S201_n3;

public class Paypal implements Comparable<Paypal> {
	private int id;
	private String usuariPP;

	
	public Paypal(int id, String usuariPP) {
		this.id = id;
		this.usuariPP = usuariPP;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return usuariPP;
	}

	@Override
	public int compareTo(Paypal o) {
		int comparaCodi = ((Paypal)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		return "INSERT INTO S201_n3.paypal (usuari_pp) " + "VALUES (\"" + usuariPP + "\");";
	}
	
}
