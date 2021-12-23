package S201_n2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
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
				// TODO Auto-generated catch block
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

			int pais = rand.nextInt(lPaisos.size());

			//Adreça Codi Postal
			Integer randomCP=(int)(Math.random()*(47999-1)+1);
			String cp = randomCP.toString();
						
			c = new Usuari(i, email, password, username, data, sex, pais, randomCP);
			//System.out.println(c);
			usuaris.add(c);

		}
		return usuaris;

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
