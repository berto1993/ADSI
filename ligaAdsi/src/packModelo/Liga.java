package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
	
	public Temporada getTemporada (int pTemporada)
	{
		return temporadas.get(pTemporada);
	}
	
	public void calcularFairplay()
	{
		//Al terminar el calculo abre la interfaz de fairplay pasandole
		//como parametros las listas de equipos y jugadores
	
		if (temporadas.size()==0)
			{
			JOptionPane.showMessageDialog(null,"No existe temporadas","Error",JOptionPane.ERROR_MESSAGE);
			}
		else
			{
			Temporada aCalcular = getTemporada(temporadas.size()-1);
			ListaEquipos listaEquiposTemporada = aCalcular.getEquipos();
			
			Iterator<Equipo> itE = listaEquiposTemporada.getIterator();
			Equipo equi= null;
			LinkedList<Jugador> listaJugadores = new LinkedList<Jugador>();
			
			while (itE.hasNext())
			{
				equi = itE.next();
				listaJugadores.addAll(equi.getListaJugadoresEquipo());
			}
			
			Iterator<Jugador> it = listaJugadores.iterator();
			a
			}
		
	}
	
	public String[] calcularClasificacion ()
	{
		if (temporadas.size()==0)
		{
			JOptionPane.showMessageDialog(null,"No existe temporadas","Error",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Temporada aCalcular = getTemporada(temporadas.size()-1);
			ListaEquipos listaEquiposTemporada = aCalcular.getEquipos();
			listaEquiposTemporada.ordenar();
			Iterator<Equipo> it = listaEquiposTemporada.getIterator();
			Equipo aux;
			int i = 0;
			String [] resultados;
			while (it.hasNext())
			{
				aux = it.next();
				resultados[i] = aux.getNombre() + "-->" + aux.getPuntos(); 
			}
			
		
	}
}
