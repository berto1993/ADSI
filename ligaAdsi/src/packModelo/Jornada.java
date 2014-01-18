package packModelo;

import java.util.Date;

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
}