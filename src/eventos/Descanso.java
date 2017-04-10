package eventos;

import java.util.GregorianCalendar;

import org.json.simple.JSONObject;

public class Descanso extends Evento{
	
	private QUALIDADE qualidade;
	
	public Descanso(String nome, String descricao, String local, double preco, GregorianCalendar horarioInicio, GregorianCalendar horarioTermino, QUALIDADE qualidade) {
		super(nome,Descanso.class.getSimpleName(), descricao, local, preco, horarioInicio, horarioTermino);
		this.qualidade = qualidade;
	}

	public QUALIDADE getQualidade() {
		return qualidade;
	}

	public void setQualidade(QUALIDADE qualidade) {
		this.qualidade = qualidade;
	}

	@Override
	public JSONObject converterParaJSON() {
		
		JSONObject json = super.converterParaJSON();	
		json.put("Qualidade" , this.qualidade.ordinal());
		
		return json;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Qualidade: " + this.getQualidade().name()+"\n";
	}
	
	
	
}
