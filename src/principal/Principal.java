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
import estrategiasDeEscolha.EstrategiaComPreferencia;
import estrategiasDeEscolha.EstrategiaDeEscolha;
import estrategiasDeEscolha.EstrategiaPorMenorPreco;
import eventos.Alimentacao;
import eventos.Descanso;
import eventos.Exposicao;
import eventos.Evento;
import eventos.Evento.QUALIDADE;

public class Principal {

	public static void main(String[] args) {
		
		JSONArray eventos = new JSONArray();
		
		Alimentacao a1 = new Alimentacao("Restaurante Bom comer", "Restaurante que tem boa comida", "Avenida 2", 50, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.BOA);
		Alimentacao a2 = new Alimentacao("Restaurante Bom apetite", "Restaurante que tem comida excelente", "Avenida da Bronzita", 100, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), QUALIDADE.EXCELENTE);
		Alimentacao a3 = new Alimentacao("Restaurante do Povão", "Restaurante com comida BBB", "BR 01", 30, new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.BOA);
		Alimentacao a4 = new Alimentacao("Restaurante do João", "Restaurante com comida Top", "BR 111", 40, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), QUALIDADE.BOA);
		Alimentacao a5 = new Alimentacao("Restaurante do Túlio", "Restaurante com comida francesa", "BR 110", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 13, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.EXCELENTE);
		Alimentacao a6 = new Alimentacao("Restaurante do come-come", "Restaurante com melhor self-service da região", "BR 90", 60, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 15, 0), QUALIDADE.BOA);
		Alimentacao a7 = new Alimentacao("Restaurante do dourado", "Restaurante de frutos do mar", "BR 1", 40, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Alimentacao a8 = new Alimentacao("Restaurante Rei do gado", "Restaurante com o melhor da carne bovina", "BR 101", 50, new GregorianCalendar(2017, Calendar.MARCH, 10, 10, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), QUALIDADE.MEDIA);
		Alimentacao a9 = new Alimentacao("Restaurante Bom ponto", "Restaurante com um excelente local de acesso", "BR 101", 40, new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 15, 0), QUALIDADE.BOA);
		Alimentacao a10 = new Alimentacao("Restaurante do Buffalo Bill", "Restaurante especializado em comida de buffalo", "BR 101", 150, new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 15, 0), QUALIDADE.EXCELENTE);
		
		Descanso d1 = new Descanso("Hotel sono bom", "Hotel para sono top", "Rua do Malte", 80, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
		Descanso d2 = new Descanso("Pousada soneca", "Pousada a brisa mar", "Rua da Pestana", 50, new GregorianCalendar(2017, Calendar.MARCH, 10, 12, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.BOA);
		Descanso d3 = new Descanso("Hotel do João Pestana", "Hotel de primeira quailidade", "Rua da soneca", 150, new GregorianCalendar(2017, Calendar.MARCH, 10, 18, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 23, 0), QUALIDADE.EXCELENTE);
		Descanso d4 = new Descanso("Hertz Center Hotel", "O hotel mais luxuoso da cidade", "Rua São Manuel", 200, new GregorianCalendar(2017, Calendar.MARCH, 10, 18, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 23, 0), QUALIDADE.MEDIA);
		Descanso d5 = new Descanso("Pousada da caridade", "Pousada boa, bonita e barata", "Rua João Catinguera", 30, new GregorianCalendar(2017, Calendar.MARCH, 10, 18, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 20, 0), QUALIDADE.BOA);
		Descanso d6 = new Descanso("Hotel do conhecimento", "Durma aprendendo", "Rua do saber", 90, new GregorianCalendar(2017, Calendar.MARCH, 10, 19, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 21, 0), QUALIDADE.MEDIA);
		Descanso d7 = new Descanso("Hotel Colina", "Hotel com bela vista para a cidade", "Rua do Monte Azul", 80, new GregorianCalendar(2017, Calendar.MARCH, 10, 20, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 23, 0), QUALIDADE.MEDIA);
		Descanso d8 = new Descanso("Natal Palace Hotel", "O Melhor hotel do bairro alecrim", "Avenida Brasil", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 21, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 22, 0), QUALIDADE.MEDIA);
		Descanso d9 = new Descanso("Hotel boa dormida", "Melhor local para descanso para você", "Rua do sono", 70, new GregorianCalendar(2017, Calendar.MARCH, 10, 19, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 21, 0), QUALIDADE.MEDIA);
		Descanso d10 = new Descanso("Hotel Ibernação", "Aqui vc dorme de verdade", "Rua do Inverno", 85, new GregorianCalendar(2017, Calendar.MARCH, 10, 21, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 23, 0), QUALIDADE.MEDIA);
		
		/*
		Alimentacao d10 = new Alimentacao("Restaurante do Guiné", "Restaurante com comida caseira do sertão", "BR 101", 75, new GregorianCalendar(2017, Calendar.MARCH, 10, 11, 0), new GregorianCalendar(2017, Calendar.MARCH, 10, 14, 0), QUALIDADE.MEDIA);
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
		eventos.add(d1.converterParaJSON());
		eventos.add(d2.converterParaJSON());
		eventos.add(d3.converterParaJSON());		
		eventos.add(d4.converterParaJSON());
		eventos.add(d5.converterParaJSON());
		eventos.add(d6.converterParaJSON());
		eventos.add(d7.converterParaJSON());
		eventos.add(d8.converterParaJSON());
		eventos.add(d9.converterParaJSON());
		eventos.add(d10.converterParaJSON());
		
		List<Preferencia> preferencias = new ArrayList<Preferencia>();
		
		preferencias.add(new Preferencia(Alimentacao.class,12,0,14,0));
		//preferencias.add(new Preferencia(Alimentacao.class,12,0,14,0));
		//preferencias.add(new Preferencia(Descanso.class,RANKING.DOIS));
		//preferencias.add(new Preferencia(Exposicao.class,RANKING.DOIS));
		
		
		List<Class <? extends Evento>> classes = new ArrayList<Class <? extends Evento>>();
		classes.add(Alimentacao.class);
		classes.add(Descanso.class);
		
		try {
			ESArquivosJSON manipulador = new ESArquivosJSON();
			
			manipulador.escritor("teste.json", eventos);
			
			List<Evento> le = manipulador.leitorJSONArray("teste.json");
			
			ConstrutorDeRoteiro construtor = new ConstrutorDeRoteiro(le, classes, preferencias, 2017, Calendar.MARCH, 10,7);
			
			//EstrategiaDeEscolha estrategia = new EstrategiaAleatoria();
			EstrategiaDeEscolha estrategia = new EstrategiaPorMenorPreco();
			//EstrategiaDeEscolha estrategia = new EstrategiaComPreferencia();
			
			List<Evento> roteiro = construtor.getRoteiro(estrategia);
			
			//List<List<Evento>> matrizRoteiro = construtor.selecionarRoteirosPossiveis();
			
			/*
			for(List<Evento>lme : matrizRoteiro){
				for(Evento ev : lme){
					System.out.println(ev.toString());
				}
				
				System.out.println("=============ACABOU A LINHA===============");
			}
			*/
			
			JSONArray roteiroSalvo = new JSONArray();
			
			for(Evento e : roteiro){
				
				System.out.println(e.toString());
				
				roteiroSalvo.add(e.converterParaJSON());
				
				System.out.println("=========================================================\n");
				
			}
			
			//Gravando o roteiro
			manipulador.escritor("roteiro.json", roteiroSalvo);
			
		} catch (IOException e) {
			System.out.println("ERRO AO ESCREVER EM ARQUIVO");
			e.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
