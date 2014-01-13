package packModelo;

public class Equipo 
{
	private String nombre;
	private int puntos;
	private //¿int? entrenador;
	private String estadio;
	private ListaJugadores jugadores;
	private int idCod;
	private ListaJugadores listaConvocados;
	
	public Equipo(String pNombre, String pEstadio, int pIdCodm ¿int? pEntrenador) 
	{
		this.nombre = pNombre;
		this.estadio = pEstadio;
		this.idCod = pIdCod;
		puntos = 0;
		entrenador = pEntrenador;
		jugadores = null;
		listaConvocados = null;
	}
	
	

}
