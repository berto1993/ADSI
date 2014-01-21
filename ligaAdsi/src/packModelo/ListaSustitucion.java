package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaSustitucion 
{
	private LinkedList<Sustitucion> lista;

	public ListaSustitucion()
	{
		lista = new LinkedList<Sustitucion>();
	}

	public void obtenerReemplazos(String pJugador, LinkedList<String> resu) 
	{
		Iterator<Sustitucion> it = lista.iterator();
		Sustitucion aux;
		
		while (it.hasNext())
		{
			aux = it.next();
			
			if (aux.getEntrante().getNombre().equals(pJugador) || aux.getSaliente().getNombre().equals(pJugador))
			{
				resu.addLast("Sale: "+aux.getSaliente().getNombre()+" ("+aux.getSaliente().getDorsal()") ->"+"Entra: "+aux.getEntrante().getNombre()+" ("+aux.getEntrante().getDorsal()+") ->" + aux.getInstante().getHours()+":"+aux.getInstante().getMinutes()+":"+aux.getInstante().getSeconds());
			}
		}
		
	}
}
