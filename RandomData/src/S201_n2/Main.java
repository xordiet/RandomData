package S201_n2;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

	static String sqlGeneral = "";
	
	public static void main(String[] args) {
		
		//quants de cada volem generar?
		int nombreUsuaris=900;
		int nombreVideos=2500;
		
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

		/*
		sqlGeneral += "\n-- Generem els clients de la pizzeria\n";
		List<Usuari> lClients = GeneraPersones.gClients(nombreClients);
		lClients.forEach(c -> {
			//System.out.println(c.toString());
			sqlClients += c.toString();
			sqlClients += "\n";
			sqlGeneral += c.toString();
			sqlGeneral += "\n";
		});
		//System.out.println(sqlClients);
		//CreaSQL.serialSQL(sqlClients, "clients");

		sqlGeneral += "\n-- Generem les diferents botigues de la pizzeria\n";
		List<Botiga> lBotigues = GeneraVideos.gBotigues(nombreBotigues);
		lBotigues.forEach(b -> {
			//System.out.println(c.toString());
			sqlBotigues += b.toString();
			sqlBotigues += "\n";
			sqlGeneral += b.toString();
			sqlGeneral += "\n";
		});
		//System.out.println(sqlBotigues);
		//CreaSQL.serialSQL(sqlBotigues, "botigues");
		
		sqlGeneral += "\n-- Generem els treballadors de la pizzeria\n";
		List<Treballador> lTreballadors = GeneraPersones.gTreballadors(nombreTreballadors, nombreBotigues);
		lTreballadors.forEach(t -> {
			//System.out.println(c.toString());
			sqlTreballadors += t.toString();
			sqlTreballadors += "\n";
			sqlGeneral += t.toString();
			sqlGeneral += "\n";
		});
		//System.out.println(sqlTreballadors);
		//CreaSQL.serialSQL(sqlTreballadors, "treballadors");
		
		//Filtrem els treballadors que són repartidors que ho usarem més endavant
		List<Treballador> tRepartidors = lTreballadors.stream()
				.filter(c -> "repartidor".equals(c.getCategoria()))
				  .collect(Collectors.toList());
		
		sqlGeneral += "\n-- Generem les categories de pizzes\n";
		List<Etiqueta> lCategories = GeneraVideos.gCategories();
		lCategories.forEach(c -> {
			//System.out.println(c.toString());
			sqlGeneral += c.toString();
			sqlGeneral += "\n";
		});
				
		sqlGeneral += "\n-- Generem el llistat de productes\n";
		List<Video> lProductes = GeneraVideos.gProductes();
		lProductes.forEach(p -> {
			//System.out.println(c.toString());
			sqlGeneral += p.toString();
			sqlGeneral += "\n";
		});
		int nombreProductes = lProductes.size();

		sqlGeneral += "\n-- Generem el llistat de comandes\n";
		List<Like> lComandes = GeneraVideos.gComanda(nombreComandes, nombreClients, nombreBotigues, tRepartidors);
		lComandes.forEach(c -> {
			//System.out.println(c.toString());
			sqlGeneral += c.toString();
			sqlGeneral += "\n";
		});

		
		sqlGeneral += "\n-- Generem el llistat de detall de comandes\n";
		List<Comentari> lDetCom = GeneraVideos.gDComandes(nombreComandes, nombreProductes);
		lDetCom.forEach(d -> {
			//System.out.println(c.toString());
			sqlGeneral += d.toString();
			sqlGeneral += "\n";
		});
		
		*/

		System.out.println(sqlGeneral);
		CreaSQL.serialSQL(sqlGeneral, "inserta_tot");
		System.out.println("Ja hem acabat! :)");
		
		
	}

}
