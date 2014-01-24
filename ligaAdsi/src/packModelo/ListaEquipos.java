package packModelo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import net.sf.jga.algorithms.Sort;

public class ListaEquipos 
{
	private LinkedList<Equipo> lista;
	
	public ListaEquipos()
	{
		lista = new LinkedList<Equipo>();
	}
	
	public Equipo[]  getEquipos()
	{
		return (Equipo[]) lista.toArray();
	}
	
	public Iterator<Equipo> getIterator()
	{
		return lista.iterator();
	}
	
	public void ordenar() 
	{
		LinkedList<Equipo> aux = new LinkedList<Equipo>();
		Sort.sort(lista, aux);
		lista = aux;
		
	}
	
	public int tamano() 
	{
		return lista.size();
	}
	
	public Equipo getEquipo(int pIndex)
	{
		return this.lista.get(pIndex);
	}

	public Equipo getEquipoN(String equipo) 
	{
		Iterator<Equipo> it = lista.iterator();
		boolean encontrado = false;
		Equipo aux = null;
		
		while (it.hasNext() && !encontrado)
		{
			aux = it.next();
			if (aux.getNombre().equals(equipo))
				encontrado = true;
		}
		if (!encontrado)
			{
			aux = null;
			}
		
		return aux;
	}
	
	public void add(Equipo pEquipo)
	{
		lista.addLast(pEquipo);
	}
}