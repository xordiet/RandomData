package S201_n2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraPersones {
		
	public static List<Usuari> gUsuaris(int nombre, List<Pais> paisos) {
		List<Usuari> usuaris = new ArrayList<>();		
		
		List<Pais> lPaisos = paisos;
		Random rand = new Random();
		
		for(int i=0; i<nombre; i++) {
			Usuari c;
			String username = "";
			int rdmExt = (int)(Math.random()*(6)+6);
			for (int j=0; j<rdmExt; j++) {
				char caracter = constants.LLETRES.charAt(rand.nextInt(constants.LLETRES.length()));
				username += caracter;
			}
			
			String email = username+"@gmail.com";
			
			String password;
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				md.update(username.getBytes());
			    byte[] arr = md.digest();
				password = Base64.getEncoder().encodeToString(arr);
			} catch (NoSuchAlgorithmException e) {
				System.out.println(e.toString());
				password="12345";
				
			}
			//System.out.println(password);
			
			String data = "";
			LocalDate start = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate end = LocalDate.now();
			LocalDate dataRand = betweenD(start, end);
			data += dataRand;
			
			List<String> sexe = constants.SEXE;
			String sex = sexe.get(rand.nextInt(sexe.size()));

			int pais = rand.nextInt(lPaisos.size())+1;

			//Adreça Codi Postal
			Integer randomCP=(int)(Math.random()*(47999-1)+1);
			//String cp = randomCP.toString();
						
			c = new Usuari(i, email, password, username, data, sex, pais, randomCP);
			//System.out.println(c);
			usuaris.add(c);

		}
		return usuaris;

	}
		
	public static List<Canal> gCanals(int numCanals, int numUsuaris) {
		List<Canal> canals = new ArrayList<>();
		Random rand = new Random();
		
		for(int i=0; i<numCanals; i++) {
			Canal c;
			
			String nom = "canal ";
			int rdmExt = (int)(Math.random()*(6)+6);
			for (int j=0; j<rdmExt; j++) {
				char caracter = constants.LLETRES.charAt(rand.nextInt(constants.LLETRES.length()));
				nom += caracter;
			}

			String descripcio = "Aquest canal tracta sobre...";
			int creador = rand.nextInt(numUsuaris)+1;
			String dataCreacio = "";
			LocalDate diaInici = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			//LocalTime horaInici = LocalTime.of(0, 0);
			//LocalTime horaFinal = LocalTime.of(23, 59);
			//LocalTime horaRand = betweenT(horaInici, horaFinal);
			dataCreacio = dataRand.toString();

			c = new Canal(i, nom, descripcio, creador, dataCreacio);
			canals.add(c);

		}
		return canals;

	}	

	public static List<Subscripcio> gSubscripcions(int nombreSubscripcions, int numUsuaris, int numCanals) {
		List<Subscripcio> subscr = new ArrayList<>();
		Random rand = new Random();

		for(int i=0; i<nombreSubscripcions; i++) {
			Subscripcio s;
			
			int u = rand.nextInt(numUsuaris)+1;
			int c = rand.nextInt(numCanals)+1;
	
			s = new Subscripcio(i, u, c);
			subscr.add(s);
		}
		return subscr;

	}	

	public static List<Playlist> gPlaylists(int numPlayLists, int numUsuaris){
		List<Playlist> playlists = new ArrayList<>();
		Random rand = new Random();
		
		for(int i=0; i<numPlayLists; i++) {

			int creador = rand.nextInt(numUsuaris)+1;
			String nom = "";
			int rdmExt = (int)(Math.random()*(6)+6);
			for (int j=0; j<rdmExt; j++) {
				char caracter = constants.LLETRES.charAt(rand.nextInt(constants.LLETRES.length()));
				nom += caracter;
			}
			String creacio = "";
			LocalDate diaInici = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			LocalTime horaInici = LocalTime.of(0, 0);
			LocalTime horaFinal = LocalTime.of(23, 59);
			LocalTime horaRand = betweenT(horaInici, horaFinal);
			creacio = dataRand + " " + horaRand;
			boolean publica = rand.nextBoolean();
			
			Playlist pl = new Playlist(i, creador, nom, creacio, publica);
			playlists.add(pl);

		}
		
		return playlists;
	}
	
	public static List<PLContent> oPlayLists(int genera, int numPlayLists, int numVideos) {
		List<PLContent> plContent = new ArrayList<>();
		Random rand = new Random();

		for(int i=0; i<genera; i++) {
			
			int p = rand.nextInt(numPlayLists)+1;
			int v = rand.nextInt(numVideos)+1;
			String afegit = "";
			LocalDate diaInici = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			LocalTime horaInici = LocalTime.of(0, 0);
			LocalTime horaFinal = LocalTime.of(23, 59);
			LocalTime horaRand = betweenT(horaInici, horaFinal);
			afegit = dataRand + " " + horaRand;
	
			PLContent c = new PLContent(i, p, v, afegit);
			plContent.add(c);
		}
		return plContent;

	}	

	public static List<Comentari> gComentari(int genera, int numUsuaris, int numVideos) {
		List<Comentari> comentaris = new ArrayList<>();
		Random rand = new Random();
		
		List<String> subjectes = constants.SUBJECTES;
		List<String> verbs = constants.VERBS;
		List<String> predicats = constants.PREDICATS;


		for(int i=0; i<genera; i++) {
			
			int u = rand.nextInt(numUsuaris)+1;
			int v = rand.nextInt(numVideos)+1;
			String sub = subjectes.get(rand.nextInt(subjectes.size()));
			String verb = verbs.get(rand.nextInt(verbs.size()));
			String pred = predicats.get(rand.nextInt(predicats.size()));
			String text = sub+" "+verb+" "+pred;
			LocalDate diaInici = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			LocalTime horaInici = LocalTime.of(0, 0);
			LocalTime horaFinal = LocalTime.of(23, 59);
			LocalTime horaRand = betweenT(horaInici, horaFinal);
			String afegit = dataRand + " " + horaRand;
	
			Comentari c = new Comentari(i, u, v, text, afegit);
			comentaris.add(c);
		}
		return comentaris;

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
