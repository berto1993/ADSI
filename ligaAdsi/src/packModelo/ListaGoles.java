package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaGoles 
{
	private LinkedList<Gol> lista;
	
	public ListaGoles()
	{
		lista = new LinkedList<Gol>();
	}

	public void obtenerGolesJugador(String pJugador, LinkedList<String> resu) 
	{
	Iterator<Gol> it = lista.iterator();
	Gol aux = null;
	
	while (it.hasNext())
	{
		aux = it.next();
		if (aux.getQuien().getNombre().equals(pJugador))
		{
			resu.addLast("Gol en "+ aux.getInstante().getHours()+":"+aux.getInstante().getMinutes()+":"+aux.getInstante().getSeconds());
		}
	}
		
	}

}
