package S203_n2;

public class Subscripcio implements Comparable<Subscripcio> {
	private int id;
	private int usuari;
	private int canal;

	
	public Subscripcio(int id, int usuariID, int canalID) {
		this.id = id;
		this.usuari = usuariID;
		this.canal = canalID;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Subscripcio o) {
		int comparaCodi = ((Subscripcio)o).getId();
		return this.id - comparaCodi;
	}
	
	@Override
	public String toString() {
		return "{ \"usuari_id\": " + usuari + ", \"canal_id\": " + canal + "}";

	}
	
}
