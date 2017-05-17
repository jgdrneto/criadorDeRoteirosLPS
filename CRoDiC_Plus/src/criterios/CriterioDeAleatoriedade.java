package criterios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import construtor.Preferencia;
import eventos.Evento;

public class CriterioDeAleatoriedade implements Criterio{
	
	private Random geradorDeNumero;

	public CriterioDeAleatoriedade() {
		this.geradorDeNumero = new Random();
	}
	
	public List<Evento> aplicarCriterio(List<Evento> eventos, List<Preferencia> preferencias){
		
		List<Evento> le = new ArrayList<Evento>();
		
		if(!eventos.isEmpty()){
			
			for(Evento ev : eventos){
				if(geradorDeNumero.nextInt(2)==0){
					le.add(ev);
				}
			}
			
			//Se ninguem for selecionado pela aleatoriedade, pelo menos um é garantido
			if(le.isEmpty()){
				le.add(eventos.get(geradorDeNumero.nextInt(eventos.size())));
			}
		
		}
		
		return le;
	}
	
}
