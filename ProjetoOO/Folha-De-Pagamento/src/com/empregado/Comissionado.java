package com.empregado;

import java.util.ArrayList;
import java.util.Scanner;

public class Comissionado extends Empregado {
	
	Scanner input = new Scanner(System.in);
	
	public Comissionado(int numeroEmpregado, String nome, String endereco, int metodoPagamento, int isSindicato, int tipo, String tipoAgenda, int diaSemana) {
		super(numeroEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo, tipoAgenda, diaSemana);
	}
	
	
	// Salário
	private double salarioComissionadoFixo;
	private double salarioComissionadoLiq;
	private double valorComissao;
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
	
	@Override
	public void pagarEmpregado(ArrayList<Empregado> empregado, int index) {
		this.salarioComissionadoLiq = salarioComissionadoFixo + valorComissao - getSindicato().getTaxaSindicall() - getSindicato().getValorTaxaServico();
		System.out.println(empregado.get(index).toString() + "\n");
		
		this.salarioComissionadoLiq = 0;
		this.valorComissao = 0;
		
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
		
		this.valorComissao =  (valorVenda * comissao)/100;
		
		System.out.println("\n==================================================================================");
		System.out.println("Nome: " + getNome() + "		Número do empregado: " + getNumeroEmpregado());
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Data da venda: " + diaVenda + "/ " + mesVenda + "/" + anoVenda + "		Valor da comissão: R$ " + ((valorVenda * comissao)/100));
		System.out.println("==================================================================================");
		
		System.out.println("\nResultado da venda registrado com sucesso!\n");
	}

	
	//======================================= Get/Set =================================================

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
		string += "Agenda de Pagamento: " + getTipoAgenda() + "	Dia da semana: " + getDiaFrequencia();
		string += "\n_________________________________________________________________________________________________________\n";
		
		if (getIsSindicato() == 1) {
			string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getTaxaSindicall();
			string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
		}
		
		string += "\nComissão de vendas -------------------------------------------------------- (+) R$ " + this.valorComissao;
		string += "\n\nSalário Líquido  -------------------------------------------------------------- R$ " + this.salarioComissionadoLiq;
		
		return string;
	}
	
}
