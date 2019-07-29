package com.empregado;

import java.util.ArrayList;
import java.util.Scanner;

import com.empresa.Sindicato;
import com.sistema.TratamentoExc;

public abstract class Empregado {
	private int numeroEmpregado;
	private String nome;
	private String endereco;
	private int tipo;
	private int metodoPagamento;
	private int isSindicato = 0;
	
	// Agenda
	private String tipoAgenda;
	private int diaFrequencia;

	Sindicato sindicato = new Sindicato();
	
	static Scanner input = new Scanner(System.in);
	
	public Empregado(int numeroEmpregado, String nome, String endereco, int metodoPagamento, int isSindicato, int tipo, String tipoAgenda, int diaSemana) {
		this.numeroEmpregado = numeroEmpregado;
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
		this.metodoPagamento = metodoPagamento;
		this.isSindicato = isSindicato;
		this.tipoAgenda = tipoAgenda;
		this.diaFrequencia = diaSemana;
	}
	
	public void alterarDetalhes(int opcao) {
		switch(opcao) {
		case 1:
			System.out.println("Digite o nome do empregado:");
			 String nome = input.nextLine();
			
			 setNome(nome);
			 
			 System.out.println("\nNome do empregado alterado com sucesso!\n");
			 
			break;
		
		case 2:
			 System.out.println("\nDigite o endereço do empregado:");
			 String endereco = input.nextLine();
			
			 setEndereco(endereco);
			 
			 System.out.println("\nEndereço do empregado alterado com sucesso!\n");
			 
			break;
		
		case 3:
			System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
			int metodoPagamento = TratamentoExc.lerInt();
			 
			setMetodoPagamento(metodoPagamento);
			
			System.out.println("\nMétodo de pagamento do empregado alterado com sucesso!\n");
			
			break;
		
		case 4:
			System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
			int isSindicato = TratamentoExc.lerInt();
			
			setIsSindicato(isSindicato);
			
			if (isSindicato == 1) {
			  System.out.print("Digite o valor da taxa sindical:\nR$ ");
			  double taxaSindical = TratamentoExc.lerDouble();
			  
			  sindicato.setNumeroSindicato(getNumeroEmpregado());
			  sindicato.setTaxaSindical(taxaSindical);
			  
			  setNumeroEmpregado(getNumeroEmpregado() + 1);
			}
			
			System.out.println("\nSindicato do empregado alterado com sucesso!\n");
			
			break;
		}
	}
	
	
	public abstract void salario();
	public abstract void pagarEmpregado(ArrayList<Empregado> empregado, int index);

	
	//======================================= Get/Set =================================================
	
	public int getNumeroEmpregado() {
		return this.numeroEmpregado;
	}
	
	public void setNumeroEmpregado(int numeroEmpregado) {
		this.numeroEmpregado = numeroEmpregado;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	public int getMetodoPagamento() {
		return this.metodoPagamento;
	}
	
	public void setMetodoPagamento(int metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	
	public int getIsSindicato() {
		return this.isSindicato;
	}
	
	public void setIsSindicato(int isSindicato) {
		this.isSindicato = isSindicato;
	}
	
	
	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}
	
	@Override
	public String toString() {
		String string;
		
		string = "Número Empregado: " + this.numeroEmpregado + "		Nome: " + this.nome;
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		string += "Endereço: " + this.endereco;
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		
		if (this.metodoPagamento == 1) {
			string += "Método de Pagamento: Cheque pelos correios";
		} else if (this.metodoPagamento == 2) {
			string += "Método de Pagamento: Cheque em mãos";
		} else if (this.metodoPagamento == 3) {
			string += "Método de Pagamento: Depósito em conta bancária";
		}
		
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		
		if (isSindicato == 1) {
			string += "Sindicado: Pertence		Número do Sindicato: " + this.sindicato.getNumeroSindicato() + "		Taxa Sindical: R$ " + this.sindicato.getTaxaSindicall();
		} else {
			string += "Sindicado: Não Pertence";
		}
		
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		
		return string;
	}

	public String getTipoAgenda() {
		return tipoAgenda;
	}

	public void setTipoAgenda(String tipoAgenda) {
		this.tipoAgenda = tipoAgenda;
	}

	public int getDiaFrequencia() {
		return diaFrequencia;
	}

	public void setDiaFrequencia(int diaFrequencia) {
		this.diaFrequencia = diaFrequencia;
	}
	
}