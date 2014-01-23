package packModelo;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaSustitucion 
{
	private LinkedList<Sustitucion> lista;

	public ListaSustitucion()
	{
		lista = new LinkedList<Sustitucion>();
	}

	public void obtenerReemplazos(String pJugador, LinkedList<String> resu) 
	{
		Iterator<Sustitucion> it = lista.iterator();
		Sustitucion aux;
		
		while (it.hasNext())
		{
			aux = it.next();
			
			if (aux.getEntrante().getNombre().equals(pJugador) || aux.getSaliente().getNombre().equals(pJugador))
			{
				resu.addLast("Sale: "+aux.getSaliente().getNombre()+" ("+aux.getSaliente().getDorsal()+") ->"+"Entra: "+aux.getEntrante().getNombre()+" ("+aux.getEntrante().getDorsal()+") ->" + aux.getInstante().getHours()+":"+aux.getInstante().getMinutes()+":"+aux.getInstante().getSeconds());
			}
		}
		
	}
	
	public LinkedList<Sustitucion> obtenerListaReemplazos(){
		return this.lista;
	}
	
	
	public Sustitucion obtenerSustitucion(Date pInstante){
		Sustitucion sus =null;
		
		return sus;
	}
	
	public void anadirSustitucion(Jugador pJugadorE, Jugador pJugadorS, Date pInstante){
		if (lista.size()==0){
			Sustitucion sus=new Sustitucion(pJugadorE, pJugadorS, pInstante);
			lista.add(sus);
		}else{
			Sustitucion sus=null;
			Boolean esta=false;
			Iterator<Sustitucion> itr = lista.iterator();
			while(itr.hasNext() || esta){
				sus=itr.next();
				if(sus.getInstante().equals(pInstante)){
					esta=true;
				}
			}
			if(!esta){
				Sustitucion susti=new Sustitucion(pJugadorE, pJugadorS, pInstante);
				lista.add(susti);
			}
		}
	}
}
