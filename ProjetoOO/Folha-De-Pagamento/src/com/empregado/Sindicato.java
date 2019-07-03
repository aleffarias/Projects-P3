package com.empregado;

import java.util.Scanner;

import com.folhapagamento.TratamentoExc;

public class Sindicato {
	
	Scanner input = new Scanner(System.in);
	
	private int numeroSindicato;
	private double taxaSindical= 0;
	private double valorTaxaServico = 0; 
	
	public void taxaServico() {
		System.out.print("\nDigite o serviço adicional prestado pelo sindicato:\n");
		String servicoPrestado = input.nextLine();
		
		System.out.println("\nValor da taxa de serviço:\nR$");
		double valor = TratamentoExc.lerDouble();
		
		this.valorTaxaServico = valorTaxaServico + valor;
		
		System.out.println("\n============================Registro de Serviço=================================");
		System.out.println("Número do sindicato: " + numeroSindicato);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Serviço: " + servicoPrestado + "		Valor do serviço: R$ " + valor);
		System.out.println("==================================================================================");
		
		System.out.println("\nTaxa de serviço registrada com sucesso!\n");
		
	}
	
	//======================================= Get/Set =================================================
	
	public int getNumeroSindicato() {
		return numeroSindicato;
	}

	public void setNumeroSindicato(int numeroSindicato) {
		this.numeroSindicato = numeroSindicato;
	}

	public double getTaxaSindicall() {
		return taxaSindical;
	}

	public void setTaxaSindical(double taxaMensal) {
		this.taxaSindical = taxaMensal;
	}

	public double getValorTaxaServico() {
		return valorTaxaServico;
	}
	
}
