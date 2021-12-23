package S201_n1_ex2;

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
		
		String retorna = "";
		
		List<Municipi> llistaMunicipis = new ArrayList<>();
		llistaMunicipis = ParseMunicipi.pMunicipi();
		
		Collections.sort(llistaMunicipis);
		
		for(int i=0; i<llistaMunicipis.size(); i++) {
			String cadena = "";
			
			cadena +="INSERT INTO S201_n1_ex2.localitats (nom, provincia_id) VALUES (";
			
			Municipi municipi = llistaMunicipis.get(i);
			cadena+= "\""+municipi.getMunicipi()+"\", ";
			cadena+= municipi.getCodiProvincia();
					
			cadena +=");";

			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		
		
		
		return retorna;

	}
	
	public static String gProvincies() {
		
		String retorna = "";
		
		List<Provincia> llistaProvincies = new ArrayList<>();
		llistaProvincies = ParseProvincia.pProvincia();
		
		Collections.sort(llistaProvincies);
				
		for(int i=0; i<llistaProvincies.size(); i++) {
			String cadena = "";
			
			cadena +="INSERT INTO S201_n1_ex2.provincies (nom) VALUES (";
			
			Provincia provincia = llistaProvincies.get(i);
			cadena+= "\""+provincia.getProvincia()+"\"";
			//cadena+= "\""+provincia.getCodiProvincia()+"\"";
					
			cadena +=");";

			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		
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
