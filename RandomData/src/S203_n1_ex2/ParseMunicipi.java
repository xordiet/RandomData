package S203_n1_ex2;

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
			 int i = 1;
	         while (iterator.hasNext()) {
	        	 int id = i;
	        	 JSONArray entrada = (JSONArray)iterator.next();
	        	 String identif = (String)entrada.get(13);
	        	 int idf = Integer.parseInt(identif);
	        	 String municipi = (String)entrada.get(8);
	        	 String comarca = (String)entrada.get(14);
	        	 String codiCom = (String)entrada.get(15);
	        	 int cComarca = Integer.parseInt(codiCom);
	        	 String provincia = (String)entrada.get(17);
	        	 String codiProv = (String)entrada.get(18);
	        	 int cProvincia = Integer.parseInt(codiProv);
	        	 Municipi m = new Municipi(id, idf, municipi, comarca, cComarca, provincia, cProvincia);
	        	 listMunicip.add(m);
	        	 //System.out.println(i+" "+m.toString());
	        	 i++;
	         }
			 
		 } catch (ParseException pe) {
			 System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
		 } finally {
			 return listMunicip;
		 }
		 

	}


}
