package S201_n2;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsePaisos {
	
	private static List<Pais> listPaisos;
	
	public static List<Pais> pPais() {
		listPaisos = new ArrayList<>();
		
		JSONParser parser = new JSONParser();
		 
		 try {
			 Object obj = parser.parse(new FileReader(constants.RUTAJSONS+"paisos.json"));
			 //obj ho convertim a JSON object
			 JSONObject objecte = (JSONObject) obj;
			 JSONArray data = (JSONArray)objecte.get("records");
			 //System.out.println("data: "+data);
			 //Iterator<JSONArray> iterator = data.iterator();
			 data.forEach(p -> {
				 JSONArray ps = (JSONArray)p;
				 //System.out.println(ps.toString());
				 int idp = (int)(long)ps.get(0);
				 String isoPais = (String) ps.get(1);
				 String nomPais = (String) ps.get(2);
				 Pais ipais = new Pais(idp, isoPais, nomPais);
	        	 listPaisos.add(ipais);
			 });
			 			 
		 } catch (ParseException pe) {
			 System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
		 } finally {
			 return listPaisos;
		 }
		 

	}


}
