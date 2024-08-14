package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Dominio.Genero;
import Dominio.GestorDeSocios;
import Dominio.Socio;
import Exceptions.ExceptionSocio;


class TestSocio{

	@Test
	@Order(1)
	@DisplayName("testAgregarSocio")
	void test01() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(2002, 11, 25);
		Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		//Actual
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		//Assert
		assertEquals(gs.getsocio().size(),1);
	}
	
	@Test
	@Order(2)
	@DisplayName("testEliminarSocio")
	void test02() throws ExceptionSocio{
	    Calendar c1 = new GregorianCalendar(1900, 11, 25);
	    Calendar c2 = new GregorianCalendar(2022, 11, 25);
	    Calendar c3 = new GregorianCalendar(2000, 11, 25);
	    //Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
	    Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c2);
	    Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c3); 
	    
	    GestorDeSocios gs = GestorDeSocios.getInstancia();
	    
	   //gs.agregarSocio(s1);
	    gs.agregarSocio(s2);
	    gs.agregarSocio(s3);
	    
	    assertEquals(3, gs.getCantidadDeSocios());
	    
	    gs.eliminarSociosConEdadMenorA(18);
	    assertEquals(0, gs.getCantidadDeSocios());
	}
	
	@Test
	@Order(3)
	@DisplayName("testBuscarSocioPorNumero")
	void test03() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(2002, 11, 25);
		Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c1);
		Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c1); 
		
		//Actual 
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		
		//Assert
		assertTrue(gs.existeSocio(1));
		assertTrue(gs.existeSocio(3));
		assertTrue(gs.existeSocio(2));
		//assertTrue(gs.existeSocio(4));
		gs.LimpiarTodo();
	}
	
	@Test
	@Order(4)
	@DisplayName("testBuscarSocioPorGenero")
	void test04() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(2002, 11, 25);
		Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c1);
		Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c1); 
		//Actual
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		Predicate<Socio> p = (Socio s)->s.getGeneros().equals(Genero.FEMENINO);
		ArrayList<Socio> actual = gs.getSociosPorGenero(p);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		esperado.add(s2);
		//Assert
		assertEquals(esperado,actual);
		gs.LimpiarTodo();
	}
	
	@Test
	@Order(5)
	@DisplayName("testGetSociosOrdenadosPorEdad")
	void test05() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(2022, 11, 25);
		Calendar c2 = new GregorianCalendar(1989, 11, 25);
		Calendar c3 = new GregorianCalendar(2002, 11, 25);
		
		Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c2);
		Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c3);
		//Actual
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		
		Comparator<Socio> comp = (Socio socio1, Socio socio2)->(socio1.getEdad() - socio2.getEdad());
		
		ArrayList<Socio> actual = gs.getSociosOrdenadosPorEdad(comp);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s1);
		esperado.add(s2);
		esperado.add(s3);
		
		//Assert
		assertEquals(esperado, actual);
		gs.LimpiarTodo();
	}
	
	@Test
	@Order(6)
	@DisplayName("testGetSociosMayoresDe")
	void test06() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(1994, 11, 25);
		Calendar c2 = new GregorianCalendar(1989, 11, 25);
		Calendar c3 = new GregorianCalendar(1997, 11, 25);
		Calendar c4 = new GregorianCalendar(1991, 11, 25);
		
		Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c2);
		Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c3);
		Socio s4 = new Socio("Gabriel", "Fonzalida", 1, false, Genero.MASCULINO, c4);
		
		//Actual
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		Predicate<Socio> p = (Socio s)->s.getEdad() > 25;
		ArrayList<Socio> actual = gs.getSociosPorGenero(p);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s2);
		esperado.add(s4);
		
		//Assert
		assertEquals(esperado, actual);
		gs.LimpiarTodo();
	}
	
	@Test
	@Order(7)
	@DisplayName("testGetPromedioEdad")
	void test07() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(1994, 11, 25);
		Calendar c2 = new GregorianCalendar(1989, 11, 25);
		Calendar c3 = new GregorianCalendar(1997, 11, 25);
		Calendar c4 = new GregorianCalendar(1991, 11, 25);
		
		Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c2);
		Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c3);
		Socio s4 = new Socio("Gabriel", "Fonzalida", 1, false, Genero.MASCULINO, c4);
		//Actual
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		double esperado = (s1.getEdad()+s2.getEdad()+s3.getEdad()+s4.getEdad())/4;
		//Assert
		assertEquals(esperado,gs.getPromedioEdad());
		gs.LimpiarTodo();
	}
	
	@Test
	@Order(8)
	@DisplayName("testExisteSocioConNombre")
	void test08() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(1994, 11, 25);
		Calendar c2 = new GregorianCalendar(1989, 11, 25);
		Calendar c3 = new GregorianCalendar(1997, 11, 25);
		Calendar c4 = new GregorianCalendar(1991, 11, 25);
		
		Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c2);
		Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c3);
		Socio s4 = new Socio("Gabriel", "Fonzalida", 1, false, Genero.MASCULINO, c4);
		//Actual
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		//gs.agregarSocio(s5);
		
		Predicate<Socio> p = (Socio s)->s.getNombre().equals("Juan");

		//Assert
		assertTrue(gs.existeSocioConNombre(p));
		gs.LimpiarTodo();
	}
	
	@Test
	@Order(9)
	@DisplayName("testEliminarSociosConEdadMenorA")
	void test09() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(1994,10,15);
		Calendar c2 = new GregorianCalendar(1989,12,04);
		Calendar c3 = new GregorianCalendar(1997,05,11);
		Calendar c4 = new GregorianCalendar(1991,06,22);
		
		Socio s1 = new Socio("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c2);
		Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c3);
		Socio s4 = new Socio("Gabriel", "Fonzalida", 1, false, Genero.MASCULINO, c4); 
		//Actual
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		Predicate<Socio> p = (Socio s)->s.getEdad() < 21;
		//ArrayList<Socio> actual = gs.eliminarSociosConEdadMenorA(p);
		gs.eliminarSociosConEdadMenorA(p);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s2);
		esperado.add(s4);

		//Assert
	    assertEquals(gs.getsocio().size(), 2);
	    assertEquals(gs.getsocio(), esperado);
		
		gs.LimpiarTodo();
	}
	
	@Test
	@Order(10)
	@DisplayName("getSociosConPrestamosActivos")
	void test10() throws ExceptionSocio{
		//Arrange
		Calendar c1 = new GregorianCalendar(1994,10,15);
		Calendar c2 = new GregorianCalendar(1989,12,04);
		Calendar c3 = new GregorianCalendar(1997,05,11);
		Calendar c4 = new GregorianCalendar(1991,06,22);
		Socio s1 = new Socio("Gabriel", "Rearte", 1, true, Genero.MASCULINO, c1);
		Socio s2 = new Socio("Mariana", "Benitez", 2, true, Genero.FEMENINO, c2);
		Socio s3 = new Socio("Juan", "Perez", 3, false, Genero.OTRO, c3);
		Socio s4 = new Socio("Gabriel", "Fonzalida", 1, false, Genero.MASCULINO, c4);
		//Actual
		GestorDeSocios gs = GestorDeSocios.getInstancia();
		gs.agregarSocio(s1);
		gs.agregarSocio(s2);
		gs.agregarSocio(s3);
		gs.agregarSocio(s4);
		
		Predicate<Socio> p = (Socio s)->s.isTienePrestamo();
		ArrayList<Socio> actual = gs.getSociosConPrestamosActivos(p);
		ArrayList<Socio> esperado = new ArrayList<Socio>();
		
		esperado.add(s1);
		esperado.add(s2);
		//Assert
		assertEquals(esperado,actual);
		gs.LimpiarTodo();
	}
	
}
