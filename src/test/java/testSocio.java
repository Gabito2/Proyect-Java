import org.testng.annotations.Test;
import java.time.LocalDate;
import static org.testng.AssertJUnit.assertEquals;

public class testSocio {
    @Test
    void test01(){
        //Arrange
        LocalDate c1 = LocalDate.of(2002, 11, 25);
        Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
        Socio s2 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
        //Actual

        GestorDeSocios gs = null;

        gs.addSocio(s1);
        gs.addSocio(s2);

        //Assert
        assertEquals((gs),1);
    }
}
