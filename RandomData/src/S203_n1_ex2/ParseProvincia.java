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

public class ParseProvincia {
	static int i;
	
	private static List<Provincia> listProvincies;
	
	public static List<Provincia> pProvincia() {
		listProvincies = new ArrayList<>();
		
		JSONParser parser = new JSONParser();
		 
		 try (FileReader reader = new FileReader(constants.RUTAJSONS+"provincies.json")) {			 
			 //Object obj = parser.parse(new FileReader(constants.RUTAJSONS+"provincies.json"));
			 Object obj = parser.parse(reader);
			 JSONArray provincies = (JSONArray) obj;
			 //System.out.println(provincies);
			 provincies.forEach( prov -> parseProvinciaObj( (JSONObject) prov ) );
			 
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	     } catch (IOException e) {
	            e.printStackTrace();
	     } catch (ParseException pe) {
			 System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
		 } finally {
			 return listProvincies;
		 }
	}
		 
		 private static void parseProvinciaObj(JSONObject provincia) {
		     //Get employee object within list
			 JSONObject prov = (JSONObject) provincia.get("fields");
			 //System.out.println(prov);

			 String nom = (String) prov.get("provincia");
			 //System.out.println(nom);
			 
			 String codi = (String) prov.get("codigo");
			 int codiProv = Integer.parseInt(codi);
			 //System.out.println(codiProv);
			 
			 Provincia p = new Provincia(nom, codiProv);
			 listProvincies.add(p);
		}
		 



}
