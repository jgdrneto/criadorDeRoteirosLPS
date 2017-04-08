package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import construtor.ConstrutorDeRoteiro;
import construtor.ESArquivosJSON;
import construtor.Preferencia;
import construtor.Preferencia.RANKING;
import estrategiasDeEscolha.EstrategiaAleatoria;
import estrategiasDeEscolha.EstrategiaDeEscolha;
import eventos.Alimentacao;
import eventos.Descanso;
import eventos.Exposicao;
import eventos.Evento;
import eventos.Evento.QUALIDADE;

public class Principal {

	public static void main(String[] args) {
		
		JSONArray eventos = new JSONArray();
		
		Alimentacao a1 = new Alimentacao("Restaurante Bom comer", "Restaurante que tem boa comida", "Avenida 2", 50, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), QUALIDADE.BOA);
		Alimentacao a2 = new Alimentacao("Restaurante Bom apetite", "Restaurante que tem comida excelente", "Avenida da Bronzita", 100, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), QUALIDADE.EXCELENTE);
		Alimentacao a3 = new Alimentacao("Restaurante do Povão", "Restaurante com comida BBB", "BR 01", 30, new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.BOA);
		Alimentacao a4 = new Alimentacao("Restaurante do João", "Restaurante com comida Top", "BR 111", 40, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), QUALIDADE.BOA);
		Alimentacao a5 = new Alimentacao("Restaurante do Túlio", "Restaurante com comida francesa", "BR 110", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.EXCELENTE);
		Alimentacao a6 = new Alimentacao("Restaurante do come-come", "Restaurante com melhor self-service da região", "BR 90", 60, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 15, 0), QUALIDADE.BOA);
		Alimentacao a7 = new Alimentacao("Restaurante do dourado", "Restaurante de frutos do mar", "BR 1", 40, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao a8 = new Alimentacao("Restaurante Rei do gado", "Restaurante com o melhor da carne bovina", "BR 101", 50, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao a9 = new Alimentacao("Restaurante Bom ponto", "Restaurante com um excelente local de acesso", "BR 101", 40, new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 15, 0), QUALIDADE.BOA);
		Alimentacao a10 = new Alimentacao("Restaurante do Buffalo Bill", "Restaurante especializado em comida de buffalo", "BR 101", 150, new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 15, 0), QUALIDADE.EXCELENTE);
		/*
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao c3 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		*/
		
		eventos.add(a1.converterParaJSON());
		eventos.add(a2.converterParaJSON());
		eventos.add(a3.converterParaJSON());		
		eventos.add(a4.converterParaJSON());
		eventos.add(a5.converterParaJSON());
		eventos.add(a6.converterParaJSON());
		eventos.add(a7.converterParaJSON());
		eventos.add(a8.converterParaJSON());
		eventos.add(a9.converterParaJSON());
		eventos.add(a10.converterParaJSON());
		
		List<Preferencia> preferencias = new ArrayList<Preferencia>();
		
		preferencias.add(new Preferencia(Alimentacao.class,RANKING.UM));
		preferencias.add(new Preferencia(Descanso.class,RANKING.DOIS));
		preferencias.add(new Preferencia(Exposicao.class,RANKING.DOIS));
		
		
		List<Class <? extends Evento>> classes = new ArrayList<Class <? extends Evento>>();
		classes.add(Alimentacao.class);
		
		try {
			ESArquivosJSON manipulador = new ESArquivosJSON();
			
			manipulador.escritor("teste.json", eventos);
			
			List<Evento> le = manipulador.leitorJSONArray("teste.json");
			
			ConstrutorDeRoteiro construtor = new ConstrutorDeRoteiro(le, classes, preferencias, 2017, Calendar.MARCH, 10,7);
			
			EstrategiaDeEscolha eAleatoria = new EstrategiaAleatoria();
			
			List<Evento> roteiro = construtor.getRoteiro(eAleatoria); 
			
			List<List<Evento>> matrizRoteiro = construtor.selecionarRoteirosPossiveis();
			/*
			for(List<Evento>lme : matrizRoteiro){
				for(Evento ev : lme){
					System.out.println(ev.toString());
				}
				
				System.out.println("=============ACABOU A LINHA===============");
			}
			*/
			
			for(Evento e : roteiro){
				if(e instanceof Alimentacao){
					
					Alimentacao c = (Alimentacao)e;
					
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
