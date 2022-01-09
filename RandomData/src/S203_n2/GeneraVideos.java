package S203_n2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraVideos {
	
	public static List<Etiqueta> gEtiquetes() {
		List<Etiqueta> tags = new ArrayList<>();
		
		List<String> nomsTags = constants.ETIQUETES;
		
		for(int i=0; i<nomsTags.size(); i++) {
			Etiqueta e;
			
			String etiqueta = nomsTags.get(i);
			
			e = new Etiqueta(i+1, etiqueta);
			tags.add(e);

		}
		return tags;

	}	
	
	public static List<Video> gVideos(int nombreVideos, int nombreUsuaris, int nombreEtiquetes) {
				
		List<Video> videos = new ArrayList<>();
		
		Random rand = new Random();
				
		for(int i=1; i<=nombreVideos; i++) {			
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
			int numTags = rand.nextInt(5);
			List<Integer> etiquetes = new ArrayList<Integer>();
			for(int k=0; k<numTags; k++) {
				int r = rand.nextInt(nombreEtiquetes)+1;
				etiquetes.add(r);
			}
			String publicat = "";
			LocalDate pStart = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate pEnd = LocalDate.now();
			LocalDate dataRand = betweenD(pStart, pEnd);
			LocalTime phStart = LocalTime.of(0, 0);
			LocalTime phEnd = LocalTime.of(23, 59);
			LocalTime randomPublicat = betweenT(phStart, phEnd);
			publicat = dataRand + " " + randomPublicat;

			
			
			Video v = new Video(i, usuariID, estat, titol, descripcio, grandaria, nomArxiu, 
					durada, thumbnail, reproduccions, likes, dislikes, etiquetes, publicat);
			videos.add(v);
		}
		
		
		return videos;

	}	
	
	public static List<Like> setLikes(int numLikes, int numUsuaris, int numVideos){
		List<Like> likes = new ArrayList<>();
		List<String> tipusLike = constants.LIKES;
		Random rand = new Random();
		
		for(int i=0; i<numLikes; i++) {
			String tipus = tipusLike.get(rand.nextInt(tipusLike.size()));
			int u = rand.nextInt(numUsuaris)+1;
			int v = rand.nextInt(numVideos)+1;
			String moment = "";
			LocalDate diaInici = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			LocalTime horaInici = LocalTime.of(0, 0);
			LocalTime horaFinal = LocalTime.of(23, 59);
			LocalTime horaRand = betweenT(horaInici, horaFinal);
			moment = dataRand + " " + horaRand;
			
			Like l = new Like(i, tipus, u, v, moment);
			likes.add(l);

		}
		
		return likes;
	}
	
	public static List<ComentLike> agradaComentari(int numLikes, int numUsuaris, int numComentaris){
		List<ComentLike> likes = new ArrayList<>();
		List<String> tipusLike = constants.LIKES;
		Random rand = new Random();
		
		for(int i=1; i<=numLikes; i++) {
			String tipus = tipusLike.get(rand.nextInt(tipusLike.size()));
			int u = rand.nextInt(numUsuaris)+1;
			int c = rand.nextInt(numComentaris)+1;
			String moment = "";
			LocalDate diaInici = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			LocalTime horaInici = LocalTime.of(0, 0);
			LocalTime horaFinal = LocalTime.of(23, 59);
			LocalTime horaRand = betweenT(horaInici, horaFinal);
			moment = dataRand + " " + horaRand;
			
			ComentLike l = new ComentLike(i, tipus, u, c, moment);
			likes.add(l);

		}
		
		return likes;
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
