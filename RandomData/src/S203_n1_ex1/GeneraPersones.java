package S203_n1_ex1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraPersones {
	
	public static String gClients(int nombre) {
		
		String retorna = "";
		
		List<String> llistaNoms = new ArrayList<>();
		llistaNoms = ParseNoms.pNoms();
		
		List<String> llistaCognoms = new ArrayList<>();
		llistaCognoms = ParseCognoms.pCognoms();
		
		List<String> llistaCarrers = new ArrayList<>();
		llistaCarrers = ParseAdresa.pCarrer();
		
		List<Municipi> llistaMunicipis = new ArrayList<>();
		llistaMunicipis = ParseMunicipi.pMunicipi();
		
		Random rand = new Random();
		int randomInt;
		
		for(int i=1; i<=nombre; i++) {
			String cadena = "";
			
			cadena +="db.clients.insertOne({\"_id\": " + i + ",\"nom\": \"";
			
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));
			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomElement2 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			cadena += randomNom+" "+randomElement1+" i "+randomElement2;
			
			cadena += "\",\"adresa_postal\": \"";
			
			String randomCarrer = llistaCarrers.get(rand.nextInt(llistaCarrers.size()));
			cadena+= randomCarrer+", ";
			int randomNum=(int)(Math.random()*(300));
			cadena+= randomNum+", ";
			Municipi randomMunicipi = llistaMunicipis.get(rand.nextInt(llistaMunicipis.size()));
			cadena+= randomMunicipi;

			cadena += "\",\"telefon\": ";
			randomInt=(int)(Math.random()*(699999999-600000000+1)+600000000);
			cadena+= randomInt;
			
			cadena += ", \"email\": \"";
			cadena+= randomNom+"."+randomElement1+"@gmail.com\"";
			
			int randInt = (int)(Math.random()*(10-1+1)+1);
			if (randInt == 1) {
				cadena += ", \"recomenat_per\": ";
				int recomanat = (int)(Math.random()*(i-1+1)+1);
				cadena+=recomanat;
			} 
			
			cadena += ", \"data_registre\": ISODate(";
			
			String creacio = "\"";
			LocalDate start = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate end = LocalDate.now();
			LocalDate dataRand = betweenD(start, end);
			creacio += dataRand;
			LocalTime obre = LocalTime.of(8, 30);
			LocalTime tanca = LocalTime.of(18, 30);
			LocalTime randomTime = betweenT(obre, tanca);
			creacio += " "+randomTime;
			cadena +=  creacio+"\")";

			
			cadena += "})";

			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		
		return retorna;

	}
	
	public static String gTreballadors(int nombre) {
		
		String retorna = "";
		
		List<String> llistaNoms = new ArrayList<>();
		llistaNoms = ParseNoms.pNoms();
		
		List<String> llistaCognoms = new ArrayList<>();
		llistaCognoms = ParseCognoms.pCognoms();
		
		
		Random rand = new Random();
		int randomInt;
		
		
		for(int i=1; i<=nombre; i++) {
			String cadena = "";
			
			cadena +="db.treballadors.insertOne({\"_id\": " + i + ",\"nom\": \"";
			
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));
			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomElement2 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			cadena+= randomNom+" "+randomElement1+" i "+randomElement2;

			cadena += "\", \"alta\": ISODate(";

			String creacio = "\"";
			LocalDate start = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate end = LocalDate.now();
			LocalDate dataRand = betweenD(start, end);
			creacio += dataRand;
			LocalTime obre = LocalTime.of(8, 30);
			LocalTime tanca = LocalTime.of(18, 30);
			LocalTime randomTime = betweenT(obre, tanca);
			creacio += " "+randomTime;
			cadena +=  creacio+"\")";

			cadena += "})";

			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		
		return retorna;

	}
	
	public static String gProveidors(int nombre) {
		
		String retorna = "";
		
		List<String> llistaNoms = new ArrayList<>();
		llistaNoms = ParseNoms.pNoms();
		
		List<String> llistaCognoms = new ArrayList<>();
		llistaCognoms = ParseCognoms.pCognoms();

		List<String> denominacio = constants.DENOMINACIO;
		
		List<String> llistaCarrers = new ArrayList<>();
		llistaCarrers = ParseAdresa.pCarrer();
		
		List<String> pisos = constants.PISOS;
		List<String> portes = constants.PORTES;

		List<Municipi> llistaMunicipis = new ArrayList<>();
		llistaMunicipis = ParseMunicipi.pMunicipi();
		
		Random rand = new Random();
		int randomInt;
		
		
		for(int i=1; i<=nombre; i++) {
			String cadena = "";
			
			cadena +="db.proveidors.insertOne({\"_id\": " + i + ", \"nom\": \"";
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));
			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String forma = denominacio.get(rand.nextInt(denominacio.size()));
			cadena+= randomNom+" "+randomElement1+" "+forma;			
			
			cadena += "\", \"adresa\": {\"carrer\": \"";
			String randomElement = llistaCarrers.get(rand.nextInt(llistaCarrers.size()));
			cadena+= randomElement;
			
			cadena += "\",\"numero\": ";
			randomInt=(int)(Math.random()*(1-1000+1)+1000);
			cadena+= randomInt;
			
			cadena += ",\"pis\": \"";
			String pis = pisos.get(rand.nextInt(pisos.size()));
			cadena+= pis;
			
			cadena += "\",\"porta\": \"";
			String porta = portes.get(rand.nextInt(portes.size()));
			cadena+= porta;

			Municipi randomMunicipi = llistaMunicipis.get(rand.nextInt(llistaMunicipis.size()));

			cadena += "\",\"ciutat\": \"";
			String ciutat = randomMunicipi.getMunicipi();
			cadena+= ciutat;
			
			cadena += "\",\"cp\": ";
			String cp = randomMunicipi.getCodiPostal();
			cadena+= cp;

			cadena += ",\"pais\":\"";
			String pais = randomMunicipi.getPais();
			cadena+= pais;
			
			cadena += "\"}, \"telefon\": ";
			int randomTel=(int)(Math.random()*(699999999-600000000+1)+600000000);
			cadena+= randomTel;
			
			cadena += ", \"fax\": ";
			int randomFax=(int)(Math.random()*(999999999-900000000+1)+900000000);
			cadena+= randomFax;
			
			cadena += ", \"nif\": \"";
			int randomNIFn = (int)(Math.random()*(99999999));
			CalculaDni lletra = new CalculaDni(randomNIFn);
			String randomNIFl = lletra.getLetra();
			String randomNIF = randomNIFn+randomNIFl;
			cadena += randomNIF;

			
			cadena += "\"})";

			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		
		return retorna;

	}
	
	public static String gMarques(int nombre, int numPr) {
		
		String retorna = "";
		
		List<String> llistaNoms = new ArrayList<>();
		llistaNoms = ParseNoms.pNoms();
		
		List<String> llistaCognoms = new ArrayList<>();
		llistaCognoms = ParseCognoms.pCognoms();
		
		
		Random rand = new Random();
		int randomInt;
		
		
		for(int i=1; i<=nombre; i++) {
			String cadena = "";
			
			cadena +="db.marques.insertOne({\"_id\": " + i + ", \"marca\": \"";
			
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));
			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			cadena+= randomNom+" "+randomElement1;
			
			cadena += "\",\"proveidor_id\": ";
			randomInt=(int)(Math.random()*(1-numPr+1)+numPr);
			cadena+= randomInt;
					
			cadena += "})";

			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		
		return retorna;

	}
	
	/*
	 * Genera una data random
	 * copiat de https://www.baeldung.com/java-random-dates
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
