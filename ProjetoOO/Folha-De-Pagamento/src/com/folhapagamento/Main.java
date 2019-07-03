package com.folhapagamento;

import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);
	static Calendario calendario = new Calendario();

	public static void main(String[] args) {
		
		int opcao;
		
		Funcionalidades funcionalidades = new Funcionalidades();
		
		while (true) {
			
			int dia = calendario.getDia();
			int diaSemana = calendario.getDiaSemana();
			
			menu();
			
			opcao = input.nextInt();
			input.nextLine();
			
			switch(opcao) {
			case 1:
				funcionalidades.addEmpregado();
				break;
				
			case 2:
				funcionalidades.removerEmpregado();
				break;
				
			case 3:
				funcionalidades.lancarCartaoPonto();
				break;
				
			case 4:
				funcionalidades.lancarResultadoVenda();
				break;
			
			case 5:
				funcionalidades.lancarTaxaServico();
				break;
			
			case 6:	
				funcionalidades.alterarDetalhe();
				break;
			
			case 7:
				funcionalidades.rodarFolha(dia, diaSemana);
				calendario.avancarDia();
				break;
			case 8:
				
				break;
			
			case 9:
				funcionalidades.agendaPagamento();
				break;
			case 0:
				System.exit(0);
			
			default:
				System.out.println("\nErro: Opção Inválida.\n");
			}
			
		}
	}
	
	public static void menu() {
		System.out.println("=============================== FOLHA DE PAGAMENTO =====================================");
		
		System.out.println(calendario.toString());
		
		System.out.println("\nEscolha uma opção:");
		System.out.println("(1) - Adicionar Empregado");
		System.out.println("(2) - Remover Empregado");
		System.out.println("(3) - Lançar um Cartão de Ponto");
		System.out.println("(4) - Lançar um Resultado Venda");
		System.out.println("(5) - Lançar uma Taxa de Serviço");
		System.out.println("(6) - Alterar Detalhes de um Empregado");
		System.out.println("(7) - Rodar a Folha de Pagamento para Hoje (após rodar, avança 1 dia)");
		System.out.println("(8) - Undo/redo");
		System.out.println("(9) - Agenda de Pagamento");
		System.out.println("(10) - Criação de Novas Agendas de Pagamento");
		System.out.println("(0) - Sair");
	}
	
}
