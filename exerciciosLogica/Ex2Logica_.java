package felipe;


public class Ex2Logica_ {

	public static void main(String[] args) {
		
		String sentence[] = new String [3];
		sentence[0] = "Teste usuario - primeiro teste";
		sentence[1] = "olá mundo!";
		sentence[2]= "TESTANDO sentença DANçante - abcdef";
	
		
		for (int i = 0; i < sentence.length; i++) {
			String palavra[] = sentence[i].split("");
			for (int j = 0; j < palavra.length; j++) {
				if (j%2==0) {
					palavra[j] = palavra[j].toUpperCase();
				}else {
					palavra[j] = palavra[j].toLowerCase();
				}
			
		}
		String dance = String.join("",palavra);
		System.out.println(dance);

	

	}
	}

}
