package S203_n1_ex1;

public class CalculaDni {

	private String letra;
	
	public CalculaDni(int dni) {
		String caracters="TRWAGMYFPDXBNJZSQVHLCKE";
		int modulo= dni % 23;
		this.letra = caracters.charAt(modulo)+"";	
	}
	
	public String getLetra() {
		return letra;
	}
	

}
