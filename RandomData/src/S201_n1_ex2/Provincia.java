package S201_n1_ex2;

public class Provincia implements Comparable<Provincia> {
	private String provincia;
	private int codiProvincia;
	private String pais;

	
	public Provincia(String provincia, int codiProvincia) {
		this.provincia = provincia;
		this.codiProvincia = codiProvincia;
		this.pais = "Catalunya";
	}

	@Override
	public String toString() {
		return codiProvincia + " ("
				+ provincia + ") " + pais.toUpperCase();
	}

	public String getProvincia() {
		return provincia;
	}
	
	public int getCodiProvincia() {
		return codiProvincia;
	}

	public String getPais() {
		return pais;
	}

	@Override
	public int compareTo(Provincia o) {

		int comparaCodi = ((Provincia)o).getCodiProvincia();
		return this.codiProvincia - comparaCodi;
	}
	
}
