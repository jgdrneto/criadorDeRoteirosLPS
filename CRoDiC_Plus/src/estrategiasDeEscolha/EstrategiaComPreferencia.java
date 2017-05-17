package estrategiasDeEscolha;

import java.util.List;

import construtor.Preferencia;
import criterios.Criterio;
import criterios.CriterioDePreferencia;
import eventos.Evento;

public class EstrategiaComPreferencia implements EstrategiaDeEscolha{

	@Override
	public Evento escolher(List<Evento> eventos, List<Preferencia> preferencias) {
		
		if(!eventos.isEmpty()){
			
			Criterio c = new CriterioDePreferencia();
			
			return c.aplicarCriterio(eventos, preferencias).get(0);
			
		}else{
			return null;
		}
	}
}
