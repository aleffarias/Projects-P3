package folhapagamento;

import java.util.ArrayList;
import java.util.Scanner;

import folhapagamento.empregado.Assalariado;
import folhapagamento.empregado.Comissionado;
import folhapagamento.empregado.Empregado;
import folhapagamento.empregado.Horista;

public class Funcionalidades {
	  static Scanner input = new Scanner(System.in);
	  
	  private static int numEmpregado = 1, numeroSindicato = 1;
	  private static double taxaSindical = 0;
	  
	  static ArrayList<Empregado> listaEmpregados = new ArrayList<Empregado>();
	  
	  public static void addEmpregado() {
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
		 
		 teste();
		  
		 System.out.println("\nEmpregado cadastrado com sucesso!\n");
		 numEmpregado++;
		
	  }
	  
	// Teste
	 public static void teste() {
		 System.out.println(listaEmpregados.get(0).toString());
		  }
	  
	public static void removerEmpregado() {
		  System.out.println("\n\t**  	REMOVER FUNCIONÁRIO  	**\n");
		  
		  System.out.println("Digite o número do Empregado:\n");
		  int nEmpTemp = input.nextInt();
		  input.nextLine();
		  
		  System.out.println("\nRemovendo empregado...");
		  
		  for (int i=0; i < listaEmpregados.size(); i++) {
				if (listaEmpregados.get(i).getNumeroEmpregado() == nEmpTemp) {
					listaEmpregados.remove(i);
					
					System.out.println("\nEmpregado removido com sucesso!\n");	
					return;
				}
			} 
		  
		  System.out.println("\nErro: Empregado não encontrado.\n");	
	  }
	 
	public static void lancarCartaoPonto() {
		 System.out.println("\n**  	LANÇAR CARTÃO DE PONTO  	**\n");	
		 System.out.println("Digite o número do Empregado:");
		 int nEmpTemp = input.nextInt();
		 input.nextLine();
		 
		 for (int i=0; i < listaEmpregados.size(); i++) {
			 if (listaEmpregados.get(i).getNumeroEmpregado() == nEmpTemp) {		// Procura o empregado solicitado
				 if (listaEmpregados.get(i) instanceof Horista) {				// Verifica se é horista
					 Horista horista = (Horista) listaEmpregados.get(i);
					 
					 horista.cartaoPonto();
					 return;
					 
				 } else {
					 System.out.println("\nErro: Empregado não é horista.\n");
				 }
			 }
		 }
		 
	 }
	 
	public static void lancarResultadoVenda() {
		 System.out.println("\n**  	LANÇAR RESULTADO DE VENDA  		**\n");
		 System.out.println("Digite o número do Empregado:");
		 int nEmpTemp = input.nextInt();
		 input.nextLine();
		 
		 for (int i=0; i < listaEmpregados.size(); i++) {
			 System.out.println("Entrou");
			 if (listaEmpregados.get(i).getNumeroEmpregado() == nEmpTemp) {			// Procura o empregado solicitado
				 if (listaEmpregados.get(i) instanceof Comissionado) {				// Verifica se é comissionado
					 Comissionado comissionado = (Comissionado) listaEmpregados.get(i);
					 
					 comissionado.resultadoVenda();
					 return;
					 
				 } else {
					 System.out.println("\nErro: Empregado não é comissionado.\n");
				 }
			 }
		 }
	
	 }
	 
	public static void lancarTaxaServico() {
		System.out.println("\n**  	LANÇAR TAXA DE SERVIÇO  	**\n");
		System.out.println("Digite o número do Empregado:");
		int nEmpTemp = input.nextInt();
		input.nextLine();
		
		for (int i=0; i < listaEmpregados.size(); i++) {
			 if (listaEmpregados.get(i).getNumeroEmpregado() == nEmpTemp) {			// Procura o empregado solicitado
				 if (listaEmpregados.get(i).getIsSindicato() == 1) {				// Verifica se pertence ao sindicato
					 listaEmpregados.get(i).getSindicato().taxaServico();
					 // Descontar taxa no dia do pagamento
					 
				 } else {
					 System.out.println("\nErro: Empregado não pertence ao sindicato.\n");
				 }
			 }
		 }
	}
	 
