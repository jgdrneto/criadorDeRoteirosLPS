package eventos;

import java.util.GregorianCalendar;

public class Intervalo extends Evento {

	public Intervalo(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino) {
		super(nome,Intervalo.class.getName(), descricao, local, preco, horarioInicio, horarioTermino);
	}
	
}
