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

import eventos.Comer;
import eventos.Evento;
import eventos.Evento.QUALIDADE;

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
			case "Comer":
				
				Integer quali = Integer.valueOf(obj.get(Comer.QUALIDADE).toString());
				
				QUALIDADE q = QUALIDADE.values()[quali];
				
				return new Comer((String)valores.get(Evento.NOME),
								 (String)valores.get(Evento.DESCRICAO),
								 (String)valores.get(Evento.LOCAL),
								 (double)valores.get(Evento.PRECO),
								 (GregorianCalendar)valores.get(Evento.HORADEINICIO),
								 (GregorianCalendar)valores.get(Evento.HORADETERMINO),
								 q);
								 
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
