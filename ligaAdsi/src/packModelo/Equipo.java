package packModelo;

import java.util.Collection;
import java.util.LinkedList;

public class Equipo implements Comparable<Equipo>
{
	private String nombre;
	private int puntos;
//	private ¿int? entrenador;
	private String estadio;
	private ListaJugadores jugadores;
	private int idCod;
	private ListaJugadores listaConvocados;
	
	public Equipo(String pNombre, String pEstadio, int pIdCod/*, ¿int? pEntrenador*/) 
	{
		this.nombre = pNombre;
		this.estadio = pEstadio;
		this.idCod = pIdCod;
		puntos = 0;
		//entrenador = pEntrenador;
		jugadores = null;
		listaConvocados = null;
	}


	public LinkedList<Jugador> getListaJugadoresEquipo() 
	{
		return jugadores.getLista();
	}

	public String getNombre()
	{
		return nombre;
	}

	public int getPuntos() 
	{
		return puntos;
	}

	public int compareTo(Equipo arg0) 
	{
		if (this.getPuntos() != arg0.getPuntos())
			return this.getPuntos() - arg0.getPuntos();
		else
			return this.getNombre().compareTo(arg0.getNombre());
	}


	public int calcularMediaTarjetasJugador()
	{
		return jugadores.calcularMediaTarjetasJugador();
	}
	
	public String getEstadio()
	{
		return this.estadio;
	}
}