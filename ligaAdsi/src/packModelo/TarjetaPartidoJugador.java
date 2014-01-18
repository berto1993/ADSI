package packModelo;

public class TarjetaPartidoJugador
{
	private xx fechaInstante;
	private tipoT tipo;
	private int idJugador;
	
	public TarjetaPartidoJugador (xx pFechaInstante, tipoT pTipo , int pIdJugador)
	{
		fechaInstante = pFechaInstante;
		tipo = pTipo;
		idJugador = pIdJugador;
	}
	
	public tipoT getTipo()
	{
		return tipo;
	}

}
