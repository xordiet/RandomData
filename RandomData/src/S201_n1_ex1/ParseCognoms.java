package S201_n1_ex1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseCognoms {
	
	private static List<String> listCognoms;
	
	public static List<String> pCognoms() {
		listCognoms = new ArrayList<>();
		
		JSONParser parser = new JSONParser();
		 
		 try {
			 Object obj = parser.parse(new FileReader(constants.RUTAJSONS+"cognoms.json"));
			 //obj ho convertim a JSON object
			 JSONObject objecte = (JSONObject) obj;
			 JSONObject feed = (JSONObject) objecte.get("feed");
			 JSONArray entry = (JSONArray)feed.get("entry");
			 //System.out.println(entry);
			 Iterator iterator = entry.iterator();
			 int i = 0;
	         while (iterator.hasNext()) {
	        	 JSONObject entrada = (JSONObject)iterator.next();
	        	 String title = (String)entrada.get("title");
	        	 listCognoms.add(title);
	        	 //System.out.println(i+" "+title);
	        	 i++;
	         }
			 
		 } catch (ParseException pe) {
			 System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
		 } finally {
			 return listCognoms;
		 }
		 

	}


}
