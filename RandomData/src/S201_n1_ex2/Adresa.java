package S201_n1_ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adresa {
	private String carrer;
	private int numero;
	private String pis;
	private String porta;
	private int cp;
	private String codiPostal;
	private String municipi;
	private String comarca;
	private String provincia;
	private String pais;
	
	Random rand = new Random();
	
	List<Municipi> llistaMunicipis;
	
	public Adresa(String carrer, int cp, String municipi, String comarca, String provincia) {
		this.carrer=carrer;
		int r = (int)(Math.random()*(500-1+1)+1);
		this.numero = r;
		int ps = (int)(Math.random()*(8-1+1)+1);
		this.pis = Integer.toString(ps);
		this.cp = cp;
		this.municipi=municipi;
		this.comarca = comarca;
		this.provincia = provincia;
		this.pais = "Catalunya";
		
	}
	public Adresa(String carrer, String codiPostal, String municipi, String comarca, String provincia) {
		this.carrer=carrer;
		int r = (int)(Math.random()*(500-1+1)+1);
		this.numero = r;
		int ps = (int)(Math.random()*(8-1+1)+1);
		this.pis = Integer.toString(ps);
		this.codiPostal = codiPostal;
		this.municipi=municipi;
		this.comarca = comarca;
		this.provincia = provincia;
		this.pais = "Catalunya";
		
	}
	
	public Adresa(String carrer) {
		this.carrer=carrer;
		int r = (int)(Math.random()*(500-1+1)+1);
		this.numero = r;
		int ps = (int)(Math.random()*(8-1+1)+1);
		this.pis = Integer.toString(ps);
		Municipi poblacio = generaMunicipi();
		this.codiPostal = poblacio.getCodiPostal();
		this.municipi= poblacio.getMunicipi();
		this.comarca = poblacio.getComarca();
		this.provincia = poblacio.getProvincia();
		this.pais = "Catalunya";
		
	}
	
	private Municipi generaMunicipi() {
		llistaMunicipis = new ArrayList<>();
		llistaMunicipis = ParseMunicipi.pMunicipi();
		Municipi inventat = llistaMunicipis.get(rand.nextInt(llistaMunicipis.size()));
		return inventat;
	}

	@Override
	public String toString() {
		return "Adresa [carrer=" + carrer + ", numero=" + numero + ", pis=" + pis + ", porta=" + porta + ", codiPostal="
				+ codiPostal + ", cp=" + cp + ", municipi=" + municipi + ", comarca=" + comarca + ", provincia=" + provincia
				+ ", pais=" + pais + "]";
	}
	
}
