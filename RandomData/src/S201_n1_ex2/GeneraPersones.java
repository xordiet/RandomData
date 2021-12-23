package S201_n1_ex2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraPersones {
		
	public static List<Client> gClients(int nombre) {
		
		List<String> llistaNoms = new ArrayList<>();
		llistaNoms = ParseNoms.pNoms();
		
		List<String> llistaCognoms = new ArrayList<>();
		llistaCognoms = ParseCognoms.pCognoms();
		
		List<String> llistaCarrers = new ArrayList<>();
		llistaCarrers = ParseAdresa.pCarrer();
		
		List<String> pisos = constants.PISOS;
		List<String> portes = constants.PORTES;
		
		List<Municipi> llistaMunicipis = new ArrayList<>();
		llistaMunicipis = ParseMunicipi.pMunicipi();
		//les ordeno perquè l'id segueixi el mateix ordre que a la taula localitats
		Collections.sort(llistaMunicipis);
		//llistaMunicipis.forEach(m -> System.out.println(m.toString()));
		
		List<Client> clients = new ArrayList<>();
		
		Random rand = new Random();
		
		for(int i=0; i<nombre; i++) {
			Client c;
			
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));

			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomElement2 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomCognoms = randomElement1+" "+randomElement2;
			
			//Adreça Carrer
			String randomCarrer = llistaCarrers.get(rand.nextInt(llistaCarrers.size()));
			//Adreça Num
			int randomNum=(int)(Math.random()*(1-500+1)+500);
			//Adreça pis
			String randomPis = pisos.get(rand.nextInt(pisos.size()));
			//Adreça porta
			String randomPorta = portes.get(rand.nextInt(portes.size()));			
			//Municipi
			Municipi randomMunicipi = llistaMunicipis.get(rand.nextInt(llistaMunicipis.size()));
			//Adresa municipi id
			String municipi = randomMunicipi.getMunicipi();
			int municipiID = randomMunicipi.getId();
			//Adreça Provincia (codi)
			int prov = randomMunicipi.getCodiProvincia();
			//Adreça Codi Postal
			int randomCP=(int)(Math.random()*(999-1)+1);
			String cp = (String)""+prov+randomCP;
			String randomAdresa = randomCarrer+", "+randomNum+" "+randomPis+" "+randomPorta;
			
			int randomTel=(int)(Math.random()*(699999999-600000000+1)+600000000);
			
			c = new Client(i, randomNom, randomCognoms, randomAdresa, cp, municipiID, prov, randomTel);
			clients.add(c);

		}
		
		return clients;

	}
	
	public static List<Treballador> gTreballadors(int nombre, int botigues) {
		
		List<String> llistaNoms = new ArrayList<>();
		llistaNoms = ParseNoms.pNoms();
		
		List<String> llistaCognoms = new ArrayList<>();
		llistaCognoms = ParseCognoms.pCognoms();
		
		List<String> categories = constants.CATEG_TREBALLADORS;
				
		List<Treballador> treballadors = new ArrayList<>();
		
		Random rand = new Random();
		
		for(int i=0; i<nombre; i++) {
			String randomNom = llistaNoms.get(rand.nextInt(llistaNoms.size()));

			String randomElement1 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomElement2 = llistaCognoms.get(rand.nextInt(llistaCognoms.size()));
			String randomCognoms = randomElement1+" "+randomElement2;
			
			int randomNIFn = (int)(Math.random()*(99999999));
			CalculaDni lletra = new CalculaDni(randomNIFn);
			String randomNIFl = lletra.getLetra();
			String randomNIF = randomNIFn+randomNIFl;
			
			int randomTel=(int)(Math.random()*(699999999-600000000+1)+600000000);
			
			String randomCategoria = categories.get(rand.nextInt(categories.size()));
			
			int botigaID = (int)(Math.random()*(botigues)+1);
			
			Treballador t = new Treballador(i, randomNom, randomCognoms, randomNIF, randomTel, randomCategoria, botigaID);
			treballadors.add(t);

		}
		
		return treballadors;


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
