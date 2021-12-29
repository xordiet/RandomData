package S201_n3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraAltres {
	
	public static List<Pais> gPaisos() {
		
		List<Pais> llistaPaisos = new ArrayList<>();
		llistaPaisos = ParsePaisos.pPais();
				
		Collections.sort(llistaPaisos);
		
		return llistaPaisos;

	}
	
	public static List<Targeta> gTargetes(int numTarges) {
		List<Targeta> targetes = new ArrayList<>();
		Random rand = new Random();
		
		for(int i=1; i<=numTarges; i++) {
			int numero = rand.nextInt(100000000);
			String zNumero = String.format("%08d", numero);
			int dc = rand.nextInt(10000);
			String zdc = String.format("%04d", dc);
			String iniciTg = constants.TARGETES.get(rand.nextInt(constants.TARGETES.size())); 
			String tarja = iniciTg+zNumero+zdc;
			int mesCad = rand.nextInt(12)+1;
			int anyCad = rand.nextInt(30-22)+22;
			int cvv = rand.nextInt(1000);
					
			Targeta t = new Targeta(i, tarja, mesCad, anyCad, cvv);
			targetes.add(t);
			
		}
		
		return targetes;
	}
	
	public static List<Paypal> gPayPal(int numPayPals){
		List<Paypal> paypals = new ArrayList<>();
		Random rand = new Random();
		
		for(int i=1; i<=numPayPals; i++) {

			String usuari = "";
			int rdmExt = (int)(Math.random()*(6)+6);
			for (int j=0; j<rdmExt; j++) {
				char caracter = constants.LLETRES.charAt(rand.nextInt(constants.LLETRES.length()));
				usuari += caracter;
			}
			
			Paypal pp = new Paypal(i, usuari);
			paypals.add(pp);

		}
		
		return paypals;
	}
	
	
	/*
	 * Genera una data random
	 */
	public static LocalDate betweenD(LocalDate startInclusive, LocalDate endExclusive) {
	    long startEpochDay = startInclusive.toEpochDay();
	    long endEpochDay = endExclusive.toEpochDay();
	    long randomDay = ThreadLocalRandom
	      .current()
	      .nextLong(startEpochDay, endEpochDay);

	    return LocalDate.ofEpochDay(randomDay);
	}
	public static LocalTime betweenT(LocalTime startTime, LocalTime endTime) {
	    int startSeconds = startTime.toSecondOfDay();
	    int endSeconds = endTime.toSecondOfDay();
	    int randomTime = ThreadLocalRandom
	      .current()
	      .nextInt(startSeconds, endSeconds);

	    return LocalTime.ofSecondOfDay(randomTime);
	}

}
