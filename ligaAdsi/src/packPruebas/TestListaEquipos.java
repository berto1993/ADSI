package packPruebas;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Equipo;
import packModelo.ListaEquipos;

public class TestListaEquipos {

	ListaEquipos lista;
	@Before
	public void setUp() throws Exception 
	{
		lista = new ListaEquipos();
	}

	@After
	public void tearDown() throws Exception 
	{
		lista = null;
	}

	@Test
	public void testOrdenar() 
	{
		assertEquals(lista.tamano(),0);
		Equipo aux = new Equipo("equi1", "campo1" ,1);
		lista.add(aux);
		aux = new Equipo("equi4", "campo4" ,4);
		lista.add(aux);
		aux = new Equipo("equi5", "campo1" ,5);
		lista.add(aux);
		aux = new Equipo("equi3", "campo3" ,3);
		lista.add(aux);
		aux = new Equipo("equi2", "campo2" ,2);
		lista.add(aux);
		assertEquals(lista.tamano(),5);
		
		
		lista.ordenar();
		Iterator<Equipo> it = lista.getIterator();
		
		
		aux =it.next();
		assertEquals(aux.getPuntos(), 1);
		aux =it.next();
		assertEquals(aux.getPuntos(), 2);
		aux =it.next();
		assertEquals(aux.getPuntos(), 3);
		aux =it.next();
		assertEquals(aux.getPuntos(), 4);
		aux =it.next();
		assertEquals(aux.getPuntos(), 5);
		
	}

	@Test
	public void testGetEquipo() 
	{
		assertEquals(lista.tamano(),0);
		Equipo aux = new Equipo("equi1", "campo1" ,1);
		lista.add(aux);
		aux = new Equipo("equi4", "campo4" ,4);
		lista.add(aux);
		aux = new Equipo("equi5", "campo1" ,5);
		lista.add(aux);
		aux = new Equipo("equi3", "campo3" ,3);
		lista.add(aux);
		aux = new Equipo("equi2", "campo2" ,2);
		lista.add(aux);
		assertEquals(lista.tamano(),5);
	
		aux = lista.getEquipo(4);
		assertEquals(aux.getNombre(), "equi2s");
	}

	@Test
	public void testGetEquipoN() 
	{
		assertEquals(lista.tamano(),0);
		Equipo aux = new Equipo("equi1", "campo1" ,1);
		lista.add(aux);
		aux = new Equipo("equi4", "campo4" ,4);
		lista.add(aux);
		aux = new Equipo("equi5", "campo1" ,5);
		lista.add(aux);
		aux = new Equipo("equi3", "campo3" ,3);
		lista.add(aux);
		aux = new Equipo("equi2", "campo2" ,2);
		lista.add(aux);
		assertEquals(lista.tamano(),5);
		
		aux = lista.getEquipoN("equi2");
		assertEquals(aux.getPuntos(), 2);
	}

	public void  testGetEquipos() 
	{
		assertEquals(lista.tamano(),0);
		Equipo aux = new Equipo("equi1", "campo1" ,1);
		lista.add(aux);
		aux = new Equipo("equi4", "campo4" ,4);
		lista.add(aux);
		aux = new Equipo("equi5", "campo1" ,5);
		lista.add(aux);
		aux = new Equipo("equi3", "campo3" ,3);
		lista.add(aux);
		aux = new Equipo("equi2", "campo2" ,2);
		lista.add(aux);
		assertEquals(lista.tamano(),5);	
	
		Equipo[] lis = lista.getEquipos();
		assertEquals(lis.length, 5);
	}

}
