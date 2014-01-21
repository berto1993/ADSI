package packModelo;

import java.util.Date;

public class Sustitucion 
{
	private Jugador sale;
	private Jugador entra;
	private Date instante;
	
	public Sustitucion (Jugador pJugadorE,Jugador pJugadorS, Date pInstante)
	{
		sale = pJugadorS;
		entra = pJugadorE;
		instante = pInstante;
	}
	
	public Jugador getSaliente()
	{
		return sale;
	}
	
	public Jugador getEntrante()
	{
		return entra;
	}

	public Date getInstante() 
	{
		return instante;
	}
}