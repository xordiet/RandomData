package S201_n3;

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

import S201_n1_ex2.Treballador;

public class GeneraPersones {
		
	public static List<Usuari> gUsuaris(int nombre, List<Pais> paisos) {
		List<Usuari> usuaris = new ArrayList<>();		
		
		List<Pais> lPaisos = paisos;
		Random rand = new Random();
		
		for(int i=1; i<=nombre; i++) {
			Usuari c;
			boolean premium = rand.nextBoolean();
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
						
			c = new Usuari(i, premium, email, password, username, data, sex, pais, randomCP);
			//System.out.println(c);
			usuaris.add(c);

		}
		return usuaris;

	}
		
	public static List<Artista> gArtistes(int numArtistes){
		List<Artista> artistes = new ArrayList<>();
		Random rand = new Random();
		for (int i=1; i<=numArtistes; i++) {
			String nom = "";
			int rdmExt = (int)(Math.random()*(6)+6);
			for (int j=0; j<rdmExt; j++) {
				char caracter = constants.LLETRES.charAt(rand.nextInt(constants.LLETRES.length()));
				nom += caracter;
			}
			Artista a = new Artista(i, nom, "imatge de l'artista");
			artistes.add(a);
		}
		
		return artistes;
	}
	
	public static List<Relacionat> gRelacions(int numRelacions, int numArtistes){
		List<Relacionat> artistesRelac = new ArrayList<>();
		Random rand = new Random();
		for(int i=1; i<=numRelacions; i++) {
			int artistBase = rand.nextInt(numArtistes)+1;
			int artistRelac = rand.nextInt(numArtistes)+1;
			Relacionat r = new Relacionat(i, artistBase, artistRelac);
			artistesRelac.add(r);
			
		}
		return artistesRelac;
	}
	
	public static List<Subscripcio> gSubscripcions(int nombreSubscripcions, List<Usuari> sonPremium) {
		List<Subscripcio> subscr = new ArrayList<>();
		Random rand = new Random();

		for(int i=0; i<nombreSubscripcions; i++) {
			Subscripcio s;
			
			int r = rand.nextInt(sonPremium.size());
			Usuari prem = sonPremium.get(r);
			int u = prem.getId();
			LocalDate diaInici = LocalDate.of(2000, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			//LocalTime horaInici = LocalTime.of(0, 0);
			//LocalTime horaFinal = LocalTime.of(23, 59);
			//LocalTime horaRand = betweenT(horaInici, horaFinal);
			//dataInici = dataRand + " " + horaRand;
			String dataInici = dataRand.toString();
			int renova = constants.MESOSRENOVACIO.get(rand.nextInt(constants.MESOSRENOVACIO.size()));
			LocalDate renovacio = dataRand.plusMonths(12);
			String dataRenovacio = renovacio.toString();
			String pagament = constants.PAGAMENTS.get(rand.nextInt(constants.PAGAMENTS.size()));
			
			s = new Subscripcio(i, u, dataInici, dataRenovacio, pagament);
			subscr.add(s);
		}
		return subscr;

	}	

	public static List<Pagament> gPagaments(int numPagaments, int nombreSubscripcions, int nombreTargetes, int nombrePaypals){
		List<Pagament> pagaments = new ArrayList<>();
		Random rand = new Random();
		for (int i=1; i<=numPagaments; i++) {
			int subId= rand.nextInt(nombreSubscripcions)+1;
			int targId = rand.nextInt(nombreTargetes)+1;
			int ppId = rand.nextInt(nombrePaypals)+1;
			LocalDate diaInici = LocalDate.of(2000, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			//LocalTime horaInici = LocalTime.of(0, 0);
			//LocalTime horaFinal = LocalTime.of(23, 59);
			//LocalTime horaRand = betweenT(horaInici, horaFinal);
			//dataInici = dataRand + " " + horaRand;
			String data = dataRand.toString();
			double preu = 10 + rand.nextDouble() * (100 - 10);
			double preuTotal = Math.round(preu * 100.0)/100.0;
			String tipus = constants.PAGAMENTS.get(rand.nextInt(constants.PAGAMENTS.size()));
			
			
			Pagament p = new Pagament(i, subId, targId, ppId, data, preuTotal, tipus);
			pagaments.add(p);
			
		}
		return pagaments;
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
