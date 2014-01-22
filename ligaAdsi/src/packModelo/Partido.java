package packModelo;

import java.util.Date;
import java.util.LinkedList;

public class Partido 
{
	private int numGolesLocal;
	private int numGolesVisitante;
	private Date fecha;
	private Equipo equipoL;
	private Equipo equipoV;
	private ListaTarjetaPartidoJugador listaTarjetas;
	private ListaConvocados listaConvocados;
	private ListaTitulares listaTitulares;
	private ListaSustitucion listaReemplazos;
	private ListaGoles listaGoles;
	private int codP;
	private boolean suspendido;
	private Arbitro arbitro;
	private String estadio;

	public Partido (Date pFecha, Equipo pEquipoL, Equipo pEquipoV, String pEstadio)
	{
		fecha = pFecha;
		equipoL = pEquipoL;
		equipoV = pEquipoV;
		listaConvocados = new ListaConvocados();
		listaGoles = new ListaGoles();
		listaTarjetas = new ListaTarjetaPartidoJugador();
		listaTitulares = new ListaTitulares();
		listaReemplazos = new ListaSustitucion();
	}

	public Equipo getEquipoV() 
	{
		return equipoV;
	}
	
	public Equipo getEquipoL() 
	{
		return equipoL;
	}

	public ListaConvocados getListaConvocados() {
		// TODO Auto-generated method stub
		return listaConvocados;
	}

	public ListaGoles getListaGoles() 
	{
		return listaGoles;
	}

	public ListaSustitucion getListaReemplazos() 
	{
		return listaReemplazos;
	}

	public ListaTarjetaPartidoJugador getListaTarjetas() 
	{		
		return listaTarjetas;
	}

	public void obtenerIncidencias(String pJugador, LinkedList<String> resu) 
	{
		getListaGoles().obtenerGolesJugador(pJugador, resu);
		getListaReemplazos().obtenerReemplazos(pJugador,resu);
		getListaTarjetas().obtenerTarjetas(pJugador, resu);
	}
}
