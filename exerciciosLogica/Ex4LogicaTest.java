package felipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class Ex4LogicaTest {

    @Test
    public void testSomar() {
        String expressao = "1 + 2 + 3";
        double resultado = Ex4Logica.calcularExpressao(expressao);
        assertEquals(6.0, resultado);
    }

    @Test
    public void testSubtrair() {
        String expressao = "5 - 3";
        double resultado = Ex4Logica.calcularExpressao(expressao);
        assertEquals(2.0, resultado);
    }

    @Test
    public void testMultiplicar() {
        String expressao = "2 * 3";
        double resultado = Ex4Logica.calcularExpressao(expressao);
        assertEquals(6.0, resultado);
    }

    @Test
    public void testDividir() {
        String expressao = "10 / 2";
        double resultado = Ex4Logica.calcularExpressao(expressao);
        assertEquals(5.0, resultado);
    }

    @Test
    public void testExpressaoComposta() {
        String expressao = "(1 + 2) * (3 + 4)";
        double resultado = Ex4Logica.calcularExpressao(expressao);
        assertEquals(21.0, resultado);
    }

    @Test
    public void testExpressaoComEspacos() {
        String expressao = "( 1 + 2 ) * ( 3 + 4 )";
        double resultado = Ex4Logica.calcularExpressao(expressao);
        assertEquals(21.0, resultado);
    }

    @Test
    public void testExpressaoComParentesesExternos() {
        String expressao = "(((((1 + 2)))))";
        double resultado = Ex4Logica.calcularExpressao(expressao);
        assertEquals(3.0, resultado);
    }

    @Test
    public void testExpressaoInvalida() {
        String expressao = "1 + 4 / -5";
        assertThrows(IllegalArgumentException.class, () -> {
            Ex4Logica.calcularExpressao(expressao);
        });
    }

}
