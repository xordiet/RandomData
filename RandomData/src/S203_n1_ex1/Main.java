package S203_n1_ex1;

public class Main {
	
	static String sqlGeneral = "";

	public static void main(String[] args) {		
		sqlGeneral += "db = connect( 'mongodb://localhost/optica' );\n";
		//sqlGeneral += "show dbs;";
		
		int numClients = 800;
		int numTreballadors = 25;
		int numProveidors = 15;
		int numMarques = 75;
		int numUlleres = 3000;
		int numVendes = 8000;
		
		String sqlClients = GeneraPersones.gClients(numClients);
		sqlGeneral += sqlClients;
		
		String sqlTreballadors = GeneraPersones.gTreballadors(numTreballadors);
		sqlGeneral += sqlTreballadors;
		
		String sqlProveidors = GeneraPersones.gProveidors(numProveidors);
		sqlGeneral += sqlProveidors;

		String sqlMarques = GeneraPersones.gMarques(numMarques, numProveidors);
		sqlGeneral += sqlMarques;
		
		String sqlUlleres = GeneraAltres.gUlleres(numUlleres, numMarques);
		sqlGeneral += sqlUlleres;
		
		String sqlVendes = GeneraAltres.gVendes(numVendes, numClients, numTreballadors, numUlleres);
		sqlGeneral += sqlVendes;
		
		System.out.println(sqlGeneral);
		CreaSQL.serialSQL(sqlGeneral, "optica");
		System.out.println("Ja hem acabat! :)");
	}

}
