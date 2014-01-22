package packModelo;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class Jornada
{
	private boolean finalizada;
	private Date fechaInicio;
	private int numJornada;
	private ListaPuntosJornadaEquipo listaPuntosJornada;
	private ListaPartidos lPartidos;
	
	public Jornada(int pNJorn, Date pFechaIni)
	{
		this.finalizada = false;
		this.fechaInicio = pFechaIni;
		this.numJornada = pNJorn;
		this.listaPuntosJornada = new ListaPuntosJornadaEquipo();
		this.lPartidos = new ListaPartidos();
	}
	
	public void anadirPartido(Partido pPartido)
	{
		this.lPartidos.anadirPartido(pPartido);
	}
	
	public Date getFechaInicio()
	{
		return this.fechaInicio;
	}

	public int getNumJornada() 
	{
		return numJornada;
	}

	public LinkedList<PuntosJornadaEquipo> getEquipoYPuntos() 
	{
		return listaPuntosJornada.getEquipoYPuntos();
	}

	public ListaPartidos getListaPartidos() 
	{
			return lPartidos;
	}

	public LinkedList<Jugador> obtenerJugadores(String equipo) 
	{
	Equipo equi = Liga.getLiga().obtenerEquipo(equipo);
	LinkedList<Jugador> lisI = lPartidos.obtenerJugadores(equipo);
	LinkedList<Jugador> lisF = new LinkedList<Jugador>();

	Jugador aux;
	Iterator<Jugador> it = lisI.iterator();
	
		while (it.hasNext())
		{
			aux = it.next();
			if (equi.esta(aux))
				lisF.addLast(aux);
		}
		return lisF;
	}
}