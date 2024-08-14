package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Dominio.Genero;
import Dominio.Socio;
import Exceptions.ExceptionApellidoNull;
import Exceptions.ExceptionApellidoVacio;
import Exceptions.ExceptionFechaSocioNull;
import Exceptions.ExceptionNombreNull;
import Exceptions.ExceptionNombreVacio;
import Exceptions.ExceptionNroSocioNegativo;

class TestException {

	@Test
	@Order(1)
	@DisplayName("Constructor con datos validos")
	void test01ConstructorConDatosValidos() {
		try {
			Calendar c1 = new GregorianCalendar(1990, 10, 13);
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
	@Order(2)
	@DisplayName("Constructor con nombre null")
	void test02ConstructorNombreNull() {
		try {
			Calendar c1 = new GregorianCalendar(1990, 10, 13);
			Socio s = new Socio(null, "Rearte", 1, false, Genero.MASCULINO, c1);
		} catch (ExceptionNombreNull ex) {
			assertEquals("Error por el nombre Nula", ex.getMessage());
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
		}
	}

	@Test
	@Order(3)
	@DisplayName("Constructor con nombre vacio")
	void test03ConstructorNombreVacio() {
		try {
			Calendar c1 = new GregorianCalendar(1990, 10, 13);
			Socio s = new Socio("", "Rearte", 1, false, Genero.MASCULINO, c1);
		} catch (ExceptionNombreVacio ex) {
			assertEquals("Error por el nombre Vacio", ex.getMessage());
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
		}
	}

	@Test
	@Order(4)
	@DisplayName("Constructor con apellido null")
	void test04ConstructorApellidoNull() {
		try {
			Calendar c1 = new GregorianCalendar(1990, 10, 13);
			Socio s = new Socio("Gabriel", null, 1, false, Genero.MASCULINO, c1);
		} catch (ExceptionApellidoNull ex) {
			assertEquals("Error por el apellido Nula", ex.getMessage());
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
		}
	}

	@Test
	@Order(5)
	@DisplayName("Constructor con apellido vacio")
	void test05ConstructorApellidoVacio() {
		try {
			Calendar c1 = new GregorianCalendar(1990, 10, 13);
			Socio s = new Socio("Gabriel", "", 1, false, Genero.MASCULINO, c1);
		} catch (ExceptionApellidoVacio ex) {
			assertEquals("Error por el apellido Vacio", ex.getMessage());
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
		}
	}

	@Test
	@Order(6)
	@DisplayName("Constructor con fecha null")
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
	@Order(7)
	@DisplayName("Constructor con numero de socio negativo")
	void test07ConstructorNroSocioNegativo() {
		try {
			Calendar c1 = new GregorianCalendar(1990, 10, 13);
			Socio s = new Socio("Gabriel", "Rearte", -1, false, Genero.MASCULINO, c1);
		} catch (ExceptionNroSocioNegativo ex) {
			assertEquals("Error por el numero de socio negativo", ex.getMessage());
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
		}
	}

	@Test
	@Order(8)
	@DisplayName("Constructor con datos no validos")
	void test08ConstructorConDatosNoValidos() {
		try {
			Calendar c1 = new GregorianCalendar(1990, 10, 13);
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

	/*
	 * @Test
	 * 
	 * @Order(9)
	 * 
	 * @DisplayName("ExceptionSocioNombreNull hereda de ExceptionSocio")
	 * void test09Constructor_NombreNull() {
	 * try {
	 * Calendar c1 = new GregorianCalendar(1990,10,13);
	 * Socio s = new Socio(null , "Rearte", 1, false, Genero.MASCULINO, c1);
	 * fail("Esta linea no deberia correrse");
	 * } catch (ExceptionSocio ex) {
	 * assertEquals("Error por el nombre Nula", ex.getMessage());
	 * } catch (Exception ex) {
	 * fail("Esta linea no deberia correrse");
	 * }
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @Order(10)
	 * 
	 * @DisplayName("ExceptionSocioNombreVacio hereda de ExceptionSocio")
	 * void test10Constructor_NombreVacio() {
	 * try {
	 * Calendar c1 = new GregorianCalendar(1990,10,13);
	 * Socio s = new Socio("","Jimenez",c1,Genero.MASCULINO,1,true);
	 * fail("Esta linea no deberia correrse");
	 * } catch (ExceptionSocio ex) {
	 * assertEquals("Error por el nombre Vacio", ex.getMessage());
	 * }catch (Exception ex) {
	 * fail("Esta linea no deberia correrse");
	 * }
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @Order(11)
	 * 
	 * @DisplayName("ExceptionSocioApellidoNull hereda de ExceptionSocio")
	 * void test11Constructor_ApellidoNull() {
	 * try {
	 * Calendar c1 = new GregorianCalendar(1990,10,13);
	 * Socio s = new Socio("Carlos",null,c1,Genero.MASCULINO,1,true);
	 * fail("Esta linea no deberia correrse");
	 * } catch (ExceptionSocio ex) {
	 * assertEquals("Error por el apellido Nula", ex.getMessage());
	 * }catch (Exception ex) {
	 * fail("Esta linea no deberia correrse");
	 * }
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @Order(12)
	 * 
	 * @DisplayName("ExceptionSocioApellidoVacio hereda de ExceptionSocio")
	 * void test12Constructor_ApellidoVacio() {
	 * try {
	 * Calendar c1 = new GregorianCalendar(1990,10,13);
	 * Socio s = new Socio("Carlos","",c1,Genero.MASCULINO,1,true);
	 * fail("Esta linea no deberia correrse");
	 * } catch (ExceptionSocio ex) {
	 * assertEquals("Error por el apellido Vacio", ex.getMessage());
	 * }catch (Exception ex) {
	 * fail("Esta linea no deberia correrse");
	 * }
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @Order(13)
	 * 
	 * @DisplayName("ExceptionSocioFechaNula hereda de ExceptionSocio")
	 * void test13Constructor_FechaNula() {
	 * try {
	 * //Calendar c1 = new GregorianCalendar(1990,10,13);
	 * Socio s = new Socio("Carlos","Jimenez",null,Genero.MASCULINO,1,true);
	 * fail("Esta linea no deberia correrse");
	 * } catch (ExceptionSocio ex) {
	 * assertEquals("Error por la fecha nacimiento es Nula", ex.getMessage());
	 * }catch (Exception ex) {
	 * fail("Esta linea no deberia correrse");
	 * }
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @Order(14)
	 * 
	 * @DisplayName("ExceptionSocioFechaNula hereda de ExceptionSocio")
	 * void test14Constructor_NroSocioNegativo() {
	 * try {
	 * Calendar c1 = new GregorianCalendar(1990,10,13);
	 * Socio s = new Socio("Carlos","Jimenez",c1,Genero.MASCULINO,-1,true);
	 * fail("Esta linea no deberia correrse");
	 * } catch (ExceptionSocio ex) {
	 * assertEquals("Error por el numero de socio negativo", ex.getMessage());
	 * }catch (Exception ex) {
	 * fail("Esta linea no deberia correrse");
	 * }
	 * }
	 */
}
