package principal;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import construtor.ESArquivosJSON;
import eventos.Comer;
import eventos.Evento;
import eventos.Evento.QUALIDADE;

public class Principal {

	public static void main(String[] args) {
		
		JSONArray eventos = new JSONArray();
		
		Comer c1 = new Comer("Restaurante Bom comer", "Restaurante que tem boa comida", "Avenida 2", 50, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), QUALIDADE.BOA);
		Comer c2 = new Comer("Restaurante Bom apetite", "Restaurante que tem comida excelente", "Avenida da Bronzita", 100, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), QUALIDADE.EXCELENTE);
		Comer c3 = new Comer("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		
		eventos.add(c1.converterParaJSON());
		eventos.add(c2.converterParaJSON());
		eventos.add(c3.converterParaJSON());		
		
		try {
			ESArquivosJSON manipulador = new ESArquivosJSON();
			
			manipulador.escritor("teste.json", eventos);
			
			List<Evento> le = manipulador.leitorJSONArray("teste.json");
			
			for(Evento e : le){
				if(e instanceof Comer){
					
					Comer c = (Comer)e;
					
					System.out.println(c.toString());
					
					System.out.println("=========================================================\n");
				}
			}
			
		} catch (IOException e) {
			System.out.println("ERRO AO ESCREVER EM ARQUIVO");
			e.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
