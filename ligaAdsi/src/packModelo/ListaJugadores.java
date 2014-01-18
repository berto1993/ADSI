package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaJugadores 
{
	private LinkedList<Jugador> lista;
	
	public ListaJugadores()
	{
		lista = new LinkedList<Jugador>();
	}

	public LinkedList<Jugador> getLista() 
	{
		return lista;
	}

	public int calcularMediaTarjetasJugador() 
	{
		Iterator<Jugador> it = lista.iterator();
		int aux = 0;
		Jugador jug;
		
		while (it.hasNext())
		{
			jug = it.next();
			aux = aux + jug.getTarjetasRecibidas();
		}
		return aux;
	}
}