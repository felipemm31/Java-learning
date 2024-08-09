package felipe;

public class Ex4Logica {

    public static void main(String[] args) {
        String expressao = "( ( ( 1-2 ) + (2 +200 )*100)+(5+(4-2*2)))";
        double resultado = calcularExpressao(expressao);
        System.out.println("Resultado: " + resultado);
    }

    public static double calcularExpressao(String expressao) {
        
    	// ignora espaços na equação
    	expressao = expressao.replaceAll("\\s+", "");
    	
    	// remove os parênteses externos se houver
        expressao = removerParentesesExternos(expressao);

        // verifica se a expressão é um número
        if (isNumber(expressao)) {
            return Double.parseDouble(expressao);
        }

        // encontra o primeiro operador
        int index = encontrarProximoOperador(expressao);
        if (index == -1) {
            throw new IllegalArgumentException("Expressão inválida: " + expressao);
        }

        // divide a expressão em duas partes
        String parteEsquerda = expressao.substring(0, index);
        String parteDireita = expressao.substring(index + 1);

        // avalia as partes recursivamente
        double valorEsquerda = calcularExpressao(parteEsquerda);
        double valorDireita = calcularExpressao(parteDireita);

        // aplica o operador
        char operador = expressao.charAt(index);
        switch (operador) {
            case '+':
                return valorEsquerda + valorDireita;
            case '-':
                return valorEsquerda - valorDireita;
            case '*':
                return valorEsquerda * valorDireita;
            case '/':
                return valorEsquerda / valorDireita;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }

    private static String removerParentesesExternos(String expressao) {
        while (expressao.startsWith("(") && expressao.endsWith(")")) {
            int count = 0;
            boolean valid = true;
            for (int i = 0; i < expressao.length(); i++) {
                if (expressao.charAt(i) == '(') count++;
                if (expressao.charAt(i) == ')') count--;
                if (count == 0 && i != expressao.length() - 1) {
                    valid = false;
                    break;
                }
            }         
            if (valid) {
                expressao = expressao.substring(1, expressao.length() - 1);
            } else {
                break;
            }
        }
        return expressao;
    }

    private static boolean isNumber(String expressao) {
        try {
            Double.parseDouble(expressao);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int encontrarProximoOperador(String expressao) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < expressao.length(); i++) {
            char ch = expressao.charAt(i);
            if (ch == '(') {
            	count++;
            } else if (ch == ')') {
            	count--;
            } else if ((ch == '+' || ch == '-') && count == 0) {
                index = i;
            } else if ((ch == '*' || ch == '/') && count == 0 && index == -1) {
                index = i;
            }
        }
        return index;
    }
}

