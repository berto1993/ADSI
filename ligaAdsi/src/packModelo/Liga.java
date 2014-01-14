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
	
	public void calcularFairplay()
	{
		//Al terminar el calculo abre la interfaz de fairplay pasandole
		//como parametros las listas de equipos y jugadores
	}

}
