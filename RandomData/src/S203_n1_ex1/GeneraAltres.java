package S203_n1_ex1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraAltres {
	
	public static String gUlleres(int nombre, int numMarques) {
		
		String retorna = "";
		
		List<String> colors = constants.COLORS;
		List<String> montures = constants.MONTURES;
		List<String> colVidres = constants.COLVIDRES;
		
		Random rand = new Random();
		Double randomDobl;
		
		for(int i=1; i<=nombre; i++) {
			String cadena = "";
			
			cadena +="db.ulleres.insertOne({\"_id\": "+ i +", \"marca_id\": ";
			
			int randomInt=(int)(Math.random()*(numMarques)+1);
			cadena+= randomInt;

			cadena += ", \"graduacio\": [";
			float randomDobl1 = (float)(Math.random()*3);
			float randomDobl2;
			if(Math.random() < 0.5){
				randomDobl2 = randomDobl1+(float)(Math.random());
			} else {
				randomDobl2 = randomDobl1-(float)(Math.random());
			}
			cadena+= randomDobl1+", "+randomDobl2;
			
			cadena += "], \"tipus_montura\": \"";
			String montura = montures.get(rand.nextInt(montures.size()));
			cadena+= montura;
			
			cadena += "\", \"color_montura\": \"";
			String colorMontura = colors.get(rand.nextInt(colors.size()));
			cadena+= colorMontura;
			
			cadena += "\", \"color_vidres\": [";
			String colorVd = colVidres.get(rand.nextInt(colVidres.size()));
			String colorVe = colVidres.get(rand.nextInt(colVidres.size()));
			cadena+= "\""+colorVd+"\", \""+colorVe+"\"";
			
			cadena += "], \"preu\": ";
			float preu = (float)(Math.random()*300+50);
			cadena+= preu;
			
			cadena += "})";
			
			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		
		return retorna;

	}
	
	public static String gVendes(int nombre, int numClients, int numTreballadors, int numUlleres) {
		
		String retorna = "";
		
		Random rand = new Random();
		int randomInt;
		
		
		for(int i=0; i<nombre; i++) {
			String cadena = "";
			
			cadena +="db.vendes.insertOne({\"client_id\": ";
			randomInt=(int)(Math.random()*(numClients)+1);
			cadena+= randomInt;
			
			cadena += ", \"venedor_id\": ";
			randomInt=(int)(Math.random()*(numTreballadors)+1);
			cadena+= randomInt;
			
			cadena += ", \"ullera_ud\": ";
			randomInt=(int)(Math.random()*(numUlleres)+1);
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
