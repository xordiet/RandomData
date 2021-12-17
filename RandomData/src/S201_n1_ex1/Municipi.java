package S201_n1_ex1;

public class Municipi {
	private String codiPostal;
	private int cp;
	private String municipi;
	private String comarca;
	private String provincia;
	private String pais;

	public Municipi(int cp, String municipi, String comarca, String provincia) {
		this.cp = cp;
		this.municipi=municipi;
		this.comarca = comarca;
		this.provincia = provincia;
		this.pais = "Catalunya";
	}
	
	public Municipi(String codiPostal, String municipi, String comarca, String provincia) {
		this.codiPostal = codiPostal;
		this.municipi=municipi;
		this.comarca = comarca;
		this.provincia = provincia;
		this.pais = "Catalunya";
	}

	@Override
	public String toString() {
		return codiPostal + ", " + municipi + " - " + comarca + " ("
				+ provincia + ") " + pais.toUpperCase();
	}

	public String getCodiPostal() {
		return codiPostal;
	}

	public int getCp() {
		return cp;
	}

	public String getMunicipi() {
		return municipi;
	}

	public String getComarca() {
		return comarca;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getPais() {
		return pais;
	}
	
}
