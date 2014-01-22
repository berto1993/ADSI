package packModelo;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import net.sf.jga.algorithms.Sort;

public class Liga 
{
	private LinkedList<Temporada> temporadas;
	private ListaEquipos listaEquiposTotal;
	private static Liga miListaTemporadas;
	
	private Liga()
	{
		this.temporadas = new LinkedList<Temporada>();
		this.listaEquiposTotal = new ListaEquipos();
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
			LinkedList<String> equiPun = new LinkedList<String>();
			Iterator<Equipo> itE = listaEquiposTemporada.getIterator();
			Equipo equi= null;
			LinkedList<Jugador> listaJugadores = new LinkedList<Jugador>();
			int aux = 0; 
			while (itE.hasNext())
			{
				equi = itE.next();
				aux = equi.calcularMediaTarjetasJugador();
				equiPun.addLast(equi.getNombre() + "-->" + aux);
				listaJugadores.addAll(equi.getListaJugadoresEquipo());
			}
			String[]jugadores = preprararJugadores(listaJugadores, listaJugadores.size());
			String[]Equipos = preprararEquipos(equiPun);
			}
		
	}
	
	private String[] preprararEquipos(LinkedList<String> equiPun) 
	{
		Iterable<String> aux = Sort.sort(equiPun, new comparatorString());
		Iterator<String> it = aux.iterator();
		String [] resul = new String[equiPun.size()];
		for (int i = 0 ; it.hasNext() ; i++)
		{
			resul[i] = it.next();
		}
		return resul;
	}

	private String[] preprararJugadores(LinkedList<Jugador> pListaJugadores, int pTamano) 
	{
		Iterable<Jugador> lista = Sort.sort(pListaJugadores);
		Iterator<Jugador> it = lista.iterator();
		String[] jugadores = new String[pTamano];
		Jugador aux;
		
		for (int i=0 ; it.hasNext();i++)
		{
			aux = it.next();
			jugadores[i] = aux.getNombre() + "(" + aux.getDorsal() + ")";
		}
		return jugadores;
	}

	public String[] calcularClasificacion()
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
			String [] resultados = new String[listaEquiposTemporada.tamano()];
			while (it.hasNext())
			{
				aux = it.next();
				resultados[i] = aux.getNombre() + "-->" + aux.getPuntos(); 
			}
		}
		return resultados;
	}
	
	public void realizarSorteo()
	{
		try
		{
			
			int nJornadas = 1;
			Date fechaInicio = miListaTemporadas.temporadas.getLast().getFechaIni();
			Connection a = (Connection) ConexionDB.GetConnection();
			Statement s = (Statement) a.createStatement();
		
			while (nJornadas <= 38)
			{
				if (nJornadas != 1)
				{
					int d = fechaInicio.getDate() + 7;
					fechaInicio.setDate(d);
				}
			
				Jornada j = new Jornada(nJornadas, fechaInicio);
				int nPartidos = 1;
			
				while(nPartidos <= 10)
				{
					Equipo aux1 = miListaTemporadas.temporadas.getLast().cogerEquipo();
					Equipo aux2 = miListaTemporadas.temporadas.getLast().cogerEquipo();
					Partido p = new Partido(j.getFechaInicio(), aux1, aux2, aux1.getEstadio());
					j.anadirPartido(p);
					int id = nJornadas*100 + nPartidos;
					s.executeUpdate("insert into partido values ( 0, 0, " + p.getFechaIni() + ", " + id + ", " + p.getFechaIni() + ", " + p.getFechaIni() + ", " + nJornadas);
					nPartidos++;
				}
				miListaTemporadas.temporadas.getLast().addJornada(j);
				s.executeUpdate("insert into jornada values ( 0, " + j.getFechaInicio() + ", , " + nJornadas);
				nJornadas++;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}