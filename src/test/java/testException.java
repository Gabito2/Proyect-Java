import Exceptions.*;
import net.bytebuddy.asm.Advice;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

public class testException {

    @Test
    public void test01ConstructorConDatosValidos() {
        try {
            LocalDate c1 = LocalDate.of(1990, 10, 13);
            Socio socio = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
            assertEquals("Gabriel", socio.getNombre());
            assertEquals("Rearte", socio.getApellido());
            assertEquals(c1, socio.getFechaSocio());
            assertEquals(Genero.MASCULINO, socio.getGeneros());
            assertEquals(false, socio.isTienePrestamo());

        } catch (Exception ex) {
            fail("Esta linea no deberia correrse");
        }
    }

    @Test
    void test02ConstructorNombreNull() {
        try {
            LocalDate c1 = LocalDate.of(1990, 10, 13);
            Socio s = new Socio(null, "Rearte", 1, false, Genero.MASCULINO, c1);
        } catch (ExceptionNombreNull ex) {
            assertEquals("Error por el nombre Nula", ex.getMessage());
        } catch (Exception ex) {
            fail("Esta linea no deberia correrse");
        }
    }

    @Test
    void test03ConstructorNombreVacio() {
        try {
            LocalDate c1 = LocalDate.of(1990, 10, 13);
            Socio s = new Socio("", "Rearte", 1, false, Genero.MASCULINO, c1);
        } catch (ExceptionNombreVacio ex) {
            assertEquals("Error por el nombre Vacio", ex.getMessage());
        } catch (Exception ex) {
            fail("Esta linea no deberia correrse");
        }
    }

    @Test
    void test04ConstructorApellidoNull() {
        try {
            LocalDate c1 = LocalDate.of(1990, 10, 13);
            Socio s = new Socio("Gabriel", null, 1, false, Genero.MASCULINO, c1);
        } catch (ExceptionApellidoNull ex) {
            assertEquals("Error por el apellido Nula", ex.getMessage());
        } catch (Exception ex) {
            fail("Esta linea no deberia correrse");
        }
    }

    @Test
    void test05ConstructorApellidoVacio() {
        try {
            LocalDate c1 = LocalDate.of(1990, 10, 13);
            Socio s = new Socio("Gabriel", "", 1, false, Genero.MASCULINO, c1);
        } catch (ExceptionApellidoVacio ex) {
            assertEquals("Error por el apellido Vacio", ex.getMessage());
        } catch (Exception ex) {
            fail("Esta linea no deberia correrse");
        }
    }

    @Test
    void test06ConstructorFechaNula() {
        try {
            // Calendar c1 = new GregorianCalendar(1990,10,13);
            Socio s = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, null);
        } catch (ExceptionFechaSocioNull ex) {
            assertEquals("Error por la fecha nacimiento es Nula", ex.getMessage());
        } catch (Exception ex) {
            fail("Esta linea no deberia correrse");
        }
    }

    @Test
    void test07ConstructorNroSocioNegativo() {
        try {
            LocalDate c1 = LocalDate.of(1990, 10, 13);
            Socio s = new Socio("Gabriel", "Rearte", -1, false, Genero.MASCULINO, c1);
        } catch (ExceptionNroSocioNegativo ex) {
            assertEquals("Error por el numero de socio negativo", ex.getMessage());
        } catch (Exception ex) {
            fail("Esta linea no deberia correrse");
        }
    }

    @Test
    void test08ConstructorConDatosNoValidos() {
        try {
            LocalDate c1 = LocalDate.of(1990, 10, 13);
            Socio s = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
        } catch (ExceptionNombreNull ex) {
            assertEquals("Error por el nombre Nula", ex.getMessage());
        } catch (ExceptionNombreVacio ex) {
            assertEquals("Error por el nombre Vacio", ex.getMessage());
        } catch (ExceptionApellidoNull ex) {
            assertEquals("Error por el apellido Nula", ex.getMessage());
        } catch (ExceptionApellidoVacio ex) {
            assertEquals("Error por el apellido Vacio", ex.getMessage());
        } catch (ExceptionFechaSocioNull ex) {
            assertEquals("Error por la fecha nacimiento es Nula", ex.getMessage());
        } catch (ExceptionNroSocioNegativo ex) {
            assertEquals("Error por el numero de socio negativo", ex.getMessage());
        } catch (Exception ex) {
            fail("Esta linea no deberia correrse");
        }
    }


      @Test
      void test09Constructor_NombreNull() {
      try {
      LocalDate c1 = LocalDate.of(1990,10,13);
      Socio s = new Socio(null , "Rearte", 1, false, Genero.MASCULINO, c1);
      fail("Esta linea no deberia correrse");
      } catch (ExceptionSocio ex) {
      assertEquals("Error por el nombre Nula", ex.getMessage());
      } catch (Exception ex) {
      fail("Esta linea no deberia correrse");
      }
      }


      @Test

      void test10Constructor_NombreVacio() {
      try {
      LocalDate c1 = LocalDate.of(1990,10,13);
      Socio s = new Socio("","Jimenez", 1, false, Genero.MASCULINO, c1);
      fail("Esta linea no deberia correrse");
      } catch (ExceptionSocio ex) {
      assertEquals("Error por el nombre Vacio", ex.getMessage());
      }catch (Exception ex) {
      fail("Esta linea no deberia correrse");
      }
      }


      @Test

      void test11Constructor_ApellidoNull() {
      try {
      LocalDate c1 = LocalDate.of(1990,10,13);
      Socio s = new Socio("Carlos",null, 1, false, Genero.MASCULINO, c1);
      fail("Esta linea no deberia correrse");
      } catch (ExceptionSocio ex) {
      assertEquals("Error por el apellido Nula", ex.getMessage());
      }catch (Exception ex) {
      fail("Esta linea no deberia correrse");
      }
      }


      @Test

      void test12Constructor_ApellidoVacio() {
      try {
      LocalDate c1 = LocalDate.of(1990,10,13);
      Socio s = new Socio("Carlos","", 1, false, Genero.MASCULINO, c1);
      fail("Esta linea no deberia correrse");
      } catch (ExceptionSocio ex) {
      assertEquals("Error por el apellido Vacio", ex.getMessage());
      }catch (Exception ex) {
      fail("Esta linea no deberia correrse");
      }
      }


      @Test

      void test13Constructor_FechaNula() {
      try {
      //Calendar c1 = new GregorianCalendar(1990,10,13);
      Socio s = new Socio("Carlos","Jimenez",1, false, Genero.MASCULINO, null);
      fail("Esta linea no deberia correrse");
      } catch (ExceptionSocio ex) {
      assertEquals("Error por la fecha nacimiento es Nula", ex.getMessage());
      }catch (Exception ex) {
      fail("Esta linea no deberia correrse");
      }
      }


      @Test

      void test14Constructor_NroSocioNegativo() {
      try {
      LocalDate c1 = LocalDate.of(1990,10,13);
      Socio s = new Socio("Carlos","Jimenez", 1, false, Genero.MASCULINO, c1);
      fail("Esta linea no deberia correrse");
      } catch (ExceptionSocio ex) {
      assertEquals("Error por el numero de socio negativo", ex.getMessage());
      }catch (Exception ex) {
      fail("Esta linea no deberia correrse");
      }
      }
}