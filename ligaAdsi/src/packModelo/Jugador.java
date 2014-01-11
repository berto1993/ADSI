package packModelo;

public class Jugador 
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
}
