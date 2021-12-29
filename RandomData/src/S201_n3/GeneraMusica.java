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

	public static List<Album> gAlbums(int numAlbums, int numArtistes){
		List<Album> albums = new ArrayList<>();
		Random rand = new Random();
		
		for (int i=1; i<=numAlbums; i++) {
			int artista = rand.nextInt(numArtistes)+1;
			String titol = "";
			int rdmExt = rand.nextInt(6)+6;
			for (int j=0; j<rdmExt; j++) {
				char caracter = constants.LLETRES.charAt(rand.nextInt(constants.LLETRES.length()));
				titol += caracter;
			}
			int anyPublicacio = rand.nextInt(2021-1979)+1979;
			String imgPortada = "Imatge de la portada del disc";
			Album a = new Album(i, artista, titol, anyPublicacio, imgPortada);
			albums.add(a);
		}
		return albums;
	}
	
	public static List<Canso> gCansons(int nombreCancons, int nombreArtistes, int nombreAlbums) {
				
		List<Canso> cancons = new ArrayList<>();
		Random rand = new Random();
				
		for(int i=0; i<nombreCancons; i++) {			
			String titol = "Títol del video";
			LocalTime dStart = LocalTime.of(0, 0);
			LocalTime dEnd = LocalTime.of(5, 39);
			LocalTime randDurada = betweenT(dStart, dEnd);
			String durada = randDurada.toString();
			int artista = rand.nextInt(nombreArtistes)+1;
			int album = rand.nextInt(nombreAlbums)+1;
			int reproduccions = rand.nextInt(23500);
			
			Canso c = new Canso(i, titol, durada, artista, album, reproduccions);
			cancons.add(c);
		}
		
		return cancons;

	}	
	
	public static List<PLDetails> oPlayLists(int genera, int numPlayLists, int numCancons, int numUsuaris) {
		List<PLDetails> plContent = new ArrayList<>();
		Random rand = new Random();

		for(int i=0; i<genera; i++) {
			
			int p = rand.nextInt(numPlayLists)+1;
			int c = rand.nextInt(numCancons)+1;
			int u = rand.nextInt(numUsuaris)+1;
			LocalDate diaInici = LocalDate.of(1979, Month.OCTOBER, 1);
			LocalDate diaFinal = LocalDate.now();
			LocalDate dataRand = betweenD(diaInici, diaFinal);
			String dataAddicio = dataRand.toString();
	
			PLDetails o = new PLDetails(i, p, c, u, dataAddicio);
			plContent.add(o);
		}
		return plContent;

	}	

	public static List<Seguiment> gSeguments(int genera, int numUsuaris, int numArtistes) {
		List<Seguiment> seguiments = new ArrayList<>();
		Random rand = new Random();

		for(int i=0; i<genera; i++) {
			Seguiment s;
			
			int u = rand.nextInt(numUsuaris)+1;
			int a = rand.nextInt(numArtistes)+1;
	
			s = new Seguiment(i, u, a);
			seguiments.add(s);
		}
		return seguiments;

	}	

	public static List<Favorit> setFavs(int numLikes, int numUsuaris, int numAlbums, int numCancons){
		List<Favorit> favorits = new ArrayList<>();
		List<String> tipusFAV = constants.TIPUS_FAV;
		Random rand = new Random();
		
		for(int i=0; i<numLikes; i++) {
			int u = rand.nextInt(numUsuaris)+1;
			int a = rand.nextInt(numAlbums)+1;
			int c = rand.nextInt(numCancons)+1;
			String tipus = tipusFAV.get(rand.nextInt(tipusFAV.size()));
			
			Favorit f = new Favorit(i, u, a, c, tipus);
			favorits.add(f);

		}
		
		return favorits;
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
