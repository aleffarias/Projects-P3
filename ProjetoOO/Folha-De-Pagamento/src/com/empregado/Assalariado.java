package com.empregado;

import java.util.Scanner;

public class Assalariado extends Empregado {
	
	Scanner input = new Scanner(System.in);
	
	// Construtor 
	public Assalariado(int numeroEmpregado, String nome, String endereco, int metodoPagamento, int isSindicato, int tipo) {
		super(numeroEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo);
	}
	
	// Agenda Padrão
	private int dia = 30;
	private String agenda = "Mensal - Padrão" + "	Dia: " + this.dia;
	
	// Salário
	private double salarioAssalariadoFixo;
	private double salarioAssalariadoLiq;
	
	@Override
	public void salario() {
		System.out.print("\nInforme o salário fixo mensal:\nExemplo: 1500 - 3000.56\nR$ ");
		double salarioTemp = input.nextDouble();
		input.nextLine();
		
		this.salarioAssalariadoFixo = salarioTemp;
		
	}
	
	//======================================= Get/Set =================================================
	
	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public double getSalarioAssalariadoFixo() {
		return salarioAssalariadoFixo;
	}

	public double getSalarioAssalariadoLiq() {
		return salarioAssalariadoLiq;
	}
	
	@Override
	public String toString() {
		String string;
		
		string = super.toString();
		
		string += "Tipo: Assalariado		Salário Bruto: R$ " + this.salarioAssalariadoFixo;
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		string += "Agenda de Pagamento: " + this.agenda;
		string += "\n________________________________________________________________________________________________________\n";
		string += "Salário Líquido: R$ " + this.salarioAssalariadoLiq;
		
		return string;
	}

}
