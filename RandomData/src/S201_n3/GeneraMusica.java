package S201_n3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraMusica {
	
	public static List<Playlist> gPlaylists(int numPlayLists, int numUsuaris){
		List<Playlist> playlists = new ArrayList<>();
		Random rand = new Random();
		
		for(int i=0; i<numPlayLists; i++) {

			String titol = "";
			int rdmExt = (int)(Math.random()*(6)+6);
			for (int j=0; j<rdmExt; j++) {
				char caracter = constants.LLETRES.charAt(rand.nextInt(constants.LLETRES.length()));
				titol += caracter;
			}
			int numcansons = rand.nextInt(1000)+1;
			LocalDate diaInici1 = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate diaFinal1 = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici1, diaFinal1);
			//LocalTime horaInici = LocalTime.of(0, 0);
			//LocalTime horaFinal = LocalTime.of(23, 59);
			//LocalTime horaRand = betweenT(horaInici, horaFinal);
			//creacio = dataRand + " " + horaRand;
			String creacio = dataRand.toString();
			boolean eliminada = rand.nextBoolean();
			String dataEliminacio = "NULL";
			if(eliminada) {
				LocalDate diaInici2 = dataRand;
				LocalDate diaFinal2 = LocalDate.now();
				LocalDate dataElim = betweenD(diaInici2, diaFinal2);
				dataEliminacio = dataElim.toString();
			}
			int creador = rand.nextInt(numUsuaris)+1;
			
			Playlist pl = new Playlist(i, titol, numcansons, creacio, eliminada, dataEliminacio, creador);
			playlists.add(pl);

		}
		
		return playlists;
	}

	
	
	
	
	
	
	public static List<Canso> gVideos(int nombreVideos, int nombreUsuaris) {
				
		List<Canso> videos = new ArrayList<>();
		
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

			
			
			Canso v = new Canso(i, usuariID, estat, titol, descripcio, grandaria, nomArxiu, 
					durada, thumbnail, reproduccions, likes, dislikes, publicat);
			videos.add(v);
		}
		
		
		return videos;

	}	
	
	public static List<Paypal> gEtiquetes() {
		List<Paypal> tags = new ArrayList<>();
		
		List<String> nomsTags = constants.ETIQUETES;
		
		for(int i=0; i<nomsTags.size(); i++) {
			Paypal e;
			
			String etiqueta = nomsTags.get(i);
			
			e = new Paypal(i, etiqueta);
			tags.add(e);

		}
		return tags;

	}	
	
	public static List<Set> setEtiquetes(int genera, int numVideos, int numTags) {
		List<Set> sets = new ArrayList<>();
		Random rand = new Random();

		for(int i=0; i<genera; i++) {
			Set s;
			
			int v = rand.nextInt(numVideos)+1;
			int t = rand.nextInt(numTags)+1;
	
			s = new Set(i, v, t);
			sets.add(s);
		}
		return sets;

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
