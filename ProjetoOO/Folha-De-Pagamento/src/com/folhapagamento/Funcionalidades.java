package com.folhapagamento;

import java.util.ArrayList;
import java.util.Scanner;

import com.empregado.Assalariado;
import com.empregado.Comissionado;
import com.empregado.Empregado;
import com.empregado.Horista;

public class Funcionalidades {
	  static Scanner input = new Scanner(System.in);
	  
	  private static int numEmpregado = 1, numeroSindicato = 1;
	  private static double taxaSindical = 0;
	  
	  static ArrayList<Empregado> listaEmpregados = new ArrayList<Empregado>();
	  Agenda agenda = new Agenda();
	  
	  public void addEmpregado() {
		  System.out.println("\n**  ADICIONAR EMPREGADO  **\n");
		  
		  System.out.println("Digite o nome do empregado:");
		  String nome = input.nextLine();
		  
		  System.out.println("\nDigite o endereço do empregado:");
		  String endereco = input.nextLine();
		  
		  System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
		  int metodoPagamento = input.nextInt();
		  input.nextLine();
		  
		  System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
		  int isSindicato = input.nextInt();
		  input.nextLine();
		  
		  if (isSindicato == 1) {
			  System.out.print("Digite o valor da taxa sindical:\nR$ ");
			  taxaSindical = input.nextDouble();
			  input.nextLine();
		  }
		  
		  System.out.println("\nEscolha o tipo do empregado:\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
		  int tipo = input.nextInt();
		  input.nextLine();
		  
		  if (tipo == 1) {
			  
			  Horista horista = new Horista(numEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo);
			 
			  horista.salario();
			  
			  if (isSindicato == 1) {
				  horista.getSindicato().setNumeroSindicato(numeroSindicato);
				  horista.getSindicato().setTaxaSindical(taxaSindical);
				  numeroSindicato++;
			  }
			  
			  listaEmpregados.add(horista);
			  
		  } else if (tipo == 2) {
			  Assalariado assalariado = new Assalariado(numEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo);
			  
			  assalariado.salario();
			  
			  if (isSindicato == 1) {
				  assalariado.getSindicato().setNumeroSindicato(numeroSindicato);
				  assalariado.getSindicato().setTaxaSindical(taxaSindical);
				  numeroSindicato++;
			  }
			  
			  listaEmpregados.add(assalariado);
			  
		  } else if (tipo == 3) {
			  Comissionado comissionado = new Comissionado(numEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo);
			  
			  comissionado.salario();
			  
			  if (isSindicato == 1) {
				  comissionado.getSindicato().setNumeroSindicato(numeroSindicato);
				  comissionado.getSindicato().setTaxaSindical(taxaSindical);
				  numeroSindicato++;
			  }
			  
			  listaEmpregados.add(comissionado);
			  
		  } else {
			  System.out.println("\nErro: Opção Inválida.\\n");
		  }	
		  
		 System.out.println("\nEmpregado cadastrado com sucesso!\n");
		 numEmpregado++;
		
	  }
	  
	  
	public void removerEmpregado() {
		System.out.println("\n\t**  	REMOVER FUNCIONÁRIO  	**\n");
		  
		System.out.println("Digite o número do Empregado:\n");
		int nEmpTemp = input.nextInt();
		input.nextLine();
		  
		int index = agenda.searchEmpregado(listaEmpregados, nEmpTemp);
		if (index == -1) return;
		
		System.out.println("\nRemovendo empregado...");
		  
		listaEmpregados.remove(index);
					
		System.out.println("\nEmpregado removido com sucesso!\n");	
				
	  }
	 
	public void lancarCartaoPonto() {
		System.out.println("\n**  	LANÇAR CARTÃO DE PONTO  	**\n");	
		System.out.println("Digite o número do Empregado:");
		int nEmpTemp = input.nextInt();
		input.nextLine();
		
		int index = agenda.searchEmpregado(listaEmpregados, nEmpTemp);
		
		
		try {
			if (index == -1) return;
			
			Horista horista = (Horista) listaEmpregados.get(index);	 
			horista.cartaoPonto();
			
		} catch (Exception e) {
			System.out.println("\nErro: Empregado não é horista.\n");
		} 	 
		 
	 }
	 
	public void lancarResultadoVenda() {
		System.out.println("\n**  	LANÇAR RESULTADO DE VENDA  		**\n");
		System.out.println("Digite o número do Empregado:");
		int nEmpTemp = input.nextInt();
		input.nextLine();
		 
		int index = agenda.searchEmpregado(listaEmpregados, nEmpTemp);
			
		try {
			if (index == -1) return;
			
			Comissionado comissionado = (Comissionado) listaEmpregados.get(index);
			comissionado.resultadoVenda();
			
		} catch (Exception e) {
			System.out.println("\nErro: Empregado não é comissionado.\n");
		}	 
	 }
	 
	public void lancarTaxaServico() {
		System.out.println("\n**  	LANÇAR TAXA DE SERVIÇO  	**\n");
		System.out.println("Digite o número do Empregado:");
		int nEmpTemp = input.nextInt();
		input.nextLine();
		
		int index = agenda.searchEmpregado(listaEmpregados, nEmpTemp);
		if (index == -1) return;
		
		if (listaEmpregados.get(index).getIsSindicato() == 1) {				
			listaEmpregados.get(index).getSindicato().taxaServico();
			 
		} else {
			System.out.println("\nErro: Empregado não pertence ao sindicato.\n");
		}
			 	 
	}
	 
	public void alterarDetalhe() {
		System.out.println("\n**  	ALTERAR DETALHES DO EMPREGADO  	**\n");
		System.out.println("Digite o número do Funcionário:");
		int nEmpTemp = input.nextInt();
		input.nextLine();
		
		int index = agenda.searchEmpregado(listaEmpregados, nEmpTemp);
		if (index == -1) return;
		
		System.out.println("Escolha uma opção:");
		System.out.println("(1) - Alterar Nome");
		System.out.println("(2) - Alterar Endereço");
		System.out.println("(3) - Alterar Método de Pagamento");
		System.out.println("(4) - Alterar Sindicato");
		System.out.println("(5) - Alterar Tipo");
				
		int opcao = input.nextInt();
		input.nextLine();
				
		if (opcao <=4 & opcao > 0) {		
			listaEmpregados.get(index).alterarDetalhes(opcao);
				
		} else if(opcao == 5) {
			EditarDetalhes.alterarTipo(listaEmpregados, index);	
			  
		} else {
			System.out.println("\nErro: Opção Inválida.\n");
		}		
		
	}
	
	public void rodarFolha() {
		System.out.println("\n**  	RODAR A FOLHA DE PAGAMENTO  	**\n");
		System.out.println("Verificando Empregados...");
		
		
		
	}
	
	public void agendaPagamento() {
		System.out.println("\n**  				AGENDA DE PAGAMENTO 				**\n");
		
		agenda.consultaAgenda(listaEmpregados);
		
	}
	
	public void novaAgenda() {
		System.out.println("\n**  	CRIAR AGENDA DE PAGAMENTO 	**\n");
		System.out.println("\n**  	ALTERAR DETALHES DO EMPREGADO  	**\n");
		System.out.println("Digite o número do Funcionário:");
		int nEmpTemp = input.nextInt();
		input.nextLine();
		
		int index = agenda.searchEmpregado(listaEmpregados, nEmpTemp);
		if (index == -1) return;
		
		agenda.novaAgenda(listaEmpregados, index);
		
	}
	
	
	//======================================= Get/Set =================================================
	
	public int getNumeroSindicato() {
		return numeroSindicato;
	}

	public void setNumeroSindicato(int numeroSindicato) {
		Funcionalidades.numeroSindicato = numeroSindicato;
	}
	 
}
