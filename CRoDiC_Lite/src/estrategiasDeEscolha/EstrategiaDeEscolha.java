package estrategiasDeEscolha;

import java.util.List;

import construtor.Preferencia;
import eventos.Evento;

public interface EstrategiaDeEscolha {
	public Evento escolher(List<Evento> eventos, List<Preferencia> preferencias);
}
