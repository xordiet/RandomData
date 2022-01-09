package S203_n2;

import java.util.List;

public class Main {

	static String sqlGeneral = "";
	
	public static void main(String[] args) {
		
		sqlGeneral += "db = connect( 'mongodb://localhost/youtube' );\n";
		
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
				
		List<Pais> lPaisos = GeneraAltres.gPaisos();
		/*lPaisos.forEach(p -> {
			System.out.println(p.toString());
		});*/
		
		List<Usuari> lUsuaris = GeneraPersones.gUsuaris(nombreUsuaris, lPaisos);
		String sqlUsuaris = "db.usuaris.insertMany("+lUsuaris+");\n";
		//System.out.println(sqlUsuaris);
		sqlGeneral += sqlUsuaris;
		
		List<Etiqueta> lTags = GeneraVideos.gEtiquetes();
		String sqlTags = "db.etiquetes.insertMany("+lTags+");\n";
		sqlGeneral += sqlTags;
		int nombreEtiquetes = lTags.size();
		
		List<Video> lVideos = GeneraVideos.gVideos(nombreVideos, nombreUsuaris, nombreEtiquetes);
		String sqlVideos = "db.videos.insertMany("+lVideos+");\n";
		//System.out.println(sqlVideos);
		sqlGeneral += sqlVideos;
		
		List<Canal> lCanals = GeneraPersones.gCanals(nombreCanals, nombreUsuaris);
		String sqlCanals = "db.canals.insertMany("+lCanals+");\n";
		//System.out.println(sqlCanals);
		sqlGeneral += sqlCanals;
		
		List<Subscripcio> lSusbsc = GeneraPersones.gSubscripcions(nombreSubscripcions, nombreUsuaris, nombreCanals);
		String sqlSubscr = "db.subscripcions.insertMany("+lSusbsc+");\n";
		//System.out.println(sqlSubscr);
		sqlGeneral += sqlSubscr;
		
		List<Like> lLikes = GeneraVideos.setLikes(nombreLikes, nombreUsuaris, nombreVideos);
		String sqlLikes = "db.likes.insertMany("+lLikes+");\n";
		//System.out.println(sqlLikes);
		sqlGeneral += sqlLikes;
		
		List<Playlist> lPlayLists = GeneraPersones.gPlaylists(nombrePlayLists, nombreUsuaris, nombreVideos);
		String sqlPlayLists = "db.playlist.insertMany("+lPlayLists+");\n";
		//System.out.println(sqlPlayLists);
		sqlGeneral += sqlPlayLists;
		
		List<Comentari> gComentaris = GeneraPersones.gComentari(nombreComentaris, nombreUsuaris, nombreVideos);
		String sqlComentaris = "db.comentaris.insertMany("+gComentaris+");\n";
		//System.out.println(sqlComentaris);
		sqlGeneral += sqlComentaris;

		List<ComentLike> lComLikes = GeneraVideos.agradaComentari(nombreLikesComent, nombreUsuaris, nombreComentaris);
		String sqlLikeComent = "db.comment_like.insertMany("+lComLikes+");\n";
		System.out.println(sqlLikeComent);
		sqlGeneral += sqlLikeComent;

		//System.out.println(sqlGeneral);
		CreaSQL.serialSQL(sqlGeneral, "youtube");
		System.out.println("Ja hem acabat! :)");
		
		
	}

}
