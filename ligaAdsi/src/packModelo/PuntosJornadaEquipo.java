package packModelo;

public class PuntosJornadaEquipo 
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
}
