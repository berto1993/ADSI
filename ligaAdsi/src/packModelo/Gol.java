package packModelo;

import java.util.Date;

public class Gol 
{
	private Date instante;
	private Jugador quien;
	
	public Gol (Date pInstante, Jugador pQuien)
	{
		instante = pInstante;
		quien = pQuien;
	}
	
	public Date getInstante()
	{
		return instante;
	}
	
	public Jugador getQuien()
	{
		return quien;
	}
}