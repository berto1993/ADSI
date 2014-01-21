package packModelo;

import java.util.Date;

public class TarjetaPartidoJugador
{
	private Date fechaInstante;
	private tipoT tipo;
	private Jugador idJugador;
	
	public TarjetaPartidoJugador (Date pFechaInstante, tipoT pTipo , Jugador pIdJugador)
	{
		fechaInstante = pFechaInstante;
		tipo = pTipo;
		idJugador = pIdJugador;
	}
	
	public tipoT getTipo()
	{
		return tipo;
	}

	public Jugador getQuien() 
	{
		return idJugador;
	}

	public Date getInstante() 
	{
		return fechaInstante;
	}

}
