package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

import net.sf.jga.algorithms.Sort;

public class ListaPuntosJornadaEquipo 
{
	private LinkedList<PuntosJornadaEquipo> lista;
	
	public ListaPuntosJornadaEquipo()
	{
		lista = new LinkedList<PuntosJornadaEquipo>();
	}
	

	public LinkedList<PuntosJornadaEquipo> getEquipoYPuntos() 
	{
		
		Iterator<PuntosJornadaEquipo> it = Sort.sort(lista.iterator());
		LinkedList<PuntosJornadaEquipo> resul = new LinkedList<PuntosJornadaEquipo>();
		PuntosJornadaEquipo aux;
		
		while (it.hasNext())
		{
			aux = it.next();
			resul.addLast(aux);
		}
		return resul;
	}
}
