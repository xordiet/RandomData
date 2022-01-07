package S203_n1_ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseNoms {
	
	private static List<String> listNoms;
	
	public static List<String> pNoms() {
		listNoms = new ArrayList<>();
		
		JSONParser parser = new JSONParser();
		 
		 try {
			 Object obj = parser.parse(new FileReader(constants.RUTAJSONS+"nadons.json"));
			 //System.out.println(obj.toString());
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
	        	 listNoms.add(title);
	        	 //System.out.println(i+" "+title);
	        	 i++;
	         }
			 
		 } catch (ParseException pe) {
			 System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
		 } finally {
			 return listNoms;
		 }
		 

	}


}
