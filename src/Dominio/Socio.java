package Dominio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import Exceptions.ExceptionApellidoNull;
import Exceptions.ExceptionApellidoVacio;
import Exceptions.ExceptionFechaSocioNull;
import Exceptions.ExceptionNombreNull;
import Exceptions.ExceptionNombreVacio;
import Exceptions.ExceptionNroSocioNegativo;
import Exceptions.ExceptionSocio;

public class Socio {
	private String nombre;
	private String apellido;
	private int nroSocio;
	private boolean tienePrestamo;
	private Genero generos;
	Calendar fechaSocio;
	//("Gabriel", "Rearte", 1, false, Genero.MASCULINO, c1)
	public Socio(String nombre, String apellido, int nroSocio,  
			boolean tienePrestamos, Genero miGenero, Calendar fechaSocio) throws ExceptionSocio{
		super();
		if(nombre == null)
			throw new ExceptionNombreNull("Error por el nombre Nula");
		if(nombre.equals(""))
			throw new ExceptionNombreVacio("Error por el nombre Vacio");
		this.nombre = nombre;
		if(apellido == null)
			throw new ExceptionApellidoNull("Error por el apellido Nula");
		if(apellido.equals(""))
			throw new ExceptionApellidoVacio("Error por el apellido Vacio");
		this.apellido = apellido;
		if(fechaSocio == null)
			throw new ExceptionFechaSocioNull("Error por la fecha nacimiento es Nula");
		this.fechaSocio = fechaSocio;
		this.generos = miGenero;
		if(nroSocio < 0)
			throw new ExceptionNroSocioNegativo("Error por el numero de socio negativo");
		this.nroSocio = nroSocio;
		this.tienePrestamo = tienePrestamos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}

	public boolean isTienePrestamo() {
		return tienePrestamo;
	}

	public void setTienePrestamo(boolean tienePrestamo) {
		this.tienePrestamo = tienePrestamo;
	}

	public Genero getGeneros() {
		return generos;
	}

	public void setGeneros(Genero generos) {
		this.generos = generos;
	}

	public Calendar getFechaSocio() {
		return fechaSocio;
	}

	public void setFechaSocio(Calendar fechaSocio) {
		this.fechaSocio = fechaSocio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, fechaSocio, generos, nombre, nroSocio, tienePrestamo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(fechaSocio, other.fechaSocio)
				&& generos == other.generos && Objects.equals(nombre, other.nombre) && nroSocio == other.nroSocio
				&& tienePrestamo == other.tienePrestamo;
	}

	public int getEdad() {
		Calendar actual= Calendar.getInstance();
		fechaSocio = new GregorianCalendar();
		int edad = actual.get(Calendar.YEAR) - fechaSocio.get(Calendar.YEAR);
		return edad;
	}

	@Override
	public String toString() {
		return nroSocio + "(" + generos + ")" + apellido + "," + nombre 
				+ "(" +fechaSocio + ")" + "- Prestamos =" + tienePrestamo;
	}
	
	
	
}
