package S201_n1_ex1;

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
		
		for(int i=0; i<nombre; i++) {
			String cadena = "";
			
			cadena +="INSERT INTO S201_n1_ex1.ulleres (marca_id, gradua_ud, gradua_ue, tipus_montura, color_montura, color_vd, color_ve, preu) VALUES (";
			
			int randomInt=(int)(Math.random()*(numMarques)+1);
			cadena+= randomInt+", ";
			
			float randomDobl1 = (float)(Math.random()*3);
			cadena+= ""+randomDobl1+", ";

			float randomDobl2;
			if(Math.random() < 0.5){
				randomDobl2 = randomDobl1+(float)(Math.random());
			} else {
				randomDobl2 = randomDobl1-(float)(Math.random());
			}
			cadena+= ""+randomDobl2+", ";

			String montura = montures.get(rand.nextInt(montures.size()));
			cadena+= "\""+montura+"\", ";

			String colorMontura = colors.get(rand.nextInt(colors.size()));
			cadena+= "\""+colorMontura+"\", ";

			String colorVd = colVidres.get(rand.nextInt(colVidres.size()));
			cadena+= "\""+colorVd+"\", ";

			String colorVe = colVidres.get(rand.nextInt(colVidres.size()));
			cadena+= "\""+colorVe+"\", ";
			
			float preu = (float)(Math.random()*300+50);
			cadena+= preu;
			

			cadena +=");";

			retorna += cadena+"\n";
			//System.out.println(cadena);

		}
		
		return retorna;

	}
	
	public static String gVendes(int nombre, int numTreballadors, int numClients) {
		
		String retorna = "";
		
		Random rand = new Random();
		int randomInt;
		
		
		for(int i=0; i<nombre; i++) {
			String cadena = "";
			
			cadena +="INSERT INTO S201_n1_ex1.vendes (ullera_id, venedor_id, client_id, data_venda) VALUES (";
			
			cadena+= (i+1)+", ";
			
			randomInt=(int)(Math.random()*(numTreballadors)+1);
			cadena+= randomInt+", ";

			randomInt=(int)(Math.random()*(numClients)+1);
			cadena+= randomInt+", ";
			
			String venda = "";
			LocalDate start = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate end = LocalDate.now();
			LocalDate dataRand = betweenD(start, end);
			venda += dataRand;
			LocalTime obre = LocalTime.of(8, 30);
			LocalTime tanca = LocalTime.of(18, 30);
			LocalTime randomTime = betweenT(obre, tanca);
			venda += " "+randomTime;
			cadena +=  "'"+venda+"'";
					
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
