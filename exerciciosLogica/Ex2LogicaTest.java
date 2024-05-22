package felipe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex2LogicaTest {
	
	@Test
	public void testFormatDancingSentence() {
		assertEquals("PrImEiRo tEsTe", Ex2Logica.formatSentence("primeiro teste"));
		assertEquals("SeGuNdO TeStE", Ex2Logica.formatSentence("SEGUNDO TESTE"));
		assertEquals("TeRcEiRo --- tEsTe 123.,OpS09d", Ex2Logica.formatSentence("TERCEIRO --- teste 123.,ops09d"));
	}

}
