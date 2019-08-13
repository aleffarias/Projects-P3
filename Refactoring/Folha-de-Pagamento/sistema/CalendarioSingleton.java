package sistema;

public class CalendarioSingleton {
	
	private static CalendarioSingleton uniqueInstance;
	
	public static synchronized CalendarioSingleton getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new CalendarioSingleton();
		
		return uniqueInstance;
	}
	
	private int diaSemana;
	private int dia ;
	private int semana;
	private int mes;
	private int ano;
	private String diaString;
	
	private CalendarioSingleton() {
		this.dia = 1;
		this.mes = 1;
		this.ano = 2019;
		this.diaSemana = 1;
		this.semana = 1;
		this.diaString = "Segunda";
	}
	
	public void avancarDia() {
		this.dia++;
		this.diaSemana++;
		this.semana = (dia / 7) + 1;
		
		if (diaSemana == 8) {
			this.diaSemana = 1;
		}
			
		if (this.mes == 2 & this.dia == 29) {
			this.dia = 1;
			this.semana = 1;
			this.mes++;
		}
		
		if (this.dia == 32) {
			if (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12) {
				if (this.mes == 12) {
					this.dia = 1;
					this.semana = 1;
					this.mes = 1;
					this.ano++;
				} else {
					this.dia = 1;
					this.semana = 1;
					this.mes++;
				}
			}
		} else if (this.dia == 31) {
			if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) {
				this.dia = 1;
				this.semana = 1;
				this.mes++;
			}
		}
		
		if (diaSemana == 1) diaString = "Segunda";
		else if (diaSemana == 2) diaString = "Terça";
		else if (diaSemana == 3) diaString = "Quarta";
		else if (diaSemana == 4) diaString = "Quinta";
		else if (diaSemana == 5) diaString = "Sexta";
		else if (diaSemana == 6) diaString = "Sábado";
		else if (diaSemana == 7) diaString = "Domingo";
		
	}
	
	public int ultimoDia(int mes) {
		int ultimo = 0;
		
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			ultimo = 31;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			ultimo = 30;
		} else if (mes == 2) {
			ultimo = 28;
		}
		
		return ultimo;
	}
	
	@Override
	public String toString() {
			
		return this.diaString + " - Dia: " + this.dia + " Mês: " + this.mes + " Ano: " + this.ano;
	}
	
	//======================================= Get/Set =================================================
	
	public int getDiaSemana() {
		return diaSemana;
	}

	public int getDia() {
		return dia;
	}

	public int getSemana() {
		return semana;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}
	
}
