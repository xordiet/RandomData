package S203_n1_ex2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraAltres {
	
	public static String gLocalitats() {
		
		List<Municipi> llistaMunicipis = new ArrayList<>();
		llistaMunicipis = ParseMunicipi.pMunicipi();
		
		Collections.sort(llistaMunicipis);

		String retorna = "db.localitats.insertMany(";
		retorna += llistaMunicipis;
		retorna += ")";
		
		
		return retorna;

	}
	
	public static String gProvincies() {
		
		List<Provincia> llistaProvincies = new ArrayList<>();
		llistaProvincies = ParseProvincia.pProvincia();
		
		Collections.sort(llistaProvincies);
		
		String retorna = "db.provincies.insertMany(";
		
		retorna += llistaProvincies;
			
		retorna += ")";
		
		/*
		for(int i=0; i<llistaProvincies.size(); i++) {

			Provincia provincia = llistaProvincies.get(i);

			String cadena = "db.provincias.insertOne({\"id\":";
			cadena += provincia.getCodiProvincia();

			cadena += ",\"nom\":\"";
			cadena+= provincia.getProvincia();
			
			cadena += "\"})";

			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		*/
		
		return retorna;

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
