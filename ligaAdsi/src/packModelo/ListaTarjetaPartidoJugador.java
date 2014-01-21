package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaTarjetaPartidoJugador 
{
	private LinkedList<TarjetaPartidoJugador> lista;
	
	public ListaTarjetaPartidoJugador()
	{
		lista = new LinkedList<TarjetaPartidoJugador>();
	}

	public void obtenerTarjetas(String pJugador, LinkedList<String> resu) 
	{
		Iterator<TarjetaPartidoJugador> it = lista.iterator();
		TarjetaPartidoJugador aux = null;
		
		while (it.hasNext())
		{
			aux = it.next();
			if (aux.getQuien().getNombre().equals(pJugador))
			{
				resu.addLast(aux.getTipo().toString()+" en "+ aux.getInstante().getHours()+":"+aux.getInstante().getMinutes()+":"+aux.getInstante().getSeconds());
			}
		}
	}
}