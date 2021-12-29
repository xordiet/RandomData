package S201_n3;

import java.util.List;
import java.util.stream.Collectors;

import S201_n1_ex2.Treballador;

public class Main {

	static String sqlGeneral = "";
	
	public static void main(String[] args) {
		
		//quants de cada volem generar?
		int nombreUsuaris=900;
		int nombreSubscripcions=1800;
		int nombreTargetes = 300;
		int nombrePaypals = 300;
		int nombrePagaments = 2500;
		int nombrePlayLists=8000;
		int nombreArtistes=15000;
		int nombreAlbums = 25000;
		int nombreRelacions = 20000;
		int nombreCancons = 35000;
		int omplePlayLists=25000;
		int numSeguiments=30000;
		int nombreFavs=50000;
				
		System.out.println("Paciència...");
				
		sqlGeneral += "-- Insertem els Països existents\n";
		List<Pais> lPaisos = GeneraAltres.gPaisos();
		lPaisos.forEach(p -> {
			sqlGeneral += p.toString();
			sqlGeneral += "\n";			
		});
		
		sqlGeneral += "\n-- Generem el llistat d'usuaris\n";
		List<Usuari> lUsuaris = GeneraPersones.gUsuaris(nombreUsuaris, lPaisos);
		lUsuaris.forEach(u -> {
			sqlGeneral += u.toString();
			sqlGeneral += "\n";
		});
		
		//Filtrem els usuaris premium, que seran els que paguen subscripció
		List<Usuari> uPremium = lUsuaris.stream()
				.filter(u -> u.isPremium())
				.collect(Collectors.toList());	
		
		sqlGeneral += "\n-- Creem les subscripcions\n";
		List<Subscripcio> lSusbsc = GeneraPersones.gSubscripcions(nombreSubscripcions, uPremium);
		lSusbsc.forEach(s -> {
			sqlGeneral += s.toString();
			sqlGeneral += "\n";			
		});

		sqlGeneral += "\n-- Creem les targetes de crèdit\n";
		List<Targeta> lTarges = GeneraAltres.gTargetes(nombreTargetes);
		lTarges.forEach(t -> {
			sqlGeneral += t.toString();
			sqlGeneral += "\n";			
		});
		
		sqlGeneral += "\n-- Creem el registre de PayPal\n";
		List<Paypal> lPaypals = GeneraAltres.gPayPal(nombrePaypals);
		lPaypals.forEach(p -> {
			sqlGeneral += p.toString();
			sqlGeneral += "\n";			
		});
		
		sqlGeneral += "\n-- Creem el registre de pagaments\n";
		List<Pagament> lPagaments = GeneraPersones.gPagaments(nombrePagaments, nombreSubscripcions, nombreTargetes, nombrePaypals);
		lPagaments.forEach(p -> {
			sqlGeneral += p.toString();
			sqlGeneral += "\n";			
		});
		
		System.out.println("Still running: generant els artistes... Paciència, són "+nombreArtistes);
		sqlGeneral += "\n-- Generem els artistes\n";
		List<Artista> lArtistes = GeneraPersones.gArtistes(nombreArtistes);
		lArtistes.forEach(a -> {
			sqlGeneral += a.toString();
			sqlGeneral += "\n";			
		});

		System.out.println("Still running: generant els albums... Paciència, són "+nombreAlbums);
		sqlGeneral += "\n-- Generem els albums\n";
		List<Album> lAlbums = GeneraMusica.gAlbums(nombreAlbums, nombreArtistes);
		lAlbums.forEach(a -> {
			sqlGeneral += a.toString();
			sqlGeneral += "\n";			
		});

		System.out.println("Still running: generant els artistes relacionats... Paciència, són "+nombreRelacions);
		sqlGeneral += "\n-- Generem els artistes relacionats\n";
		List<Relacionat> lArtRelac = GeneraPersones.gRelacions(nombreRelacions, nombreArtistes);
		lArtRelac.forEach(a -> {
			sqlGeneral += a.toString();
			sqlGeneral += "\n";			
		});

		System.out.println("Still running: generant les playlist...");
		sqlGeneral += "\n-- Generem les Playlist\n";
		List<Playlist> lPlaylists = GeneraMusica.gPlaylists(nombrePlayLists, nombreUsuaris);
		lPlaylists.forEach(p -> {
			sqlGeneral += p.toString();
			sqlGeneral += "\n";			
		});

		System.out.println("Still running: generant el llistat de cançons... Paciència, són "+nombreCancons);
		sqlGeneral += "\n-- Generem el llistat de cançons\n";
		List<Canso> lCancons = GeneraMusica.gCansons(nombreCancons, nombreArtistes, nombreAlbums);
		lCancons.forEach(c -> {
			sqlGeneral += c.toString();
			sqlGeneral += "\n";
		});
		
		System.out.println("Still running: Omplint els detalls de les PlayLists... Paciència, són "+omplePlayLists);
		sqlGeneral += "\n-- Omplim els detalls de les PlayLists\n";
		List<PLDetails> oPlayLists = GeneraMusica.oPlayLists(omplePlayLists, nombrePlayLists, nombreCancons, nombreUsuaris);
		oPlayLists.forEach(o -> {
			sqlGeneral += o.toString();
			sqlGeneral += "\n";			
		});

		System.out.println("Still running: Creem els seguiments... Paciència, són "+numSeguiments);
		sqlGeneral += "\n-- Creem els seguiments\n";
		List<Seguiment> lSeguiments = GeneraMusica.gSeguments(numSeguiments, nombreUsuaris, nombreArtistes);
		lSeguiments.forEach(s -> {
			sqlGeneral += s.toString();
			sqlGeneral += "\n";			
		});

		System.out.println("Still running: Creem els favorits... Paciència, són "+nombreFavs);
		sqlGeneral += "\n-- Creem els Favorits\n";
		List<Favorit> lLikes = GeneraMusica.setFavs(nombreFavs, nombreUsuaris, nombreAlbums, nombreCancons);
		lLikes.forEach(l -> {
			sqlGeneral += l.toString();
			sqlGeneral += "\n";			
		});
		
		System.out.println(sqlGeneral);
		CreaSQL.serialSQL(sqlGeneral, "inserta_tot");
		System.out.println("Ja hem acabat! :)");
		
	}

}
