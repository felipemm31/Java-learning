package felipe;

public class Ex5Logica {
    private static final int vazio = 0;
    private static final int parede = -1;

    public static int[][] menorCaminho(int[][] labirinto, int ratoLinha, int ratoColuna, int queijoLinha, int queijoColuna) {
        if (labirinto[ratoLinha][ratoColuna] == parede) {
            System.out.println("Erro: O rato não pode iniciar em uma parede.");
            return new int[0][0]; 
        }

        if (labirinto[queijoLinha][queijoColuna] == parede) {
            System.out.println("Erro: O queijo não pode ser colocado em uma parede.");
            return new int[0][0];
        }

        return busca(labirinto, ratoLinha, ratoColuna, queijoLinha, queijoColuna);
    }

    private static int[][] busca(int[][] labirinto, int ratoLinha, int ratoColuna, int queijoLinha, int queijoColuna) {
        int linhas = labirinto.length;
        int colunas = labirinto[0].length;
        boolean[][] visitado = new boolean[linhas][colunas];
        int[][][] caminhoAnterior = new int[linhas][colunas][2];

        // simulando uma fila de arrays
        int[][] fila = new int[linhas * colunas][2];
        int inicio = 0;
        int fim = 0;

        fila[fim++] = new int[]{ratoLinha, ratoColuna};
        visitado[ratoLinha][ratoColuna] = true;

        while (inicio < fim) {
            int[] atual = fila[inicio++];
            int atualLinha = atual[0];
            int atualColuna = atual[1];

            if (atualLinha == queijoLinha && atualColuna == queijoColuna) {
                return construirCaminho(caminhoAnterior, ratoLinha, ratoColuna, queijoLinha, queijoColuna);
            }

            // movimentos possíveis (baixo, cima, direita, esquerda)
            int[][] movimentos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] movimento : movimentos) {
                int novaLinha = atualLinha + movimento[0];
                int novaColuna = atualColuna + movimento[1];

                	if 	(novaLinha >= 0 //garante que a nova linha está está dentro dos limites inferiores da matriz
                		&& novaLinha < linhas //garante que a nova linha está está dentro dos limites superiores da matriz
                		&& novaColuna >= 0 //garante que a nova coluna está está dentro dos limites à esquerda da matriz
                		&& novaColuna < colunas //garante que a nova coluna está está dentro dos limites à direita da matriz
                		&& labirinto[novaLinha][novaColuna] != parede //garante que a nova posiçao não é uma parede
                		&& !visitado[novaLinha][novaColuna]) //garante que a posicao ainda nao foi visitada 
                		{
                    fila[fim++] = new int[]{novaLinha, novaColuna};
                    visitado[novaLinha][novaColuna] = true;
                    caminhoAnterior[novaLinha][novaColuna] = new int[]{atualLinha, atualColuna};
                }
            }
        }
        
        return new int[0][0]; //retorna um caminho vazio se não for encontrado nenhum caminho
        }

    private static int[][] construirCaminho(int[][][] caminhoAnterior, int ratoLinha, int ratoColuna, int queijoLinha, int queijoColuna) {
        int[][] caminho = new int[caminhoAnterior.length * caminhoAnterior[0].length][2];
        int contador = 0; //conta o numero de passos no caminho
        int[] posicaoAtual = {queijoLinha, queijoColuna};

        while (posicaoAtual[0] != ratoLinha || posicaoAtual[1] != ratoColuna) {
            caminho[contador++] = posicaoAtual;
            posicaoAtual = caminhoAnterior[posicaoAtual[0]][posicaoAtual[1]];
        }

        caminho[contador++] = new int[]{ratoLinha, ratoColuna};
        
        int[][] resultado = new int[contador][2];
        for (int i = 0; i < contador; i++) {
            resultado[i] = caminho[contador - i - 1];
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] labirinto = {
        		{0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0},
                {0, -1, 0, 0, -1, 0, -1, 0, -1, -1, 0},
                {0, 0, -1, 0, -1, 0, -1, 0, 0, 0, -1},
                {0, -1, 0, -1, 0, 0, 0, -1, -1, 0, 0},
                {0, 0, 0, -1, 0, -1, 0, 0, 0, -1, 0},
                {0, -1, 0, 0, 0, 0, 0, 0, -1, 0, 0}
        };

        int[][] caminho = menorCaminho(labirinto, 0, 0, 5, 10);
        for (int[] passo : caminho) {
            System.out.println("Linha: " + passo[0] + ", Coluna: " + passo[1]);
        }
    }
}
