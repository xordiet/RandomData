package S201_n2;

import java.util.List;

public class Main {

	static String sqlGeneral = "";
	
	public static void main(String[] args) {
		
		//quants de cada volem generar?
		int nombreUsuaris=900;
		int nombreVideos=2500;
		int nombreSets=7500;
		int nombreCanals=600;
		int nombreSubscripcions=1800;
		int nombreLikes=12000;
		int nombrePlayLists=8000;
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

		sqlGeneral += "\n-- Generem el llistat de videos\n";
		List<Video> lVideos = GeneraVideos.gVideos(nombreVideos, nombreUsuaris);
		lVideos.forEach(v -> {
			sqlGeneral += v.toString();
			sqlGeneral += "\n";
		});
		int numVideos = lVideos.size();
		
		sqlGeneral += "\n-- Creem les etiquetes\n";
		List<Etiqueta> lTags = GeneraVideos.gEtiquetes();
		lTags.forEach(t -> {
			sqlGeneral += t.toString();
			sqlGeneral += "\n";			
		});
		int numEtiquetes = lTags.size();
		
		sqlGeneral += "\n-- Apliquem les etiquetes als videos\n";
		List<Set> lSets = GeneraVideos.setEtiquetes(nombreSets, numVideos, numEtiquetes);
		lSets.forEach(t -> {
			sqlGeneral += t.toString();
			sqlGeneral += "\n";			
		});

		sqlGeneral += "\n-- Generem el llistat de canals\n";
		List<Canal> lCanals = GeneraPersones.gCanals(nombreCanals, nombreUsuaris);
		lCanals.forEach(c -> {
			sqlGeneral += c.toString();
			sqlGeneral += "\n";
		});

		sqlGeneral += "\n-- Creem les subscripcions\n";
		List<Subscripcio> lSusbsc = GeneraPersones.gSubscripcions(nombreSubscripcions, nombreUsuaris, nombreCanals);
		lSusbsc.forEach(s -> {
			sqlGeneral += s.toString();
			sqlGeneral += "\n";			
		});

		sqlGeneral += "\n-- Creem els likes\n";
		List<Like> lLikes = GeneraVideos.setLikes(nombreLikes, nombreUsuaris, nombreVideos);
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
		List<PLContent> oPlayLists = GeneraPersones.oPlayLists(omplePlayLists, nombrePlayLists, nombreUsuaris);
		oPlayLists.forEach(o -> {
			sqlGeneral += o.toString();
			sqlGeneral += "\n";			
		});

		sqlGeneral += "\n-- Generem els Comentaris\n";
		List<Comentari> gComentaris = GeneraPersones.gComentari(nombreComentaris, nombreUsuaris, nombreVideos);
		gComentaris.forEach(c -> {
			sqlGeneral += c.toString();
			sqlGeneral += "\n";			
		});
		
		sqlGeneral += "\n-- Creem els likes als comentaris\n";
		List<ComentLike> lComLikes = GeneraVideos.agradaComentari(nombreLikesComent, nombreUsuaris, nombreComentaris);
		lComLikes.forEach(l -> {
			sqlGeneral += l.toString();
			sqlGeneral += "\n";			
		});
		
		System.out.println(sqlGeneral);
		CreaSQL.serialSQL(sqlGeneral, "inserta_tot");
		System.out.println("Ja hem acabat! :)");
		
		
	}

}
