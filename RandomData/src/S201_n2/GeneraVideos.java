package S201_n2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraVideos {
			
	
	public static List<Video> gVideos(int nombreVideos, int nombreUsuaris) {
				
		List<Video> videos = new ArrayList<>();
		
		Random rand = new Random();
				
		for(int i=0; i<nombreVideos; i++) {			
			int usuariID = rand.nextInt(nombreUsuaris)+1;
			List<String> est = constants.ESTATS;
			String estat = est.get(rand.nextInt(est.size()));
			String titol = "Títol del video";
			String descripcio = "Aquest vídeo és una passada";
			int grandaria = rand.nextInt(10000);
			String nomArxiu = "";
			int rdmExt = rand.nextInt(6)+6;
			for (int j=0; j<rdmExt; j++) {
				char caracter = constants.LLETRES.charAt(rand.nextInt(constants.LLETRES.length()));
				nomArxiu += caracter;
			}
			nomArxiu += ".mp4";
			String durada = "";
			LocalTime obre = LocalTime.of(0, 0);
			LocalTime tanca = LocalTime.of(3, 59);
			LocalTime randomTime = betweenT(obre, tanca);
			durada += randomTime;
			String thumbnail = "Imatge en miniatura del vídeo";
			int reproduccions = rand.nextInt(500);
			int likes = rand.nextInt(300);
			int dislikes = rand.nextInt(100);
			String publicat = "";
			LocalDate pStart = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate pEnd = LocalDate.now();
			LocalDate dataRand = betweenD(pStart, pEnd);
			LocalTime phStart = LocalTime.of(0, 0);
			LocalTime phEnd = LocalTime.of(23, 59);
			LocalTime randomPublicat = betweenT(phStart, phEnd);
			publicat = dataRand + " " + randomPublicat;

			
			
			Video v = new Video(i, usuariID, estat, titol, descripcio, grandaria, nomArxiu, 
					durada, thumbnail, reproduccions, likes, dislikes, publicat);
			videos.add(v);
		}
		
		
		return videos;

	}	
	
	public static List<Etiqueta> gCategories() {
		List<Etiqueta> categories = new ArrayList<>();
		
		/*
		List<String> catPizzes = constants.CATEG_PIZZES;
		
		for(int i=0; i<catPizzes.size(); i++) {
			Etiqueta c;
			
			String categoria = catPizzes.get(i);
			
			c = new Etiqueta(i, categoria);
			categories.add(c);

		}
		*/
		return categories;

	}	

	public static List<Like> gComanda(int nombre, int nombreClients, int nombreBotigues, List<Treballador> tRepartidors){
		
		int comptador = 1;
		
		List<Like> comandes = new ArrayList<>();
		
		Random rand = new Random();
		
		//saber el nombre de repartidor que hi ha
		//tRepartidors.forEach(rp -> System.out.println(rp.getId()+": "+rp.getNif()));
		//int r = rand.nextInt(tRepartidors.size());
		//System.out.print("Dels "+tRepartidors.size()+" es tria el núm... ");
		//Treballador repa = tRepartidors.get(r);
		//System.out.println(r+"("+repa.getId()+") -> "+repa.getNif());
		
		for(int i=0; i<nombre; i++) {
			Like c;
			
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
						
			c = new Like(comptador, clientID, data, tipus, preuTotal, botigaID, repartidorID, datall);
			comandes.add(c);
			comptador++;
		}
		
		return comandes;
	}
	
	public static List<Comentari> gDComandes(int nombreComandes, int numProductes){
		int comptador = 1;
		List<Comentari> dComandes = new ArrayList<>();
		Random rand = new Random();
		
		for(int i=1; i<=nombreComandes; i++) {
			int productes = (int)(Math.random()*(8)+3);
			for (int j=1; j<=productes; j++) {
				Comentari d;
				int id = comptador;
				int comandaID = i;
				int quantitat = (int)(Math.random()*(5)+1);
				int producteID = (int)(Math.random()*(numProductes)+1);
				
				d = new Comentari(comptador, comandaID, quantitat, producteID);
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
