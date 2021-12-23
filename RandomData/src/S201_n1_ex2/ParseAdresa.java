package S201_n1_ex2;

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

public class ParseAdresa {
	
	private static List<String> listNoms;
	private static List<Adresa> listAdreces;
	
	public static List<String> pCarrer() {
		listNoms = new ArrayList<>();
		
		JSONParser parser = new JSONParser();
		 
		 try {
			 Object obj = parser.parse(new FileReader(constants.RUTAJSONS+"NomenclatorBCN.json"));
			 //obj ho convertim a JSON object
			 JSONArray carrers = (JSONArray) obj;
			 //System.out.println(carrers);
			 Iterator iterator = carrers.iterator();
			 int i = 0;
	         while (iterator.hasNext()) {
	        	 JSONObject entrada = (JSONObject)iterator.next();
	        	 String tvia = (String)entrada.get("TIPUS_VIA");
	        	 String part = (String)entrada.get("PARTICULES");
	        	 String nom = (String)entrada.get("NOM");
	        	 String complert = tvia+" "+part+" "+nom;
	        	 listNoms.add(complert);
	        	 //System.out.println(i+" "+complert);
	        	 i++;
	         }
			 
		 } catch (ParseException pe) {
			 System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
		 } finally {
			 return listNoms;
		 }
		 

	}

	public static List<Adresa> pAdresa() {
		listAdreces = new ArrayList<>();
		Adresa adresa;
		
		JSONParser parser = new JSONParser();
		 
		 try {
			 Object obj = parser.parse(new FileReader(constants.RUTAJSONS+"NomenclatorBCN.json"));
			 //obj ho convertim a JSON object
			 JSONArray carrers = (JSONArray) obj;
			 //System.out.println(carrers);
			 Iterator iterator = carrers.iterator();
			 int i = 0;
	         while (iterator.hasNext()) {
	        	 JSONObject entrada = (JSONObject)iterator.next();
	        	 String tvia = (String)entrada.get("TIPUS_VIA");
	        	 String part = (String)entrada.get("PARTICULES");
	        	 String nom = (String)entrada.get("NOM");
	        	 String complert = tvia+" "+part+" "+nom;
	        	 
	        	 adresa = new Adresa(complert);
	        	 //listAdreces.add(complert);
	        	 //System.out.println(i+" "+complert);
	        	 i++;
	         }
			 
		 } catch (ParseException pe) {
			 System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
		 } finally {
			 return listAdreces;
		 }
		 

	}


}
