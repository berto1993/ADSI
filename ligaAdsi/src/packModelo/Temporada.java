package packModelo;

import java.util.Date;
import java.util.LinkedList;
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
		this.fechaFin = ;;
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
		return this.getEquipos().getEquipo((int)Math.random()*this.getEquipos().tamano());
	}
	
	public Date getFechaIni()
	{
		return this.fechaIni;
	}

	public Date getFechaFin() {
		// TODO Auto-generated method stub
		return fechaFin;
	}

	public String getTemporada() 
	{
	
		return fechaIni.getYear() + "-" + fechaFin.getYear();
	}

	public LinkedList<Jornada> getJornadas()
	{
		return jornadas.getJornadas();
	}

	public Jornada getJornada(int laJornada) 
	{
		return jornadas.getJornadas().get(laJornada);
	}
}