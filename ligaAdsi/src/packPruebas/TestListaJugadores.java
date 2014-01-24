package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Jugador;
import packModelo.ListaJugadores;

public class TestListaJugadores {

	ListaJugadores lista; 
	@Before
	public void setUp() throws Exception
	{
		lista = new ListaJugadores();
	}

	@After
	public void tearDown() throws Exception 
	{
		lista = null;
	}

	@Test
	public void testCalcularMediaTarjetasJugador() 
	{
		int resul = 0;
		Jugador aux;
		aux = new Jugador("1", 1, "1");
		aux.setTarjetas(12);
		lista.add(aux);
		resul = resul + aux.getTarjetasRecibidas();
		aux = new Jugador("2", 2, "2");
		aux.setTarjetas(2);
		lista.add(aux);
		resul = resul + aux.getTarjetasRecibidas();
		aux = new Jugador("3", 3, "5");
		aux.setTarjetas(2);
		lista.add(aux);
		resul = resul + aux.getTarjetasRecibidas();
		
		assertEquals(lista.tamano(), 3);
		int r = resul/3;
		assertEquals(lista.calcularMediaTarjetasJugador(), r);
					
	}

}
