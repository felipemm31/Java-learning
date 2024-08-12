package felipe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Ex1LogicaTest {

    @Test
    public void testFormatarNome_Completo() {
        assertEquals("Mendes, Felipe", Ex1Logica.formatarNome("felipe", "mendes"));
        assertEquals("Oliveira, Marina", Ex1Logica.formatarNome("mARINA", "oliveira"));
        assertEquals("Souza, Ana Maria", Ex1Logica.formatarNome("ana maria", "soUZA"));
        assertEquals("Carlos, Roberto", Ex1Logica.formatarNome("ROberTo", "caRloS"));
        assertEquals("Ramos, Cassio", Ex1Logica.formatarNome("CassiO", "RamoS"));
    }

    @Test
    public void testFormatarNome_SemSobrenome() {
        assertEquals("Juliana", Ex1Logica.formatarNome("JULIANA", ""));
        assertEquals("Lucas", Ex1Logica.formatarNome("lucas", ""));
    }

    @Test
    public void testFormatarParteNome() {
        assertEquals("Felipe", Ex1Logica.formatarParteNome("felipe"));
        assertEquals("Marina", Ex1Logica.formatarParteNome("mARINA"));
        assertEquals("Ana Maria", Ex1Logica.formatarParteNome("ana maria"));
        assertEquals("Roberto", Ex1Logica.formatarParteNome("ROberTo"));
        assertEquals("Cassio", Ex1Logica.formatarParteNome("CassiO"));
        assertEquals("Carlos", Ex1Logica.formatarParteNome("caRloS"));
    }

    @Test
    public void testFormatarParteNome_Empty() {
        assertEquals("", Ex1Logica.formatarParteNome(""));
    }
    
    @Test
    public void testOrdenarNomes() {
        
        String[][] pessoas = {
            {"felipe", "mendes"},
            {"mARINA", "oliveira"},
            {"JULIANA", ""},
            {"ana maria", "soUZA"},
            {"lucas", ""},
            {"ROberTo", "caRloS"},
            {"CassiO", "RamoS"},
        };

        String[][] pessoasOrdenadas = {
        		{"ROberTo", "caRloS"},
        		{"JULIANA", ""},
        		{"lucas", ""},
        		{"felipe", "mendes"},
        		{"mARINA", "oliveira"},
        		{"CassiO", "RamoS"},
        		{"ana maria", "soUZA"}                   
        };

        Ex1Logica.ordenarNomes(pessoas);

        assertArrayEquals(pessoasOrdenadas, pessoas, "Os nomes não foram ordenados corretamente.");
    }
    
    @Test
    public void testOrdenarNomesSemSobrenomes() {
        
        String[][] pessoas = {
            {"JULIANA", ""},
            {"lucas", ""},
            {"hugo", ""},
            {"alvaro", ""}
        };

        String[][] pessoasOrdenadas = {
        		{"alvaro", ""},
        		{"hugo", ""},
        		{"JULIANA", ""},
        		{"lucas", ""}
        };

        Ex1Logica.ordenarNomes(pessoas);

        assertArrayEquals(pessoasOrdenadas, pessoas, "Os nomes não foram ordenados corretamente.");
    }
    
    @Test
    public void testOrdenarSobrenomesComAMesmaLetraInicial() {
    	
    	String[][] pessoas = {
                {"joao", "Alves"},
                {"joao", "Alvarenga"},
                {"joao", "Amado"},
                {"joao", "Almeida"}
            };

            String[][] pessoasOrdenadas = {
            		{"joao", "Almeida"},
            		{"joao", "Alvarenga"},
            		{"joao", "Alves"},
            		{"joao", "Amado"}
            };

            Ex1Logica.ordenarNomes(pessoas);

            assertArrayEquals(pessoasOrdenadas, pessoas, "Os nomes não foram ordenados corretamente.");
        }
    
    @Test
    public void testOrdenarNomesComAMesmaLetraInicial() {
    	
    	String[][] pessoas = {
                {"joao", ""},
                {"jaspion", ""},
                {"jose", ""},
                {"james", ""}
            };

            String[][] pessoasOrdenadas = {
            		{"james", ""},
            		{"jaspion", ""},
            		{"joao", ""},
            		{"jose", ""}
            };

            Ex1Logica.ordenarNomes(pessoas);

            assertArrayEquals(pessoasOrdenadas, pessoas, "Os nomes não foram ordenados corretamente.");
    }
}



