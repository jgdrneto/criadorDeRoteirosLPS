package construtor;

import eventos.Evento;

public class Preferencia implements Comparable<Preferencia>{
	
	public enum RANKING{
		SEM_RANKING,
		UM,
		DOIS,
		TRES,
		QUATRO,
		CINCO
	}
	
	Class<? extends Evento> classe;
	RANKING rk;
	
	public Preferencia(Class<? extends Evento> classe, RANKING rk) {
		this.classe = classe;
		this.rk = rk;
	}

	public Class<? extends Evento> getClasse() {
		return classe;
	}

	public void setClasse(Class<? extends Evento> classe) {
		this.classe = classe;
	}

	public RANKING getRk() {
		return rk;
	}

	public void setRk(RANKING rk) {
		this.rk = rk;
	}

	@Override
	public int compareTo(Preferencia pref) {
		
		if(this.getRk().ordinal()>pref.getRk().ordinal()){
			return -1;
		}else{
			if(this.getRk().ordinal()<pref.getRk().ordinal()){
				return 1;
			}else{
				return 0;
			}
		}
	}
}
