package principal;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import construtor.ESArquivosJSON;
import eventos.Alimentacao;
import eventos.Evento;
import eventos.Evento.QUALIDADE;

public class Teste2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONArray eventos = new JSONArray();
		
		Alimentacao a1 = new Alimentacao("Restaurante Bom comer", "Restaurante que tem boa comida", "Avenida 2", 50, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), QUALIDADE.BOA);
		
		eventos.add(a1.converterParaJSON());
		
		ESArquivosJSON manipulador = new ESArquivosJSON();
		
		try {
			manipulador.escritor("teste2.json", eventos);
			
			manipulador.escritor("teste2.json", eventos);
			
			List<Evento> le = manipulador.leitorJSONArray("teste2.json");
			
			for(Evento e : le){
				if(e instanceof Alimentacao){
					
					Alimentacao c = (Alimentacao)e;
					
					System.out.println(c.toString());
					
					System.out.println("=========================================================\n");
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
