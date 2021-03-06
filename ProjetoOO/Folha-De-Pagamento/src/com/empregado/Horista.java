package com.empregado;

import java.util.ArrayList;

import com.folhapagamento.TratamentoExc;

public class Horista extends Empregado {
	
	public Horista(int numeroEmpregado, String nome, String endereco, int metodoPagamento, int isSindicato, int tipo, String tipoAgenda, int diaSemana) {
		super(numeroEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo, tipoAgenda, diaSemana);
	}
	
	// Salário
	private double salarioHoristaLiq = 0;
	private double salarioHorista = 0;
	private double salarioHora = 0;
	
	@Override
	public void salario() {
		System.out.print("\nInforme o salário por hora trabalhada:\nExemplo: 1,5 - 3\nR$ ");
		double salarioTemp = TratamentoExc.lerDouble();

		this.salarioHora = salarioTemp;
		
	}
	
	@Override
	public void pagarEmpregado(ArrayList<Empregado> empregado, int index) {
		this.salarioHoristaLiq = salarioHorista - getSindicato().getTaxaSindicall() - getSindicato().getValorTaxaServico();
		System.out.println(empregado.get(index).toString() + "\n");
		
		this.salarioHoristaLiq = 0;
		this.salarioHorista = 0;
	}
	
	public void cartaoPonto() {	
		
		System.out.println("\nHorário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
		int cartaoPontoE = TratamentoExc.lerInt();
		
		System.out.println("\nHorário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
		int cartaoPontoS = TratamentoExc.lerInt();
		
		// Calcula o salário
		this.salarioHorista = salarioHorista + (calculaSalario(salarioHora, cartaoPontoE, cartaoPontoS));
		
		System.out.println("\nCartão de Ponto registrado com sucesso!\n");		
	}
	
	// Calcula o salário de acordo com o cartão ponto
	public static double calculaSalario(double salarioHora, int entrada, int saida) {
		double salario;
		
		int horaTrabalhada = saida - entrada;
		float minutos = horaTrabalhada % 100;
		
		if (horaTrabalhada <= 800) {
		
			if (minutos < 10) {
				minutos = minutos / 10;
			} else {
				minutos = minutos / 100;
			}
			
			salario = ((horaTrabalhada / 100) * salarioHora) + (minutos * salarioHora);
		} else {
			int horaExtra = horaTrabalhada - 800;
			
			if (minutos < 10) {
				minutos = minutos / 10;
			} else {
				minutos = minutos / 100;
			}
			
			salario = (8 * salarioHora + ((horaExtra / 100) * (salarioHora * 1.5)) + (minutos * (horaExtra * 1.5)));
			
		}
		
		return salario;
	}
	
	//======================================= Get/Set =================================================

	
	public double getSalarioHorista() {
		return salarioHorista;
	}
	
	@Override
	public String toString() {
		String string, diaString = null;
		
		string = super.toString();
		
		string += "Tipo: Horista		Salário Hora: R$ " + this.salarioHora;
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		
		if (getDiaFrequencia() == 1) diaString = "Segunda";
		else if (getDiaFrequencia() == 2) diaString = "Terça";
		else if (getDiaFrequencia() == 3) diaString = "Quarta";
		else if (getDiaFrequencia() == 4) diaString = "Quinta";
		else if (getDiaFrequencia() == 5) diaString = "Sexta";
		else if (getDiaFrequencia() == 6) diaString = "Sábado";
		else if (getDiaFrequencia() == 7) diaString = "Domingo";
		
		string += "Agenda de Pagamento: " + this.getTipoAgenda() + "	Dia da semana: " + diaString;
		string += "\n________________________________________________________________________________________________________\n";
		
		if (getIsSindicato() == 1) {
			string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getTaxaSindicall();
			string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
		}
		
		string += "\nSalário  Bruto Acumulado -------------------------------------------------- (+) R$ " + this.salarioHorista;
		string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salarioHoristaLiq;
		
		return string;
	}

}
