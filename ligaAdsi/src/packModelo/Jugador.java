package packModelo;

public class Jugador implements Comparable<Jugador>
{
	private String nombre;
	private int dorsal;
	private int partidosJugados;
	private int tarjetasRecibidas;
	private boolean fichaje;
	private boolean expulsion;
	private String dni;

	public Jugador (String pNombre,int pDorsal, String pDni)
	{/*Por defecto al crear un jugador este no
	habra jugado ningun partido ni tendra tarjeta,
	ademas no estara disponible para fichar ni expulsado*/
		
		nombre = pNombre;
		dorsal = pDorsal;
		partidosJugados = 0;
		tarjetasRecibidas = 0;
		fichaje = false;
		expulsion = false;
		dni = pDni;
	}

	public int compareTo(Jugador o) 
	{
		if (tarjetasRecibidas == o.getTarjetasRecibidas())
		{
			if (partidosJugados == o.getPartidosJugados())
			{
				return nombre.compareTo(o.getNombre());
			}
			else
			{
				return partidosJugados - o.getPartidosJugados();
			}
		}
		else
		{
			return tarjetasRecibidas - o.getTarjetasRecibidas();
		}
	}

	public int getPartidosJugados() 
	{
		return partidosJugados;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public int getTarjetasRecibidas() 
	{
		return tarjetasRecibidas;
	}

	public int getDorsal() 
	{
		return dorsal;
	}
	
	public void setTarjetas(int pTarjetas)
	{
		tarjetasRecibidas = pTarjetas;
	}
}