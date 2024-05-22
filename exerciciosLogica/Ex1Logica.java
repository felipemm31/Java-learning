package exerciciosLogica;

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
	            nomeFormatado.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1).toLowerCase()).append(" ");
	            }
	        }
	        return nomeFormatado.toString().trim();
	    }

	    public static void main(String[] args) {
	    	
	        String[][] pessoas = {
	            {"felipe", "mendes"},
	            {"mARINA", "oliveira"},
	            {"JULIANA", ""},
	            {"ana maria", "soUZA"},
	            {"lucas", ""},
	            {"ROberTo", "caRloS"},
	            {"CassiO", "RamoS"},
	        };

	        for (String[] pessoa : pessoas) {
	            String nome = pessoa[0];
	            String sobrenome = pessoa[1];
	            String nomeFormatado = formatarNome(nome, sobrenome);
	            System.out.println(nomeFormatado);
	        }
	    }
	}