package criterios;

import java.util.List;

import construtor.Preferencia;
import eventos.Evento;

public interface Criterio {
	public List<Evento> aplicarCriterio(List<Evento> eventos, List<Preferencia> preferencias);
}
