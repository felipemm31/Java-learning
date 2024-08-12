package felipe;

public class Ex1Logica {
	
	  public static String formatarNome(String nome, String sobrenome) {
	        String nomeFormatado = formatarParteNome(nome);
	        String sobrenomeFormatado = formatarParteNome(sobrenome);
	        
	        if(sobrenomeFormatado.isEmpty()) {
	            return nomeFormatado;
	        }else {
	            return sobrenomeFormatado + ", " + nomeFormatado;
	        }
	    }

	    static String formatarParteNome(String parteNome) {
	        if (parteNome.isEmpty()) {
	            return "";
	        }
	        String[] palavras = parteNome.split(" ");
	        StringBuilder nomeFormatado = new StringBuilder();
	        for (String palavra : palavras) {
	            if (!palavra.isEmpty()) {
	            nomeFormatado.append(Character.toUpperCase(palavra.charAt(0)))
	            .append(palavra.substring(1).toLowerCase()).append(" ");
	            }
	        }
	        return nomeFormatado.toString().trim();
	    }
	    
	    public static void ordenarNomes(String[][] nomes) {
	        for (int i = 0; i < nomes.length; i++) {
	            for (int j = i + 1; j < nomes.length; j++) {
	                String sobrenome1 = nomes[i][1];
	                String sobrenome2 = nomes[j][1];
	                
	                // se os sobrenomes são vazios, comparar pelos nomes
	                if (sobrenome1.isEmpty()) sobrenome1 = nomes[i][0];
	                if (sobrenome2.isEmpty()) sobrenome2 = nomes[j][0];
	                
	                if (sobrenome1.compareToIgnoreCase(sobrenome2) > 0) {
	                    String[] temp = nomes[i];
	                    nomes[i] = nomes[j];
	                    nomes[j] = temp;
	                }
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	    	
	        String[][] pessoas = {
	            {"felipe", "mendes"},
	            {"mARINA", "oliveira"},
	            {"JULIANA", ""},
	            {"ana maria", "MEDEL"},
	            {"lucas", ""},
	            {"ROberTo", "caRloS"},
	            {"CassiO", "RamoS"},
	        };
	        
	        ordenarNomes(pessoas);

	        for (String[] pessoa : pessoas) {
	            String nome = pessoa[0];
	            String sobrenome = pessoa[1];
	            String nomeFormatado = formatarNome(nome, sobrenome);
	            System.out.println(nomeFormatado);
	        }
	    }
	}