	public static void alterarDetalhe() {
		System.out.println("\n**  	ALTERAR DETALHES DO EMPREGADO  	**\n");
		System.out.println("Digite o número do Funcionário:");
		int nEmpTemp = input.nextInt();
		input.nextLine();
		
		for (int i=0; i < listaEmpregados.size(); i++) {
			if (listaEmpregados.get(i).getNumeroEmpregado() == nEmpTemp) {
				System.out.println("Escolha uma opção:");
				System.out.println("(1) - Alterar Nome");
				System.out.println("(2) - Alterar Endereço");
				System.out.println("(3) - Alterar Método de Pagamento");
				System.out.println("(4) - Alterar Sindicato");
				System.out.println("(5) - Alterar Tipo");
				
				int opcao = input.nextInt();
				input.nextLine();
				
				if (opcao <=4 & opcao > 0) {		
					listaEmpregados.get(i).alterarDetalhes(opcao);
					
				} else if(opcao == 5) {
					
					System.out.println("\nEscolha o tipo do empregado:\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
					  int tipo = input.nextInt();
					  input.nextLine();
					  
					  if (tipo == 1) {
						  Horista horista = new Horista(listaEmpregados.get(i).getNumeroEmpregado(), listaEmpregados.get(i).getNome(), 
								  listaEmpregados.get(i).getEndereco(), listaEmpregados.get(i).getMetodoPagamento(), listaEmpregados.get(i).getIsSindicato(), tipo);
						 			  
						  horista.salario();
						  
						  if (listaEmpregados.get(i).getIsSindicato() == 1) {
							  horista.getSindicato().setNumeroSindicato(listaEmpregados.get(i).getSindicato().getNumeroSindicato());
							  horista.getSindicato().setTaxaSindical(listaEmpregados.get(i).getSindicato().getTaxaSindicall());
						  }
						  
						  listaEmpregados.add(i, horista);
						  listaEmpregados.remove(i);
						  
					  } else if (tipo == 2) {
						  Assalariado assalariado = new Assalariado(listaEmpregados.get(i).getNumeroEmpregado(), listaEmpregados.get(i).getNome(), 
								  listaEmpregados.get(i).getEndereco(), listaEmpregados.get(i).getMetodoPagamento(), listaEmpregados.get(i).getIsSindicato(), tipo);
						  
						  assalariado.salario();
						  
						  if (listaEmpregados.get(i).getIsSindicato() == 1) {
							  assalariado.getSindicato().setNumeroSindicato(listaEmpregados.get(i).getSindicato().getNumeroSindicato());
							  assalariado.getSindicato().setTaxaSindical(listaEmpregados.get(i).getSindicato().getTaxaSindicall());
						  }
						  
						  listaEmpregados.add(assalariado);
						  listaEmpregados.remove(i);
						  
					  } else if (tipo == 3) {
						  Comissionado comissionado = new Comissionado(listaEmpregados.get(i).getNumeroEmpregado(), listaEmpregados.get(i).getNome(), 
								  listaEmpregados.get(i).getEndereco(), listaEmpregados.get(i).getMetodoPagamento(), listaEmpregados.get(i).getIsSindicato(), tipo);
						  
						  comissionado.salario();
						  
						  if (listaEmpregados.get(i).getIsSindicato() == 1) {
							  comissionado.getSindicato().setNumeroSindicato(listaEmpregados.get(i).getSindicato().getNumeroSindicato());
							  comissionado.getSindicato().setTaxaSindical(listaEmpregados.get(i).getSindicato().getTaxaSindicall());
						  }
						  
						  listaEmpregados.add(i, comissionado);
						  listaEmpregados.remove(i);
					  }
					  
					  System.out.println("\nTipo do empregado alterado com sucesso!\n");
					  
					  return;
					  
				} else {
					System.out.println("\nErro: Opção Inválida.\n");
				}
				
			}
		}		
		
	}
	
	public static void rodarFolha() {
		System.out.println("\n**  	RODAR A FOLHA DE PAGAMENTO  	**\n");
		System.out.println("Verificando Empregados...");
		
		
	}
	
	public static void agendaPagamento() {
		System.out.println("\n**  				AGENDA DE PAGAMENTO 				**\n");
		
		// Agenda Padrão
		System.out.println("\nEMPREGADOS PAGOS SEMANALMENTE\n");
		for (int i=0; i < listaEmpregados.size(); i++) {
			if (listaEmpregados.get(i) instanceof Horista) {
				System.out.println(listaEmpregados.get(0).toString() + "\n");
			}
		}
		
		System.out.println("\nEMPREGADOS PAGOS BI-SEMANALMENTE\n");
		for (int i=0; i < listaEmpregados.size(); i++) {
			if (listaEmpregados.get(i) instanceof Comissionado) {
				System.out.println(listaEmpregados.get(0).toString() + "\n");
			}
		}
		
		System.out.println("\nEMPREGADOS PAGOS MENSALMENTE\n");		
		for (int i=0; i < listaEmpregados.size(); i++) {
			if (listaEmpregados.get(i) instanceof Assalariado) {
				System.out.println(listaEmpregados.get(0).toString() + "\n");
			}
		}
		
	}
	
	
	//======================================= Get/Set =================================================
	
	public static int getNumeroSindicato() {
		return numeroSindicato;
	}

	public static void setNumeroSindicato(int numeroSindicato) {
		Funcionalidades.numeroSindicato = numeroSindicato;
	}
	 
}
