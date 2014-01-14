package packModelo;

public class Gol 
{
	private xx instante;
	private Jugador quien;
	
	public Gol (xx pInstante, Jugador pQuien)
	{
		instante = pInstante;
		quien = pQuien;
	}
	
	public xx getInstante()
	{
		return instante;
	}
	
	public Jugador getQuien()
	{
		return quien;
	}

}
