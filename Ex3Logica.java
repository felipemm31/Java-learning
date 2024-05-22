package felipe;
import java.util.Scanner;
public class Ex3Logica {

	public static void main(String[] args) {
		
		/* alfabeto na tabela ASCII: A-Z (65-90) / a-z (97-122)
		
          ENTRADA: número de linhas (N) -> N strings 
          SAÍDA:  para cada linha deve-se apresentar a mensagem criptografada. */
		
		 Scanner teclado = new Scanner (System.in);
		 
		 int N;

	       
	        while (true){
	            System.out.println("Digite o número de linhas que serão criptografadas:");
	            if (teclado.hasNextInt()) {
	                N = teclado.nextInt();
	                if (N>0) {
	                break;
	                }else if (N==0) {
	            	System.out.println("Digite um número maior que zero.");
	                }
	              }else {
	               System.out.println("Digite um número inteiro.");
	               teclado.next();
	            }
	        }
	        
		String linhas[] = new String[N];
		teclado.nextLine();
		
		for (int i = 0; i < N; i++) {
			System.out.println("Digite a "+(i+1)+"º linha:");
			linhas[i]=teclado.nextLine();
		}
		
		teclado.close();
		for (String linha : linhas) {	
			String resultado = criptografar(linha);
			System.out.println(resultado);
		}
	}
	
		public static String criptografar(String linha) {
			StringBuilder L = new StringBuilder(linha);
			
 // 1) letras minúsculas e maiúsculas devem ser deslocadas 3 posições para a direita.
			for (int j=0; j< L.length();j++) {
				int num = L.charAt(j);
				if ((num>=65 && num<=90) || (num>=97 && num<= 122)) {
					char caract = (char) (num + 3);
					L.setCharAt(j,caract);
				}
// 2) a linha deverá ser invertida				
			} L.reverse();
			
// 3) dividir o string pela metade e deslocar cada caractere da segunda metade uma posição para a esquerda na tabela ASCII			
			for (int j = (L.length()/2); j<L.length(); j++ ) {
				char caract = (char) ( L.charAt(j)-1);
				L.setCharAt(j, caract);
			}
			
			return L.toString();		
	}	
}


	



