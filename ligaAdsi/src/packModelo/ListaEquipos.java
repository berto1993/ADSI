package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaEquipos 
{
	private LinkedList<Equipo> lista;
	
	public ListaEquipos ()
	{
		lista = new LinkedList<Equipo>();
	}
	public Equipo[]  getEquipos ()
	{
		return (Equipo[]) lista.toArray();
	}
	public Iterator<Equipo> getIterator()
	{
		return lista.iterator();
	}
}
