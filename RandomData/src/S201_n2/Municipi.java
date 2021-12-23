package S201_n2;

public class Municipi implements Comparable<Municipi> {
	private int id;
	private int idf;
	private String municipi;
	private String codiPostal;
	private int municipiID;
	private String comarca;
	private int cComarca;
	private String provincia;
	private int cProvincia;
	private String pais;

	public Municipi(int cp, String municipi, String comarca, String provincia) {
		this.idf = cp;
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
	
	public Municipi(int idf, String municipi, String comarca, int cComarca, String provincia, int cProvincia) {
		this.idf = idf;
		this.municipi=municipi;
		this.comarca = comarca;
		this.cComarca = cComarca;
		this.provincia = provincia;
		this.cProvincia = cProvincia;
		this.pais = "Catalunya";
	}

	public Municipi(int id, int idf, String municipi, String comarca, int cComarca, String provincia, int cProvincia) {
		this.id = id;
		this.idf = idf;
		this.municipi=municipi;
		this.comarca = comarca;
		this.cComarca = cComarca;
		this.provincia = provincia;
		this.cProvincia = cProvincia;
		this.pais = "Catalunya";
	}

	@Override
	public String toString() {
		return id + ", " + idf + ", " + municipi + " - " + comarca + " ("
				+ provincia + ") " + pais.toUpperCase();
	}

	public String getCodiPostal() {
		return codiPostal;
	}

	public int getId() {
		return id;
	}

	public int getIdf() {
		return idf;
	}

	public String getMunicipi() {
		return municipi;
	}

	public String getComarca() {
		return comarca;
	}
	
	public int getCodiComarca() {
		return cComarca;
	}

	public String getProvincia() {
		return provincia;
	}
	
	public int getCodiProvincia() {
		return cProvincia;
	}

	public String getPais() {
		return pais;
	}

	@Override
	public int compareTo(Municipi o) {
		//String comparaMuni = ((Municipi)o).getMunicipi();
		//return municipi.compareTo(comparaMuni);
		int comparaCodi = ((Municipi)o).getId();
		return this.id - comparaCodi;
	}
	
}
