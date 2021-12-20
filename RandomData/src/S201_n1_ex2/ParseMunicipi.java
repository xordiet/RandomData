package S201_n1_ex2;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseMunicipi {
	
	private static List<Municipi> listMunicip;
	
	public static List<Municipi> pMunicipi() {
		listMunicip = new ArrayList<>();
		
		JSONParser parser = new JSONParser();
		 
		 try {
			 Object obj = parser.parse(new FileReader(constants.RUTAJSONS+"municipis.json"));
			 //obj ho convertim a JSON object
			 JSONObject objecte = (JSONObject) obj;
			 JSONArray data = (JSONArray)objecte.get("data");
			 //System.out.println(data);
			 Iterator<JSONArray> iterator = data.iterator();
			 int i = 0;
	         while (iterator.hasNext()) {
	        	 JSONArray entrada = (JSONArray)iterator.next();
	        	 String codiPostal = (String)entrada.get(13);
	        	 int cp = Integer.parseInt(codiPostal);
	        	 String municipi = (String)entrada.get(8);
	        	 String comarca = (String)entrada.get(14);
	        	 String provincia = (String)entrada.get(17);
	        	 Municipi m = new Municipi(codiPostal, municipi, comarca, provincia);
	        	 listMunicip.add(m);
	        	 i++;
	        	 //System.out.println(i+" "+m.toString());
	         }
			 
		 } catch (ParseException pe) {
			 System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
		 } finally {
			 return listMunicip;
		 }
		 

	}


}
