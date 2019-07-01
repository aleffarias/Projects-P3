package folhapagamento;

import java.util.Scanner;

public class Main {

	private static Scanner input;
	
	private static int diaSemana = 1, semana = 1, dia = 1, mes = 1, ano = 2019;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		
		int opcao;
		
		while (true) {
			
			menu();
			
			opcao = input.nextInt();
			input.nextLine();
			
			switch(opcao) {
			case 1:
				Funcionalidades.addEmpregado();
				break;
				
			case 2:
				Funcionalidades.removerEmpregado();
				break;
				
			case 3:
				Funcionalidades.lancarCartaoPonto();
				break;
				
			case 4:
				Funcionalidades.lancarResultadoVenda();
				break;
			
			case 5:
				Funcionalidades.lancarTaxaServico();
				break;
			
			case 6:	
				Funcionalidades.alterarDetalhe();
				break;
			
			case 7:
				
				break;
			case 8:
				
				break;
			
			case 9:
				Funcionalidades.agendaPagamento();
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
		data(diaSemana, semana, dia, mes, ano);
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
	
	public static void data(int diaSemana, int semana, int dia, int mes, int ano) {
		
		if (diaSemana == 8) {
			semana++;
			diaSemana = 1;
		}
		
		if (dia == 31 && mes != 12) {
			dia = 1;
			semana = 1;
			mes++;
		}
		
		if (dia == 31 && mes == 12) {
			dia = 1;
			mes = 1;
			ano++;
		}
		
		System.out.println("Dia: " + dia + " Mês: " + mes + " Ano: " + ano);
	}
}
