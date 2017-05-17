package estrategiasDeEscolha;

import java.util.List;

import construtor.Preferencia;
import criterios.Criterio;
import criterios.CriterioDePreferencia;
import criterios.CriterioMenorPreco;
import eventos.Evento;

public class EstrategiaComPreferenciaMenorPreco implements EstrategiaDeEscolha{

	@Override
	public Evento escolher(List<Evento> eventos, List<Preferencia> preferencias) {
		
		if(!eventos.isEmpty()){
			
			Criterio c = new CriterioDePreferencia();
			Criterio c2 =  new CriterioMenorPreco();
			
			return c2.aplicarCriterio(c.aplicarCriterio(eventos, preferencias),preferencias).get(0);
			
		}else{
			return null;
		}
	}
}
