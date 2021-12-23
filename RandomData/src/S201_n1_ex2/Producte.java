package S201_n1_ex2;

public class Producte implements Comparable<Producte> {
	private int id;
	private String nom;
	private String tipus;
	private int categoriaID;
	private String descripcio;
	private String imatge;
	private double preu;

	
	public Producte(int id, String nom, String tipus, int categoriaID, String descripcio, String imatge, double preu) {
		this.id = id;
		this.nom = nom;
		this.tipus = tipus;
		this.categoriaID = categoriaID;
		this.descripcio = descripcio;
		this.imatge = imatge;
		this.preu = preu;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public int compareTo(Producte o) {
		int comparaCodi = ((Producte)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		String sql = "";
		sql += "INSERT INTO S201_n1_ex2.productes (nom, tipus, categoria_id, descripcio,"
				+ " imatge, preu) " + "VALUES (\"" + nom + "\", \"" + tipus
				+ "\", ";
		if (categoriaID == 0) {
			sql += "NULL";
		} else {
			sql += categoriaID;
		}
		sql += ", \"" + descripcio + "\", \"" + imatge + "\", " + preu + ");";;
		return sql;
	}
	
}
