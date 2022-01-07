package S203_n1_ex2;

public class Provincia implements Comparable<Provincia> {
	private String provincia;
	private int codiProvincia;

	
	public Provincia(String provincia, int codiProvincia) {
		this.provincia = provincia;
		this.codiProvincia = codiProvincia;
	}

	@Override
	public String toString() {
		return "{ \"_id\": " + codiProvincia + ", \"nom\": \"" + provincia + "\"}";
	}

	public String getProvincia() {
		return provincia;
	}
	
	public int getCodiProvincia() {
		return codiProvincia;
	}

	@Override
	public int compareTo(Provincia o) {

		int comparaCodi = ((Provincia)o).getCodiProvincia();
		return this.codiProvincia - comparaCodi;
	}
	
}
