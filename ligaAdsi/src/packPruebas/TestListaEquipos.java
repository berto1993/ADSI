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
		while (it.hasNext())
		{
			it.next().getPuntos();
		}

	}

	@Test
	public void testGetEquipo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEquipoN() {
		fail("Not yet implemented");
	}

}
