package felipe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex3LogicaTest {

	@Test
	public void testCriptografar() {
        assertEquals("1 hvugV", Ex3Logica.criptografar("Teste 1"));
        assertEquals("hwqhpdyrqqfpcvugV", Ex3Logica.criptografar("Testando novamente"));
        assertEquals("C", Ex3Logica.criptografar("A"));
        assertEquals("D", Ex3Logica.criptografar("B"));
        assertEquals("E", Ex3Logica.criptografar("C"));
        assertEquals("c", Ex3Logica.criptografar("a"));
        assertEquals("d", Ex3Logica.criptografar("b"));
        assertEquals("e", Ex3Logica.criptografar("c"));
        
	}

    @Test
    public void testCriptografarWithEmptyString() {
        assertEquals("", Ex3Logica.criptografar(""));
    }
}

