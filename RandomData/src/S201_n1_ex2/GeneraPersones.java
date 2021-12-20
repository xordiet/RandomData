package S201_n1_ex2;

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
		
		
		for(int i=0; i<nombre; i++) {
			String cadena = "";
			
			cadena +="INSERT INTO S201_n1_ex1.clients (nom, adresa_postal, telefon, email, recomenat_per, data_registre) VALUES (";
			
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));
			cadena+= "\""+randomNom+" ";

			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomElement2 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			cadena+= randomElement1+" "+randomElement2+"\",";
			
			String randomElement = llistaCarrers.get(rand.nextInt(llistaCarrers.size()));
			cadena+= "\""+randomElement+", ";
			
			Municipi randomMunicipi = llistaMunicipis.get(rand.nextInt(llistaMunicipis.size()));
			cadena+= randomMunicipi+"\",";
			
			randomInt=(int)(Math.random()*(699999999-600000000+1)+600000000);
			cadena+= "\""+randomInt+"\",";
			
			cadena+= "\""+randomNom+"."+randomElement1+"@gmail.com\",";
			
			int randInt = (int)(Math.random()*(10-1+1)+1);
			if (randInt == 1) {
				int recomanat = (int)(Math.random()*(i-1+1)+1);
				cadena+=recomanat;
			} else {
				cadena+="NULL";
			}
			
			String creacio = "";
			LocalDate start = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate end = LocalDate.now();
			LocalDate dataRand = betweenD(start, end);
			creacio += dataRand;
			LocalTime obre = LocalTime.of(8, 30);
			LocalTime tanca = LocalTime.of(18, 30);
			LocalTime randomTime = betweenT(obre, tanca);
			creacio += " "+randomTime;
			cadena +=  ", '"+creacio+"'";
					
			cadena +=");";

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
		
		
		for(int i=0; i<nombre; i++) {
			String cadena = "";
			
			cadena +="INSERT INTO S201_n1_ex1.treballadors (nom, alta) VALUES (";
			
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));
			cadena+= "\""+randomNom+" ";

			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomElement2 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			cadena+= randomElement1+" "+randomElement2+"\",";
			
			String creacio = "";
			LocalDate start = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate end = LocalDate.now();
			LocalDate dataRand = betweenD(start, end);
			creacio += dataRand;
			LocalTime obre = LocalTime.of(8, 30);
			LocalTime tanca = LocalTime.of(18, 30);
			LocalTime randomTime = betweenT(obre, tanca);
			creacio += " "+randomTime;
			cadena +=  " '"+creacio+"'";
					
			cadena +=");";

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
		
		
		for(int i=0; i<nombre; i++) {
			String cadena = "";
			
			cadena +="INSERT INTO S201_n1_ex1.proveidors (nom, adresa_carrer, adresa_num, adresa_pis, adresa_porta, adresa_ciutat, adresa_cp, adresa_pais) VALUES (";
			
			//Nom
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));
			cadena+= "\""+randomNom+" ";
			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomElement2 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String forma = denominacio.get(rand.nextInt(denominacio.size()));
			cadena+= randomElement1+" "+randomElement2+forma+"\",";
			
			//Adresa Carrer
			String randomElement = llistaCarrers.get(rand.nextInt(llistaCarrers.size()));
			cadena+= "\""+randomElement+"\", ";
			
			//Adresa Num
			randomInt=(int)(Math.random()*(1-1000+1)+1000);
			cadena+= ""+randomInt+", ";
			
			//Adresa pis
			String pis = pisos.get(rand.nextInt(pisos.size()));
			cadena+= "\""+pis+"\", ";
			
			//Adresa porta
			String porta = portes.get(rand.nextInt(portes.size()));
			cadena+= "\""+porta+"\", ";
			
			//Municipi
			Municipi randomMunicipi = llistaMunicipis.get(rand.nextInt(llistaMunicipis.size()));
			
			//Adresa ciutat
			String ciutat = randomMunicipi.getMunicipi();
			cadena+= "\""+ciutat+"\",";
			
			//Adresa CP
			String cp = randomMunicipi.getCodiPostal();
			cadena+= "\""+cp+"\",";

			//Adresa país
			String pais = randomMunicipi.getPais();
			cadena+= "\""+pais+"\"";

			cadena +=");";

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
		
		
		for(int i=0; i<nombre; i++) {
			String cadena = "";
			
			cadena +="INSERT INTO S201_n1_ex1.marques (marca, proveidor_id) VALUES (";
			
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));
			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			cadena+= "\""+randomNom+" "+randomElement1+"\", ";
			
			randomInt=(int)(Math.random()*(1-numPr+1)+numPr);
			cadena+= randomInt;
					
			cadena +=");";

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
