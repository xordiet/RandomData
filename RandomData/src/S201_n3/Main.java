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
		
		int nombreVideos=2500;
		int nombreSets=7500;
		int nombreCanals=600;
		int nombreLikes=12000;
		int omplePlayLists=25000;
		int nombreComentaris=18000;
		int nombreLikesComent=8000;
		
		System.out.println("Paciència...");
				
		sqlGeneral += "\n-- Insertem els Països existents\n";
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
		
		sqlGeneral += "\n-- Generem les Playlist\n";
		List<Playlist> lPlaylists = GeneraMusica.gPlaylists(nombrePlayLists, nombreUsuaris);
		lPlaylists.forEach(p -> {
			sqlGeneral += p.toString();
			sqlGeneral += "\n";			
		});

		


		/*
		sqlGeneral += "\n-- Generem el llistat de videos\n";
		List<Canso> lVideos = GeneraMusica.gVideos(nombreVideos, nombreUsuaris);
		lVideos.forEach(v -> {
			sqlGeneral += v.toString();
			sqlGeneral += "\n";
		});
		int numVideos = lVideos.size();
		
		sqlGeneral += "\n-- Creem les etiquetes\n";
		List<Paypal> lTags = GeneraMusica.gEtiquetes();
		lTags.forEach(t -> {
			sqlGeneral += t.toString();
			sqlGeneral += "\n";			
		});
		int numEtiquetes = lTags.size();
		
		sqlGeneral += "\n-- Apliquem les etiquetes als videos\n";
		List<Set> lSets = GeneraMusica.setEtiquetes(nombreSets, numVideos, numEtiquetes);
		lSets.forEach(t -> {
			sqlGeneral += t.toString();
			sqlGeneral += "\n";			
		});

		//NO funciona
		sqlGeneral += "\n-- Generem el llistat de canals\n";
		List<Favorit> lCanals = GeneraPersones.gCanals(nombreCanals, nombreUsuaris);
		lCanals.forEach(c -> {
			sqlGeneral += c.toString();
			sqlGeneral += "\n";
		});


		sqlGeneral += "\n-- Creem els likes\n";
		List<Like> lLikes = GeneraMusica.setLikes(nombreLikes, nombreUsuaris, nombreVideos);
		lLikes.forEach(l -> {
			sqlGeneral += l.toString();
			sqlGeneral += "\n";			
		});
		
		sqlGeneral += "\n-- Generem les PlayList\n";
		List<Playlist> lPlayLists = GeneraPersones.gPlaylists(nombrePlayLists, nombreUsuaris);
		lPlayLists.forEach(p -> {
			sqlGeneral += p.toString();
			sqlGeneral += "\n";			
		});

		sqlGeneral += "\n-- Omplim les PlayList\n";
		List<PLDetails> oPlayLists = GeneraPersones.oPlayLists(omplePlayLists, nombrePlayLists, nombreUsuaris);
		oPlayLists.forEach(o -> {
			sqlGeneral += o.toString();
			sqlGeneral += "\n";			
		});
		*/

		System.out.println(sqlGeneral);
		CreaSQL.serialSQL(sqlGeneral, "inserta_tot");
		System.out.println("Ja hem acabat! :)");
		
		
	}

}
