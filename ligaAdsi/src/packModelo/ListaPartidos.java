package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaPartidos 
{
	private LinkedList<Partido> lista;
	
	public ListaPartidos()
	{
		lista = new LinkedList<Partido>();
	}
	
	public void anadirPartido(Partido pPartido)
	{
		this.lista.add(pPartido);
	}

	public LinkedList<Jugador> obtenerJugadores(String equipo) 
	{
		Partido aux = null;
		Iterator<Partido> it = lista.iterator();
		boolean encontrado = false;
		
		while (it.hasNext() && !encontrado)
		{
			aux = it.next();
			if (aux.getEquipoV().getNombre().equals(equipo) || aux.getEquipoL().getNombre().equals(equipo) )
				encontrado = true;
		}
		
		if (encontrado)
			return aux.getListaConvocados().getLista();
		else 
			return null;
	}

	public Partido getPartido(String equipo) 
	{
		Partido aux = null;
		Iterator<Partido> it = lista.iterator();
		boolean encontrado = false;
		
		while (it.hasNext() && !encontrado)
		{
			aux = it.next();
			if (aux.getEquipoV().getNombre().equals(equipo) || aux.getEquipoL().getNombre().equals(equipo) )
				encontrado = true;
		}
		
		if (encontrado)
			return aux;
		else 
			return null;	
		}
}
