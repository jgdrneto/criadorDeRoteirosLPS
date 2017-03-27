package eventos;

import java.util.GregorianCalendar;

public class Lazer extends Evento{

	public Lazer(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino) {
		super(nome,Lazer.class.getName(), descricao, local, preco, horarioInicio, horarioTermino);
	}

}
