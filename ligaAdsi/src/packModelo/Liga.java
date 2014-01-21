package packModelo;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import packVista.CalcularFairplay;
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
	
	public static Liga getLiga()
	{
		if (miListaTemporadas == null)
			{
			miListaTemporadas = new Liga();
			}
	
		return miListaTemporadas;
			
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
			String[]equipos = preprararEquipos(equiPun);
			new CalcularFairplay(jugadores, equipos);
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
	}
	
	public void realizarSorteo()
	{
		int nJornadas = 1;
				
		while (nJornadas <= 38)
		{
			//DUDA: ¿No hay manera de ir sumandole dias/semanas a la fecha de inicio de la temporada?
			Jornada j = new Jornada(nJornadas, miListaTemporadas.temporadas.getLast().getFechaIni());
			int nPartidos = 1;
			
			while(nPartidos <= 10)
			{
				Equipo aux1 = miListaTemporadas.temporadas.getLast().cogerEquipo();
				Equipo aux2 = miListaTemporadas.temporadas.getLast().cogerEquipo();
				j.anadirPartido(new Partido(j.getFechaInicio(), aux1, aux2, aux1.getEstadio()));	
				nPartidos++;
			}
			miListaTemporadas.temporadas.getLast().addJornada(j);
			nJornadas++;
		}
	}
	
	public String[] obtenerTemporadas()
	{
		Iterator<Temporada> it = temporadas.iterator();
		String[] resul = new String[temporadas.size()];
		Temporada aux;
		
		for (int i = 0 ; it.hasNext(); i++)
		{
			aux = it.next();
			resul[i] = aux.getTemporada();
		}
		return resul;
	}
	
	public String[] obtenerJornadas(int laTemporada)
	{
		Temporada temp = temporadas.get(laTemporada);
		LinkedList<Jornada> listAux = temp.getJornadas();
		Iterator<Jornada> it = listAux.iterator();
		String[] resul = new String[listAux.size()];
		Jornada aux;
		
		for (int i = 0; it.hasNext(); i++)
		{
			aux = it.next();
			resul[i] = String.valueOf(aux.getNumJornada());
		}
	
		return resul;
	}
	
	public String[] obtenerEquiposPuntos(int laTemporada,int laJornada)
	{
		Jornada aux = temporadas.get(laTemporada).getJornada(laJornada);
		LinkedList<PuntosJornadaEquipo> lis = aux.getEquipoYPuntos();
		Iterator<PuntosJornadaEquipo>it = lis.iterator();
		String[] resul = new String[lis.size()];
		PuntosJornadaEquipo equip;
		
		for (int i = 0; it.hasNext(); i++)
		{
			equip = it.next();
			resul[i] = equip.getEquipo().getNombre() + "->" + equip.getPuntos();
		}
		return resul;
	}
	
	public String[] obtenerJugadores(int temporada,int jornada, String equipo)
	{
		LinkedList<Jugador> listaConvocados = temporadas.get(temporada).getJornada(jornada).obtenerJugadores(equipo); 
		return preparJugadoresEstadisticas(listaConvocados);
	}

	private String[] preparJugadoresEstadisticas(LinkedList<Jugador> listaConvocados) 
	{
		String[] resul = new String [listaConvocados.size()];
		Iterator <Jugador> it = listaConvocados.iterator();
		Jugador aux;
		
		for (int i = 0; it.hasNext(); i++)
		{
			aux = it.next();
			resul[i] = aux.getNombre()+"("+aux.getDorsal()+")";
		}
		return resul;
	}

	public Equipo obtenerEquipo(String equipo) 
	{
		return listaEquiposTotal.getEquipoN(equipo);
	}
	
	public String[] obtenerIncidenciasJugador(int pTemporada, int pJornada, String pEquipo, String pJugador)
	{
		Partido part = temporadas.get(pTemporada).getJornada(pJornada).getListaPartidos().getPartido(pEquipo);
		LinkedList<String> resu = new LinkedList<String>();
		part.getListaGoles().obtenerGolesJugador(pJugador, resu);
		part.getListaReemplazos().obtenerReemplazos(pJugador,resu);
		part.getListaTarjetas().obtenerTarjetas(pJugador, resu);
		
		return resu.toArray();
	}
}