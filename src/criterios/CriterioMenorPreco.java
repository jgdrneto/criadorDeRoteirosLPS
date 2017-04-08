package criterios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import construtor.Preferencia;
import eventos.Evento;

public class CriterioMenorPreco implements Criterio{

	public List<Evento> aplicarCriterio(List<Evento> eventos, List<Preferencia> preferencias){
		
		List<Evento> le = new ArrayList<Evento>();
		
		if(!eventos.isEmpty()){
			
			Evento e = eventos.get(0);		
			
			for(Evento ev : eventos){
				if(ev.getPreco()<e.getPreco()){
					e = ev;
				}
			}
			
			for(Evento ev : eventos){
				if(ev.getPreco()==e.getPreco()){
					le.add(ev);
				}
			}
		}
		
		return le;
	}
	
}
