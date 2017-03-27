package construtor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import eventos.Evento;

public class ConstrutorDeRoteiro {
	
	private List<Evento> todosEventos;
	private List<List<Evento>> matrizEvento;
	private List<Evento> roteiro;
	private List<Class<? extends Evento>> classes;
	private GregorianCalendar data;
	private Random geradorDeNumero;
	
	public ConstrutorDeRoteiro(List<Evento> todosEventos, List<Class<? extends Evento>> classes, int ano, int mes, int dia, int hora) {
		this.todosEventos = todosEventos;
		this.classes = classes;
		this.data = new GregorianCalendar(ano, mes, dia, hora, 0);
		this.geradorDeNumero = new Random();
		
		this.roteiro = criarRoteiro();
	}
	
	private List<List<Evento>> selecionarRoteirosPossiveis(){
		
		List<List<Evento>> tempRoteiro = new ArrayList<List<Evento>>();
		
		List<Integer> horas = new ArrayList<Integer>();
		
		List<Evento> vTemp = new ArrayList<Evento>();
		
		for(Evento e : todosEventos){
			if(classes.contains(e.getClass()) && data.get(Calendar.DAY_OF_MONTH)==e.getHorarioInicio().get(Calendar.DAY_OF_MONTH)
											  && data.get(Calendar.MONTH) == e.getHorarioInicio().get(Calendar.MONTH)
											  && data.get(Calendar.YEAR) == e.getHorarioInicio().get(Calendar.YEAR)){
				
				if(horas.contains(data.get(Calendar.HOUR_OF_DAY))){
					
					vTemp = tempRoteiro.get(data.get(Calendar.HOUR_OF_DAY));
					
				}else{
					horas.add(data.get(Calendar.HOUR_OF_DAY));
					vTemp =  new ArrayList<Evento>();
				}
				
				vTemp.add(e);
				tempRoteiro.set(horas.indexOf(data.get(Calendar.HOUR_OF_DAY)),vTemp);
			}
		}
		
		Collections.sort(horas);
		
		for(int i=0;i<horas.size();i++){
			
			int id = buscaIdPorHora(horas.get(i),tempRoteiro);
			
			Collections.swap(tempRoteiro,i, id);
		
		}		
		return tempRoteiro;
		
	}
	
	private int buscaIdPorHora(int hora, List<List<Evento>> tempRoteiro){
		
		for(int i =0;i<tempRoteiro.size();i++){
			if(tempRoteiro.get(i).get(0).getHorarioInicio().get(Calendar.HOUR)==hora){
				return i;
			}
		}
		
		return -1;
	}
	
	private List<Evento> criarRoteiro(){
		
		matrizEvento = selecionarRoteirosPossiveis();
		
		List<Evento> r =  new ArrayList<Evento>();	
		
		int horaAtual = matrizEvento.get(0).get(0).getHorarioInicio().get(Calendar.HOUR_OF_DAY);
		
		for(int i =0; i< matrizEvento.size();i++){
			
			if(horaAtual<=matrizEvento.get(i).get(0).getHorarioInicio().get(Calendar.HOUR_OF_DAY)){
				int j = geradorDeNumero.nextInt(matrizEvento.get(i).size());
				r.add(matrizEvento.get(i).get(j));
				horaAtual = matrizEvento.get(i).get(j).getHorarioTermino().get(Calendar.HOUR_OF_DAY);	
			}
		}
		
		return r;
	}
	
	private void atualizarRoteiro(){
		
	}
	
	public void RemoverEventoDoRoteiro(Evento v){
		
		this.roteiro.remove(v); 
		
		atualizarRoteiro();
	} 
	
	public List<Evento> getRoteiro() {
		return roteiro;
	}

		
}
