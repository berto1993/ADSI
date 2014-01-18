package packModelo;

import java.util.Date;
import java.util.Random;

public class Temporada 
{
	private Date fechaIni;
	private Date fechaFin;
	private ListaJornadas jornadas;
	private ListaEquipos equipos;
	private ListaPartidos listaAplazados;
	
	public Temporada(Date pFechaIni)
	{
		this.fechaIni = pFechaIni;
		this.fechaFin =;
		this.jornadas = new ListaJornadas();
		this.equipos = new ListaEquipos();
		this.listaAplazados = new ListaPartidos();
	}
	
	public ListaEquipos getEquipos()
	{
		return equipos;
	}
	
	public void addJornada(Jornada pJornada)
	{
		this.jornadas.anadirJornada(pJornada);
	}
	
	public Equipo cogerEquipo()
	{
		Equipo aux = this.getEquipos().getEquipo(Integer.parseInt(Math.random())*this.getEquipos().tamano());
		return aux;
	}
	
	public Date getFechaIni()
	{
		return this.fechaIni;
	}
}