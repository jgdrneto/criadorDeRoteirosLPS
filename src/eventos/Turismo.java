package eventos;

import java.util.GregorianCalendar;

public class Turismo extends Evento{

	public Turismo(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino) {
		super(nome,Turismo.class.getName(), descricao, local, preco, horarioInicio, horarioTermino);
	}

}
