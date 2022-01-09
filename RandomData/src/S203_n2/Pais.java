package S203_n2;

public class Pais implements Comparable<Pais> {
	private int id;
	private String isoPais;
	private String nomPais;
	private String areaEconomica;
	private int idAreaForeland;
	private String nomAreaForeland;
	private int idAreaSubForeland;
	private String nomAreaSubForeland;
	
	public Pais(int id) {
		this.id = id;
	};

	public Pais(int id, String nomPais) {
		this.id = id;
		this.nomPais = nomPais;
	};

	public Pais(int id, String isoPais, String nomPais) {
		this.id = id;
		this.isoPais = isoPais;
		this.nomPais = nomPais;
	};

	public Pais(int id, String isoPais, String nomPais, String areaEconomica, 
			int idAreaForeland, String nomAreaForeland, int idAreaSubForeland, String nomAreaSubForeland) {
		this.id = id;
		this.isoPais = isoPais;
		this.nomPais = nomPais;
		this.areaEconomica = areaEconomica;
		this.idAreaForeland = idAreaForeland;
		this.nomAreaForeland = nomAreaForeland;
		this.idAreaSubForeland = idAreaSubForeland;
		this.nomAreaSubForeland = nomAreaSubForeland;
	}


	public int getId() {
		return id;
	}
	public String getISO() {
		return isoPais;
	}
	public String getNomPais() {
		return nomPais;
	}


	@Override
	public int compareTo(Pais o) {
		//String comparaMuni = ((Municipi)o).getMunicipi();
		//return municipi.compareTo(comparaMuni);
		int comparaCodi = ((Pais)o).getId();
		return this.id - comparaCodi;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", isoPais=" + isoPais + ", nomPais=" + nomPais + "]";
	}
	
}
