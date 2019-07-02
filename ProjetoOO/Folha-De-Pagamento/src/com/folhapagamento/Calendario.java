package com.folhapagamento;

public class Calendario {
	private int diaSemana = 1;
	private int dia = 1;
	private int semana = 1;
	private int mes = 1;
	private int ano = 2019;
	
	public void avancarDia() {
		this.dia++;
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
	}
	
	@Override
	public String toString() {
		return "Dia: " + this.dia + " Mês: " + this.mes + " Ano: " + this.ano;
	}
	
	//======================================= Get/Set =================================================
	
	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
