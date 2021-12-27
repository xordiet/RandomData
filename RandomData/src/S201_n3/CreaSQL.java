package S201_n3;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CreaSQL {
	
	public static void serialSQL(String sqlClients, String nomArxiu) {
		/**
		 * Serialització del fitxer sql
		 */
		// establim la ruta i nom d'arxiu i Guardem a l'arxiu
		String directori = constants.RUTAEXPORTS;
		try {
			String fileName = directori+nomArxiu+".sql";
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		    writer.write(sqlClients);
		    
		    writer.close();
			
		} catch(Exception e){
			System.out.println("Error al crear l'arxiu serialitzat");
		} finally {
			System.out.println("!");
		}

	}

}
