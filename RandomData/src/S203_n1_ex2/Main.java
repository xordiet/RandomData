package S203_n1_ex2;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

	static String sqlGeneral = "";
	static String sqlClients = "";
	static String sqlBotigues = "";
	static String sqlTreballadors = "";
	
	public static void main(String[] args) {

		sqlGeneral += "db = connect( 'mongodb://localhost/pizzeria' );\n";

		//quants de cada volem generar?
		int nombreClients=900;
		int nombreBotigues=50;
		int nombreTreballadors=125;
		int nombreComandes=3000;
		
		System.out.println("Paciència...");
		
		String sqlProvincies = GeneraAltres.gProvincies();
		//System.out.println(sqlProvincies);
		sqlGeneral += sqlProvincies + ";\n";
		
		String sqlMunicipis = GeneraAltres.gLocalitats();
		//System.out.println(sqlMunicipis);
		sqlGeneral += sqlMunicipis + ";\n";
		
		List<Client> lClients = GeneraPersones.gClients(nombreClients);
		String sqlClients = "db.clients.insertMany("+lClients+");\n";
		//System.out.println(sqlClients);
		sqlGeneral += sqlClients;
		
		List<Botiga> lBotigues = GeneraNegoci.gBotigues(nombreBotigues);
		String sqlBotigues = "db.botigues.insertMany("+lBotigues+");\n";
		//System.out.println(sqlBotigues);
		sqlGeneral += sqlBotigues;
		
		List<Treballador> lTreballadors = GeneraPersones.gTreballadors(nombreTreballadors, nombreBotigues);
		String sqlTreballadors = "db.treballadors.insertMany("+lTreballadors+");\n";
		//System.out.println(sqlTreballadors);
		sqlGeneral += sqlTreballadors;

		//Filtrem els treballadors que són repartidors que ho usarem més endavant
		List<Treballador> tRepartidors = lTreballadors.stream()
				.filter(c -> "repartidor".equals(c.getCategoria()))
				  .collect(Collectors.toList());
		
		List<Categoria> lCategories = GeneraNegoci.gCategories();
		String sqlCategories = "db.categories_pizza.insertMany("+lCategories+");\n";
		//System.out.println(sqlCategories);
		sqlGeneral += sqlCategories;

		List<Producte> lProductes = GeneraNegoci.gProductes();
		String sqlProductes = "db.productes.insertMany("+lProductes+");\n";
		//System.out.println(sqlProductes);
		sqlGeneral += sqlProductes;
		
		
		List<Comanda> lComandes = GeneraNegoci.gComanda(nombreComandes, nombreClients, nombreBotigues, tRepartidors);
		String sqlComandes = "db.comandes.insertMany("+lComandes+");\n";
		//System.out.println(sqlComandes);
		sqlGeneral += sqlComandes;

		//System.out.println(sqlGeneral);
		CreaSQL.serialSQL(sqlGeneral, "pizzeria");
		System.out.println("SQL generat! :)");
		
		
	}

}
