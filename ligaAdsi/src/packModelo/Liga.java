package packModelo;

import java.util.LinkedList;

public class Liga 
{
	private LinkedList<Temporada> temporadas;
	private ListaEquipos listaEquiposTotal;
	private static Liga miListaTemporadas;
	
	private Liga ()
	{
		temporadas = new LinkedList<Temporada>();
		listaEquiposTotal = new ListaEquipos();				
		
	}

}
