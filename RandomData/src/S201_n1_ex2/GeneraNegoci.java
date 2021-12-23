package S201_n1_ex2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraNegoci {
		
	public static List<Botiga> gBotigues(int nombre) {
				
		List<String> llistaCarrers = new ArrayList<>();
		llistaCarrers = ParseAdresa.pCarrer();
				
		List<Municipi> llistaMunicipis = new ArrayList<>();
		llistaMunicipis = ParseMunicipi.pMunicipi();
		//les ordeno perquè l'id segueixi el mateix ordre que a la taula localitats
		Collections.sort(llistaMunicipis);
		//llistaMunicipis.forEach(m -> System.out.println(m.toString()));
		
		List<Botiga> botigues = new ArrayList<>();
		
		Random rand = new Random();
		
		for(int i=0; i<nombre; i++) {
			Botiga b;
						
			//Adreça Carrer
			String randomCarrer = llistaCarrers.get(rand.nextInt(llistaCarrers.size()));
			//Adreça Num
			int randomNum=(int)(Math.random()*(1-500+1)+500);
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
			String randomAdresa = randomCarrer+", "+randomNum;
			
			b = new Botiga(i, randomCarrer, randomAdresa, cp, municipiID, prov);
			botigues.add(b);

		}
		
		return botigues;

	}	
	
	public static List<Categoria> gCategories() {
		
		List<String> catPizzes = constants.CATEG_PIZZES;
		
		List<Categoria> categories = new ArrayList<>();
				
		for(int i=0; i<catPizzes.size(); i++) {
			Categoria c;
			
			String categoria = catPizzes.get(i);
			
			c = new Categoria(i, categoria);
			categories.add(c);

		}
		
		return categories;

	}	
	
	public static List<Producte> gProductes() {
		
		int comptador = 1;

		List<Categoria> catPizzes = gCategories();
		List<String> nomsPizzes = constants.NOMS_PIZZES;
		List<String> nomsBurgers = constants.NOMS_BURGERS;
		List<String> nomsBegudes = constants.NOMS_BEGUDES;
		
		List<Producte> productes = new ArrayList<>();
		
		Random rand = new Random();
				
		for(int i=0; i<nomsPizzes.size(); i++) {
			Producte p;
			String nom = nomsPizzes.get(i);
			String tipus = "pizza";
			int categoriaID = rand.nextInt(catPizzes.size())+1;
			String descripcio = "Mozzarella di bufala, tartufata, scamorza, mix de bolets amb all i julivert";
			String imatge = "imatge de la pizza";
			double preu = 10 + rand.nextDouble() * (15 - 10);
			double round = Math.round(preu * 100.0)/100.0;
			
			p = new Producte(comptador, nom, tipus, categoriaID, descripcio, imatge, round);
			productes.add(p);
			comptador++;

		}
		
		for(int i=0; i<nomsBurgers.size(); i++) {
			Producte p;
			String nom = nomsBurgers.get(i);
			String tipus = "hamburguesa";
			int categoriaID = 0;
			String descripcio = "160 g de carn de vedella, bacó de porc seleccionat, formatge del Delta, ou de corral, enciam meravella i romana, tomàquet pera Eco, melmelada de ceba, cogombret";
			String imatge = "imatge de l'hamburguesa";
			double preu = 10 + rand.nextDouble() * (12 - 8);
			double round = Math.round(preu * 100.0)/100.0;
			
			p = new Producte(comptador, nom, tipus, categoriaID, descripcio, imatge, round);
			productes.add(p);
			comptador++;

		}
		
		for(int i=0; i<nomsBegudes.size(); i++) {
			Producte p;
			String nom = nomsBegudes.get(i);
			String tipus = "beguda";
			int categoriaID = 0;
			String descripcio = "Refrescant i saborosa, aquesta cervesa és ideal per acompanyar les teves pizzes o hamburgueses.";
			String imatge = "imatge de la beguda";
			double preu = 10 + rand.nextDouble() * (6 - 9);
			double round = Math.round(preu * 100.0)/100.0;
			
			p = new Producte(comptador, nom, tipus, categoriaID, descripcio, imatge, round);
			productes.add(p);
			comptador++;

		}
		
		return productes;

	}	
	
	public static List<Comanda> gComanda(int nombre, int nombreClients, int nombreBotigues, List<Treballador> tRepartidors){
		
		int comptador = 1;
		
		List<Comanda> comandes = new ArrayList<>();
		
		Random rand = new Random();
		
		//saber el nombre de repartidor que hi ha
		//tRepartidors.forEach(rp -> System.out.println(rp.getId()+": "+rp.getNif()));
		//int r = rand.nextInt(tRepartidors.size());
		//System.out.print("Dels "+tRepartidors.size()+" es tria el núm... ");
		//Treballador repa = tRepartidors.get(r);
		//System.out.println(r+"("+repa.getId()+") -> "+repa.getNif());
		
		for(int i=0; i<nombre; i++) {
			Comanda c;
			
			int id = comptador;
			int clientID = (int)(Math.random()*(nombreClients-1)+1);
			
			String data = "";
			LocalDate start = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate end = LocalDate.now();
			LocalDate dataRand = betweenD(start, end);
			data += dataRand;
			LocalTime obre = LocalTime.of(8, 30);
			LocalTime tanca = LocalTime.of(18, 30);
			LocalTime randomTime = betweenT(obre, tanca);
			data += " "+randomTime;
			//LocalDate dtComanda = LocalDate.parse(data);
			//System.out.print(data);
			
			String tipus = "";
			int randInt = (int)(Math.random()*(8)+1);
			if (randInt == 1) {
				tipus = "recollir";
			} else {
				tipus = "domicili";
			}
			
			double preu = 10 + rand.nextDouble() * (100 - 10);
			double preuTotal = Math.round(preu * 100.0)/100.0;
			
			int botigaID = (int)(Math.random()*(nombreBotigues-1)+1);
			//int r = (int)Math.random()*(tRepartidors.size())+1;
			int r = rand.nextInt(tRepartidors.size());
			//int r = rand.nextInt(tRepartidors.size());
			Treballador rep = tRepartidors.get(r);
			//System.out.println(i+": "+rep.getId());
			int repartidorID = rep.getId();
			
			String datall = "";
			LocalDate start2 = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate end2 = LocalDate.now();
			LocalDate dataRand2 = betweenD(start, end);
			datall += dataRand2;
			LocalTime obre2 = LocalTime.of(8, 30);
			LocalTime tanca2 = LocalTime.of(18, 30);
			LocalTime randomTime2 = betweenT(obre, tanca);
			datall += " "+randomTime2;
			//LocalDate dtLliurament = LocalDate.parse(datall);
						
			c = new Comanda(comptador, clientID, data, tipus, preuTotal, botigaID, repartidorID, datall);
			comandes.add(c);
			comptador++;
		}
		
		return comandes;
	}
	
	public static List<DetallComanda> gDComandes(int nombreComandes, int numProductes){
		int comptador = 1;
		List<DetallComanda> dComandes = new ArrayList<>();
		Random rand = new Random();
		
		for(int i=1; i<=nombreComandes; i++) {
			int productes = (int)(Math.random()*(8)+3);
			for (int j=1; j<=productes; j++) {
				DetallComanda d;
				int id = comptador;
				int comandaID = i;
				int quantitat = (int)(Math.random()*(5)+1);
				int producteID = (int)(Math.random()*(numProductes)+1);
				
				d = new DetallComanda(comptador, comandaID, quantitat, producteID);
				dComandes.add(d);
				
				comptador++;
				
			}
			
		}

		return dComandes;
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
