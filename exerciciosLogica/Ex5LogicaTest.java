package felipe;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Ex5LogicaTest {

    int[][] labirinto = {
    		{0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0},
            {0, -1, 0, 0, -1, 0, -1, 0, -1, -1, 0},
            {0, 0, -1, 0, -1, 0, -1, 0, 0, 0, -1},
            {0, -1, 0, -1, 0, 0, 0, -1, -1, 0, 0},
            {0, 0, 0, -1, 0, -1, 0, 0, 0, -1, 0},
            {0, -1, 0, 0, 0, 0, 0, 0, -1, 0, 0}
    };
    
    @Test
    public void testCaminhos() { //PRIMEIRO TESTE (RATO EM 0,0 E QUEIJO EM 5,10) 
    	
        int[][] caminho1 = Ex5Logica.menorCaminho(labirinto, 0, 0, 5, 10);
        	System.out.println("TESTE :: Rato em (0,0) e Queijo em (5,10):\n");
        for (int[] passo : caminho1) {
            System.out.println("Linha: " + passo[0] + ", Coluna: " + passo[1]);
        } System.out.println("________________________________________________\n");
        
        int[][] caminhoEsperado1 = {
        		{0,0}, {1,0}, {2,0}, {3,0}, {4,0}, {4,1}, {4,2}, {5,2}, {5,3}, {5,4}, {4,4}, {3,4}, {3,5}, 
        		{2,5}, {1,5}, {0,5}, {0,6}, {0,7}, {1,7}, {2,7}, {2,8}, {2,9}, {3,9}, {3,10}, {4,10}, {5,10}
            };
        
        
        //SEGUNDO TESTE (RATO EM 5,2 E QUEIJO EM 3,5)
        int[][] caminho2 = Ex5Logica.menorCaminho(labirinto, 5, 2, 3, 5);
        System.out.println("TESTE :: Rato em (5,2) e Queijo em (3,5):\n");
        for (int[] passo : caminho2) {
            System.out.println("Linha: " + passo[0] + ", Coluna: " + passo[1]);
        } System.out.println("________________________________________________\n");
        
        int[][] caminhoEsperado2 = {
        		{5,2}, {5,3}, {5,4}, {4,4}, {3,4}, {3,5}
        };
        
            assertArrayEquals(caminhoEsperado1, caminho1);
            assertArrayEquals(caminhoEsperado2, caminho2);
    }

    @Test
	public void testParede() {
		
    	//O rato é colocado dentro de uma parede (0,3)
    	System.out.println("TESTE :: Rato inicia em uma parede:\n");
    	int[][] caminho1 = Ex5Logica.menorCaminho(labirinto, 0, 3, 5, 8);
    	assertEquals(0, caminho1.length);
    	
    	System.out.println("________________________________________________\n");
    	
    	//O rato inicia em (0,0) e o queijo é colocado dentro de uma parede (5,8)
    	System.out.println("TESTE :: Queijo em uma parede:\n");
    	int[][] caminho2 = Ex5Logica.menorCaminho(labirinto, 0, 0, 5, 8);
    	assertEquals(0, caminho2.length);
	}
    
    int[][] labirinto2 = {
    		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    
    @Test
    public void testLabirintoAberto() {
    	
    	//Rato inicia em 0,0 e o queijo está em 5,10
    	int[][] caminho3 = Ex5Logica.menorCaminho(labirinto2, 0, 0, 5, 10);
    	 System.out.println("TESTE :: Rato em (0,0) e Queijo em (5,10) em Labirinto sem paredes:\n");
         for (int[] passo : caminho3) {
             System.out.println("Linha: " + passo[0] + ", Coluna: " + passo[1]);
         } System.out.println("________________________________________________\n");
         
    	int[][] caminhoEsperado3 = {
    			{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{5,1},{5,2},{5,3},{5,4},{5,5},{5,6},
    			{5,7},{5,8},{5,9},{5,10}
    	};
    	assertArrayEquals(caminhoEsperado3, caminho3);
    	
    }
    
}