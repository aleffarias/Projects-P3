package com.empregado;

import java.util.Scanner;

public class Comissionado extends Empregado {
	
	Scanner input = new Scanner(System.in);
	
	public Comissionado(int numeroEmpregado, String nome, String endereco, int metodoPagamento, int isSindicato, int tipo) {
		super(numeroEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo);
	}
	
	
	// Agenda Padrão
	private int frequencia = 2;
	private int diaSemana = 5;
	private String agenda = "Semanal - Padrão" + "	 Frequência: A cada " + this.frequencia + " semana(s)" + "	 Dia da semana: " + this.diaSemana;
	
	
	// Salário
	private double salarioComissionadoFixo;
	private double salarioComissionadoLiq;
	private double comissao;
	
	@Override
	public void salario() {
		System.out.print("\nInforme o salário:\nExemplo: 1500 - 3000.56\nR$ ");
		double salarioTemp = input.nextDouble();
		input.nextLine();
		
		System.out.println("\nInforme o percentual de comissão:\nExemplo: 15 para 15% 1.5 para 1.5%");
		this.comissao = input.nextDouble();
		input.nextLine();
		
		this.salarioComissionadoFixo = salarioTemp;
		
	}
	
	public void resultadoVenda() {
		System.out.println("\nDia da venda:");
		int diaVenda = input.nextInt();
		
		System.out.println("\nMês da venda:");
		int mesVenda = input.nextInt();
		
		System.out.println("\nAno da venda:");
		int anoVenda = input.nextInt();
		
		System.out.print("\nValor da venda:\nExemplo: 1500 - 3000.56\nR$ "); 
		double valorVenda = input.nextDouble();
		
		this.salarioComissionadoLiq = salarioComissionadoFixo + ((valorVenda * comissao)/100);
		
		System.out.println("\n==================================================================================");
		System.out.println("Nome: " + getNome() + "		Número do empregado: " + getNumeroEmpregado());
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Data da venda: " + diaVenda + "/ " + mesVenda + "/" + anoVenda + "		Valor da comissão: R$ " + ((valorVenda * comissao)/100));
		System.out.println("==================================================================================");
		
		System.out.println("\nResultado da venda registrado com sucesso!\n");
	}
	
	//======================================= Get/Set =================================================
	
	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public double getSalarioComissionadoFixo() {
		return salarioComissionadoFixo;
	}

	public double getSalarioComissionadoCom() {
		return salarioComissionadoLiq;
	}

	public double getComissao() {
		return comissao;
	}
	
	@Override
	public String toString() {
		String string;
		
		string = super.toString();
		
		string += "Tipo: Comissionado		Salário Bruto: R$ " + this.salarioComissionadoFixo + "	Comissão: " + this.comissao + "%";
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		string += "Agenda de Pagamento: " + this.agenda;
		string += "\n_________________________________________________________________________________________________________\n";
		string += "Salário Líquido: R$ " + this.salarioComissionadoLiq;
		
		return string;
	}

	
}
