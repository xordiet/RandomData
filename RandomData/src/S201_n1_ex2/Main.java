package S201_n1_ex2;

public class Main {

	public static void main(String[] args) {		
		
		/**
		 * Comento els arxius ja creats per no crear-ne de nous cada cop
		 */ 
		
		String sqlClients = GeneraPersones.gClients(800);
		System.out.println(sqlClients);
		
		/*
		 * Comento per ara
		 * 
		String sqlClients = GeneraPersones.gClients(800);
		System.out.println(sqlClients);
		//CreaSQL.serialSQL(sqlClients, "clients");

		String sqlTreballadors = GeneraPersones.gTreballadors(25);
		System.out.println(sqlTreballadors);
		//CreaSQL.serialSQL(sqlTreballadors, "treballadors");

		String sqlProveidors = GeneraPersones.gProveidors(15);
		System.out.println(sqlProveidors);
		//CreaSQL.serialSQL(sqlProveidors, "proveidors");

		String sqlMarques = GeneraPersones.gMarques(75, 15);
		System.out.println(sqlMarques);
		//CreaSQL.serialSQL(sqlMarques, "marques");

		String sqlUlleres = GeneraAltres.gUlleres(3000, 75);
		System.out.println(sqlUlleres);
		//CreaSQL.serialSQL(sqlUlleres, "ulleres");
		
		String sqlVendes = GeneraAltres.gVendes(3000, 25, 800);
		System.out.println(sqlVendes);
		//CreaSQL.serialSQL(sqlVendes, "vendes");
		 */
		
		
	}

}
