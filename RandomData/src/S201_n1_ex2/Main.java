package S201_n1_ex2;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

	static String sqlGeneral = "";
	static String sqlClients = "";
	static String sqlBotigues = "";
	static String sqlTreballadors = "";
	
	public static void main(String[] args) {
		
		//quants de cada volem generar?
		int nombreClients=900;
		int nombreBotigues=50;
		int nombreTreballadors=125;
		int nombreComandes=3000;
		
		System.out.println("Paciència...");
		
		sqlGeneral += "-- Primer insertem les províncies ja que necessitem el seu id per a les localitats\n";
		//String sqlProvincies = GeneraAltres.gProvincies();
		//System.out.println(sqlProvincies);
		//CreaSQL.serialSQL(sqlProvincies, "provincies");
		sqlGeneral += GeneraAltres.gProvincies();
		
		sqlGeneral += "\n-- Insertem els 947 municipis de Catalunya com a localitats\n";
		//String sqlMunicipis = GeneraAltres.gLocalitats();
		//System.out.println(sqlMunicipis);
		//CreaSQL.serialSQL(sqlMunicipis, "localitats");
		sqlGeneral += GeneraAltres.gLocalitats();
		
		sqlGeneral += "\n-- Generem els clients de la pizzeria\n";
		List<Client> lClients = GeneraPersones.gClients(nombreClients);
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
		List<Botiga> lBotigues = GeneraNegoci.gBotigues(nombreBotigues);
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
		List<Categoria> lCategories = GeneraNegoci.gCategories();
		lCategories.forEach(c -> {
			//System.out.println(c.toString());
			sqlGeneral += c.toString();
			sqlGeneral += "\n";
		});
				
		sqlGeneral += "\n-- Generem el llistat de productes\n";
		List<Producte> lProductes = GeneraNegoci.gProductes();
		lProductes.forEach(p -> {
			//System.out.println(c.toString());
			sqlGeneral += p.toString();
			sqlGeneral += "\n";
		});
		int nombreProductes = lProductes.size();

		sqlGeneral += "\n-- Generem el llistat de comandes\n";
		List<Comanda> lComandes = GeneraNegoci.gComanda(nombreComandes, nombreClients, nombreBotigues, tRepartidors);
		lComandes.forEach(c -> {
			//System.out.println(c.toString());
			sqlGeneral += c.toString();
			sqlGeneral += "\n";
		});

		
		sqlGeneral += "\n-- Generem el llistat de detall de comandes\n";
		List<DetallComanda> lDetCom = GeneraNegoci.gDComandes(nombreComandes, nombreProductes);
		lDetCom.forEach(d -> {
			//System.out.println(c.toString());
			sqlGeneral += d.toString();
			sqlGeneral += "\n";
		});

		//System.out.println(sqlGeneral);
		CreaSQL.serialSQL(sqlGeneral, "inserta_tot");
		System.out.println("SQL generat! :)");
		
		
	}

}
