package felipe;

public class Ex2Logica {

	public static String formatSentence(String sentence) {
		
		String[] palavras = sentence.split("");
		for (int i = 0; i < palavras.length; i++) {
			if (i%2==0) {
				palavras[i] = palavras[i].toUpperCase();
		}else {
			palavras[i] = palavras[i].toLowerCase();
		}
		}
		return String.join("", palavras);
	}
	
	
	public static void main(String[] args) {
		
		String sentences[] = new String [3];
		sentences[0] = "Teste usuario - primeiro teste";
		sentences[1] = "olá mundo!";
		sentences[2]= "TESTANDO sentença DANçante - abcdef";
		
		for (String sentence : sentences) {
			String formattedSentence = formatSentence(sentence);
			System.out.println(formattedSentence);
		}
		
		
		
}
}
