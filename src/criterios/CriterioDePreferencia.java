package criterios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import construtor.Preferencia;
import eventos.Evento;

public class CriterioDePreferencia implements Criterio{

	public List<Evento> aplicarCriterio(List<Evento> eventos, List<Preferencia> preferencias){
		
		List<Evento> le = new ArrayList<Evento>();
		
		if(!eventos.isEmpty()){
			
			if(!preferencias.isEmpty()){
			
				Collections.sort(preferencias);
				
				for(Preferencia pf : preferencias){
					for(Evento ev : eventos){
						if(ev.getTipo().equals(pf.getClass().getSimpleName())){
							le.add(ev);
						}
					}
				}
			}else{
				return eventos;
			}	
		}
		
		return le;
	}
	
}
