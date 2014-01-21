package packModelo;

public class PuntosJornadaEquipo implements Comparable<PuntosJornadaEquipo> 
{
	private Equipo equipo;
	private int puntos;
	
	public PuntosJornadaEquipo(Equipo pEquipo, int pPuntos)
	{
		equipo = pEquipo;
		puntos = pPuntos;
	}

	public int getPuntos()
	{
		return puntos;
	}
	
	public Equipo getEquipo()
	{
		return equipo;
	}

	@Override
	public int compareTo(PuntosJornadaEquipo arg0) 
	{
		if (puntos ==arg0.getPuntos())
			return equipo.getNombre().compareTo(arg0.getEquipo().getNombre());
		else
			return puntos - arg0.puntos;
	}
}
