package construtor;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eventos.Alimentacao;
import eventos.Descanso;
import eventos.Evento;
import eventos.Evento.QUALIDADE;
import eventos.Exposicao;
import eventos.Intervalo;
import eventos.Lazer;
import eventos.Palestra;
import eventos.Turismo;

public class ESArquivosJSON {
	
	List<Evento> eventos;
	
	
	public List<Evento> leitorJSONArray(String NomeArquivo) throws IOException, ParseException {
		
		List<Evento> events = new ArrayList<Evento>();
		
		JSONParser parser=new JSONParser();

		JSONArray obj = (JSONArray) parser.parse(new FileReader(NomeArquivo));
		
		for(Object o : obj){
			JSONObject jo = (JSONObject)o;
			
			events.add(convertJsonOBJParaEvento(jo));
			
		}
				
		return events;
	}	
	
	private Evento convertJsonOBJParaEvento(JSONObject obj) {
				
		Map<String,Object> valores = Evento.obterValoresApartirDoJSON(obj);

		switch(valores.get(Evento.TIPO).toString()){
			case "Alimentacao":
				
				Integer qualA = Integer.valueOf(obj.get(Alimentacao.QUALIDADE).toString());
				
				QUALIDADE qA = QUALIDADE.values()[qualA];
				
				return new Alimentacao((String)valores.get(Evento.NOME),
								 (String)valores.get(Evento.DESCRICAO),
								 (String)valores.get(Evento.LOCAL),
								 (double)valores.get(Evento.PRECO),
								 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
								 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
								 qA);
			case "Descanso":
				
				Integer qualD = Integer.valueOf(obj.get(Alimentacao.QUALIDADE).toString());
				
				QUALIDADE qD = QUALIDADE.values()[qualD];
				
				return new Descanso((String)valores.get(Evento.NOME),
								 (String)valores.get(Evento.DESCRICAO),
								 (String)valores.get(Evento.LOCAL),
								 (double)valores.get(Evento.PRECO),
								 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
								 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
								 qD);
				
			case "Exposicao" :
				return new Exposicao((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
						 (String)valores.get("Autor"));
			case "Intervalo" :
				return new Intervalo((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO));
			case "Lazer" :
				return new Lazer((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO));
			case "Palestra" :
				return new Palestra((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
						 (String)valores.get("Palestrante"));
			case "Turismo" :
				return new Turismo((String)valores.get(Evento.NOME),
						 (String)valores.get(Evento.DESCRICAO),
						 (String)valores.get(Evento.LOCAL),
						 (double)valores.get(Evento.PRECO),
						 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
						 (GregorianCalendar)valores.get(Evento.HORADETERMINO));
			default:
				return null;
		}
	}
	
	public void escritor(String nomeArquivo, JSONArray json) throws IOException {
		
		FileWriter writeFile = null;
		
		try{
			writeFile = new FileWriter(nomeArquivo);
			//Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(json.toJSONString());
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void escritor(String nomeArquivo, JSONObject json) throws IOException {
		
		FileWriter writeFile = null;
		
		try{
			writeFile = new FileWriter(nomeArquivo);
			//Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(json.toJSONString());
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
